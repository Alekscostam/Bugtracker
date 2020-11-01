package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kowalski.demo.dao.ProjectDAO;
import pl.kowalski.demo.model.Project;

import java.util.List;

public class ProjectRestController {


    ProjectDAO projectDAO;

    @Autowired
    public ProjectRestController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }


    @GetMapping("/findAllProjects")
    public List<Project> findAllProjects()
    {
      return  projectDAO.findAll();
    }


}
