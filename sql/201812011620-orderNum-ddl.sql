alter table album add column order_num int(3) comment '排序' after status ;
alter table audio add column order_num int(3) comment '排序' after play_num;
alter table video add column order_num int(3) comment '排序' after play_num;