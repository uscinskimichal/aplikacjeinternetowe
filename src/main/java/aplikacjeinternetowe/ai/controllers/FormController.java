package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/forms/patient/{patientId}")
    public ResponseEntity<List<FormDTO>> getClientForms(@PathVariable int patientId) {
        return new ResponseEntity<>(formService.getClientForms(patientId),HttpStatus.OK);
    }


    @GetMapping("/forms/doctor/{doctorId}")
    public ResponseEntity<List<FormDTO>> getDoctorForms(@PathVariable int doctorId) {
        return new ResponseEntity<>(formService.getDoctorForms(doctorId),HttpStatus.OK);
    }


    @GetMapping("/forms/doctorAll")
    public ResponseEntity<List<FormDTO>> getDoctorAvailableForms() {
        return new ResponseEntity<>(formService.getAvailableDoctorForms(),HttpStatus.OK);
    }


    @GetMapping("/forms")
    public ResponseEntity<List<FormDTO>> getAllForms() {
        return new ResponseEntity<>(formService.getAllForms(), HttpStatus.OK);
    }

    @GetMapping("/forms/{id}")
    public ResponseEntity<FormDTO> getForm(@PathVariable("id") Integer idForm) {
        FormDTO formDTO = formService.getForm(idForm);
        if (formDTO != null)
            return new ResponseEntity<>(formDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/forms")
    public ResponseEntity addForm(@RequestBody FormDTO formDTO) {
        if (formService.addForm(formDTO))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/forms/{id}")
    public ResponseEntity editForm(@RequestBody FormDTO formDTO,
                                   @PathVariable Integer id) {
        if (formService.editForm(formDTO, id)) //??
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/forms/{id}")
    public ResponseEntity deleteForm(@PathVariable Integer id) {
        if (formService.deleteForm(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
