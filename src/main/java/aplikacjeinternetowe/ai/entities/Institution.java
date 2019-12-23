package aplikacjeinternetowe.ai.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Institution;

    private String name;
    private String phoneNumber;
    @Column(scale = 3 , precision = 5)
    private BigDecimal xCoordinates;
    @Column(scale = 3 , precision = 5)
    private BigDecimal yCoordinates;
    private String description;


    @OneToMany(mappedBy = "institution")
    private Set<Doctor> doctors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "institution_specialization",
            inverseJoinColumns  = {@JoinColumn(name = "id_specialization")},
            joinColumns = {@JoinColumn(name = "id_institution")}
    )
    Set<Specialization> institute_specializations;
}
