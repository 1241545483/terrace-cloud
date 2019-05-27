
DROP TABLE IF EXISTS `wx_login_state`;
CREATE TABLE `wx_login_state` (
  `rec_id` varchar(30) NOT NULL PRIMARY KEY,
  `openId` varchar(100) DEFAULT NULL,
  `unionId` varchar(100) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL COMMENT '登陆成功token',
  `status` varchar(10) DEFAULT NULL COMMENT '登陆状态',
  `status_desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;