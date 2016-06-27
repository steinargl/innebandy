package no.sag.treg.data.model;

public enum AttendenceType
{
    ATTEND("Kommer"),
    NOT_ATTEND("Feiger ut"),
    INJURED("Skadet");

    private final String text;

    AttendenceType(final String text)
    {
        this.text = text;
    }

    public String text() {
        return text;
    }

    public static AttendenceType fromText(final String text)
    {
        switch (text)
        {
            case "Kommer": return ATTEND;
            case "Feiger ut": return NOT_ATTEND;
            case "Skadet": return INJURED;
            default: throw new IllegalStateException("Unknown attendence type text: " + text);
        }
    }
}
