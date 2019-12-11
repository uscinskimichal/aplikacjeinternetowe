package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    boolean existsByEmailAndPassword(String email, String password);

    @Query(nativeQuery = true , value = "SELECT d.id_doctor from doctor d where d.email=?1 and d.password=?2")
    int findIdByLoginDataDoctor(String email, String password);
}
