package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.DoctorDTO;
import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    List<DoctorDTO> getAllDoctors();

    DoctorDTO getDoctor(Integer idDoctor);

    boolean addDoctor(DoctorDTO doctorDTO);

    boolean editDoctor(DoctorDTO doctorDTO, Integer id);

    boolean deleteDoctor(Integer id);

    LoginFormResponse login(LoginForm loginForm, int userId);
}
