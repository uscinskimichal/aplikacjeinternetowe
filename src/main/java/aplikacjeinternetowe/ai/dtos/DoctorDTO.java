package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorDTO {
    private Integer ID_Doctor;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phoneNumber;
    private InstitutionDTO institution;
    private List<SpecializationDTO> specializations;
}
