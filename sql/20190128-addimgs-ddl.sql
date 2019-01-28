alter table album add column pc_cover varchar(200) DEFAULT NULL COMMENT  'pc端封面图片URL' after cover ;
alter table album add column pc_banner varchar(200) DEFAULT NULL COMMENT  'pc替换封面图片URL' after banner ;
alter table audio add column pc_cover varchar(200) DEFAULT NULL COMMENT  'pc端音频封面图片URL' after cover ;
alter table video add column pc_cover varchar(200) DEFAULT NULL COMMENT  'pc端封面视频图片URL' after cover ;
alter table book add column pc_cover varchar(200) DEFAULT NULL COMMENT  'pc端书籍封面' after cover ;
alter table book add column pc_banner varchar(200) DEFAULT NULL COMMENT  'pc替换书籍封面' after banner ;