package pl.kowalski.demo.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter

@RequiredArgsConstructor
public class Institution {
    @Id
    private Long id;
    private String code;
    private String name;
    private String description;

    @OneToMany
    List<Employee> employee = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
