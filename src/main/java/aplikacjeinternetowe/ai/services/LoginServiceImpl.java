package aplikacjeinternetowe.ai.services;

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

    HttpStatus httpStatus;

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    PatientServiceImpl patientService;

    public String login(String login, String password) {
        if (doctorService.doctorRepository.existsByLoginAndPassword(login, password)) {
            setHttpStatus(HttpStatus.OK);
            return doctorService.login(login, password);
        } else if (patientService.patientRepository.existsByLoginAndPassword(login, password)) {
            setHttpStatus(HttpStatus.OK);
            return patientService.login(login, password);
        } else {
            setHttpStatus(HttpStatus.NOT_FOUND);
            return "Błedne dane logowania";
        }

    }
}
