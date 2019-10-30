package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.SpecializationDTO;
import aplikacjeinternetowe.ai.entities.Specialization;
import aplikacjeinternetowe.ai.mappers.SpecializationMapper;
import aplikacjeinternetowe.ai.repositories.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    SpecializationMapper specializationMapper;

    @Autowired
    SpecializationRepository specializationRepository;


    @Override
    public boolean deleteSpecialization(Integer id) {
        Specialization specialization = specializationRepository.findById(id).orElse(null);
        if (specialization!=null) {
            specializationRepository.delete(specialization);
            return true;
        } else
            return false;
    }

    @Override
    public boolean editSpecialization(SpecializationDTO specializationDTO, Integer id) {
        if (specializationRepository.existsById(id)) {
            Specialization specialization = specializationMapper.convert(specializationDTO);
            specialization.setID_Specialization(id);
            specializationRepository.save(specialization);
            return true;
        } else
            return false;
    }

    @Override
    public boolean addSpecialization(SpecializationDTO specializationDTO) {
        if (!specializationRepository.existsByName(specializationDTO.getName())) {
            Specialization specialization = specializationMapper.convert(specializationDTO);
            specialization.setID_Specialization(0);
            specializationRepository.save(specialization);
            return true;
        } else
            return false;
    }

    @Override
    public SpecializationDTO getSpecialization(Integer specializationId) {
        Specialization specialization = specializationRepository.findById(specializationId).orElse(null);
        return specializationMapper.convert(specialization);
    }

    @Override
    public List<SpecializationDTO> getAllSpecializations() {
        List<Specialization> specializations = specializationRepository.findAll();
        return specializationMapper.convert(specializations);
    }
}
