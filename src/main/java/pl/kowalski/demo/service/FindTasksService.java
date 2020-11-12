package pl.kowalski.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.demo.ObjectMapper;
import pl.kowalski.demo.dao.BugRepository;
import pl.kowalski.demo.dao.ProjectRepository;
import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Entity.Dto.BugDto;
import pl.kowalski.demo.model.Entity.Project;

import java.math.BigInteger;
import java.util.List;

@Service
public class FindTasksService {

    BugRepository bugRepository;
    ProjectRepository projectRepository;

    @Autowired
    public FindTasksService(BugRepository bugRepository, ProjectRepository projectRepository) {
        this.bugRepository = bugRepository;
        this.projectRepository = projectRepository;
    }

    public List<BugDto> getAllByProjectId(Long projectId) {
        List<Bug> allByProjectId = bugRepository.findAllByProjectId(projectId);
        List<BugDto> bugDtos = ObjectMapper.mapBugToBugDto(allByProjectId);
        return bugDtos;

    }

    public List<Bug> findAllTasks() {

     return bugRepository.findAll();

    }
    public List<Project> findAllProjects() {

     return projectRepository.findAll();

    }






}
