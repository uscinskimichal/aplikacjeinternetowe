package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

    @Query(nativeQuery = true, value = "Select * from institution i " +
            "JOIN institution_specialization iss on i.id_institution=iss.id_institution " +
            "where iss.id_specialization = ?1 ")
    List<Institution> getInstitutionsFiltered(int id_specialization);

}
