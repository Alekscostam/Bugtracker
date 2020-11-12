package pl.kowalski.demo;

import pl.kowalski.demo.model.Entity.Bug;
import pl.kowalski.demo.model.Entity.Dto.BugDto;
import pl.kowalski.demo.model.Level;
import pl.kowalski.demo.model.Progress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ObjectMapper {

    private ObjectMapper() {
    }

    public static List<BugDto> mapBugToBugDto(List<Bug> bugList) {
        List<BugDto> bugDtos = new ArrayList<>();
        bugList.forEach(bug ->

                {
                    BugDto bugDto = new BugDto();
                    bugDto.setDate(bug.getDate());
                    bugDto.setDescription(bug.getDescription());
                    bugDto.setId(bug.getId());
                    bugDto.setLevel(bug.getLevel());
                    bugDto.setReportedId(bug.getReportedId());
                    bugDto.setProgress(bug.getProgress());

                    bugDtos.add(bugDto);
                }
        );

        return bugDtos;
    }


}
