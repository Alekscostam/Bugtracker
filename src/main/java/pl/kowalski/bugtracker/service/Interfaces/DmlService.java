package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Entity.Employee;

public interface DmlService {
   void addNewBug(Bug bug);
   boolean addNewEmployee(EmployeeDto employeeDto);
}
