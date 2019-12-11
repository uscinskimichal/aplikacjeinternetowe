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
        int userId;
        if (doctorService.doctorRepository.existsByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            userId = doctorService.doctorRepository.findIdByLoginDataDoctor(loginForm.getEmail(), loginForm.getPassword());
            return doctorService.login(loginForm, userId);
        } else if (patientService.patientRepository.existsByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword())) {
            setHttpStatus(HttpStatus.OK);
            userId = patientService.patientRepository.findIdByLoginDataPatient(loginForm.getEmail(), loginForm.getPassword());
            return patientService.login(loginForm, userId);
        } else {
            setHttpStatus(HttpStatus.NOT_FOUND);
            LoginFormResponse loginFormResponse = new LoginFormResponse();
            loginFormResponse.setEmail(loginForm.getEmail());
            loginFormResponse.setPassword(loginForm.getPassword());
            loginFormResponse.setRole("Błedne dane logowania");
            loginFormResponse.setUserId(0);
            return loginFormResponse;
        }

    }
}
