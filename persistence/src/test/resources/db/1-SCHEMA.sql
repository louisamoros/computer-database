create table company (
  id                        bigint not null auto_increment,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null auto_increment,
  name                      varchar(255),
  introduced                timestamp NULL,
  discontinued              timestamp NULL,
  company_id                bigint default NULL,
  constraint pk_computer primary key (id))
;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);

  create table user (
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
      CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user (id),
      CONSTRAINT fk_user_profile FOREIGN KEY (user_profile_id) REFERENCES user_profile (id)
  );

