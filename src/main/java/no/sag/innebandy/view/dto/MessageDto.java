package no.sag.innebandy.view.dto;

public class MessageDto
{
    private final String text;
    private final String severity;

    public MessageDto(final String severity, final String text)
    {
        this.severity =severity;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getSeverity() {
        return severity;
    }
}
