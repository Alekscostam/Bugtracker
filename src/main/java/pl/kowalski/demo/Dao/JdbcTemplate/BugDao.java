package pl.kowalski.demo.Dao.JdbcTemplate;

import pl.kowalski.demo.model.Dto.BugDto;

public interface BugDao {
    BugDto findAllInfoAboutBug(Long id);
}
