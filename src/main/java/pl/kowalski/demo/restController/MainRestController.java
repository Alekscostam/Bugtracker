package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kowalski.demo.service.ProjectService;

@org.springframework.web.bind.annotation.RestController
public class MainRestController {

    @Autowired
    ProjectService projectService;

    public MainRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addNewIssue")
    public void addNewIssue(String name, String data, String level , String desc, String custId)
    {

    }

    @PostMapping("/addNewProject")
    public void addNewProject(String date, String name , String description)
    {
        projectService.addNewProject(date,name,description);
    }

}
