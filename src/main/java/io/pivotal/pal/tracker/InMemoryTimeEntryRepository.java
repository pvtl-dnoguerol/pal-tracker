package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long,TimeEntry> entryMap = new HashMap<>();
    private int nextId = 1;

    public List<TimeEntry> list() {
        return new ArrayList(entryMap.values());
    }

    public TimeEntry find(long id) {
        return entryMap.get(id);
    }

    public TimeEntry create(TimeEntry te) {
        TimeEntry nte = new TimeEntry(nextId++, te.getProjectId(), te.getUserId(), te.getDate(), te.getHours());
        entryMap.put(nte.getId(), nte);
        return nte;
    }

    public TimeEntry update(long id, TimeEntry te) {
        if (entryMap.containsKey(id)) {
            TimeEntry nte = new TimeEntry(id, te.getProjectId(), te.getUserId(), te.getDate(), te.getHours());
            entryMap.put(id, nte);
            return nte;
        } else {
            return null;
        }
    }

    public void delete(long id) {
        entryMap.remove(id);
    }
}
