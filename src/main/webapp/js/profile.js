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

$(document).on("click", "#btnProfile", function(e) {
    event.preventDefault();
    Profile.displayProfile();
});

