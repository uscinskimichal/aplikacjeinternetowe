package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private HttpStatus httpStatus;

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private PatientServiceImpl patientService;


    public LoginFormResponse login(LoginForm loginForm) {
        if (doctorService.doctorRepository.existsByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            return doctorService.login(loginForm);
        } else if (patientService.patientRepository.existsByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            return patientService.login(loginForm);
        } else {
            setHttpStatus(HttpStatus.NOT_FOUND);
            LoginFormResponse loginFormResponse = new LoginFormResponse();
            loginFormResponse.setEmail(loginForm.getEmail());
            loginFormResponse.setPassword(loginForm.getPassword());
            loginFormResponse.setRole("Błedne dane logowania");
            return loginFormResponse;
        }

    }
}
