package no.sag.treg.data.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class Role
{
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name="username")
    private User user;


    @Column(name="role", columnDefinition = "enum('ATTEND','NOT_ATTEND')", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
