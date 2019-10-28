package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import aplikacjeinternetowe.ai.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }
}
