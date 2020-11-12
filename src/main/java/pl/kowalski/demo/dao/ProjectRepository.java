package pl.kowalski.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalski.demo.model.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
