/*阅读类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('1','Reading_Type', '1', '阅读类型', '音频', 1, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('2','Reading_Type', '2', '阅读类型', '视频', 2, now(),now());

/*专辑发布状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('21','Album_Publish_Status', '0', '专辑发布状态', '未发布', 3, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('22','Album_Publish_Status', '1', '专辑发布状态', '已发布', 4, now(),now());


/*专辑状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('31','Album_Status', '0', '专辑状态', '删除', 5, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('32','Album_Status', '1', '专辑状态', '正常', 6, now(),now());

/*音频类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('41','Audio_Type', 'album', '音频类型', '专辑', 7, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('42','Audio_Type', 'book', '音频类型', '书籍', 8, now(),now());

/*视频类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('51','Video_Type', 'album', '视频类型', '专辑', 9, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('52','Video_Type', 'book', '视频类型', '书籍', 10, now(),now());

/*被评论类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('61','Comment_Type', 'info', '被评论类型', '资讯', 11, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('62','Comment_Type', 'reply', '被评论类型', '评论回复', 12, now(),now());

/*评论状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('71','Review_Status', '0', '评论状态', '删除', 13, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('72','Review_Status', '1', '评论状态', '正常', 14, now(),now());

/*资讯发布状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('81','Information_publish_status ', '0', '资讯发布状态', '未发布', 15, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('82','Information_publish_status ', '1', '资讯发布状态', '已发布', 16, now(),now());

/*资讯状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('91','Information_status ', '0', '资讯状态', '删除', 17, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('92','Information_status ', '1', '资讯状态', '正常', 18, now(),now());

/*被收藏类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('101','collect_type ', 'info', '被收藏类型', '资讯', 19, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('102','collect_type ', 'audio', '被收藏类型', '音频', 20, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('103','collect_type ', 'vedio', '被收藏类型', '视频', 21, now(),now());


/*被点赞类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('104','like_type  ', 'info', '被点赞类型', '资讯', 22, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('105','like_type  ', 'audio', '被点赞类型', '音频', 23, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('106','like_type  ', 'vedio', '被点赞类型', '视频', 24, now(),now());