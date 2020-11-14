package pl.kowalski.demo.Dao.JdbcTemplate;

import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.model.Entity.Employee;

import java.util.List;

public interface BugDao {
    BugDto findAllInfoAboutBug(Long id);
}
