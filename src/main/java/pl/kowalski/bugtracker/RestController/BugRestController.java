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


    // TODO: 27.12.2020 wiadomosc czy zostal dodany bug

    @PostMapping("/addNewIssue")
    public void addNewIssue(@ModelAttribute Bug bug, Principal principal) {
       dmlBugService.postBug(bug, principal);

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
