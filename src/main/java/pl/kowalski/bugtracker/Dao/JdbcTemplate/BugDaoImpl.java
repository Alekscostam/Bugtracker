package pl.kowalski.bugtracker.Dao.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.Interfaces.BugDao;
import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Level;
import pl.kowalski.bugtracker.Model.Progress;


@Component
public class BugDaoImpl implements BugDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public BugDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BugDto findAllInfoAboutBug(Long id) {

        String sql =
                "SELECT b.id, b.date, b.last_modify, b.description, b.level, b.progress, e.first_name, e.last_name,p.name " +
                "FROM bug b " +
                "JOIN employee e ON b.employee_id = e.id " +
                "JOIN project p ON b.project_id = p.id " +
                "WHERE b.id='"+id+"';";


        return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> {
            BugDto bugDto = new BugDto();
            bugDto.setId(rs.getLong(1));
            bugDto.setDate(rs.getDate(2));
            bugDto.setLastModify(rs.getDate(3));
            bugDto.setDescription(rs.getString(4));
            bugDto.setLevel(Level.values()[rs.getInt(5)]);
            bugDto.setProgress(Progress.values()[rs.getInt(6)]);
            bugDto.setEmployeeName(rs.getString(7)+" "+rs.getString(8));
            bugDto.setProjectName(rs.getString(9));
            return bugDto;
        });

    }


}
