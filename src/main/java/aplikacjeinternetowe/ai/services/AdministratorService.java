package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.AdministratorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdministratorService {

    List<AdministratorDTO> getAllAdministrators();
    AdministratorDTO getAdministrator(Integer administratorId);

    boolean addAdministrator(AdministratorDTO administratorDTO);

    boolean editAdministrator(AdministratorDTO administratorDTO, Integer id);

    boolean deleteAdministrator(Integer id);
}
