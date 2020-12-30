package pl.kowalski.bugtracker.Service.Get;

import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.ObjectMapper;
import pl.kowalski.bugtracker.Service.Post.PostBugService;

import java.util.List;
import java.util.Optional;

public interface GetEmployeeService   {


   String getEmployeeNamesByBugId(Long bugId);

   List<String> getInstitutionCodes();

   String generateInstitutionCode();

   boolean checkUserHaveThisTask(Long bugId, Employee employee);

   Optional<Employee> findEmployeeByEmail(String email);


}
