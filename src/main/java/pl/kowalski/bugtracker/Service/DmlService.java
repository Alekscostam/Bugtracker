package pl.kowalski.bugtracker.Service;

import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;

import java.security.Principal;

public interface DmlService {
   boolean postBug(BugDto bug, Principal principal);
   void register(EmployeeDto employeeDto);
}
