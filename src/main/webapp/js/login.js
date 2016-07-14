var Login = (function() {
    return {
        displayLogin: function() {
            var loginHtml = Handlebars.templates.login();
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
      //timeout: 1000,
      type: 'POST',
      url: '/login'

    }).done(function(data, textStatus, jqXHR) {
     // var preLoginInfo = JSON.parse($.cookie('dashboard.pre.login.request'));
      //window.location = preLoginInfo.url;AttendanceResult
      Training.displayTraining();

    }).fail(function(jqXHR, textStatus, errorThrown) {
        alert('Booh! Wrong credentials, try again!');
    });
});

$(document).on("click", "#btnLogout", function(e) {
    event.preventDefault();
    $.ajax({
      data: {},
      timeout: 1000,
      type: 'POST',
      url: '/logout'
    }).done(function(data, textStatus, jqXHR) {
        window.location = '/';
    }).fail(function(jqXHR, textStatus, errorThrown) {
        alert('Booh! Logout failed');
    });
});