package aplikacjeinternetowe.ai.dtos;

import lombok.Data;

@Data
public class PatientDTO {

    private Integer ID_Patient;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;
    private String phoneNumber;
    private Character sex;
    private String pesel;


}
