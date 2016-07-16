package no.sag.innebandy.view.dto;

import no.sag.innebandy.data.model.Attendance;

public class AbstractDtoBuilder
{
    protected AttendanceDto createAttendanceDto(final Attendance attendance)
    {
        return AttendanceDto.builder()
            .id(attendance.getId())
            .date(attendance.getDate())
            .attendanceType(AttendanceTypeDto.builder()
                .id(attendance.getAttendanceType().name())
                .name(attendance.getAttendanceType().text())
                .build()
            )
            .build();
    }
}
