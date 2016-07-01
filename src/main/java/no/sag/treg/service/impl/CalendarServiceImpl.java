package no.sag.treg.service.impl;

import no.sag.treg.service.CalendarService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CalendarServiceImpl implements CalendarService
{
    @Override
    public LocalDate nextTrainingDate()
    {
        LocalDate date = LocalDate.now();

        if (date.getDayOfWeek() == DayOfWeek.TUESDAY) {
            return date;
        }

        while (date.getDayOfWeek() != DayOfWeek.TUESDAY)
        {
            date = date.plusDays(1);
        }

        return date;
    }
}
