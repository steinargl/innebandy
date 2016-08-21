package no.sag.innebandy.view.dto;


import com.google.common.base.Preconditions;
import no.sag.innebandy.data.model.Attendance;
import no.sag.innebandy.data.model.User;

public class UserDto
{
    private final String email;
    private final String name;
    private final String phone;
    private final AttendanceDto attendance;
    private final UserValidationResult validationResult;

    private UserDto(UserDtoBuilder builder)
    {
        this.email = builder.email;
        this.name = builder.name;
        this.phone = builder.phone;
        this.attendance = builder.attendance;
        this.validationResult = builder.validationResult;
    }

    public static UserDtoBuilder builder()
    {
        return new UserDtoBuilder();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public AttendanceDto getAttendance() {
        return attendance;
    }

    public UserValidationResult getValidationResult() {
        return validationResult;
    }

    public static class UserDtoBuilder extends AbstractDtoBuilder
    {
        private String email;
        private String name;
        private String phone;
        private AttendanceDto attendance;
        private UserValidationResult validationResult;

        public UserDto build()
        {
            Preconditions.checkNotNull(email, "email is required");
            Preconditions.checkNotNull(name, "name is required");
            Preconditions.checkNotNull(phone, "phone is required");
            return new UserDto(this);
        }

        public UserDto build(final User user, final Attendance attendance)
        {
            Preconditions.checkNotNull(user, "user is required");
            Preconditions.checkNotNull(attendance, "attendance is required");

            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.attendance = createAttendanceDto(attendance);
            return new UserDto(this);
        }

        public UserDto build(final User user)
        {
            Preconditions.checkNotNull(user, "user is required");

            this.email = user.getEmail();
            this.name = user.getName();
            this.phone = user.getPhone();
            return new UserDto(this);
        }

        public UserDtoBuilder email(final String email)
        {
            this.email = email;
            return this;
        }

        public UserDtoBuilder name(final String name)
        {
            this.name = name;
            return this;
        }

        public UserDtoBuilder phone(final String phone)
        {
            this.phone = phone;
            return this;
        }

        public UserDtoBuilder user(final AttendanceDto attendance)
        {
            this.attendance = attendance;
            return this;
        }

        public UserDtoBuilder validationResult(UserValidationResult validationResult)
        {
            this.validationResult = validationResult;
            return this;
        }
    }
}
