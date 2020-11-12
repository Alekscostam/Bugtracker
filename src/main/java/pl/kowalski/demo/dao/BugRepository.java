package pl.kowalski.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kowalski.demo.model.Entity.Bug;
import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

    @Query("SELECT t FROM Bug t WHERE t.project.id = :projectId")
    List<Bug> findAllByProjectId(Long projectId);

}
