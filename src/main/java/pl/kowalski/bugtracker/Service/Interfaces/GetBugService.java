package pl.kowalski.bugtracker.Service.Interfaces;

import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;

import java.util.List;

public interface GetBugService {

    List<BugDto> getAllBugsByProjectId(Long projectId);
    BugDto getInfoAboutBug(Long id);
    List<Bug> findAllTasks();
}
