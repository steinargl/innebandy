package no.sag.treg.view.dto;

import com.google.common.base.Preconditions;
import no.sag.treg.data.model.AttendanceType;

public class AttendanceTypeDto
{
    private final String id;
    private final String name;

    private AttendanceTypeDto(final ActivityDtoBuilder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static ActivityDtoBuilder builder()
    {
        return new ActivityDtoBuilder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static class ActivityDtoBuilder
    {
        private String id;
        private String name;

        public AttendanceTypeDto build()
        {
            Preconditions.checkNotNull(id, "id is required");
            Preconditions.checkNotNull(name, "name is required");

            return new AttendanceTypeDto(this);
        }

        public AttendanceTypeDto build(final AttendanceType attendanceType)
        {
            Preconditions.checkNotNull(attendanceType, "attendanceType is required");

            this.id = attendanceType.name();
            this.name = attendanceType.text();

            return new AttendanceTypeDto(this);
        }

        public ActivityDtoBuilder id(final String id)
        {
            this.id = id;
            return this;
        }

        public ActivityDtoBuilder name(final String name)
        {
            this.name = name;
            return this;
        }
    }
}
