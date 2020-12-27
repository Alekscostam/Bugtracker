package pl.kowalski.bugtracker.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {


    private final  JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findEmployeeNamesByBugId(Long bugId) {
        String sql =
                "SELECT e.first_name, e.last_name " +
                "FROM employee e " +
                "JOIN bug_employee be ON e.id = be.employee_id " +
                "JOIN bug b ON b.id = be.bug_id " +
                "WHERE bug_id='"+bugId+"'";

        return jdbcTemplate.query(sql, (rs, rowNum) -> (rs.getString(1) +" "+ rs.getString(2)));
    }
}
