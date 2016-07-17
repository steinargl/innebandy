var Login = (function() {
    return {
        displayLogin: function() {
            var loginHtml = Handlebars.templates.login();
            $('#page').html(loginHtml);
            $('#page').hide();
            $('#page').show();
        },
        displayLoginWithErrorMsg: function(errorMessage) {
            var loginHtml = Handlebars.templates.login(errorMessage);
            $('#page').html(loginHtml);
            $('#page').hide();
            $('#page').show();
        }
    }
}());

$(document).on("click", "#btnLogin", function(e) {
    event.preventDefault();
    var data = 'username=' + $('#uid').val() + '&password=' + $('#pwd').val();
    $.ajax({
        data: data,
        type: 'POST',
        url: '/login',
        success: function(data, textStatus, jqXHR) {
            // var preLoginInfo = JSON.parse($.cookie('dashboard.pre.login.request'));
            //window.location = preLoginInfo.url;AttendanceResult
            Training.displayTraining();
        },
        fail: function(jqXHR, textStatus, errorThrown) {
            Training.displayLoginWithErrorMsg("Beklager, det har skjedd en uventet feil. Prøv igjen senere");
        }
    });
});

$(document).on("click", "#btnLogout", function(e) {
    event.preventDefault();
    $.ajax({
      data: {},
      type: 'POST',
      url: '/logout'
    }).done(function(data, textStatus, jqXHR) {
        window.location = '/';
    }).fail(function(jqXHR, textStatus, errorThrown) {
        alert('Booh! Logout failed');
    });
});