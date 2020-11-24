package pl.kowalski.bugtracker.Dao.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kowalski.bugtracker.Model.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
