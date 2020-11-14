package pl.kowalski.bugtracker.model;

import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Dto.BugDto;


public class ObjectMapper {

    private ObjectMapper() {
    }

    public static BugDto mapBugToBugDto(Bug bug) {

        BugDto bugDto = new BugDto();
        bugDto.setDate(bug.getDate());
        bugDto.setDescription(bug.getDescription());
        bugDto.setId(bug.getId());
        bugDto.setLevel(bug.getLevel());
        bugDto.setProgress(bug.getProgress());

        return bugDto;
    }

}
