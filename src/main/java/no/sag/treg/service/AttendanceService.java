package no.sag.treg.service;

import no.sag.treg.data.model.AttendanceType;
import no.sag.treg.view.dto.AttendanceDto;

public interface AttendanceService
{
    void createAttendance(String username, AttendanceType attendanceType);

    void updateAttendance(Long attendenceId, AttendanceType attendanceType);
}
