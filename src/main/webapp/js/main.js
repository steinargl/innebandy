$(document).ready(function(){

    Handlebars.partials = Handlebars.templates;

    Handlebars.registerHelper('severity', function(training) {
        if (training.training === false) {
            return 'failure';
        }
        if (training.distanceFromLimit <= 0) {
            return 'success';
        }
        return 'warning';
    });

    Handlebars.registerHelper('statusTitle', function(training) {
        if (training.training === false) {
            return "Ingen trening i dag";
        }
        if (training.distanceFromLimit <= 0) {
            return "The game is on!!!";
        }
        return "Ser dårlig ut...";
    });

    Handlebars.registerHelper('statusSubTitle', function(training) {
        if (training.training === false) {
            return "Satser på bedre oppmøte neste gang...";
        }
        if (training.distanceFromLimit <= 0) {
            return training.isAttendingList.length + " stk. har meldt seg på så langt";
        }
        if (training.distanceFromLimit == 1) {
            return "Vi magler én spiller!";
        }
        return "Vi magler " + training.distanceFromLimit + " spillere!";
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

/*
$(document).on("click", ".nav #dashboard", function(e) {
    e.preventDefault();
    $('.nav #week').parent().removeClass('active');
    $('.nav #day').parent().removeClass('active');
    $(this).parent().addClass('active');
    DASHBOARD.displayDashboard();
});

$(document).on("click", ".nav #week", function(e) {
    e.preventDefault();
    $('.nav #dashboard').parent().removeClass('active');
    $('.nav #day').parent().removeClass('active');
    $(this).parent().addClass('active');
    WEEK.displayCurrentWeek();
});

$(document).on("click", ".nav #day", function(e) {
    e.preventDefault();
    $('.nav #dashboard').parent().removeClass('active');
    $('.nav #week').parent().removeClass('active');
    $(this).parent().addClass('active');
    DAY.displayToday();
});
*/

