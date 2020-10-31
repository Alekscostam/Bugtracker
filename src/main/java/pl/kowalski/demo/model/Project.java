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
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy="projectId")
    List<Issue> issues = new ArrayList<>();

}
