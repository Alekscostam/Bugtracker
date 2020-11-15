package pl.kowalski.bugtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.Repositories.BugRepository;
import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Progress;
import pl.kowalski.bugtracker.service.Interfaces.DmlBugService;

@Service
public class DmlBugServiceImpl implements DmlBugService {

    BugRepository bugRepository;

    @Autowired
    public DmlBugServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Override
    public void addNewBug(Bug bug) {
        bug.setProgress(Progress.OPEN);
        bugRepository.save(bug);
    }


}
