package pl.kowalski.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kowalski.demo.model.Project;

public interface ProjectDAO  extends JpaRepository<Project,Long> {
}
