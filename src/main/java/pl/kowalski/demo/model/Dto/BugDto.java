package pl.kowalski.demo.model.Dto;

import pl.kowalski.demo.model.Entity.Employee;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;

import java.util.Date;
import java.util.List;

public class BugDto {

    private Long id;
    private Date date;
    private Level level;
    private String description;
    private Progress progress;
    private String employyeName;
    private String projectName;

    public String getEmployyeName() {
        return employyeName;
    }

    public void setEmployyeName(String employyeName) {
        this.employyeName = employyeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

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




}