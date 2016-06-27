package no.sag.treg.view.dto;

import com.google.common.base.Preconditions;

public class AttendanceResultDto
{
    private boolean game;
    private String gameText;
    private String info;
    private int attendingCount;
    private int notAttendingCount;
    private int notAnsweredCount;
    private int limit;

    private AttendanceResultDto(AttendanceResultDtoBuilder builder)
    {
        this.game = builder.game;
        this.attendingCount = builder.attendingCount;
        this.notAttendingCount = builder.notAttendingCount;
        this.notAnsweredCount = builder.notAnsweredCount;
        this.limit = builder.limit;
    }

    public boolean isGame() {
        return game;
    }

    public int getAttendingCount() {
        return attendingCount;
    }

    public int getNotAttendingCount() {
        return notAttendingCount;
    }

    public int getNotAnsweredCount() {
        return notAnsweredCount;
    }

    public boolean getReachedLimit()
    {
        return attendingCount >= limit;
    }

    public int getMissingPlayersCount()
    {
        return limit - attendingCount;
    }

    public int getLimit() {
        return limit;
    }

    public static AttendanceResultDtoBuilder createBuilder()
    {
        return new AttendanceResultDtoBuilder();
    }

    public static class AttendanceResultDtoBuilder
    {
        private Boolean game;
        private String gameText;
        private String info;
        private Integer attendingCount;
        private Integer notAttendingCount;
        private Integer notAnsweredCount;
        private Integer limit;

        public AttendanceResultDto build()
        {
            Preconditions.checkNotNull(game, "game is required");
            Preconditions.checkNotNull(gameText, "gameText is required");
            Preconditions.checkNotNull(attendingCount, "attendingCount is required");
            Preconditions.checkNotNull(notAttendingCount, "notAttendingCount is required");
            Preconditions.checkNotNull(notAnsweredCount, "notAnsweredCount is required");
            Preconditions.checkNotNull(limit, "limit is required");
            return new AttendanceResultDto(this);
        }

        public AttendanceResultDtoBuilder game(final Boolean game) {
            this.game = game;
            return this;
        }

        public AttendanceResultDtoBuilder gameText(final String gameText) {
            this.gameText = gameText;
            return this;
        }

        public AttendanceResultDtoBuilder info(final String info) {
            this.info = info;
            return this;
        }

        public AttendanceResultDtoBuilder attendingCount(final Integer attendingCount) {
            this.attendingCount = attendingCount;
            return this;
        }

        public AttendanceResultDtoBuilder notAttendingCount(final Integer notAttendingCount) {
            this.notAttendingCount = notAttendingCount;
            return this;
        }

        public AttendanceResultDtoBuilder notAnsweredCount(final Integer notAnsweredCount) {
            this.notAnsweredCount = notAnsweredCount;
            return this;
        }

        public AttendanceResultDtoBuilder limit(final Integer limit) {
            this.limit = limit;
            return this;
        }
    }
}
