package pl.kowalski.demo.service.Interfaces;

import pl.kowalski.demo.model.Entity.Project;

import java.util.List;

public interface GetProjectService {
     List<Project> findAllProjects();
}
