package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.SpecializationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecializationService {
    boolean deleteSpecialization(Integer id);

    boolean editSpecialization(SpecializationDTO specializationDTO, Integer id);

    boolean addSpecialization(SpecializationDTO specializationDTO);

    SpecializationDTO getSpecialization(Integer specializationId);

    List<SpecializationDTO> getAllSpecializations();
}
