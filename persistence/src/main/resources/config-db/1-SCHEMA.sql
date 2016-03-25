drop schema if exists `computerDmo-database-db`;
  create schema if not exists `computerDmo-database-db`;
  use `computerDmo-database-db`;

  drop table if exists computerDmo;
  drop table if exists companyDmo;

  create table companyDmo (
    id                        bigint not null auto_increment,
    name                      varchar(255),
    constraint pk_company primary key (id))
  ;

  create table computerDmo (
    id                        bigint not null auto_increment,
    name                      varchar(255),
    introduced                timestamp NULL,
    discontinued              timestamp NULL,
    company_id                bigint default NULL,
    constraint pk_computer primary key (id))
  ;

  alter table computerDmo add constraint fk_computer_company_1 foreign key (company_id) references companyDmo (id) on delete restrict on update restrict;
  create index ix_computer_company_1 on computerDmo (company_id);
