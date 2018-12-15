DROP TABLE IF EXISTS share_image;


CREATE TABLE share_image
(
  rec_id      VARCHAR(30) NOT NULL COMMENT   '主键',
  user_id     VARCHAR(30) NOT NULL COMMENT '用户（当前登录的用户信息）',
  share_type  VARCHAR(10) COMMENT '被分享的类型(audio:音频,video:视频)',
  share_id    VARCHAR(30) COMMENT '被分享主键',
  url         VARCHAR(500) COMMENT '分享图片URL',
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  update_id   VARCHAR(30) COMMENT '更新人',
  update_time VARCHAR(30) COMMENT '更新时间',
  PRIMARY KEY (rec_id )
);
alter table share_image comment '分享图片';