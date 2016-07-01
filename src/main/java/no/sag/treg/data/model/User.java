package no.sag.treg.data.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(mappedBy="user")
    private Set<Role> roles;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy="user")
    private Set<Attendance> attendences;

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

    public Set<Attendance> getAttendences() {
        return attendences;
    }

    public void setAttendences(Set<Attendance> attendences) {
        this.attendences = attendences;
    }
}
