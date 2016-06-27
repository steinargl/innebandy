package no.sag.treg.util;


import com.google.common.base.Preconditions;
import org.springframework.util.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class TimeUtil
{
    private static final String LANGUAGE_TAG = "no-NO";

    public static LocalDate getFirstDayOfWeek(LocalDate date)
    {
        Preconditions.checkNotNull(date, "date is null");
        return date.with(DayOfWeek.MONDAY);
    }

    public static LocalDate getFirstDayOfCurrentWeek()
    {
        return LocalDate.now(ZoneId.systemDefault()).with(DayOfWeek.MONDAY);
    }

    public static LocalDate getLastDayOfWeek(LocalDate date)
    {
        Preconditions.checkNotNull(date, "date is null");
        return date.now(ZoneId.systemDefault()).with(DayOfWeek.SUNDAY);
    }

    public static int getWeekNumber(LocalDate date)
    {
        Preconditions.checkNotNull(date, "date is null");
        return date.get(WeekFields.of(Locale.forLanguageTag("nb-NO")).weekOfWeekBasedYear());
    }

    public static boolean isFirstDayOfWeek(LocalDate date)
    {
        Preconditions.checkNotNull(date, "date is null");
        return date.getDayOfWeek().equals(WeekFields.of(Locale.forLanguageTag("nb-NO")).getFirstDayOfWeek());
    }

    public static String getMonth(LocalDate date)
    {
        Preconditions.checkNotNull(date, "date is null");
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("nb-NO"));
    }

    public static String getDay(LocalDate date)
    {
        final String weekDay = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag(LANGUAGE_TAG));
        return StringUtils.capitalize(weekDay);
    }
}
