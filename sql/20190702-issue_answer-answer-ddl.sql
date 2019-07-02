

ALTER TABLE issue_answer ADD COLUMN  answer   TEXT  DEFAULT NULL COMMENT '文字回答' AFTER item_id;

