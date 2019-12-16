package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.services.FormService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/forms/patient/{patientId}")
    public ResponseEntity<List<FormDTO>> findAllbyPatientFilter(@PathVariable int patientId,
                                                                @RequestParam(required = false) String status,
                                                                @RequestParam(required = false)
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                                                @RequestParam(required = false)
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo
    ) {
        return new ResponseEntity<>(formService.getClientForms(patientId, status, dateFrom, dateTo), HttpStatus.OK);
    }


    @GetMapping("/forms/doctor/{doctorId}")
    public ResponseEntity<List<FormDTO>> findAllbyDoctorFilter(@PathVariable int doctorId,
                                                               @RequestParam(required = false) String status,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                                               @RequestParam(required = false)
                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return new ResponseEntity<>(formService.getDoctorForms(doctorId, status, dateFrom, dateTo), HttpStatus.OK);
    }


    @GetMapping("/forms/doctorAll")
    public ResponseEntity<List<FormDTO>> getDoctorAvailableForms(@RequestParam(required = false) String status,
                                                                 @RequestParam(required = false)
                                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
                                                                 @RequestParam(required = false)
                                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return new ResponseEntity<>(formService.getAvailableDoctorForms(status, dateFrom, dateTo), HttpStatus.OK);
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
    public ResponseEntity addForm(@RequestBody FormDTO formDTO
            , @RequestParam int patientId) {
        if (formService.addForm(formDTO, patientId))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/forms/{id}")
    public ResponseEntity editForm(@RequestBody FormDTO formDTO,
                                   @PathVariable Integer id,
                                   @RequestParam int doctorId) {
        if (formService.editForm(formDTO, id, doctorId))
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/forms/{id}")
    public ResponseEntity deleteForm(@PathVariable Integer id,
                                     @RequestParam String role,
                                     @RequestParam int userId) {
        if (formService.deleteForm(id, role, userId))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
