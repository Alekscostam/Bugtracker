package pl.kowalski.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.model.Entity.Project;
import pl.kowalski.demo.service.GetBugService;

import java.util.List;

@Controller
public class NavigatorController {


    private GetBugService getBugService;

    @Autowired
    public NavigatorController(GetBugService getBugService) {
        this.getBugService = getBugService;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:allTasks";
    }

    @GetMapping("/allTasks")
    public ModelAndView startMyTasks() {

        ModelAndView mav = new ModelAndView("AllTasks");
        List<Project> projectList = getBugService.findAllProjects();
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

    @GetMapping("/bugInfo")
    public ModelAndView startBugInfoPage(Long bugId) {
        ModelAndView mav = new ModelAndView("AllTasks");
        BugDto infoAboutBug = getBugService.findInfoAboutBug(bugId);
        mav.addObject("bugInfo",infoAboutBug);
        return mav;
    }


}
