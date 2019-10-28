package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.PatientDTO;
import aplikacjeinternetowe.ai.entities.Patient;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PatientMapper {
        List<PatientDTO> convert(List<Patient> in);
}
