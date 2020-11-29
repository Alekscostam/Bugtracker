package pl.kowalski.bugtracker.Service;

import pl.kowalski.bugtracker.Model.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface GetEmployeeService{

   String getEmployeeNamesByBugId(Long bugId);

   List<String> getInstitutionCodes();

   String generateInstitutionCode();

   boolean checkUserHaveThisTask(Long bugId, Employee employee);

   Optional<Employee> findEmployeeByEmail(String email);

}
