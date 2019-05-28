DROP TABLE IF EXISTS `class_code`;
CREATE TABLE `class_code` (
  `class_code` int not NULL auto_increment
  COMMENT '自增用于作为班级code码',
  `status`    varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id   VARCHAR (30) COMMENT '创建人',
  create_time  VARCHAR(30) COMMENT '创建时间',
  update_id    VARCHAR(30) COMMENT '更新人',
  update_time  VARCHAR(30) COMMENT '更新时间',
  primary key(class_code)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
alter TABLE class_code AUTO_INCREMENT=100000