package aplikacjeinternetowe.ai.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
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
