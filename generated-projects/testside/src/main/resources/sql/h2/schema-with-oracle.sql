drop table if exists ycli_task;
drop table if exists ycli_user;

create table ycli_task (
	id varchar(32),
	title varchar(128) not null,
	description varchar(255),
    create_by varchar(64) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	update_by varchar(64) COMMENT '更新者',
	update_date datetime COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
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


create sequence ycli_seq_task start with 100 increment by 20;
create sequence ycli_seq_user start with 100 increment by 20;