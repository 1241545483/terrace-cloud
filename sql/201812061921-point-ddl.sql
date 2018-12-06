/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/6 19:19:53                           */
/*==============================================================*/


drop table if exists member;

drop table if exists my_signin;

/*==============================================================*/
/* Table: member                                                */
/*==============================================================*/
create table member
(
   user_id              varchar(30) not null comment '用户（当前登录的用户信息）',
   point                int(8) comment '积分',
   create_id            varchar(30) comment '创建人',
   create_time          varchar(30) comment '创建时间',
   update_id            varchar(30) comment '更新人',
   update_time          varchar(30) comment '更新时间',
   primary key (user_id)
);

alter table member comment '用户信息';


/*==============================================================*/
/* Table: my_signin                                             */
/*==============================================================*/
create table my_signin
(
   rec_id               varchar(30) not null comment '主键',
   point                int(8) comment '签到获得的积分',
   create_id            varchar(30) comment '签到人',
   create_time          varchar(30) comment '签到时间',
   primary key (rec_id)
);

alter table my_signin comment '我的签到';

create index idx_userid on my_signin
(
   create_id
);
