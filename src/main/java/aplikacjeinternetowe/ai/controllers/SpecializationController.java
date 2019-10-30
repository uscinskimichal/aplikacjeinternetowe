package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.SpecializationDTO;
import aplikacjeinternetowe.ai.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;


    @GetMapping("/specializations")
    public ResponseEntity<List<SpecializationDTO>> getAllSpecializations() {
        return new ResponseEntity<>(specializationService.getAllSpecializations(), HttpStatus.OK);
    }

    @GetMapping("/specializations/{id}")
    public ResponseEntity<SpecializationDTO> getSpecialization(@PathVariable("id") Integer specializationId) {
        SpecializationDTO specializationDTO = specializationService.getSpecialization(specializationId);
        if (specializationDTO != null)
            return new ResponseEntity<>(specializationDTO, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/specializations")
    public ResponseEntity addSpecialization(@RequestBody SpecializationDTO specializationDTO) {
        if (specializationService.addSpecialization(specializationDTO))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/specializations/{id}")
    public ResponseEntity editSpecialization(@RequestBody SpecializationDTO specializationDTO,
                                             @PathVariable Integer id) {
        if (specializationService.editSpecialization(specializationDTO, id)) //??
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/specializations/{id}")
    public ResponseEntity deleteSpecialization(@PathVariable Integer id) {
        if (specializationService.deleteSpecialization(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
