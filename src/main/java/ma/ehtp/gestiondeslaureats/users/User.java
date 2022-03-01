package ma.ehtp.gestiondeslaureats.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ehtp.gestiondeslaureats.roles.Role;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String telephone;

    @NotBlank
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    private Role role;



    public User(String username, String password, String telephone,String email) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
    }

}
