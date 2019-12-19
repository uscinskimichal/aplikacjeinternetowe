package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    List<PatientDTO> getAllPatients();
    PatientDTO getPatient(Integer patientId);

    String addPatient(PatientDTO patientDTO);

    boolean editPatient(PatientDTO patientDTO, Integer id);

    boolean deletePatient(Integer id);

}
