   ___________   _____    _______	
  |____   ____| |  _  \  |  _____| 
       | |      | |_| |  | |___
       | |      |  _  /  | 	___| 
	   | |      | | \ \  | |_____
       |_|      |_|  \_\ |_______| 
        
***********************
* RUN THE APPLICATION *
***********************
Run the application using mvn spring-boot:run.
Or you can build the JAR file with mvn clean package and run the JAR by typing: java -jar target/treg-0.1.0.jar


***********************
* HTML TEMPLATES      *
***********************
handlebars.js is use for html templating

Installation:
- install node.js
- run the command: vnpm install handlebars -g

Now you can use the following syntax in the command prompt:

	handlebars <input> -f <output>
	
	compile multiple templates into one javascript:
	C:\Projects\treg\src\main\webapp\templates>handlebars .\ -f templates.js

where <input> is an original template file name, and <output> is a pre-compliled template file name.
ql


***********************
* RUN CONFIGURATION   *
***********************
local: spring-boot:run
local (with production config): spring-boot:run -Dspring.profiles.active=production


************************
* DEPLOY APP ON HEROKU *
************************
https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku#preparing-a-spring-boot-app-for-heroku
