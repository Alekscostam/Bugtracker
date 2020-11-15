package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Entity.Employee;

public interface GetEmployeeService{

   String getEmployeeNamesByBugId(Long bugId);

   boolean checkUserHaveThisTask(Long bugId, Employee employee);

}
