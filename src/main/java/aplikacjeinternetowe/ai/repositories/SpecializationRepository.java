package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization , Integer> {
    boolean existsByName(String name);
}
