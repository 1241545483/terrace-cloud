# ALTER TABLE album
#   ADD COLUMN topic_id VARCHAR(30) DEFAULT NULL
# COMMENT '主题'
#   AFTER type;


DROP TABLE IF EXISTS topic;


/*==============================================================*/
/* Table: topic                                              */
/*==============================================================*/
CREATE TABLE topic
(
  rec_id           VARCHAR(30) NOT NULL
  COMMENT '主键',
  name             VARCHAR(200) COMMENT '目录名字',
  cover            VARCHAR(30) COMMENT '替换封面url',
  `pc_cover`       VARCHAR(200) DEFAULT NULL
  COMMENT 'pc端封面图片URL',
  `banner`         VARCHAR(200) DEFAULT NULL
  COMMENT '替换封面图片URL',
  `pc_banner`      VARCHAR(200) DEFAULT NULL
  COMMENT 'pc替换封面图片URL',
  intro            TEXT,
  `slogan`         VARCHAR(200) DEFAULT NULL,
  `publish_status` VARCHAR(6)   DEFAULT NULL
  COMMENT '0 未发布，1已发布',
  `status`         VARCHAR(6)   DEFAULT NULL
  COMMENT '0 删除，1正常',
  order_num        INT(3) COMMENT '排序',
  detail           VARCHAR(30) COMMENT '',
  create_id        VARCHAR(30) COMMENT '创建人',
  create_time      VARCHAR(30) COMMENT '创建时间',
  update_id        VARCHAR(30) COMMENT '更新人',
  update_time      VARCHAR(30) COMMENT '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE topic
  COMMENT '主题，关联专辑';



