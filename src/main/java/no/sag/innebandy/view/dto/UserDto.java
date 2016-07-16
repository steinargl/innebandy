package no.sag.innebandy.view.dto;


import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.Attendance;
import no.sag.innebandy.data.model.User;

public class UserDto
{
    private String username;
    private String email;
    private AttendanceDto attendance;

    private UserDto(UserDtoBuilder builder)
    {
        this.username = builder.username;
        this.email = builder.email;
        this.attendance = builder.attendance;
    }

    public static UserDtoBuilder builder()
    {
        return new UserDtoBuilder();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AttendanceDto getAttendance() {
        return attendance;
    }

    public static class UserDtoBuilder extends AbstractDtoBuilder
    {
        private String username;
        private String email;
        private AttendanceDto attendance;

        public UserDto build()
        {
            Preconditions.checkNotNull(username, "username is required");
            Preconditions.checkNotNull(email, "email is required");
            return new UserDto(this);
        }

        public UserDto build(final User user, final Attendance attendance)
        {
            Preconditions.checkNotNull(user, "user is required");
            Preconditions.checkNotNull(attendance, "attendance is required");

            this.username = user.getUsername();
            this.email = user.getEmail();
            this.attendance = createAttendanceDto(attendance);

            return new UserDto(this);
        }

        public UserDto build(final User user)
        {
            Preconditions.checkNotNull(user, "user is required");

            this.username = user.getUsername();
            this.email = user.getEmail();

            return new UserDto(this);
        }

        public UserDtoBuilder username(final String username)
        {
            this.username = username;
            return this;
        }

        public UserDtoBuilder email(final String email)
        {
            this.email = email;
            return this;
        }

        public UserDtoBuilder user(final AttendanceDto attendance)
        {
            this.attendance = attendance;
            return this;
        }
    }
}
