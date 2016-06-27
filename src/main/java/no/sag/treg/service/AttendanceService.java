package no.sag.treg.service;

import no.sag.treg.view.dto.AttendanceDto;

public interface AttendanceService
{
    AttendanceDto addAttendance(String attendenceTypeId);

    AttendanceDto updateAttendance(final String attendenceId, final String attendenceTypeId);
}
