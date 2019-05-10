alter table member add column pic varchar(150) comment '头像' after mobile ;
alter table member add column audio_intro varchar(200) comment '音频介绍' after pic;
alter table member add column expert int(3) comment '是否是专家' after audio_intro;