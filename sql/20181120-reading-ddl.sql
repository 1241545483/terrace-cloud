/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/20 10:40:57                          */
/*==============================================================*/ 

drop table if exists album;

drop table if exists media_list;

drop table if exists video_list;

/*==============================================================*/
/* Table: album                                                 */
/*==============================================================*/
create table album
(
   rec_id               varchar(30) not null,
   name                 varchar(30),
   intro                varchar(2000),
   type                 varchar(6) comment '1 音频，2视频，3 书籍，4音频+视频，5音频+书籍，6视频+书籍，7音频+视频+书籍',
   cover                varchar(200) comment '封面图片URL',
   publish_status       varchar(6) comment '0 未发布，1已发布',
   status               varchar(6) comment '0 删除，1正常',
   visit_num            bigint(11),
   create_id            varchar(30),
   create_time          varchar(30),
   update_id            varchar(30),
   update_time          varchar(30),
   primary key (rec_id)
);

/*==============================================================*/
/* Table: media_list                                            */
/*==============================================================*/
create table media_list
(
   rec_id               varchar(30) not null,
   name                 varchar(30),
   url                  varchar(500),
   belong_to            varchar(10) comment 'album 专辑，book书籍',
   belong_to_id         varchar(30) comment '专辑或书籍主键',
   play_num             bigint(11) default 0,
   create_id            varchar(30),
   create_time          varchar(30),
   update_id            varchar(30),
   update_time          varchar(30),
   primary key (rec_id)
);

/*==============================================================*/
/* Table: video_list                                            */
/*==============================================================*/
create table video_list
(
   rec_id               varchar(30) not null,
   name                 varchar(30),
   url                  varchar(500),
   belong_to            varchar(10) comment 'album 专辑，book书籍',
   belong_to_id         varchar(30) comment '专辑或书籍主键',
   play_num             bigint(11) default 0,
   create_id            varchar(30),
   create_time          varchar(30),
   update_id            varchar(30),
   update_time          varchar(30),
   primary key (rec_id)
);

create table base_system_parameter
(
  REC_ID varchar(30) primary key,
  PARAMETER_TYPE varchar(50) null,
  PARAMETER_KEY varchar(100) null,
  PARAMETER_NAME varchar(100) null,
  PARAMETER_VALUE varchar(200) null,
  WEIGHT int(5) null,
  PARENT_PARAMETER_TYPE varchar(50) null,
  PARENT_PARAMETER_KEY varchar(100) null,
  CREATE_TIME varchar(100) null,
  UPDATE_TIME varchar(100) null
)
  engine=InnoDB charset=utf8;

create index key_v_t_pid_idx
  on base_system_parameter (PARAMETER_KEY, PARAMETER_TYPE, PARAMETER_VALUE, PARENT_PARAMETER_KEY);

create index key_value_type_idx
  on base_system_parameter (PARAMETER_KEY, PARAMETER_TYPE, PARAMETER_VALUE);
