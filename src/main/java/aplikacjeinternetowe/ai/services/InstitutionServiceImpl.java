package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.InstitutionDTO;
import aplikacjeinternetowe.ai.entities.Institution;
import aplikacjeinternetowe.ai.mappers.InstitutionMapper;
import aplikacjeinternetowe.ai.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Autowired
    InstitutionMapper institutionMapper;

    @Autowired
    InstitutionRepository institutionRepository;

    @Override
    public boolean deleteInstitution(Integer id) {
        Institution institution = institutionRepository.findById(id).orElse(null);
        if (institution!=null) {
            institutionRepository.delete(institution);
            return true;
        } else
            return false;
    }

    @Override
    public boolean editInstitution(InstitutionDTO institutionDTO, Integer id) {
        if (institutionRepository.existsById(id)) {
            Institution institution = institutionMapper.convert(institutionDTO);
            institution.setID_Institution(id);
            institutionRepository.save(institution);
            return true;
        } else
            return false;
    }

    @Override
    public boolean addInstitution(InstitutionDTO institutionDTO) {
            Institution institution = institutionMapper.convert(institutionDTO);
            institution.setID_Institution(0);
            institutionRepository.save(institution);
            return true;
    }

    @Override
    public InstitutionDTO getInstitution(Integer institutionId) {
        Institution institution = institutionRepository.findById(institutionId).orElse(null);
        return institutionMapper.convert(institution);
    }

    @Override
    public List<InstitutionDTO> getAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAll();
        return institutionMapper.convert(institutions);
    }
}
