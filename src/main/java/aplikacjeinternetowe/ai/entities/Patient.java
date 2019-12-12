package aplikacjeinternetowe.ai.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@DynamicUpdate
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Patient;

    private String name;
    private String surname;
    private String password;

    @Column(unique = true)
    private String email;

    private String phoneNumber;
    private Character sex;

    @Column(unique = true)
    private String pesel;

    @OneToMany(mappedBy = "patient")
    private Set<Form> forms;

}
