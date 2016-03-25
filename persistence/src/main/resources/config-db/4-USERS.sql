/*All User's are stored in APP_USER table*/
create table userDmo (
   id BIGINT NOT NULL AUTO_INCREMENT,
   username VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (username)
);

/* USER_PROFILE table contains all possible roles */
create table user_profile(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);

/* JOIN TABLE for MANY-TO-MANY relationship*/
CREATE TABLE user_user_profile (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES userDmo (id),
    CONSTRAINT fk_user_profile FOREIGN KEY (user_profile_id) REFERENCES user_profile (id)
);

/* Populate USER_PROFILE Table */
INSERT INTO user_profile(type)
VALUES ('USER');

INSERT INTO user_profile(type)
VALUES ('ADMIN');

/* Populate APP_USER Table */
INSERT INTO userDmo(username, password, first_name, last_name, email)
VALUES ('bill','abc123', 'Bill','Watcher','bill@xyz.com');

INSERT INTO userDmo(username, password, first_name, last_name, email)
VALUES ('danny','abc124', 'Danny','Theys','danny@xyz.com');

INSERT INTO userDmo(username, password, first_name, last_name, email)
VALUES ('sam','abc125', 'Sam','Smith','samy@xyz.com');

INSERT INTO userDmo(username, password, first_name, last_name, email)
VALUES ('kenny','abc127', 'Kenny','Roger','kenny@xyz.com');

/* Populate JOIN Table */
INSERT INTO user_user_profile(user_id, user_profile_id)
  SELECT userDmo.id, profile.id FROM userDmo userDmo, user_profile profile
  where userDmo.username='bill' and profile.type='USER';

INSERT INTO user_user_profile(user_id, user_profile_id)
  SELECT userDmo.id, profile.id FROM userDmo userDmo, user_profile profile
  where userDmo.username='danny' and profile.type='USER';

INSERT INTO user_user_profile(user_id, user_profile_id)
  SELECT userDmo.id, profile.id FROM userDmo userDmo, user_profile profile
  where userDmo.username='sam' and profile.type='ADMIN';

INSERT INTO user_user_profile(user_id, user_profile_id)
  SELECT userDmo.id, profile.id FROM userDmo userDmo, user_profile profile
  where userDmo.username='kenny' and profile.type='ADMIN';

