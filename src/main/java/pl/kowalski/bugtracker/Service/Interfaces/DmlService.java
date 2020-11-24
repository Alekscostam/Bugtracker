package pl.kowalski.bugtracker.Service.Interfaces;

import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;

public interface DmlService {
   void addBug(Bug bug);
   void register(EmployeeDto employeeDto);
}
