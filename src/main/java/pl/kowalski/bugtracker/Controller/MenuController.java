package pl.kowalski.bugtracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Service.EmailNotFoundException;
import pl.kowalski.bugtracker.Service.Get.GetBugServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetProjectServiceImpl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class MenuController {


    private final GetBugServiceImpl getBugServiceImpl;
    private final GetEmployeeServiceImpl getEmployeeServiceImpl;
    private final GetProjectServiceImpl getProjectServiceImpl;

    @Autowired
    public MenuController(GetBugServiceImpl getBugServiceImpl, GetEmployeeServiceImpl getEmployeeServiceImpl, GetProjectServiceImpl getProjectServiceImpl) {
        this.getBugServiceImpl = getBugServiceImpl;
        this.getEmployeeServiceImpl = getEmployeeServiceImpl;
        this.getProjectServiceImpl = getProjectServiceImpl;
    }

    @GetMapping("/")
    public String start() {
        return "redirect:Register";
    }

    @GetMapping("/AllBugs")
    public ModelAndView startMyTasks(Principal principal) {

        ModelAndView mav = new ModelAndView("AllBugs");
        Optional<Employee> employeeByEmail = getEmployeeServiceImpl.findEmployeeByEmail(principal.getName());

        if (employeeByEmail.isEmpty())
            throw new EmailNotFoundException("Something goes wrong... User is not present after log in");

        List<Project> projectList = getProjectServiceImpl.findAllProjectsByCode(employeeByEmail.get().getEmail());

        if(projectList.isEmpty())
            mav.addObject("message", "No projects were found!");

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

    @GetMapping("/AddInstitution")
    public ModelAndView startAddInstitutionPage( ) {
        ModelAndView mav = new ModelAndView("AddInstitution");
        return mav;
    }

}
