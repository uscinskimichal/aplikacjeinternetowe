package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository< Patient , Integer> {
    boolean existsByPesel(String pesel);
    boolean existsById(Integer id);

    boolean existsByEmailAndPassword(String email, String password);

    @Query(nativeQuery = true , value = "SELECT p.id_patient from patient p where p.email=?1 and p.password=?2")
    int findIdByLoginDataPatient(String email, String password);
}
