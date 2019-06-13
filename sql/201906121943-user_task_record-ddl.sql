

DROP TABLE IF EXISTS `user_task_record`;
CREATE TABLE `user_task_record` (
   rec_id      VARCHAR(30) PRIMARY KEY,
  task_id                varchar(30) comment '学习相关id',
  user_id                varchar(30) comment '班级id',
  `status`             varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='任务接受记录';



