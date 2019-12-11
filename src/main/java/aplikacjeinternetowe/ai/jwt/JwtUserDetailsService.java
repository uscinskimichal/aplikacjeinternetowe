package aplikacjeinternetowe.ai.jwt;

import aplikacjeinternetowe.ai.entities.Doctor;
import aplikacjeinternetowe.ai.entities.Patient;
import aplikacjeinternetowe.ai.repositories.DoctorRepository;
import aplikacjeinternetowe.ai.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Patient patient = patientRepository.findByEmail(email);

        if (patient != null)
            return new org.springframework.security.core.userdetails.User(patient.getEmail(), patient.getPassword(), new ArrayList<>());
        else {
            Doctor doctor = doctorRepository.findByEmail(email);
            if (doctor != null)
                return new org.springframework.security.core.userdetails.User(doctor.getEmail(), doctor.getPassword(), new ArrayList<>());
            else
                throw new UsernameNotFoundException("Użytkownik o podanym mailu nie istnieje: " + email);
        }
    }
}
