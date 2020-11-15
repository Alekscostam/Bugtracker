package pl.kowalski.bugtracker.Dao.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.Interfaces.EmployeeDao;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {


    JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findEmployeeNamesByBugId(Long bugId) {
        String sql =
                "SELECT e.first_name, e.last_name " +
                "FROM employee e " +
                "JOIN bug_employees be on e.id = be.employees_id " +
                "JOIN bug b on b.id = be.bug_id " +
                "WHERE bug_id='"+bugId+"'";

        return jdbcTemplate.query(sql, (rs, rowNum) -> (rs.getString(1) + ", " + rs.getString(2)));
    }
}
