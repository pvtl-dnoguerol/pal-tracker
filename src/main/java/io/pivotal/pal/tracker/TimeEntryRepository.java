package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    List<TimeEntry> list();
    TimeEntry find(long id);
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry update(long id, TimeEntry timeEntry);
    void delete(long id);
}
