package pl.kowalski.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigatorController {

    @GetMapping("")
    public String start() {
        return "myTasks";
    }

    @GetMapping("/myTasks")
    public String startMyTasks() {
        return "myTasks";
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
