package pl.kowalski.bugtracker.Dao.JdbcTemplate.Interfaces;

import pl.kowalski.bugtracker.Model.Dto.BugDto;

public interface BugDao {
    BugDto findAllInfoAboutBug(Long id);
}
