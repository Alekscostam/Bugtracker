package pl.kowalski.bugtracker.model;

import pl.kowalski.bugtracker.model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Dto.BugDto;
import pl.kowalski.bugtracker.model.Entity.Employee;


public class ObjectMapper {

    private ObjectMapper() {
    }

    public static BugDto mapBugToBugDto(Bug bug) {

        BugDto bugDto = new BugDto();
        bugDto.setDate(bug.getDate());
        bugDto.setDescription(bug.getDescription());
        bugDto.setId(bug.getId());
        bugDto.setLevel(bug.getLevel());
        bugDto.setProgress(bug.getProgress());

        return bugDto;
    }

    public static Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setInstitutionCode(employeeDto.getInstitutionCode());
        employee.setLastName(employeeDto.getLastName());
        employee.setPassword(employeeDto.getPassword());

        return employee;
    }

}
