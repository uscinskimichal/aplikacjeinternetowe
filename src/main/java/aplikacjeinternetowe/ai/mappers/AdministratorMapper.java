package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.AdministratorDTO;
import aplikacjeinternetowe.ai.entities.Administrator;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {
    List<AdministratorDTO> convert(List<Administrator> in);
    AdministratorDTO convert(Administrator in);
    Administrator convert(AdministratorDTO in);
}
