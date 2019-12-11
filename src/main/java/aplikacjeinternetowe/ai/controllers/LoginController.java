package aplikacjeinternetowe.ai.controllers;


import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import aplikacjeinternetowe.ai.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginFormResponse> login(
            @RequestBody LoginForm loginForm) {
        return new ResponseEntity<>(loginService.login(loginForm), loginService.getHttpStatus());
    }
}
