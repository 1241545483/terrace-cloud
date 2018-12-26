DROP TABLE IF EXISTS feedback;


CREATE TABLE feedback
(
  rec_id       VARCHAR(30) NOT NULL COMMENT   '主键',
  content      TEXT COMMENT '意见',
  create_id    VARCHAR(30) NOT NULL COMMENT '用户（当前登录的用户信息）',
  create_time  VARCHAR(30) COMMENT '创建时间',
  PRIMARY KEY (rec_id )
);
alter table feedback comment '意见反馈';