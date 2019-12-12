package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class InstitutionDTO {
    private Integer ID_Institution;
    private String name;
    private String phoneNumber;
    private BigDecimal xCoordinates;
    private BigDecimal yCoordinates;
    private String description;
    private List<SpecializationDTO> institute_specializations;
}
