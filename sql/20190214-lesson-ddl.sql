


DROP TABLE IF EXISTS lesson;

/*==============================================================*/
/* Table: lesson                                              */
/*==============================================================*/
CREATE TABLE lesson
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '课程名称',
  intro                text comment '课程描述',
  presentation         varchar(200) comment '课程视频介绍',
  image                varchar(200) comment '图片URL',
  banner               varchar(200) comment 'banner',
  publish_status       varchar(6) comment '发布状态(0 未发布，1已发布)',
  status               varchar(6) comment '状态(0 删除，1正常)',
  order_num            int(3) comment '排序',
  visit_num            bigint(11) comment '访问数量',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE lesson   COMMENT '课程';


DROP TABLE IF EXISTS section;

/*==============================================================*/
/* Table: section                                              */
/*==============================================================*/
CREATE TABLE section
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '章节名称',
  intro                text comment '章节描述',
  lession_id           varchar(30) comment '课程id ',
  image                varchar(200) comment '图片URL',
  banner               varchar(200) comment 'banner',
  publish_status       varchar(6) comment '发布状态(0 未发布，1已发布)',
  status               varchar(6) comment '状态(0 删除，1正常)',
  order_num            int(3) comment '排序',
  visit_num            bigint(11) comment '访问数量',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE section   COMMENT '章节';

ALTER TABLE topic
  ADD COLUMN  presentation  VARCHAR(200) DEFAULT NULL
COMMENT '电台视频介绍'
  AFTER intro;