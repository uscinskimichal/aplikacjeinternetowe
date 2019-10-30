package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.InstitutionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstitutionService {
    boolean deleteInstitution(Integer id);

    boolean editInstitution(InstitutionDTO institutionDTO, Integer id);

    boolean addInstitution(InstitutionDTO institutionDTO);

    InstitutionDTO getInstitution(Integer institutionId);

    List<InstitutionDTO> getAllInstitutions();
}
