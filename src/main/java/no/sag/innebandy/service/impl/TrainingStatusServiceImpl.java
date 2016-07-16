package no.sag.innebandy.service.impl;

import no.sag.innebandy.service.CalendarService;
import no.sag.innebandy.service.TrainingStatusService;
import no.sag.innebandy.view.dto.TrainingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class TrainingStatusServiceImpl implements TrainingStatusService
{
    @Autowired
    private CalendarService calendarService;

    @Override
    public TrainingStatus getStatus(int isAttendingCount, int limit)
    {
        final LocalDate nextTrainingDate = calendarService.nextTrainingDate();

        final LocalDateTime oneHourBeforeTraining = LocalDateTime.of(nextTrainingDate, LocalTime.of(19, 0));

        if (LocalDateTime.now().isAfter(oneHourBeforeTraining) && isAttendingCount < limit) {
            return TrainingStatus.NO;
        }
        else if (isAttendingCount >= limit) {
            return TrainingStatus.YES;
        }
        else {
            return TrainingStatus.MAYBE;
        }
    }
}
