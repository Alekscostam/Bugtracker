package pl.kowalski.demo.model;

import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Dto.BugDto;


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
