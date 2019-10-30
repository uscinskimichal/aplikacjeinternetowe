package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {
}
