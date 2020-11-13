package pl.kowalski.demo.model.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter

@RequiredArgsConstructor
public class Bug {

    public Bug(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Level level;
    private String description;
    private Progress progress;

    @ManyToMany
    Set<Employee> employees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="employee_id", nullable = false)
    private Employee employee;



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
