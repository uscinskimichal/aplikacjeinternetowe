package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.SpecializationDTO;
import aplikacjeinternetowe.ai.entities.Specialization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {
    List<SpecializationDTO> convert(List<Specialization> in);
    SpecializationDTO convert(Specialization in);
    Specialization convert(SpecializationDTO in);
}