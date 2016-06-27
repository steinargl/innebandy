$(document).ready(function(){

    Handlebars.partials = Handlebars.templates;




    Handlebars.registerHelper('severity', function(attendanceResult) {
        if (attendanceResult.reachedLimit === true) {
            return 'success';
        }
        if (attendanceResult.missingPlayersCount === 1) {
            return 'warning';
        }
        if (attendanceResult.missingPlayersCount > 1) {
            return 'failure';
        }
    });
/*
    Handlebars.registerHelper('toAlertTypeClass', function(severity) {
        if (severity === 'INFO') {
            return 'alert-success';
        } else if (severity === 'WARNING') {
            return 'alert-warning';
        } else {
            return 'alert-danger';
        }
    });

    Handlebars.registerHelper('toAlertText', function(severity) {
        if (severity === 'INFO') {
            return 'Info!';
        } else if (severity === 'WARNING') {
            return 'Advarsel!';
        } else {
            return 'Feil!';
        }
    });

    Handlebars.registerHelper('if_eq', function(a, b, opts) {
        if(a === b)
            return opts.fn(this);
        else
            return opts.inverse(this);
    });

    Handlebars.registerHelper('if_gte', function(a, b, opts) {
        if(parseFloat(a) >= parseFloat(b))
            return opts.fn(this);
        else
            return opts.inverse(this);
    });

    Handlebars.registerHelper('formatHM', function(hoursMinutes, small, opts) {
        var timeStr = "";
        if (hoursMinutes.hours == 0 && hoursMinutes.minutes == 0) {
            return "0";
        }
        if (hoursMinutes.hours > 0) {
            timeStr += hoursMinutes.hours;
            timeStr += small === true ? '<small>t</small>&nbsp' : "t&nbsp;";
        }
        if (hoursMinutes.minutes > 0) {
            timeStr += hoursMinutes.minutes;
            timeStr += small === true ? '<small>m</small>&nbsp' : "m&nbsp;";
        }
        return timeStr;
    });

    Handlebars.registerHelper('formatDHM', function(daysHoursMinutes, opts) {
        var timeStr = "";
        if (daysHoursMinutes.days == 0 && daysHoursMinutes.hours == 0 && daysHoursMinutes.minutes == 0) {
            return "0";
        }
        if (daysHoursMinutes.days > 0) {
            timeStr += daysHoursMinutes.days;
            timeStr += '<small>d</small>&nbsp';
        }
        if (daysHoursMinutes.hours > 0) {
            timeStr += daysHoursMinutes.hours;
            timeStr += '<small>t</small>&nbsp';
        }
        if (daysHoursMinutes.minutes > 0) {
            timeStr += daysHoursMinutes.minutes;
            timeStr += '<small>m</small>&nbsp';
        }
        return timeStr;
    });*/

    AttendanceResult.displayAttendanceResult();

});

/*
$(document).on("click", ".nav #dashboard", function(e) {
    e.preventDefault();
    $('.nav #week').parent().removeClass('active');
    $('.nav #day').parent().removeClass('active');
    $(this).parent().addClass('active');
    DASHBOARD.displayDashboard();
});

$(document).on("click", ".nav #week", function(e) {
    e.preventDefault();
    $('.nav #dashboard').parent().removeClass('active');
    $('.nav #day').parent().removeClass('active');
    $(this).parent().addClass('active');
    WEEK.displayCurrentWeek();
});

$(document).on("click", ".nav #day", function(e) {
    e.preventDefault();
    $('.nav #dashboard').parent().removeClass('active');
    $('.nav #week').parent().removeClass('active');
    $(this).parent().addClass('active');
    DAY.displayToday();
});
*/

