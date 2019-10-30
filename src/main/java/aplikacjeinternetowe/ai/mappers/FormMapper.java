package aplikacjeinternetowe.ai.mappers;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.entities.Form;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FormMapper {
    List<FormDTO> convert(List<Form> in);
    FormDTO convert(Form in);
    Form convert(FormDTO in);
}
