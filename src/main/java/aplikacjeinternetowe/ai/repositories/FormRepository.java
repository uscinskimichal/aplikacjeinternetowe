package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {

    @Query(nativeQuery = true,
            value = "Select * from form where id_patient=?1"
    )
    List<Form> findAllByPatient(int patientId);


    @Query(nativeQuery = true,
            value = "Select * from form where id_doctor=?1")
    List<Form> findAllbyDoctor(int idDoctor);

    @Query(nativeQuery = true,
            value = "Select * from form where id_doctor is null")
    List<Form> findAllAvailableFormsForDoctor(); // TO DO
}
