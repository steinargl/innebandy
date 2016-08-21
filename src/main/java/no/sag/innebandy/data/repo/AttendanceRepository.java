package no.sag.innebandy.data.repo;

import no.sag.innebandy.data.model.AttendanceType;

import java.time.LocalDate;

public interface AttendanceRepository
{
    void save(String email, LocalDate date, AttendanceType attendanceType);

    void update(Long id, AttendanceType attendanceType);
}
