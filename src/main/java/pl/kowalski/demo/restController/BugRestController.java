package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Entity.Project;
import pl.kowalski.demo.model.Entity.Dto.BugDto;
import pl.kowalski.demo.service.FindTasksService;

import java.util.Arrays;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class BugRestController {


    private FindTasksService findTasksService;

    @Autowired
    public BugRestController(FindTasksService findTasksService) {
        this.findTasksService = findTasksService;
    }

    @PostMapping("/addNewIssue")
    public void addNewIssue(@ModelAttribute BugDto issue) {

    }

    @GetMapping("/getActuallyTasksByProjectId")
    public List<BugDto>  getTasksByProjectId(Long projectId) {
        return  findTasksService.getAllByProjectId(projectId);
    }


    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("message/Object");
        mav.addObject("messages", "object");
        return mav;
    }

}
