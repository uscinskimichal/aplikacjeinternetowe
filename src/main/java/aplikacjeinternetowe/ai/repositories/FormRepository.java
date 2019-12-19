package aplikacjeinternetowe.ai.repositories;

import aplikacjeinternetowe.ai.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {

    @Query(nativeQuery = true,
            value = "Select * from form f where f.id_doctor is null AND " +
                    "ifnull(?1,-1) = case when ?1 is null then -1 else f.status END AND " +
                    "ifnull(?2,-1) <= case when ?2 is null then -1 else f.date END AND " +
                    "ifnull(?3,-1) >= case when ?3 is null then -1 else f.date  END AND f.id_patient is not null " +
                    "GROUP BY f.id_form")
    List<Form> findAllAvailableFormsForDoctor(String status, LocalDateTime dateFrom, LocalDateTime dateTo); // TO DO + AUTOMATYYCZNA DATA W FORM I STATUS POST


    @Query(nativeQuery = true,
            value = "Select * from form f " +
                    "where ifnull(?1,-1) = case when ?1 is null then -1 else f.id_patient END AND " +
                    "ifnull(?2,-1) = case when ?2 is null then -1 else f.status END AND " +
                    "ifnull(?3,-1) <= case when ?3 is null then -1 else f.date END AND " +
                    "ifnull(?4,-1) >= case when ?4 is null then -1 else f.date  END AND " +
                    "f.patient_active_flag = 1 "+
                    "GROUP BY f.id_form")
    List<Form> findAllbyPatientFilter(int patientId, String status, LocalDateTime dateFrom, LocalDateTime dateTo);


    @Query(nativeQuery = true,
            value = "Select * from form f " +
                    "where ifnull(?1,-1) = case when ?1 is null then -1 else f.id_doctor END AND " +
                    "ifnull(?2,-1) = case when ?2 is null then -1 else f.status END AND " +
                    "ifnull(?3,-1) <= case when ?3 is null then -1 else f.date END AND " +
                    "ifnull(?4,-1) >= case when ?4 is null then -1 else f.date END AND " +
                    "f.doctor_active_flag = 1 "+
                    "GROUP BY f.id_form")
    List<Form> findAllbyDoctorFilter(int doctorId, String status, LocalDateTime dateFrom, LocalDateTime dateTo);

}
