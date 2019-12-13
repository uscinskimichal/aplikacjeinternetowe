package aplikacjeinternetowe.ai.controllers;

import aplikacjeinternetowe.ai.services.RemindPasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RemindPasswordController {

    @Autowired
    RemindPasswordServiceImpl remindPasswordService;

    @PostMapping("/remindPassword")
    public ResponseEntity<String> remindPassword(@RequestParam String email) {
        return new ResponseEntity<>(remindPasswordService.remindPassword(email), HttpStatus.OK);
    }

}
