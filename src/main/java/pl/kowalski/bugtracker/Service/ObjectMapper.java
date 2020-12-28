package pl.kowalski.bugtracker.Service;

import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Model.Progress;

import java.util.Date;


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

    public static Bug mapBugDtoToBug(BugDto bugDto, Employee reporter) {

        Date date = new Date(System.currentTimeMillis());

        Bug bug = new Bug();
        bug.setDate(date);
        bug.setDescription(bugDto.getDescription());
        bug.setId(bugDto.getId());
        bug.setLevel(bugDto.getLevel());
        bug.setProgress(Progress.OPEN);
        bug.setLastModify(date);
        bug.setEmployeeId(reporter);

        return bug;
    }

    public static Project mapProjectDtoToProject(ProjectDto projectDto) {
        Date date = new Date(System.currentTimeMillis());
        Project project = new Project();
        project.setDate(date);
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return project;
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
