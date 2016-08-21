package no.sag.innebandy.data.model;

import no.sag.innebandy.view.dto.UserDto;

import java.security.cert.PKIXRevocationChecker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class User
{
    private String email;
    private String name;
    private String phone;
    private boolean enabled;

    private List<Attendance> attendences = new ArrayList<>();

    public Optional<Attendance> getAttendance(final Predicate<Attendance> predicate)
    {
        return attendences.stream().filter(predicate).findFirst();
    }

    public boolean hasNotAnswerd(final LocalDate nextTrainingDate)
    {
        return !attendences.stream().filter(a -> a.getDate().equals(nextTrainingDate)).findFirst().isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return email.equals(user.email);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
