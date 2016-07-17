var Training = (function() {

    _getTraining = function(url) {
        $.ajax(url, {
            type: 'GET',
            success: function(training) {
                var trainingHtml = Handlebars.templates.training(training);
                $('#page').html(trainingHtml);
                _initEventHandlers(training);

                $('#username').html($('#username').text().replace("{username}", training.currentUser.username));
                $('#navbar-content').show(400);
            },
            beforeSend: function() {
                $('#page').hide();
                $('#pageSpinner.spinner').show();
            },
            complete: function() {
                $('#pageSpinner.spinner').hide();
                $('#page').show(400);
            }
        });
    }

    _initEventHandlers = function(training) {
        $('#decisionSelect').on('change', function(e) {
            if (training.currentUser.attendance) {
                _createOrUpdateAttendance('/innebandy/attendance/update', 'PUT');
            }
            else {
                _createOrUpdateAttendance('/innebandy/attendance/create', 'POST');
            }
        });
    }

    _createOrUpdateAttendance = function(url, requestType) {
        $.ajax(url, {
        type: requestType,
            data: $('#decisionForm').serialize(),
            success: function(training) {
                var decisionBoxHtml = Handlebars.templates.decisionBox(training);
                $('#decisionBox').replaceWith(decisionBoxHtml);

                var bigStatusBoxHtml = Handlebars.templates.bigStatusBox(training);
                $('#bigStatusBox').replaceWith(bigStatusBoxHtml);

                var attendingBoxHtml = Handlebars.templates.attendingBox(training);
                $('#attendingBox').replaceWith(attendingBoxHtml);

                var notAttendingBoxHtml = Handlebars.templates.notAttendingBox(training);
                $('#notAttendingBox').replaceWith(notAttendingBoxHtml);

                var maybeAttendingBoxHtml = Handlebars.templates.maybeAttendingBox(training);
                $('#maybeAttendingBox').replaceWith(maybeAttendingBoxHtml);

                $('#username').html($('#username').text().replace("{username}", training.currentUser.username));

                _initEventHandlers(training);

                $('#decision').show();
                //$('.shakeit').effect( "shake", { direction: "right", times: 4, distance: 5}, 1000 );
                $('#decision').delay(1000).fadeOut(1000)
            },
            beforeSend: function() {
                $('#decisionSpinner.spinner-blue').show();
            },
            complete: function() {
                $('#decisionSpinner.spinner-blue').hide();
            }
        });
    }

    return {
        displayTraining: function() {
           _getTraining('/innebandy/attendance');
        }
    }

}());
