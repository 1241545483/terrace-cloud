

DROP TABLE IF EXISTS `task_note`;
CREATE TABLE `task_note` (
   rec_id      VARCHAR(30) PRIMARY KEY,
  `note`       text COMMENT '笔记',
  `user_id`    varchar(30) DEFAULT NULL COMMENT '用户id',
  `task_id`    varchar(30) DEFAULT NULL COMMENT '任务主键',
  `img1`       varchar(200) DEFAULT NULL COMMENT '图片1',
  `img2`      varchar(200) DEFAULT NULL COMMENT '图片2',
  `img3`      varchar(200) DEFAULT NULL COMMENT '图片3',
  `status`             varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='任务笔记';



