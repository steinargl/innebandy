package no.sag.treg.service;


import java.time.DayOfWeek;
import java.time.LocalDate;

public class AbstractService
{
    protected LocalDate nextTrainingDate()
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
