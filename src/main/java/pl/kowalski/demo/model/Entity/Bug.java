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
    private Long reportedId;

    public Progress getProgress() {
        return progress;
    }

    public Long getReportedId() {
        return reportedId;
    }

    public void setReportedId(Long reportedId) {
        this.reportedId = reportedId;
    }

    @ManyToMany
    Set<Employee> employee;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( nullable = false)
    private Project project;


    public void setDate(Date date) {
        this.date = date;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public void setProject(Project projectId) {
        this.project = projectId;
    }


}
