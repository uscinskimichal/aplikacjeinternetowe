package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.entities.Form;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    List<FormDTO> getAllForms();

    FormDTO getForm(Integer idForm);

    boolean addForm(FormDTO formDTO);

    boolean editForm(FormDTO formDTO, Integer id);

    boolean deleteForm(Integer id);

    List<FormDTO> getClientForms(int patientId);

    List<FormDTO> getDoctorForms(int idDoctor);
}
