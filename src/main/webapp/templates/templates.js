(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['bigStatusBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    return "";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing;

  return "<div id=\"bigStatusBox\" class=\"jumbotron jumbotron-"
    + ((stack1 = (helpers.severity || (depth0 && depth0.severity) || alias2).call(alias1,depth0,{"name":"severity","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\">\r\n    <h2><small>Status for "
    + container.escapeExpression(((helper = (helper = helpers.date || (depth0 != null ? depth0.date : depth0)) != null ? helper : alias2),(typeof helper === "function" ? helper.call(alias1,{"name":"date","hash":{},"data":data}) : helper)))
    + "</small></h2>\r\n    <h1 class=\"jumbotron-header-"
    + ((stack1 = (helpers.severity || (depth0 && depth0.severity) || alias2).call(alias1,depth0,{"name":"severity","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "\">"
    + ((stack1 = (helpers.statusTitle || (depth0 && depth0.statusTitle) || alias2).call(alias1,depth0,{"name":"statusTitle","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</h1>\r\n    <h2><small>"
    + ((stack1 = (helpers.statusSubTitle || (depth0 && depth0.statusSubTitle) || alias2).call(alias1,depth0,{"name":"statusSubTitle","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</small></h2>\r\n</div>\r\n";
},"useData":true});
templates['decisionBox'] = template({"1":function(container,depth0,helpers,partials,data) {
    var stack1;

  return "                <input type=\"hidden\" name=\"attendanceId\" value=\""
    + container.escapeExpression(container.lambda(((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.id : stack1), depth0))
    + "\">\r\n";
},"3":function(container,depth0,helpers,partials,data) {
    return " selected";
},"5":function(container,depth0,helpers,partials,data) {
    return "Kansje";
},"7":function(container,depth0,helpers,partials,data) {
    return "            <div style=\"height:20px;\"><h4 id=\"decision\" style=\"display:none\">Svaret ditt er registrert</h4></div>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing;

  return "<div id=\"decisionBox\" class=\"panel panel-default blue-box\">\r\n    <div class=\"panel-body\">\r\n        <h3>Kommer du på trening i dag?</h3>\r\n        <form id=\"decisionForm\">\r\n"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1),{"name":"if","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            <div id=\"decisionSelect\" class=\"form-group\">\r\n                <select name=\"attendanceTypeId\" class=\"form-control\" style=\"padding:5px;font-size: 120%;\">\r\n                    <option value=\"NOT_DECIDED\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"UNDECIDED",{"name":"equal","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),{"name":"if","hash":{},"fn":container.program(5, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "</option>\r\n                    <option value=\"ATTEND\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"ATTEND",{"name":"equal","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">Kommer</option>\r\n                    <option value=\"NOT_ATTEND\""
    + ((stack1 = (helpers.equal || (depth0 && depth0.equal) || alias2).call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),"NOT_ATTEND",{"name":"equal","hash":{},"fn":container.program(3, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + ">Kommer ikke</option>\r\n                </select>\r\n            </div>\r\n        </form>\r\n"
    + ((stack1 = helpers["if"].call(alias1,((stack1 = ((stack1 = ((stack1 = (depth0 != null ? depth0.currentUser : depth0)) != null ? stack1.attendance : stack1)) != null ? stack1.attendanceType : stack1)) != null ? stack1.id : stack1),{"name":"if","hash":{},"fn":container.program(7, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n";
},"useData":true});
templates['infoBox'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div class=\"panel panel-default yellow-box\">\r\n    <div class=\"panel-body\">\r\n        <p>\r\n            Trening hver tirsdag fra kl 20.00 til kl 22.00 i <a href=\"https://www.google.no/maps/place/Gaustadhallen/@59.2659743,10.7717805,15z/data=!4m5!3m4!1s0x0:0xe28d42b4c8661585!8m2!3d59.2659743!4d10.7717805\">Gaustadhallen</a>\r\n        </p>\r\n        <p>\r\n            Prisen er kr 150,- per måned<br>\r\n            Betal med <a href=\"https://www.vipps.no/sos.html\">Vipps</a> til 91193609\r\n        </p>\r\n    </div>\r\n</div>\r\n";
},"useData":true});
templates['login'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div id=\"login\">\r\n    <form id=\"loginform\">\r\n        <fieldset class=\"form-group\">\r\n            <label for=\"uid\">Brukernavn</label>\r\n            <input type=\"userid\" class=\"form-control\" id=\"uid\" placeholder=\"Brukernavn\">\r\n        </fieldset>\r\n        <fieldset class=\"form-group\">\r\n            <label for=\"pwd\">Passord</label>\r\n            <input type=\"password\" class=\"form-control\" id=\"pwd\" placeholder=\"Passord\">\r\n        </fieldset>\r\n        <button type=\"submit\" id=\"btnLogin\" class=\"btn btn-primary\">OK</button>\r\n    </form>\r\n</div>\r\n";
},"useData":true});
templates['training'] = template({"1":function(container,depth0,helpers,partials,data) {
    var helper;

  return "                    "
    + container.escapeExpression(((helper = (helper = helpers.username || (depth0 != null ? depth0.username : depth0)) != null ? helper : helpers.helperMissing),(typeof helper === "function" ? helper.call(depth0 != null ? depth0 : {},{"name":"username","hash":{},"data":data}) : helper)))
    + "<br>\r\n";
},"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var stack1, alias1=container.lambda, alias2=container.escapeExpression, alias3=depth0 != null ? depth0 : {};

  return "<div class=\"row\">\r\n    <div class=\"col-sm-12\">\r\n"
    + ((stack1 = container.invokePartial(partials.bigStatusBox,depth0,{"name":"bigStatusBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n</div>\r\n<div class=\"row\">\r\n    <div class=\"col-sm-7\">\r\n"
    + ((stack1 = container.invokePartial(partials.decisionBox,depth0,{"name":"decisionBox","data":data,"indent":"        ","helpers":helpers,"partials":partials,"decorators":container.decorators})) != null ? stack1 : "")
    + "    </div>\r\n    <div class=\"col-sm-5\">\r\n        <div class=\"panel panel-default yellow-box\">\r\n            <div class=\"panel-body\">\r\n                <p>\r\n                    Trening hver tirsdag fra kl 20.00 til kl 22.00 i <a href=\"https://www.google.no/maps/place/Gaustadhallen/@59.2659743,10.7717805,15z/data=!4m5!3m4!1s0x0:0xe28d42b4c8661585!8m2!3d59.2659743!4d10.7717805\">Gaustadhallen</a>\r\n                </p>\r\n                <p>\r\n                    Prisen er kr 150,- per måned<br>\r\n                    Betal med <a href=\"https://www.vipps.no/sos.html\">Vipps</a> til 91193609\r\n                </p>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n<div class=\"row\">\r\n    <div class=\"col-sm-4\">\r\n        <div class=\"panel panel-default green-box\">\r\n            <div class=\"panel-body\">\r\n                <table><tr><td>KOMMER&nbsp;</td><td><div class=\"mybadge\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.isAttendingList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</div></td></tr></table>\r\n                <hr>\r\n"
    + ((stack1 = helpers.each.call(alias3,(depth0 != null ? depth0.isAttendingList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"col-sm-4\">\r\n        <div class=\"panel panel-default gray-box\">\r\n            <div class=\"panel-body\">\r\n                <table><tr><td>KOMMER IKKE&nbsp;</td><td><div class=\"mybadge\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.isNotAttendingList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</div></td></tr></table>\r\n                <hr>\r\n"
    + ((stack1 = helpers.each.call(alias3,(depth0 != null ? depth0.isNotAttendingList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </div>\r\n        </div>\r\n    </div>\r\n    <div class=\"col-sm-4\">\r\n        <div class=\"panel panel-default gray-box\">\r\n            <div class=\"panel-body\">\r\n                <table><tr><td>Kansje&nbsp;</td><td><div class=\"mybadge\">"
    + alias2(alias1(((stack1 = (depth0 != null ? depth0.hasNotAnsweredList : depth0)) != null ? stack1.length : stack1), depth0))
    + "</div></td></tr></table>\r\n                <hr>\r\n"
    + ((stack1 = helpers.each.call(alias3,(depth0 != null ? depth0.hasNotAnsweredList : depth0),{"name":"each","hash":{},"fn":container.program(1, data, 0),"inverse":container.noop,"data":data})) != null ? stack1 : "")
    + "            </div>\r\n        </div>\r\n    </div>\r\n</div>\r\n";
},"usePartial":true,"useData":true});
})();