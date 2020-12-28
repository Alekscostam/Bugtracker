package pl.kowalski.bugtracker.Service.Post;


import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Service.ObjectMapper;

@Service
public class PostProjectServiceImpl implements PostProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public PostProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    // TODO: 27.12.2020 dodanie alertu czy dodalo czy nie!
    @Override
    public boolean postProject(ProjectDto projectDto) {

        Project project = ObjectMapper.mapProjectDtoToProject(projectDto);
        projectRepository.save(project);

        return false;
    }
}
