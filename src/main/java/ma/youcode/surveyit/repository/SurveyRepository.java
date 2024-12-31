package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("SELECT COUNT(s) > 0 FROM Survey s WHERE s.title = :title AND s.id != :id")
    boolean existsByTitleNotId(String title , Long id);
}
