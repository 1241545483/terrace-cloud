DROP TABLE IF EXISTS media_counts;


CREATE TABLE media_counts
(
  rec_id      VARCHAR(30) NOT NULL COMMENT   '主键',
  media_id     VARCHAR(30) NOT NULL COMMENT '被播放ID',
  media_type  VARCHAR(30) NOT NULL COMMENT '播放类型',
  clicked     VARCHAR(10) COMMENT '点击音频，未播放完成',
  finished    VARCHAR(10) COMMENT '音频播放完成',
  create_id   VARCHAR(30) COMMENT '创建人',
  create_time VARCHAR(30) COMMENT '创建时间',
  PRIMARY KEY (rec_id )
);
alter table media_counts comment '统计播放量';

alter table audio add column finish_num bigint(11) DEFAULT 0 comment '播放完成总数' after play_num;
