package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {
//    @Query("SELECT e FROM Edition e " +
//            "LEFT JOIN FETCH e.chapters c " +
//            "LEFT JOIN FETCH c.subchapters s " +
//            "LEFT JOIN FETCH c.questions q")
//    List<Edition> findAllWithDetails();
}
