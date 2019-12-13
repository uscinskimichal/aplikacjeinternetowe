package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.entities.Doctor;
import aplikacjeinternetowe.ai.entities.Patient;
import aplikacjeinternetowe.ai.repositories.DoctorRepository;
import aplikacjeinternetowe.ai.repositories.PatientRepository;
import aplikacjeinternetowe.ai.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemindPasswordServiceImpl implements RemindPasswordService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public String remindPassword(String email) {
        if (patientRepository.findByEmail(email) != null) {
            Patient patient = patientRepository.findByEmail(email);
            EmailService emailService = new EmailService();
            emailService.sendEmail(patient.getName(), patient.getPassword(), email);
            return "Sukces, na adres email : " + email + " zostało przesłane hasło.";
        } else if (doctorRepository.findByEmail(email) != null) {
            Doctor doctor = doctorRepository.findByEmail(email);
            EmailService emailService = new EmailService();
            emailService.sendEmail(doctor.getName(), doctor.getPassword(), email);
            return "Sukces, na adres email : " + email + " zostało przesłane hasło.";
        } else
            return "Użytkownik o podanym adresie email nie istnieje.";
    }
}
