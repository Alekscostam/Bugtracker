package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kowalski.demo.dao.ProjectRepository;
import pl.kowalski.demo.model.Entity.Project;

import java.util.List;

public class ProjectRestController {


    ProjectRepository projectRepository;

    @Autowired
    public ProjectRestController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @GetMapping("/findAllProjects")
    public List<Project> findAllProjects()
    {
      return  projectRepository.findAll();
    }


}
