package pl.kowalski.bugtracker.Service.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.Progress;
import pl.kowalski.bugtracker.Repositories.BugRepository;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Service
public class PostBugServiceImpl implements PostBugService{

    private final BugRepository bugRepository;
    private final GetEmployeeServiceImpl getEmployeeService;

    @Autowired
    public PostBugServiceImpl(BugRepository bugRepository, GetEmployeeServiceImpl getEmployeeService) {
        this.bugRepository = bugRepository;
        this.getEmployeeService = getEmployeeService;
    }


    @Override
    public boolean postBug(Bug bug, Principal principal) {
        Optional<Employee> employeeByEmail = getEmployeeService.findEmployeeByEmail(principal.getName());
        boolean present = employeeByEmail.isPresent();

        if (present) {
            Date date = new Date(System.currentTimeMillis());
            bug.setDate(date);
            bug.setLastModify(date);
            bug.setProgress(Progress.OPEN);
            bug.setEmployeeId(employeeByEmail.get());
            bugRepository.save(bug);
        }

        return present;
    }
}
