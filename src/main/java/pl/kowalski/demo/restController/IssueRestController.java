package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.demo.model.Issue;
import pl.kowalski.demo.model.modelDTO.IssueDTO;
import pl.kowalski.demo.service.IssueService;
import pl.kowalski.demo.service.ProjectService;

@org.springframework.web.bind.annotation.RestController
public class IssueRestController {


    ProjectService projectService;
    IssueService issueService;

    @Autowired
    public IssueRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addNewIssue")
    public String addNewIssue(@ModelAttribute IssueDTO issue)
    {


        return "asd";

    }

    @PostMapping("/addNewProject")
    public void addNewProject(String date, String name , String description)
    {
        projectService.addNewProject(date,name,description);
    }

}
