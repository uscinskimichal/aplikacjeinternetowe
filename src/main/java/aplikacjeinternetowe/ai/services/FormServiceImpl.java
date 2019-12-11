package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.entities.Doctor;
import aplikacjeinternetowe.ai.entities.Form;
import aplikacjeinternetowe.ai.mappers.DoctorMapper;
import aplikacjeinternetowe.ai.mappers.FormMapper;
import aplikacjeinternetowe.ai.repositories.DoctorRepository;
import aplikacjeinternetowe.ai.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FormServiceImpl implements FormService {


    @Autowired
    DoctorMapper doctorMapper;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    FormRepository formRepository;

    @Autowired
    FormMapper formMapper;

    @Override
    public List<FormDTO> getAllForms() {
        List<Form> forms = formRepository.findAll();
        return formMapper.convert(forms);
    }

    @Override
    public FormDTO getForm(Integer idForm) {
        Form form = formRepository.findById(idForm).orElse(null);
        return formMapper.convert(form);
    }

    @Override
    public boolean addForm(FormDTO formDTO) {
        Form form = formMapper.convert(formDTO);
        form.setID_Form(0);
        form.setDate(LocalDateTime.now());
        form.setStatus("Wysłany");
        form.setPatient_active_flag(1);
        form.setDoctor_active_flag(1);
        formRepository.save(form);
        return true;
    }

    @Override
    public boolean editForm(FormDTO formDTO, Integer id) {
        if (formRepository.existsById(id)) {
            Form form = formMapper.convert(formDTO);
            form.setID_Form(id);
            form.setStatus("Przeanalizowany");
            form.setPatient_active_flag(1);
            formRepository.save(form);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteForm(Integer id, String role, int userId) {
        Form form = formRepository.findById(id).orElse(null);
        if (form != null) {
            if (role.equals("patient") && userId == form.getPatient().getID_Patient())
                form.setPatient_active_flag(0);
            else if (role.equals("doctor") && userId == form.getDoctor().getID_Doctor())
                form.setDoctor_active_flag(0);
            formRepository.save(form);
            return true;
        } else
            return false;
    }

    @Override
    public List<FormDTO> getAvailableDoctorForms(String status, LocalDateTime dateFrom, LocalDateTime dateTo) {
        List<Form> forms = formRepository.findAllAvailableFormsForDoctor(status, dateFrom, dateTo);
        return formMapper.convert(forms);
    }

    @Override
    public List<FormDTO> getDoctorForms(int doctorId, String status, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return formMapper.convert(formRepository.findAllbyDoctorFilter(doctorId, status, dateFrom, dateTo));

    }

    @Override
    public List<FormDTO> getClientForms(int clientId, String status, LocalDateTime dateFrom, LocalDateTime dateTo) {
        return formMapper.convert(formRepository.findAllbyPatientFilter(clientId, status, dateFrom, dateTo));

    }
}
