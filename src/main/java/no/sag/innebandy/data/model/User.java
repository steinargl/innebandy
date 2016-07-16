package no.sag.innebandy.data.model;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String username;

    private String email;

    private boolean enabled;

    private List<Attendance> attendences = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Attendance> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<Attendance> attendences) {
        this.attendences = attendences;
    }
}
