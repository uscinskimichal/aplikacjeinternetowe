package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import aplikacjeinternetowe.ai.entities.Patient;
import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import aplikacjeinternetowe.ai.mappers.PatientMapper;
import aplikacjeinternetowe.ai.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    public final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.convert(patients);
    }

    @Override
    public PatientDTO getPatient(Integer patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        return patientMapper.convert(patient);
    }

    @Override
    public boolean addPatient(PatientDTO patientDTO) {
        if (!patientRepository.existsByPesel(patientDTO.getPesel())) {
            Patient patient = patientMapper.convert(patientDTO);
            patient.setID_Patient(0);
            patientRepository.save(patient);
            return true;
        } else
            return false;
    }

    @Override
    public boolean editPatient(PatientDTO patientDTO, Integer id) {
        if (patientRepository.existsById(id)) {
            Patient patient = patientMapper.convert(patientDTO);
            patient.setID_Patient(id);
            patientRepository.save(patient);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deletePatient(Integer id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient!=null) {
            patientRepository.delete(patient);
            return true;
        } else
            return false;
    }

    @Override
    public LoginFormResponse login(LoginForm loginForm) {
        LoginFormResponse loginFormResponse = new LoginFormResponse();
        loginFormResponse.setEmail(loginForm.getEmail());
        loginFormResponse.setPassword(loginForm.getPassword());
        loginFormResponse.setRole("patient");
        return loginFormResponse;
    }
}
