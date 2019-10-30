package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.AdministratorDTO;
import aplikacjeinternetowe.ai.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/administrators")
    public ResponseEntity<List<AdministratorDTO>> getAllAdministrators() {
        return new ResponseEntity<>(administratorService.getAllAdministrators(), HttpStatus.OK);
    }

    @GetMapping("/administrators/{id}")
    public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable("id") Integer idAdministrator) {
        AdministratorDTO administrator = administratorService.getAdministrator(idAdministrator);
        if (administrator != null)
            return new ResponseEntity<>(administrator, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/administrators")
    public ResponseEntity addAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        administratorService.addAdministrator(administratorDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/administrators/{id}")
    public ResponseEntity editAdministrator(@RequestBody AdministratorDTO administratorDTO,
                                      @PathVariable Integer id){
        if(administratorService.editAdministrator(administratorDTO,id)) //??
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/administrators/{id}")
    public ResponseEntity deleteAdministrator(@PathVariable Integer id){
        if(administratorService.deleteAdministrator(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
