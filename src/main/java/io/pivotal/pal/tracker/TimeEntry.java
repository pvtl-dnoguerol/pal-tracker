package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
        this(123L, 456L, LocalDate.parse("2017-01-08"), 8);
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this(-1, projectId, userId, date, hours);
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TimeEntry) {
            TimeEntry e = (TimeEntry)o;

            return
                e.id == id &&
                e.projectId == projectId &&
                e.userId == userId &&
                ((e.date == null && date == null) || (e.date != null && e.date.equals(date))) &&
                e.hours == hours;
        } else {
            return false;
        }
    }
}
