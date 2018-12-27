/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/27 10:08:43                          */
/*==============================================================*/


drop table if exists book;

/*==============================================================*/
/* Table: book                                                  */
/*==============================================================*/
create table book
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '书籍名称',
  intro                text comment '书籍描述',
  slogan               varchar(200) comment 'slogan',
  `type`               varchar(6) comment '书籍类型(1 音频，2视频，3音频+视频）',
  cover                varchar(200) comment '书籍封面(封面图片URL)',
  banner               varchar(200) comment 'banner',
  publish_status       varchar(6) comment '发布状态(0 未发布，1已发布)',
  status               varchar(6) comment '状态(0 删除，1正常)',
  order_num            int(3) comment '排序',
  visit_num            bigint(11) comment '访问数量',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
)
  ENGINE = InnoDB
  CHARSET = utf8;

drop table if exists recommend;

/*==============================================================*/
/* Table: recommend                                             */
/*==============================================================*/
create table recommend
(
  rec_id               varchar(30) not null comment '主键',
  recommendt_type      varchar(10) comment '被推荐类型(info:资讯,audio:音频,vedio:视频)',
  recommend_id         varchar(30) comment '被推荐主键',
  create_id            varchar(30) comment '推荐人',
  create_time          varchar(30) comment '推荐时间',
  start_time           varchar(30) comment '开始时间',
  end_time             varchar(30) comment '结束时间',
  primary key (rec_id)
)
  ENGINE = InnoDB
  CHARSET = utf8;

alter table recommend comment '推荐';



drop table if exists video;

/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
create table video
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '视频名称',
  url                  varchar(500) comment '视频链接',
  intro                text comment '简介',
  tag                  varchar(30) comment '标签( 研读，导读)',
  qr_code              varchar(100) comment '二维码',
  cover                varchar(200) comment '封面',
  belong_to            varchar(10) comment '属于哪个栏目(album 专辑，book书籍)',
  belong_to_id         varchar(30) comment '属于哪个栏目ID(专辑或书籍主键)',
  finish_num           bigint(11) comment '播放完成总数',
  play_num             bigint(11) default 0 comment '播放量',
  order_num            int(3) comment '排序',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
);

alter table video comment '视频';

alter table discuss add column reply_id varchar(30)  comment '回复评论' after comment_id;



