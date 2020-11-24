package pl.kowalski.bugtracker.Service.Interfaces;

import pl.kowalski.bugtracker.Model.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface GetEmployeeService{

   String getEmployeeNamesByBugId(Long bugId);

   List<String> getInstitutionCodes();

   String generateInstitutionCode();

   boolean checkUserHaveThisTask(Long bugId, Employee employee);
   boolean userExists(String email);
   Optional<Employee> findEmployeeByEmail(String email);

}
