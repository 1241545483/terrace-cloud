

DROP TABLE IF EXISTS `bind`;
CREATE TABLE `bind` (
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

DROP TABLE IF EXISTS `wx_login_state`;
CREATE TABLE `wx_login_state` (
  `rec_id` varchar(30) NOT NULL PRIMARY KEY,
  `openId` varchar(100) DEFAULT NULL,
  `unionId` varchar(100) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL COMMENT '登陆成功token',
  `status` varchar(10) DEFAULT NULL COMMENT '登陆状态',
  `status_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

