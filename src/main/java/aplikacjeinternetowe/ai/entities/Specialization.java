package aplikacjeinternetowe.ai.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Specialization;

    private String name;

    @ManyToMany(mappedBy = "specializations")
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "institute_specializations")
    private Set<Institution> institutions;

}
