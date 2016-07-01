package no.sag.treg.data.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;

    @Column(name="date", nullable=false)
    private LocalDate date;

    @Column(name="type", columnDefinition = "enum('ATTEND','NOT_ATTEND', 'NOT_DECIDED')", nullable = false)
    @Enumerated(EnumType.STRING)
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
