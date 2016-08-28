use innebandy;

INSERT INTO users (email, password, name, phone) values ('sglamseter@gmail.com', 'steinar', 'Steinar', '91193609');
INSERT INTO users (email, password, name, phone) values ('jarle@gmail.com', 'jarle', 'Jarle', '11111111');
INSERT INTO users (email, password, name, phone) values ('fredrik@gmail.com', 'fredrik', 'Fredrik', '11111111');
INSERT INTO users (email, password, name, phone) values ('anders@gmail.com', 'anders', 'Anders', '11111111');
INSERT INTO users (email, password, name, phone) values ('henrik@gmail.com', 'henrik', 'Henrik', '11111111');
INSERT INTO users (email, password, name, phone) values ('larspetter@gmail.com', 'lars petter', 'Lars Petter', '11111111');
INSERT INTO users (email, password, name, phone) values ('magnus@gmail.com', 'magnus', 'Magnus', '11111111');
INSERT INTO users (email, password, name, phone) values ('johnny@gmail.com', 'johnny', 'Johnny', '11111111');
INSERT INTO users (email, password, name, phone) values ('bernt@gmail.com', 'bernt', 'Bernt', '11111111');
INSERT INTO users (email, password, name, phone) values ('sjur@gmail.com', 'sjur', 'Sjur', '11111111');

INSERT INTO user_roles (email, role) values ('sglamseter@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('sglamseter@gmail.com', 'ADMIN');
INSERT INTO user_roles (email, role) values ('jarle@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('fredrik@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('henrik@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('larspetter@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('magnus@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('johnny@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('bernt@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('sjur@gmail.com', 'USER');
INSERT INTO user_roles (email, role) values ('anders@gmail.com', 'USER');



#UPDATE attendance set type='NOT_ATTEND' WHERE email in ('fredrik@gmail.com');

