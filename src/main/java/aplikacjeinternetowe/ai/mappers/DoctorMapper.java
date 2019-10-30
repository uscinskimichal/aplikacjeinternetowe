package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.DoctorDTO;
import aplikacjeinternetowe.ai.entities.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    List<DoctorDTO> convert(List<Doctor> in);
    DoctorDTO convert(Doctor in);
    Doctor convert(DoctorDTO in);
}
