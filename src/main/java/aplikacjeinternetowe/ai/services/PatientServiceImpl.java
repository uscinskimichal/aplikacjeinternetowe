package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import aplikacjeinternetowe.ai.entities.Patient;
import aplikacjeinternetowe.ai.mappers.PatientMapper;
import aplikacjeinternetowe.ai.repositories.PatientRepository;
import aplikacjeinternetowe.ai.util.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public String addPatient(PatientDTO patientDTO) {
        if (!patientRepository.existsByPesel(patientDTO.getPesel()) && !patientRepository.existsByEmail(patientDTO.getEmail())) {
            Patient patient = patientMapper.convert(patientDTO);
            patient.setID_Patient(0);
            patientRepository.save(patient);
            EmailService emailService = new EmailService();
            emailService.sendEmail(patient.getEmail(), "Rejestracja w systemie ConsultMed.", "Cześć, " + patient.getName() + "!\n\nDziękujemy za rejestrację w systemie ConsultMed :) \n\nOto Twoje dane dostępowe do strony:\nLogin(email) : " + patient.getEmail() + "\nHasło : " + patient.getPassword() + "\n\nŻyczymy pomyślnego korzystania z serwisu! ;)\nZespół ConsultMed");
            return "Rejestracja zakończona sukcesem!\nNa adres email : " + patient.getEmail() + " zostały wysłane dane potrzebne do logowania.";
        } else
            return "Błąd!\nRejestracja zakończona niepowodzeniem.\nUżytownik o podanym adresie email lub numerze PESEL juz istnieje!";
    }

    @Override
    public boolean editPatient(PatientDTO patientDTO, Integer id) {
        if ((patientRepository.findByEmail(patientDTO.getEmail()) == null || patientRepository.findByEmail(patientDTO.getEmail()).getEmail().equals(patientDTO.getEmail()))&& patientRepository.existsById(id)) {
            Patient patient = patientRepository.findById(id).orElse(null);
            if (patientDTO.getEmail() != null)
                patient.setEmail(patientDTO.getEmail());
            if (patientDTO.getPhoneNumber() != null)
                patient.setPhoneNumber(patientDTO.getPhoneNumber());
            if (patientDTO.getPassword() != null)
                patient.setPassword(patientDTO.getPassword());
            patientRepository.save(patient);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deletePatient(Integer id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient != null) {
            patient.getForms().forEach(a -> a.setPatient(null));
            patientRepository.delete(patient);
            return true;
        } else
            return false;
    }

}
