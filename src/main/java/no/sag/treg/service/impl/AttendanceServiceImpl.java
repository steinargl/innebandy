package no.sag.treg.service.impl;

import no.sag.treg.data.model.AttendanceType;
import no.sag.treg.data.repo.AttendanceRepository;
import no.sag.treg.service.AttendanceService;
import no.sag.treg.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class AttendanceServiceImpl implements AttendanceService
{
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private CalendarService calendarService;


    @Override
    @Transactional
    public void createAttendance(final String username, final AttendanceType attendanceType)
    {
        checkArgument(!isEmpty(username), "username is required");
        checkArgument(!isEmpty(attendanceType), "attendanceType is required");

        final LocalDate nextTrainingDate = calendarService.nextTrainingDate();
        attendanceRepository.save(username, nextTrainingDate, attendanceType);
    }

    @Override
    @Transactional
    public void updateAttendance(final Long attendenceId, final AttendanceType attendanceType)
    {
        checkArgument(!isEmpty(attendenceId), "attendenceId is required");
        checkArgument(!isEmpty(attendanceType), "attendanceType is required");

        attendanceRepository.update(attendenceId, attendanceType);
    }
}
