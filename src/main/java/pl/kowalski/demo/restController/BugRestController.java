package pl.kowalski.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.service.GetBugService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class BugRestController {


    private GetBugService getBugService;

    @Autowired
    public BugRestController(GetBugService getBugService) {
        this.getBugService = getBugService;
    }

    @PostMapping("/addNewIssue")
    public void addNewIssue(@ModelAttribute BugDto issue) {

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
