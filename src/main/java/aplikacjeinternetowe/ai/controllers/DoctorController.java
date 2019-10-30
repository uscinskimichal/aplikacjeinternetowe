package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.dtos.DoctorDTO;
import aplikacjeinternetowe.ai.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") Integer idDoctor) {
        DoctorDTO patient = doctorService.getDoctor(idDoctor);
        if (patient != null)
            return new ResponseEntity<>(patient, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/doctors")
    public ResponseEntity addDoctor(@RequestBody DoctorDTO doctorDTO) {
        if (doctorService.addDoctor(doctorDTO))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity editDoctor(@RequestBody DoctorDTO doctorDTO,
                                      @PathVariable Integer id){
        if(doctorService.editDoctor(doctorDTO,id)) //??
            return new ResponseEntity(HttpStatus.ACCEPTED);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity deleteDoctor(@PathVariable Integer id){
        if(doctorService.deleteDoctor(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
