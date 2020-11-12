package pl.kowalski.demo.model.modelDTO;

import pl.kowalski.demo.dao.ProjectRepository;

public class PostDTOWrapper {


    ProjectRepository projectRepository;

    public PostDTOWrapper(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }



}
