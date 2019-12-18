package aplikacjeinternetowe.ai.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
public class PatientDTO {

    private Integer ID_Patient;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phoneNumber;
    private String sex;
    private String pesel;
}
