

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
   rec_id      VARCHAR(30) PRIMARY KEY,
  `name`         varchar(30)   COMMENT '任务名称',
  intro                text comment '任务描述',
  study_type                varchar(30) comment '学习相关类型',
  study_id                varchar(30) comment '学习相关id',
  `status`             varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='任务';


