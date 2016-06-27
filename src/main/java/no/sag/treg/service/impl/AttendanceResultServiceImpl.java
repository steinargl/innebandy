package no.sag.treg.service.impl;

import no.sag.treg.data.model.User;
import no.sag.treg.data.repo.UserRepository;
import no.sag.treg.service.AttendanceResultService;
import no.sag.treg.view.dto.AttendanceResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Transactional
@Service
public class AttendanceResultServiceImpl implements AttendanceResultService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public AttendanceResultDto getAttendanceResult()
    {
        //final LocalDate previousTraining = getPreviousTraining();

        final LocalDate nextTraining = getNextTraining();
        final Iterable<User> users = userRepository.findAll();

        return AttendanceResultDto.createBuilder()
            .game(true)
            .gameText("THE GAME IS ON!")
            .info("Her kommer mer info")
            .attendingCount(1)
            .notAnsweredCount(1)
            .notAttendingCount(1)
            .limit(4)
            .build();
    }

  /*  private LocalDate getPreviousTraining()
    {
        LocalDate date = LocalDate.now();
        if (date.getDayOfWeek() == DayOfWeek.TUESDAY)
        {
            date = date.minusDays(1);
        }
        while (date.getDayOfWeek() != DayOfWeek.TUESDAY)
        {
            date = date.minusDays(1);
        }
        return date;
    }*/

    private LocalDate getNextTraining()
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