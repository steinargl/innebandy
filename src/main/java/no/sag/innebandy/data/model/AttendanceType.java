package no.sag.innebandy.data.model;

public enum AttendanceType
{
    ATTEND("Kommer"),
    NOT_ATTEND("Kommer ikke"),
    NOT_DECIDED("Vet ikke");

    private final String text;

    AttendanceType(final String text)
    {
        this.text = text;
    }

    public String text() {
        return text;
    }

}
