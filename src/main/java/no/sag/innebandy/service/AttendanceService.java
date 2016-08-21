package no.sag.innebandy.service;

import no.sag.innebandy.data.model.AttendanceType;

public interface AttendanceService
{
    void createAttendance(String email, AttendanceType attendanceType);

    void updateAttendance(Long attendenceId, AttendanceType attendanceType);
}
