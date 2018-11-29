/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/24 9:32:45                           */
/*==============================================================*/


DROP TABLE IF EXISTS album;

DROP TABLE IF EXISTS audio;

DROP TABLE IF EXISTS video;

/*==============================================================*/
/* Table: album                                                 */
/*==============================================================*/
CREATE TABLE album
(
  rec_id         VARCHAR(30) NOT NULL,
  name           VARCHAR(30),
  intro          VARCHAR(2000),
  slogan         VARCHAR(200),
  type           VARCHAR(6) COMMENT '1 音频，2视频，3 书籍，4音频+视频，5音频+书籍，6视频+书籍，7音频+视频+书籍',
  cover          VARCHAR(200) COMMENT '封面图片URL',
  publish_status VARCHAR(6) COMMENT '0 未发布，1已发布',
  status         VARCHAR(6) COMMENT '0 删除，1正常',
  visit_num      BIGINT(11),
  create_id      VARCHAR(30),
  create_time    VARCHAR(30),
  update_id      VARCHAR(30),
  update_time    VARCHAR(30),
  PRIMARY KEY (rec_id)
);

ALTER TABLE album
  COMMENT '专辑';

/*==============================================================*/
/* Table: audio                                                 */
/*==============================================================*/
CREATE TABLE audio
(
  rec_id       VARCHAR(30) NOT NULL,
  name         VARCHAR(30),
  url          VARCHAR(500),
  intro        VARCHAR(2000),
  qr_code      VARCHAR(100),
  cover        VARCHAR(200) COMMENT '封面图片URL',
  belong_to    VARCHAR(10) COMMENT 'album 专辑，book书籍',
  belong_to_id VARCHAR(30) COMMENT '专辑或书籍主键',
  play_num     BIGINT(11) DEFAULT 0,
  create_id    VARCHAR(30),
  create_time  VARCHAR(30),
  update_id    VARCHAR(30),
  update_time  VARCHAR(30),
  PRIMARY KEY (rec_id)
);

ALTER TABLE audio
  COMMENT '音频';

/*==============================================================*/
/* Table: video                                                 */
/*==============================================================*/
CREATE TABLE video
(
  rec_id       VARCHAR(30) NOT NULL,
  name         VARCHAR(30),
  url          VARCHAR(500),
  intro        VARCHAR(2000),
  qr_code      VARCHAR(100),
  cover        VARCHAR(200) COMMENT '封面图片URL',
  belong_to    VARCHAR(10) COMMENT 'album 专辑，book书籍',
  belong_to_id VARCHAR(30) COMMENT '专辑或书籍主键',
  play_num     BIGINT(11) DEFAULT 0,
  create_id    VARCHAR(30),
  create_time  VARCHAR(30),
  update_id    VARCHAR(30),
  update_time  VARCHAR(30),
  PRIMARY KEY (rec_id)
);

ALTER TABLE video
  COMMENT '视频';

DROP TABLE IF EXISTS base_system_parameter;
CREATE TABLE base_system_parameter
(
  REC_ID                VARCHAR(30) PRIMARY KEY,
  PARAMETER_TYPE        VARCHAR(50)  NULL,
  PARAMETER_KEY         VARCHAR(100) NULL,
  PARAMETER_NAME        VARCHAR(100) NULL,
  PARAMETER_VALUE       VARCHAR(200) NULL,
  WEIGHT                INT(5)       NULL,
  PARENT_PARAMETER_TYPE VARCHAR(50)  NULL,
  PARENT_PARAMETER_KEY  VARCHAR(100) NULL,
  CREATE_TIME           VARCHAR(100) NULL,
  UPDATE_TIME           VARCHAR(100) NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;

CREATE INDEX key_v_t_pid_idx
  ON base_system_parameter (PARAMETER_KEY, PARAMETER_TYPE, PARAMETER_VALUE, PARENT_PARAMETER_KEY);

CREATE INDEX key_value_type_idx
  ON base_system_parameter (PARAMETER_KEY, PARAMETER_TYPE, PARAMETER_VALUE);
