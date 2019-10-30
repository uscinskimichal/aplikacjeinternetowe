package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.AdministratorDTO;
import aplikacjeinternetowe.ai.entities.Administrator;
import aplikacjeinternetowe.ai.mappers.AdministratorMapper;
import aplikacjeinternetowe.ai.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public List<AdministratorDTO> getAllAdministrators() {
        List<Administrator> administrators = administratorRepository.findAll();
        return administratorMapper.convert(administrators);
    }

    @Override
    public AdministratorDTO getAdministrator(Integer administratorId) {
        Administrator administrator = administratorRepository.findById(administratorId).orElse(null);
        return administratorMapper.convert(administrator);
    }

    @Override
    public boolean addAdministrator(AdministratorDTO administratorDTO) {
            Administrator administrator = administratorMapper.convert(administratorDTO);
            administrator.setID_Administrator(0);
            administratorRepository.save(administrator);
            return true;
    }

    @Override
    public boolean editAdministrator(AdministratorDTO administratorDTO, Integer id) {
        if (administratorRepository.existsById(id)) {
            Administrator administrator = administratorMapper.convert(administratorDTO);
            administrator.setID_Administrator(id);
            administratorRepository.save(administrator);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteAdministrator(Integer id) {
        Administrator administrator = administratorRepository.findById(id).orElse(null);
        if (administrator!=null) {
            administratorRepository.delete(administrator);
            return true;
        } else
            return false;
    }
}
