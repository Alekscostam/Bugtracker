package pl.kowalski.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.demo.Dao.JdbcTemplate.BugDaoImpl;
import pl.kowalski.demo.model.ObjectMapper;
import pl.kowalski.demo.Dao.Repositories.BugRepository;
import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.service.Interfaces.GetBugService;

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


    public List<BugDto> getAllBugsByProjectId(Long projectId) {
        List<Bug> allByProjectId = bugRepository.findAllByProjectId(projectId);
        List<BugDto> bugDtoList =new ArrayList<>();
        allByProjectId.forEach(bug-> bugDtoList.add(ObjectMapper.mapBugToBugDto(bug)));
        return bugDtoList;
    }

    public BugDto getInfoAboutBug(Long id) {
        return getBugDao.findAllInfoAboutBug(id);
    }

    public List<Bug> findAllTasks() {

        return bugRepository.findAll();

    }



}
