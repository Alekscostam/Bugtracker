package pl.kowalski.bugtracker.Service.Post;

import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;

import java.security.Principal;

public interface PostBugService {
    boolean postBug(Bug bug, Principal principal);
}
