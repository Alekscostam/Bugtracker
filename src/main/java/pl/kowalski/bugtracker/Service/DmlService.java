package pl.kowalski.bugtracker.Service;

import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;

import java.security.Principal;

public interface DmlService {
   boolean postBug(Bug bug, Principal principal);
   void register(EmployeeDto employeeDto);
}
