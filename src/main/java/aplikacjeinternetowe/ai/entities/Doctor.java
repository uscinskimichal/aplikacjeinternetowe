package aplikacjeinternetowe.ai.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Doctor;

    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;
    private String phoneNumber;

    @OneToMany(mappedBy = "doctor")
    private Set<Form> forms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_institution")
    private Institution institution;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "doctor_specialization",
            joinColumns = {@JoinColumn(name = "id_specialization")},
            inverseJoinColumns = {@JoinColumn(name = "id_doctor")}
    )
    Set<Specialization> specializations;
}
