package no.sag.treg.view.dto;

import com.google.common.base.Preconditions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TrainingDto
{
    private final UserDto currentUser;
    private final String date;
    private final boolean training;
    private final List<UserDto> isAttendingList;
    private final List<UserDto> isNotAttendingList;
    private final List<UserDto> hasNotAnsweredList;
    private int limit;

    private TrainingDto(TrainingDtoBuilder builder)
    {
        this.currentUser = builder.currentUser;
        this.date = builder.date;
        this.training = builder.training;
        this.isAttendingList = builder.isAttendingList;
        this.isNotAttendingList = builder.isNotAttendingList;
        this.hasNotAnsweredList = builder.hasNotAnsweredList;
        this.limit = builder.limit;
    }

    public UserDto getCurrentUser() {
        return currentUser;
    }

    public int getDistanceFromLimit()
    {
        return limit - isAttendingList.size();
    }

    public String getDate() {
        return date;
    }

    public boolean isTraining() {
        return training;
    }

    public List<UserDto> getIsAttendingList() {
        return isAttendingList;
    }

    public List<UserDto> getIsNotAttendingList() {
        return isNotAttendingList;
    }

    public List<UserDto> getHasNotAnsweredList() {
        return hasNotAnsweredList;
    }

    public int getLimit() {
        return limit;
    }

    public static TrainingDtoBuilder createBuilder()
    {
        return new TrainingDtoBuilder();
    }

    public static class TrainingDtoBuilder extends AbstractDtoBuilder
    {
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEEE d. LLLL yyyy");

        private UserDto currentUser;
        private String date;
        private boolean training;
        private List<UserDto> isAttendingList;
        private List<UserDto> isNotAttendingList;
        private List<UserDto> hasNotAnsweredList;
        private Integer limit;

        public TrainingDto build() {
            Preconditions.checkNotNull(currentUser, "currentUser is required");
            Preconditions.checkNotNull(date, "date is required");
            Preconditions.checkNotNull(isAttendingList, "isAttendingList is required");
            Preconditions.checkNotNull(isNotAttendingList, "isNotAttendingList is required");
            Preconditions.checkNotNull(hasNotAnsweredList, "hasNotAnsweredList is required");
            Preconditions.checkNotNull(limit, "limit is required");

            training = true;
            final LocalDateTime oneHourBeforeTraining = LocalDateTime.now().withHour(19);
            if (LocalDateTime.now().isAfter(oneHourBeforeTraining) && isAttendingList.size() < limit) {
                training = false;
            }

            return new TrainingDto(this);
        }

        public TrainingDtoBuilder date(final LocalDate date) {
            this.date = DATE_FORMATTER.format(date);
            return this;
        }

        public TrainingDtoBuilder isAttendingList(final List<UserDto> isAttendingList) {
            this.isAttendingList = isAttendingList;
            return this;
        }

        public TrainingDtoBuilder isNotAttendingList(final List<UserDto> isNotAttendingList) {
            this.isNotAttendingList = isNotAttendingList;
            return this;
        }

        public TrainingDtoBuilder hasNotAnsweredList(final List<UserDto> hasNotAnsweredList) {
            this.hasNotAnsweredList = hasNotAnsweredList;
            return this;
        }

        public TrainingDtoBuilder limit(final Integer limit) {
            this.limit = limit;
            return this;
        }

        public TrainingDtoBuilder currentUser(final UserDto user) {
            this.currentUser = user;
            return this;
        }
    }
}
