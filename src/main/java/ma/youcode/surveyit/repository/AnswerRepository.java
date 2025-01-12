package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Modifying
    @Query(value = "DELETE FROM Answer a WHERE a.id = :id")
    void deleteById(@Param("id") Long id);


}
