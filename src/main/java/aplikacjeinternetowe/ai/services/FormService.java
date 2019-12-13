package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.entities.Form;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface FormService {
    List<FormDTO> getAllForms();

    FormDTO getForm(Integer idForm);

    boolean addForm(FormDTO formDTO);

    boolean editForm(FormDTO formDTO, Integer id, int doctorId);

    boolean deleteForm(Integer id, String role, int userId);

    List<FormDTO> getClientForms(int patientId, String status, LocalDateTime dateFrom , LocalDateTime dateTo);

    List<FormDTO> getDoctorForms(int idDoctor, String status, LocalDateTime dateFrom , LocalDateTime dateTo);

    List<FormDTO> getAvailableDoctorForms(String status, LocalDateTime dateFrom, LocalDateTime dateTo);
}
