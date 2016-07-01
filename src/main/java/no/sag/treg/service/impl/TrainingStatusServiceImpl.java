package no.sag.treg.service.impl;

import no.sag.treg.service.CalendarService;
import no.sag.treg.service.TrainingStatusService;
import no.sag.treg.view.dto.TrainingStatus;
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
        else if (LocalDate.now().equals(nextTrainingDate)) {
            return TrainingStatus.MAYBE_ON_TRAINING_DAY;
        }
        else if (LocalDate.now().isBefore(nextTrainingDate)) {
            return TrainingStatus.MAYBE_BEFORE_TRAINING_DAY;
        }
        else {
            throw new IllegalStateException(String.format("Invalid training state. Time=%s. Limit=%s.",
                LocalDateTime.now().toString(), limit));
        }
    }
}
