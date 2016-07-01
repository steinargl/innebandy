package no.sag.treg.service.impl;

import com.google.common.base.Preconditions;
import no.sag.treg.data.model.Attendance;
import no.sag.treg.data.model.User;
import no.sag.treg.data.repo.AttendanceRepository;
import no.sag.treg.data.repo.UserRepository;
import no.sag.treg.service.CalendarService;
import no.sag.treg.service.TrainingService;
import no.sag.treg.service.TrainingStatusService;
import no.sag.treg.view.dto.TrainingDto;
import no.sag.treg.view.dto.TrainingStatus;
import no.sag.treg.view.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Transactional
@Service
public class TrainingServiceImpl implements TrainingService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private TrainingStatusService trainingStatusService;

    @Autowired
    private CalendarService  calendarService;


    @Override
    public TrainingDto getTraining(final String username)
    {
        Preconditions.checkNotNull(username, "username is required");

        final LocalDate nextTrainingDate = calendarService.nextTrainingDate();

        final Set<User> users = userRepository.findByEnabled(true);

        final int traingTimes = 52 - 33 + 1;
        final int dayPrice = (int)Math.ceil((180.0 * 2.0) / users.size());
        final int seasonPrice = (int)Math.ceil((traingTimes * 180.0 * 2.0) / users.size());
        final int monthlyPrice =  (int)Math.ceil(seasonPrice / 5.0);

        final int limit = 4;//TODO: get value from settings

        final UserDto currentUser = getCurrentUser(username, nextTrainingDate, users);
        final List<UserDto> attendingList = createList(users, a -> a.getDate().equals(nextTrainingDate) && a.attending());
        final List<UserDto> notAttendingList = createList(users, a -> a.getDate().equals(nextTrainingDate) && a.notAttending());
        final List<UserDto> maybeAttendingList = createList(users, a -> a.getDate().equals(nextTrainingDate) && a.maybeAttending());

        maybeAttendingList.addAll(users.stream()
            .filter(u -> u.getAttendences().isEmpty())
            .map(u->UserDto.builder().build(u))
            .collect(Collectors.toList())
        );

        final TrainingStatus trainingStatus = trainingStatusService.getStatus(attendingList.size(), limit);

        return TrainingDto.createBuilder()
            .status(trainingStatus)
            .currentUser(currentUser)
            .date(nextTrainingDate)
            .attendingList(attendingList)
            .notAttendingList(notAttendingList)
            .maybeAttendingList(maybeAttendingList)
            .limit(limit)
            .dayPrice(dayPrice)
            .seasonPrice(seasonPrice)
            .monthlyPrice(monthlyPrice)
            .build();
    }

    private List<UserDto> createList(final Set<User> users, final Predicate<Attendance> predicate)
    {
        final List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            final Optional<Attendance> attendance = user.getAttendences().stream().filter(predicate).findFirst();
            if (attendance.isPresent()) {
                userDtos.add(UserDto.builder().build(user, attendance.get()));
            }
        }
        return userDtos;
    }

    private UserDto getCurrentUser(final String username, final LocalDate nextTrainingDate, final Set<User> users)
    {
        final Optional<User> currentUser = users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
        if (!currentUser.isPresent()) {
            throw new IllegalStateException(String.format("Cannot find user with username=%s"));
        }

        final Optional<Attendance> attendance =
            currentUser.get().getAttendences().stream()
                .filter(a -> a.getDate().equals(nextTrainingDate))
                .findFirst();

        if (attendance.isPresent()) {
            return UserDto.builder().build(currentUser.get(), attendance.get());
        }

        return UserDto.builder().build(currentUser.get());
    }
}