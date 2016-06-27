package no.sag.treg.view.dto;

public class TimeDto
{
    private final int minutes;
    private final double hours;
    private final double days;
    private final DaysHoursMinutes daysHoursMinutes;
    private final HoursMinutes hoursMinutes;
    private boolean negative;
    private final String text;

    private TimeDto(final TimeDtoBuilder builder)
    {
        if (builder.minutes < 0) {
            negative = true;
        }
        this.hours = builder.minutes / 60.0;
        this.days = builder.minutes / 60.0 / 7.5;
        this.minutes = builder.minutes;
        this.daysHoursMinutes = new DaysHoursMinutes(builder.minutes);
        this.hoursMinutes = new HoursMinutes(builder.minutes);
        this.text = builder.text;
    }

    public static TimeDtoBuilder createBuilder()
    {
        return new TimeDtoBuilder();
    }

    public int getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    public double getDays() {
        return days;
    }

    public DaysHoursMinutes getDaysHoursMinutes() {
        return daysHoursMinutes;
    }

    public HoursMinutes getHoursMinutes() {
        return hoursMinutes;
    }

    public boolean isNegative() {
        return negative;
    }

    public String getText() {
        return text;
    }

    public static class TimeDtoBuilder
    {
        private int minutes;
        private String text;

        public TimeDto build()
        {
            return new TimeDto(this);
        }

        public TimeDtoBuilder minutes(int minutes)
        {
            this.minutes = minutes;
            return this;
        }

        public TimeDtoBuilder text(String text)
        {
            this.text = text;
            return this;
        }
    }
}

class HoursMinutes
{
    private final int hours;
    private final int minutes;

    public HoursMinutes(int minutes)
    {
        this.hours = (int)Math.floor(Math.abs(minutes)/60.0);
        this.minutes = (int)Math.floor(((Math.abs(minutes)/60.0)-hours)*60.0);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}

class DaysHoursMinutes
{
    private final int days;
    private final int hours;
    private final int minutes;

    public DaysHoursMinutes(int minutes)
    {
        this.days = (int)Math.floor(Math.abs(minutes)/60.0/7.5);
        this.hours = (int)Math.floor((Math.abs(minutes)/60.0/7.5-days)*7.5);
        this.minutes = (int)Math.floor((((Math.abs(minutes)/60.0/7.5-days)*7.5)-hours)*60.0);
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
