


DROP TABLE IF EXISTS trade_order;

/*==============================================================*/
/* Table: trade_order                                              */
/*==============================================================*/
CREATE TABLE trade_order
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(30) comment '订单名称',
  intro                text comment '订单描述',
  pay_way              varchar(200) comment '支付页方式',
  price                varchar(100) comment '总价',
  status               varchar(6) comment '状态(0 删除，1正常)',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE  trade_order   COMMENT '订单';





DROP TABLE IF EXISTS  trade_order_detail;

/*==============================================================*/
/* Table: trade_order_detail                                              */
/*==============================================================*/
CREATE TABLE trade_order_detail
(

  rec_id               varchar(30) not null comment '主键',
  trate_order_id       varchar(30) comment '订单名称',
  original_price       varchar(50) comment '原价',
  present_price        varchar(50) comment '购买金额',
  name                 varchar(30) comment '商品名称',
  prod_type            varchar(30) comment '商品类型',
  prod_id              varchar(30) comment '商品id',
  intro                text comment '商品描述',
  preferential_way     varchar(50) comment '优惠方式',
  status               varchar(6) comment '状态(0 删除，1正常)',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  PRIMARY KEY (rec_id)
);

ALTER TABLE trade_order_detail   COMMENT '订单详情';


