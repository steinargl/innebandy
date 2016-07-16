package no.sag.innebandy.view.dto;

import com.google.common.base.Preconditions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class TrainingDto
{
    private final String status;
    private final UserDto currentUser;
    private final String formattedDate;
    private final String isoDate;
    private final List<UserDto> attendingList;
    private final List<UserDto> notAttendingList;
    private final List<UserDto> maybeAttendingList;
    private int limit;
    private int seasonPrice;
    private int monthlyPrice;
    private int dayPrice;
    private String datetime;
    private String datetime2;

    private TrainingDto(TrainingDtoBuilder builder)
    {
        this.status = builder.status;
        this.currentUser = builder.currentUser;
        this.formattedDate = builder.formattedDate;
        this.isoDate = builder.isoDate;
        this.attendingList = builder.attendingList;
        this.notAttendingList = builder.notAttendingList;
        this.maybeAttendingList = builder.maybeAttendingList;
        this.limit = builder.limit;
        this.seasonPrice = builder.seasonPrice;
        this.monthlyPrice = builder.monthlyPrice;
        this.dayPrice = builder.dayPrice;

        DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        datetime = ISO_DATE_FORMATTER.format(LocalDateTime.now());

        DateTimeFormatter ISO_DATE_FORMATTER2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.forLanguageTag("nb-NO"));
        datetime2 = ISO_DATE_FORMATTER2.format(LocalDateTime.now());

    }

    public String getStatus() {
        return status;
    }

    public UserDto getCurrentUser() {
        return currentUser;
    }

    public int getDistanceFromLimit()
    {
        return limit - attendingList.size();
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public String getIsoDate() {
        return isoDate;
    }

    public List<UserDto> getAttendingList() {
        return attendingList;
    }

    public List<UserDto> getNotAttendingList() {
        return notAttendingList;
    }

    public List<UserDto> getMaybeAttendingList() {
        return maybeAttendingList;
    }

    public int getLimit() {
        return limit;
    }

    public int getSeasonPrice() {
        return seasonPrice;
    }

    public int getMonthlyPrice() {
        return monthlyPrice;
    }

    public int getDayPrice() {
        return dayPrice;
    }


    public String getDatetime() {
        return datetime;
    }

    public String getDatetime2() {
        return datetime2;
    }

    public static TrainingDtoBuilder createBuilder()
    {
        return new TrainingDtoBuilder();
    }


    public static class TrainingDtoBuilder extends AbstractDtoBuilder
    {
        private static final DateTimeFormatter ISO_DATE_FORMATTER =
                DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.forLanguageTag("nb-NO"));
        private static final DateTimeFormatter DATE_FORMATTER =
                DateTimeFormatter.ofPattern("EEEE d. LLLL yyyy", Locale.forLanguageTag("nb-NO"));

        private String status;
        private UserDto currentUser;
        private String formattedDate;
        private String isoDate;
        private List<UserDto> attendingList;
        private List<UserDto> notAttendingList;
        private List<UserDto> maybeAttendingList;
        private Integer limit;
        private Integer seasonPrice;
        private Integer monthlyPrice;
        private Integer dayPrice;

        public TrainingDto build()
        {
            Preconditions.checkNotNull(status, "status is required");
            Preconditions.checkNotNull(currentUser, "currentUser is required");
            Preconditions.checkNotNull(formattedDate, "formattedDate is required");
            Preconditions.checkNotNull(attendingList, "attendingList is required");
            Preconditions.checkNotNull(notAttendingList, "notAttendingList is required");
            Preconditions.checkNotNull(maybeAttendingList, "maybeAttendingList is required");
            Preconditions.checkNotNull(limit, "limit is required");
            Preconditions.checkNotNull(seasonPrice, "seasonPrice is required");
            Preconditions.checkNotNull(monthlyPrice, "monthlyPrice is required");
            Preconditions.checkNotNull(dayPrice, "dayPrice is required");
            return new TrainingDto(this);
        }

        public TrainingDtoBuilder status(final TrainingStatus status) {
            this.status = status.name();
            return this;
        }

        public TrainingDtoBuilder date(final LocalDate date) {
            this.formattedDate = DATE_FORMATTER.format(date);
            this.isoDate = ISO_DATE_FORMATTER.format(date);
            return this;
        }

        public TrainingDtoBuilder attendingList(final List<UserDto> isAttendingList) {
            this.attendingList = isAttendingList;
            return this;
        }

        public TrainingDtoBuilder notAttendingList(final List<UserDto> isNotAttendingList) {
            this.notAttendingList = isNotAttendingList;
            return this;
        }

        public TrainingDtoBuilder maybeAttendingList(final List<UserDto> maybeAttendingList) {
            this.maybeAttendingList = maybeAttendingList;
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

        public TrainingDtoBuilder seasonPrice(final Integer price) {
            this.seasonPrice = price;
            return this;
        }

        public TrainingDtoBuilder monthlyPrice(final Integer price) {
            this.monthlyPrice = price;
            return this;
        }

        public TrainingDtoBuilder dayPrice(final Integer price) {
            this.dayPrice = price;
            return this;
        }
    }
}
