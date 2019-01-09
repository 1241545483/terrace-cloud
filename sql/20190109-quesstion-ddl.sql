/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/9 9:49:51                             */
/*==============================================================*/


drop table if exists issue;

drop table if exists issue_answer;

drop table if exists issue_item;

/*==============================================================*/
/* Table: issue                                                 */
/*==============================================================*/
create table issue
(
  rec_id               varchar(30) not null comment '主键',
  content              varchar(500) comment '题目内容',
  belong_to            varchar(10) comment '属于哪个栏目(album 专辑，book书籍)',
  belong_to_id         varchar(30) comment '属于哪个栏目ID(专辑或书籍主键)',
  img1                 varchar(200) comment '图片1',
  img2                 varchar(200) comment '图片2',
  img3                 varchar(200) comment '图片3',
  type                 varchar(6) comment '题目类型(single 单选，multi多选)',
  analysis             varchar(500) comment '题目解析',
  difficulty           varchar(6) comment '难度系数',
  status               varchar(6) comment '状态(0 删除，1正常)',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
);

alter table issue comment '观看视频回答题目';

/*==============================================================*/
/* Table: issue_answer                                          */
/*==============================================================*/
create table issue_answer
(
  rec_id               varchar(30) not null comment '主键',
  issue_id             varchar(30) not null comment '题目主键',
  item_id              varchar(30) not null comment '选项主键',
  status               varchar(6) comment '状态(0 删除，1正常)',
  create_id            varchar(30) comment '回答人',
  create_time          varchar(30) comment '回答时间',
  primary key (rec_id)
);

alter table issue_answer comment '问题回答';

/*==============================================================*/
/* Table: issue_item                                            */
/*==============================================================*/
create table issue_item
(
  rec_id               varchar(30) not null comment '主键',
  issue_id             varchar(30) not null comment '题目主键',
  content              varchar(500) comment '选项内容',
  img1                 varchar(200) comment '图片1',
  img2                 varchar(200) comment '图片2',
  img3                 varchar(200) comment '图片3',
  is_answer            varchar(6) comment '是否正确答案(0否,1是)',
  create_id            varchar(30) comment '创建人',
  create_time          varchar(30) comment '创建时间',
  update_id            varchar(30) comment '更新人',
  update_time          varchar(30) comment '更新时间',
  primary key (rec_id)
);

alter table issue_item comment '题目选项';

