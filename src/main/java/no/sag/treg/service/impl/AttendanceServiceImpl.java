package no.sag.treg.service.impl;

import com.google.common.base.Preconditions;
import no.sag.treg.data.model.Attendance;
import no.sag.treg.data.model.AttendenceType;
import no.sag.treg.data.model.User;
import no.sag.treg.data.repo.AttendanceRepository;
import no.sag.treg.data.repo.UserRepository;
import no.sag.treg.service.AttendanceService;
import no.sag.treg.view.dto.AttendanceDto;
import no.sag.treg.view.dto.AttendanceTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Transactional
@Service
public class AttendanceServiceImpl implements AttendanceService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public AttendanceDto addAttendance(final String attendenceTypeId)
    {
        final User user = userRepository.findByEmail("sglamseter@gmail.com");

        final Attendance attendance = new Attendance();
        attendance.setAttendenceType(AttendenceType.valueOf(attendenceTypeId));
        attendance.setUser(user);
        attendance.setDate(nextTrainingDate());

        attendanceRepository.save(attendance);

        user.getAttendences().add(attendance);

        return AttendanceDto.createBuilder()
            .id(attendance.getId())
            .date(nextTrainingDate())
            .attendanceType(AttendanceTypeDto.createBuilder()
                .id(attendance.getAttendenceType().name())
                .name(attendance.getAttendenceType().text())
                .build())
            .build();
    }

    @Override
    public AttendanceDto updateAttendance(final String attendenceId, final String attendenceTypeId)
    {
        Preconditions.checkNotNull(attendenceId, "attendenceId is required");
        Preconditions.checkNotNull(attendenceTypeId, "attendenceTypeId is required");

        final Attendance attendance = attendanceRepository.findOne(attendenceId);
        if (attendance == null)
        {
            throw new IllegalStateException("Attendance with id=" + attendenceId + " doesn't exist");
        }

        attendance.setAttendenceType(AttendenceType.valueOf(attendenceTypeId));

        attendanceRepository.save(attendance);

        return AttendanceDto.createBuilder()
            .id(attendance.getId())
            .date(nextTrainingDate())
            .attendanceType(AttendanceTypeDto.createBuilder()
                .id(attendance.getAttendenceType().name())
                .name(attendance.getAttendenceType().text())
                .build())
            .build();
    }

    private LocalDate nextTrainingDate()
    {
        LocalDate date = LocalDate.now();
        if (date.getDayOfWeek() == DayOfWeek.TUESDAY)
        {
            return date;
        }
        while (date.getDayOfWeek() != DayOfWeek.TUESDAY)
        {
            date = date.plusDays(1);
        }
        return date;
    }
}
