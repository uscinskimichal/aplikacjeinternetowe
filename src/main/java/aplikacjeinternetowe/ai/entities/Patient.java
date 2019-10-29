package aplikacjeinternetowe.ai.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Patient;

    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;
    private String phoneNumber;
    private Character sex;
    private String pesel;

    @OneToMany(mappedBy = "patient")
    private Set<Form> forms;

}
