ALTER TABLE album
  ADD COLUMN topic_id VARCHAR(30) DEFAULT NULL
COMMENT '主题'
  AFTER type;


DROP TABLE IF EXISTS topic;


/*==============================================================*/
/* Table: topic                                              */
/*==============================================================*/
CREATE TABLE topic
(
  rec_id      VARCHAR(30) NOT NULL COMMENT '主键',
  name        VARCHAR(200) COMMENT '目录名字',
  banner      VARCHAR(30) COMMENT '封面url',
  order_num   INT(3) COMMENT '排序',
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  update_id   VARCHAR(30) COMMENT '更新人',
  update_time VARCHAR(30) COMMENT '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE topic COMMENT '主题，关联专辑';
