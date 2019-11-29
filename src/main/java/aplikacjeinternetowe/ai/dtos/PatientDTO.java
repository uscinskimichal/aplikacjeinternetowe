package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDTO {

    private Integer ID_Patient;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phoneNumber;
    private Character sex;
    private String pesel;
}
