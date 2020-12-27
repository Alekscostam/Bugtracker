package pl.kowalski.bugtracker.Dao;


import java.util.List;


public interface EmployeeDao {

    List<String> findEmployeeNamesByBugId(Long bugId);
}
