package aplikacjeinternetowe.ai.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FormDTO {

    private Integer ID_Form;
    private String subject;
    private String message;
    private String comment;
    private String status;
    private LocalDateTime date;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private int doctor_active_flag;
    private int patient_active_flag;
}
