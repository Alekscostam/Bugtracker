package pl.kowalski.bugtracker.Service.Post;


import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Repositories.ProjectRepository;

@Service
public class PostProjectServiceImpl implements PostProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public PostProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    // TODO: 27.12.2020 dodawanie nowego projecktu
    @Override
    public boolean PostProject() {
        
        // projectRepository.save();
        return false;
    }
}
