drop table if exists ycli_task;
drop table if exists ycli_user;

create table ycli_task (
	id varchar(32),
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
);

create table ycli_user (
	id varchar(32),
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null,
	primary key (id)
);