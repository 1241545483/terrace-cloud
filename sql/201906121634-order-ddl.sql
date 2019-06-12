

ALTER TABLE trade_order ADD COLUMN  finish_time   VARCHAR(20) DEFAULT NULL COMMENT '订单完成时间' AFTER create_time;


