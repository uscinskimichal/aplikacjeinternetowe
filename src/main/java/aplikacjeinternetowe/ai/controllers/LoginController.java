package aplikacjeinternetowe.ai.controllers;


import aplikacjeinternetowe.ai.dtos.AdministratorDTO;
import aplikacjeinternetowe.ai.services.DoctorServiceImpl;
import aplikacjeinternetowe.ai.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    PatientServiceImpl patientService;


    @GetMapping("/login")
    public ResponseEntity<String> login(
            @PathVariable String login,
            @PathVariable String password) {
        if (doctorService.doctorRepository.existsByLoginAndPassword(login, password))
            return new ResponseEntity<>(doctorService.login(login, password), HttpStatus.OK);
        else if (patientService.patientRepository.existsByLoginAndPassword(login, password))
            return new ResponseEntity<>(patientService.login(login, password), HttpStatus.OK);
        else
            return new ResponseEntity<>("Błedne dane logowania", HttpStatus.NOT_FOUND);
    }


}
