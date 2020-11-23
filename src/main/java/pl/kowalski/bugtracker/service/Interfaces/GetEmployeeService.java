package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Entity.Employee;

import java.util.List;

public interface GetEmployeeService{

   String getEmployeeNamesByBugId(Long bugId);

   List<String> getInstitutionCodes();

   String generateInstitutionCode();

   boolean checkUserHaveThisTask(Long bugId, Employee employee);

}
