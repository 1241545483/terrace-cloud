# ALTER TABLE album
#   ADD COLUMN simple_intro VARCHAR(200) DEFAULT NULL
# COMMENT '简介'
#   AFTER intro;


ALTER TABLE album
  ADD COLUMN  tag  VARCHAR(200) DEFAULT NULL
COMMENT '标签'
  AFTER simple_intro;


