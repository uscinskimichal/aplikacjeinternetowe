package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution , Integer> {

}
