


DROP TABLE IF EXISTS lesson;

/*==============================================================*/
/* Table: lesson                                              */
/*==============================================================*/
CREATE TABLE lesson
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '课程名称',
  simple_intro         varchar(500) comment '课程名称',
  intro                text comment '课程描述',
  audio_intro          varchar(200) comment '课程音频介绍',
  video_intro          varchar(200) comment '课程视频介绍',
  image                varchar(200) comment '图片URL',
  banner               varchar(200) comment 'banner',
  discount             varchar(30) comment '折扣',
  tag                  varchar(200) comment '标签',
  original_price       varchar(50) comment '原价',
  present_price        varchar(50) comment '现价',
  expert_id              varchar(50) comment '专家id',
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





DROP TABLE IF EXISTS expert;

/*==============================================================*/
/* Table: expert                                              */
/*==============================================================*/
CREATE TABLE expert
(
  rec_id               varchar(30) not null comment '主键',
  user_id              varchar(30) comment '专家自己id，以后专家登录使用（暂时用不上）',
  name                 varchar(30) comment '专家名称',
  intro                text comment '专家描述',
  image                varchar(200) comment '专家头像',
  title               varchar(200) comment '专家头衔',
  status               varchar(6) comment '状态(0 删除，1正常)',
  order_num            int(3) comment '排序',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE expert   COMMENT '专家';


DROP TABLE IF EXISTS purchase_record;

/*==============================================================*/
/* Table: purchase_record                                              */
/*==============================================================*/
CREATE TABLE purchase_record
(
  rec_id               varchar(30) not null comment '主键',
  user_id              varchar(30) comment '购买者id',
  lesson_id             varchar(30) comment '课程id',
  price                varchar(200) comment '价格',
  pay_way           varchar(30) comment '支付方式（1.微信 ，2.支付宝，3.其他三方）',
  operations           varchar(30) comment '购买方式（1.正常购买， 2.学校统一购买）',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE purchase_record   COMMENT '购买记录';

ALTER TABLE video
  ADD COLUMN  free  VARCHAR(30) DEFAULT NULL
COMMENT '免费观看'
  AFTER belong_to_id;