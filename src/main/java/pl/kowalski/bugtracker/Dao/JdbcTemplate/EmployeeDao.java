package pl.kowalski.bugtracker.Dao.JdbcTemplate;

import java.util.List;

public interface EmployeeDao {

    List<String> findEmployeeNamesByBugId(Long bugId);
}
