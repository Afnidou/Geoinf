package ma.ehtp.gestiondeslaureats.RestControllers;



import ma.ehtp.gestiondeslaureats.authentication.payload.request.LoginRequest;
import ma.ehtp.gestiondeslaureats.authentication.payload.request.SignupRequest;
import ma.ehtp.gestiondeslaureats.authentication.payload.response.JwtResponse;
import ma.ehtp.gestiondeslaureats.authentication.payload.response.MessageResponse;
import ma.ehtp.gestiondeslaureats.authentication.security.jwt.JwtUtils;
import ma.ehtp.gestiondeslaureats.authentication.security.services.UserDetailsImpl;
import ma.ehtp.gestiondeslaureats.repositories.RoleRepository;
import ma.ehtp.gestiondeslaureats.repositories.UserRepository;
import ma.ehtp.gestiondeslaureats.roles.ERole;
import ma.ehtp.gestiondeslaureats.roles.Role;
import ma.ehtp.gestiondeslaureats.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired  AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;


	@Autowired  PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPassword()),
									 signUpRequest.getPhone(),
									 signUpRequest.getEmail());

		String givenrole = signUpRequest.getRole();
		Role role;


		if (givenrole == null) {
			Role employeurRole = roleRepository.findByName(ERole.ROLE_LAUREAT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			role = employeurRole;
		} else {

				switch (givenrole) {
				case "laureat":
					Role laureatRole = roleRepository.findByName(ERole.ROLE_LAUREAT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					role = laureatRole;
					user.setRole(role);
					userRepository.save(user);
					break;

				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					role = adminRole;
					user.setRole(role);
					userRepository.save(user);
					break;

				default:
					Role laureatRole1 = roleRepository.findByName(ERole.ROLE_LAUREAT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					role = laureatRole1;
					user.setRole(role);
					userRepository.save(user);

				}

		}


		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
