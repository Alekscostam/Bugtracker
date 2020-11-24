package pl.kowalski.bugtracker.Service.Interfaces;

import pl.kowalski.bugtracker.Model.Entity.Project;

import java.util.List;

public interface GetProjectService {
     List<Project> findAllProjects();
}
