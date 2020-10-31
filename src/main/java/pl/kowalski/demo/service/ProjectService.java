package pl.kowalski.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kowalski.demo.dao.ProjectDAO;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Service
public class ProjectService {



    ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }



    public void addNewProject(String date, String name, String description) {

        Date dataFormat = new Date(System.currentTimeMillis());

        try {
            dataFormat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Project project = new Project();
        project.setDate(dataFormat);
        project.setName(name);
        project.setDescription(description);

        projectDAO.save(project);

    }


}
