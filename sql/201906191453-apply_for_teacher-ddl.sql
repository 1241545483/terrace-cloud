

DROP TABLE IF EXISTS `apply_for_teacher`;
CREATE TABLE `apply_for_teacher` (
   rec_id      VARCHAR(30) PRIMARY KEY,
  `name`       varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_id`    varchar(30) DEFAULT NULL COMMENT '用户id',
  `reason`       varchar(30) DEFAULT NULL COMMENT '申请原因',
  `status`             varchar(10) DEFAULT NULL COMMENT '状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='申请成为老师';



