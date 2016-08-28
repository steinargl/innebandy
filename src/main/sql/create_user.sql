use glamseter;

INSERT INTO users (email, password, name, phone)
VALUES ('Angaustad@gmail.com', '$2a$10$D5X8goKmNCDl/QOz2gv1nu9czMv2Mxp.uRTzzPJNqSWW3pdvzA5iy', 'angaustad@gmail.com', '93466321');

INSERT INTO user_roles (email, role) values ('angaustad@gmail.com', 'USER');

#INSERT INTO user_roles (email, role) values ('sglamseter@gmail.com', 'ADMIN');

#delete from users where email='Angaustad@gmail.com';
