package no.sag.treg.data.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class User
{
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="user")
    private Set<Attendance> attendences;

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

    public Set<Attendance> getAttendences() {
        return attendences;
    }

    public void setAttendences(Set<Attendance> attendences) {
        this.attendences = attendences;
    }
}
