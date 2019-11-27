package aplikacjeinternetowe.ai.controllers;


import aplikacjeinternetowe.ai.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;


    @GetMapping("/login")
    public ResponseEntity<String> login(
            @PathVariable String login,
            @PathVariable String password) {
        return new ResponseEntity<>(loginService.login(login,password), loginService.getHttpStatus());
    }


}
