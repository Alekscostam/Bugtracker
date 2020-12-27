package pl.kowalski.bugtracker.Service.Get;

import pl.kowalski.bugtracker.Model.Entity.Project;

import java.util.List;

public interface GetProjectService {
     List<Project> findAllProjects();
     List<Project> findAllProjectsByCode(String code);
}
