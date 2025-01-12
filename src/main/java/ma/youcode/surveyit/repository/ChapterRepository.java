package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {


    @Modifying
    @Query(value = "DELETE FROM Chapter c WHERE c.id = :id")
    void deleteById(@Param("id") Long id);

}
