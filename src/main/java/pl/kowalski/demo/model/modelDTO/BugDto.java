package pl.kowalski.demo.model.modelDTO;

import lombok.Getter;
import lombok.Setter;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;


@Getter
@Setter
public class BugDto {

    private String date;
    private Level level;
    private String description;
    private Progress progress;
    private String projectName;

}
