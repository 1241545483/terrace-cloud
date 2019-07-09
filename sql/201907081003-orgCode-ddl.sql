DROP TABLE IF EXISTS `org_code`;
CREATE TABLE `org_code` (
  `org_code` int not NULL auto_increment
  COMMENT '自增用于作为班级code码',
  `status`    varchar(10) DEFAULT NULL COMMENT '班级状态',
  qr_code              VARCHAR(100),
  create_id   VARCHAR (30) COMMENT '创建人',
  create_time  VARCHAR(30) COMMENT '创建时间',
  update_id    VARCHAR(30) COMMENT '更新人',
  update_time  VARCHAR(30) COMMENT '更新时间',
  primary key(org_code)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
alter TABLE org_code AUTO_INCREMENT=10000