create table User (
	id bigint primary key not NULL,
  NAME VARCHAR(10) ,
  age int not null
)

create table Sys_User (
	id int primary key ,
	username varchar(20),
  password VARCHAR(20)
)
create table Sys_Role(
 id int primary key,
 name varchar(20)
)
create table Sys_Permission(
	id int primary key ,
	name varchar(20),
	descripion varchar(20),
	url varchar(20),
	pid int
)
create table Sys_Role_User(
	id int primary  key,
	sys_user_id int,
  sys_role_id int
)
create table Sys_Permission_Role(
	id int primary key,
  sys_role_id int ,
  sys_permission_id int

)

insert into SYS_USER (id,username, password) values (1,'admin', 'admin');
insert into SYS_USER (id,username, password) values (2,'abel', 'abel');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_ROLE_USER(id,SYS_USER_ID,sys_ROLE_ID) values(1,1,1);
insert into SYS_ROLE_USER(id,SYS_USER_ID,sys_ROLE_ID) values(2,2,2);

BEGIN;
INSERT INTO `Sys_permission` VALUES ('1', 'ROLE_HOME', 'home', '/', null), ('2', 'ROLE_ADMIN', 'ABel', '/admin', null);
COMMIT;

BEGIN;
INSERT INTO `Sys_permission_role` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '1');
COMMIT;
select * from sys_user
select * from sys_role
select * from sys_permission
select * from sys_role_user
select * from sys_permission_role