use glamseter;

INSERT INTO users (email, password, name, phone)
VALUES ('akvame@gmail.com', '$2a$10$D5X8goKmNCDl/QOz2gv1nu9czMv2Mxp.uRTzzPJNqSWW3pdvzA5iy', 'Anders Kvame', '98010149');

INSERT INTO user_roles (email, role) values ('akvame@gmail.com', 'USER');

#INSERT INTO user_roles (email, role) values ('sglamseter@gmail.com', 'ADMIN');

#delete from users where email='Angaustad@gmail.com';
