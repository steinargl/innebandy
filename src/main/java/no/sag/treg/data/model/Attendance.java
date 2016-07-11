package no.sag.treg.data.model;

import java.time.LocalDate;

public class Attendance
{
    private Long id;
    private User user;
    private LocalDate date;
    private AttendanceType attendanceType;

    public boolean attending()
    {
        return attendanceType == AttendanceType.ATTEND;
    }

    public boolean notAttending()
    {
        return attendanceType == AttendanceType.NOT_ATTEND;
    }

    public boolean maybeAttending()
    {
        return attendanceType == AttendanceType.NOT_DECIDED;
    }

    public boolean hasNotAnswerd()
    {
        return attendanceType == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }
}
