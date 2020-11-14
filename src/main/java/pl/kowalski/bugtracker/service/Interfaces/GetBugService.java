package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Dto.BugDto;
import pl.kowalski.bugtracker.model.Entity.Bug;

import java.util.List;

public interface GetBugService {

    List<BugDto> getAllBugsByProjectId(Long projectId);
    BugDto getInfoAboutBug(Long id);
    List<Bug> findAllTasks();
}
