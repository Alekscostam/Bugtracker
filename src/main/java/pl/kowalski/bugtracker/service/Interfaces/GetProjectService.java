package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Entity.Project;

import java.util.List;

public interface GetProjectService {
     List<Project> findAllProjects();
}
