var Training = (function() {

    _getTraining = function(url) {
        $.ajax(url, {
            type: 'GET',
            success: function(training) {
                var trainingHtml = Handlebars.templates.training(training);
                $('#page').html(trainingHtml);
                _initEventHandlers(training);
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

                _initEventHandlers(training);
                $('#decision').show();
                //$('.shakeit').effect( "shake", { direction: "right", times: 4, distance: 5}, 1000 );
                $('#decision').delay(1000).fadeOut(1000)
            },
            beforeSend: function() {
                /*$('#page').hide();
                $('#pageSpinner.spinner').show();*/
            },
            complete: function() {
                /*$('#pageSpinner.spinner').hide();
                $('#page').show(400);*/
            }
        });
    }

    return {
        displayTraining: function() {
           _getTraining('/innebandy/attendance');
        }
    }

}());
