package pl.kowalski.bugtracker.Service.Get;

import pl.kowalski.bugtracker.Model.Entity.Project;

import java.util.List;
import java.util.Optional;

public interface GetProjectService {
     List<Project> findAllProjects();
     List<Project> findAllProjectsByCode(String code);

    Optional<Project> findDataByProjectId(Long projectId);
}
