package pl.kowalski.bugtracker.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.model.Dto.BugDto;
import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Progress;
import pl.kowalski.bugtracker.service.DmlBugServiceImpl;
import pl.kowalski.bugtracker.service.GetBugServiceImpl;
import pl.kowalski.bugtracker.service.Interfaces.DmlBugService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class BugRestController {


    private final GetBugServiceImpl getBugServiceImpl;
    private final DmlBugServiceImpl dmlBugServiceImpl;

    @Autowired
    public BugRestController(GetBugServiceImpl getBugServiceImpl, DmlBugServiceImpl dmlBugServiceImpl) {
        this.getBugServiceImpl = getBugServiceImpl;
        this.dmlBugServiceImpl = dmlBugServiceImpl;
    }




    @PostMapping("/addNewIssue")
    public void addNewIssue(@ModelAttribute Bug bug) {

        dmlBugServiceImpl.addNewBug(bug);
    }

    @GetMapping("/getActuallyTasksByProjectId")
    public List<BugDto>  getTasksByProjectId(Long projectId) {

        return  getBugServiceImpl.getAllBugsByProjectId(projectId);
    }

    @GetMapping("/getMoreInfoAboutBug")
    public List<BugDto>  getMoreInfoAboutBug(Long bugId) {
        return  getBugServiceImpl.getAllBugsByProjectId(bugId);
    }


    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("message/Object");
        mav.addObject("messages", "object");
        return mav;
    }



}
