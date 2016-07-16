(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['attendingBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            "
    + container.escapeExpression(((helper = (helper = helpers.username || (depth0 != null ? depth0.username : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"username","hash":{},"data":data}) : helper)))
    + "<br>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div id=\"attendingBox\" class=\"panel panel-default green-box\">\r\n    <div class=\"panel-body\">\r\n        <span class=\"player-count\">"
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.attendingList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</span>&nbsp;KOMMER\r\n        <hr>\r\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.attendingList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n";
},"useData":true});
templates['bigStatusBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    return "";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing;

  return "<div id=\"bigStatusBox\" class=\"jumbotron jumbotron-"
    + ((stack1 = (helpers.severity || (depth0 && depth0.severity) || alias2).call(alias1,depth0,{"name":"severity","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\">\r\n    <h4>Status for neste trening - "
    + container.escapeExpression(((helper = (helper = helpers.date || (depth0 != null ? depth0.date : depth0)) != null ? helper : alias2),(typeof helper === "function" ? helper.call(alias1,{"name":"date","hash":{},"data":data}) : helper)))
    + "</h4>\r\n    <h1 class=\"jumbotron-header-"
    + ((stack1 = (helpers.severity || (depth0 && depth0.severity) || alias2).call(alias1,depth0,{"name":"severity","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\"><b>"
    + ((stack1 = (helpers.text2 || (depth0 && depth0.text2) || alias2).call(alias1,depth0,{"name":"text2","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</b></h1>\r\n    <h4>"
    + ((stack1 = (helpers.text3 || (depth0 && depth0.text3) || alias2).call(alias1,depth0,{"name":"text3","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</h4>\r\n</div>\r\n";
},"useData":true});
templates['decisionBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "                <input type=\"hidden\" name=\"attendanceId\" value=\""
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.id : stack1), depth0))
    + "\">\r\n";
},"3":function(container,depth0,helpers,partials,data) {
    return "                        <option></option>\r\n";
},"5":function(container,depth0,helpers,partials,data) {
    return " selected";
},"7":function(container,depth0,helpers,partials,data) {
    return "            <div style=\"height:20px;\"><h4 id=\"decision\" style=\"display:none\">Svaret ditt er registrert</h4></div>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing;

  return "<div id=\"decisionBox\" class=\"panel panel-default blue-box\">\r\n    <div class=\"panel-body\">\r\n        <h3>Kommer du på trening i dag?</h3>\r\n        <form id=\"decisionForm\">\r\n"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            <div id=\"decisionSelect\" class=\"form-group\">\r\n                <select name=\"attendanceTypeId\" class=\"form-control\" style=\"padding:5px;font-size: 120%;\">\r\n"
    + ((stack1 = helpers.unless.call(alias1,((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1),{"name":"unless","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "                    <option value=\"ATTEND\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"ATTEND",{"name":"equal","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">Kommer</option>\r\n                    <option value=\"NOT_ATTEND\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"NOT_ATTEND",{"name":"equal","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">Kommer ikke</option>\r\n                    <option value=\"NOT_DECIDED\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"NOT_DECIDED",{"name":"equal","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">Vet ikke</option>\r\n                </select>\r\n            </div>\r\n        </form>\r\n"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),{"name":"if","hash":{},"fn":container.program(7, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n";
},"useData":true});
templates['infoBox1'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div class=\"panel panel-default gold-box\">\r\n    <div class=\"panel-body\">\r\n        <p>\r\n            Trening på tirsdager fra kl 20.00 til kl 22.00 i <a href=\"https://www.google.no/maps/place/Gaustadhallen/@59.2659743,10.7717805,15z/data=!4m5!3m4!1s0x0:0xe28d42b4c8661585!8m2!3d59.2659743!4d10.7717805\">Gaustadhallen</a>\r\n        </p>\r\n        <p>\r\n            Første trening blir tirsdag 16. August og siste trening blir 27. desember.\r\n        </p>\r\n    </div>\r\n</div>\r\n";
},"useData":true});
templates['infoBox2'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"panel panel-default gold-box\">\r\n    <div class=\"panel-body\">\r\n        <p>\r\n            <h2>Priser</h2>\r\n            <table class=\"table\">\r\n            <tbody>\r\n            <tr>\r\n                <td><small>Per trening</small></td>\r\n                <td>kr "
    + alias4(((helper = (helper = helpers.dayPrice || (depth0 != null ? depth0.dayPrice : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"dayPrice","hash":{},"data":data}) : helper)))
    + ",-</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Per måned</td>\r\n                <td>kr "
    + alias4(((helper = (helper = helpers.monthlyPrice || (depth0 != null ? depth0.monthlyPrice : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"monthlyPrice","hash":{},"data":data}) : helper)))
    + ",-</td>\r\n            </tr>\r\n            <tr>\r\n                <td>Hele perioden</td>\r\n                <td>kr "
    + alias4(((helper = (helper = helpers.seasonPrice || (depth0 != null ? depth0.seasonPrice : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"seasonPrice","hash":{},"data":data}) : helper)))
    + ",-</td>\r\n            </tr>\r\n            </tbody>\r\n        </table>\r\n        Betal med <a href=\"https://www.vipps.no/sos.html\">Vipps</a> til 91193609\r\n        </p>\r\n    </div>\r\n</div>\r\n";
},"useData":true});
templates['login'] = template({"1":function(container,depth0,helpers,partials,data) {
    return "            <div class=\"alert alert-info\" role=\"alert\">\r\n                <p>Feil brukernavn eller passord.</p>\r\n            </div>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div id=\"login\" class=\"panel panel-default login-box\">\r\n    <form id=\"loginform\">\r\n        <fieldset class=\"form-group\">\r\n            <label for=\"uid\">Brukernavn</label>\r\n            <input type=\"userid\" class=\"form-control\" id=\"uid\" placeholder=\"Brukernavn\">\r\n        </fieldset>\r\n        <fieldset class=\"form-group\">\r\n            <label for=\"pwd\">Passord</label>\r\n            <input type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Passord\">\r\n        </fieldset>\r\n"
    + ((stack1 = helpers["if"].call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.showErrorMessage : depth0),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "        <button type=\"submit\" id=\"btnLogin\" class=\"btn btn-primary\">Logg inn</button>\r\n    </form>\r\n</div>\r\n";
},"useData":true});
templates['maybeAttendingBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            "
    + container.escapeExpression(((helper = (helper = helpers.username || (depth0 != null ? depth0.username : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"username","hash":{},"data":data}) : helper)))
    + "<br>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div id=\"maybeAttendingBox\" class=\"panel panel-default yellow-box\">\r\n    <div class=\"panel-body\">\r\n        <span class=\"player-count\">"
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.maybeAttendingList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</span>&nbsp;VET IKKE\r\n        <hr>\r\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.maybeAttendingList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n";
},"useData":true});
templates['notAttendingBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "            "
    + container.escapeExpression(((helper = (helper = helpers.username || (depth0 != null ? depth0.username : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"username","hash":{},"data":data}) : helper)))
    + "<br>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "<div id=\"notAttendingBox\" class=\"panel panel-default red-box\">\r\n    <div class=\"panel-body\">\r\n        <span class=\"player-count\">"
    + container.escapeExpression(container.lambda(((stack1 = (depth0 != null ? depth0.notAttendingList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</span>&nbsp;KOMMER IKKE\r\n        <hr>\r\n"
    + ((stack1 = helpers.each.call(depth0 != null ? depth0 : {},(depth0 != null ? depth0.notAttendingList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n";
},"useData":true});
templates['training'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"row\">\r\n    <div class=\"col-sm-12\">\r\n"
    + ((stack1 = container.invokePartial(partials.bigStatusBox,depth0,{"name":"bigStatusBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n\r\n"
    + alias4(((helper = (helper = helpers.datetime || (depth0 != null ? depth0.datetime : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"datetime","hash":{},"data":data}) : helper)))
    + "<br>\r\n"
    + alias4(((helper = (helper = helpers.datetime2 || (depth0 != null ? depth0.datetime2 : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"datetime2","hash":{},"data":data}) : helper)))
    + "<br>\r\n\r\n<div class=\"row\">\r\n    <div class=\"col-sm-7\">\r\n"
    + ((stack1 = container.invokePartial(partials.decisionBox,depth0,{"name":"decisionBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n    <div class=\"col-sm-5\">\r\n"
    + ((stack1 = container.invokePartial(partials.infoBox1,depth0,{"name":"infoBox1","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n<div class=\"row\">\r\n    <div class=\"col-sm-4\">\r\n"
    + ((stack1 = container.invokePartial(partials.attendingBox,depth0,{"name":"attendingBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n    <div class=\"col-sm-4\">\r\n"
    + ((stack1 = container.invokePartial(partials.maybeAttendingBox,depth0,{"name":"maybeAttendingBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n    <div class=\"col-sm-4\">\r\n"
    + ((stack1 = container.invokePartial(partials.notAttendingBox,depth0,{"name":"notAttendingBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n<div class=\"row\">\r\n    <div class=\"col-sm-5\">\r\n"
    + ((stack1 = container.invokePartial(partials.infoBox2,depth0,{"name":"infoBox2","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n\r\n";
},"usePartial":true,"useData":true});
})();