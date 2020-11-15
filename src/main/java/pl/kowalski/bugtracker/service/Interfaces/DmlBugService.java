package pl.kowalski.bugtracker.service.Interfaces;

import pl.kowalski.bugtracker.model.Entity.Bug;

public interface DmlBugService {
   void addNewBug(Bug bug);
}
