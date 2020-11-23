package pl.kowalski.bugtracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.model.Dto.BugDto;
import pl.kowalski.bugtracker.model.Entity.Project;
import pl.kowalski.bugtracker.service.GetBugServiceImpl;
import pl.kowalski.bugtracker.service.GetEmployeeServiceImpl;
import pl.kowalski.bugtracker.service.GetProjectServiceImpl;

import java.util.List;

@Controller
public class NavigatorController {


    private final GetBugServiceImpl getBugServiceImpl;
    private final GetEmployeeServiceImpl getEmployeeServiceImpl;
    private final GetProjectServiceImpl getProjectServiceImpl;

    @Autowired
    public NavigatorController(GetBugServiceImpl getBugServiceImpl, GetEmployeeServiceImpl getEmployeeServiceImpl, GetProjectServiceImpl getProjectServiceImpl) {
        this.getBugServiceImpl = getBugServiceImpl;
        this.getEmployeeServiceImpl = getEmployeeServiceImpl;
        this.getProjectServiceImpl = getProjectServiceImpl;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:Register";
    }

    @GetMapping("/AllBugs")
    public ModelAndView startMyTasks() {

        ModelAndView mav = new ModelAndView("AllBugs");
        List<Project> projectList = getProjectServiceImpl.findAllProjects();
        mav.addObject("projects", projectList);
        return mav;
    }



    @GetMapping("/CreateNewIssue")
    public ModelAndView  startCreateIssue() {
        ModelAndView mav = new ModelAndView("AddNewBug");
        List<Project> projectList = getProjectServiceImpl.findAllProjects();
        mav.addObject("projects", projectList);
        return mav;
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

    @GetMapping("/AllInfoAboutBug")
    public ModelAndView startBugInfoPage(Long bugId) {
        ModelAndView mav = new ModelAndView("AboutBug");
        BugDto infoAboutBug = getBugServiceImpl.getInfoAboutBug(bugId);
        String employeeNamesByBugId = getEmployeeServiceImpl.getEmployeeNamesByBugId(bugId);
        mav.addObject("bugInfo",infoAboutBug);
        mav.addObject("employeeNames",employeeNamesByBugId);
        return mav;
    }

    @GetMapping("/Login")
    public ModelAndView startLoginPage( ) {
        ModelAndView mav = new ModelAndView("Login");
        return mav;
    }
    @GetMapping("/AddInstitution")
    public ModelAndView startAddInstitutionPage( ) {
        ModelAndView mav = new ModelAndView("AddInstitution");
        return mav;
    }


}
