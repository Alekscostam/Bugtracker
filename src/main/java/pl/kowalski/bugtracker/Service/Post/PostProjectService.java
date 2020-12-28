package pl.kowalski.bugtracker.Service.Post;

import org.springframework.stereotype.Repository;
import pl.kowalski.bugtracker.Model.Dto.ProjectDto;

@Repository
public interface PostProjectService {

    boolean postProject(ProjectDto projectDto);

}
