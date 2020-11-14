package pl.kowalski.demo.Dao.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.kowalski.demo.model.Dto.BugDto;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;


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
                "SELECT b.id, b.date, b.description, b.level, b.progress,e.first_name,p.name " +
                "FROM bug b " +
                "JOIN employee e on b.employee_id = e.id " +
                "JOIN project p on b.project_id = p.id " +
                "WHERE b.id='"+id+"';";


        return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> {
            BugDto bugDto = new BugDto();
            bugDto.setId(rs.getLong(1));
            bugDto.setDate(rs.getDate(2));
            bugDto.setDescription(rs.getString(3));
            bugDto.setLevel(Level.values()[rs.getInt(4)]);
            bugDto.setProgress(Progress.values()[rs.getInt(5)]);
            bugDto.setEmployeeName(rs.getString(6));
            bugDto.setProjectName(rs.getString(7));
            return bugDto;
        });

    }


}
