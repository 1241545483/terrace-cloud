

ALTER TABLE trade_order ADD COLUMN  start_time   VARCHAR(20) DEFAULT NULL COMMENT 'vip开始时间' AFTER create_time;
ALTER TABLE trade_order ADD COLUMN  end_time   VARCHAR(20) DEFAULT NULL COMMENT 'vip结束时间' AFTER create_time;

