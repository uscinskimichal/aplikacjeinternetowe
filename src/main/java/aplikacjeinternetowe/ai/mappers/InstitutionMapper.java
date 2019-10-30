package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.InstitutionDTO;
import aplikacjeinternetowe.ai.entities.Institution;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {
    List<InstitutionDTO> convert(List<Institution> in);
    InstitutionDTO convert(Institution in);
    Institution convert(InstitutionDTO in);
}