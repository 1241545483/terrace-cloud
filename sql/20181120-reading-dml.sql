/*阅读类型*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('1','Reading_Type', '1', '阅读类型', '音频', 1, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('2','Reading_Type', '2', '阅读类型', '视频', 2, now(),now());

/*发布状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('21','Publish_Status', '0', '发布状态', '未发布', 3, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('22','Publish_Status', '1', '发布状态', '未发布', 4, now(),now());


/*状态*/
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('31','Status', '0', '状态', '删除', 5, now(),now());
INSERT INTO base_system_parameter
(REC_ID,PARAMETER_TYPE, PARAMETER_KEY, PARAMETER_NAME, PARAMETER_VALUE, WEIGHT, CREATE_TIME, UPDATE_TIME)
VALUES ('32','Status', '1', '状态', '正常', 6, now(),now());

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