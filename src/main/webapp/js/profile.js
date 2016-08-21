var Profile = (function() {
    _getProfile = function(url) {
        $.ajax(url, {
            type: 'GET',
            success: function(profile) {
                var profileHtml = Handlebars.templates.profile(profile);
                $('#page').html(profileHtml);
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
        displayProfile: function() {
            _getProfile('/innebandy/profile');
        }
    }
}());

$(document).on("click", "#btnSaveProfile", function(e) {
    event.preventDefault();
    var data = 'email=' + $('#email').val() +
        '&name=' + $('#name').val() + '&phone=' + $('#phone').val();

    $.ajax({
        data: data,
        type: 'POST',
        url: '/innebandy/profile/save',
        success: function(profile, textStatus, jqXHR) {
            var profileHtml = Handlebars.templates.profile(profile);
            $('#page').html(profileHtml);

            if (!profile.validationResult.errors) {
                $('#profileResponseMsg').show();
                $('#profileResponseMsg').delay(1300).fadeOut(1000)
            }
        },
        beforeSend: function() {
            $('#btnSaveProfile').prop('disabled', true);
            $('#profileSpinner').show();
        },
        complete: function() {
            $('#profileSpinner').hide();
            $('#btnSaveProfile').prop('disabled', false);
        },
        fail: function(jqXHR, textStatus, errorThrown) {
        }
    });
});

