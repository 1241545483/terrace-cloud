
DELETE FROM role_model_mapping;

insert into role_model_mapping values
(1,1,'teacher',1,1,1,now(),now()),
(2,1,'student',1,1,1,now(),now()),
(3,1,'vip',1,1,1,now(),now());

DELETE FROM model_operate;
insert into model_operate values
(1,1,'CREATE_DISCUSS','',1,1,1,now(),now()),
(2,1,'DELETE_DISCUSS','',1,1,1,now(),now()),
(3,1,'ADD_COLLECT','',1,1,1,now(),now()),
(4,1,'DELETE_COLLECT','',1,1,1,now(),now())
;