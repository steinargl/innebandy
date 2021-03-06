$(document).ready(function(){

    Handlebars.partials = Handlebars.templates;

    Handlebars.registerHelper('severity', function(training) {
        if (training.status === 'YES') {
            return "success";
        }
        if (training.status === 'NO') {
            return "failure";
        }
        if (isTrainingDay(training.isoDate) && training.status === 'MAYBE') {
            return "warning";
        }
        return "maybe";
    });

    Handlebars.registerHelper('text1', function(training) {
        if (training.isToday) {
            return "Status for trening i dag";
        }
        return "Status for neste trening - " + training.date;
    });

    Handlebars.registerHelper('text2', function(training) {
        if (training.status === 'YES') {
            return "The game is on!!!";
        }
        if (training.status === 'NO') {
            return "Ingen trening i dag";
        }
        if (isTrainingDay(training.isoDate) && training.status === 'MAYBE') {
            return "Ser dårlig ut...";
        }
        return "Foreløpig usikkert...";
    });

    Handlebars.registerHelper('text3', function(training) {
        if (training.status === 'YES') {
            return training.attendingList.length + " stk. har meldt seg på så langt";
        }
        if (training.status === 'NO') {
            return "Satser på bedre oppmøte neste gang...";
        }
        if (training.distanceFromLimit == 1) {
            return "Vi mangler kun " + training.distanceFromLimit + " spiller!";
        }
        if (training.distanceFromLimit > 1) {
            return "Vi mangler " + training.distanceFromLimit + " spillere!";
        }
    });

    Handlebars.registerHelper('equal', function(lvalue, rvalue, options) {
        if (arguments.length < 3)
            throw new Error("Handlebars Helper equal needs 2 parameters");
        if( lvalue!=rvalue ) {
            return options.inverse(this);
        } else {
            return options.fn(this);
        }
    });

    Handlebars.registerHelper('jumbotronText', function(training) {
        if (isTrainingDay(training.isoDate)) {
            return "Status for trening i dag";
        }
        else if (isDayBeforeTrainingDay(training.isoDate)) {
            return "Status for trening i morgen";
        }
        return "Status for trening " + training.formattedDate;
    });

    Handlebars.registerHelper('decisionText', function(training) {
        if (isTrainingDay(training.isoDate)) {
            return "Kommer du på trening i dag?";
        }
        else if (isDayBeforeTrainingDay(training.isoDate)) {
            return "Kommer du på trening i morgen?";
        }
        return "Kommer du på trening til tirsdag?";
    });

    Training.displayTraining();

});

function isTrainingDay(date) {
    var now = new Date();
    var nowStr = now.getFullYear() + "-" + ('0' + (now.getMonth()+1)).slice(-2) + "-" + ('0' + now.getDate()).slice(-2);
    return nowStr === date;
}

function isDayBeforeTrainingDay(date) {
    var now = new Date();
    now.setDate(now.getDate() + 1);
    var nowStr = now.getFullYear() + "-" + ('0' + (now.getMonth()+1)).slice(-2) + "-" + ('0' + now.getDate()).slice(-2);
    return nowStr === date;
}

$(document).ajaxError(function(event,xhr,options,exc) {
    if (xhr.status === 401) {
        if (xhr.responseJSON.path === "/login") {
            Login.displayLoginWithErrorMsg("Feil brukernavn eller passord.");
        } else {
            Login.displayLogin();
        }
    }
    else {
        Error.displayError();
    }
});

$(document).on("click", "#btnProfile", function(e) {
    event.preventDefault();
    $('.active').removeClass('active');
    $(this).parent().addClass('active');
    Profile.displayProfile();
});

$(document).on("click", "#btnHome", function(e) {
    event.preventDefault();
    $('.active').removeClass('active');
    $(this).parent().addClass('active');
    Training.displayTraining();
});

