package aplikacjeinternetowe.ai.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "doctor_specialization",
            inverseJoinColumns  = {@JoinColumn(name = "id_specialization")},
            joinColumns = {@JoinColumn(name = "id_doctor")}
    )
    Set<Specialization> specializations;
}
