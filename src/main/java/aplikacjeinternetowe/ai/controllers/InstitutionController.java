package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.InstitutionDTO;
import aplikacjeinternetowe.ai.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;


    @GetMapping("/institutions")
    public ResponseEntity<List<InstitutionDTO>> getAllInstitutions() {
        return new ResponseEntity<>(institutionService.getAllInstitutions(), HttpStatus.OK);
    }

    @GetMapping("/institutions/{id}")
    public ResponseEntity<InstitutionDTO> getInstitution(@PathVariable("id") Integer institutionId) {
        InstitutionDTO specializationDTO = institutionService.getInstitution(institutionId);
        if (specializationDTO != null)
            return new ResponseEntity<>(specializationDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/institutions")
    public ResponseEntity addInstitution(@RequestBody InstitutionDTO institutionDTO) {
        if (institutionService.addInstitution(institutionDTO))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/institutions/{id}")
    public ResponseEntity editInstitution(@RequestBody InstitutionDTO institutionDTO,
                                             @PathVariable Integer id) {
        if (institutionService.editInstitution(institutionDTO, id)) //??
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/institutions/{id}")
    public ResponseEntity deleteInstitution(@PathVariable Integer id) {
        if (institutionService.deleteInstitution(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
