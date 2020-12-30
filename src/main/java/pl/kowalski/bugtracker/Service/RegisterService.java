package pl.kowalski.bugtracker.Service;

import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;


public interface RegisterService {
    void register(EmployeeDto employeeDto);
}
