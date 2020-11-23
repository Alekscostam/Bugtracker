package pl.kowalski.bugtracker.model.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@RequiredArgsConstructor
@Table( name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String institutionCode;



    @ManyToMany
    Set<Project> project;

    @OneToMany(mappedBy = "employee")
    Set<Bug> bug;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }


}
