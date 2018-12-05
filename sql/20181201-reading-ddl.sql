/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/1 9:48:13                            */
/*==============================================================*/

drop table if exists discuss;

drop table if exists information;

drop table if exists my_collect;

drop table if exists my_like;

/*==============================================================*/
/* Table: discuss                                               */
/*==============================================================*/
create table discuss
(
   rec_id               varchar(30) not null comment '主键',
   comment_type         varchar(10) comment '被评论类型(info:资讯,reply:评论回复)',
   comment_id           varchar(30) comment '被评论主键',
   content              varchar(2000) comment '评论内容',
   like_num             bigint(11)  DEFAULT 0 comment '点赞数量',
   status               varchar(6) comment '评论状态(0:删除,1正常)',
   create_id            varchar(30) comment '评论人',
   create_time          varchar(30) comment '评论时间',
   primary key (rec_id)
);

alter table discuss comment '评论表';

/*==============================================================*/
/* Index: idx_discuss                                           */
/*==============================================================*/
create index idx_discuss on discuss
(
   comment_type,
   comment_id,
   status,
   create_id
);

/*==============================================================*/
/* Table: information                                           */
/*==============================================================*/
create table information
(
   rec_id               varchar(30) not null comment '主键',
   title                varchar(100) comment '标题',
   author               varchar(10) comment '作者',
   content              text comment '内容',
   cover                varchar(200) comment '封面',
   read_num             bigint(11)  DEFAULT 0 comment '阅读数量',
   like_num             bigint(11)  DEFAULT 0 comment '点赞数量',
   publish_status       varchar(6) comment '0 未发布，1已发布',
   status               varchar(6) comment '0 删除，1正常',
   create_id            varchar(30) comment '创建人',
   create_time          varchar(30) comment '创建时间',
   update_id            varchar(30) comment '更新人',
   update_time          varchar(30) comment '更新时间',
   primary key (rec_id)
);

alter table information comment '资讯模块';

/*==============================================================*/
/* Table: my_collect                                            */
/*==============================================================*/
create table my_collect
(
   rec_id               varchar(30) not null comment '主键',
   collect_type         varchar(10) comment '被收藏类型(info:资讯,audio:音频,vedio:视频)',
   collect_id           varchar(30) comment '被收藏主键',
   create_id            varchar(30) comment '收藏人',
   create_time          varchar(30) comment '收藏时间',
   primary key (rec_id)
);

alter table my_collect comment '我的收藏';

/*==============================================================*/
/* Index: idx_collect                                           */
/*==============================================================*/
create index idx_collect on my_collect
(
   collect_type,
   collect_id,
   create_id
);

/*==============================================================*/
/* Table: my_like                                               */
/*==============================================================*/
create table my_like
(
   rec_id               varchar(30) not null comment '主键',
   like_type            varchar(10) comment '被点赞类型(info:资讯,audio:音频,vedio:视频)',
   like_id              varchar(30) comment '被点赞主键',
   create_id            varchar(30) comment '点赞人',
   create_time          varchar(30) comment '点赞时间',
   primary key (rec_id)
);

alter table my_like comment '我的点赞';

/*==============================================================*/
/* Index: idx_like                                              */
/*==============================================================*/
create index idx_like on my_like
(
   like_type,
   like_id,
   create_id
);