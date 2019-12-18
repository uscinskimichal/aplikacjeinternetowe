package aplikacjeinternetowe.ai.jwt;

import aplikacjeinternetowe.ai.entities.Doctor;
import aplikacjeinternetowe.ai.entities.Patient;
import aplikacjeinternetowe.ai.repositories.DoctorRepository;
import aplikacjeinternetowe.ai.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
                return new org.springframework.security.core.userdetails.User(doctor.getEmail(), doctor.getPassword(), new ArrayList<>());
        }
    }

    public ResponseEntity<JwtResponse> createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        final UserDetails userDetails = loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        Patient patient = patientRepository.findByEmail(authenticationRequest.getEmail());
        if (patient != null) {
            return new ResponseEntity<>(new JwtResponse(token, patient.getID_Patient(), "patient"), HttpStatus.OK);
        } else {
            Doctor doctor = doctorRepository.findByEmail(authenticationRequest.getEmail());
            if (doctor != null)
                return new ResponseEntity<>(new JwtResponse(token, doctor.getID_Doctor(), "doctor"), HttpStatus.OK);
            else
                return new ResponseEntity<>(new JwtResponse(token, doctor.getID_Doctor(), "Error"), HttpStatus.CONFLICT);
        }

    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
