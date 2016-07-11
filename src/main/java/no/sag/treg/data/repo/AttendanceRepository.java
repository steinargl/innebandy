package no.sag.treg.data.repo;

import no.sag.treg.data.model.AttendanceType;

import java.time.LocalDate;

public interface AttendanceRepository
{
    void save(String username, LocalDate date, AttendanceType attendanceType);

    void update(Long id, AttendanceType attendanceType);
}
