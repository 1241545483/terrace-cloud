DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id`        VARCHAR(20)        PRIMARY KEY,
  `login_name`     VARCHAR(50)          DEFAULT NULL,
  `login_alais`    VARCHAR(50)          DEFAULT NULL
  COMMENT '登录别名',
  `login_pass`     VARCHAR(200)         DEFAULT NULL,
  `reg_way`        VARCHAR(20)          DEFAULT NULL
  COMMENT '目前小程序传递过来的 READING-WX标识',
  `user_name`      VARCHAR(200)         DEFAULT NULL,
  `status`         VARCHAR(20)          DEFAULT NULL
  COMMENT '正常、受限、冻结',
  `last_logindttm` DATETIME             DEFAULT NULL
  COMMENT '基于日志判断，库表中不存相关数据信息了',
  `org_id`       VARCHAR(20)          DEFAULT NULL,
  `user_img`       VARCHAR(100)         DEFAULT NULL,
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  update_id   VARCHAR(30) COMMENT '更新人',
  update_time VARCHAR(30) COMMENT '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户信息表(登录账户)';


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  rec_id      VARCHAR(30) PRIMARY KEY,
  `user_id`   VARCHAR(20)  DEFAULT NULL,
  `role_id`   VARCHAR(20)  DEFAULT NULL
  COMMENT '具体某个角色',
  `app_key`   VARCHAR(20)  DEFAULT NULL
  COMMENT '业务系统的appkey',
  `org_id`    VARCHAR(100) DEFAULT NULL COMMENT '不同组织中不同的角色使用到',
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  update_id   VARCHAR(30) COMMENT '更新人',
  update_time VARCHAR(30) COMMENT '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='阅读这边目前就只有老师，学生';


DROP TABLE IF EXISTS `connection`;
CREATE TABLE `connection` (
  rec_id      VARCHAR(30) PRIMARY KEY,
  `user_id`   VARCHAR(255) DEFAULT NULL,
  `privide`   VARCHAR(255) DEFAULT NULL  COMMENT '来源，目前来WEIXIN',
  `open_id`   VARCHAR(255) DEFAULT NULL,
  `union_id`  VARCHAR(255) DEFAULT NULL,
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  update_id   VARCHAR(30) COMMENT '更新人',
  update_time VARCHAR(30) COMMENT '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='储存用户绑定关系表，用户和对应的openId，unionId等';


DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  org_id          VARCHAR(30) PRIMARY KEY  COMMENT '机构id',
  `org_name`      VARCHAR(200) DEFAULT NULL,
  `status`        VARCHAR(2)   DEFAULT NULL,
  `org_nature`    VARCHAR(10)  DEFAULT NULL
  COMMENT '1. 管理性质',
  `parent_org_id` VARCHAR(20)  DEFAULT NULL
  COMMENT '上级单位是指： 行政上的隶属关系',
  `org_location`  VARCHAR(100) DEFAULT NULL,
  create_id       VARCHAR(30) COMMENT '创建人',
  create_time     VARCHAR(30) COMMENT '创建时间',
  update_id       VARCHAR(30) COMMENT '更新人',
  update_time     VARCHAR(30) COMMENT '更新时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='组织机构';


DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  rec_id         VARCHAR(30) PRIMARY KEY,
  `menu_id`      VARCHAR(30)  DEFAULT NULL
  COMMENT '菜单ID',
  `operate_desc` VARCHAR(100) DEFAULT NULL,
  `name`         VARCHAR(50)  DEFAULT NULL
  COMMENT '模块名称',
  `status`       VARCHAR(20)  DEFAULT NULL,
  create_id      VARCHAR(30) COMMENT '创建人',
  create_time    VARCHAR(30) COMMENT '创建时间',
  update_id      VARCHAR(30) COMMENT '更新人',
  update_time    VARCHAR(30) COMMENT '更新时间'

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='系统模块';

DROP TABLE IF EXISTS `model_operate`;
CREATE TABLE `model_operate` (
  rec_id        VARCHAR(30) PRIMARY KEY,
  `model_id`    VARCHAR(30)  DEFAULT NULL,
  `code`        VARCHAR(255) DEFAULT NULL
  COMMENT '组装的请求方式和方法，用来判断是否有访问权限',
  `desc`        VARCHAR(200) DEFAULT NULL,
  `status`      VARCHAR(20)  DEFAULT NULL,
  `create_id`   VARCHAR(20)  DEFAULT NULL,
  `update_id`   VARCHAR(20)  DEFAULT NULL,
  `create_time` VARCHAR(20)  DEFAULT NULL,
  `update_time` VARCHAR(20)  DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='系统模块和code的关系';


DROP TABLE IF EXISTS `role_model_mapping`;
CREATE TABLE `role_model_mapping` (
  rec_id        VARCHAR(30) PRIMARY KEY,
  `model_id`    VARCHAR(30) DEFAULT NULL,
  `role_id`     VARCHAR(20) DEFAULT NULL,
  `status`      VARCHAR(20) DEFAULT NULL,
  `create_id`   VARCHAR(20) DEFAULT NULL,
  `update_id`   VARCHAR(20) DEFAULT NULL,
  `create_time` VARCHAR(20) DEFAULT NULL,
  `update_time` VARCHAR(20) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT ='系统模块和角色的关系';

