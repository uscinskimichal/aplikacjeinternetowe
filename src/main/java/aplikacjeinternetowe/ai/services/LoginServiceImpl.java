package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginServiceImpl implements LoginService {

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    HttpStatus httpStatus;

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    PatientServiceImpl patientService;


    public LoginFormResponse login(LoginForm loginForm) {
        if (doctorService.doctorRepository.existsByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            return doctorService.login(loginForm);
        } else if (patientService.patientRepository.existsByLoginAndPassword(loginForm.getLogin(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            return patientService.login(loginForm);
        } else {
            setHttpStatus(HttpStatus.NOT_FOUND);
            LoginFormResponse loginFormResponse = new LoginFormResponse();
            loginFormResponse.setLogin(loginForm.getLogin());
            loginFormResponse.setPassword(loginForm.getPassword());
            loginFormResponse.setRole("Błedne dane logowania");
            return loginFormResponse;
        }

    }
}
