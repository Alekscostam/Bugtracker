package pl.kowalski.bugtracker.Dao.JdbcTemplate;

import pl.kowalski.bugtracker.model.Dto.BugDto;

public interface BugDao {
    BugDto findAllInfoAboutBug(Long id);
}
