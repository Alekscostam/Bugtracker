package pl.kowalski.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Model.Entity.Project;

import java.util.List;

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
}
