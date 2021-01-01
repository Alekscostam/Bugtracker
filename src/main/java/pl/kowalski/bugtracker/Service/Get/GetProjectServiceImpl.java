package pl.kowalski.bugtracker.Service.Get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Model.Entity.Project;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetProjectServiceImpl implements GetProjectService {

  private final ProjectRepository projectRepository;

    @Autowired
    public GetProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAllProjects() {

        return projectRepository.findAll();

    }

    @Override
    public List<Project> findAllProjectsByCode(String code) {
        return projectRepository.findAll().stream().filter(project -> project.getInstitutionCode().equals(code)).collect(Collectors.toList());
    }

    @Override
    public Optional<Project> findDataByProjectId(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
