package no.sag.treg.service;

import no.sag.treg.data.model.AttendanceType;
import no.sag.treg.view.dto.AttendanceDto;

public interface AttendanceService
{
    AttendanceDto createAttendance(String username, AttendanceType attendanceType);

    AttendanceDto updateAttendance(Long attendenceId, AttendanceType attendanceType);
}
