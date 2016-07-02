$(document).ready(function(){

    Handlebars.partials = Handlebars.templates;

    Handlebars.registerHelper('severity', function(training) {
        if (training.status === 'YES') {
            return "success";
        }
        if (training.status === 'NO') {
            return "failure";
        }
        if (training.status === 'MAYBE_ON_TRAINING_DAY') {
            return "warning";
        }
        return "maybe";
    });

    Handlebars.registerHelper('statusTitle', function(training) {
        if (training.status === 'YES') {
            return "The game is on!!!";
        }
        if (training.status === 'NO') {
            return "Ingen trening i dag";
        }
        if (training.status === 'MAYBE_ON_TRAINING_DAY') {
            return "Ser dårlig ut...";
        }
        return "Kanskje...";
    });

    Handlebars.registerHelper('statusSubTitle', function(training) {
        if (training.status === 'YES') {
            return training.isAttendingList.length + " stk. har meldt seg på så langt";
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


    Training.displayTraining();

});


$(document).ajaxError(function(event,xhr,options,exc) {
    if (xhr.status === 401) {
        Login.displayLogin();
    }
    else {
        Error.displayError();
    }
});


