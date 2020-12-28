package pl.kowalski.bugtracker.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.DmlServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetBugServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BugRestController {


    private final GetBugServiceImpl getBugService;
    private final DmlServiceImpl dmlBugService;


    @Autowired
    public BugRestController(GetBugServiceImpl getBugService, DmlServiceImpl dmlBugService) {
        this.getBugService = getBugService;
        this.dmlBugService = dmlBugService;

    }


    @PostMapping("/CreateNewIssue")
    public ModelAndView addNewIssue(@ModelAttribute BugDto bug, Principal principal) {
        ModelAndView mav = new ModelAndView("redirect:/CreateNewIssue");
        boolean postBugResult = dmlBugService.postBug(bug, principal);

        if (postBugResult) {
            mav.addObject("message", "successfully added!");
        }
        else
            mav.addObject("message", "failure!");

        return mav;
    }

    @GetMapping("/getActuallyTasksByProjectId")
    public List<BugDto>  getTasksByProjectId(Long projectId) {

        return  getBugService.getAllBugsByProjectId(projectId);
    }

    @GetMapping("/getMoreInfoAboutBug")
    public List<BugDto>  getMoreInfoAboutBug(Long bugId) {
        return  getBugService.getAllBugsByProjectId(bugId);
    }


    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("message/Object");
        mav.addObject("messages", "object");
        return mav;
    }



}
