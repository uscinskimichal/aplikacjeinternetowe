package aplikacjeinternetowe.ai.services;

import aplikacjeinternetowe.ai.dtos.FormDTO;
import aplikacjeinternetowe.ai.entities.Form;
import aplikacjeinternetowe.ai.mappers.FormMapper;
import aplikacjeinternetowe.ai.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    FormRepository formRepository;

    @Autowired
    FormMapper formMapper;


    @Override
    public List<FormDTO> getAllForms() {
        List<Form> forms = formRepository.findAll();
        return formMapper.convert(forms);
    }

    @Override
    public FormDTO getForm(Integer idForm) {
        Form form = formRepository.findById(idForm).orElse(null);
        return formMapper.convert(form);
    }

    @Override
    public boolean addForm(FormDTO formDTO) {
        Form form = formMapper.convert(formDTO);
        form.setID_Form(0);
        formRepository.save(form);
        return true;
    }

    @Override
    public boolean editForm(FormDTO formDTO, Integer id) {
        if (formRepository.existsById(id)) {
            Form form = formMapper.convert(formDTO);
            form.setID_Form(id);
            formRepository.save(form);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteForm(Integer id) {
        Form form = formRepository.findById(id).orElse(null);
        if (form != null) {
            formRepository.delete(form);
            return true;
        } else
            return false;
    }
}
