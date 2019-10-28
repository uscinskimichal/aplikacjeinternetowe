package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository< Patient , Integer> {
}
