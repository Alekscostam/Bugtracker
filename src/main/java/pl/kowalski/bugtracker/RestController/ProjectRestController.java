package pl.kowalski.bugtracker.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Service.Post.PostProjectServiceImpl;

import java.util.List;

@RestController
public class ProjectRestController {


    private final ProjectRepository projectRepository;
    private  final PostProjectServiceImpl postProjectService;

    @Autowired
    public ProjectRestController(ProjectRepository projectRepository, PostProjectServiceImpl postProjectService) {
        this.projectRepository = projectRepository;
        this.postProjectService = postProjectService;
    }




    @GetMapping("/findAllProjects")
    public List<Project> findAllProjects()
    {
      return  projectRepository.findAll();
    }

    @PostMapping("/CreateNewProject")
    public void createNewProject(@ModelAttribute ProjectDto projectDto)
    {

        postProjectService.postProject(projectDto);
    }



}
