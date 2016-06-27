package no.sag.treg.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "Attendance")
public class Attendance
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="email")
    private User user;

    @Column(name="date", nullable=false)
    private LocalDate date;

    @Column(columnDefinition = "enum('ATTEND','NOT_ATTEND','INJURED')", nullable=false)
    @Enumerated(EnumType.STRING)
    private AttendenceType attendenceType;

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

    public AttendenceType getAttendenceType() {
        return attendenceType;
    }

    public void setAttendenceType(AttendenceType attendenceType) {
        this.attendenceType = attendenceType;
    }
}
