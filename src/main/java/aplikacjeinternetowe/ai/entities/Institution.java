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
    private BigDecimal xCoordinates;
    private BigDecimal yCoordinates;


    @OneToMany(mappedBy = "institution")
    private Set<Doctor> doctors;
}
