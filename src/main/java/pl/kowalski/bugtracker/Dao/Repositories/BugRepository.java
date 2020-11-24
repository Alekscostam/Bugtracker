package pl.kowalski.bugtracker.Dao.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

    @Query("SELECT b FROM Bug b WHERE b.project.id = :projectId")
    List<Bug> findAllByProjectId(Long projectId);

}
