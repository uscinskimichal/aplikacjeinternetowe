package aplikacjeinternetowe.ai.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Form;

    private String subject;
    private String message;
    private String comment;
    private String status;
    private LocalDateTime date;
    private int doctor_active_flag;
    private int patient_active_flag;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient" , nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;
}
