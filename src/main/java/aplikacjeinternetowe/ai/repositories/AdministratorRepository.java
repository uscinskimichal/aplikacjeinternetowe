package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator , Integer> {

    Administrator findByEmail(String email);
}
