
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `rec_id`             varchar(30) NOT NULL PRIMARY KEY,
  `class_code`         varchar(30) DEFAULT NULL  COMMENT '班级码用于学生搜索班级码加入学生',
  intro                text comment '班级描述',
  qr_code              VARCHAR(100),
  cover                varchar(200) comment '班级封面(封面图片URL)',
  `status`             varchar(10) DEFAULT NULL COMMENT '班级状态',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `class_student_mapping`;
CREATE TABLE `class_student_mapping` (
  rec_id        VARCHAR(30) PRIMARY KEY,
  `class_id`    VARCHAR(30) DEFAULT NULL,
  `student_id`     VARCHAR(20) DEFAULT NULL,
  `status`      VARCHAR(20) DEFAULT NULL,
  `create_id`   VARCHAR(20) DEFAULT NULL,
  `update_id`   VARCHAR(20) DEFAULT NULL,
  `create_time` VARCHAR(20) DEFAULT NULL,
  `update_time` VARCHAR(20) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='班级和学生的关系';