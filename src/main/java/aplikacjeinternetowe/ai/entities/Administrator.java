package aplikacjeinternetowe.ai.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Administrator;

    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;
}
