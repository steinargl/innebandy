package no.sag.treg.view.dto;

import com.google.common.base.Preconditions;
import no.sag.treg.data.model.Attendance;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AttendanceDto
{
    private Long id;
    private String date;
    private AttendanceTypeDto attendanceType;

    private AttendanceDto(AttendanceTypeDtoBuilder builder)
    {
        id = builder.id;
        attendanceType = builder.attendanceType;
        date = builder.date;
    }

    public static AttendanceTypeDtoBuilder builder()
    {
        return new AttendanceTypeDtoBuilder();
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public AttendanceTypeDto getAttendanceType() {
        return attendanceType;
    }

    public static class AttendanceTypeDtoBuilder
    {
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        private Long id;
        private String date;
        private AttendanceTypeDto attendanceType;

        public AttendanceDto build()
        {
            Preconditions.checkNotNull(id, "id is required");
            Preconditions.checkNotNull(date, "date is required");
            Preconditions.checkNotNull(attendanceType, "attendanceType is required");

            return new AttendanceDto(this);
        }

        public AttendanceDto build(Attendance attendance)
        {
            Preconditions.checkNotNull(attendance, "attendance is required");
            this.id = attendance.getId();
            this.date = DATE_FORMATTER.format(attendance.getDate());
            this.attendanceType = AttendanceTypeDto.builder().build(attendance.getAttendanceType());

            return new AttendanceDto(this);
        }

        public AttendanceTypeDtoBuilder id(final Long id)
        {
            this.id = id;
            return this;
        }

        public AttendanceTypeDtoBuilder date(final LocalDate date) {
            this.date = DATE_FORMATTER.format(date);
            return this;
        }

        public AttendanceTypeDtoBuilder attendanceType(final AttendanceTypeDto activityType)
        {
            this.attendanceType = activityType;
            return this;
        }
    }
}
