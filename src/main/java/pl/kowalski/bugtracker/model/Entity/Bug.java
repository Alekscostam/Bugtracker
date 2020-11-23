package pl.kowalski.bugtracker.model.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.kowalski.bugtracker.model.Level;
import pl.kowalski.bugtracker.model.Progress;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter

@RequiredArgsConstructor
@Table( name = "bug")
public class Bug {

    public Bug(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date lastModify;

    private Level level;
    private String description;
    private Progress progress;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;

    public Date getLastModify() { return lastModify; }

    public void setLastModify(Date lastModify) { this.lastModify = lastModify; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployeeId() {
        return employee;
    }

    public void setEmployeeId(Employee employee) {
        this.employee = employee;
    }
}
