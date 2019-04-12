

ALTER TABLE trade_order
  ADD COLUMN  pay_no  VARCHAR(100) DEFAULT NULL
COMMENT '支付订单号'
  AFTER intro;