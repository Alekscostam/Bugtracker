package pl.kowalski.bugtracker.Service.Post;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.Entity.Project;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;
import pl.kowalski.bugtracker.Service.ObjectMapper;

import java.security.Principal;
import java.util.Optional;


@Service
public class PostProjectServiceImpl implements PostProjectService {

    private static Logger LOGGER = LoggerFactory.getLogger(PostProjectServiceImpl.class);

    private final ProjectRepository projectRepository;
    private final GetEmployeeServiceImpl getEmployeeService;


    public PostProjectServiceImpl(ProjectRepository projectRepository, GetEmployeeServiceImpl getEmployeeService) {
        this.projectRepository = projectRepository;
        this.getEmployeeService = getEmployeeService;
    }

    @Override
    public boolean postProject(ProjectDto projectDto, Principal principal) {

        Optional<Employee> employeeByEmail = getEmployeeService.findEmployeeByEmail(principal.getName());
        boolean present = employeeByEmail.isPresent();


        if(present){
            Project project = ObjectMapper.mapProjectDtoToProject(projectDto, employeeByEmail.get());
            projectRepository.save(project);
        }

        return  present;

    }
}
