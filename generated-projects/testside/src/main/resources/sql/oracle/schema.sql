drop table ycli_task;
drop table ycli_user;

create table ycli_task (
	id varchar2(32),
	title varchar2(128) not null,
	description varchar2(255),
	user_id number(19,0) not null,
	primary key (id)
);

create table ycli_user (
	id varchar2(32),
	login_name varchar2(64) not null unique,
	name varchar2(64) not null,
	password varchar2(255) not null,
	salt varchar2(64) not null,
	roles varchar2(255) not null,
	register_date date not null,
	primary key (id)
);


create sequence ycli_seq_task start with 100 increment by 20;
create sequence ycli_seq_user start with 100 increment by 20;
