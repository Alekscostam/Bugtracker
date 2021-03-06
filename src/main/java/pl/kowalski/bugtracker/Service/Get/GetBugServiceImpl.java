package pl.kowalski.bugtracker.Service.Get;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.BugDaoImpl;
import pl.kowalski.bugtracker.Service.ObjectMapper;
import pl.kowalski.bugtracker.Repositories.BugRepository;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Dto.BugDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetBugServiceImpl implements GetBugService {

    BugRepository bugRepository;
    BugDaoImpl getBugDao;

    @Autowired
    public GetBugServiceImpl(BugRepository bugRepository, BugDaoImpl getBugDao) {
        this.bugRepository = bugRepository;
        this.getBugDao = getBugDao;
    }


    @Override
    public List<BugDto> getAllBugsByProjectId(Long projectId) {

        List<Bug> allByProjectId = bugRepository.findAllByProjectId(projectId);
        List<BugDto> bugDtoList =new ArrayList<>();
        allByProjectId.forEach(bug-> bugDtoList.add(ObjectMapper.mapBugToBugDto(bug)));

        return bugDtoList;
    }

    @Override
    public BugDto getInfoAboutBug( Long id) {
        return getBugDao.findAllInfoAboutBug(id);
    }

    @Override
    public List<Bug> findAllTasks() {

        return bugRepository.findAll();

    }



}
