var AttendanceResult = (function() {

    _getAttendanceResult = function(url) {
        $.ajax(url, {
            type: 'GET',
            success: function(attendanceResult) {
               var attendanceResultHtml = Handlebars.templates.attendanceResult(attendanceResult);
               $('#page').html(attendanceResultHtml);
               //alert(ColorCalc.getColor(100));

               var rgbCol = ColorCalc.getColor(100);
               //$('.jumbotron h1').css('color', '#4CBB17');

               //$('.jumbotron').css({"border-color": "#4CBB17","border-width":"1px","border-style":"solid"});
               //$('.jumbotron').css('border-color: black;');


            },
            error: function( jqXHR, textStatus, errorThrown) {
                if (jqXHR.status === 401) {
                    Login.displayLogin();
                }
                else {
                    Error.displayError();
                }
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

    return {
        displayAttendanceResult: function() {
           _getAttendanceResult('/innebandy/attendance');
        }
    }

}());