package no.sag.treg.service.impl;

import no.sag.treg.data.model.Attendance;
import no.sag.treg.data.model.AttendanceType;
import no.sag.treg.data.model.User;
import no.sag.treg.data.repo.AttendanceRepository;
import no.sag.treg.data.repo.UserRepository;
import no.sag.treg.service.AttendanceService;
import no.sag.treg.service.CalendarService;
import no.sag.treg.service.TrainingService;
import no.sag.treg.view.dto.AttendanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkArgument;
import static org.springframework.util.StringUtils.isEmpty;

@Transactional
@Service
public class AttendanceServiceImpl implements AttendanceService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private CalendarService calendarService;


    @Override
    public AttendanceDto createAttendance(final String username, final AttendanceType attendanceType)
    {
        checkArgument(!isEmpty(username), "username is required");
        checkArgument(!isEmpty(attendanceType), "attendanceType is required");

        final User user = userRepository.findByUsernameAndEnabled(username, true);
        if (user == null) {
            throw new IllegalStateException(String.format("Cannot find user with username=%s", username));
        }

        Attendance attendance = createAttendance(user, attendanceType);
        attendance = attendanceRepository.save(attendance);

        user.getAttendences().add(attendance);

        return AttendanceDto.builder().build(attendance);
    }

    private Attendance createAttendance(final User user, final AttendanceType attendenceType)
    {
        final Attendance attendance = new Attendance();
        attendance.setAttendanceType(attendenceType);
        attendance.setUser(user);
        attendance.setDate(calendarService.nextTrainingDate());
        return attendance;
    }

    @Override
    public AttendanceDto updateAttendance(final Long attendenceId, final AttendanceType attendanceType)
    {
        checkArgument(!isEmpty(attendenceId), "attendenceId is required");
        checkArgument(!isEmpty(attendanceType), "attendanceType is required");

        Attendance attendance = attendanceRepository.findOne(attendenceId);
        if (attendance == null) {
            throw new IllegalStateException("Cannot find attendance with id=" + attendenceId);
        }

        attendance.setAttendanceType(attendanceType);
        attendance = attendanceRepository.save(attendance);

        return AttendanceDto.builder().build(attendance);
    }
}
