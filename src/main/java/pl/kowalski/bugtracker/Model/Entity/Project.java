package pl.kowalski.bugtracker.Model.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private String institutionCode;

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* @ManyToMany
    Set<Employee> employee;*/

    @OneToMany(mappedBy="project")
    Set<Bug> bugs;

}
