package pl.kowalski.bugtracker.Dao.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalski.bugtracker.model.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
