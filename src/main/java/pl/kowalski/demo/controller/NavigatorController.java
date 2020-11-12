package pl.kowalski.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Entity.Project;
import pl.kowalski.demo.service.FindTasksService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NavigatorController {



    private FindTasksService findTasksService;

    @Autowired
    public NavigatorController(FindTasksService findTasksService) {
        this.findTasksService = findTasksService;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:allTasks";
    }

    @GetMapping("/allTasks")
    public ModelAndView startMyTasks() {

        ModelAndView mav = new ModelAndView("allTasks");
        List<Project> projectList = findTasksService.findAllProjects();
        mav.addObject("projects", projectList);
        return mav;
    }

    @GetMapping("/createIssue")
    public String startCreateIssue() {
        return "createIssue";
    }

    @GetMapping("/createProject")
    public String startCreateProject() {
        return "redirect:/start";
    }

    @GetMapping("/openTasks")
    public String startOpenTasks() {
        return "redirect:/start";
    }

    @GetMapping("/inProgressTasks")
    public String startInProgressTaskss() {
        return "redirect:/start";
    }
    @GetMapping("/toAnalyze")
    public String startToAnalyze() {
        return "redirect:/start";
    }


}
