package pl.kowalski.bugtracker.RestController;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Service.Get.GetProjectService;
import pl.kowalski.bugtracker.Service.Get.GetProjectServiceImpl;
import pl.kowalski.bugtracker.Service.Post.PostProjectServiceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectRestController {


    private final ProjectRepository projectRepository;
    private  final PostProjectServiceImpl postProjectService;
    private  final GetProjectServiceImpl getProjectService;

    public ProjectRestController(ProjectRepository projectRepository, PostProjectServiceImpl postProjectService, GetProjectServiceImpl getProjectService) {
        this.projectRepository = projectRepository;
        this.postProjectService = postProjectService;
        this.getProjectService = getProjectService;
    }

    @GetMapping("/findAllProjects")
    public List<Project> findAllProjects()
    {
      return  projectRepository.findAll();
    }

    @PostMapping("/CreateNewProject")
    public ModelAndView createNewProject(@ModelAttribute ProjectDto projectDto, Principal principal)
    {

        ModelAndView mav = new ModelAndView("redirect:/CreateNewProject");
        boolean postProject = postProjectService.postProject(projectDto, principal);

        if (postProject) {
            mav.addObject("message", "Project successfully added!");
        }
        else
            mav.addObject("message", "failure!");

        return mav;
    }


    // TODO: 01.01.2021 cos tu sie dzieje wiec trza naprawic  
    // TODO: 01.01.2021 wstawianie projectu do tabelek  
    @GetMapping("/getDataByProjectId")
    public Project getDataProject(Long projectId) throws NotFoundException {
        Optional<Project> dataByProjectId = getProjectService.findDataByProjectId(projectId);
        if(dataByProjectId.isPresent())
        {
            return dataByProjectId.get();
        }
        else
            throw new NotFoundException("Something goes wrong... project is not found");

    }

}
