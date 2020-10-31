package pl.kowalski.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter

@RequiredArgsConstructor
public class Issue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Level level;
    private String description;
    private Progress progress;

    @ManyToMany
    List<Employee> employees = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project projectId;


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

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }


}
