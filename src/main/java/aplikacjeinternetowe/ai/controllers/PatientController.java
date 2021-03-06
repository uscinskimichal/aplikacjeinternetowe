package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import aplikacjeinternetowe.ai.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Integer idPatient) {
        PatientDTO patientDTO = patientService.getPatient(idPatient);
        if (patientDTO != null)
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/patients")
    public ResponseEntity<String> addPatient(@RequestBody PatientDTO patientDTO) {
        String result = patientService.addPatient(patientDTO);
        if (!result.startsWith("Błąd"))
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity editPatient(@RequestBody PatientDTO patientDTO,
                                      @PathVariable Integer id) {
        if (patientService.editPatient(patientDTO, id))
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity deletePatient(@PathVariable Integer id) {
        if (patientService.deletePatient(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
