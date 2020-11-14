package pl.kowalski.bugtracker.model.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@RequiredArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstitution(Institution institutionId) {
        this.institution = institutionId;
    }

    @ManyToMany
    @JoinTable
    Set<Bug> bugs;


    @ManyToMany
    Set<Project> project;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="institution_id", nullable = false)
    private Institution institution;

    @OneToMany(mappedBy="employee")
    Set<Bug> bug;

}
