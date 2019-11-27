package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    boolean existsByLoginAndPassword(String login, String password);
}
