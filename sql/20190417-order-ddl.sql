

ALTER TABLE trade_order ADD COLUMN  import_data   VARCHAR(20) DEFAULT NULL COMMENT '是否为导入数据' AFTER rec_id;


