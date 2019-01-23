

/*==============================================================*/
/* DBMS itemName:      MySQL 5.0                                    */
/* Created on:     2019/1/22 11:21:34                           */
/*==============================================================*/


drop table if exists category;
drop table if exists relevance_item;


/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
  rec_id               varchar(30) not null comment '主键',
  name                 varchar(200) comment '目录名字',
  pid                  varchar(30) comment '父级id',
  ppid                 varchar(30) comment '爷级id',
  level                varchar(30) comment '等级',
  weight                varchar(30) comment '排序',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
);

alter table category comment '推荐中高考书籍目录（三级）';


/*==============================================================*/
/* Table: CatItem                                              */
/*==============================================================*/
create table relevance_item
(
  rec_id               varchar(30) not null comment '主键',
  category_id              varchar(30) comment '目录id',
  item_id              varchar(30) comment '项目id',
  item_type            varchar(30) comment '类型',
  weight                varchar(30) comment '目录排序',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
);

alter table relevance_item comment '书籍与目录对应关系';