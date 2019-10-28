package aplikacjeinternetowe.ai.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Specialization;

    private String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "doctor_specialization",
            joinColumns = @JoinColumn(name = "id_specialization"),
            inverseJoinColumns = @JoinColumn(name = "id_doctor"))
    private Set<Doctor> doctors;


}
