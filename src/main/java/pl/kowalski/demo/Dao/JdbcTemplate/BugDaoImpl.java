package pl.kowalski.demo.Dao.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BugDaoImpl implements BugDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public BugDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BugDto findAllInfoAboutBug(Long id) {

        String sql = "SELECT b.id, b.date, b.description, b.level, b.progress,e.first_name,p.name " +
                "FROM bug b " +
                "JOIN employee e on b.employee_id = e.id " +
                "JOIN project p on b.project_id = p.id " +
                "WHERE b.id=1;";

        return (BugDto) jdbcTemplate.queryForObject(sql, (RowMapper<Object>) (rs, rowNum) -> {
            BugDto bugDto1 = new BugDto();
            bugDto1.setId(rs.getLong(1));
            bugDto1.setDate(rs.getDate(2));
            bugDto1.setDescription(rs.getString(3));
            bugDto1.setLevel(Level.values()[rs.getInt(4)]);
            bugDto1.setProgress(Progress.values()[rs.getInt(5)]);
            bugDto1.setEmployyeName(rs.getString(6));
            bugDto1.setProjectName(rs.getString(7));
            return bugDto1;
        });

    }
}
