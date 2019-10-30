package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDTO {
    private Integer ID_Administrator;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;
}
