use innebandy;

INSERT INTO users (username, password, email) values ('steinar', 'steinar', 'sglamseter@gmail.com');
INSERT INTO users (username, password, email) values ('jarle', 'jarle', 'jarle@gmail.com');
INSERT INTO users (username, password, email) values ('fredrik', 'fredrik', 'fredrik@gmail.com');
INSERT INTO users (username, password, email) values ('anders', 'anders', 'anders@gmail.com');
INSERT INTO users (username, password, email) values ('henrik', 'henrik', 'henrik@gmail.com');
INSERT INTO users (username, password, email) values ('lars petter', 'lars petter', 'sglamseter@gmail.com');
INSERT INTO users (username, password, email) values ('magnus', 'magnus', 'magnus@gmail.com');
INSERT INTO users (username, password, email) values ('johnny', 'johnny', 'johnny@gmail.com');
INSERT INTO users (username, password, email) values ('bernt', 'bernt', 'bernt@gmail.com');
INSERT INTO users (username, password, email) values ('sjur', 'sjur', 'sjur@gmail.com');

INSERT INTO user_roles (username, role) values ('steinar', 'USER');
INSERT INTO user_roles (username, role) values ('steinar', 'ADMIN');
INSERT INTO user_roles (username, role) values ('jarle', 'USER');
INSERT INTO user_roles (username, role) values ('fredrik', 'USER');
INSERT INTO user_roles (username, role) values ('henrik', 'USER');
INSERT INTO user_roles (username, role) values ('lars petter', 'USER');
INSERT INTO user_roles (username, role) values ('magnus', 'USER');
INSERT INTO user_roles (username, role) values ('johnny', 'USER');
INSERT INTO user_roles (username, role) values ('bernt', 'USER');
INSERT INTO user_roles (username, role) values ('sjur', 'USER');
INSERT INTO user_roles (username, role) values ('anders', 'USER');



INSERT INTO attendance (username, date, type) values ('steinar', '2016-07-05', 'ATTEND');
INSERT INTO attendance (username, date, type) values ('steinar', '2016-06-21', 'ATTEND');

INSERT INTO attendance (username, date, type) values ('jarle', '2016-07-05', 'ATTEND');
INSERT INTO attendance (username, date, type) values ('fredrik', '2016-07-05', 'ATTEND');
INSERT INTO attendance (username, date, type) values ('henrik', '2016-07-05', 'ATTEND');
INSERT INTO attendance (username, date, type) values ('lars petter', '2016-07-05', 'ATTEND');
INSERT INTO attendance (username, date, type) values ('johnny', '2016-07-05', 'NOT_ATTEND');
INSERT INTO attendance (username, date, type) values ('sjur', '2016-07-05', 'NOT_ATTEND');


UPDATE attendance set type='NOT_ATTEND' WHERE username in ('fredrik');