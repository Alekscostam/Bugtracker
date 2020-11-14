package pl.kowalski.demo.service.Interfaces;

import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.model.Entity.Bug;

import java.util.List;

public interface GetBugService {

    List<BugDto> getAllBugsByProjectId(Long projectId);
    BugDto getInfoAboutBug(Long id);
    List<Bug> findAllTasks();
}
