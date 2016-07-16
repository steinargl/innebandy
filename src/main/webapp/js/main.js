$(document).ready(function(){

    Handlebars.partials = Handlebars.templates;

    Handlebars.registerHelper('severity', function(training) {
        if (training.status === 'YES') {
            return "success";
        }
        if (training.status === 'NO') {
            return "failure";
        }
        if (isToday(training.isoDate) && training.status === 'MAYBE') {
            return "warning";
        }
        return "maybe";
    });

    Handlebars.registerHelper('text1', function(training) {
        if (training.today) {
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
        if (isToday(training.isoDate) && training.status === 'MAYBE') {
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

    Handlebars.registerHelper('decisionText', function(training) {
        if (isToday(training.isoDate)) {
            return "Kommer du på trening i dag";
        }
        return "Status for neste trening - " + training.date;
    });

    Training.displayTraining();

});

function isToday(date) {

    return false;
}

$(document).ajaxError(function(event,xhr,options,exc) {
    if (xhr.status === 401) {
        if (xhr.responseJSON.path === "/login") {
            Login.displayLoginWithErrorMsg();
        } else {
            Login.displayLogin();
        }
    }
    else {
        Error.displayError();
    }
});


