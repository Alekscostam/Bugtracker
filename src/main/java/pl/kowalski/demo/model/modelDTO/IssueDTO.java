package pl.kowalski.demo.model.modelDTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;
import pl.kowalski.demo.model.Project;

import java.util.Date;


@Getter
@Setter
public class IssueDTO {

    private String date;
    private Level level;
    private String description;
    private Progress progress;
    private String projectName;

}
