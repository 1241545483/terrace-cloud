

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
   rec_id      VARCHAR(30) PRIMARY KEY,
  `name`         varchar(30)   COMMENT '任务名称',
  intro                text comment '任务描述',
  study_type                varchar(30) comment '学习相关类型',
  study_id                varchar(30) comment '学习相关id',
  class_id                varchar(30) comment '班级id',
  `status`             varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='任务';


DROP TABLE IF EXISTS `task_study_mapping`;
CREATE TABLE `task_study_mapping` (
  rec_id        VARCHAR(30) PRIMARY KEY,
  `task_id`    VARCHAR(30) DEFAULT NULL,
  `study_id`     VARCHAR(20) DEFAULT NULL,
  study_type    varchar(30) comment '学习相关类型',
  `status`      VARCHAR(20) DEFAULT NULL,
  `create_id`   VARCHAR(20) DEFAULT NULL,
  `update_id`   VARCHAR(20) DEFAULT NULL,
  `create_time` VARCHAR(20) DEFAULT NULL,
  `update_time` VARCHAR(20) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='任务和学习课程的关系';


