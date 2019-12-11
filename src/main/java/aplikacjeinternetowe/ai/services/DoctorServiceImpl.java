package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.DoctorDTO;
import aplikacjeinternetowe.ai.loginForms.LoginForm;
import aplikacjeinternetowe.ai.loginForms.LoginFormResponse;
import aplikacjeinternetowe.ai.entities.Doctor;
import aplikacjeinternetowe.ai.mappers.DoctorMapper;
import aplikacjeinternetowe.ai.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    public DoctorMapper doctorMapper;

    @Autowired
    public DoctorRepository doctorRepository;


    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.convert(doctors);
    }

    @Override
    public DoctorDTO getDoctor(Integer idDoctor) {
        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);
        return doctorMapper.convert(doctor);
    }

    @Override
    public boolean addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.convert(doctorDTO);
        doctor.setID_Doctor(0);
        doctorRepository.save(doctor);
        return true;
    }

    @Override
    public boolean editDoctor(DoctorDTO doctorDTO, Integer id) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = doctorMapper.convert(doctorDTO);
            doctor.setID_Doctor(id);
            doctorRepository.save(doctor);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor != null) {
            doctorRepository.delete(doctor);
            return true;
        } else
            return false;
    }

    @Override
    public LoginFormResponse login(LoginForm loginForm, int userId) {
        LoginFormResponse loginFormResponse = new LoginFormResponse();
        loginFormResponse.setEmail(loginForm.getEmail());
        loginFormResponse.setPassword(loginForm.getPassword());
        loginFormResponse.setRole("doctor");
        loginFormResponse.setUserId(userId);
        return loginFormResponse;
    }

}
