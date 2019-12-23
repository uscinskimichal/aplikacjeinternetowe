package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    boolean existsByPesel(String pesel);

    boolean existsById(Integer id);

    Patient findByEmail(String email);

    boolean existsByEmail(String email);
}
