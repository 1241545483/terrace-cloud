/*
Navicat MySQL Data Transfer

Source Server         : ali01(远程数据库！！！)
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : reading

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-05-10 09:25:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `album`
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `rec_id` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `intro` text,
  `simple_intro` varchar(200) DEFAULT NULL COMMENT '简介',
  `tag` varchar(200) DEFAULT NULL COMMENT '标签',
  `slogan` varchar(200) DEFAULT NULL,
  `type` varchar(6) DEFAULT NULL COMMENT '1 音频，2视频，3 书籍，4音频+视频，5音频+书籍，6视频+书籍，7音频+视频+书籍',
  `topic_id` varchar(30) DEFAULT NULL COMMENT '主题',
  `cover` varchar(200) DEFAULT NULL COMMENT '封面图片URL',
  `pc_cover` varchar(200) DEFAULT NULL COMMENT 'pc端封面图片URL',
  `banner` varchar(200) DEFAULT NULL COMMENT '替换封面图片URL',
  `pc_banner` varchar(200) DEFAULT NULL COMMENT 'pc替换封面图片URL',
  `publish_status` varchar(6) DEFAULT NULL COMMENT '0 未发布，1已发布',
  `status` varchar(6) DEFAULT NULL COMMENT '0 删除，1正常',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `visit_num` bigint(11) DEFAULT '0',
  `create_id` varchar(30) DEFAULT NULL,
  `create_time` varchar(30) DEFAULT NULL,
  `update_id` varchar(30) DEFAULT NULL,
  `update_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('ID515536127436783616', '父母学堂', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '只为你讲述科学、专业的教育书籍~', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', '', 'http://img.jssns.cn/SHILU/1/c54e70ca1c02ee1c1684f023c98ae996.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '0', '0', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536127436783617', '《园丁与木匠》', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '作为父母，你可以选择像木匠一样把孩子雕刻成你想要的样子，也可以像园丁一样让孩子成长为自己喜欢的样子。', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', 'ID51553612743678361', 'http://img.jssns.cn/SHILU/1/c04aab1c5db3e8edc0494135958bc831.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '1', '1', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536127436783618', '《俗物与天才》', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '孩子宛如一张白纸，他的命运取决于你在上面写下的是俗物还是天才。', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', 'ID51553612743678361', 'http://img.jssns.cn/SHILU/1/f6bcd48c40008589331efe21425508fa.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '1', '1', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536127436783619', '《宝宝也是哲学家》', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '作为父母，我们应当转变自己根深蒂固的陈腐看法，真正尊重孩子。', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', 'ID51553612743678361', 'http://img.jssns.cn/SHILU/1/6bbe261a8a87b1558f11b3403da04bd7.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '1', '1', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536127436783620', '《教养的迷思》', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '对孩子的人格养成起决定性作用的并不是家庭教育，而是孩子所在的同龄人群体。', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', 'ID51553612743678361', 'http://img.jssns.cn/SHILU/1/5511cd1d873d132079369c9bed407e0b.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '1', '1', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536127436783621', '《培养孩子从画画开始》', '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', '10年前就被誉为早教圣经会告诉你，该如何正确地培养孩子画画！', '点击收听', '只为你讲述科学、专业的教育书籍~', 'media', 'ID51553612743678361', 'http://img.jssns.cn/SHILU/1/29386907c1d15f5308adc7c447f71f62.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '1', '1', '5', '0', '432228697144033280', '2018-11-23 14:36:30', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536344454266880', '儿童哲学', '<p class=\"ql-align-justify\">每个孩子都是天生的哲学家，只需适当的引导，孩子就会变成一个热爱生活、充满激情的人。</p><p><br></p><p class=\"ql-align-justify\">儿童哲学针对的是4—12岁之间的孩子，通过趣味故事来讲解<span style=\"color: rgb(252, 88, 50);\">“生与死”、“对与错”、“爱与恨</span>”等孩子好奇家长犯难的话题，以此来增加孩子的见识。</p><p class=\"ql-align-justify\">&nbsp;</p><p class=\"ql-align-justify\">目前《时间管理》主题已经全部上架，第二季的《生与死》也将陆续更新，欢迎收听！</p><p class=\"ql-align-justify\"><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45277119159029623.jpg\"></p>', '陪孩子一起探究世界和人生的真相！', '第一季', '陪孩子一起探究世界和人生的真相！', 'media', '', 'http://img.jssns.cn/SHILU/1/a56b3a04c77a6c03fea99b38ca8492d8.png', null, 'http://img.jssns.cn/SHILU/1/f91a2a65b6101c0e1b5e1647dd05fb90.png', null, '0', '0', '2', '0', '432228697144033280', '2018-11-23 14:37:22', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515536344454266881', '珍惜时间', '<p class=\"ql-align-justify\">每个孩子都是天生的哲学家，只需适当的引导，孩子就会变成一个热爱生活、充满激情的人。</p><p><br></p><p class=\"ql-align-justify\">儿童哲学针对的是4—12岁之间的孩子，通过趣味故事来讲解<span style=\"color: rgb(252, 88, 50);\">“生与死”、“对与错”、“爱与恨</span>”等孩子好奇家长犯难的话题，以此来增加孩子的见识。</p><p class=\"ql-align-justify\">&nbsp;</p><p class=\"ql-align-justify\">目前《时间管理》主题已经全部上架，第二季的《生与死》也将陆续更新，欢迎收听！</p><p class=\"ql-align-justify\"><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45277119159029623.jpg\"></p>', '时间是什么？怎么利用好时间？怎么让自己的时间自由？', '第一季', '陪孩子一起探究世界和人生的真相！', 'media', 'ID51553634445426688', 'http://img.jssns.cn/SHILU/1/28732b81e019f83422e5a3b8f08cc2a1.jpg', 'http://img.jssns.cn/SHILU/1/9e511b213c886a092bb2b825c2210b53.jpeg', 'http://img.jssns.cn/SHILU/1/c7aa52071049bfe8c4bdcf32a0a1da0e.png', '', '1', '1', '0', '0', '432228697144033280', '2018-11-23 14:37:22', '432228697144033280', '2019-03-20 15:30:33');
INSERT INTO `album` VALUES ('ID515536344454266882', '生与死', '<p class=\"ql-align-justify\">每个孩子都是天生的哲学家，只需适当的引导，孩子就会变成一个热爱生活、充满激情的人。</p><p><br></p><p class=\"ql-align-justify\">儿童哲学针对的是4—12岁之间的孩子，通过趣味故事来讲解<span style=\"color: rgb(252, 88, 50);\">“生与死”、“对与错”、“爱与恨</span>”等孩子好奇家长犯难的话题，以此来增加孩子的见识。</p><p class=\"ql-align-justify\">&nbsp;</p><p class=\"ql-align-justify\">目前《时间管理》主题已经全部上架，第二季的《生与死》也将陆续更新，欢迎收听！</p><p class=\"ql-align-justify\"><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45277119159029623.jpg\"></p>', '什么是死亡？怎么证明自己活着？生命的价值在哪里？', '第二季', '陪孩子一起探究世界和人生的真相！', 'media', 'ID51553634445426688', 'http://img.jssns.cn/SHILU/1/8d67589ef48261641a3f29daa5a60553.jpg', null, 'http://img.jssns.cn/SHILU/1/f91a2a65b6101c0e1b5e1647dd05fb90.png', null, '1', '1', '0', '0', '432228697144033280', '2018-11-23 14:37:22', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515538987750785024', '晚安故事', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '在美好的声音中，遇见美妙的梦！', '第一季', '在美好的声音中，遇见美妙的梦！', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/bd2166e0ee2d7d02b3acdd7ae2f15f82.jpg', null, 'http://img.jssns.cn/SHILU/1/0778ac7e79e7c347174586f088fa923a.jpg', null, '0', '0', '5', '0', '432228697144033280', '2018-11-23 14:47:52', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515539237269929984', '成语新说', '<p><img src=\"http://img.jssns.cn/SHILU/1/42332953434592621.png\"></p>', '不仅是故事，更是一种思维方式！', '第一季', '不仅是故事，更是一种思维方式！', 'media', '', 'http://img.jssns.cn/SHILU/1/d342591240dfdea8715a0297eeeb2f0c.png', null, 'http://img.jssns.cn/SHILU/1/ec831e87e15677a3085594222d11deb6.jpg', null, '0', '0', '1', '0', '432228697144033280', '2018-11-23 14:48:52', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID515539237269929985', '学会学习', '<p><img src=\"http://img.jssns.cn/SHILU/1/42332953434592621.png\"></p>', '不仅故事，更是一种学习方法！', '第一季', '不仅是故事，更是一种思维方式！', 'media', 'ID51553923726992998', 'http://img.jssns.cn/SHILU/1/c930edb16f9a57dc97e5ec4057ebccab.png', '', 'http://img.jssns.cn/SHILU/1/769cb1f73f60a6f63e9e6cc66378e339.png', 'http://img.jssns.cn/SHILU/1/186caa3a85be34f37ac97fe6880463db.png', '1', '1', '0', '0', '432228697144033280', '2018-11-23 14:48:52', '432228697144033280', '2019-02-22 18:14:08');
INSERT INTO `album` VALUES ('ID515539237269929986', '批判性思维', '<p><img src=\"http://img.jssns.cn/SHILU/1/42332953434592621.png\"></p>', '抓住要领，善于质疑辨析，基于严格推断，富于机智灵气。', '第二季', '不仅是故事，更是一种思维方式！', 'media', 'ID51553923726992998', 'http://img.jssns.cn/SHILU/1/4b17eb7ade0278d81825961f05d84e41.png', null, 'http://img.jssns.cn/SHILU/1/ec831e87e15677a3085594222d11deb6.jpg', null, '1', '1', '0', '0', '432228697144033280', '2018-11-23 14:48:52', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID527176137755852800', '节日百科', '', '讲述那些有趣的节日历史~', '第一季', '讲述那些有趣的节日历史~', 'media', '', 'http://img.jssns.cn/SHILU/1/eb5b56116fe65e69c2119b8acf026d02.jpg', null, 'http://img.jssns.cn/SHILU/1/eb5b56116fe65e69c2119b8acf026d02.jpg', null, '0', '0', '6', '0', '168', '2018-12-25 17:29:44', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID530061872238428160', '世界童话', '<p><img src=\"http://img.jssns.cn/SHILU/1/43024268503287396.jpg\"></p>', '童话，幻想期孩子的内心语言。', '第一季', '童话，幻想期孩子的内心语言。', '', '', 'http://img.jssns.cn/SHILU/1/00ee915bd9fdd2ce81b90cd16e4e050c.jpg', null, 'http://img.jssns.cn/SHILU/1/00ee915bd9fdd2ce81b90cd16e4e050c.jpg', null, '0', '0', '1', '0', '168', '2019-01-02 16:36:38', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID535147574781280256', '古诗鉴赏', '<p><img src=\"http://img.jssns.cn/SHILU/1/44898300353672905.jpg\"></p>', '习中国文化，悟古人智慧！', '第一季', '习中国文化，悟古人智慧！', '', 'ID53514757478128025', 'http://img.jssns.cn/SHILU/1/af10dc1aed52a07e9884ff75dbba530e.png', null, 'http://img.jssns.cn/SHILU/1/2fe1aa15aea0c0298de69e584f8e002a.png', null, '1', '1', '1', '0', '168', '2019-01-16 17:25:24', '432228697144033280', '2019-02-16 19:24:58');
INSERT INTO `album` VALUES ('ID547426536010022912', '节日百科', '<p><img src=\"http://img.jssns.cn/SHILU/1/47170026476966668.jpg\"></p>', '听节日故事，习传统文化！', '点击收听', '听节日故事，习传统文化！', 'media', 'ID53514757478128025', 'http://img.jssns.cn/SHILU/1/229dd55f286a54e966d895aab2344845.jpg', '', 'http://img.jssns.cn/SHILU/1/f46d78ec7e949519d6e0a0a6d8edc230.jpg', '', '1', '1', '10', '0', '168', '2019-02-19 14:37:36', '168', '2019-02-19 18:00:29');
INSERT INTO `album` VALUES ('ID558303512723718144', '情商培养', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '现代心理学研究表明，一个人成功的80%在于情商，智商只占20%。', '点击收听', '5岁以前是培养孩子高情商的关键时期', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/6884d14cbb85ada519b47d6f6426f5db.png', '', 'http://img.jssns.cn/SHILU/1/91e70153ef22aecf20b18dc2ff13f95e.jpg', '', '1', '1', '0', '0', '168', '2019-03-21 14:58:50', '168', '2019-03-21 18:05:10');
INSERT INTO `album` VALUES ('ID558313010574131200', '习惯养成', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '教育孩子的第一任务就是培养孩子的良好习惯。', '点击收听', '习惯决定命运', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/b2b52d9e5ce5f0248c2ef987b59608ab.png', '', 'http://img.jssns.cn/SHILU/1/09890e9f4ee10efdcf1e46040e118428.jpeg', '', '1', '1', '0', '0', '168', '2019-03-21 15:36:34', '168', '2019-03-21 18:05:54');
INSERT INTO `album` VALUES ('ID558316172307595264', '品格塑造', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '一个人的性格会伴随人的一生，什么样的性格又决定一个人的成功与否。', '点击收听', '性格形成的最佳时期是0~6岁', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/f7131e9e65fbc1f91555d3f90747e9f9.png', '', 'http://img.jssns.cn/SHILU/1/54f7a1a56a04afff46a2e9225bfff5e4.jpg', '', '1', '1', '0', '0', '168', '2019-03-21 15:49:08', '168', '2019-04-12 16:19:00');
INSERT INTO `album` VALUES ('ID558316417410138112', '亲情家庭', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '再忙，也别忘了孩子亲情的需要', '点击收听', '再忙，也别忘了孩子亲情的需要', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/993d2cbcd04577086b98ccd796a5d482.png', '', 'http://img.jssns.cn/SHILU/1/4389436e9b5a0bb0edccdf0d3abd1d77.jpeg', '', '1', '1', '0', '0', '168', '2019-03-21 15:50:06', '168', '2019-03-21 18:06:12');
INSERT INTO `album` VALUES ('ID558316668967714816', '思维启迪', '<p><img src=\"http://img.jssns.cn/SHILU/1/b2d22b3dea01467f005b5c180c65d532.png\"></p>', '思维能力是人类整个智慧的核心，参与、支配着人类的一切智力活动。', '点击收听', '思维水平的高低，反映一个人智力活动水平的高低', 'media', 'ID51553898775078502', 'http://img.jssns.cn/SHILU/1/696b3f3c9446db5df861187806c1bd83.png', '', 'http://img.jssns.cn/SHILU/1/b0b7a5528c083e7c879df7b359d37e1b.jpg', '', '1', '1', '0', '0', '168', '2019-03-21 15:51:06', '168', '2019-03-21 18:06:24');

-- ----------------------------
-- Table structure for `audio`
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio` (
  `rec_id` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `intro` text,
  `qr_code` varchar(100) DEFAULT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `pc_cover` varchar(200) DEFAULT NULL COMMENT 'pc端音频封面图片URL',
  `belong_to` varchar(10) DEFAULT NULL COMMENT 'album 专辑，book书籍',
  `belong_to_id` varchar(30) DEFAULT NULL COMMENT '专辑或书籍主键',
  `play_num` bigint(11) DEFAULT '0',
  `finish_num` bigint(11) DEFAULT '0' COMMENT '播放完成总数',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `create_id` varchar(30) DEFAULT NULL,
  `create_time` varchar(30) DEFAULT NULL,
  `update_id` varchar(30) DEFAULT NULL,
  `update_time` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of audio
-- ----------------------------
INSERT INTO `audio` VALUES ('ID518081228029558784', '爱提问题的波波', 'https://www.jssns.cn/SHILU/1/ac1ee855636526cee3b4c672e5e5d46c.mp3', '<h2 class=\"ql-align-center\"><strong>爱提问的波波</strong></h2><p class=\"ql-align-center\"><br></p><p>&nbsp;</p><h2>波波是一只爱提问题的花斑狗。不论遇到什么事儿，他都要问出个究竟来。</h2><h2><br></h2><h3>这一天，波波在田里捡到一个比皮球小、比核桃大、像土块一样的东西。他想：这是个啥东西呢？</h3><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/4e83c399a7ae076c78497e8c9b332c06-sz_15586.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>这时，山羊公公从不远处路过。波波急忙跑过去，很有礼貌地问：“<span class=\"ql-size-large\">山羊公公</span>，<span style=\"color: rgb(153, 51, 255);\">这个奇怪的东西是</span>啥呀？”</p><p><br></p><p>“哦，这个东西啊？”山羊公公捋着胡子说，</p><p>“<strong>我们管它叫山药蛋</strong>。”</p><p><br></p><p>“山药蛋？好玩儿。这个名字很有意思。”</p><p><br></p><p>山羊公公走了。波波看着手里的山药蛋，自言自语地说：“叫啥不好，偏叫个山药蛋。”</p><p><br></p><p>波波正在为这个名字感到好奇，熊伯伯骑着车子过来了。波波拦住了熊伯伯，举起手里那个奇怪的东西，很有礼貌地问：“熊伯伯，这东西为啥偏叫山药蛋啊？”</p><p><br></p><p>熊伯伯看着波波手里那个奇怪的东西，忍不住笑了起来：“哈哈，这怎么叫山药蛋呢？这明明是洋芋啊！”</p><p><br></p><p>“什么，洋芋？”波波糊涂了。他拿着这个奇怪的东西边走边想：这么一会儿就问出两个名字。我再去问问牛爷爷，说不定他还会说出一个更新鲜的名字呢。</p><p><br></p><p>波波急急忙忙地来到牛爷爷家，见到牛爷爷就问：“这个东西为啥又叫山药蛋，又叫洋芋呢？”</p><p><br></p><p>“什么山药蛋、洋芋？”牛爷爷被波波问蒙了。他接过波波手里的东西一看，说：“嗨，这不是土豆嘛！”</p><p><br></p><p>果然又是一个新名字，！波波更纳闷儿了。他要去找马老师，把这个有三个名字的东西弄明白。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/9db88a860ca7a7ceb8429fffe0f10923-sz_256150.png\"></p><p><br></p><p>马老师正在家打扫卫生。波波凑过去，很有礼貌地问：“马老师，这个东西怎么会有三个名字啊？”马老师接过波波手里那个东西，看了看，说：“其实，个东西的学名叫马铃薯。山药蛋、洋芋是有些地区的叫法，而土豆是它的通称。它主要含淀粉，可以蒸、煮、炒、炖、凉拌着吃。”</p><p><br></p><p>马老师见波波是那样认真的样子，就接着说：“你叫波波，也叫花斑狗，妈妈还叫你宝宝、乖乖，人们见你总爱提问题，又叫你‘小问号’。花斑狗、波波、宝宝、乖乖和小问号加在一起，你不也是有好几个名字吗？”</p><p><br></p><p>波波开心地笑了，爱提问题的好习惯又使他学到了好多新的知识。</p><p>&nbsp;</p><p>亲爱的宝贝们，我们是不是应该向波波学习呢？爱提问题会让你变得更聪明奥，所以<strong>遇到不懂得问题就要及时的问爸爸妈妈或者老师</strong>，因为他们都是超人，什么问题都难不倒他们的。</p>', 'http://img.jssns.cn/SHILU/1/40168681985236551.png', 'http://img.jssns.cn/SHILU/1/0fc7d0ffd9b924c1d75ca3762f2da9d1.jpg', null, 'album', 'ID558313010574131200', '108', '3', '15', '168', '2018-11-30 15:09:50', '168', '2019-01-28 11:05:03');
INSERT INTO `audio` VALUES ('ID518083290419167232', '【滥竽充数】不懂装懂的恶果', 'https://www.jssns.cn/SHILU/1/dfc249ce7ffa740f69cd70ff96383c20.mp3', '<p><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">滥竽充数表示那些不学无术、&nbsp;靠蒙骗混饭吃的人，也可以用来形容那些以次充好的东西。</p><p><br></p><p><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">1、篮球赛</p><p class=\"ql-align-justify\">2、巧克力</p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group49/M09/99/44/wKgKl1vOxZnBaMUEAAQVSIJWxKc19_mobile_large.jpeg\"></p><p><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">滥竽充数的故事给我们的启发可远远不止这些这些哦~！你有没有想过，整个乐队那么多人，这么长时间，真的没有任何人发现南郭先生不会吹竽吗？</p><p><br></p><p class=\"ql-align-justify\">1、<span style=\"color: rgb(252, 88, 50);\">齐宣王</span>喜欢热闹，爱摆排场，总想在人前显示做国君的威严，同时他用人不察，又不懂装懂，这才给了南郭先生充数的机会。</p><p><br></p><p class=\"ql-align-justify\">2、<span style=\"color: rgb(252, 88, 50);\">乐队队长</span>只是拿钱办事，不尽心工作，竟然不知道队伍中还有不会吹竽的人。当然也有一种可能，这个队长明明知道南郭先生不会吹奏，却因为害怕齐宣王怪罪，故意不上报，让南郭先生自在地混了。</p><p><br></p><p class=\"ql-align-justify\">3、<span style=\"color: rgb(252, 88, 50);\">南郭先生身边的队友</span>肯定听得出他不会吹竽,然而却“各人自扫门前雪,哪管他人瓦上霜”,不去或不敢伸张正义,以致南郭先生愚弄了别人还自鸣得意。</p>', 'http://img.jssns.cn/SHILU/1/40169173718984905.png', 'http://img.jssns.cn/SHILU/1/28f3b6ea60a4bf8b92c28e9c6dbe672f.jpg', null, 'album', 'ID515539237269929985', '137', '3', '8', '168', '2018-11-30 15:18:01', '168', '2019-01-31 17:52:05');
INSERT INTO `audio` VALUES ('ID518083668560838656', '【刻舟求剑】提问的力量', 'https://www.jssns.cn/SHILU/1/d856175e355db4e193f2c1d625d17608.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">比喻人的眼光未与客观世界的发展变化同步，不懂得根据实际情况处理问题。也比喻办事刻板，拘泥而不知变通。</p><p><br></p><p><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">套用作文模板</p><p><br></p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group50/M01/98/A9/wKgKnVvOzALwWn3PAAUir8MTZCM951_mobile_large.png\"></p><p><br></p><p><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">那么我们该如何做才能避免自己也落入刻舟求剑的陷阱呢？</p><p class=\"ql-align-justify\">答案就是<span style=\"color: rgb(252, 88, 50);\">提问</span>二字。</p><p class=\"ql-align-justify\">1、当楚国人在船上刻记号的时候，周围的船客感到很奇怪但却没能问出“为什么”！</p><p class=\"ql-align-justify\">2、提问之所以重要是因为它可以帮助你搞清楚一件事情背后的原因到底是什么。只有搞清楚了原因，你才能够全面、动态、深刻的看待问题，之后你在做事时才能更有针对性和创造性。</p>', 'http://img.jssns.cn/SHILU/1/40169263832951106.png', 'http://img.jssns.cn/SHILU/1/ff7a4640538cc5cfbab2a6f85c0e0429.jpg', null, 'album', 'ID515539237269929985', '116', '4', '9', '168', '2018-11-30 15:19:32', '168', '2019-01-31 17:52:46');
INSERT INTO `audio` VALUES ('ID518086312704606208', '会变颜色的小花猫', 'https://www.jssns.cn/SHILU/1/b8027ed429cd25f62fd7895cffb379f2.mp3', '<p>会变颜色的小花猫</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;有只小花猫长得可漂亮了，圆圆的眼睛长长的尾巴。身上还有淡黄色的花纹呢！</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/3462880adb6bde812c6748031a078d84-sz_623661.png\"></p><p>妈妈特别喜欢它。可是小花猫一点也不听话，整天跑来跑去还老在地上打滚，把漂亮的衣服弄的脏兮兮的。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;有一天小花猫到院子里去玩。他看见墙边有一个圆圆的铁通。使劲一跳，跳到了桶沿上，往下一瞧、原来是一桶绿色的油漆！小花猫想，要是把我的花衣裳染成绿色，那该有多好呀！说着他就扑通一声跳进去了。铁通太深了，小花猫又不会游泳，他叫也叫不出来，气也喘不过来，急的在里面直扑腾。他拼命的抓呀抓！忽然抓住了桶边，这才慢慢的爬了上来，这下呀！小花猫交成小绿猫了，他看着身上的油漆，心想“哎呀，妈妈看见了肯定要骂我，不行，我得变回去。”他连忙跑到黄泥地上，打了几个滚，想把油漆给弄下来，可没想到，那油漆比浆糊还粘，这一滚把黄泥全都粘上去了。小绿猫又变成小黄猫了。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;没办法了，小黄猫只好垂头丧气的往回走。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;走着走着，他看见一段很长的就烟囱倒在路边，上去一瞧，里面黑呼呼的。小黄猫乐了“嘿嘿，这多像我常钻的山洞啊，我要钻山洞玩。”他滋溜一声钻了进去。一个劲往里走，等他从另一头出来的时候。小黄猫变成小黑猫了。原来，烟囱里尽是黑黑的煤烟，全都蹭到身上去了。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/a5272a02a33ced77ac7c0ade01611275-sz_175952.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;太阳下山了，小黑猫回到家。妈妈推开门一看，奇怪的问：“这是谁家的孩子，跑到这里来做什么？”小黑猫委屈的叫了起来：“妈妈，是我呀，我是小花猫！”这下妈妈认出来了，他连忙把小黑猫领到自来水龙头下面，接上水管给他冲洗，冲呀冲呀！煤烟没有了露出了黄泥。妈妈接着冲，冲呀冲呀！黄泥没有了露出了绿油漆，油漆可没法用水冲。妈妈只好用刷子使劲的刷。一下，两下，油漆刷掉了，可小花猫身上的毛也掉下来了。还疼的喵喵直叫唤：“哎呀哎呀！疼死我了，疼死我了。”就这样，小花猫身上的毛，东掉一块，西掉一块，再也不像以前那样漂亮了。</p><p class=\"ql-align-center\"><br></p>', 'http://img.jssns.cn/SHILU/1/40169894253336323.png', 'http://img.jssns.cn/SHILU/1/dc1c0ca0938019e25658c6d566b0f1c9.jpg', null, 'album', 'ID558313010574131200', '102', '0', '21', '168', '2018-11-30 15:30:02', '168', '2019-01-28 09:36:33');
INSERT INTO `audio` VALUES ('ID518087104530481152', '【临渊羡鱼】如何制定一个计划？', 'https://www.jssns.cn/SHILU/1/f0b753dd6b2ff499ee2ff59706acd8dd.mp3', '<p><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">临渊羡鱼比喻只希望得到而不将希望付诸行动。退而结网比喻当目前情况无法实现目标时，要懂得先努力提升可以实现目标的基本技能。</p><p class=\"ql-align-justify\">“临渊羡鱼不如退而结网”，比喻与其空有理想，不如实实在在地付诸行动。</p><p><br></p><p><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">1、考年级第一</p><p class=\"ql-align-justify\">2、去旅游</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group50/M02/99/0D/wKgKmVvO0DfTbF76AARzikm6wmw464_mobile_large.png\"></p><p class=\"ql-align-justify\"><br></p><p><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、这个成语故事最重要的是如何“退而结网”。</p><p class=\"ql-align-justify\">2、听取一个人建议时不仅要看这个建议有没有解决问题，更重要的是要看这个建议到底能不能真正的执行。</p><p class=\"ql-align-justify\">3、“退而结网”的关键是“退”，即要找到一个目前情况下切实可行的简单目标。</p>', 'http://img.jssns.cn/SHILU/1/40170083065550077.png', 'http://img.jssns.cn/SHILU/1/6315debc94d1c9e7cc9f3ca38e9a2d5e.jpg', null, 'album', 'ID515539237269929985', '111', '3', '10', '168', '2018-11-30 15:33:11', '168', '2019-01-31 17:56:14');
INSERT INTO `audio` VALUES ('ID518087482479214592', '【守株待兔】比努力更重要的是什么？', 'https://www.jssns.cn/SHILU/1/6f45312c4fe62cc63789abc165c6bddd.mp3', '<p><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">守株待兔比喻希望不经过努力而得到成功的侥幸心理，现也比喻死守狭隘经验，不知变通。</p><p><br></p><p><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">欣欣的课上表现</p><p><br></p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group49/M03/9A/30/wKgKl1vO0V2w4pFLAANny6AhCTA89_mobile_large.jpeg\"></p><p><br></p><p><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、如果你是这个农夫，当抓到第一只兔子后，你会采取什么措施抓兔子？</p><p class=\"ql-align-justify\">2、选择合适的做事方法有时候比努力更加重要，我们需要根据不同情况灵活变通我们的做事方法而不是死守着狭隘的个人经验，</p><p class=\"ql-align-justify\">3、我们第二期讲的成语《刻舟求剑》是不是也有死守狭隘经验，不知变通这个意思呢？</p><p class=\"ql-align-justify\">4、找到做事方法的关键就是不断地尝试，尝试就免不了不断地犯错误，因此我们可以说，学会犯错误是我们通向成功最重要的能力！</p>', 'http://img.jssns.cn/SHILU/1/40170173159687959.png', 'http://img.jssns.cn/SHILU/1/2edb7702520e06692a6df1d4b4392f25.jpg', null, 'album', 'ID515539237269929985', '111', '1', '11', '168', '2018-11-30 15:34:41', '168', '2019-01-31 17:56:42');
INSERT INTO `audio` VALUES ('ID518087803364442112', '月亮婆婆值夜班', 'https://www.jssns.cn/SHILU/1/4afdd782a05bb51f00b05dda741b81e5.mp3', '<p>月亮婆婆值夜班</p><p><br></p><p>&nbsp;</p><p>太阳公公工作了一整天疲劳地躲到山后面休息去了，月亮婆婆带着一群闪闪烁烁的小星星挂在了天空，天渐渐黑了下来，夜晚来临了。月亮婆婆在干什么呢?月亮婆婆在值夜班呢。瞧!它们值班多么认真呀：月亮婆婆笑微微地看着，小星星眼睛一眨一眨亮闪闪的。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/5ae270bc045ddd9a64ffc4202031a368-sz_60515.jpg?x-oss-process=style/xmorient\"></p><p>月亮婆婆和小星星们看呀看呀，小动物们都在干什么?小鸟飞累了，扇动着疲倦的翅膀飞回了树枝上的鸟窝，鸟窝真舒服呀，小鸟打着哈欠躺在软软的鸟窝里，“呼呼”地睡着了;小白兔们蹦蹦跳跳地回到家里，伸伸懒腰躺在床上，听兔妈妈唱着摇篮曲，静静地睡着了;小花猪打着饱嗝，摇着尾巴，舒舒服服地洗了个热水澡，往床上一躺，呼噜噜、呼噜噜地睡着了;小花狗丢下肉骨头，用它的舌头舔了舔嘴巴，走到主人为它准备好的玉米皮编成的狗窝里，那里面还铺着柔软的稻草呢!小花狗趴在了窝里，耷拉下耳朵，垂下眼皮一动不动地睡着了……</p><p><br></p><p>现在小朋友在干什么呢?你看，这个小朋友在刷牙洗脸洗脚，然后，她脱下自己的衣服、鞋子，把它们整整齐齐地叠放好，再上床盖上小花被，轻轻闭上了眼睛，慢慢地小朋友睡着了，“呼、呼呼”她进入了甜美的梦乡……&nbsp;</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/e556dde299a8f6505863db73cceb446e-sz_56545.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>这时，月亮婆婆开心地笑了，她轻轻地冲小星星们点了一下头，星星们便心领神会地演奏起柔美舒缓的乐曲，月亮婆婆甜美轻柔的唱着摇篮曲：睡吧，睡吧，我亲爱的宝贝……</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/40170249639796780.png', 'http://img.jssns.cn/SHILU/1/0aa1416cc7d35325ed7cbc58a51e6b2a.jpg', null, 'album', 'ID558316417410138112', '122', '11', '3', '168', '2018-11-30 15:35:57', '168', '2019-01-28 10:16:43');
INSERT INTO `audio` VALUES ('ID518087975544815616', '【画蛇添足】锻炼想象力和创造力的方法', 'https://www.jssns.cn/SHILU/1/95c24ae7ad39b86fe5f6c935c48ed99c.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(252, 88, 50);\">字面</span>意思是“画一条有脚的小蛇”</p><p><br></p><p class=\"ql-align-justify\">画蛇添足<span style=\"color: rgb(252, 88, 50);\">比喻</span>那些没有必要的多余的事情也比喻卖弄本领，反而把事情搞砸。</p><p><br></p><p class=\"ql-align-justify\"><strong>一、应用场景</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">1、藏玩具</p><p class=\"ql-align-justify\">2、射击比赛</p><p class=\"ql-align-justify\">3、故事创编</p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group50/M00/CE/2F/wKgKmVvRZX7wrHaIAAUAxNWTKAQ663_mobile_large.png\"></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、我们只要能够清楚地知道“做一件事情的核心目的”就可以了。</p><p><br></p><p class=\"ql-align-justify\">2、只有清晰地知道做一件事情真正的目的，舍去那些对目标没帮助的事情，我们才能避免落入画蛇添足的陷阱。</p><p><br></p><p class=\"ql-align-justify\">3、婷婷老师从一个全新的角度来理解画蛇添足这个成语，即我们从创造的过程去考虑。画蛇添足是个锻炼想象力和创造力的好方法！</p><p><br></p><p class=\"ql-align-justify\">4、<span style=\"color: rgb(252, 88, 50);\">小任务</span>：找出生活中常见的动物，并给它们添上原本没有的东西，比如腿、翅膀、羽毛等等，然后编个故事让它变得合理起来吧~</p>', 'http://img.jssns.cn/SHILU/1/40170290717710741.png', 'http://img.jssns.cn/SHILU/1/3f6dc4c118dac1a48cbbb6cb98fcf767.jpg', null, 'album', 'ID515539237269929985', '102', '1', '12', '168', '2018-11-30 15:36:38', '168', '2019-01-31 17:57:34');
INSERT INTO `audio` VALUES ('ID518088768721256448', '【一叶障目】如何才能不自欺欺人？！', 'https://www.jssns.cn/SHILU/1/839be2eaa39c4efe05bcd4355701992a.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(252, 88, 50);\">字面意思</span>是用一片叶子挡住眼睛。</p><p><br></p><p class=\"ql-align-justify\">一叶障目<span style=\"color: rgb(252, 88, 50);\">比喻</span>被局部现象所迷惑，看不到事情的全貌，也比喻目光短浅。</p><h2><br></h2><p class=\"ql-align-justify\"><strong>一、应用场景</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">1、古人认为“<span style=\"color: rgb(252, 88, 50);\">天是圆的地是方的”，地球是宇宙的中心，太阳围绕着地球转</span>等，这些都是一叶障目的例子。</p><p class=\"ql-align-justify\">2、《题西林壁》</p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group51/M00/08/CD/wKgKmlvULLzg1PEyAAL3NRIMrrg352_mobile_large.png\"></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、《题西林壁》</p><p class=\"ql-align-justify\">横看成岭侧成峰，远近高低各不同。</p><p class=\"ql-align-justify\">不识庐山真面目，只缘身在此山中。</p><p><br></p><p class=\"ql-align-justify\">2、不盲目轻信和盲目崇拜，即使是书本上的知识也要以谨慎怀疑的态度看待</p><p><br></p><p class=\"ql-align-justify\">3、通过不断地学习和实践，提高自己知识的深度和广度。提高知识的深度意味着你可以站在更高的地方看清问题的全貌，提高知识的广度意味着你可以从不同的角度理解问题。</p><p><br></p><p class=\"ql-align-justify\">4、避免一叶障目需要谦虚的态度和持续一生的学习能力。</p>', 'http://img.jssns.cn/SHILU/1/40170479826128950.png', 'http://img.jssns.cn/SHILU/1/81e90382c9d77398f6f05d097decc8b0.jpg', null, 'album', 'ID515539237269929985', '102', '2', '13', '168', '2018-11-30 15:39:48', '168', '2019-01-31 17:59:32');
INSERT INTO `audio` VALUES ('ID518089162302160896', '【安步当车】过程远比结果更重要！', 'https://www.jssns.cn/SHILU/1/755d94a3ce356a7ece4738ade9fa89a8.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">1、字面意思用从容的步行代替乘车</p><p><br></p><p class=\"ql-align-justify\">2、比喻一个人勤俭节约，不贪求富贵。</p><p><br></p><p class=\"ql-align-justify\">3、以从容的步行代替乘车，比喻轻松缓慢地行走。</p><p><br></p><p class=\"ql-align-justify\"><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">1、旅游</p><p class=\"ql-align-justify\">2、支教</p><p class=\"ql-align-justify\">3、目标的实现</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group50/M09/52/D7/wKgKmVvXs9qh3bnwAAaN-zPw1oo435_mobile_large.png\"></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、安步当车是一种生活的态度，是一种不以目标为导向，专注于事情本身的态度。</p><p><br></p><p class=\"ql-align-justify\">2、如果你的学习生活只是为了完成一个又一个“任务”，你不仅会忘记了做一件事情本身的乐趣，还会让自己离目标越来越远。相反，如果你专注于事情本身的乐趣，去深入研究那些你热爱的事情，你最终会更快的达到目标。</p>', 'http://img.jssns.cn/SHILU/1/40170573617086828.png', 'http://img.jssns.cn/SHILU/1/2180583f12b0c5f1a3071faf3992834a.jpg', null, 'album', 'ID515539237269929985', '102', '2', '14', '168', '2018-11-30 15:41:21', '168', '2019-01-31 18:00:48');
INSERT INTO `audio` VALUES ('ID518089575046840320', '【杞人忧天】把时间放在有价值的事情上', 'https://www.jssns.cn/SHILU/1/cbdb5b0e7d28b9350bf6d06748fe2840.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">1、比喻没有必要去担心那些根本不会发生的事情。</p><p><br></p><p class=\"ql-align-justify\">2、比喻担心那些看似不可能发生的事情，这些事情发生的可能性很小，但不是完全没可能发生。</p><h2><br></h2><p class=\"ql-align-justify\"><strong>二、应用场景</strong></p><p><br></p><p class=\"ql-align-justify\">1、太阳</p><p><br></p><p class=\"ql-align-justify\">2、地震</p><p><br></p><p class=\"ql-align-justify\"><img src=\"http://fdfs.xmcdn.com/group49/M00/99/8A/wKgKl1va1aqCpKDDAAS0LfQ5bi8963_mobile_large.png\"></p><p><br></p><p class=\"ql-align-justify\"><strong>三、更深层次、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、小明为了这件发生可能性很小的事浪费了大把的时间和精力，如果他能把时间用来研究地震发生的原理，研究这个地方的地质结构，不仅可以把疑虑扫除而且会变成一个对地震非常了解的“小专家”。</p><p><br></p><p class=\"ql-align-justify\">2、<strong>把时间和精力放在更有价值的事情上</strong>，不要把它们浪费在那些可能性非常小的事情上。</p><p><br></p><p class=\"ql-align-justify\">3、多学习，多看书和多提问，见的多了，知道的多了，自然毫无意义的担忧就少了。</p>', 'http://img.jssns.cn/SHILU/1/40170672065159539.png', 'http://img.jssns.cn/SHILU/1/ee7a60a9a360f37fd9fae7ab1bbf2731.jpg', null, 'album', 'ID515539237269929985', '106', '1', '15', '168', '2018-11-30 15:43:00', '168', '2019-01-31 18:02:16');
INSERT INTO `audio` VALUES ('ID518089984079560704', '【邯郸学步】伟大的艺术家都擅长剽窃', 'https://www.jssns.cn/SHILU/1/2997ab8b63a19094fe2ed72b9540db09.mp3', '<p class=\"ql-align-justify\"><strong>一、故事</strong></p><p><br></p><p class=\"ql-align-justify\">1、字面意思是在邯郸这个地方学习走路</p><p><br></p><p class=\"ql-align-justify\">2、比喻生搬硬套，机械地模仿别人，不但学不到别人的长处，反而会把自己的优点和本领也丢掉了。</p><h2><br></h2><p class=\"ql-align-justify\"><strong>二、场景应用</strong></p><p><br></p><p class=\"ql-align-justify\">1、学画画</p><p><br></p><p class=\"ql-align-justify\">2、模仿</p><p><br></p><p><span style=\"color: rgb(64, 64, 76);\"><img src=\"http://fdfs.xmcdn.com/group49/M00/36/11/wKgKl1viR2DTWQEzAANwd8CjWXk561_mobile_large.png\"></span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三、更深层次的、更多元角度的分析</strong></p><p><br></p><p class=\"ql-align-justify\">1、在我们学习一件新事物的时候，模仿大师是非常必要的，但如果只是简单的抄袭过来，你就永远只能成为模仿者；相反，你需要在模仿的时候多问自己一个问题，即“他为什么会这样做呢？”，这样你就可以站在大师的角度去思考，领悟其作品背后的内涵。</p><p><br></p><p class=\"ql-align-justify\">2、优秀的艺术家是模仿，伟大的艺术家则是剽窃。----毕加索</p><p><br></p><p class=\"ql-align-justify\">3、不要害怕从大师作品那里获取灵感，好的东西能给你视野之外的启发，但你有必要了解其背后的深刻思想，提炼出规律，最后根据自己的经验内化成自己的风格。</p>', 'http://img.jssns.cn/SHILU/1/40170769546777456.png', 'http://img.jssns.cn/SHILU/1/da3451985d4fdc3194f4b85c2b46f4ab.jpg', null, 'album', 'ID515539237269929985', '106', '3', '16', '168', '2018-11-30 15:44:37', '168', '2019-01-31 18:03:05');
INSERT INTO `audio` VALUES ('ID518090356701528064', '玛丽和洋娃娃', 'https://www.jssns.cn/SHILU/1/b988d1dd167b405703d172da3410b3bd.mp3', '<p>玛丽和洋娃娃</p><p><br></p><p>&nbsp;</p><p>小姑娘玛丽长得非常漂亮。不过，她做事情的时候有一个毛病，就是丢三落四。</p><p><br></p><p>她的书、玩具，经常被丢在上次用过的地方。于是妈妈总是不得不跟在她身后，帮助她把那些东西收拾到合适的位置。哦，这样一来，就给妈妈带来很大麻烦。</p><p><br></p><p>妈妈不断地提醒玛丽，做事一定要细心。可玛丽从来听不进妈妈的劝告。结果呢，书、玩具常常被她扯破或者是弄坏。</p><p><br></p><p>更糟糕的是，她变得真的细心不起来，越来越粗心大意了。这会非常不利于她的生活。另外，由于坏习惯的捣乱，使她经常心情不好。朋友们的兴致也时常被她破坏。</p><p><br></p><p>一天，玛丽和妈妈一起，在院子里待了足足一小时。妈妈并没有丢下手头正忙着的活儿。玛丽则和她的狗儿德西一块儿玩，他们不停地跑来跑去。</p><p><br></p><p>突然，在院子的一个角落里，玛丽发现了她最心爱的那个洋娃娃。哦，洋娃娃不但衣服沾满泥土，而且还被扯破。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/92854dcb51303f739108f1006463edfb-sz_19323.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>玛丽立刻推断到这是德西所为，于是德西遭到了非常严厉地斥责。</p><p><br></p><p>玛丽非常伤心。她哭着把扯破的洋娃娃拿到了妈妈跟前。</p><p><br></p><p>“孩子，你是否将洋娃娃放在了德西容易够到的走廊里了？”妈妈问她。“是的，妈妈。”玛丽回答道。</p><p><br></p><p>“哦，玛丽，那就不是小狗的错了。它可不懂你的洋娃娃是不能撕咬的哟。孩子，别伤心了，汲取这个教训吧。从今以后，记着要把自己的东西都放到合适的地方去啊。”</p><p><br></p><p>“妈妈，我会尽力做到的！”玛丽抹着眼泪表示。</p><p><br></p><p>妈妈很开心玛丽能如此回答。后来，妈妈还帮助她把娃娃补好了。</p><p>&nbsp;</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/57a406c637c9cd3234febe56e64bb7d6-sz_49469.png\"></p><p><br></p><p><strong>亲爱的宝贝，还记得那些你弄丢的玩具吗？</strong>赶紧闭上眼睛想一想，他们被你丢到哪里去了？记住了，现在不要去找他们，因为他们现在已经睡着了！你也赶紧睡吧！答应婷婷姐姐<strong>，明天早上把自己的玩具好好整理一下。不要再让他们因为你的丢三落四而在角落哭泣了！</strong></p>', 'http://img.jssns.cn/SHILU/1/40170858394643067.png', 'http://img.jssns.cn/SHILU/1/ec10ce353184faaee79284b70383169f.jpg', null, 'album', 'ID558313010574131200', '101', '0', '19', '168', '2018-11-30 15:46:06', '168', '2019-01-28 11:21:19');
INSERT INTO `audio` VALUES ('ID518090678215901184', '小松鼠买梦', 'https://www.jssns.cn/SHILU/1/137019fc001d54453a4ad8a8e1077b9c.mp3', '<p>&nbsp;小松鼠买梦</p><p><br></p><p>&nbsp;</p><p>有一天，小松鼠自个儿待在松树上。东张西望，忙着采松子。</p><p><br></p><p>一只小红鸟飞来了，很高兴地对小松鼠说：“小松鼠，告诉你吧，我昨天晚上做了一个梦，梦见和一只好漂亮的大蝴蝶一起玩呢！”</p><p><br></p><p>小松鼠眨眨眼睛，心想：哟，这可真好！</p><p><br></p><p>小红鸟飞走了。小黄鸟又飞来了，对小松鼠说：“小松鼠，告诉你吧，我昨天晚上做了一个梦，梦见一朵孔雀花，美极了。”</p><p><br></p><p>小松鼠又眨眨眼睛，心想：哟，这可真好！</p><p><br></p><p>小黄鸟说完。就飞走了。</p><p><br></p><p>小松鼠想：呀，做梦真美。今天晚上，我也要做一个梦。</p><p><br></p><p>到了晚上，他早早睡在床上，闭上眼睛，等着梦来。小松鼠等呀等呀，慢慢睡着了。</p><p><br></p><p>可是他没有做梦。</p><p><br></p><p>小松鼠一觉醒来，闭着眼睛想了想：咦，我什么梦也没有做呀。他很不高兴。</p><p><br></p><p>突然，小松鼠想到一个好主意：“对了，我去买一个梦吧。”</p><p><br></p><p>他拿了一分钱，买梦去了。</p><p><br></p><p>小松鼠走到大湖边，看到红鲤鱼在水里游，说：“红鲤鱼，红鲤鱼，我想买一个梦，你有吗？”</p><p><br></p><p>红鲤鱼说：“我不卖梦。”说完，鱼游走了。她那红红的尾巴，在绿绿的湖水里，一甩，一甩。</p><p><br></p><p>这时候，一只白天鹅落到了水面上。小松鼠对白天鹅说：“白天鹅，白天鹅，我想买个梦，你有吗？”</p><p><br></p><p>白天鹅说：“我不卖梦。”说完，扑扇着翅膀向天上飞去。她那雪白的大翅膀，在蓝蓝的天空里，一扇，一扇。</p><p><br></p><p>小松鼠又到树林里，看到小白兔在树林里荡秋千。</p><p>小松鼠大声说：“小白兔，小白兔，我想买一个梦，你有吗？”</p><p><br></p><p>小白兔说：“我的梦怎么能卖给你呢？”说完，又荡起秋千来。她荡呀，荡呀，好像一朵白云在飘。</p><p><br></p><p>小松鼠买不到梦，难过地回家去了。</p><p><br></p><p>天黑了，他想：我没有买到梦，今天晚上肯定也不会做梦了。</p><p><br></p><p>夜里真静，小松鼠轻轻呼吸着，一下子睡着了。</p><p><br></p><p>小松鼠开始做梦了。</p><p><br></p><p>他做了一个大湖的梦。在梦里，他和红鲤鱼一起在湖中游来游去，一起做游戏。</p><p><br></p><p>接着，他又做了一个飞的梦。在梦里，白天鹅背着他，在蓝天上飞，越过湖水，越过高山，飞到了很远很远的地方。</p><p><br></p><p>他还做了一个荡秋千的梦。在梦里，他和小白兔坐在秋千上，荡呀，荡呀，荡到云朵里去了……</p><p><br></p><p>天亮时，他眨着眼睛，想着自己做过的梦。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/ea6d6a1d28f6a9c883f46fc6c5252477-sz_30338.png\"></p><p><br></p><p>“原来、我会做这么多好玩的梦呀！”小松鼠高兴极了。</p><p><br></p><p><strong>亲爱的宝贝们，梦是买不到的奥~</strong></p><p><br></p><p>今晚你会做一个什么样的梦呢？赶紧把小眼睛闭起来。美梦要开始喽~</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/40170935042448643.png', 'http://img.jssns.cn/SHILU/1/96e2582ded2c3a4d92ee14546564623f.jpg', null, 'album', 'ID558316668967714816', '103', '0', '16', '168', '2018-11-30 15:47:23', '168', '2019-01-28 11:13:47');
INSERT INTO `audio` VALUES ('ID518090756984930304', '【铁杵成针】比努力更重要的是什么？', 'https://www.jssns.cn/SHILU/1/7bde2df157ef79e0e4ba64941428c64c.mp3', '<h2 class=\"ql-align-justify\"><span style=\"color: rgb(252, 88, 50);\">一、故事</span></h2><p><br></p><p class=\"ql-align-justify\">1、字面上的意思是，把铁棒磨成绣花针。</p><p><br></p><p class=\"ql-align-justify\">2、比喻只要有决心，肯下工夫，不管多么难的事情也能做成功。</p><h2><br></h2><h2 class=\"ql-align-justify\"><span style=\"color: rgb(252, 88, 50);\">二、场景应用</span></h2><p><br></p><p class=\"ql-align-justify\">1、医药学家李时珍</p><p><br></p><p class=\"ql-align-justify\">2、美国“发明大王”爱迪生</p><p><br></p><h2 class=\"ql-align-justify\"><span style=\"color: rgb(252, 88, 50);\">三、更深层次的、更多元角度的分析</span></h2><p><br></p><p class=\"ql-align-justify\">1、实际上，上面的所有故事都有个很重要的前提，比如在老婆婆铁杵磨针的故事中，老婆婆的目标很简单，就是把铁杵磨成绣花针；同样，李时珍的目标也很明确，就是通过药草拯救病人的生命；爱迪生的目标也非常明确，就是发明可以被寻常百姓使用的电灯泡。。。</p><p><br></p><p class=\"ql-align-justify\">2、做任何事一定要有明确的目标，努力虽然很重要，但如果你的目标不明确也依然不会取得令人满意的成果。</p><p><br></p><p class=\"ql-align-justify\">3、从今天开始，把“只要功夫深，铁杵磨成针”当作自己的座右铭吧！为了你的目标，为了你的梦想加油！</p>', 'http://img.jssns.cn/SHILU/1/40170953866065749.png', 'http://img.jssns.cn/SHILU/1/230cb88600c88e82b74339ae63a1c616.jpg', null, 'album', 'ID515539237269929985', '107', '2', '17', '168', '2018-11-30 15:47:42', '168', '2019-01-28 14:50:05');
INSERT INTO `audio` VALUES ('ID518091303477575680', '坏蛋哪里跑', 'https://www.jssns.cn/SHILU/1/e4eb428d41b44bc6f2f33651d97cd213.mp3', '<p>坏蛋那边跑</p><p><br></p><p>有两只黄鼠狼，一只叫大黄，一只叫二黄。他们在一路筹议怎么偷吃火帽子小公鸡的事，正巧被红袋鼠听到了。于是，红袋鼠立刻把这事告诉了火帽子和跳跳蛙。</p><p><br></p><p>三个好伴侣便决定筹议抓坏蛋：要让他们没处藏，要把他们抓得手！</p><p><br></p><p>夜深了， 大黄、二黄蹑手蹑脚的闯进火帽子的家。他们边走边美滋滋地想：</p><p><br></p><p>火帽子的肉肯定很鲜，火帽子的肉肯定很嫩，真想捉住火帽子，好好的吃一顿。</p><p><br></p><p>可他们拿手电这里照照，那儿那里照照，就是看不见火帽子。真焦心啊！</p><p><br></p><p>推开门，大黄刚想溜进火帽子的寝室，脚下一绊，摔了个嘴啃泥。二黄用手电一照，原本是一根绳子拦在了路上。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/a6ec498465aaffaa1e1ec7f48ebafa05-sz_21496.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>大黄、二黄走进房子，听见了火帽子打呼噜的声音，真开心呀。谁知，他们刚往前迈了一步，哎呀，不好！“咕咚”一声，失进了陷阱。 黄、二黄只感觉黑咕隆咚，晕头转向的。他们使出全部力气爬出了陷阱，却发现，呼噜声原来是从隔壁房子传过来的。</p><p><br></p><p>大黄、二黄又闯了进去，一眼看到火帽子躺在床上睡得正喷香。哈，这回看你往哪边跑！</p><p><br></p><p>大黄抢先一步，蹿到火帽子床前，伸出爪子便要去抓火帽子。他的爪子刚刚碰到火帽子 ，就听见“啪”的一声……</p><p><br></p><p>大黄的两只爪子被夹住了。</p><p><br></p><p>二黄说：“不好！咱们中骗局了，快跑！”他刚想往外逃，却发明门已经被反锁住了。</p><p><br></p><p>这时，警笛响了起来，院子里站满了黑猫差人。他们是接到红袋鼠报警后，早就潜伏好的。</p><p><br></p><p>红袋鼠、火帽子和跳跳蛙一路欢呼：“坏蛋那边跑，想逃没处逃，黑猫差人到，谁也跑不了！”</p><p>&nbsp;</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/4a068f06370ee7af88fc6f660890be4a-sz_103692.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>小朋友们，当我们碰着坏蛋，要怎样保护自己呢：</p><p><br></p><p>第一，爸爸妈妈告诉我们的，比如：<strong>不要到公路边玩，不要吃陌生人给的食物，不要和陌生人说话。</strong>等等一定要记住。</p><p><br></p><p>第二，<strong> 当爸爸妈妈不在身边时，陌生人强制接近自己的话，不要慌张，不要打叫。赶紧抱住离自己最近的人的腿，叫他爸爸。</strong>让坏人以为你有家人在旁边所以他不敢靠近你的。<strong>如果旁边没有人，就要倒在地上耍赖打滚，叫喊哭嚎引来旁人关注，令对方惊恐不安，乘机脱身。</strong></p><p><br></p><p><strong>亲爱的小朋友们，只有爸爸妈妈的怀抱，才是最温暖，最安全的地方。当和爸爸妈妈外出时，不要因为贪玩离爸爸妈妈太远奥！</strong></p>', 'http://img.jssns.cn/SHILU/1/40171084121373032.png', 'http://img.jssns.cn/SHILU/1/2e99cd2f25c04819c5dbbd22903ad424.jpg', null, 'album', 'ID558313010574131200', '103', '0', '18', '168', '2018-11-30 15:49:52', '168', '2019-01-28 11:17:37');
INSERT INTO `audio` VALUES ('ID518092325025480704', '【开篇】为什么每个孩子都必须学习哲学？', 'https://www.jssns.cn/SHILU/1/9fdfc664cfe3cbd0784460075e620ac6.mp3', '<p><strong style=\"color: rgb(255, 169, 0);\">在一定意义上，每个孩子都是天生的哲学家。</strong>他们是这个世界的新手，在好奇心的驱动下，他们会产生非常多有趣且耐人深思的问题，比如：“什么是时间？”、“梦到底是什么”等等。这些问题听起来很简单，简单到我们都未曾注意到过。</p><p><br></p><p><strong style=\"color: rgb(255, 169, 0);\">是啊，时间，它到底是什么？</strong>我们总是说要节约时间，要作好时间管理，可归根结底，时间到底是什么？它看不见，摸不着，也无法被感受到，那么我们怎么才能证明时间的存在呢？</p><p><br></p><p>看吧，孩子小小脑袋里装的都是这些大大的问题。生命的生长带来对人生的新的发现，这些新的发现使孩子们兴奋，更使孩子们困惑。我们没有理由不利用孩子这段时间旺盛的好奇心，把适合孩子们的哲学知识传递给他们，让他们可以更好地了解自己，更好地了解世界，最终发现更好地自己。</p><p><br></p><p>当然，你也许会问，孩子本身学习压力已经够大了，学这些虚头虚脑的哲学到底有什么用？要想回答这个问题，我们必须先把“有用”这个词搞清楚？</p><p><br></p><p>每个人对“有用”的看法都不同，但归根到底我们都希望孩子可以成为一个优秀的人，成为一个能够适应未来生活的人。而在大部分左脑工作被取代的人工智能时代，孩子要想适应未来就必须需要诸如<strong style=\"color: rgb(255, 169, 0);\">批判性思考、创造力和想象力</strong>之类的基本能力，而哲学恰恰能给孩子们带来这些。</p><p><br></p><p>首先，哲学可以帮助孩子培养出批判性思考的能力：<strong style=\"color: rgb(255, 169, 0);\">哲学的本质是思维实验</strong>，它需要孩子能够建立论点，运用逻辑思考来论证论点，并且，当其他孩子提出反对意见的时候能够针对反对意见提出自己的思考。因此，学习哲学就是学习如何透过现象看本质，而这就是批判性思考；</p><p>&nbsp;</p><p><strong style=\"color: rgb(255, 169, 0);\">其次，哲学能够让孩子更具想象力和创造力。</strong>哲学需要思辨，需要思考事情的对立面，比如“如果这件事是错的，那正确的应该是什么？”，思考这些问题对于孩子的创造力提升非常有帮助，换句话说，可以锻炼孩子思维的灵活性；</p><p><br></p><p><strong style=\"color: rgb(255, 169, 0);\">另外，哲学对于提高孩子的社交技巧非常有帮助。</strong>提起社交，大人们立刻会联想到“情商”，情商归根结底就是要能够站在他人的角度看待问题，而这需要与他人共鸣的能力。哲学谈论的话题非常广泛，比如生命、友谊、爱情、亲情、丑与美等等，而学习这些能够帮助孩子与他人产生情感上的共鸣。</p><p><br></p><p><strong style=\"color: rgb(255, 169, 0);\">最后，哲学可以提高孩子的学习成绩。</strong>有研究对比了不同班级中学习哲学的学生和不学习哲学的学生期末考试成绩之间的差距。结果显示，学习哲学的学生平均成绩比不学习哲学的学生高出40%。</p><p><br></p><p>那么到底如何给孩子进行哲学启蒙呢？<strong style=\"color: rgb(255, 169, 0);\">答案就是通过故事。</strong></p><p><br></p><p>我们会把哲学故事和思考融入孩子喜闻乐见的故事中，让孩子在听故事的过程中了解是什么是时间？什么是性别？什么是快乐？什么是美丽？等等。</p><p>&nbsp;</p><p>如果你真正的爱孩子，关心他们的前途，就应该把自己的眼光放长远一点。不要挫伤孩子自发的哲学兴趣，而是保护和鼓励。<strong style=\"color: rgb(255, 169, 0);\">最好的鼓励方法就是和他们一起思考讨论哲学问题。</strong></p><p><br></p><p>事实上，任何一个真正的哲学问题都不可能有标准答案，因此，对孩子而言，重要的不是答案而是发现和探究的过程，愿我们能帮助你和你的孩子爱上哲学，爱上思考。</p>', 'http://img.jssns.cn/SHILU/1/40171327751849881.png', 'http://img.jssns.cn/SHILU/1/94ee76cbbd48a4da18a43faad727d6f2.jpg', null, 'album', 'ID515536344454266881', '141', '6', '1', '168', '2018-11-30 15:53:55', '168', '2019-01-26 10:24:21');
INSERT INTO `audio` VALUES ('ID518092557754826752', '会说话的卷心菜', 'https://www.jssns.cn/SHILU/1/1301cc1d93aa0c1c522a6a1e79e5ce93.mp3', '<p>会说话的卷心菜</p><p><br></p><p>&nbsp;</p><p>熊奶奶从地里摘来一棵卷心莱。</p><p><br></p><p>熊奶奶手拿莱刀，刚想把刀切下去，只听到卷心菜发出叽叽咕咕的声音。</p><p><br></p><p>熊奶奶吓了一跳，卷心莱怎么会有声音呢？是自己耳朵出毛病了？她再仔细听，卷心菜真的在叽叽咕咕说着话。</p><p><br></p><p>熊奶奶喊了起来：“天哪，卷心莱在自言自语呢！”</p><p><br></p><p>她侧着耳朵听了半天，也不知道卷心莱在说些什么。</p><p>她跑出门外，喊来了河马先生。</p><p><br></p><p>河马先生竖起耳朵听了半天，也不知道卷心菜在说些什么。</p><p><br></p><p>熊奶奶又去找来了兔子先生。</p><p><br></p><p>兔子先生竖起一对长耳朵听了半天，他说：“卷心菜先生一定说的是外语，我没学过。”</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/51f8f73806063eab3e51e8b5a06c34b0-sz_152303.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>这时，有位青蛙大婶走过这里，也来好奇地听听，突然，青蛙大蜂尖叫起来：</p><p><br></p><p>“哦，我的宝贝，我的可怜的宝贝。”</p><p><br></p><p>兔子先生闹不明白，忙问：“熊奶奶的卷心菜，怎么成了你的宝贝？你听懂里面说的外国话了吗？”</p><p><br></p><p>青蛙大婶说：“什么外国话，他根本不会说话。”</p><p><br></p><p>河马先生说：“什么？你说卷心菜不会说话？</p><p><br></p><p>“不是的。”青蛙大蜂说：“这卷心菜里而是我的小宝贝，他失踪两个月了，那时候，刚从小蝌蚪变成小青蛙，只会叽叽咕咕叫，还没学会说话。</p><p><br></p><p>熊奶奶一听可着急了，她赶快放下菜刀，用手把卷心菜叶子一瓣一瓣剥下来。</p><p><br></p><p>卷心菜越来越小，越来越小。最后，从菜心里发现一个小青蛙，正在叽叽咕咕地叫着呢。原来，有一天，小青蛙在卷心菜的菜心里睡觉，睡啊睡啊，就让卷心菜给包了起来，一包就包了两个月。</p><p><br></p><p>熊奶奶为了庆祝青蛙大婶找到了自己的小宝贝，赶紧用卷心菜熬了一锅汤，请青蛙大等和她的儿子吃。小青蛙喝完汤，叽叽咕咕地叫着。青蛙大缔说：“我的小宝贝在称赞熊奶奶做的卷心菜汤真好吃呢！熊奶奶，谢谢你了。”</p><p><br></p><p>青蛙大婶高高兴兴地领着儿子回家了。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/179943657f83f2607dd794fec0891941-sz_239006.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>熊奶奶呢，从这以后，每逢切卷心菜，总要先拍打几下，再用耳朵听听，她想会不会有会讲话的卷心菜……</p>', 'http://img.jssns.cn/SHILU/1/40171383190391093.png', 'http://img.jssns.cn/SHILU/1/13c42736e1ad6f2f553dfe46155c5540.jpg', null, 'album', 'ID558316417410138112', '102', '1', '17', '168', '2018-11-30 15:54:51', '168', '2019-01-28 09:37:36');
INSERT INTO `audio` VALUES ('ID518095629965066240', '爱唱歌的小鸭子', 'https://www.jssns.cn/SHILU/1/b3939e828d93b1f8d2b1290b3436eaac.mp3', '<p>&nbsp;爱唱歌的小鸭子</p><p><br></p><p><br></p><p>从前，有个特别爱唱歌的小鸭子，可她却生活在一个孤独偏僻的山坳里，从来没有人听到过她的歌。一天夜里，小鸭竟然做了个梦，梦到了一个美丽的天使妹妹飘在她的面前说：“小鸭姐姐，你不是爱唱歌吗？</p><p><br></p><p>你从这座山峰顺着这条小溪一直向前走吧！就会发现有一片光明的地方，那儿是个很大的乐园，专供你们这些鸟儿雀儿唱歌的。”说罢天使妹妹飘飘然不见了。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/2d0ea079b42735fd6c8b62fafed9ccf1-sz_4083923.jpg?x-oss-process=style/xmhigh\"></p><p><br></p><p>梦醒后，小鸭就顺着天使妹妹所指的方向上路了。她越过了一座座山，趟过了一条条河，终于看到了那个充满阳光的乐园。可那座乐园是一个和谐文明洁净的乐园，不能随随便便进出，旁边还有个虎头虎脑的虎崽子把着乐园的大门，小鸭从缝隙中看到了能言会语的鹦鹉，巧嘴滑舌的八哥，小巧玲珑的画眉，等好多好多的鸟儿，他们正轻松愉悦热热闹闹的亮着嗓门大喊大唱，样子开心极了。小鸭好羡慕，可小鸭只能眼瞅着&nbsp;耳听着&nbsp;那些鸟儿雀儿委婉动听清脆悦耳的歌声。单纯的小鸭把自己的身世向把门的虎崽讲了个清楚明了，谁知把门的虎崽用眼斜了眼小鸭说：“他们都是经过严格培训才表演的那样出色，你连个培训班的门也没见过，让你进去还不是白占座位。”</p><p><br></p><p>小鸭沮丧极了，无奈的小鸭在乐园的门外孤独的逛来逛去，她想到一路上千辛万苦所经的丛山峻岭，好不容易赶在了乐园的门外&nbsp;怎能就此放弃呢！转了一天的小鸭身心疲惫的偎依在乐园的门口不愿离去。太阳就要落山了，鸟儿要归巢了，把门的虎崽闭门时才发现了执著的小鸭原来还在，终于起了怜悯之心，为小鸭畅开了那扇神秘的门。</p><p><br></p><p>乐园里黄鹂婉转动听的歌声让小鸭久听不厌，布谷鸟又清又亮的歌喉使小鸭百听不烦，还有画眉山雀好多好多鸟儿那悠扬甜美的歌声常常令小鸭如痴如醉，忘却自我。自卑的小鸭默默的躲在小小的角落里用心的倾听着鹦鹉、八哥等鸟儿的甜甜的歌声，小鸭十分珍惜这次难得的机会，倾注了一腔的热忱，专心致至的聆听着，学习着……</p><p><br></p><p>寒来暑往，不觉一年来到了，到了凤凰妹妹的生日那天，凡是乐园中的每位成员都的为凤凰妹妹唱首歌曲以示祝贺。于是黄鹂婉转的歌声在乐园中唱响，布谷鸟清亮的歌喉响彻云霄，一首接一首美妙的歌声唱红了整个乐园，最后终于轮到了小鸭的演唱，小鸭清了清嗓子唱出了一首歌，百鸟朝凤……</p><p><br></p><p>小鸭的歌声刚落，耳边响起了雷鸣般的掌声，主持演唱会的山羊伯伯说：“小鸭，你能说说你是怎样唱出这么又纯又美的歌曲的。”小鸭摸了摸湿润的眼睛说：“用心去唱。”</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/38b8447f47599f49a7685db5cd8f8c37-sz_1016842.jpg?x-oss-process=style/xmorient\"></p>', 'http://img.jssns.cn/SHILU/1/40172115688966347.png', 'http://img.jssns.cn/SHILU/1/cfa3fe8b7971c183f049d1d99e6a23e4.jpg', null, 'album', 'ID558316172307595264', '113', '6', '6', '168', '2018-11-30 16:07:03', '168', '2019-01-28 10:58:04');
INSERT INTO `audio` VALUES ('ID518096019230031872', '蜗牛的森林', 'https://www.jssns.cn/SHILU/1/0f8abfada201acae5a90a3223587acc3.mp3', '<p>蜗牛的森林</p><p>&nbsp;</p><p><br></p><p>蜗牛生活在一片草地上，对于蜗牛来说，这里就像是一片茂密的森林。</p><p><br></p><p>可是有一天，草地上来了一只穿红靴子的兔子，蜗牛很热情地招呼说：“欢迎你来到蜗牛的森林。”兔子听了哈哈笑着说：“这样的草地也算森林？最高的草才过我的靴筒。”于是，兔子就给蜗牛描述了真正的森林，那是有着高大树木的地方。蜗牛很吃惊，世界上还有这样的地方？他决朵去寻找真正的森林。</p><p><br></p><p>蜗牛上路，什么也不用带，他的背壳房子就是他的一切。当他身体缩进去的时候，他就在休息，当他把身体伸出来的时候，他就在赶路。就这样过了许多天。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/17ac6cdc5dc2a71747a47460e880e6a5-sz_1308544.png\"></p><p><br></p><p>一天，蜗牛看见四个巨大的树根，啊，这样的大树，只有森林里才有啊。</p><p><br></p><p>蜗牛很高兴，他觉得自己已经到哒了森林。可是，森林这么大，蜗牛站在地上是看不清楚的，他决朵沿着树干一直往上爬。</p><p><br></p><p>这是一棵多么老的树呀，蜗牛一边爬一边想着。蜗牛爬到顶上的时候，感觉到刺眼的阳光，哦，原来他到了大象的背ㄩ上，那粗粗的树根当然是大象的腿了。</p><p><br></p><p>大象一点也不知道背上有一只蜗牛，踱着步子慢悠悠地走进森林。</p><p><br></p><p>小蜗牛终于看见了真正的森林。</p><p><br></p><p>太阳光斜斜地透过茂密的树叶像星星一样撒在地上，也撒在蜗牛的背壳上。这时候，森林里来了一个巨人，大象很热情地招呼他：“请休息一会儿吧，这里是大象的森林。”巨人哈哈笑着说：“森林？这里的树就和小草一样，才到我的膝盖。”是啊，大象在巨人面前显得很小很小，森林就在巨人的脚下。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/e6359324d94a0477d751e70578e59673-sz_27040.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>巨人说：“再见，小小的大象，我要到我自己的森林里去了。”对呀，巨人一朵有着巨大的森林。</p><p><br></p><p>当大象又经过草地的时候，蜗牛顺着他长长的鼻子下来了。兔子看见这一切的时候，简直是惊呆了。</p><p><br></p><p>蜗牛安安心心地住在自己的森林里了，虽然这里最高的草也只过了兔子的靴筒。</p>', 'http://img.jssns.cn/SHILU/1/40172208489319254.png', 'http://img.jssns.cn/SHILU/1/71f2a66efb2f4b619b873ab667294bee.jpg', null, 'album', 'ID558316172307595264', '106', '3', '14', '168', '2018-11-30 16:08:36', '168', '2019-01-28 09:33:15');
INSERT INTO `audio` VALUES ('ID518096552670003200', '淘淘和苹果树', 'https://www.jssns.cn/SHILU/1/120ef1764d59e1d2b147d47e972a5f1e.mp3', '<p>淘淘和苹果树</p><p><br></p><p>&nbsp;</p><p>其实淘淘的真名不是叫淘淘，因为它平时太顽皮捣蛋，所以森林里的动物朋友们都叫它淘淘。</p><p><br></p><p>一天，妈妈看到天空晴朗，阳光明媚，就对淘淘说：“淘淘，妈妈想种棵树，你觉得种什么树好呢?”</p><p>淘淘听了，想了一想，开心地说：“妈妈，种苹果树吧。我喜欢吃苹果，但森林里的苹果树都是离我们家比较远的。如果我们自己种了的话，到时就不用走那么远的路去摘了。”</p><p><br></p><p>于是，妈妈听淘淘的建议播了一粒苹果种子。</p><p><br></p><p>妈妈让淘淘每天都给种子浇水。不久，种子发芽了。再过没多长时间，就长出了好几节高，还有几片叶子了呢。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/1bc863119d976b2e5c2924ae7b7b28b6-sz_609256.png\"></p><p>有一天，妈妈出门去了，留淘淘自己在家玩。淘淘没事干觉得很无聊，就一直在那叹着气儿。</p><p><br></p><p>它看到苹果树上的叶子，嫩嫩的，绿绿的，叶脉儿一条一条的。于是它就摘了一片下来，顺着叶脉一点一点地撕开，发觉挺好玩的，就又摘了一片。不一会，就把小树苗的叶子全摘光了。</p><p><br></p><p>于是，淘淘接下来的日子里，每当小树苗好不容易长出一片叶子，它就摘下来玩。</p><p><br></p><p>没过多久，小树苗就萎恹死了。淘淘伤心地哭着告诉妈妈，说它再也吃不到苹果了。妈妈跑到种苹果树的地方，当看到一条没叶子的树枝，大吃一惊，就问淘淘是什么原因?淘淘把事情告诉了妈妈。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/e9b78014fa7410f816ca5b09e609cd69-sz_105554.jpg?x-oss-process=style/xmorient\"></p><p>妈妈听了事情后，对淘淘说：“淘淘，你不能把小树苗的叶子摘了。因为小树苗要靠它来进行光合作用，吃东西呢。”</p><p><br></p><p>“吃东西?”淘淘好奇地问。</p><p><br></p><p>“嗯”妈妈接着说：“光合作用是植物产生营养成分的一种方式，而进行这些是要经过叶子的。这叶子好比是我们的嘴巴，当我们没有嘴巴吃东西时，我们也是会饿死的啊。”</p><p><br></p><p>淘淘听了妈妈的话后很后悔，它说：“妈妈，我知道错了，我以会不会随便小树的叶子了。”</p>', 'http://img.jssns.cn/SHILU/1/40172335641896963.png', 'http://img.jssns.cn/SHILU/1/e2b91889f3b898940996f0684dbf82ee.jpg', null, 'album', 'ID558316417410138112', '114', '8', '4', '168', '2018-11-30 16:10:43', '168', '2019-01-28 10:48:23');
INSERT INTO `audio` VALUES ('ID518096933240176640', '小猴子买礼貌', 'https://www.jssns.cn/SHILU/1/635848bdd7d979748d7c6fe4a415cdc6.mp3', '<p>&nbsp;小猴学礼貌</p><p><br></p><p>&nbsp;</p><p>小猴，没有礼貌。</p><p><br></p><p>老师来了，他不问好；撞到了小兔，他不道歉；碰见老人，他不让路……</p><p><br></p><p>猴妈妈很生气 ，他对小猴子说：</p><p><br></p><p>“你怎么不学着讲礼貌呢 ？”</p><p><br></p><p>学礼貌，多麻烦，拿钱多省事。小猴对妈妈说：“给我一些钱，我去买礼貌。”</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/2d819c69d768a158e72d2961256262a2-sz_311318.png\"></p><p>猴妈妈哭笑不得。</p><p><br></p><p>仔细一想，就给了小猴一些钱。</p><p><br></p><p>小猴拿着钱，高高兴兴的朝街上跑去……来到第一家商店，小猴大喊：</p><p><br></p><p>“喂，这儿卖礼貌吗？”</p><p><br></p><p>没人回答。</p><p><br></p><p>来到第二家商店，小猴大叫：“喂，这儿卖礼貌吗？”</p><p>没人回答。</p><p><br></p><p>一家、两家……小猴跑了三十三家商店，都没有买到礼貌。</p><p><br></p><p>只剩最后一家商店了，山羊伯伯开的。山羊伯伯平时对小猴很好，小猴很敬重他。</p><p><br></p><p>小猴想，山羊伯伯肯帮忙，我一定能买到礼貌。</p><p>他看见山羊伯伯很忙，就等了一会儿。“山羊伯伯，您这有礼貌卖吗？” 小猴轻轻问。</p><p><br></p><p>山羊伯伯笑了：“傻孩子，礼貌是买不到的，只能学到。”</p><p><br></p><p>小猴没有买到礼貌，低着头走回来，他不好意思地说：“对不起 ，我没有买到礼貌。”</p><p><br></p><p>猴妈妈乐呵呵地端出饭菜：“肚子饿了吧 ?快吃。”小猴早已饿级了，他大口大口地吃着香喷喷的饭菜，心想：“还是妈妈好，我要谢谢她。”</p><p><br></p><p>“谢谢妈妈！一句很有礼貌的话从小猴嘴里飞出来。猴妈妈笑了：“孩子，你没有买到礼貌，但你学到了。”</p>', 'http://img.jssns.cn/SHILU/1/40172426427394417.png', 'http://img.jssns.cn/SHILU/1/f28c57792eff8ad7022a077001849338.jpg', null, 'album', 'ID558303512723718144', '113', '7', '8', '168', '2018-11-30 16:12:14', '168', '2019-01-28 09:27:41');
INSERT INTO `audio` VALUES ('ID518097240917540864', '爱打呼噜的河马先生', 'https://www.jssns.cn/SHILU/1/ef83852857d761ff2eea94dcbd823d07.mp3', '<p>爱打呼噜的河马先生</p><p><br></p><p><br></p><p>阳光公寓新搬来的河马先生是个热心人。邻居们的床呀、柜子桌子呀、冰箱彩电呀等一些大家俱搬不动时，河马先生总是呵呵笑着赶来帮忙。大家都很感激河马先生。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/4981a3481c6307820da165f326d2f020-sz_64708.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>但河马先生也有个让人心烦的缺点，那就是他的嘴巴特大，鼻子却偏小，睡觉时特爱打呼噜。一到晚上，河马先生的呼噜声就“轰隆!轰隆……”不停地钻向阳光公寓的每一个角落，使得正在睡觉的邻居们就像坐在一列不停地钻山洞的火车上，根本无法睡着。</p><p><br></p><p>几天下来，邻居们受不了了：白天上班直打瞌睡，兔小姐的心脏发病了，山羊公公的血压直往上“蹦”，小猴子烦燥得到处找人吵架……唉，再这样下去，可怎么得了?</p><p><br></p><p>一个星期天的早晨，除河马先生外的阳光公寓居民们，都相约聚在公寓一旁的小公园里，讨论如何不让河马先生的呼噜声影响大家这一问题。</p><p><br></p><p>兔小姐说：“我们给河马先生做个大口罩吧，捂住他的呼噜声。”</p><p><br></p><p>山羊公公说： “不行不行，呼噜声用口罩是捂不住的，再说大热天的，让河马先生捂着大口罩睡觉，那多难受啊。”</p><p><br></p><p>狐狸说：“要不让他搬出阳光公寓吧，我可真受不了他的呼噜声了。”</p><p><br></p><p>狐狸这话刚一出口，马上遭到鸡妈妈和鸭太太的反对：“不能赶他走!想想河马先生对我们大家那么好，我们哪个没得到过他的帮助?我们可不能做无情无义的事。要是河马先生晚上不睡觉白天睡觉就好了。”</p><p><br></p><p>小猴子一听，猛拍一下脑袋跳起来：“嘿!有办法了!我们可以请河马先生当本公寓的保安员，晚上值班巡逻，白天睡觉。”</p><p><br></p><p>大家一听，都说：“妙!妙!”可不，河马先生下岗后天天出去找工作，到现在还没找着。让他当保安员，既为他找到了工作，又对公寓里的居民们大有好处——他个头大又热心!这真是个两全齐美的好办法呀!</p><p><br></p><p>此时，河马先生正背大包拎小包地走出家门呢，一见许多邻居到来，忙说：“对不起!我刚才无意中听到了你们的谈话，才知道我的呼噜声太大了，影响了大家。我要走了，我想回到河边的老房子住。再见!朋友们。”</p><p><br></p><p>“是这样的……”山羊公公捋着白胡子，将大家决定聘请他当阳光公寓保安员的想法说了一遍，并问：“不知你愿不愿意?”</p><p><br></p><p>河马先生一听，立即扔下大包小包，拥抱着大家，连声说：“愿意!愿意!谢谢大家对我的信任，我保证晚上不打呼噜白天打呼噜!”</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/a9fe62ac20fbc73b605e0cdf6a38c268-sz_321258.jpg?x-oss-process=style/xmorient\"></p><p>自从有了河马先生当保安员，阳光公寓的动物居民们，晚上睡觉更香更甜更放心了，白天上班有精神，情绪开朗，大家和睦相处。最近，阳光公寓还被评为最佳“安全、文明、和睦、卫生”公寓呢。</p>', 'http://img.jssns.cn/SHILU/1/40172499760491943.png', 'http://img.jssns.cn/SHILU/1/04be32b7ff6d8a75b2b3c60e70df8604.jpg', null, 'album', 'ID558303512723718144', '115', '8', '4', '168', '2018-11-30 16:13:28', '168', '2019-01-28 09:22:26');
INSERT INTO `audio` VALUES ('ID518098057879879680', '妈妈的故事盒', 'https://www.jssns.cn/SHILU/1/b0059d8e5258454efe756c813dd78531.mp3', '', 'http://img.jssns.cn/SHILU/1/40172694544847942.png', 'http://img.jssns.cn/SHILU/1/1baec169a5fdf943892c884727403c3d.jpg', null, 'album', 'ID558316417410138112', '109', '4', '11', '168', '2018-11-30 16:16:42', '168', '2019-01-28 09:30:08');
INSERT INTO `audio` VALUES ('ID518098356564656128', '大人们奇怪的要求', 'https://www.jssns.cn/SHILU/1/e8ceae30fd44459932049d8a4750aec7.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/a6dc46dcc841693549dfa07b33518bbb-sz_334222.jpeg?x-oss-process=style/xmorient\"></p><blockquote>“快点去洗澡！”</blockquote><blockquote>“快点穿上你的衣服！”</blockquote><blockquote>“快来！”</blockquote><blockquote>“快一点完成作业！”</blockquote><blockquote>“快去睡觉！”</blockquote><blockquote>“快去洗手”</blockquote><blockquote>“快去吃饭！”</blockquote><blockquote>可我们从来没听过：</blockquote><blockquote>“慢点去洗澡！”</blockquote><blockquote>“慢点穿上你的衣服！”</blockquote><blockquote>“慢慢来！”</blockquote><blockquote>“慢一点完成作业！”</blockquote><blockquote>“慢慢去睡觉！”</blockquote><blockquote>“慢慢去洗手”</blockquote><blockquote>“慢慢去吃饭！”</blockquote><p><br></p><p>仿佛在大人的世界里，很多事情都必须很快的去完成，而且是越快越好。可大人们的要求总是很奇怪的，他们有时候会要求我们快一点，有时候又会要求我们慢一点。</p><p><br></p><p>比如，当你写作业的时候，大人们会说：“画慢一点，否则你会涂改的乱七八糟！”“如果你慢一点，就可以少犯些错误！”哎，一会儿快，一会慢，真让人有些不知所措呢~</p><p>&nbsp;</p><p>那么我们到底该慢一点呢，还是快一点呢？如果我们愿意的话，是应该快速迅速地长成大人，还是继续优哉游哉地再当一阵爸爸妈妈的小宝宝呢？</p><p><br></p><p>你过生日的时候，是选择迅速地把蛋糕一扫而光呢，还是慢慢地去品尝它的美味呢？</p><p><br></p><p>放学后，你是赶快去做作业呢，还是在这之前先慢慢地玩一会？</p><p><br></p><p>大人们一会说做事拖拖拉拉是浪费时间，一会又说做事从容不迫非常重要。所以，想把握好时间并不是一件容易的事情。而且，一个很现实的情况是，几乎所有的奖励都给了那些行动迅速的人！</p><p>&nbsp;</p><p>那么，我们到底该如何把握时间呢？哦对了，时间到底是什么呢？</p>', 'http://img.jssns.cn/SHILU/1/40172765696170561.png', 'http://img.jssns.cn/SHILU/1/85cd8615d6f5ace0e23c1857e6ddf640.jpg', null, 'album', 'ID515536344454266881', '138', '7', '2', '168', '2018-11-30 16:17:54', '168', '2019-01-26 10:23:28');
INSERT INTO `audio` VALUES ('ID518098925983367168', '时间到底是什么？', 'https://www.jssns.cn/SHILU/1/ed60b49258fc06481761072a7878601e.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/f90fba54ab210f596c2afc24a10d2ae0-sz_1106817.jpg?x-oss-process=style/xmorient\"></p><p>我们的生活离不开时间，课堂的时钟、手表上的数字、收音机里的报时，都不断在告诉我们现在的时间。可问题是，你有思考过，到底什么是时间吗？&nbsp;</p><p>没有任何人能够看到时间，触摸到时间或者听到过时间，仿佛时间根本不存在。&nbsp;</p><p><br></p><p>可我们每个人都看到过季节的交替和变化：<strong style=\"color: rgb(241, 27, 27);\">花儿慢慢开放、秋叶片片飘落、白雪皑皑铺满异地。我们感受过阳光闪耀，大地渐渐回暖，也感受过冰天雪地，透着刺骨的寒气。</strong>我们能听到的是，白天知了在树上唱歌，夜晚一群青蛙在池塘里呼朋引伴。&nbsp;</p><p>&nbsp;</p><p>试想下，如果有这样的一位年轻的小伙子，他在冰块里沉睡了整整50年。当他苏醒过来的时候，发现周围的人和事都变了：曾经黑色头发的爱人现在已经是满头白发，眼角也爬满了皱纹；以前骑自行车的儿子，现在开上了汽车；孩子出生时他在花园里栽种的树木现在也长得枝繁叶茂；马路旁的咖啡馆也不见了，取而代之的是一家大型商场。。。。。。&nbsp;</p><p><br></p><p>这位不年轻的小伙子，看着眼前的一切，不由得感叹了一句：“时间过得真快啊~”&nbsp;</p><p>&nbsp;</p><p>是啊，时间过得真快啊，一睁眼就已经过去了50年。那么老先生是如何感知到了时间的流逝呢？没错，是因为他周围的一切都发生了翻天覆地的变化。</p><p><br></p><p>我们可以猜测，如果这个小伙子在一个完全陌生的环境里醒来，周围没有他的爱人和儿子，也没有花园和街道，那么他是绝对不会知道从自己入睡的那一天起，已经过去了多少时间。&nbsp;</p><p><br></p><p>所以，时间留存于我们这个世界的只是变化，即时间就是变化，时间就是改变。&nbsp;</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">随着时间的流逝，世界上的一切事物都在不断地演变和变化着。这种巨大的演变和变化有时会让我们感到害怕。的确，时间是一个可怕的东西。&nbsp;</strong></p><p>&nbsp;</p><p>当我们说：“我害怕长大”，这不是说：“我害怕长个子或长胖”，而是想说：“我害怕爸爸妈妈不再像以前那样爱我了”，当然，我们也担心，万一自己长大后成为了自己曾经讨厌的人，或者变得完全不像现在的自己。&nbsp;</p><p>&nbsp;</p><p>其实，我们只要看看我们的爷爷就行了：相册里的明明是个含着奶嘴的小宝宝，可我们眼前却是个花白胡子，拄着拐杖，叼着烟斗的老人。我们很难想象，爷爷居然和照片上的婴儿是同一个人。&nbsp;</p><p>&nbsp;</p><p>没错，他们确实是同一个人，时间改变了他，改变了他的身体，当然也改变了他的性格。但他们看起来又完全不一样：爷爷确实是从一点点大的婴儿长大的，可现在的他已经完全不是过去的他了。&nbsp;</p><p>&nbsp;</p><p>所以，这些绝大的变化，让我们每个人都害怕时间，害怕时间的流逝。于是，几乎每个人都在思考这样的一个问题，随着时间的流逝，我们能给这个世界留下些什么呢？这是个值得思考的问题。&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/40172901488089404.png', 'http://img.jssns.cn/SHILU/1/1fbf12b16d23f651bf5da60e6b021066.jpg', null, 'album', 'ID515536344454266881', '125', '5', '3', '168', '2018-11-30 16:20:09', '168', '2019-01-26 10:22:28');
INSERT INTO `audio` VALUES ('ID518099783953416192', '我们可不能当时间的老大', 'https://www.jssns.cn/SHILU/1/7394e9500337b85de62321f7e1e6eff7.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/7bafd0e3aa85aeddbbe212f8bb7fd487-sz_1611904.jpg?x-oss-process=style/xmhigh\"></p><p>现在是星期天晚上19点10分，小明正在平板电脑上看动画片，她非常喜欢这个动画片。可是看着看着，她的兴致在慢慢地减退。因为她知道再过20分钟，爸爸或是妈妈就会让她把平板电脑关了，去做作业。</p><p><br></p><p>因为家里的规矩一直都是这样的：需要在晚上9点睡觉前完成当天的所有作业。小明每过一会儿就看下时间，这样她变成焦躁不安，已经没有心思来享用最后20分钟的动画片时间了。</p><p>&nbsp;</p><p>忽然，她想出了一个绝妙的主意。她心想：这些讨厌的时针不停地往前走，就是它们在捣乱。爸爸妈妈总是不断地看这些时针，一旦它们走到某个数字，就会开始发号施令!所以，只要我把时针弄停下来不就解决问题了吗？我真是太机智了~</p><p>&nbsp;</p><p>于是，小明站了起来，到家里每个房间转了一圈，取下了所有时钟的电池，现在所有的时针都停在了19点15分。为了防止计划失败，小明还把所有的手表也藏了起来。这一切做完之后，她心满意足的回到了平板电脑前，滋滋有味的看了起来。</p><p>&nbsp;</p><p>渐渐地，小明的父母开始觉得不对劲儿了。</p><p><br></p><p>小明的爸爸首先发现电视上，星期天晚上电影频道播的电影已经开始了。这非常奇怪，因为在电影开始之前，一直都是有个晚间新闻节目的，而新闻这个节目，他是绝对不会错过的~！</p><p>&nbsp;</p><p>与其同时，小明的妈妈也发觉到了异常：家里怎么到处都是焦臭味儿？她突然想起了烤箱里的烤鱼，她赶紧跑过去一看，烤箱里的鱼已经变成了一块木炭~到底出了什么怪事呢？</p><p>&nbsp;</p><p>当小明的爸爸妈妈再一次抬头看墙上的时钟时，他们终于知道了原因：时钟停止走动了！可他们不知道到底是什么原因让这些时钟不走动了。我敢肯定，当他们搞清楚这背后的原因时，小明一定会被父母要求写检讨书的~</p><p>&nbsp;</p><p>由此可见，我们不能替代时间老大的位置。妄图停止时间，成为时间的老大的人，都会把自己的生活搞得一团糟~</p><p>&nbsp;</p><p>这就是我们为什么需要在每个地方放置时钟的原因了~</p>', 'http://img.jssns.cn/SHILU/1/40173106271346995.png', 'http://img.jssns.cn/SHILU/1/371966af5821e7587875300a664fff0f.jpg', null, 'album', 'ID515536344454266881', '110', '6', '5', '168', '2018-11-30 16:23:34', '168', '2019-01-26 10:20:11');
INSERT INTO `audio` VALUES ('ID518101884913844224', '一小时是太长还是太短？', 'https://www.jssns.cn/SHILU/1/a5754056a58ba992ca571defe4a67313.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/af351fe45fad8068952067c52037df41-sz_164996.jpeg?x-oss-process=style/xmorient\"></p><p>著名物理学家爱因斯坦曾说：<strong style=\"color: rgb(241, 27, 27);\">“时间是相对的”</strong>，其实，即使没听过这句话，我们也知道时间是相对的。比如，当我们犯错被老师罚站时，那十分钟就和一小时一样漫长；而在体育课上，当我们和伙伴一起玩耍时，一小时就像十分钟那样短暂。</p><p><br></p><p>接下来，我会说一个有趣的小故事，进一步向你解释时间的相对性：</p><blockquote>一天早上，在送芳芳去学校的路上，妈妈对她说\"今天，对我来说将是没完没了、无比漫长的一天。”芳芳听后开始仔细分析妈妈的话，\"没完今没了的一天？是什么意思呢？”</blockquote><blockquote><br></blockquote><blockquote>在芳芳所经历的世界里，所有的白天都是一样的，而且在同样的时间里，她总是做着同样的事情：早上8点半，妈妈会开车送她去学校上课；然后，晚上6点钟，妈妈会来接她放学。</blockquote><blockquote><br></blockquote><blockquote>可听了妈妈的话以后，芳芳一整天都在担心：如果今天真的是没完没了，那么会发生些什么事情呢？也许她将永远待在学校里，因为再也没有下课铃；也许妈妈将再也不会来接她回家了，因为妈妈永远不会下班；更可怕的是，太阳将不再下山，天空会一直这么亮着。</blockquote><p><br></p><p>不过，芳芳的担心都是多余的。事实上，她妈妈所说的“今天没完没了”指的是，她预感这一天会很艰难：收音机里插播的路况消息意味着她去办公室的过程中会遇到很多交通麻烦；之后，中午11点钟她要去见一些客户，然而这些客户对她的公司非常不满；再然后，她还应该给她的弟弟打个电话，因为她和她的弟弟前几天吵了一架；最后，也是最让她头疼的，今天晚上，芳芳的爷爷奶奶要来吃晚饭，可她现在连菜都还没有买。</p><p>&nbsp;</p><p>以上这些就是妈妈觉得这一天将会没完没了的原因。事实上它并不比别的日子多一分一秒。只是因为芳芳的妈妈将面临一些困难的事情，一些令她不愉快的事情，所以这一天时间对她来说就显得非常漫长。</p><p><br></p><p>我们想象下，如果芳芳的妈妈带上一本好书，去海边晒太阳、游泳，顺便吃个美味的冰激凌，那么她绝不会认为这一天太漫长了，相反，她会觉得这一天太过短暂。</p><p><br></p><p>所以，我们在生活中感受的并不是时间，我们感受的是我们度过时间的方式。</p>', 'http://img.jssns.cn/SHILU/1/40173606979100527.png', 'http://img.jssns.cn/SHILU/1/221495c4cce81b012ecbb0cf1c508c34.jpg', null, 'album', 'ID515536344454266881', '108', '5', '6', '168', '2018-11-30 16:31:55', '168', '2019-01-26 10:18:28');
INSERT INTO `audio` VALUES ('ID518103250356928512', '谁在支配着你的时间？', 'https://www.jssns.cn/SHILU/1/96692ec7fb9d2b57a254319d56441e7d.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/853736efd4df536be28d8d6f6ba912ff-sz_284279.jpeg?x-oss-process=style/xmorient\"></p><p>不管是在学校还是在家里，我们常常会觉得是<strong style=\"color: rgb(241, 27, 27);\">其他人在支配我们的时间。</strong>事实也的确如此！</p><p><br></p><p>让我们一起来看看芳芳的时间表。</p><p><br></p><p>从星期一开始，一直到星期五。芳芳每天早上8点30分芳芳去到学校，中午在学校的食堂吃饭，下午6点放学回家。每周都是如此，一直到放寒暑假。</p><p><br></p><p>所以，对芳芳而言，从周一到周五，每天早上8点30分到下午6点钟这段时间都是由学校决定的。</p><p>&nbsp;</p><p>在这些日子里，芳芳能够支配的时间只是晚上6点钟到7点钟这1个小时，因为7点以后，还要做作业、吃晚饭、洗澡和睡觉。也就是说，当芳芳上学的时候，她<strong style=\"color: rgb(241, 27, 27);\">每天能够支配的时间只有一个小时</strong>。因此，我们可以说芳芳的时间几乎都是由其他人来决定的。</p><p><br></p><p>你也许会说，只有小孩子的时间才会被其他人支配，大人们总是想干什么就干什么！事实真的是这样的吗？我们来看下马婷小姐的时间表。</p><p>&nbsp;</p><p>马婷小姐是花店老板，她非常热爱自己的工作。为了店里能够天天出售美丽而新鲜的花朵，除了星期一，她每天清早6点钟去鲜花批发市场。在那儿，马婷小姐把当天买进的鲜花装上她的小型卡车，再运到自己的花店。花店从上午9点到晚上7点营业，由于马婷小姐还没有足够的钱来雇用一个女店员做帮手，所以她得整天待在店里。</p><p><br></p><p>等到花店关门以后，她不是去看看朋友，就是去电影院，要不就干脆回家······她总是尽量在晚上11点钟以前睡觉，否则，第二天早起就会成为一个问题。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">因此，我们可以说马婷小姐的时间是由她的工作决定的，只有晚上7点以后这段时间完全是由她来决定。</strong></p><p><br></p><p>所以，马婷小姐能够随心所欲支配的的间每天只有四小时，再加上每周星期一。</p><p><br></p><p>因此，马婷小姐并没有很多她想做什么就可以做什么的时间，也就是说，她没有很多自由的时间。</p><p>&nbsp;</p><p>自由的时间，一个多么有趣的表述啊！照这样说，其余的就是不自由的时间喽~不自由的时间顾名思义就是被剥夺的时间，被限制的时间，被占用的时间。</p><p>&nbsp;</p><p>那自由的时间和不自由的时间，到底有什么区别呢？不自由的时间就是由别人而不是由我们自己来支配的时间，在这段时间里，是别人来决定我们应该做什么。</p><p>&nbsp;</p><p>而自由的时间，就是空闲的、可以占用的、由我们自己支配的时间。在这段时间里，我们自己决定我们将要做的事，而不必征求别人的许可。</p><p><br></p><p>当某个人抱怨说。我没有时间，实际上他是想说，我没有自由的时间，我没有自由，我没有让我任意支配的时间。</p><p>&nbsp;</p><p>如果时间总是由别人来支配的话，这就和没有时间几乎一样。这就清楚地证明了，<strong style=\"color: rgb(241, 27, 27);\">真正的时间是那些自由的时间，是可自由支配的时间。</strong></p>', 'http://img.jssns.cn/SHILU/1/40173932525215283.png', 'http://img.jssns.cn/SHILU/1/b8c96477efac7d4390e47ffd3815c1a6.jpg', null, 'album', 'ID515536344454266881', '111', '1', '7', '168', '2018-11-30 16:37:20', '168', '2019-01-26 10:17:19');
INSERT INTO `audio` VALUES ('ID518104967974748160', '有时候无所事事也很重要', 'https://www.jssns.cn/SHILU/1/3216582b83e5987933351f76c8bd9ea9.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/5d956991ce38488b8ee2a454fcc8cb43-sz_2192201.jpg?x-oss-process=style/xmhigh\"></p><p>星期六，外面下着雨，小明待在家里，他不想看书，也不愿意看电视里无聊的节目，唯一有兴趣玩的有轨汽车玩具也坏了。</p><p><br></p><p>小明转来转去，找不到任何事做，真是无聊极了。他躺在地毯上，眼晴盯着房间里蓝色的天花板发呆，觉得生活一点意思也没有。后来他的眼光落到了一只大黑苍蝇的身上，黑苍蝇正一动不动地叮在天花板上。一会儿，不知为什么，它飞了起来，围着电灯转圈，一圈、两圈、三圈、四圈。然后，它又飞回原先停落的那个位置。</p><p>&nbsp;</p><p>小明的眼晴一直盯着黑苍蝇，为了不把它吓跑，他大气也不敢出，一动不动地待在那儿。这不，黑苍蝇又开始转圈玩了。小明内心里羡慕这只苍蝇，因为苍蝇可以自由自在的飞翔，而他却怎么也飞不起来。</p><p>&nbsp;</p><p>慢慢地，小明仿佛看见自己飞出了窗口，停落在对面广场上的一棵树上；然后越过高高的房子，在学校的上空盘旋了一阵；之后，他直冲云霄，飞到了云朵之上。在那里，他能够俯瞰整座城市，看到前所未见的美景；最后，他贴着云层翱翔一周，迅速俯冲直下，停落在了海过。在海边，有一顿美味的晚餐在等着他，桌子上由他最爱吃的汉堡。</p><p><br></p><p>就在他要拿起汉堡大吃起来的时候，小明被一阵急促的敲门声吵醒了。他打开门，爸爸进来了并问他：“你今天过得怎么样？”</p><p><br></p><p>他回答说：“好极了！对了，爸爸，下次放暑假的时候，有没有一个地方可以让我们去学习遥控滑翔？”爸爸惊诧地看着他，不知他从哪儿想出了这么一个主意。不过，爸爸最终还是同意了小明的建议。</p><p>&nbsp;</p><p>实际上，在我们无所事事的时候，在我们感觉无聊的时候，我们就会意识到时间的流逝。因为在这个时候，时间过得很慢很慢。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">但无聊也有好处，正是在这样的时候，我们的思想才有了活动的空间，我们才能够去做白日梦，去畅想自己的梦想。</strong>正如上面的故事中，小明恰恰是在无所事事的时候才会梦想自己飞翔的画面，才可能和父亲一起提出一些设想，才可能想像未来，才可能有所渴望。如果那时候，小明是在练柔道、解数学题或者看电视，他是绝不可能想到这些的。</p><p>&nbsp;</p><p>舍不得花时间去思考的人是很难有远大规划的，因为他对未来并不寄托太大的希望。<strong style=\"color: rgb(241, 27, 27);\">思考，就必须要有时间，要有自由的时间，要有空闲的时间。</strong>这个时间，只有在无所事事的时候才能找到。</p><p>&nbsp;</p><p>然而，这样的时候并不多。我们大家都有一个所谓的时间表，在这个时间的表格里，很少填着梦想的时间，什么事也不做的时间。</p><p><br></p><p>那么什么是时间表呢？它有什么作用呢？为何大人们都要围着他转呢？</p>', 'http://img.jssns.cn/SHILU/1/40174342011924733.png', 'http://img.jssns.cn/SHILU/1/4e7f49ae1340b0fd684796b1a646d605.jpg', null, 'album', 'ID515536344454266881', '102', '1', '8', '168', '2018-11-30 16:44:10', '168', '2019-01-26 10:16:22');
INSERT INTO `audio` VALUES ('ID518107379900874752', '“时间表”让我们没有空闲时间', 'https://www.jssns.cn/SHILU/1/4ae5751c6346a5744197baaead4205aa.mp3', '<p><br></p><p>明天是星期六，不上学的日子。小智决定在自己的家里组织一个小小的晚会。</p><p><br></p><p>傍晚的时候，她打电话邀请她的小伙伴儿们。阿信不能来，她要上戏剧课，然后还有钢琴课；悦悦也不能来因为她要上绘画课和英语口语；小明虽然也要上空手道和游泳课，但会在中间抽空来一趟，可以待一个小时；美美要来，可是她的妈妈会早早地来接她去上陶瓷艺术课；但好运总是有的，住在小智隔壁的小辉同学可以来，因为他的爸妈同意他今晚不去雕刻工作室。</p><p>&nbsp;</p><p>由此可见，虽然明天是不用上学的星期六，可阿信、悦悦、小明和美美都不可能躺在地板上盯着天花板去梦想。他们都有一个时间表，他们的时间被分成了一个一个格子，而且所有的格子都被填得满满的。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">当然，了解和参加各种各样的文体活动，然后找到自己真正喜爱的一种，是一件很有趣的事。</strong>而且，也许将来他们长大了，会成为优秀的画家体操运动员、黑腰带顶级空手道运动员、游泳健将、雕刻家······</p><p>&nbsp;</p><p>不过，大人们在他们孩童时代也曾有过一个满满的时间表，可最后成为画家、体操运动员、空手道运动员、游泳健将、雕刻家的人太少太少。大人们更多是成为了律师、医生、销售、老师等等。</p><p>&nbsp;</p><p>面对一个盯着天花板上的苍蝇发呆的人，一个“浪费自己时间”的人，我们可以猜想他将成为什么样的人。我们也可以设想一下，那些舍不得花时间去无所事事的人们又会成为什么样的人。这些人会梦想他们的生活、他们的未来吗？他们能展开想像的翅膀翱翔吗？他们有能力去发明创造吗？</p><p>&nbsp;</p><p>空闲的时间，有时也把它叫作“死去的时间”。无所事事，就有点像死去一样。肯定是因为这一点，人们常常认为忙忙碌碌的时间，才是充满活力的时间。</p><p>&nbsp;</p><p>另外，大人们不喜欢看到孩子们整天无所事事，不愿意看见孩子们到处闲逛。<strong style=\"color: rgb(241, 27, 27);\">他们安排孩子们的时间，以便让孩子们没有空闲。他们也是这样安排他们自己的时间的。</strong></p><p>&nbsp;</p><p>时间慢慢地将所有的人引向衰老，引向死亡。人们知道，有一天他们在地球上的时间将会停止。也许正是这一点让人感到害怕。他们寻思着如果不停地折腾，如果他们把时间填得满满的，他们就看不到时间的流逝，从而也就看不到自己的衰老了，看不见自己向死亡一步一步地迈进。</p><p>&nbsp;</p><p>因此，假如他们看到时间在流逝，假如他们拥有了空闲的时间，他们就会有一种浪费生命的感觉。对于许多人，浪费时间多多少少是在浪费他们的生命；对于许多人，浪费时间与“享受”生活是背道而驰的。但是，“享受”生活究竟意味着什么？是否就是要不断地填满时间，快速地生活，做成干上万件事情呢？</p>', 'http://img.jssns.cn/SHILU/1/40174917210460318.png', 'http://img.jssns.cn/SHILU/1/4acc196f552f29c1e5f5fc356ee3fc35.jpg', null, 'album', 'ID515536344454266881', '104', '2', '9', '168', '2018-11-30 16:53:45', '168', '2019-01-26 10:15:02');
INSERT INTO `audio` VALUES ('ID518118251692032000', '请学会享受生活', 'https://www.jssns.cn/SHILU/1/884c8418a5159109f17d16251d0717e5.mp3', '<p><br></p><p>游乐园刚刚开门，小智和他的父母就分秒不差地赶到了。因为买的是<strong style=\"color: rgb(241, 27, 27);\">全日票</strong>，可以在里面玩上整整一天，所以他们认为无论如何是值得早早赶到的。</p><p>&nbsp;</p><p>下午4点钟左右，坐了五趟超音速火车，飞了十圈儿吊椅，玩了四趟高速转盘，看了两场海豚表演，滑了四次巨型滑道，尝试了三次蹦极以后，小智实在支持不住了，他已经筋疲力尽，双脚疼得钻心。现在他只想一件事：回家，脱下鞋子，瘫倒在电视机前。</p><p><br></p><p>小智的父母和小智一样累，可是他们却冲着小智喊道：“小智，你有毛病吗？绝对不能现在就离开，我们还没有把所有的项目都玩个遍呢！你知道吗，我们可是付了一整天的钱，必须享受到底，玩到关门为止！”</p><p>&nbsp;</p><p>哈哈，听完这个故事，你是不是也觉得他们这样累都是自找的？确实，他们活该这么累！谁让他们心想游乐园晚上关门，就好像所有的一切都将停止一样，所以要充分享受个够。</p><p>&nbsp;</p><p>这正是人们常常认为的：<strong style=\"color: rgb(241, 27, 27);\">因为生命有一天会停止，所以要充分享受。</strong>不仅如此，对许许多多的人来说，“享受”就意味着去做尽量多的事情。</p><p><br></p><p>享受游乐园，就是说在一天之内去参加尽量多的游乐活动，哪怕我们已经感到厌烦了。我们付了一整天的钱，就必须待下去。否则，我们就会有负罪感，觉得这不仅浪费了自己的时间，而且还浪费了金钱。</p><p>&nbsp;</p><p>因此，在人类的生活中还有另一个头儿：金钱。它与时间如同一对孪生兄弟。所以，人们才会经常说：<strong style=\"color: rgb(241, 27, 27);\">“时间就是金钱”。</strong></p><p><br></p><p>“时间就是金钱”？多么奇怪的想法！但是，如果我们认真地观察一下人类的生活，就会发现这种想法并不愚蠢。</p><p>&nbsp;</p><p>大人们以各种方式挣钱：他们在工厂、办公室、商店、餐馆工作，或者当水管工、足球运动员、医生、小学教师、卡车司机······对这些无论做什么工作的人们，我们的要求是什么呢？就是将时间都用在工作上，准时上班，待上足够的时间，不许提前离开，等等。<strong style=\"color: rgb(241, 27, 27);\">我们对他们的要求总是时间。</strong></p><p><br></p><p>当然，给他们付工资的人要看他们的工作，但同时也要计算他们工作的时间。一位水管工来修理一个漏水的水龙头，当他修好以后。他会说：“我用了一刻钟的时间，一共80块钱”。如果路上他还花了半个小时的话，那就应该付150块钱。</p><p>&nbsp;</p><p>人们付钱给这位水管工，当然是因为他修理好了水龙头，但是也因为他还为一刻钟的修理花了半个小时来这里，所以，人们为他花费的时间付钱；而他呢，则出售自己的时间。他的时间是用金钱来衡量的。</p><p>&nbsp;</p><p>假如一个人看见水管工坐在露天咖啡馆，沐浴着阳光，懒洋洋地读着报纸，他将这样说：“瞧，这个水管工在浪费自己的时间，他这样花费时间就是在浪费自己的金钱！”</p><p>&nbsp;</p><p>人类用金钱来衡量时间，以秒钟、分钟、小时来计算。所以人们不喜欢浪费时间，因为这多少有点像在朝窗子外边扔硬币和钞票，白白糟蹋了金钱。</p>', 'http://img.jssns.cn/SHILU/1/40177509155594692.png', 'http://img.jssns.cn/SHILU/1/c06454ab7c4f80009f12a4e345aa484f.jpg', null, 'album', 'ID515536344454266881', '103', '2', '10', '168', '2018-11-30 17:36:57', '168', '2019-01-26 10:13:53');
INSERT INTO `audio` VALUES ('ID518126692514922496', '鼹鼠找面包', 'https://www.jssns.cn/SHILU/1/6a93c65b235ac0a1380b629dfea13c76.mp3', '<p>鼹鼠找面包</p><p><br></p><p>&nbsp;</p><p>鼹鼠妈妈找啊找，找到一小块面包。她想：这面包香喷喷的，我的小鼹鼠一定爱吃。她拖啊拖啊，把面包拖回家。</p><p><br></p><p>小鼹鼠抱住面包，咬了起来 ：“这面包真香！真好吃！”</p><p><br></p><p>鼹鼠妈妈听了，高兴得合不拢嘴，说：“小乖乖，你喜欢面包，妈妈再给你找！”</p><p><br></p><p>鼹鼠妈妈又出去找面包了。这回她找到一片面包。她想：这面包片又平又软，给我的小鼹鼠当床铺正合适。她拖啊拖啊，把它拖回家。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/bf9d305595db00509f10c4c11d8d7d60-sz_10849.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>这面包真大，差点儿进不了门。小鼹鼠看见了，在面包床上翻筋斗，说：“这床又软又舒服，还香喷喷的呢！”</p><p><br></p><p>过了几天，鼹鼠妈妈一看，面包床怎么没有了?小鼹鼠说：“面包床真香，真好吃，都被我吃光啦！妈妈，你再给我找一张吧！”</p><p><br></p><p>鼹鼠妈妈又去找了。找啊找啊，总算又找到了一块面包。它刚刚烤好，特别香。</p><p><br></p><p>这面包好大好大，鼹鼠妈妈搬不动。她喊来鼹鼠爸爸，一个抱，一个推，好不客易才把大面包搬到家门口。</p><p><br></p><p>面包大，门儿小，怎么也进不去。有什么办法呢？鼹鼠妈妈想了好一会儿，才想出个好办法：做成房子给小鼹鼠住。</p><p><br></p><p>鼹鼠爸爸和鼹鼠妈妈把面包抬到空地上。鼹鼠妈妈在面包上啃了一个洞当门，让小鼹鼠钻进去。小鼹鼠睡在面包房于里，地板、天花板全是面包，饿了只要张开嘴巴咬一下，就能吃到面包了。</p><p><br></p><p>小鼹鼠在面包房子里，吃了睡，睡了吃，比谁都快活。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/e20fc232423da8bcf1dd0eb595093dcc-sz_289475.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>太阳出来了，照在面包房子上，里面暖和极了。</p><p><br></p><p>小松鼠来喊小鼹鼠出去玩，可小鼹鼠说：“不，外面太冷。我不想出去。瞧，我的房子里，就像生了火炉，可暖和啦，真舒服！”</p><p><br></p><p>小路鼠一动不动地呆在面包房于里，长成了大胖子。</p><p><br></p><p>可是，有一天下起了大雨。雨水把面包房子泡成了一堆稀泥。鼹鼠妈妈跑出来一看，只见旁边有个“大泥球”在滚来滚去。哟！原来这“大泥球”就是小鼹鼠呀！</p><p>&nbsp;&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/41621443724207782.png', 'http://img.jssns.cn/SHILU/1/0f9866ae33fc2d81d77fa9b889d4b776.jpg', null, 'album', 'ID558316417410138112', '104', '3', '13', '168', '2018-11-30 18:10:29', '168', '2019-01-28 09:32:19');
INSERT INTO `audio` VALUES ('ID518128033970782208', '序：育儿的道与术', 'https://www.jssns.cn/SHILU/1/d548de6c77e48b4b8f6b8f1968b88b69.mp3', '<p><br></p><p>今天我们来推荐一本今年备受瞩目的育儿书籍——<strong style=\"color: rgb(241, 27, 27);\">《园丁与木匠》</strong>，这本书的作者是加州大学伯克利分校的发展心理学家艾莉森·高普尼克。就算你不是家长甚至根本不打算要孩子，我相信你也会对这本书感兴趣，因为它会让你深入理解“人”。</p><p>&nbsp;</p><p>我有一个女儿，但我对“怎样当好家长”这个话题没有太大兴趣。一方面我觉得自己应该志在四方，努力实现自我价值；另一方面，我认为所谓“育儿指南”，大部分都是不怎么靠谱的学问。</p><p>&nbsp;</p><p>你问任何一个“育儿专家”，在这个具体事情上，我应该对孩子做什么 —— 他都能讲一大堆道理说明为什么你只应该这么做。<strong style=\"color: rgb(241, 27, 27);\">他会说如果你不这么做，就会有什么什么样的坏影响，搞不好会毁了孩子的一生。</strong></p><p>&nbsp;</p><p>仿佛教育孩子是一件门槛很高的事情，你需要先把自己变成那些无所不知的“育儿专家”，这样才有资格培养出优秀的孩子。</p><p>&nbsp;</p><p>可是事实上，你看看那些真有出息的人物，他们的父母多种多样，有的有文化有的没文化，有的有钱有的没钱，有的管得严有的管得松……<strong style=\"color: rgb(241, 27, 27);\">他们的共同特点是没读过什么育儿指南。</strong></p><p>&nbsp;</p><p>与此同时，我们还看到大量负面的育儿案例，什么高知父母管得孩子厌学，中产父母逼得孩子自杀，他们都是育儿指南的受害者。</p><p>&nbsp;</p><p>当然这么说不科学，我们不能拿特例和个人观感下结论。如果是科学地说，据我所知，家长对孩子的影响的确是非常重大的 —— 但是这个影响并不体现在育儿指南上。家长影响孩子，有三个方面：</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">第一是提供遗传基因。</strong>这个相当重要。智力之类的素质是可以遗传的。我以前看过研究，说哪怕一个父亲生下孩子之后就死了、或者跑了，他从来没有照顾过孩子一天，这个孩子的智商和父亲的收入水平之间都有一个正相关。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">第二是提供家庭环境。</strong>这个也非常重要。中国几乎所有家长都很重视子女教育，而美国的情况则是明显的阶级分化：中产阶级家长非常重视孩子，他们的孩子的学习成绩、包括将来的成就，都比贫困家庭的孩子好得多。</p><p><br></p><p>稳定温暖的家庭环境，问问题能得到家长的回答，想去博物馆能去，想学什么课程能学，潜移默化知道怎么跟大人、陌生人、有权威的人打交道，这些肯定能让孩子受益终身。但这些事情只要是有一定条件、有一定责任心的家庭都能做到，你还是不用看育儿指南。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">第三，是具体的操作方法。</strong>这才是育儿指南大显身手的地方。而科学研究表明，具体的操作方法根本不重要。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">你是个什么人，比你对孩子做什么，重要得多。</strong></p><p><br></p><p>有的人长大以后抱怨父母钱少，有的人抱怨父母虐待，但是我从来没听说过有谁抱怨父母当年没送他上书法学习班。</p><p>&nbsp;</p><p>话虽如此，作为父母总觉得肯定有些操作是应该做的，我们总不可能就放纵孩子野蛮生长吧？那到底应该对孩子做什么呢？这就是为什么要读《园丁与木匠》这本书。</p><p><br></p><p>这本《园丁与木匠》2016年就出版了，目前为止市面上还没有中文版。它并不是一本给你育儿经验或方法的指南，<strong style=\"color: rgb(241, 27, 27);\">它讲的是最新科学结果，是人生的哲学，和童年对整个人类的价值。</strong>即这本书讨论的是育儿的“道”，从更高的视角来理解教育。</p><p>&nbsp;</p><p>想要真正掌握“术”，你得先理解“道”。想要知道怎么对待孩子，你得先知道童年到底是干什么用的。想要帮助孩子学习，你得明白儿童学习的脑科学原理。</p><p><br></p><p>高普尼克对儿童发展心理学，特别是儿童怎么学习、怎么探索的研究很深，以前出过一本书叫《宝宝也是哲学家》。儿童学习方面的问题如果可以在当今任选一个人问，你就应该选她。</p><p>&nbsp;</p><p>高普尼克已经六十多岁了，当年自己作为一个忙碌的科学家没有多少时间管孩子，可是她的三个儿子都非常有出息。她现在已经升级做了奶奶，他从孙子身上又反思了到底什么是育儿。</p><p>&nbsp;</p><p>在育儿专家看来，育儿是一项可以按照说明书操作的工作。而在高普尼克看来，育儿是在一系列矛盾中寻找一个平衡点的艺术。接下来，我们将为您解读这本书。</p>', 'http://img.jssns.cn/SHILU/1/41645946921651088.png', 'http://img.jssns.cn/SHILU/1/507a6f266dce4d2212c282d5d6e8e327.jpg', null, 'album', 'ID515536127436783617', '184', '7', '1', '432228697144033280', '2018-11-30 18:15:49', '168', '2019-01-31 23:26:20');
INSERT INTO `audio` VALUES ('ID518136921315082240', '童年是一种风险解决方案', 'https://www.jssns.cn/SHILU/1/f69024307b67ac1b25b22cc67f8115f4.mp3', '<p><strong>“家长”不是动词</strong></p><p><br></p><p>Parent（家长）这个词，在美国从七十年代开始，普遍具有了动词的形式，可以写成 parenting —— 意思是作为家长对孩子的操作。</p><p><br></p><p>你的 parenting 技能怎么样呢？育儿已经成了一门学问，有很多老一辈闻所未闻的讲究。</p><p><br></p><p>比如说，小孩晚上睡觉，是应该跟家长在同一个房间甚至在同一张床上睡 —— 育儿术语叫 co-sleeping —— 还是自己单独睡一个房间？</p><p><br></p><p>有些育儿专家会告诉你，一定要让孩子自己独立睡。很多美国家庭是孩子一出生就自己一个房间。但现在也有些育儿专家说这样会影响孩子的性格，还是应该一起睡，给孩子更多关爱。两派专家都能说出一套一套的理论，简直是你只要做错了就等于是对孩子的犯罪。</p><p><br></p><p>事实是孩子小时候跟不跟家长睡，对他长大以后的性格、能取得什么成就，根本就没有影响。</p><p><br></p><p>你要是整天被这种细节困扰，就算工作不干了个人生活放弃，全力以赴钻研和实践 parenting，也未必能培养出什么好孩子。</p><p><br></p><p>高普尼克说 parenting 在科学上几乎没用，不但没用而且还有害。越来越流行的育儿指南不但没有改善孩子的人生，而且毁了家长的人生，而且毁了孩子的童年。</p><p><br></p><p>根本问题在于，孩子，并不是你 parenting 的产品。本来这个道理很简单 —— 如果你是一个妻子，你的丈夫不是你的产品，你丈夫婚后的收入水平、性格和快乐程度不是判断你是不是好妻子的标准。如果你是一个孩子，你父母的幸福度也不是判断你是不是好孩子的标准。</p><p><br></p><p>家长跟孩子，是一种关系，而不是一个操作。</p><p><br></p><p>做家长不是做木匠去生产产品，而是做园丁，是提供良好的环境，让产品 —— 啊不是，是让孩子 —— 自己好好成长。</p><p><br></p><p><br></p><p><strong>越来越长的童年</strong></p><p><br></p><p>动物界的普遍规律是未成年期越漫长的物种，智力水平越发达。</p><p><br></p><p>哺乳动物的未成年期比一般动物长，灵长类动物的未成年期比一般哺乳动物长，而人类的未成年期则是最长的。大猩猩三四个月会走路，八九岁性成熟，十岁就已经生第一个孩子了，而今天的大多数人在这个年纪连饭都不会做。不但是身体，人类大脑也需要很多年才能长成。</p><p><br></p><p>以前有个解释说人类之所以儿童期长，是因为人类小孩的头太大，而直立行走以来女性的生理特征又不允许生头特别大的孩子，孩子必须还没长好就得生下来，都是早产儿。但这个说法只能解释人的婴儿期长，可是人类不仅仅是婴儿期长，童年和青春期都非常长，而且现在是越来越长，这又是怎么回事呢？</p><p><br></p><p>答案是因为人需要学习的东西太多了。有些八零后二十五六岁了还在上学，他们的父辈十八岁就已经参加工作了 —— 但是请注意，这一代人的知识水平和生活质量都比他们的父辈要强得多。</p><p><br></p><p>鸟类学家早就观察到，早熟的鸟，比如鸡鸭鹅，生下来没多久就能独立生存了，但是智力水平不行，也就会觅食，复杂的事儿干不了。而像乌鸦和鹦鹉非常晚熟，有一种乌鸦甚至需要被父母照顾两年，但是智力水平也高得多，那种乌鸦会使用甚至会发明工具。</p><p><br></p><p>不用为生计发愁，每天吃饱了除了学习就是玩，这是未成年人的特权。人类小孩还有一个特点，特别擅长被多个人关爱 —— 不仅父母喜欢他，爷爷奶奶、连周围陌生人都喜欢他，他能从很多人身上学到东西。</p><p><br></p><p>而人类中的成年人对此则是欣然接受，心甘情愿地给孩子提供各种服务保障。人类每一胎基本上就生一个孩子，都是精心养育，而且一养就是好多年，简直是做父母的把大部分精力都奉献给孩子了。现在有个理论说为什么别的哺乳动物都是过了生育年龄就死了，人类的女性却能在更年期之后还生活很多年呢？因为她要帮着照顾第三代。</p><p><br></p><p>当然这么做的回报也是巨大的，人类一代比一代强，早就不是一般的灵长类了。之所以不一般，在于人，特别善于应对各种不确定性。</p><p><br></p><p><br></p><p><strong>风险策略</strong></p><p><br></p><p>人类这么长的未成年期并不是几十万年前就有，有个理论认为未成年期显著变长是源自地球在五万年前经历的气候变化。气候变化导致当时的人不得不到处迁徙，这又导致了面对环境的变化。从那时候起，人的生活主题就是变化。</p><p><br></p><p>怎么适应变化呢？更长的童年，就是人的风险解决方案。</p><p><br></p><p>如果环境永远不变，你只要会一种谋生技能就行了，就好像小鸡会吃地上的虫就行。如果环境复杂多变，你就最好多掌握几项技能、甚至最好还能自己发明新技能才行，你最好……变复杂。</p><p><br></p><p>学习一项技能需要专注，而变复杂需要在各个方向探索。可是如果你整天探索这个探索那个，不老老实实赶紧学个实用的，你靠什么生活呢？</p><p><br></p><p>答案就是靠父母——小时候要多探索，长大以后再专注于收获。</p><p><br></p><p>所以父母的任务就是提供一个环境让孩子探索。他们可以无责任地随便折腾，变复杂，以期适应未来多变的环境。</p><p><br></p><p>那如此说来，“早当家”就不是好事儿，孩子不能当鸡鸭鹅养，养育的重点不是掌握某一方面的技能，而是让他学会面对未来的不确定性。</p><p><br></p><p><br></p><p><strong>混乱的价值</strong></p><p><br></p><p>前几讲咱们先讲六岁以下的学龄前儿童的家教，之后再讲上学以后怎么办。六岁以下的儿童，他们的特点是混乱。</p><p><br></p><p>家里有一个小孩就已经很乱了，像我家有两个孩子，孩子的小朋友有时候还来玩，简直就跟战场一样。但是高普尼克说，童年真正的价值就在于混乱。</p><p><br></p><p>混乱是一种演化策略，有利于孩子发展各种个性，以备将来适应各种环境。有的孩子性格比较稳重，能专注做一件事，适合稳定的环境。可是如果环境复杂多变，孩子最好就要有爱冒险的精神，能机警地意识到周围的变化。</p><p><br></p><p>那难道说有什么环境就生产什么性格的孩子吗？不是。人类的策略是各种孩子始终都有、各种性格都保留，让他们自己去闯荡不同的环境。</p><p><br></p><p>由此来说，因为未来环境不可预测，孩子将来幸福不幸福、成功不成功就不是你所能决定的 —— 得看他的特性跟他将来遇到的环境是否匹配。我们专栏第一季讲过“兰花和蒲公英”的概念，有的孩子像兰花特别挑环境，有的孩子像蒲公英走哪都能活。你决定不了你的孩子是什么，通常一家几个孩子都各有各的特点。</p><p><br></p><p>孩子的运气是孩子自己的事情，家长所能做的就是提供多方探索、体验不同环境的条件。我们爱孩子是无条件的，不论他是蒲公英还是兰花，安静还是外向，爱冒险还是胆小，我们都尽量提供探索资源。</p><p><br></p><p><br></p><p><strong>由此得到</strong></p><p><br></p><p>家长对孩子是一种关系，而不是一种工作。漫长的未成年期是人类的竞争优势，人类面对复杂多变的环境采取了先探索后收获的策略。童年时代的主要作用是探索和学习。童年，是一种风险解决方案。</p><p><br></p><p>所以我们面对的第一个矛盾是探索和收获，对应到亲子关系上，就是依赖和独立。处理这个矛盾，家长要做的是提供资源保障，让孩子充分探索。</p><p><br></p><p>家长不能确保孩子将来一定成功，不能确保孩子一定聪明，也不能确保孩子一定幸福。家长要做的不是给孩子定制、制定或者指定发展路线。家长能做的，是让孩子面对这个充满不确定性的世界，具备抗打击能力、自我发展能力和创新能力。</p>', 'http://img.jssns.cn/SHILU/1/41646187172948564.png', 'http://img.jssns.cn/SHILU/1/5c3d6385167b935613e19295da2fa1f5.jpg', null, 'album', 'ID515536127436783617', '150', '5', '2', '432228697144033280', '2018-11-30 18:51:08', '168', '2019-01-31 22:58:56');
INSERT INTO `audio` VALUES ('ID518137166967078912', '真关系和假教育', 'https://www.jssns.cn/SHILU/1/b450af1c4d8c7d8f8ec73c732c324901.mp3', '<p><br></p><p><strong>在同一张床上睡 ，还是自己单独睡一个房间？</strong></p><p>&nbsp;</p><p>有些育儿专家会告诉你，一定要让孩子自己独立睡。很多美国家庭是孩子一出生就自己一个房间。但现在也有些育儿专家说这样会影响孩子的性格，还是应该一起睡，给孩子更多关爱。两派专家都能说出一套一套的理论，简直是你只要做错了就等于是对孩子的犯罪。</p><p>&nbsp;</p><p>我感觉像高普尼克这样的科学家看育儿专家，就好像现代医学看民间偏方一样。事实是孩子小时候跟不跟家长睡，对他长大以后的性格、能取得什么成就，根本就没有影响。</p><p>&nbsp;</p><p>你要是整天被这种细节困扰，就算工作不干了个人生活放弃，全力以赴钻研和实践 parenting，也未必能培养出什么好孩子。</p><p>&nbsp;</p><p>高普尼克说 parenting 在科学上几乎没用，不但没用而且还有害。越来越流行的育儿指南不但没有改善孩子的人生，而且毁了家长的人生，而且毁了孩子的童年。</p><p>&nbsp;</p><p>根本问题在于，孩子，并不是你 parenting 的产品。本来这个道理很简单 —— 如果你是一个妻子，你的丈夫不是你的产品，你丈夫婚后的收入水平、性格和快乐程度不是判断你是不是好妻子的标准。如果你是一个孩子，你父母的幸福度也不是判断你是不是好孩子的标准。</p><p>&nbsp;</p><p><strong>家长跟孩子，是一种关系，而不是一个操作。</strong></p><p>&nbsp;</p><p>做家长不是做木匠去生产产品，而是做园丁，是提供良好的环境，让产品 —— 啊不是，是让孩子 —— 自己好好成长。</p><p>&nbsp;</p><p>那这个关系应该怎么处呢？<strong>首先你得知道童年到底是干什么用的。</strong></p><p><br></p><p>以前说“穷人的孩子早当家”是一种美德，而现在的人三十岁了还整天“我们男孩子你们女孩子”，这是不是人的退化呢？</p><p>&nbsp;</p><p>不是，这是人的进步。<strong>动物界的普遍规律是未成年期越漫长的物种，智力水平越发达。</strong></p><p>&nbsp;</p><p>哺乳动物的未成年期比一般动物长，灵长类动物的未成年期比一般哺乳动物长，而人类的未成年期则是最长的。大猩猩三四个月会走路，八九岁性成熟，十岁就已经生第一个孩子了，而今天的大多数人在这个年纪连饭都不会做。不但是身体，人类大脑也需要很多年才能长成。</p><p>&nbsp;</p><p>以前有个解释说人类之所以儿童期长，是因为人类小孩的头太大，而直立行走以来女性的生理特征又不允许生头特别大的孩子，孩子必须还没长好就得生下来，都是早产儿。但这个说法只能解释人的婴儿期长，可是人类不仅仅是婴儿期长，童年和青春期都非常长，而且现在是越来越长，这又是怎么回事呢？</p><p>&nbsp;</p><p>答案是因为人需要学习的东西太多了。有些八零后二十五六岁了还在上学，他们的父辈十八岁就已经参加工作了 —— 但是请注意，这一代人的知识水平和生活质量都比他们的父辈要强得多。</p><p>&nbsp;</p><p>鸟类学家早就观察到，早熟的鸟，比如鸡鸭鹅，生下来没多久就能独立生存了，但是智力水平不行，也就会觅食，复杂的事儿干不了。而像乌鸦和鹦鹉非常晚熟，有一种乌鸦甚至需要被父母照顾两年，但是智力水平也高得多，那种乌鸦会使用甚至会发明工具。</p><p>&nbsp;</p><p>不用为生计发愁，每天吃饱了除了学习就是玩，这是未成年人的特权。人类小孩还有一个特点，特别擅长被多个人关爱 —— 不仅父母喜欢他，爷爷奶奶、连周围陌生人都喜欢他，他能从很多人身上学到东西。</p><p>&nbsp;</p><p>而人类中的成年人对此则是欣然接受，心甘情愿地给孩子提供各种服务保障。人类每一胎基本上就生一个孩子，都是精心养育，而且一养就是好多年，简直是做父母的把大部分精力都奉献给孩子了。现在有个理论说为什么别的哺乳动物都是过了生育年龄就死了，人类的女性却能在更年期之后还生活很多年呢？因为她要帮着照顾第三代。</p><p>&nbsp;</p><p>当然这么做的回报也是巨大的，人类一代比一代强，早就不是一般的灵长类了。之所以不一般，在于人，特别善于应对各种不确定性。</p><p>&nbsp;</p><p>人类这么长的未成年期并不是几十万年前就有，有个理论认为未成年期显著变长是源自地球在五万年前经历的气候变化。气候变化导致当时的人不得不到处迁徙，这又导致了面对环境的变化。从那时候起，人的生活主题就是变化。</p><p>&nbsp;</p><p>怎么适应变化呢？<strong>更长的童年，就是人的风险解决方案。</strong></p><p>&nbsp;</p><p>如果环境永远不变，你只要会一种谋生技能就行了，就好像小鸡会吃地上的虫就行。如果环境复杂多变，你就最好多掌握几项技能、甚至最好还能自己发明新技能才行，你最好……变复杂。</p><p>&nbsp;</p><p>学习一项技能需要专注，而变复杂需要在各个方向探索。可是如果你整天探索这个探索那个，不老老实实赶紧学个实用的，你靠什么生活呢？</p><p>&nbsp;</p><p>答案就是靠父母——小时候要多探索，长大以后再专注于收获。</p><p>&nbsp;</p><p>所以父母的任务就是提供一个环境让孩子探索。他们可以无责任地随便折腾，变复杂，以期适应未来多变的环境。</p><p>&nbsp;</p><p>那如此说来，“早当家”就不是好事儿，孩子不能当鸡鸭鹅养，养育的重点不是掌握某一方面的技能，而是让他学会面对未来的不确定性。</p><p>&nbsp;</p><p>特别是幼儿，会多少个汉字，能不能算二十以内加减法，根本不重要。</p><p>&nbsp;</p><p>前几讲我们先讲六岁以下的学龄前儿童的家教，之后再讲上学以后怎么办。六岁以下的儿童，他们的特点是混乱。</p><p>&nbsp;</p><p>家里有一个小孩就已经很乱了，像我家有两个孩子，孩子的小朋友有时候还来玩，简直就跟战场一样。但是高普尼克说，童年真正的价值就在于混乱。</p><p>&nbsp;</p><p>混乱是一种演化策略，有利于孩子发展各种个性，以备将来适应各种环境。有的孩子性格比较稳重，能专注做一件事，适合稳定的环境。可是如果环境复杂多变，孩子最好就要有爱冒险的精神，能机警地意识到周围的变化。</p><p>&nbsp;</p><p>那难道说有什么环境就生产什么性格的孩子吗？不是。人类的策略是各种孩子始终都有、各种性格都保留，让他们自己去闯荡不同的环境。</p><p>&nbsp;</p><p>由此来说，因为未来环境不可预测，孩子将来幸福不幸福、成功不成功就不是你所能决定的 —— 得看他的特性跟他将来遇到的环境是否匹配。我们专栏第一季讲过“兰花和蒲公英”的概念，有的孩子像兰花特别挑环境，有的孩子像蒲公英走哪都能活。你决定不了你的孩子是什么，通常一家几个孩子都各有各的特点。</p><p><br></p><p>孩子的运气是孩子自己的事情，家长所能做的就是提供多方探索、体验不同环境的条件。我们爱孩子是无条件的，不论他是蒲公英还是兰花，安静还是外向，爱冒险还是胆小，我们都尽量提供探索资源。</p>', 'http://img.jssns.cn/SHILU/1/41646451642164937.png', 'http://img.jssns.cn/SHILU/1/a337e31d4e160c8631593d4f51c35141.jpg', null, 'album', 'ID515536127436783617', '131', '3', '3', '168', '2018-11-30 18:52:07', '168', '2019-01-31 23:02:43');
INSERT INTO `audio` VALUES ('ID518137315487383552', '孩子玩的时候在学什么？', 'https://www.jssns.cn/SHILU/1/fecaec26e3ce758509d44efa1bfdd64b.mp3', '<p><br></p><p>六岁以下儿童的主要任务不是学习而是玩。而我们中国家长对玩，情绪复杂。</p><p>&nbsp;</p><p>有些家长认为玩是不必要的，是意志力薄弱的表现，甚至可能还是一种堕落，正所谓“驰骋畋猎令人心发狂”。有些家长把玩设计成是一种休息或者奖励，比如有个说法叫“学习要认真地学习，玩要尽情地玩”，把玩当做充电和调节情绪的方法。</p><p>&nbsp;</p><p>这两种观点都是把孩子的玩和成年人旅游看电影打麻将唱卡拉OK那种玩给混淆了。孩子的玩，是必不可少的成长环节 —— <strong style=\"color: rgb(241, 27, 27);\">玩不但能促进学习，而且是最重要的学习方式。</strong></p><p>&nbsp;</p><p>可是话要这么说，似乎就有个矛盾。玩，肯定就没有什么目的，就不是“刻意”的，可是学习得刻意练习啊？如果说玩能让人变得更聪明，那让孩子直接刻意练习、去做一些数学题之类，直接锻炼大脑不是更好吗？孩子为什么非得玩呢？</p><p><br></p><p>孩子的玩一共有三种：<strong style=\"color: rgb(241, 27, 27);\">跟别的孩子玩、玩玩具、和假装。</strong></p><p>&nbsp;</p><p>这种玩法是人跟人玩，可以叫“打闹”。比如几个小孩在一起打闹、互相追逐嬉戏。</p><p>&nbsp;</p><p>打闹有点像打仗，孩子们就好像在演练各种攻防技术一样。打闹都是双方轮流进行，我打你一下，你也打我一下，大家都有演练机会。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">但打闹不是训练。打闹的好处在于学习社交互动。</strong></p><p>&nbsp;</p><p>不让孩子玩太残忍了，所以科学家都是拿老鼠做“剥夺玩的权利”实验。如果一只老鼠从来没和别的小老鼠玩过，它往往也会做各种技术动作 —— 但是一旦跟别的老鼠互动，它不知道做各种动作的时机是什么。它不知道什么时候该做什么。</p><p>&nbsp;</p><p>这就好比说步伐都会，但是不会跳舞；字都认识，但是不会连成一句话说。</p><p>&nbsp;</p><p>那么可想而知，如果一个小孩从小都没有跟别的孩子打闹过，他到了社交场合就会表现得很笨拙，他不知道怎么跟人互动。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">打闹，是一种社交演练。</strong></p><p><br></p><p>哲学家卡尔·波普尔有句话说，作为科学家，如果你看到有数据不符合你的理论，你应该对这样的数据特别感兴趣。我们讲过“信息就是意外”的道理，所谓探索，就是要寻找各种意外。</p><p><br></p><p>孩子玩玩具，也是在探索意外。</p><p>&nbsp;</p><p>有人观察，哪怕是11个月大的婴儿，都有这种探索精神。比如说看一个球打到墙上又弹回来，婴儿看多了就会觉得这没什么，关注度下降。但是如果他看见一个球居然能穿墙而过，他就会表现出强烈的兴趣。</p><p>&nbsp;</p><p>所以孩子都喜欢新奇的玩具，但这还不是最重要的。最重要的是孩子的玩法。他们会用各种方法折腾玩具，这么摆弄一下那么摆弄一下。特别是如果玩具的行为跟孩子设想的不一样，他会特别感兴趣，完全符合波普尔说的科学家标准。</p><p>&nbsp;</p><p>所以孩子哪里是在玩玩具，他们简直就是在做科学实验。当成年人都陷入确认偏误不能自拔，只关注符合自己认知的信息的时候，孩子们保留了科学探索的火种。高普尼克深有所感，专门写过一本书叫《宝宝也是哲学家》。</p><p>&nbsp;</p><p>但玩玩具还有实用的好处。探索有利于孩子掌握多方面的技能。</p><p>&nbsp;</p><p>哲学家以塞亚·伯林有一个著名的比方，叫“狐狸和刺猬”。刺猬只知道一件大事，狐狸知道很多事。有些学者只知道一个大主意就好像刺猬一样，而真正能理解复杂世界的其实是狐狸。</p><p>&nbsp;</p><p>类比到人生的选择，像有些运动员和表演艺术家从小苦练，把一生押注在一门手艺上，就是刺猬；而有的人灵活性特别强，就相当于狐狸。</p><p>&nbsp;</p><p>如果你想把孩子培养成狐狸，就得让他多玩玩具。事实上真实的狐狸跟刺猬的区别就是这样。刺猬出生六周后就离开父母，而狐狸要跟父母在一起生活六个月，而且还是被父母共同照顾。特别是母狐狸，经常把猎物带回家让小狐狸玩。</p><p>&nbsp;</p><p>那你说就算要培养狐狸，我多报几个兴趣班，效率不是更高吗？不行。玩跟上课最大的区别在于它是一种主动的探索，是亲自面对真正的意外。吹拉弹唱才艺学习，这些都是按照老师要求做事，这不是玩。我们关心的不是学会了多少技能，而是将来能不能应对新的环境。玩，是让孩子摸爬滚打一身伤痕换一份体会。</p><p>&nbsp;</p><p>跟其他孩子打闹和玩玩具这两项活动有一个最大的好处：促进大脑发育。脑神经科学家有个名词叫大脑的“可塑性”。大脑可塑性越高，你学习新东西就越容易。小孩的大脑可塑性非常高，但是很多人长大之后大脑就变得很不可塑了，就好像硬化了一样。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">孩子玩的时候，大脑前额叶中负责社交的区域会释放出一种化学物质，这种物质能让大脑变得更可塑。</strong></p><p>&nbsp;</p><p>还有一种玩法，对智力成长没有这些好处，但是可能对人更重要。</p><p>&nbsp;</p><p>很多动物都会打闹和玩玩具，但是只有人类的孩子会假装。</p><p>&nbsp;</p><p>最基本的假装就是角色扮演。以前有学者认为小孩分不清虚构和真实。的确，据我观察美国大部分七岁以下儿童认为圣诞老人和牙仙女是真的 —— 但是现在的研究者确信，对一般想象出来的东西，孩子能分辨那是假的。特别是当孩子假装的时候，他们非常明白这是假的，但是他们乐此不疲。</p><p><br></p><p>假装有两个重要作用。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">一个是想象不同的可能性。</strong>有个实验是这样的，先给孩子们玩一个带钥匙的音乐播放器。钥匙对了，它就能播放音乐，钥匙不对，它就播放不了。好，现在实验人员说，这个播放器必须得拿走了，这有个积木，我们能不能假装这个积木是播放器？</p><p>&nbsp;</p><p>然后他们就拿假装的钥匙开启了这个假装的播放器。当然没有音乐播放出来，但是孩子们能够假装现在有音乐，并且跟着音乐唱歌。</p><p><br></p><p>好，下一步，老师说我们换个钥匙，假装这个钥匙不好使 —— 于是孩子们又假装播放器无法播放音乐 —— 他们能够假装面对假装出来的沉默。</p><p>&nbsp;</p><p>所以说孩子的假装能力非常高级。但是实验中有三分之一的小孩，没有这个假装能力。你跟他说我们假装这东西正在播放音乐，他会说不对啊，它没有播放音乐啊。这一个实验，就把孩子分成了会假装和不会假装的两类。</p><p>&nbsp;</p><p>然后你做个测试，让孩子们设想一个事物的各种不同可能性，结果就会发现，会假装的孩子能想象出很多可能性来，而不会假装的孩子没有这种能力。</p><p>&nbsp;</p><p>而这是一种非常重要的高级能力。<strong style=\"color: rgb(241, 27, 27);\">想象不存在的东西，这是创造力的起源&nbsp;—— 按赫拉利的说法这可是智人的超能力！</strong>永远都是想法先行，敢想才能敢干。我们前面有一期叫《科学家的核心价值观》，科学发现就是这么来的。</p><p>&nbsp;</p><p>高普尼克还专门做了实验，让孩子多玩假装，能激发他们想象不同可能性的能力。</p><p>&nbsp;</p><p>但假装还有一个更重要的作用。</p><p>&nbsp;</p><p>假装的第二个作用，是让孩子学会理解别人的心理状态。而高普尼克认为，这个能力是包括大人在内所有人最值得学的技能。</p><p>&nbsp;</p><p>这个能力在学术上叫做“心智理论”，就是说你要知道别人的情绪是什么样，他有什么意图，他有什么欲望，他是真的还是假装，他的信仰是什么……你得会判断人的心理状态。</p><p>&nbsp;</p><p>我们举个例子。比如现在有个装创口贴的包装盒——</p><p>孩子们一看都认识。但是老师把盒子打开，一看里面装的不是创口贴，是曲别针。好，现在老师把盒子合上，问五岁的小孩两个问题 ——</p><p>第一，你知不知道这个盒子里装的是什么东西？</p><p>第二，你猜，别人会认为这个盒子里装的是什么东西？</p><p>&nbsp;</p><p>正确答案是我知道盒子里装的是曲别针，我认为别人会以为盒子里边装的是创口贴。能答对这两道题，就说明孩子具备推测别人想法的能力。自闭症儿童没有这个能力，所以面临巨大的社交困难。而研究表明，越是平时爱玩假装游戏的孩子，越能通过这个测试。</p><p><br></p><p>我们一生都在琢磨别人怎么想，但心智理论学习的最关键窗口期是从18个月到五岁这段时间。</p><p>&nbsp;</p><p>我们前面说了，六岁以下儿童最应该学的东西就是两个 —— 一个是世界上的东西都是怎么运行的，一个是人都是怎么回事儿。这第二个项目就是心智理论，是最重要的技能。说白了就是孩子得学会理解人，能善解人意就更好了 —— 而想要发展这种能力，最好的办法就是玩假装。</p>', 'http://img.jssns.cn/SHILU/1/40184503750528302.png', 'http://img.jssns.cn/SHILU/1/eea7c971289353e656dc87e5aff6ed91.jpg', null, 'album', 'ID515536127436783617', '142', '7', '4', '432228697144033280', '2018-11-30 18:52:42', '168', '2019-01-31 23:03:16');
INSERT INTO `audio` VALUES ('ID518137406327619584', '因为孩子爱玩', 'https://www.jssns.cn/SHILU/1/eaca1bde790c5b60bf5b2e41783fac98.mp3', '<p><br></p><p>高普尼克在书中提到，很多大人都已经忘记怎么玩了。我们想想，大人的多数玩法其实是娱乐。什么看电影、唱卡拉OK或者喝酒聊天之类，就算偶尔去游乐场坐个过山车，也不符合我们上一讲说的孩子的三种玩法的特点 —— <strong style=\"color: rgb(241, 27, 27);\">打闹、探索新事物和假装。</strong></p><p>&nbsp;</p><p>那么作为大人，首先要做到别破坏孩子玩，要支持。除了支持孩子玩之外，还有没有更积极的做法呢？是不是应该引导一下孩子的玩呢？</p><p>&nbsp;</p><p>高普尼克提到一个研究是这样的。有一个特别复杂的玩具，有各种功能。你挤压一个地方它能发出“滴”的一声；你再拉一下那个地方，它能播放一段音乐；别的还有能说话、有闪光的效果等等。</p><p>&nbsp;</p><p>第一组，有个实验者把这个玩具拿来给孩子们看，说她也不知道这个东西是怎么用的。她假装不经意地碰一下玩具，发出滴的一声，然后就把玩具留给孩子们，让他们自己玩。结果孩子们拿过来就积极探索玩具的各个方面，很快就把所有功能都找到了。</p><p>&nbsp;</p><p>第二组，实验者像个老师一样，郑重其事地告诉孩子们这个玩具会发出滴的一声，并且演示了这个功能。她也是把玩具交给孩子就走了。结果孩子们就反复模仿同样的动作去玩玩具，在很长时间内都没有发现其他功能。</p><p>&nbsp;</p><p>由此可见，所谓教学，其实是一把双刃剑。孩子非常敏感，如果你是在教他，他就不探索了，他就模仿你。</p><p><br></p><p>但是反过来说，如果你也做出一副探索的姿态，就能引导着孩子一起探索。</p><p><br></p><p>科学家认为最好的教学方式是老师应该只起到脚手架的作用，引导孩子自己搭建知识，而不是直接告诉孩子知识。</p><p>&nbsp;</p><p>当然这种引导法对家长、甚至对老师的要求都非常高。对一般家长来说可能不干预就是最简单的办法。</p><p>&nbsp;</p><p>总结来说，关于玩，家长能为孩子做的事大概有三点 ——</p><blockquote><span style=\"color: rgb(160, 160, 160);\">第一，提供一个安全稳定的环境。孩子在贫穷或者危险的环境都能玩，如果有一个安全稳定的环境，让孩子能放开了玩，他们会更加积极地探索。</span></blockquote><blockquote><span style=\"color: rgb(160, 160, 160);\">&nbsp;</span></blockquote><blockquote><span style=\"color: rgb(160, 160, 160);\">第二，提供玩具。玩具不一定非得多么高端复杂，一根小木棍也可以玩，关键是得有玩具可玩。</span></blockquote><blockquote><span style=\"color: rgb(160, 160, 160);\">&nbsp;</span></blockquote><blockquote><span style=\"color: rgb(160, 160, 160);\">第三，如果家长想参与，想引导孩子一起玩，也行 —— 但是你别忘了先戴上一顶侦探帽：你得能融入孩子的主流文化才行。</span></blockquote><p>&nbsp;</p><p>高普尼克经常和她的小孙子一起玩。有时候假装桌子底下有一只老虎正在睡觉，两人悄悄地从桌子旁边爬过去，说不要惊醒老虎……高普尼克说，关键还不在于家长的参与对孩子有什么好处，而是……家长也很想玩啊！</p><p><br></p><p>玩不是工作，像过家家之类的玩法好像是模拟日常的工作，但是动作会故意做得很夸张，一看那就是在玩。</p><p>&nbsp;</p><p>人们通常是在其他的基本需求得到满足之后，比如吃饱穿暖了，才想起来玩。</p><p>&nbsp;</p><p>玩好像有一些特定的形式，像小孩打闹，似乎一直在重复一些动作，但是在重复之中又总有变化。</p><p>&nbsp;</p><p>玩是自发和自愿的。在用老鼠做的实验中，小老鼠为了能玩，它甚至愿意去完成一些工作。</p><p>&nbsp;</p><p>不管是跟人玩、跟东西玩，还是跟想法玩 —— 也就是假装，我们都是在随机地、多变地尝试一些不同的动作和想法，然后总结这些动作和想法的后果是什么。你可以说玩是一种试错式的学习，能让我们快速获得反馈、积累经验，提高应对意外局面的能力。</p><p>&nbsp;</p><p>但是所有这些实用的理由，都比不上一个最重要的理由，那就是玩，很好玩。</p><p>&nbsp;</p><p>费曼有句名言，说“物理学就好像是性：是，它能给我们带来一些实用的结果，但是那不是我们为什么做它。”</p><p>&nbsp;</p><p>这当然是进化的设定。如果性行为仅仅是为了生孩子，人很可能就不会做这件事。从进化的角度来说，这一切的确都是为了生孩子；但是从人的角度，生孩子只是性的一个副产品。</p><p>&nbsp;</p><p>高普尼克说，玩也是一样。获得各种好处、促进大脑生长、学会各种技能都是副产品 —— 我们之所以玩就是因为进化给我们设定了爱玩。</p><p>&nbsp;</p><p>所以归根结底，为什么要让孩子玩？<strong style=\"color: rgb(241, 27, 27);\">因为孩子爱玩！他们有权拥有幸福的童年。</strong></p>', 'http://img.jssns.cn/SHILU/1/41646555434194229.png', 'http://img.jssns.cn/SHILU/1/7825ac21ff43cc77169ba3739fa81f82.jpg', null, 'album', 'ID515536127436783617', '125', '5', '5', '432228697144033280', '2018-11-30 18:53:04', '168', '2019-01-31 23:03:57');
INSERT INTO `audio` VALUES ('ID518137501840310272', '专注力的竞赛', 'https://www.jssns.cn/SHILU/1/48e9aab5fd872cf2a405b6c81f6f8b86.mp3', '<p>前面的音频主要讲了六岁以前幼儿的成长，今天的主题则是从六岁上学到青春期之前，孩子大脑发育和学习方式的变化。</p><p>&nbsp;</p><p>人人都知道上学重要，但是对儿童脑发育的知识，一般人了解的太少了。这可能也是因为这些知识才刚刚研究出来。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">你知道人的一生中，大脑最理智、最平静是什么时候吗？你肯定想不到，答案是八岁。</strong></p><p>&nbsp;</p><p>六岁以后，青春期以前，是一个非常特殊的时期。六岁以前儿童的大脑特点是混乱，而进入青春期之后，大脑会再次变得混乱，甚至疯狂。两者中间的这段时间，大脑非常平静。</p><p>&nbsp;</p><p>这段时间很适合学习。</p><p>&nbsp;</p><p>我们前面讲了，六岁以前幼儿的主要任务是探索，现在我们把这种学习模式称为“发现式学习”。通过模仿、听讲和玩，孩子们尽可能地探索周围的世界，不设限制。幼儿最需要学习的是这个世界上的东西都是怎样运行的，周围的人都在想什么。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">六岁以后，发现式学习仍然在继续，而且达到更高的水平。</strong></p><p>&nbsp;</p><p>比如说关于东西，儿童在这个时期不但知道体积和重量，而且有了“密度”的概念。而关于人，儿童的一个重要认知，是开始理解死亡。你要问四岁的小孩死亡是怎么回事，他可能以为人死了就是从一个地方去了另外一个地方。但是六岁以后的孩子就有一点知道死亡是什么了。</p><p>&nbsp;</p><p>他们开始理解一些复杂的情绪，比如为什么有时候人会又高兴又难过。如果不同的人告诉他一些矛盾的说法，他不会困惑，而是自己去做出判断。与此同时，玩，还是那么重要。</p><p>&nbsp;</p><p>但是这时候孩子有了一种全新的学习模式，高普尼克称之为“掌控式学习”。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">掌控式学习就是要熟练掌握专项技能。</strong>掌控式学习要求刻意练习，要练到不用想就能使出来、快速高效的自动化程度。汉字的读写、加减乘除的计算，都是掌控式学习。</p><p>&nbsp;</p><p>发现式学习是探索，掌控式学习是收获。这两种模式的次序很重要，因为这是大脑的成长机制所决定的。</p><p>&nbsp;</p><p>六岁以前的幼儿随时能被任何东西吸引注意力，他自己判断哪个有意思就学哪个。而六岁时的大脑前额叶皮质开始要求更大的控制权，它将逐步接管整个大脑的其他部分，这意味着注意力变得可控，小学生能够专注地学习某一个知识。</p><p>&nbsp;</p><p>六岁以前的大脑可塑性是最高的，六岁以后大脑就开始不容易改变了。幼儿大脑灵活多变，现在的大脑开始有效率了。高普尼克认为儿童大脑的创造力，从这一刻开始是下降了。</p><p>&nbsp;</p><p>从内部硬件角度，以前的很多神经连接现在消失了，就像是一棵树被修剪了一样。剩下的那些经常使用的神经连接会加强！</p><p><br></p><p>如果我们把神经连接想象成电线，现在有些重点线路的外面被包上了一层皮，就好像是电线外面的塑料皮 ——这层皮叫“髓鞘质”，有点像是香肠，是一节一节的。髓鞘质的作用也正像是电线的塑料皮一样，保护神经连接不漏电，能让信号更强更准确。</p><p>&nbsp;</p><p>如果你以前听说过刻意练习的理论，你会立即明白这意味着什么：这意味着技能的专业化。经常使用的神经连接被固化，这个技能如同像肌肉一样长在了你的大脑里。</p><p><br></p><p>幼儿的大脑看见街头牌匾上的字也许以为那是一幅画，能产生各种有趣的联想 —— 而固化的大脑看见字就只想到字的抽象信息。从实用角度看这当然是巨大的进步，识字已经自动化了 —— 但是在一位心情不好的哲学家看来，曾经纯真的双眼，现在戴上了一副标准化的有色眼镜！</p><p>&nbsp;</p><p>这个转变简直就相当于孙悟空前往南赡部洲学艺，亚当夏娃离开伊甸园。你欢呼也好伤感也好，该来的就这么来了。</p><p>&nbsp;</p><p>其实六岁已经不小了。以前孩子到了六岁就得干活，一般是跟着父母、或者出去找个师父当学徒。</p><p>&nbsp;</p><p>我们听德云社的八卦，知道学徒很不好干。一开始都是做杂活，慢慢磨练了性子才能给师父打个下手，一旦犯错师父非打即骂。可是从刻意练习的角度，打骂都应该叫反馈，犯错都应该叫试错，正所谓打是亲骂是爱，挨打多了就学会了。以前到九岁，孩子就已经是个有价值的劳动力了。</p><p>&nbsp;</p><p>当然现代教育体系不是这样的。学徒制的好处是手把手教你玩真的，是实实在在地学习一项专业技能，你完全知道你在干什么。可是当你让孩子背英文字母表的时候，他并不知道这是要干什么。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">现在的孩子只在文体项目上能体验一点学徒制的影子。</strong>你上场打球动作不对、弹琴弹错了，教练肯定会给反馈，特别是你会参加真正的比赛和表演。</p><p>&nbsp;</p><p>可是一般的科目，像数学、语文，就不是学徒制了。学写生字和背诵乘法口诀只是为了考试，老师并不带领学生从事帮人写信或者算账之类的谋生业务。</p><p>&nbsp;</p><p>高普尼克开了个脑洞。如果学棒球也像现在学生学数学语文这么学，你猜是一种什么样的情景？十二岁以前全都是棒球理论学习，考试考的是棒球的规则和历史文化。在这漫长的学习中你对棒球的术语、棒球界的名人事迹倒背如流，但是你从来没摸过真的棒球。到了中学你才开始有球训练，到了大学你才开始练配合……一直等到研究生二年级，你才第一次上场比赛。</p><p>&nbsp;</p><p>有这么训练棒球运动员的吗？可是我们现在训练科学家就是这个方法。过关斩将好不容易考上研究生才算当上了学徒，结果老板一看除了考试啥也不会。</p><p>&nbsp;</p><p>当然这其中也有很多无奈。今天的科学实在太难了，高中生进物理实验室也帮不了什么大忙。</p><p>&nbsp;</p><p>离开了学徒制，今天的孩子在课堂上学的很多东西是不自然的。孩子不知道为什么要学这些东西，他们在很长的时间里根本用不上这些知识。</p><p>&nbsp;</p><p>所以他们要想学得好，必须投入极大的专注力。</p><p>&nbsp;</p><p>本来六岁以后大脑的发育就是会变得更加专注，已经为学习专业技能做好了准备，搞一些要求专注力的活动没问题。但是现在学校对专注力的要求已经超过了自然水平，小学生要调用的专注力已经比大多数成年人在工作中的专注力还高。</p><p>&nbsp;</p><p>可孩子是多种多样的，有些小孩天生没有那么强的专注力。</p><p>&nbsp;</p><p>如果你的职业选择是猎人，那你根本不需要很强的专注力，你反而应该避免过分专注，得时刻对周围环境保持机警。但是学校教育可不培养猎人，学校要求孩子必须能把专注力放在老师讲的东西上。</p><p><br></p><p>你甚至可以说，现在的学校很大程度上是专注力的竞赛。哪个孩子专注力强，他学习成绩就好。</p><p>&nbsp;</p><p>结果猎人式的人才在学校里就成了落后分子，甚至成了病人！有研究表明美国政府把标准化考试推行到哪个地区，哪个地区的儿童多动症诊断率就显著提高。</p>', 'http://img.jssns.cn/SHILU/1/41646588268107559.png', 'http://img.jssns.cn/SHILU/1/9f20f38f45d81733c81e111a40753aba.jpg', null, 'album', 'ID515536127436783617', '114', '4', '6', '432228697144033280', '2018-11-30 18:53:26', '168', '2019-01-31 23:28:01');
INSERT INTO `audio` VALUES ('ID518417172242890752', '青春的较量', 'https://www.jssns.cn/SHILU/1/8ec51b2252dc739402a8b43c22c13f70.mp3', '<p>青春期的问题哪里都有，咱们每个人也都遇到过或者将来会遇到。</p><p>&nbsp;</p><p>一个被视为希望之星的天才少年，为什么在大学里突然沉迷网络游戏不学习了呢？一个系统学习过生理知识、平时特别文静的女高中生，为什么突然怀孕了？而且那个男生还不是她喜欢的类型？</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">青春期少年经常会犯一些愚蠢低级的错误。</strong>想要理解这一点，我们需要脑科学。</p><p>&nbsp;</p><p>中学老师经常感到很无奈，仿佛是突然之间，学生们对老师讲的内容都不感兴趣了。幼儿园的孩子对一切事物都充满好奇，小学生把老师的话当成金科玉律，可是到了青春期，好像课堂上的东西再新颖也无法吸引学生。他们不再迷信老师，对家长也是叛逆，他们的心思好像根本不在学业上。</p><p>&nbsp;</p><p>所以就有老师向高普尼克抱怨这个情况，说你不是脑科学专家吗，你说说为什么青春期少年对什么都不感兴趣呢？高普尼克说不是啊，你看他们对“谁喜欢谁”这个问题，感不感兴趣？老师说那倒是！这帮学生一天到晚就是研究同学的八卦。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">人到了青春期，大脑会发生一个重大改变。</strong>我们前面讲了幼儿大脑的可塑性非常高，所以灵活多变又充满了混乱。上学以后，从小学到青春期之前这段时间，孩子的大脑是非常平静的。可是到了青春期，大脑再次变得活跃，可塑性再次提高，混乱又回来了。所以青春期的大脑，有点像是幼儿的大脑。</p><p>&nbsp;</p><p>这种改变是在为离开家庭做准备。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">青春期之前的孩子，他的生活是以家长为核心，他最关心的是和家长的关系。青春期开始之后，他最在意的是和同伴之间的关系。</strong>自己在老师心目中是个什么位置，对他来说已经不重要了 —— 他更关心自己在同学中的位置，他想得到来自同学的尊敬。</p><p><br></p><p>幼儿时期的打闹，现在变成了复杂的社交演练。谁跟谁是朋友，谁跟谁是盟友，分工、谈判、妥协、利益分配、建立游戏规则，这些高级的东西都出来了。</p><p>&nbsp;</p><p>青春期少年有个地下文化。他们私下交流会说一些只有他们知道的词汇、只有他们懂的典故，他们关注的东西家长根本理解不了。你要不信可以尝试一下“快手”之类的东西，你可能无法理解为什么有人会对这种东西感兴趣。这个文化在一代又一代的少年之间传承，还不断地创新。青春期少年是否掌握这个文化，对于他的欢迎度十分重要。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">为了赢得地位，青春期少年会去做一些冒险的、匪夷所思的事情。</strong></p><p>&nbsp;</p><p>青春期少年其实也是在探索，但是他们这种探索和以前的探索不一样。以前都是在家长的庇护之下探索，做一些游戏性的操作。青春期少年的探索则是直接面对真实世界，他要追求独立。他打交道的对象都是同龄人，这是给即将到来的成人社交做演练。</p><p><br></p><p>活跃的内心遇到陌生的场景，青春少年难免会做出一些出格的行动。脑神经科学家提出了一个非常有意思的理论。</p><p>&nbsp;</p><p>科学家提出一个洞见。青春期少年之所以会去做一些不负责任、冒险的事情，并不是因为他低估了危险 —— 而是因为他高估了奖励。或者说，他对奖励的体验比成年人强烈得多！</p><p>&nbsp;</p><p>比如你想想，初恋的感觉是不是特别美好。一直到成年，每个人都觉得初恋特别美好，其实初恋可能并没有那么美好，只是那时候你是青春期，你对奖励的感觉特别强烈而已。</p><p>&nbsp;</p><p>我当年上的都是重点中学，同学都比较老实没什么人早恋，但踢足球给我带来的奖励感觉特别强烈。初中有一次我们班四比零赢了别的班，我作为守门员表现出色高接低挡做出几个值得慢动作重播的精彩扑救。同学夸赞不说，比赛结束后场边有几个不认识的人都向我致意，我好像成了球星的感觉。第二场比赛开始之前，对方的守门员居然专门跑过来跟我握手！结果后来我野心膨胀喜欢冒险出击丢了不该丢的球。</p><p>&nbsp;</p><p>从进化角度看动力系统完全合理。有这个系统的激励，你才愿意离开温暖的家庭环境，去面对社会上的风险。但是问题就在于，你需要控制这个动力才行，这就是咱们要说的第二个系统，也就是控制系统。</p><p>&nbsp;</p><p>控制系统由大脑的前额叶皮质主导。我们上一讲说了，随着大脑慢慢发育，前额叶皮质开始尝试接管大脑的其他部分，它能掌控感情，也控制动机。</p><p>&nbsp;</p><p>控制系统相当于刹车和方向盘，它克制冲动，引导我们做出科学的决策。它鼓励我们建立一个长期的目标，推迟享乐。同样也正是这个系统，主导了我们上一讲说的掌控式学习。</p><p>&nbsp;</p><p>但是控制系统的掌控能力并不是一下子就有的，而是慢慢成长出来的。它从青春期之前、刚刚上学的时候就已经存在，一直到成年以后都还在成长。</p><p>&nbsp;</p><p>所谓“谁的青春不迷茫”，就是动力系统和控制系统这两股力量的较量。</p><p><br></p><p>最理想的局面是两个系统达成平衡。本来也容易平衡，但近年来出现了一个情况，孩子们的青春期都在提前。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">为什么青春期会提前，目前还没有明确的结论。</strong>有人从能量角度，认为现在的孩子营养摄入过剩，而运动却不像以前那么多了，营养在体内没有被消耗掉，就被用于加快身体发育。还有人认为是环境中的各种激素太多了，甚至还有人说是各种人造光源对人的身体产生了影响……</p><p>&nbsp;</p><p>总而言之，青春扑面而来。动力系统已经变得活跃，控制系统却还没有准备好，结果就是青春期的少年更容易冲动冒险。要解决这个问题，就得提升控制系统。</p><p>&nbsp;</p><p>那要如何提升控制系统呢？难道是加强思想教育、依靠团支部书记的领导吗？当然不是。</p><p>&nbsp;</p><p>从脑科学角度来讲，青春期的动力系统是自然生长的，人到了一定年龄它就出来了 —— 但是控制系统并不仅仅是自然生长，而是可以训练的。</p><p>&nbsp;</p><p>控制系统高度依赖学习和经验。试错就是个好办法。如果你做出过一些错误的决定，吃亏了，你就会学会下一次如何做出正确的决定。在实践中吃一堑长一智，你就会慢慢变得成熟，这个成熟的过程就是你的控制系统成长的过程。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">所以试错宜早不宜迟。最好在青春期还没到来之前，在小学生这个阶段，家长就让孩子去做一些决策，和同学多互动。</strong>这时候还有一个好处是家长还有一定的权威，能给一点引导。</p>', 'http://img.jssns.cn/SHILU/1/40267345879304269.png', 'http://img.jssns.cn/SHILU/1/061a3ec25192af8c7f1fb812d99bd047.jpg', null, 'album', 'ID515536127436783617', '121', '2', '7', '168', '2018-12-01 13:24:45', '168', '2019-01-31 23:27:18');
INSERT INTO `audio` VALUES ('ID518417486404648960', '学习与思考（上篇）', 'https://www.jssns.cn/SHILU/1/de81b4869f6e03c096f6b4872a888aa0.mp3', '<p>艾莉森·高普尼克，儿童学习和发展研究领域的领导者，首位从儿童意识的角度深刻剖析哲学问题的心理学家。</p><p><br></p><p>心理理论创始人之一，第一位受邀在美国心理学会开设讲座的心理学家。曾在美国科学促进会、美国心理协会、美国哲学学会及诸多儿童福利机构发表儿童心理理论方面的演讲。</p><p><br></p><p>这本《宝宝也是哲学家》广受好评，被迪尼斯旗下BABBLE网站誉为“50本最佳育儿书籍”之一。</p><p><br></p><p>在书中，高普尼克教授用贝叶斯算法解释了婴儿对因果推理的娴熟。这也是令逸爸印象最为深刻的部分：我们成人大大低估了孩子的推理能力。</p><p><br></p><p>中国著名的物理学家李淼在书中的评价是这样的：我们一直认为成人的大脑是一个小宇宙，原来这个小宇宙在婴儿期就已经足够复杂了，可以完成很多我们难以想象的事，如假想、推理等，而且婴儿更换知识的速度远远高于成人。我毫无保留地推荐这本极具价值的书。</p><p><br></p><p>《纽约时报》这样写道：高普尼克解释了近几十年来科学研究对婴儿思维的讨论，为我们讲述了一个关于“我如何成为我”的精彩故事。</p><p>&nbsp;</p><p>在推序中，海银资本合伙创始人王煜全讽刺地写道：人类是一种可笑的动物，人人都经历过童年，而当我们长大之后，却对自己的童年逐渐忘却，甚至无法理解尚处于童年期的孩子们。</p><p><br></p><p>这句话深得我心。我在经历大量学习和观察后，产生了与这句话一样的感受。我发现，很多家长到处寻求育儿的方法，可是效果甚微，原因是他们无法理解孩子，没有能力看懂孩子。</p><p><br></p><p>我认为，《宝宝也是哲学家》就是一本能帮助家长看懂孩子的好书。</p><p>&nbsp;</p><p>那么，高普尼克是如何证明婴儿也有推理能力呢？尤其是那些还没有学会说话的婴儿。业内都称她是教育学家皮亚杰最为杰出的继承者。她和她的研究团队发现，孩子们总是对新奇的东西更兴趣，而感兴趣的方式就是更长时间地注视。于是，他们开创了测量孩子对一件事情的注视时间长短的方法。实验方法的改进，就如打开了婴儿心灵的小天窗。</p><p><br></p><p>我多次引用我国现代教育学开创者陈鹤琴的那句话：“游戏，是儿童的生命。”这句话，与高普尼克的观点有了交集。</p><p>&nbsp;&nbsp;</p><p>高普尼克认为，人类的童年期很长，成人给予的保护也很充分，显示了一种进化意义上的分工。她用了一个非常巧妙的比喻：儿童就像是人类的研发部门，一群空想的人通过头脑风暴产生各种奇想；而成人则像是生产与销售部门。他们来发现，我们来实施。可以说，“毛毛虫”和“蝴蝶”擅长的东西完全不一样。</p><p>&nbsp;&nbsp;&nbsp;</p><p><strong>那么，儿童具体如何研发呢？</strong></p><p>&nbsp;&nbsp;&nbsp;</p><p>是通过学习，全心全意地学习认识周围世界，并且想象世界还有可能是什么样子。</p><p>&nbsp;&nbsp;&nbsp;</p><p>认识世界，想象世界，都是通过大脑。谈起大脑，科学家都会向读者普及一些基本知识，高普尼克同样也这么做了。比如，人类大脑前额叶皮层，是负责思考、计划和控制等复杂能力的区域。婴幼儿的前额叶皮层非常的不成熟，因此理智不足，但想象力和学习力非常惊人。高普尼克指出，婴儿的大脑比成人大脑的联结程度更高，比成人有更多的神经通路。当儿童逐渐长大，获得更多经验，他们的大脑就会“剪除”那些薄弱的、不常用的神经通路，而强化经常使用的神经通路。</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/40267334547688166.png', 'http://img.jssns.cn/SHILU/1/3eeee51351a66ec280cff7361355731d.jpg', null, 'album', 'ID515536127436783619', '117', '0', '9', '168', '2018-12-01 13:26:00', '168', '2019-01-31 23:13:38');
INSERT INTO `audio` VALUES ('ID518417670446514176', '学习与思考（下篇）', 'https://www.jssns.cn/SHILU/1/63167bdec2bf3acbb35e1770db92b3a7.mp3', '<p>艾莉森·高普尼克，儿童学习和发展研究领域的领导者，首位从儿童意识的角度深刻剖析哲学问题的心理学家。</p><p><br></p><p>心理理论创始人之一，第一位受邀在美国心理学会开设讲座的心理学家。曾在美国科学促进会、美国心理协会、美国哲学学会及诸多儿童福利机构发表儿童心理理论方面的演讲。</p><p><br></p><p>这本《宝宝也是哲学家》广受好评，被迪尼斯旗下BABBLE网站誉为“50本最佳育儿书籍”之一。</p><p><br></p><p>在书中，高普尼克教授用贝叶斯算法解释了婴儿对因果推理的娴熟。这也是令逸爸印象最为深刻的部分：我们成人大大低估了孩子的推理能力。</p><p><br></p><p>中国著名的物理学家李淼在书中的评价是这样的：我们一直认为成人的大脑是一个小宇宙，原来这个小宇宙在婴儿期就已经足够复杂了，可以完成很多我们难以想象的事，如假想、推理等，而且婴儿更换知识的速度远远高于成人。我毫无保留地推荐这本极具价值的书。</p><p><br></p><p>《纽约时报》这样写道：高普尼克解释了近几十年来科学研究对婴儿思维的讨论，为我们讲述了一个关于“我如何成为我”的精彩故事。</p><p>&nbsp;</p><p>在推序中，海银资本合伙创始人王煜全讽刺地写道：人类是一种可笑的动物，人人都经历过童年，而当我们长大之后，却对自己的童年逐渐忘却，甚至无法理解尚处于童年期的孩子们。</p><p><br></p><p>这句话深得我心。我在经历大量学习和观察后，产生了与这句话一样的感受。我发现，很多家长到处寻求育儿的方法，可是效果甚微，原因是他们无法理解孩子，没有能力看懂孩子。</p><p><br></p><p>我认为，《宝宝也是哲学家》就是一本能帮助家长看懂孩子的好书。</p><p>&nbsp;</p><p>那么，高普尼克是如何证明婴儿也有推理能力呢？尤其是那些还没有学会说话的婴儿。业内都称她是教育学家皮亚杰最为杰出的继承者。她和她的研究团队发现，孩子们总是对新奇的东西更兴趣，而感兴趣的方式就是更长时间地注视。于是，他们开创了测量孩子对一件事情的注视时间长短的方法。实验方法的改进，就如打开了婴儿心灵的小天窗。</p><p><br></p><p>我多次引用我国现代教育学开创者陈鹤琴的那句话：“游戏，是儿童的生命。”这句话，与高普尼克的观点有了交集。</p><p>&nbsp;&nbsp;</p><p>高普尼克认为，人类的童年期很长，成人给予的保护也很充分，显示了一种进化意义上的分工。她用了一个非常巧妙的比喻：儿童就像是人类的研发部门，一群空想的人通过头脑风暴产生各种奇想；而成人则像是生产与销售部门。他们来发现，我们来实施。可以说，“毛毛虫”和“蝴蝶”擅长的东西完全不一样。</p><p>&nbsp;&nbsp;&nbsp;</p><p><strong>那么，儿童具体如何研发呢？</strong></p><p>&nbsp;&nbsp;&nbsp;</p><p>是通过学习，全心全意地学习认识周围世界，并且想象世界还有可能是什么样子。</p><p>&nbsp;&nbsp;&nbsp;</p><p>认识世界，想象世界，都是通过大脑。谈起大脑，科学家都会向读者普及一些基本知识，高普尼克同样也这么做了。比如，人类大脑前额叶皮层，是负责思考、计划和控制等复杂能力的区域。婴幼儿的前额叶皮层非常的不成熟，因此理智不足，但想象力和学习力非常惊人。高普尼克指出，婴儿的大脑比成人大脑的联结程度更高，比成人有更多的神经通路。当儿童逐渐长大，获得更多经验，他们的大脑就会“剪除”那些薄弱的、不常用的神经通路，而强化经常使用的神经通路。</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/40267322301521114.png', 'http://img.jssns.cn/SHILU/1/3eeee51351a66ec280cff7361355731d.jpg', null, 'album', 'ID515536127436783619', '112', '0', '10', '168', '2018-12-01 13:26:44', '168', '2019-01-31 23:13:58');
INSERT INTO `audio` VALUES ('ID518418068611792896', '孩子的人格养成', 'https://www.jssns.cn/SHILU/1/c509967c761789463becf29dfe714f89.mp3', '<p>父母对孩子的人格发展有长久影响吗？</p><p><br></p><p>本文在考察了相关证据后，得出的结论是：<strong>没有</strong>。</p><p><br></p><p><strong>一、“教养假设”是错的</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;我们平常听到很多育儿专家说，影响孩子发展的主要因素是家长的教养方式。哈里斯认为，这种观点是错的。你可能会觉得很吃惊。常识似乎在告诉我们，如果父母充满了爱心，孩子就会更有安全感，就会成长为更自信、更友善的孩子；如果父母多跟孩子说话，多陪孩子读书，孩子就会变得更聪明，在学校里就会更爱学习，学习成绩就会更好；如果父母对孩子要求更严格，孩子就会更少闯祸；如果父母对孩子诚实友善，孩子同样也会诚实友善——难道不是这样的吗？而且，我们身边确实有很多好的父母带出来了好的孩子，也有很多糟糕的父母，带出来了糟糕的孩子。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;哈里斯把<strong>“父母的教养影响到孩子的人格”</strong>这一观点称为<strong>“教养假设”</strong>，认为这是<strong>一个典型的混淆了相关关系和因果关系的观点。A和B之间有相关关系，并不一定意味着A决定了B。</strong>如果父母的教养和孩子人格养成是因果关系，那么反过来，怎么解释孩子影响到了父母的教养方式这种情况呢？有个笑话说，有人跟一个老师讲，要对她班上的一个问题儿童好一点，因为这个孩子的家庭是破裂的。这个老师说，我完全理解，哪个家庭摊上这样的孩子，都会破裂的。这个笑话有点刻薄，不过道理确实是这样的：<strong>父母对待不同的孩子，很可能会有不同的态度，父母和孩子之间的交流是双向的。</strong></p><p><br></p><p><strong>&nbsp;&nbsp;&nbsp;&nbsp;既然这二者不是因果关系，而是相关关系，那么对于“孩子的人格养成”有没有更重要的影响因素呢？&nbsp;有。</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;很可能是由于<strong>基因</strong>：如果父母的基因都是乐观的，那么孩子也遗传到了乐观的基因，因此，你看到父母和孩子都是乐观的。或者，也可能是由于<strong>外在环境</strong>：比如，这一家住在一个很开放、乐观的社区，社区里人人都很开放、乐观，这样的外部环境也影响到了这个家里的父母和孩子。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;让我们整理一下思路。<strong>影响子女成长的因素主要有两个，一个是先天的基因，第二个是后天的环境。</strong>父母对孩子有没有影响呢？当然会有影响，但是，<strong>父母对孩子最大、最明显的影响，是通过基因的遗传。</strong>基因的影响毋庸置疑，几乎是没有争议的，那么在后天的环境因素中，又可以分为家庭环境和家庭之外的环境，比如学校、社区等。那么，哪一种环境因素对孩子的影响更大呢？</p><p><br></p><p><strong>二、家庭环境vs家庭外环境</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;按照育儿专家的说法，家庭环境更重要。这是真的吗？我们可以通过<strong>对照实验</strong>来观察以下两个例子：</p><p><br></p><p><strong>1、移民家庭</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;美国是个移民国家，在很多移民家庭里，父母作为第一代移民，讲的英语是带口音的。但是，子女作为第二代移民，很小的时候就到了美国，他们往往能讲一口流利的英文。在移民家庭的例子中，有家庭因素，也有家庭之外的社会因素。如果家庭因素是更重要的，那么，孩子讲的英语应该更像父母讲的英语，也应该带着浓厚的口音，但事实却并非如此。<strong>在这个例子中，家庭之外的社会因素显然是更重要的</strong>。</p><p><br></p><p><strong>2、双胞胎</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;双胞胎一直是心理学家非常喜欢的研究题目。我们都知道，同卵双胞胎之间的性格非常相似，但是，即使是同卵双胞胎，也会多多少少存在一些性格之间的差异。有一些同卵双胞胎出生之后，一直跟着亲生父母长大，也有一些同卵双胞胎被不同的家庭领养。这就提供了一个很好的机会，可以让我们去观察在不同家庭养大的双胞胎和在同一个家庭养大的双胞胎，看看他们有什么不同。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;如果说家庭环境是很重要的，那么，在控制了基因的影响作用之后，我们应该看到，在同一个屋檐底下长大的同卵双胞胎性格相似之处，会大于在不同的领养家庭中长大的双胞胎。但事实并非如此。<strong>无论是在同一个屋檐下，还是在不同的领养家庭中长大，同卵双胞胎之间的性格差别不会有变化。</strong>换言之，决定他们性格差异的最显著原因是基因，而不是家庭环境。我们也经常看到，在同一个家庭中，如果有亲生的子女和领养的子女，这些孩子在成长的过程中会有一定的相似度。<strong>但长大成人之后，亲生子女和领养子女之间的性格相似度几乎为零。</strong>也就是说，家庭环境的影响彻底消失了。</p><p><br></p><p><strong>三、孩子的法则</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;那么家庭外的环境怎么影响孩子呢？哈里斯认为，一个小孩在家庭里面，也许会学到一些行为特质，比方说对着父母很听话很乖巧，但是也许一把他丢到学校，他会变得非常凶残，非常凶暴。为什么呢？因为到了学校，那是另一个截然不同的社会环境。也就是说，她认为<strong>人格在不同的处境底下会出现不同的面相，它不一定保证一个人在任何场合任何处境都有人格的一致性。</strong>这就说明了为什么我们看到很多人在家里面一副模样，在外面一副模样，这就是我们很多时候会诟病，说他这个人啊表里不一、内外不一，其实不是，而是一个正常的状态。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;比方说我们看意大利黑社会电影，你会注意到，里面那些黑手党儿子，哎呀回家一看到妈妈怕得不得了，非常孝顺，妈妈一说回来吃意大利面，统统回来吃。问他谁做的意大利面最好，妈妈。但是一出门口，看谁不顺眼，一枪就把他毙了。</p><p><br></p><p><br></p><p><strong>《教父》经典台词</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;为什么孩子在家里和在家庭之外的行为会有差异呢？因为，<strong>人在一种情境中学得的技能不一定可以直接应用在另外一个情境中。</strong>人是一种群居动物，人是要区分我们和他们的。一个群体要是想更加团结，就会对外排斥。<strong>在孩子们看来，我们大人是一群望而生畏、不讲道理的奇怪的物种。</strong>所以，你也就不难理解，为什么在孩子群里经常会发现挑战成人的小动作。在孩子群里，最酷的行为就是敢于挑战成人的权威。</p><p><br></p><p><strong>&nbsp;&nbsp;&nbsp;&nbsp;对孩子来讲，最重要的是如何融入同龄人，而不是学会成为一名成年人。</strong>父母在家里教的，只能用于家里。到了学校里，孩子还必须自己学会另外一套行为模式。当孩子模仿父母的行为时，他们并不是不分好坏，照单全收，他们是非常谨慎的。<strong>只有当他们父母的行为与社会上其他人的行为一致时，他们才会模仿父母。</strong></p><p><br></p><p><strong>&nbsp;&nbsp;&nbsp;&nbsp;孩子最大的愿望就是尽快成为集体中合格的一员。越是长大，他们对儿童群体的认同感和忠诚度就越强烈。</strong>父母看到孩子们慢慢和自己疏远，总会觉得心里难受，但是家长朋友请记住：<strong>孩子们的未来不取决于父母有多爱他们，而取决于他们与集体中其他成员能否和谐相处，尤其是和同辈人的相处，因为他们要和同辈人一起生活一辈子。</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;在孩童时期父母有选择孩子同辈的权利。环境和同伴对孩子的成长影响很大，所以我们说古时候的“孟母三迁”，今天的“学区房”的火爆，也是有道理的。但是，<strong>父母对孩子的影响会随着他们的年龄增长而缩小。</strong>对于小孩子，父母几乎能够控制他们交什么样的朋友。但是，等到他们到了十几岁的时候，进入青春期之后，你就不可能再控制这些孩子了。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;我们不要期待改变自己的孩子，孩子跟父母也是朋友的关系。父母不可能赐予孩子在社会上的自尊和地位。你不能指望通过给予孩子柔情蜜语，让他去抵挡外面世界的尖酸刻薄。认为自己是父母心肝小宝贝的学生，不一定在同龄人中有更高水平的自尊心，因为自尊是一个人在群体中地位的因变量。<strong>孩子有孩子自己的路，你不可能替孩子走他或她自己的路。</strong>焦虑的父母只能让孩子感到更加紧张。孩子的成长需要时间，你的生活也需要时间。</p><p><br></p><p><strong>&nbsp;&nbsp;&nbsp;&nbsp;孩子是父母家里暂住的小客人。总有一天，他们会离开我们。</strong>趁着他们还在，让我们珍惜在一起的时光。你会在睡前给小宝贝讲一个童话故事，那只是因为你想要体会这种互相依偎的美妙时光，跟他或她的性格成长、大脑发育，一点关系都没有。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;人生是一场冒险，要为一个孩子担起指导人生的责任更是风险巨大。所以哈里斯认为，<strong>所有的育儿理论，甚至是成人生活手册，其实都建立在假设的基础上，无法作为绝对遵循的金科玉律。</strong>至于运用本书的理论，为人父母者最可能需要做的，是<strong>让自己身处一个好的团体，为孩子选择一个好的团体</strong>。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;人生，以及由无数个世世代代的人生组成的社会，实在是复杂和麻烦，麻烦让我们总是希望找到一种理论去解释进而解脱，但复杂又让这成为不可能。最后还是得返璞归真，顺其自然。所以家长们，请你们莫焦虑，慢慢来。</p><p><br></p><p><strong>四、朱迪斯•哈里斯</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;最后给大家介绍一下作者朱迪斯•哈里斯。哈里斯是一个非常不平凡的人物。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;当看到她发表在核心期刊上的论文，康奈尔大学有一位教授给哈里斯写信，就问她：你是一个学者吗？还是一个临床医生？还是一个有撰写突破性学术论文爱好的失业的炼钢工人？</p><p>&nbsp;&nbsp;&nbsp;&nbsp;哈里斯回答说，如果要让她来选，她觉得自己更像失业的炼钢工人。哈里斯确实没有工作，她不是什么大学教授，她是一位全职母亲。她在37年前就被哈佛研究所退学，也完全没有做实验的环境，而且是个家庭主妇，副业是以她的学位和专业知识去写大学的入门教科书。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;为什么她没有办法好好上学或者继续她的学术生命呢？这是因为她患有一种严重的先天性疾病，只能在带孩子之余从出版社那里领了个活儿，撰写儿童心理学的教科书。我们知道，凡是帮这种学科写教科书的人，她必须要阅读很多很多基础文献，最新研究等等。在阅读这些东西的时候，她慢慢发现，她要写的这些教科书，原来在传递一些错误的观点。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;这些错误的观点她为什么说它是错误的呢？比如说教养，也就是父母会对子女造成影响这样的观念，她发现其实不符合大部分研究的实际数据，而且这些研究常常会自相矛盾。她于是在《教养的迷思》这部著作里，推翻学界盛行50年的理论，她认为<strong>孩子其实受到同伴的影响比在家庭中受到父母的影响更大。</strong></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;从《教养的迷思》这本书我们可以很明显地看出哈里斯的学术风格：<strong>虽然带着一个不完全严谨的腔调，但是又很细密地去搜寻各种她找得到的论文、材料、实验报告，找出里面的错处、找出里面矛盾的地方。</strong>因为她不能够亲身地做实验，所以就看人家的实验，在人家的实验里尽量找出有利的地方，建构自己的理论。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;她读了很多相关文献，带孩子又是一种亲身的实践。哈里斯对照着来看学术研究和自己的实践，发现理论和现实的差距很大。这才启发她写了那篇引起轰动的论文，这位家庭主妇的思辨能力真是让人佩服。</p>', 'http://img.jssns.cn/SHILU/1/40267300753211402.png', 'http://img.jssns.cn/SHILU/1/f09ace00751f33284b343d8b6eda84de.jpg', null, 'album', 'ID515536127436783620', '133', '5', '8', '168', '2018-12-01 13:28:19', '168', '2019-01-31 23:25:39');
INSERT INTO `audio` VALUES ('ID518424324789501952', '时间是人类的老大', 'https://www.jssns.cn/SHILU/1/ed3354f98c8deebdbd81edd1f761ac2b.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/e73bd584d17f2de606a2a4cf17710dbd-sz_217846.jpeg?x-oss-process=style/xmorient\"></p><p>“再过10分钟就要吃饭了！”</p><p>也就是说当秒针在时钟上转动十圈后，大家都必须上桌开始吃饭。因此，我们可以说，是这些时针决定了我们就餐的准确时间。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">没错，是时间在指挥着我们。</strong></p><p><br></p><p>当然，有时候我们肚子饿了，就会立马去桌子上吃饭，而不是等待10分钟。所以，这个时候，指挥我们就餐的是饥饿感而不是时间。</p><p>&nbsp;</p><p>面对每一件事情，我们都有两种选择：选择听任时间的指挥，或者完全不理会时间。</p><p><br></p><p>比如，晚上看书的时候，你可以说：“我想再读10分钟，之后我就去睡觉”；你也可以说：“等我读完了这个故事就去睡觉。”</p><p><br></p><p>但问题是，每个人一天只有24个小时，如果你不听时间的指挥，任由一件事发展，很可能一天结束了你一件事情都没有完成。所以，我们需要让时间指挥：</p><p><br></p><p>考试时，老师会说：“60分钟后交卷”，而不是：“写完后再交卷”。</p><p>过马路时，绿灯只给了我们30秒，而不是想什么时候过马路都可以。</p><p>写作业时，妈妈会说：“1小时后去睡觉”，而不是：“必须写完作业才能睡觉。”</p><p>&nbsp;</p><p>所以人类伟大的老板，伟大的头儿是时钟，是手表，是时间。</p><p>&nbsp;</p><p>时钟决定校门几点开，几时关；时钟决定课间休息什么时候开始，什么时候结束；时钟决定我们的父母几点该去上班；时钟决定动画片什么时候在电视上播出·····</p><p>&nbsp;</p><p>甚至，日常生活中，有一些节日，也常常是由流逝的时间来决定的：比如，当我们十周岁的时候，大人们会为我们组织一场盛大的生日晚会。因为从我们出生那天起到现在，已经过去了整整十年的时间。可当我们身高达到一米六的时候，我们既不会庆祝也没有人送给我们礼物；</p><p><br></p><p>类似的，由时间流逝来决定的纪念日还有，夫妻之间的结婚纪念日、公司成立10周年纪念日等等。另外，每年除夕，当时针和分针同时指向时钟的12点时，大家会燃放烟花，互相祝愿新年快乐。</p><p><br></p><p>这一切的一切，都是由时钟来决定，由日历来决定。因此，我们可以说，这一切的一切都是由时间来决定。</p>', 'http://img.jssns.cn/SHILU/1/40267287772951740.png', 'http://img.jssns.cn/SHILU/1/2512b80dd5b3fcd2a89784c682a0b096.jpg', null, 'album', 'ID515536344454266881', '112', '6', '4', '168', '2018-12-01 13:53:10', '168', '2019-01-26 10:21:10');
INSERT INTO `audio` VALUES ('ID518429063644184576', '请珍惜你的时间', 'https://www.jssns.cn/SHILU/1/42b0229ec3d158797e3bf921036db438.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/75cad833c442394395c8e122e809265b-sz_139627.jpeg?x-oss-process=style/xmorient\"></p><p>一列开出去的火车可以在半路上折回来；一张图画完成后，如果觉得不美，我们可以把它擦掉重画一辆；汽车可以改变行驶的方向；我们可以把毛衣反过来穿；我们也可以倒着走路。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">但是，我们却不能改变时间的方向。</strong></p><p>&nbsp;</p><p>过去的，就过去了。失去的时间不可能再找回来，谁也不可能回到过去，或者抹掉过去，或者毁掉过去。因此，珍惜时间是非常重要的。时间一去不复返。</p><p>&nbsp;</p><p>是啊，时间一去不复返，可我们的记忆却会一直停留在过去的某段时间里。它可以给你带来快乐和幸福，也可以给你带来后悔和内疚，就像下面的小故事一样：</p><p>&nbsp;</p><p>悦悦走进学校旁边的面包店，她身上的那点钱只够买一个巧克力面包。可食品架上的巧克力面包已经卖光了，于是老板娘去看看是否有刚烤出炉的。就这样，面包店里就只剩下悦悦一个人了。</p><p>&nbsp;</p><p>柜台上摆着悦悦喜欢的各种糖果和一些夹心榴莲饼干。悦悦想都没想就赶紧拿了三块儿装进了衣服口袋。过了一会儿，老板娘托着一盘热乎乎的巧克力面包回来，递给悦悦一个；悦悦接过面包并付了一个面包的钱。</p><p>&nbsp;</p><p>回到家，悦悦只对父母说了一声“我回来了”，连看都没敢看他们一眼，就将自己关进了房间。晚上，悦悦根本无法入睡，她全身发热，在床上不停地翻来覆去好几个小时。一想到上学时还要路过面包店，她就吓得发抖。她好像看见自己被关进一座监狱，觉得自己罪恶深重。要是自己从来就没有做过够这样的事，那该多好啊!</p><p>&nbsp;</p><p>但是，悦悦不可能让过去的时间重新开始，她不可能再回到推开面包店大门的那个时刻：要了一个巧克力面包，付完钱之后就马上离开，并且什么也没有偷。悦悦不可能再回到过去，抹掉以前做过的事情。所以，她将继续怀着罪恶感，并带着深深的内疚活下去。</p><p>&nbsp;</p><p>我们绝对不可能使时间倒流，我们将带着遗憾和内疚继续生活在时间的长河里。这就如同我们拖着一只沉重的箱子，它妨碍我们行动，妨碍我们走向自己想去的地方。</p><p>&nbsp;</p><p>珍惜自己的时间，就是为了避免在这只箱子里装入太重的东西，这一点尤其重要。因为，这只人生的箱子，我们既不能把它扔在路边，也不能将它忘记。<strong style=\"color: rgb(241, 27, 27);\">它就是我们的过去，它将陪伴我们度过一生。</strong></p>', 'http://img.jssns.cn/SHILU/1/40267271509569996.png', 'http://img.jssns.cn/SHILU/1/90957b45cfb2a04efbef4457e55c4dd8.jpg', null, 'album', 'ID515536344454266881', '102', '0', '11', '168', '2018-12-01 14:12:00', '168', '2019-01-26 10:12:43');
INSERT INTO `audio` VALUES ('ID518430406542884864', '热爱过去，拥抱梦想', 'https://www.jssns.cn/SHILU/1/0a1aa670d9b99c753a688930b3ab05cf.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/1722c70f9937f4875f2c289b64eed988-sz_297378.jpeg?x-oss-process=style/xmorient\"></p><p>上次聊天，我们提到了悦悦在面包店里投糖果的事情，悦悦到家后非常内疚，她非常渴望自己能活到过去，回到刚打开面包店门的那一刻。可时间永远无法重来，难道悦悦必须带着偷窃的罪恶感活一辈子吗？那简直太残忍了。</p><p><br></p><p>好在，任何事情总会有解决办法：终于，悦悦找到了一个解决问题的办法。第二天，她又去了面包店，把昨天发生的事情告诉了老板娘，然后用自己的零花钱偿还了那三块榴莲饼干的钱。走出面包店的时候，悦悦是那样的轻松，以至于从心底为自己骄傲，她战胜了心中的恐惧，而且还是独自一人！</p><p><br></p><p>你看！问题就这样完美的解决了，而且也没有用到时光机。悦悦并没有抹掉自己的过去，但是她改正了自己的行为，现在她可以心安理得地过日子了。当然，悦悦将永远不会欣赏自己偷盗糖果的那一时刻，但是她却非常得意自己有勇气去赔偿的那一时刻。</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">对我们真正有益的是建造一个我们喜爱的过去！</strong></p><p>&nbsp;</p><p>现在，让我们将思绪往前看，有过去，就会有未来。未来一定会到来，这是毋庸置疑的，就像下一个春节，下一个生日和下一个暑假。</p><p>&nbsp;</p><p>所有这一切都会来到。我们已经在想像各种聚会，将要来到的朋友，将要品尝到的美味以及将要团聚在一起的家人······我们也设想着自己将会非常愉快和高兴地迎接将要到来的一切。所以，我们都渴望着未来。</p><p>&nbsp;</p><p>然而，为了使我们的生日晚会获得成功，毕竟需要一些组织和安排：列一张准备邀请的朋友的名单，写请柬，邮寄请柬，买饮料和糖果，制作蛋糕，准备游戏和音乐，收拾装饰房间。</p><p>&nbsp;</p><p>很显然，假如直到生日的那一天，我们只是梦想，什么也没有准备的话，生日来临的时候，我们将一无所：没有客人，没有礼物，没有游戏，什么也没有。这不是一个生日。这个生日的梦想并没有变为现实。为了将它变成现实，就必须有所准备。</p><p>&nbsp;</p><p>假如小智只是躺在地板上梦想着自己在城市的上空展翅飞翔，而没有任何行动，当未来降临的时候，他将一无所有。但是，如果在梦想之后，小智立刻行动起来，寻找遥控滑翔运动学校的地址，打电话询问是否还可以注册，核实培训开始的时间是否与放假的时间一致，打听培训的价格，和父亲一起商量讨论。这样，他未来的梦想才可能变为现实。</p><p>&nbsp;</p><p>梦想，使我们对未来充满了渴望。但是这远远不够。只有梦想，就如同给一部汽车加满了汽油，却从来没有踩动油门让汽车向前飞跑！</p><p>&nbsp;</p><p><strong style=\"color: rgb(241, 27, 27);\">利用时间去梦想，就是在我们的生命中添加了动力。</strong>然而只有在时间中行动，在时间中将梦想变为现实，梦想才能推动我们的生命勇往直前。</p>', 'http://img.jssns.cn/SHILU/1/40267254447830689.png', 'http://img.jssns.cn/SHILU/1/5fa45f7118575e1b27540dbbc70f2089.jpg', null, 'album', 'ID515536344454266881', '103', '1', '12', '168', '2018-12-01 14:17:20', '168', '2019-01-26 10:25:14');
INSERT INTO `audio` VALUES ('ID518449187038167040', '幸福的像花儿一样', 'https://www.jssns.cn/SHILU/1/966ed2c8293bf49ed870c1ed6326b973.mp3', '<p>幸福像花儿一样</p><p><br></p><p>&nbsp;</p><p>小松鼠有许多秘密的洞。</p><p><br></p><p>他有一个很棒的洞，那里收藏着他最好的松果和榛子。</p><p><br></p><p>他有一个更棒的洞，那里收藏着他自己晾晒干的蘑菇。</p><p><br></p><p>他有一个最棒的洞，那里收藏着许多他自己画的图画。这些图画全都很漂亮，而且绝对神秘，因为他从没有让任何人看过。</p><p><br></p><p>他还有一个超级棒的洞，在那里他秘密驯养了一条全世界最小的龙。这条全世界最小的龙，也是全世界最乖、最害羞的龙，它只有一只蜻蜓那么大。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/2a21dc084abb1fbd49d3d2225ff596e1-sz_135337.jpg?x-oss-process=image/resize,w_1080/auto-orient,1/crop,x_0,y_3,w_878,h_927\"></p><p><br></p><p>小鼹鼠有许多秘密地道。</p><p><br></p><p>他有一条很棒的地道，通向一块野土豆田。那里生长着全世界最美味的野土豆。</p><p><br></p><p>他有一条更棒的地道，通向一个玫瑰花园。他认识那里的每一朵玫瑰花。</p><p><br></p><p>他有一条最棒的地道，通向一个秘密的小湖。小湖很神奇，在里面洗个澡，就可以忘记所有不开心的事。</p><p><br></p><p>他还有一条超级棒的地道，通向写童话的麦先生的大书房。麦先生常常在书房里大声朗读新写的童话。</p><p><br></p><p>有一天，小鼹鼠突发奇想，决定挖一条新的地道，而且是闭着眼睛挖。</p><p><br></p><p>“也许我的新地道会把我带到一个神奇的地方呢。”小鼹鼠想。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/cad59aa3d4658e4ca1f4b7f3620b1e3f-sz_21974.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>结果，小鼹鼠的新地道通到了小松鼠驯养龙的洞里。</p><p>那条全世界最乖、最害羞的龙，看到小鼹鼠害怕地尖叫起来，无论小鼹鼠怎么哄他安慰他都没有用。他就那么一直叫一直叫，直到小松鼠匆匆赶来才停止。小松鼠非常生气，因为小鼹鼠偷看了他最重大的秘密。</p><p>小鼹鼠觉得非常抱歉，为了让小松鼠感觉好受一点，他带他看了自己那条超级棒的地道，就是通向麦先生书房的那一条。</p><p><br></p><p>碰巧麦先生正在朗读一个特别有趣的童话，小松鼠一下子被吸引住了，把生气的事忘得干干净净。</p><p><br></p><p>就这样，小松鼠和小鼹鼠分享了彼此最重大的秘密。</p><p>既然连最重大的秘密都分享了，他们索性把那些小一点的秘密也全都互相分享了。</p><p><br></p><p>后来，当小松鼠和小鼹鼠手拉手从小松鼠最后一个秘洞钻出来时，他们看到繁星已经布满了天空。</p><p><br></p><p>于是他们在星空下发誓，互相保守秘密，并且——</p><p>做全世界最好的朋友!</p>', 'http://img.jssns.cn/SHILU/1/40267163749036751.png', 'http://img.jssns.cn/SHILU/1/7b89c057409ea342071ef7f22891fc50.jpg', null, 'album', 'ID558303512723718144', '113', '7', '9', '168', '2018-12-01 15:31:58', '168', '2019-01-28 09:26:47');
INSERT INTO `audio` VALUES ('ID518449521076731904', '会唱歌的小火车', 'https://www.jssns.cn/SHILU/1/74ff46462ea31beed22b9dd73477bfaf.mp3', '<p>会唱歌的小火车</p><p><br></p><p>&nbsp;</p><p>嘟嘟可喜欢坐小火车了，每次到游乐场，他都要坐上好几圈。</p><p><br></p><p>看！老爷爷一按电钮，小火车就唱着歌跑了起来，火车头上的旗子迎风飘着，站在车厢上的米老鼠招着手，嘟嘟可开心了。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/8a24aed1bb66f0986cb4458d81f5a93b-sz_2913635.png?x-oss-process=style/xmhigh\"></p><p><br></p><p>“要是幼儿园也有小火车就好了”嘟嘟想。可是，幼儿园里只有滑梯，转椅和秋千，没有会唱歌的小火车。</p><p><br></p><p>“这可怎么办呢？”嘟嘟抓了抓脑袋。突然，他看到了小椅子，有了主意。“等小朋友们都站起来的时候，我就把小椅子摆成小火车玩。”</p><p><br></p><p>老师让大家出去活动了，嘟嘟一个人悄悄地躲在了教室里。等小朋友们都走完了，他就开始忙了起来。</p><p><br></p><p>嘟嘟把小椅子一个一个搬出来，又把它们翻过来排起了队。哎呀！小椅子排起来好长啊，真像一列小火车。“我的小火车，我的小火车。”嘟嘟高兴极了，他坐在最前面的的椅子上，手扶着椅子背，嘴里喊着：“轰隆隆，轰隆隆，开火车了。”</p><p><br></p><p>小朋友们进来了，它们看着小火车，也高兴极了，每个人都挑了一个位子坐在了上面。“轰隆隆，轰隆隆，开火车了”大家都喊了起来。</p><p><br></p><p>“我的火车开的最快。”嘟嘟喊着喊着，摇起了椅子背。小椅子“咣当咣当”响了起来。“哎呀，真好玩，我的火车也会唱歌了。”嘟嘟使劲地摇呀摇，越摇越开心。小椅子晃得越来越厉害，唱的歌也越来越响。</p><p><br></p><p>哎呀！不好。要翻车了！嘟嘟的小椅子猛地向前一翻，他的脑袋一下子碰到了前面的柜子上，碰出了一个好大的包。</p><p><br></p><p>“哎呦！”嘟嘟捂着脑袋大哭起来。“这是什么火车啊，真是破火车。”这时候，小朋友们都围在了嘟嘟身边，有的帮他擦眼泪，有的用手轻轻的摸他头上的大包。老师也走了过来，为嘟嘟涂药。</p><p><br></p><p>“嘟嘟，你用小椅子摆火车，是个好主意，可是开的时候不能晃来晃去的。这样开不稳，也容易受伤，小椅子也会被摇坏的。”“恩。”嘟嘟点点头。“我再也不摇小椅子了。”</p><p><br></p><p>“现在，我给每个小朋友发一个小铃鼓，大家拿着它来开火车，好不好啊？”老师问大家。“太好了。”大家高兴极了。</p><p><br></p><p>小朋友们拿着小铃鼓，又坐在了小火车上。现在，小火车又唱起了新的歌，“哗啦啦，哗啦啦，我的火车要开啦！”</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/1c6b75fe71f8ea00737ce542de02eccb-sz_1839546.png\"></p>', 'http://img.jssns.cn/SHILU/1/40267054270740404.png', 'http://img.jssns.cn/SHILU/1/f60c8657744318f5f9da1623f3596be3.jpg', null, 'album', 'ID558303512723718144', '111', '5', '12', '168', '2018-12-01 15:33:18', '168', '2019-01-28 09:31:06');
INSERT INTO `audio` VALUES ('ID518450921814884352', '泥巴地的纽扣', 'https://www.jssns.cn/SHILU/1/3b8b4405ef122b077bd1396e03ce4204.mp3', '<p>泥巴地的纽扣</p><p><br></p><p><br></p><p>泥巴地喜欢躺着看天空。白天，天喜欢穿蓝绸缎衣裳，上面的云朵纽扣天天变花样；晚上，天喜欢穿黑袍子，上面的星星纽扣排列得很别致。泥巴地穿着一件土灰色的衣服，心想：“要是有几粒纽扣，这衣裳也不错啊！”</p><p><br></p><p>一只小花鸭跑来。“你能给我几粒纽扣吗？”泥巴地请求她。</p><p><br></p><p>“好吧！”小花鸭跳进一个水塘，湿了湿脚掌，在泥巴地的衣裳上一脚一脚踩出一粒粒枫叶般的纽扣。“</p><p>太谢谢你了！”这下，泥巴地觉得自己的衣裳好好看。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/81a493e343a35b47964c47552d2a6b65-sz_354353.jpg?x-oss-process=image/resize,w_1080/auto-orient,1/crop,x_23,y_8,w_971,h_926\"></p><p>冬天来了，雪花开始给大家送棉衣。泥巴地也披上了雪白的棉袄：“棉袄怎么没纽扣？”泥巴地有一点遗憾。</p><p><br></p><p>远远地，小花狗跑来了，他一蹦又一跳，给泥巴地的棉袄缀上一颗颗梅花般的纽扣。“多好的纽扣！”泥巴地摸了又摸，开心极了。</p><p><br></p><p>“哎哟！”风婆婆被泥巴地的纽扣一碰，装草籽的口袋破了，黑黑的草籽儿撒满了雪棉袄。“谢谢风婆婆！”泥巴地嚷嚷起来，“我也有星星般的纽扣啦！”</p><p><br></p><p>天渐渐暖了，太阳脱去了泥巴地的白棉袄。呵，风婆婆的草籽儿给泥巴地织出一件绿绿的草毛衣。“绿绿的细草毛衣挺漂亮，”泥巴地想，“可是又没有纽扣。”她抬头看到一旁的小树，也穿了绿绿的新衣裳，但还有蹦跳的小鸟纽扣在唱歌呢。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/0b6478e7acd028b424a5cb07169059d6-sz_3140383.jpg?x-oss-process=style/xmhigh\"></p><p><br></p><p>这时，一群群花蝴蝶飞来，她们好喜欢泥巴地的绿毛衣，开始在毛衣上玩耍，这儿停一对，那儿停一对。“蝴蝶纽扣！”小树哗啦啦地叫喊，“泥巴地，你的蝴蝶纽扣太好看啦！”泥巴地瞧瞧绿毛衣上飞舞的花蝴蝶，哎，真比最好看的花纽扣还美丽呢，真是太神气啦！</p>', 'http://img.jssns.cn/SHILU/1/40265196078173600.png', 'http://img.jssns.cn/SHILU/1/235c0c4a888a2050db3e5f20145e0a43.jpg', null, 'album', 'ID558316668967714816', '109', '6', '5', '168', '2018-12-01 15:38:52', '168', '2019-01-28 10:52:01');
INSERT INTO `audio` VALUES ('ID519446741330690048', '第二季【开篇】什么是批判性思维？', 'http://img.jssns.cn/SHILU/1/a5d7ead7b88d9c259924314bab207306.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/a13ef4bdabe44ab5550f49e44ff24711-sz_166492.jpeg?x-oss-process=style/xmorient\"></p><p>小朋友们，你们好，我是给你们说成语故事的婷婷老师，你们有想我吗？哈哈，今天呢，我们成语故事第二季就要正式开始了~这一季的主题是“批判性思维”。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">什么是批判性思维呢？</strong></p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">简单的说就是透过现象看本质。</strong>当其他人都认为一件事情是对的时候，你需要问问自己“这个真的是对的吗？”“它为什么是对的？”“在什么样的情况下它是错的？”</p><p>&nbsp;</p><p>你也许会被这个高大上的名字所吓倒，认为这些都是大人才能学会的思维方式。但婷婷老师想告诉你的是，当你对一件大家习以为常的事情提出质疑时，你就已经开始发挥你的批判性思维了。</p><p>&nbsp;</p><p>掌握批判性思维的基础是承认自己的无知，时髦点说就是“stay&nbsp;hungry&nbsp;saty&nbsp;foolish”，这是你自己的事情，任何人都不能帮助你。但我们能做到的是，给你一些反常识、反常理的全新角度，帮助你更全面的理解一件事，最后发展出自己的批判性思维。</p><p>&nbsp;</p><p>这一季，我会给大家带来20个反常识的趣味成语故事，让你们看到习以为常事物的全新一面，最后帮助你们成为一个具有批判性思维的孩子~！</p>', 'http://img.jssns.cn/SHILU/1/41013090302202876.png', 'http://img.jssns.cn/SHILU/1/ee229ee3742e28e6cf3e9ab63fe50c03.png', null, 'album', 'ID515539237269929986', '110', '4', '0', '168', '2018-12-04 09:35:53', '432228697144033280', '2019-03-20 17:15:58');
INSERT INTO `audio` VALUES ('ID519448959479971840', '【孔融让梨】只是为了能吃到最大的梨子', 'http://img.jssns.cn/SHILU/1/4b84b25ecd50e24e9498b4b6e6101ab0.mp3', '<h2><strong>孔融让梨</strong></h2><p><br></p><p>东汉鲁国，有个名叫孔融的孩子，十分聪明，也非常懂事。一天，父亲买了一些梨子，他特地拣了一个最大的梨子给孔融，孔融摇摇头并拣了一个最小的梨子说：“我年纪最小，应该吃小的梨，你这个大的梨子就给哥哥吧。”</p><p><br></p><p>父亲听后十分惊喜，继续问“你不是还有个弟弟呢,他不是比你还要小吗？”孔融说：“我比弟弟大，孔融我是哥哥，我应该把大的留给弟弟吃。”你看，讲得多好啊。父亲听了，好孩哈哈大笑：“好孩子，真是一个好孩子。”</p><p><br></p><p>故事说完了，你一定不陌生。每当父母或老师希望你们可以学会谦让，学会尊老爱幼的时候都会说出这个成语典故，仿佛这就是个道德标杆。</p><p><br></p><p>但小朋友们，你知道吗？<strong style=\"color: rgb(241, 27, 27);\">孔融让梨这个故事只讲了一半，它的另一半才是最能引发我们思考的。</strong>孔融的哥哥们看到孔融这么懂礼貌后非常惭愧，于是纷纷把最大的梨子让给孔融，他们自己则选择了小的梨子。也就是说，孔融不仅仅获得了父母的赞美，还获得了最大的梨子。</p><p><br></p><p>而他的哥哥呢？不仅被人认为不懂礼貌，也没有吃到最大的梨子。因此，我们可以说孔融让梨这个行为完全是损人利己的自私行为。</p><p><br></p><p>小朋友，我们来玩个穿越游戏，假如你现在是孔融的哥哥，此时，孔融拿了盘子里最小的一个苹果然后把盘子推到你面前说：“哥哥，你个子大，吃个大的梨子”。你接下来有两种选择：第一种，你可以说“弟弟真懂事，谢谢弟弟”，然后拿起最大的梨子。但这样做的后果是，你的爸爸妈妈会认为你太自私，连小弟弟的食物都抢；</p><p><br></p><p>第二种，把大的梨子让给弟弟，并说“弟弟啊，哥哥不喜欢吃梨子，吃小的就够了，大的给你”，可即使你这样做了你的父母还是会夸奖你的弟弟，毕竟他才是主动谦让的那个。</p><p><br></p><p>由此可见，孔融很可能是为了让自己能100%吃到梨子从而故意这么做的，当然这都不是最重要的。你有没有好奇过，中国几千年历史，让梨的孩子一定非常多，可为何单单只有孔融这个人出名了？答案就在于孔融的姓氏！<strong style=\"color: rgb(241, 27, 27);\">孔融是孔子的后代</strong>，所以他一出生就要意味着他必须有所成就，这是他注定的事！如何有所成就？最好的方法就是当官。</p><p><br></p><p>汉代还没有过科举制度，那个时候选举用察举制度，察举制度中可以举孝廉，也就是说你可以通过孝顺来当官。问题来了，你怎么像别人证明你很孝顺呢？答案就是“作秀”。比如说，如果父亲去世了，正常他的儿子要守孝一年，以表对父亲的孝心，但是如果他的儿子为他守了十年孝，他就会被别人传送为孝子，然后就会被举孝廉，就可以做官了。</p><p><br></p><p>因此，在这样的察举制度中，孔融让梨这件事很可能是为了以后的当官铺路。你也许不信，但接下来发生的几件事会让你大跌眼镜！</p><p><br></p><p>第一件事发生在孔融十岁那年，当时名士李膺举办聚会，孔融在没有受邀的情况下跑了过去，李膺看见孔融就问孔融你是谁家的孩子呀？我并没有邀请你吧？孔融回答说：“我们两家是世交呀，我的祖先孔子和你的祖先老子，可是有师徒之情啊！”当他说完这句话之后，在座各位无不称赞孔融的机智！</p><p><br></p><p>第二件事发生在孔融父亲去世时，孔融竟然伤心欲绝到无法站立！而且为何人们只记住了他无法站立这件事，对他守孝多少年却没有任何记载呢？</p><p><br></p><p>第三件事发生在孔融十六岁那年，他遇到了哥哥孔褒的朋友张俭，张俭是一名犯人，官兵都在追捕他，然而孔融趁哥哥不在家的时候，偷偷让张俭躲在了自己家中。不久，官兵在他的家中捉住了张俭，朝廷将此事怪罪下来，孔融争着要去承担所有的罪责。可问题是，为何被皇帝治罪的人是孔融的哥哥孔褒呢？</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">这几件事情做完之后，孔融当仁不让的坐上了超级名士的位子，被众人敬仰，拥有着巨大影响力！</strong></p><p><br></p><p>好了，婷婷老师提醒各位小朋友，我说的也不一定是对的，我只是提供一个理解孔融让梨这件事的全新角度给你，希望你能拥有自己的观点。</p>', 'http://img.jssns.cn/SHILU/1/41018899865720903.png', 'http://img.jssns.cn/SHILU/1/4c2f4dcdd405cb9c013206a33b379b58.jpg', null, 'album', 'ID515539237269929986', '109', '2', '6', '168', '2018-12-04 09:44:42', '168', '2019-01-31 18:14:06');
INSERT INTO `audio` VALUES ('ID519450551428055040', '【指鹿为马】你看到的只是你想看到的', 'http://img.jssns.cn/SHILU/1/5ca94660109640887fe3d2321504aaae.mp3', '<h2><strong>指鹿为马</strong></h2><p><br></p><p>公元前210年，秦始皇死后，赵高和李斯专政，他们为保住自己权势，假传“圣旨”，令本应继承皇位的秦始皇大儿子扶苏自杀身亡。之后，他们扶持秦王的次子胡亥即位成了秦二世。</p><p><br></p><p>赵高顺理成章的成为了秦国宰相。“一人之下，万人之上”的赵高仍不满足，日夜盘算着要篡夺皇位。可是，朝中大臣有多少人能听从他，有多少人反对他，他心中没底。于是，他想了一个办法，准备试一试自己的威信，同时也可以摸清敢于反对他的人有多少，都有谁。</p><p><br></p><p>一天上朝时，赵高让人牵来一只鹿，满脸堆笑地对秦二世说：“陛下，我献给您一匹好马。”秦二世一看，心想：这哪里是马，这分明是一只鹿嘛!便笑着对赵高说：“丞相搞错了，这里一只鹿，你怎么说是马呢?”赵高面不改色心不跳地说：“请陛下看清楚，这的确是一匹千里马。”</p><p><br></p><p>秦二世又看了看那只鹿，将信将疑地说：“马的头上怎么会长角呢?”赵高一转身，用手指着众大臣，大声说：“陛下如果不信我的话，可以问问众位大臣。”</p><p><br></p><p>大臣们都被赵高的一派胡言搞得不知所措，私下里嘀咕：这个赵高搞什么名堂?是鹿是马这不是明摆着吗!当看到赵高脸上露出阴险的笑容，两只眼睛骨碌碌轮流地盯着每个人的时候，大臣们忽然明白了他的用意。</p><p><br></p><p>一些胆小又有正义感的人都低下头，不敢说话，因为说假话，对不起自己的良心，说真话又怕日后被赵高陷害。有些正直的人，坚持认为是鹿而不是马。还有一些平时就紧跟赵高的奸佞之人立刻表示拥护赵高的说法，大言不惭地对皇上说：“这的确是一匹千里马！”</p><p><br></p><p>结果，赵高通过各种手段把那些不顺从自己的，说真话的正直大臣纷纷治罪，甚至满门抄斩。</p><p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/2bc4e3bfe2ef60a58b977a5a65e65513-sz_20766.jpeg?x-oss-process=style/xmorient\"></p><p><strong style=\"color: rgb(241, 27, 27);\">所以，我们常用指鹿为马这个成语比喻故意颠倒黑白，混淆是非。</strong></p><p><br></p><p>比如，小明偷橡皮被老师发现，但他却一口咬定自己没有偷橡皮，是借来的。这时候我们可以说小明的行为是指鹿为马。</p><p><br></p><p>我们分析上面的故事，可以发现，赵高指鹿为马策略之所以能成功，主要是因为他权力极大，一人之上万人之下，没有人敢和他作对。因此，我们可以说，当一个人拥有很大的权利时，他也可能会犯指鹿为马的错误，因为他听不到任何反对的声音。</p><p><br></p><p>在如今的社会中，为了保住自己的工作，即使领导指鹿为马，员工们也只能应声附和。这也是很多大型企业当遇到互联网、人工智能等颠覆性技术时被淘汰的原因。这些领导虽然总是开会讨论问题，但他们听到的都是那些自己想要听到的内容，他们开会讨论也只是为了证明自己的明智，而不是去研究事情真的是如此吗？</p><p><br></p><p>同样，如果你是个很强势的人，在和同学交流的过程中，为了获胜总是和同学争的面红耳赤。那么你也很难从同学那里听到真心话，他们大都会因为害怕你而不敢说出你真正的问题。所以，小朋友们，如果你希望获得别人真实的反馈，来帮助自己不断地成长，就要在与他人交往的过程中，开放你的心态，认真倾听对方说的话。</p><p><br></p><p>最后，为了不让自己犯指鹿为马的错误，我们需要相信科学而不是“盲信权威”。自古以来，我们总是喜欢听信那些所谓的专家，仿佛他们说的话就是真理，容不得半点质疑。在课堂里，老师往往是权威，当老师在黑板上写错字的时候，你的第一反应是立马提出老师的错误呢？还是先质疑自己，怀疑自己是不是写错了？</p><p><br></p><p>如果这个世界上有什么值得我们盲目相信，那非科学莫属。因为科学是一群有激情的天才，利用观察、实验、计算这一流程反复实验得出的结论，并且它经过了人们几十年甚至上百年的实践验证。<strong style=\"color: rgb(241, 27, 27);\">相信科学，掌握科学思维，可以让我们越来越明智！</strong></p>', 'http://img.jssns.cn/SHILU/1/41018917140775220.png', 'http://img.jssns.cn/SHILU/1/095e2001affec2672118729d3cdeff25.jpg', null, 'album', 'ID515539237269929986', '109', '2', '5', '168', '2018-12-04 09:51:02', '168', '2019-01-31 18:14:55');
INSERT INTO `audio` VALUES ('ID519454529536655360', '【自相矛盾】光靠逻辑是说服不了别人的', 'http://img.jssns.cn/SHILU/1/9e41530f05d96a5b0f71b9f717fa11c5.mp3', '<h2><strong>自相矛盾</strong></h2><p><br></p><p>这个成语中的矛盾指的是古代的两种兵器：矛和盾。如果你玩过英雄联盟的话，你一定知道里面一个叫作战争之王·潘森的英雄，他左手拿的就是矛，右手拿的就是盾牌。矛和盾的作用完全不一样，矛的作用进攻，而盾的作用是防守。因此，当有人拿矛攻击我们的时候，我们可以用&nbsp;盾保护自己。</p><p><br></p><p>试想一下，如果别人拿的是世界上最尖锐的矛，你手上拿着的是最坚硬的盾牌，你们俩PK一下到底谁会赢呢？这个问题在几千年前就被人提出过了。</p><p><br></p><p>2000年前，楚国有一个卖兵器的人，到集市上去卖矛和盾。为了吸引人们的眼球，他举起了他的盾，向大家夸口说：<strong>“我的盾，是世界上最最坚固的，无论怎样锋利尖锐的东西也不能刺穿它~”</strong></p><p><br></p><p>接着，这个卖兵器的人又拿起一支矛，继续夸口道：<strong>“我的矛，是世界上最尖利的，无论怎样牢固坚实的东西也挡不住它一戳，只要一碰上，嘿嘿，马上就会被它刺穿！”&nbsp;</strong></p><p><br></p><p>他十分得意，便又大声吆喝起来：“快来看呀，快来买呀，世界上最最坚固的盾和最最锋利的矛!”</p><p><br></p><p>这时，一个小孩走到了这个商人面前，微笑着说：“叔叔，如果用这矛去戳这个盾，会怎样呢?” “这，这，。。。”商人一时间不知道该说什么。那群围观的人先都一楞，突然爆发出一阵大笑，便都散了。</p><p><br></p><p>没办法，谎言被戳穿了，那个卖兵器的人，灰溜溜地扛着矛和盾走了。</p><p><br></p><p>因此，我们常用自相矛盾比喻语言、行动前后不一致或互相抵触。</p><p><br></p><p>故事说到这里，你觉得这个故事是真的呢？还是假的呢？</p><p><br></p><p>要想知道一件事情的真伪，我们就要学习揭穿自相矛盾之人的那个小孩，找到事情逻辑上的漏洞。</p><p><br></p><p>这个成语故事发生在楚国，楚国存在于公元前770年－公元前221年的春秋战国时期，<strong style=\"color: rgb(241, 27, 27);\">这个时期的金属非常昂贵。</strong>昂贵的原因有两个：一个是当时的炼铁技术刚刚被掌握，还不能高效的生产出大量金属品；二是当时全国处于战争状态，绝大部分的金属都被用于制作战士用的武器。</p><p><br></p><p>所以，平常百姓根本消费不起金属制品，更别说买把武器了。因此，我们可以说，把极为昂贵的矛和盾拿到平民老百姓生活的大街上卖根本不现实，显然这个故事是虚构的。</p><p><br></p><p>那么你可能会想，为什么这个故事会流传下来呢？我认为虽然没有这个故事，但这个故事可能确实是从楚国传来的。要知道，楚国人爱说大话可是全世界出名的，在秦始皇嬴政统一六国前，楚国人就对外宣传，“秦国不足为据，只要我们楚国有三亩地，就有机会灭掉秦国。”</p><p><br></p><p>由此可见，这个成语故事很可能是楚国人为了炫耀自己制造兵器的技术而编造的。</p><p>&nbsp;</p><p>不过，自相矛盾在某些地方会是一个做事的好方法，比如当我们想要营销和宣传某件东西的时候。</p><p>&nbsp;</p><p>我们玩个思维游戏，你现在回到了古代，变成了这个卖武器的商人。你拿着矛和盾来到了人声鼎沸的集市，集市上的商人非常多，卖什么的都有，卖兵器的也不少。你是新来的，没人认识你，你卖的武器也没有多大的特色。为了把东西卖出去你能想到哪些方法呢？显然，把自己的卖的武器形容成世界上最好的，是一个不错的方法。那个楚国商人也恰恰是这样吸引到一群围观群众的。</p><p><br></p><p>但如果你卖的东西名不副实就会变成欺骗，被别人抛弃。相反，如果你能提供非常好的产品，是你用心做出来的好产品，那么通过自相矛盾式的夸张宣传把产品吆喝出去是个非常不错的思路，让别人先试用你的产品，之后再通过你优质的内容吸引到别人。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">小朋友们，你们要记住，在这个信息爆炸，物质极为丰富的时代，酒香也怕巷子深哦~</strong></p>', 'http://img.jssns.cn/SHILU/1/41018933408999010.png', 'http://img.jssns.cn/SHILU/1/7c0c3ca8bdf62ccf81b9d028eb6a48e0.jpg', null, 'album', 'ID515539237269929986', '113', '2', '4', '168', '2018-12-04 10:06:50', '168', '2019-01-31 18:09:07');
INSERT INTO `audio` VALUES ('ID520176596611497984', '【塞翁失马】论“机会成本”', 'http://img.jssns.cn/SHILU/1/7f03ce439f6d0f284c7f7ab46bc0d0c1.mp3', '<h2><strong>塞翁失马</strong></h2><p><br></p><p><br></p><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：小羊，你怎么哭的这么伤心啊？</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：呜~~我最爱的小狗跑丢了，我找了好久都找不到~</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：别太难过了，塞翁失马焉知非福呢？</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：塞翁失马？原来我不是最惨的，他丢了一匹马啊，那他得有多难过啊。这怎么能叫作福气呢？</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：别急，听完这个故事你就明白啦。</span></blockquote><p><br></p><p><br></p><p><span class=\"ql-size-large\">战国时期有一位老人，名叫塞翁，他养了许多马。一天，马群中忽然有一匹走失了。邻居们听到这事，都来安慰他，让他不必太着急，年龄大了，多注意身体。塞翁见有人劝慰，笑笑说：“丢了一匹马损失不大，没准还会带来福气呢”。</span></p><p><br></p><p><span class=\"ql-size-large\">邻居听了塞翁的话，心里觉得好笑。马丢了，明明是件坏事，他却认为也许是好事，显然是自我安慰，强颜欢笑而已。可是过了没几天，丢掉的马不仅自己跑回来了，还带回了一匹骏马。</span></p><p><br></p><p><span class=\"ql-size-large\">邻居听说马回来了，非常佩服塞翁的远见，向塞翁道贺说：“还是您老有远见，马不仅没有丢，还带回一匹好马，真是福气呀”。</span></p><p><br></p><p><span class=\"ql-size-large\">&nbsp;</span></p><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：那。。。那你是说我丢掉的狗过几天就能回来，而且会再带一条小狗回来？</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：恩，有这个可能。不过，即使它带了一条狗回来，你也别太高兴，我的故事可还没说完呢~</span></blockquote><p><br></p><p><span class=\"ql-size-large\">&nbsp;</span></p><p><span class=\"ql-size-large\">塞翁听了邻人的祝贺，反到一点高兴的样子都没有，忧虑地说：“白白得了一匹好马，不一定是什么福气，也许惹出什么麻烦来。”</span></p><p><br></p><p><span class=\"ql-size-large\">邻居们以为他故作姿态纯属老年人的狡猾。心里明明高兴，有意不说出来。</span></p><p><br></p><p><span class=\"ql-size-large\">可没过多久，果然麻烦来了：塞翁有个独生子，非常喜欢骑马。他发现带回来的那匹好马后就经常骑着它出游。</span></p><p><br></p><p><span class=\"ql-size-large\">一天，他高兴得有些过火，打马飞奔，一不小心，从马背上跌下来，摔断了腿。</span></p><p><br></p><p><br></p><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：天哪~那么惨！那我不要它再带一个小狗回来了，我只要它自己回来就好了。</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：恩？先别急，难道你忘了我之前和你说的“塞翁失马焉知非福吗？”，我们继续来听故事。</span></blockquote><p><br></p><p><br></p><p><span class=\"ql-size-large\">听闻塞翁的儿子摔断腿后，邻居们纷纷前来慰问。塞翁说：“没什么，虽然腿摔断了但性命却保住了，或许是福气呢。”邻居们觉得他在胡言乱语，因为他们想不出，摔断腿会带来什么福气。</span></p><p><br></p><p><br></p><p><span class=\"ql-size-large\">不久，匈奴兵大举入侵，所有青年人都必须应征入伍，上场杀敌。塞翁的儿子因为摔断了腿，不能去当兵。而这次战争中，几乎所有的青年人都战死了，唯有塞翁的儿子保全了性命。</span></p><p><br></p><p><br></p><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：天哪~那些上战场的青年人好可惜，塞翁的儿子好幸运。</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">悦悦：是的，“塞翁失马”这个成语就是告诉我们凡事没有绝对，任何事情都有好的一面和坏的一面。所以，小羊，别难过了，一切都会好起来的。</span></blockquote><blockquote><span class=\"ql-size-large\" style=\"color: rgb(102, 163, 224);\">小羊：嗯嗯，谢谢你~</span></blockquote><p><br></p><p><br></p><p><span class=\"ql-size-large\">好了， 故事到这里就说完了。我相信很多小朋友会非常赞同这个说法，毕竟当你们的玩具丢了后，父母往往会买个更好更新的玩具给你们。但你们应该也遇到过这样的情况，当父母给你买了更好更新的玩具后，突然又有新的玩具出来了，你想买，可是父母不同意，因为他们才刚刚给你买过玩具。</span></p><p><br></p><p><br></p><p><span class=\"ql-size-large\">你看，是不是很多事情并没有你想的那么好呢？实际上，在经济学上有个很贴切的词语来描述这个现象。</span><strong class=\"ql-size-large\" style=\"color: rgb(240, 102, 102);\">“机会成本”</strong><span class=\"ql-size-large\">，机会成本指为了得到某种东西而所要放弃另一些东西的最大价值。</span><strong class=\"ql-size-large\" style=\"color: rgb(240, 102, 102);\">简单地说，机会成本就是你选择一件事情的同时会放弃另一件事情。</strong><span class=\"ql-size-large\">就像你前面说的那样，你让父母买了恐龙玩具，这意味着你放弃了购买植物大战僵尸玩具的机会。</span></p><p><br></p><p><span class=\"ql-size-large\">在“塞翁失马”的故事里，来了一匹新马后，塞翁的儿子选择骑着它游玩，这就意味着他暂时把安全放在了身后，他获得了飞驰的快感但失去了安全的保障。</span></p><p><br></p><p><span class=\"ql-size-large\">所以，任何选择都是有成本的，都是要付出的，一些看似好的选择不一定会有好的结果，一些看似不好的选择也不一定会有差的结果。最重要的是我们看待选择的心态~</span></p><p><br></p><p><span class=\"ql-size-large\">好了，今天的成语故事新说就到这里，我们“三顾茅庐”再见~</span></p>', 'http://img.jssns.cn/SHILU/1/40669355507189275.png', 'http://img.jssns.cn/SHILU/1/a590cc8464d595fc6d0627a5482f4415.jpg', null, 'album', 'ID515539237269929986', '109', '4', '3', '168', '2018-12-06 09:56:05', '168', '2019-01-31 18:08:02');
INSERT INTO `audio` VALUES ('ID520180836125900800', '雪娃娃的眼泪', 'http://img.jssns.cn/SHILU/1/c4a54cb655fb00cc419c0412c2b5cf5d.mp3', '<p>雪娃娃的眼泪</p><p><br></p><p>&nbsp;</p><p>雪娃娃住在雪屋子里。雪屋子非常舒适，冬天冷，夏天也冷。</p><p><br></p><p>雪娃娃外婆的外婆说过，只有一辈子都呆在雪屋子里，我们才能长成真正的雪人。因此，雪娃娃的外婆和妈妈从来没有走出过雪屋子。</p><p><br></p><p>妈妈说：“雪娃娃，你也不要走出雪屋子哟。”</p><p><br></p><p>“只有这样，你才能长成真正的小雪人呢。”外婆认真地说。</p><p><br></p><p>可是，雪娃娃想走出去试一试，才能知道是否要一辈子待在雪屋子里。于是，雪娃娃悄悄地走出了她的雪屋子。</p><p><br></p><p>雪屋子外面好美呀!有五颜六色的树，有各种各样的花，还有会跳舞的蝴蝶和唱歌跑调的大头蟋蟀，雪娃娃很喜欢它们。不过，她最喜欢的还是照在自己身上的阳光。</p><p><br></p><p>“多么美好的阳光呀，好像一匹又柔软又滑的绸缎呢。”雪娃娃让它们尽情地裹在自己的身上，“嗯，这种感觉真好!”突然，雪娃娃觉得身上有点儿暖，有点儿滑。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/5af47ae123376dd9684a769a5c102cf6-sz_2592609.jpg?x-oss-process=style/xmhigh\"></p><p><br></p><p>这时，一群小孩跑过来。他们拉着雪娃娃的手。邀请她一起唱歌、跳舞、玩游戏。于是，雪娃娃跟着孩子们一起玩耍，可开心了!雪娃娃还从来没有这么快乐过呢。</p><p><br></p><p>可是，雪娃娃觉得自己的眼睛开始流泪了。</p><p><br></p><p>雪娃娃的眼泪不停地流呀流，一滴、两滴、三滴、四滴……她的眼泪掉在地上，都快汇成一条小河了。</p><p><br></p><p>“雪娃娃哭了，她一定是不开心，这可怎么办呢?”孩子们急坏了，他们纷纷跑回了家。不一会儿，小弟弟回来了，他拿来了巧克力味的冰激凌；小姐姐回来了，她拿来了草莓派的冰葫芦；小妹妹也回来了，她端来了一大碗菠萝片冰沙……</p><p><br></p><p>“雪娃娃，这是我们最喜欢吃的东西，快吃吧!”孩子们齐声说。</p><p><br></p><p>雪娃娃流着眼泪吃了冰激凌，吃了冰葫芦，吃了菠萝片冰沙，刚一吃完，她就不再流眼泪了。这时，阳光一点一点地暗了下来。小树叶闭上了它的长眼睛，小花朵低下了它的红脸颊，小蝴蝶也不再跳舞了，大头蟋蟀吧嗒着嘴巴，正一步一步向它的大房子走去。孩子们挥着小手向雪娃娃道别。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/1e4abba9ff4dc7f65785eec6cb88a5e0-sz_1253327.png\"></p><p>“雪娃娃，明天你还出来玩吗?”</p><p><br></p><p>“嗯，出来。”雪娃娃高兴地说。</p><p><br></p><p>雪娃娃又回到了她的雪屋子。</p><p><br></p><p>“咦，雪娃娃，你看起来更结实了。”妈妈惊讶地说。</p><p>“是啊，雪娃娃更像一个真正的雪人了。”外婆说。</p><p><br></p><p>雪娃娃咯咯地笑了起来。原来，外婆的外婆说的话不一定都对呀。</p>', 'http://img.jssns.cn/SHILU/1/41386701861939168.png', 'http://img.jssns.cn/SHILU/1/8c37894d1c0362d2134a8a0aa278b4ac.jpg', null, 'album', 'ID558316172307595264', '127', '8', '2', '168', '2018-12-06 10:12:55', '168', '2019-01-28 10:05:02');
INSERT INTO `audio` VALUES ('ID520184891380334592', '牙虫的自述', 'http://img.jssns.cn/SHILU/1/7991b36228a235ed5aec804e26182dfb.mp3', '<p>牙虫的自述</p><p><br></p><p><br></p><p>我是一只小小的牙虫，自从瑶瑶上次晚上吃完糖不刷牙之后 ，我和爸爸妈妈就在瑶瑶的口腔里安居乐业了。</p><p>现在的小朋友刷牙都刷不干净，我们就一次又一次的躲过了“灭顶之灾”，但有次家庭聚会时，老乡告诉我们：现在到处都在除牙虫，好多小朋友都去医院补了牙，我有个亲戚就死去了，你们还是赶快逃到牲畜的牙齿里吧！这样说不定还能过上幸福的生活呢！</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/3e82b6fac87e64b5565b3202b40562ef-sz_17009.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>可是我们家亲戚告诉我们的时候已经晚了，第二天，瑶瑶就被妈妈带去了医院，在爸爸妈妈的保护下，我还是顽强地活了下来，可是爸爸妈妈却为了我而没有活下来。</p><p><br></p><p>当天晚上，我就背上自己的行囊，趁瑶瑶打喷嚏的时候，飞进了一个正要去农村的妇女的口中，经过几个小时的颠簸，我终于到了小猪的嘴里，虽然我已经找到了一个安全的地方，但那场灾难仍然令我记忆由新，每当回想起爸爸妈妈保护我的样子，我总会不住的流下了眼泪，我要奉劝天底下所有的小朋友：</p><p><br></p><p>1、养成早晚刷牙、饭后漱口的习惯。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/87f9f68933185e85f9f315abb61887ce-sz_64123.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>2、睡觉前千万不要吃糖，如果吃了就要仔仔细细地把牙齿刷干净</p><p><br></p><p>3、要定期去医院检查一下。只要你做到以下几点，我相信你也不会喊牙疼，我也不会为失去家人的事而伤心。希望在我们的共同努力下，我们能相处得很好！（友情提醒：千万别和我交朋友哦！）</p>', 'http://img.jssns.cn/SHILU/1/41386675608221408.png', 'http://img.jssns.cn/SHILU/1/330dfe22b90dd92297ceff81a3b954f3.jpg', null, 'album', 'ID558313010574131200', '111', '8', '10', '168', '2018-12-06 10:29:02', '168', '2019-01-28 09:28:56');
INSERT INTO `audio` VALUES ('ID521698898528436224', '儿童早期教育（上篇）', 'http://img.jssns.cn/SHILU/1/6759201b73cfb64a2d1510b2b7e5c2ba.mp3', '<p>孩子是天才还是俗物，与先天遗传关系不大，主要看后天的生长环境和接受了什么样的教育。</p><p><br></p><p><strong>第一章　教育的奥秘：庸才与骄子</strong></p><p><br></p><p><strong>教育是人类最宏伟的工程</strong></p><p><br></p><p>不管做什么事，尤其是一些环环相扣的事情，有一个良好的开端是非常重要的。一个良好的开端是整件事情能否顺利解决的基础，对事情的后续发展起到至关重要的作用。”</p><p><br></p><p>从社会发展历史来看，不论是由于道德或宗教，还是由于经济等原因而引起的争斗与矛盾，探究其产生的深层次的根源，无一不是因为人们对欲望的贪婪与无休止的追求。</p><p><br></p><p>不同的民族教育便产生了不同的民族文化。一个国家最基本的教育与该国的社会特征与上层建筑有密切的联系。国家的整体面貌则是该国教育的一个体现。</p><p><br></p><p>孩子就像黏土，而父母就像做陶器的人。</p><p><br></p><p>谁来掌握着孩子呢？显然，是孩子的父母、家庭，还有就是在小时候照顾他们并给他们深刻影响的人。</p><p><br></p><p><strong>早教是孩子成长的关键</strong></p><p><br></p><p>现在的教育模式，无论是在家里还是在学校，孩子们都被灌输各种美好的预言和故事。我们的目的是让孩子知道世界是多么美好，可是，这是真实的世界吗？我们难道不应该让孩子知道世界的真面目吗？</p><p><br></p><p>我们不应该让孩子一直生活在这些美好的谎言之中，这样会损害孩子的心灵。我们应该给予他们一定的视角，让他们真正了解社会的现状，这样他们才能正确看待社会，才有可能明辨是非。</p><p><br></p><p><strong>帮孩子避开不利的成长环境</strong></p><p><br></p><p><strong>达尔文思想对教育的影响</strong></p><p><br></p><p>叔本华曾经说过：“当我们可以走进或者代替另一个人的时候，会发现原来他的生活这么恐怖。或者假如你非常乐观，无论是面对战争还是监狱，甚至是刑场，你都不会抱怨，并且乐观面对。但是，当你被送到更加恐怖和黑暗的地方时，你会发现你无法继续乐观了，这一切真的让你无法接受。”</p><p><br></p><p><strong>请让孩子认识真实的世界</strong></p><p><br></p><p><strong>第二章　什么是真正的教育</strong></p><p><br></p><p>孩子的优秀源自双亲</p><p><br></p><p>真正的教育不应存有商业元素</p><p><br></p><p>一位思想家这样说过：“如果你是一个心智清醒的人，你会不断地更新自己的知识。同时，会不断开阔自己的视野，完善自己的思维能力。”这位思想家就是约翰·穆勒。</p><p>穆勒曾经这样说过，教育是造就伟大思想的前提，能让人们从内心热爱和追求真理，从而培养出一大批优秀的人才。</p><p><br></p><p>真正的教育就是给孩子自由</p><p><br></p><p>教育应该是手工制作，而不是批量生产</p><p><br></p><p>首先，我们需要培养孩子的品行，让孩子成为一个善良的人。其次，我们要给予孩子自由，并让其成长为对社会有用之人。</p><p><br></p><p>教育理念是需要不断改变的</p><p><br></p><p>教育不可忽视创新精神</p><p><br></p><p>帮助孩子找到真实的自我，完善自己的创新意识</p><p><br></p><p><strong>第三章　教育应该从什么时候开始</strong></p><p><br></p><p>何时才是幼儿教育的绝佳时间</p><p><br></p><p>对孩子进行早期教育的最佳时期，我认为是在孩子2岁到3岁之间。</p><p><br></p><p>幼儿时期的教育影响孩子一生</p><p><br></p><p>潜能开发不应晚于1岁</p><p><br></p><p>尽早开发孩子的语言潜能</p><p><br></p><p>建构孩子的精神世界</p><p><br></p><p>关注孩子的内心伤痛</p><p><br></p><p><strong>第四章　如何培养孩子的优秀品质</strong></p><p><br></p><p>教育孩子要诚实守信</p><p><br></p><p>培养孩子谦虚、礼让的品质</p><p><br></p><p>注重孩子的爱心教育</p><p><br></p><p>从小养成孩子的节俭品质</p><p><br></p><p>让孩子专注做事与学习</p><p><br></p><p>培养孩子的毅力和恒心</p><p><br></p><p>让孩子学会与人分享</p><p><br></p><p><strong>第五章　儿童教育应把握的重点和难点</strong></p><p><br></p><p>正确对待孩子的早熟问题</p><p><br></p><p>关于思想颇奇儿童的教育</p><p><br></p><p>避免孩子过于崭露锋芒</p><p><br></p><p>孩子的成长离不开生活的磨炼</p><p><br></p><p>帮助孩子解除“完美”情结</p><p><br></p><p>应当重视对孩子的心理教育</p><p><br></p><p><strong>第六章　教育要顺应孩子的天性</strong></p><p><br></p><p>孩子的成长需要自由</p><p><br></p><p>及时帮助孩子解决疑惑</p><p><br></p><p>随时给孩子讲解各种知识</p><p><br></p><p>允许孩子有自己的想法</p><p><br></p><p>重视孩子的全面发展</p><p><br></p><p>让孩子乐观勇敢地接受挑战</p><p><br></p><p>让孩子乐于学习和创新</p><p><br></p><p><strong>第七章　给孩子注入正能量</strong></p><p><br></p><p>给孩子快乐的学习空间</p><p><br></p><p>给孩子创造好的生活环境</p><p><br></p><p>要让孩子树立自信</p><p><br></p><p>在孩子迷茫时给予指导</p><p><br></p><p>永远不要打击孩子的信心</p><p><br></p><p>不要用父母的权威打压孩子</p><p><br></p><p>父母做错了，也要向孩子道歉</p><p><br></p><p><strong>第八章　帮助孩子顺利走向社会</strong></p><p><br></p><p>让孩子学会接受现实</p><p><br></p><p>让孩子不要太轻信别人</p><p><br></p><p>帮助孩子学会分辨是非对错</p><p><br></p><p>让孩子学会识别坏人的伪装</p><p><br></p><p>让孩子学会原谅别人</p><p><br></p><p>让孩子懂得学以致用</p><p><br></p><p>不断追求生活中的真谛</p><p><br></p><p>不墨守成规，教孩子随机应变</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/41386534854166245.png', 'http://img.jssns.cn/SHILU/1/0c31ed893198f9a5c5b6995685aca3ee.jpg', null, 'album', 'ID515536127436783618', '124', '0', '11', '168', '2018-12-10 14:45:09', '168', '2019-01-31 23:09:20');
INSERT INTO `audio` VALUES ('ID521699097439109120', '儿童早期教育（下篇）', 'http://img.jssns.cn/SHILU/1/c51f21a9cb308991028e7d53e1e7f6bf.mp3', '<p>孩子是天才还是俗物，与先天遗传关系不大，主要看后天的生长环境和接受了什么样的教育。</p><p><br></p><p><strong>第一章　教育的奥秘：庸才与骄子</strong></p><p><br></p><p><strong>教育是人类最宏伟的工程</strong></p><p><br></p><p>不管做什么事，尤其是一些环环相扣的事情，有一个良好的开端是非常重要的。一个良好的开端是整件事情能否顺利解决的基础，对事情的后续发展起到至关重要的作用。”</p><p><br></p><p>从社会发展历史来看，不论是由于道德或宗教，还是由于经济等原因而引起的争斗与矛盾，探究其产生的深层次的根源，无一不是因为人们对欲望的贪婪与无休止的追求。</p><p><br></p><p>不同的民族教育便产生了不同的民族文化。一个国家最基本的教育与该国的社会特征与上层建筑有密切的联系。国家的整体面貌则是该国教育的一个体现。</p><p><br></p><p>孩子就像黏土，而父母就像做陶器的人。</p><p><br></p><p>谁来掌握着孩子呢？显然，是孩子的父母、家庭，还有就是在小时候照顾他们并给他们深刻影响的人。</p><p><br></p><p><strong>早教是孩子成长的关键</strong></p><p><br></p><p>现在的教育模式，无论是在家里还是在学校，孩子们都被灌输各种美好的预言和故事。我们的目的是让孩子知道世界是多么美好，可是，这是真实的世界吗？我们难道不应该让孩子知道世界的真面目吗？</p><p><br></p><p>我们不应该让孩子一直生活在这些美好的谎言之中，这样会损害孩子的心灵。我们应该给予他们一定的视角，让他们真正了解社会的现状，这样他们才能正确看待社会，才有可能明辨是非。</p><p><br></p><p><strong>帮孩子避开不利的成长环境</strong></p><p><br></p><p><strong>达尔文思想对教育的影响</strong></p><p><br></p><p>叔本华曾经说过：“当我们可以走进或者代替另一个人的时候，会发现原来他的生活这么恐怖。或者假如你非常乐观，无论是面对战争还是监狱，甚至是刑场，你都不会抱怨，并且乐观面对。但是，当你被送到更加恐怖和黑暗的地方时，你会发现你无法继续乐观了，这一切真的让你无法接受。”</p><p><br></p><p><strong>请让孩子认识真实的世界</strong></p><p><br></p><p><strong>第二章　什么是真正的教育</strong></p><p><br></p><p>孩子的优秀源自双亲</p><p><br></p><p>真正的教育不应存有商业元素</p><p><br></p><p>一位思想家这样说过：“如果你是一个心智清醒的人，你会不断地更新自己的知识。同时，会不断开阔自己的视野，完善自己的思维能力。”这位思想家就是约翰·穆勒。</p><p>穆勒曾经这样说过，教育是造就伟大思想的前提，能让人们从内心热爱和追求真理，从而培养出一大批优秀的人才。</p><p><br></p><p>真正的教育就是给孩子自由</p><p><br></p><p>教育应该是手工制作，而不是批量生产</p><p><br></p><p>首先，我们需要培养孩子的品行，让孩子成为一个善良的人。其次，我们要给予孩子自由，并让其成长为对社会有用之人。</p><p><br></p><p>教育理念是需要不断改变的</p><p><br></p><p>教育不可忽视创新精神</p><p><br></p><p>帮助孩子找到真实的自我，完善自己的创新意识</p><p><br></p><p><strong>第三章　教育应该从什么时候开始</strong></p><p><br></p><p>何时才是幼儿教育的绝佳时间</p><p><br></p><p>对孩子进行早期教育的最佳时期，我认为是在孩子2岁到3岁之间。</p><p><br></p><p>幼儿时期的教育影响孩子一生</p><p><br></p><p>潜能开发不应晚于1岁</p><p><br></p><p>尽早开发孩子的语言潜能</p><p><br></p><p>建构孩子的精神世界</p><p><br></p><p>关注孩子的内心伤痛</p><p><br></p><p><strong>第四章　如何培养孩子的优秀品质</strong></p><p><br></p><p>教育孩子要诚实守信</p><p><br></p><p>培养孩子谦虚、礼让的品质</p><p><br></p><p>注重孩子的爱心教育</p><p><br></p><p>从小养成孩子的节俭品质</p><p><br></p><p>让孩子专注做事与学习</p><p><br></p><p>培养孩子的毅力和恒心</p><p><br></p><p>让孩子学会与人分享</p><p><br></p><p><strong>第五章　儿童教育应把握的重点和难点</strong></p><p><br></p><p>正确对待孩子的早熟问题</p><p><br></p><p>关于思想颇奇儿童的教育</p><p><br></p><p>避免孩子过于崭露锋芒</p><p><br></p><p>孩子的成长离不开生活的磨炼</p><p><br></p><p>帮助孩子解除“完美”情结</p><p><br></p><p>应当重视对孩子的心理教育</p><p><br></p><p><strong>第六章　教育要顺应孩子的天性</strong></p><p><br></p><p>孩子的成长需要自由</p><p><br></p><p>及时帮助孩子解决疑惑</p><p><br></p><p>随时给孩子讲解各种知识</p><p><br></p><p>允许孩子有自己的想法</p><p><br></p><p>重视孩子的全面发展</p><p><br></p><p>让孩子乐观勇敢地接受挑战</p><p><br></p><p>让孩子乐于学习和创新</p><p><br></p><p><strong>第七章　给孩子注入正能量</strong></p><p><br></p><p>给孩子快乐的学习空间</p><p><br></p><p>给孩子创造好的生活环境</p><p><br></p><p>要让孩子树立自信</p><p><br></p><p>在孩子迷茫时给予指导</p><p><br></p><p>永远不要打击孩子的信心</p><p><br></p><p>不要用父母的权威打压孩子</p><p><br></p><p>父母做错了，也要向孩子道歉</p><p><br></p><p><strong>第八章　帮助孩子顺利走向社会</strong></p><p><br></p><p>让孩子学会接受现实</p><p><br></p><p>让孩子不要太轻信别人</p><p><br></p><p>帮助孩子学会分辨是非对错</p><p><br></p><p>让孩子学会识别坏人的伪装</p><p><br></p><p>让孩子学会原谅别人</p><p><br></p><p>让孩子懂得学以致用</p><p><br></p><p>不断追求生活中的真谛</p><p><br></p><p>不墨守成规，教孩子随机应变</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/41386644710608859.png', 'http://img.jssns.cn/SHILU/1/0c31ed893198f9a5c5b6995685aca3ee.jpg', null, 'album', 'ID515536127436783618', '107', '0', '12', '168', '2018-12-10 14:45:57', '168', '2019-01-31 23:09:55');
INSERT INTO `audio` VALUES ('ID524909182437031936', '【三顾茅庐】如何找到创业合伙人？', 'http://img.jssns.cn/SHILU/1/2d6e78a9d1f2339a08f1a820ed4caded.mp3', '<h2><strong>三顾茅庐</strong></h2><p><br></p><blockquote>小智：小杨，小王愿意加入我们篮球队吗？</blockquote><blockquote>小洋：不知道啊，我去找过他了，他人不在。</blockquote><blockquote>小智：人不在？那你再过去看看</blockquote><blockquote>小洋：好吧~</blockquote><blockquote>（跑步声）</blockquote><blockquote>小智：来了吗？</blockquote><blockquote>小洋：人又不在，别喊他了，我们自己玩吧。</blockquote><blockquote>小智：他是个很厉害的投手，对我们团队帮助很大，一定要把他喊来，你再去试试看~</blockquote><blockquote>小洋：我才不去呢？已经白跑2次了！</blockquote><blockquote>小智：小杨啊，对待优秀的人，我们一定要有三顾茅庐的精神</blockquote><blockquote>小洋：三顾茅庐？是三次去上茅厕的意思吗？可我也肚子也不疼啊~</blockquote><blockquote>小智：哈哈，不是哦，让我给你讲讲三顾茅庐的故事吧~</blockquote><p>&nbsp;</p><p>东汉末年，中原各地都在打仗。每股势力都想壮大自己，成为国家的唯一统治者。其中有位叫刘备的英雄，他看到国家四分五裂，百姓被战争折磨，很想建立一个能让百姓安居乐业、没有战乱的国家。但是，刘备的势力很薄弱，他身边只有两个能征善战的好兄弟——关羽和张飞，而缺少有智谋的人帮助他。</p><p><br></p><p>后来，有人向刘备推荐诸葛亮，说他才华过人、智谋深远，如果谁能得到他的帮助，就可以平定天下了。</p><p>刘备为了请诸亮帮助自己打天下，就同关羽、张飞一起去请他出山。可是诸葛亮不在家，刘备只好留下姓名，怏怏不乐地回去。隔了几天，刘备打听到诸葛亮回来了，又带着关羽、张飞冒着风雪前去。哪知诸葛亮又出门出去了，刘备他们又空走一趟。</p><p><br></p><p><img src=\"https://mmbiz.qlogo.cn/mmbiz_jpg/CGe7osHWVneib355gHKcwc6thibGsCnHGictL8CAljvk971cKvQJsNwWr9q2qvpz044f4PCkkbk1uvia4jkaooM3BA/0?wx_fmt=jpeg\"></p><p><br></p><p>刘备第三次去隆中，终于见到了诸葛亮。在交谈中，诸葛亮对天下形势作了非常精辟的分析，刘备十分叹服。</p><p><br></p><p>刘备三顾茅庐，使诸葛亮非常感动，答应出山相助。刘备尊诸葛亮为军师，对关羽、张飞说：我之有孔明，犹鱼之有水也!</p><p><br></p><p>诸葛亮初出茅庐，就帮刘备打了不少胜仗，为刘备奠定了蜀汉的国基。</p><p><br></p><p>后来，我们就用“三顾茅庐”这个成语<strong>比喻真心诚意，一再邀请他人。</strong>这个成语故事的细节值得我们好好研究下。</p><p><br></p><p>首先，诸葛亮真的是一介布衣吗？这里的布艺指的是普通老百姓，没什么背景。</p><p><br></p><p>其实，诸葛亮的背景非常惊人，陈寿在<strong>《三国志》</strong>里是这么描述诸葛亮背景的：“琅琊阳都人也，汉司隶校尉诸葛丰后也。汉司隶校尉诸葛丰后也。父圭，字君贡，汉末为太山都丞。”</p><p><br></p><p>这段话意思是说：“诸葛亮，字孔明，琅邪郡阳都县人。汉元帝司隶校尉诸葛丰的后代，他的父亲是诸葛珪，在汉朝末年担任过太山郡的郡丞。”</p><p><br></p><p>从上面我们就可以看出，诸葛亮并不是普通老百姓，他的家族在当地非常有名望。所以，虽然诸葛亮身居乡村，但他的名声早就被传播了出去，否则刘备也不会知道他。</p><p><br></p><p>这一点在这个“酒香也怕巷子深”的时代尤为重要，想让让自己成为别人眼中的人才，和别人共创一番事业，你需要打造自己的名片，即你要让别人知道你是干什么的？你擅长什么？</p><p><br></p><p>其次，既然诸葛亮如此厉害，难道没有其他人邀请过他吗？可为何他只和刘备合作呢？</p><p><br></p><p>一方面是刘备三顾茅庐表达出的诚意和耐心都让诸葛亮很感动，认为他是一个可以信赖的人。但你要知道，合作共赢的核心不仅是人，更重要的是你要做的事情。</p><p><br></p><p>我们试想下，如果刘备只希望占据郡涿县，成为一县霸主，享受荣华富贵的生活。那么诸葛亮还会和他合作吗？</p><p><br></p><p>没错，并不会，诸葛亮之所以愿意加入刘备麾下，恰恰是因为刘备志在天下，刘备的目标是要一统天下！这个目标吸引了诸葛亮。要知道，对于真正顶级的人才而言，他们在意的是自己的影响力，而影响力需要通过完成那些看似不可能的事情来体现。统一天下，功在当代，利在千秋，这才是真正吸引诸葛亮的地方。</p><p><br></p><p>所以啊，小朋友们，如果你以后想获得专业人士的帮助，不仅要有三顾茅庐的精神，更重要的是让他知道你要做的这件事情的意义。有句话说得好，<strong>一个人做梦是白日梦，一群人做梦才是梦想。</strong></p><p><br></p><p>下好了，今天的成语故事新说就到这里，下一次，我们继续讲关于诸葛亮的成语，<strong>舌战群儒！</strong>我们下次再见咯！</p>', 'http://img.jssns.cn/SHILU/1/41796593268058495.png', 'http://img.jssns.cn/SHILU/1/b7270efdbfd462bedf8cae9d4a30420d.jpg', null, 'album', 'ID515539237269929986', '120', '3', '2', '168', '2018-12-19 11:21:41', '432228697144033280', '2019-02-22 11:39:02');
INSERT INTO `audio` VALUES ('ID525680320045907968', '你看起来很好吃', 'http://img.jssns.cn/SHILU/1/1aeb6bd5e4aea6b37ac0fb23e432bbff.mp3', '<p>你看起来很好吃</p><p><br></p><p>以前、以前、很久很久以前。在一个燥热的大沙漠里，有一个神奇的蛋被遗落在这个沙漠上。沙漠里有很多座火山，不知过了多久，荒漠里的几座活火山终于爆发了，大地在震动，零零星星的碎石块从火山口不断喷出，滚烫的岩浆流得满地都是。</p><p><br></p><p>然而，就在这时，只听“噼啪”一声，那个蛋裂开了，原来是一只小甲龙破壳而出，望着四周空无一人，他感觉好孤单，于是忍不住哭了起来……</p><p><br></p><p>就在这时，嗷呜——出现了一个巨大的影子——一只凶狠的霸王龙，霸王龙立刻吼道：“你看起来好像很好吃。”可是小甲龙并不害怕，而且紧紧地抱住了霸王龙那只柱子般的大腿，嘴里不停地喊着：“爸爸，爸爸！”霸王龙很惊讶：“你怎么知道我是你的爸爸？”“因为你刚才叫我的名字，知道我的名字就一定是我的爸爸。”小甲龙很坚决。“你……你的名字？”“对呀，我的名字就叫‘很好吃’。”</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/9f86df84ebf2d149697705599c625d59-sz_86268.jpeg?x-oss-process=style/xmorient\"></p><p><br></p><p>霸王龙无语，这时，它听到小甲龙在叫：“爸爸，爸爸，你怎么不吃草？”“奥，这不如肉……好吃，我不吃，你吃吧。”霸王龙小声地说。</p><p><br></p><p>就在这时，一只凶猛的古兰泰龙出现了，也对小甲龙说：“你看起来好像很好吃！”“叔叔，你也认识我呀！”说完，小甲龙又吃起草来。</p><p><br></p><p>“我要吃得多多的，好早点长得像你一样！”小甲龙边吃边说。</p><p><br></p><p>古兰泰龙张大嘴巴，准备要吃掉小甲龙，咔嚓！霸王龙用自己庞大的身躯挡住了小甲龙，同时又用自己的大尾巴狠狠地抽走了凶猛古兰泰龙。</p><p><br></p><p>到了晚上，霸王龙小声地对小甲龙说：“你说你也要长的像我这么大？“是呀！”小甲龙说完就睡着，这天它睡的很香。霸王龙心里很痛，比背上的伤口还痛。</p><p>第二天一早，火山又爆发了，霸王龙被惊醒了，可小甲龙却不见了，霸王龙四处寻找，可无论怎样就是找不到小甲龙。</p><p><br></p><p>“爸爸！爸爸！”只见小甲龙从远处背着一些红果子回来了。“你不爱吃草，我就去山的那边给你去摘红果子。”</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/6f583cd96f19a1cd0669ebf3a5c1e003-sz_26017.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>霸王龙生气地说：“你为什么不告诉就四处乱跑？”小甲龙委屈地说：“爸爸，我下次再也不乱跑了！”说完，就呜呜地哭起来。</p><p><br></p><p>“你这样知不知道很危险！好了！好了！别哭了！”说完，便吃起果子来，“好吃！好吃！”霸王龙一边说一边吃着。从这以后小甲龙每天早上都给霸王龙去摘果子。</p><p><br></p><p>吃完果子霸王龙教小甲龙怎样撞击、怎样用尾巴抽树、吼……</p><p><br></p><p>有一天，霸王龙说：“我已经没有什么可教你的了，你走吧！”“不，我要永远和你在一起！”霸王龙悲伤地说：“好，我们来赛跑，如果你能比过我，我们就永远在一起。”“好！”小甲龙说。</p><p><br></p><p>小甲龙努力地向前跑，嘴里不停的说：“我一定要和爸爸在一起！”可霸王龙却回头走了。小甲龙跑着跑着，遇见了自己的真正的父母，“再见了，‘很好吃’。” 霸王龙边说边吃完了最后的一个很好吃给他摘的果子，微笑地向远方走去。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/41980447735279173.png', 'http://img.jssns.cn/SHILU/1/779ded1da9a6c9ece332a19bd22c97f4.jpg', null, 'album', 'ID558316417410138112', '139', '14', '1', '168', '2018-12-21 14:25:54', '168', '2019-01-28 09:14:49');
INSERT INTO `audio` VALUES ('ID525686848677216256', '泡泡糖飞船', 'http://img.jssns.cn/SHILU/1/45901476dce18e8a7166a5cc7af3a0b0.mp3', '<p>泡泡糖飞船</p><p><br></p><p>春天来了，森林里的布谷鸟叫着：“布谷——布谷——”</p><p><br></p><p>小动物们听到布谷鸟叫，开始种地了。</p><p><br></p><p>小兔种萝卜，小猴种花生，小熊种玉米。小狗俏俏什么种子也没有，急得直掉眼泪。他挠挠头，摸摸兜。咦？兜里有块泡泡糖，小狗俏俏就把泡泡糖种在了泥土里。</p><p><br></p><p>小兔、小猴、小熊看见小狗俏俏种了一块泡泡糖，哈哈大笑。调皮的小猴还给小狗俏俏编了一首歌：“公鸡下蛋鼠吃猫，小狗俏俏种泡泡，玉米好吃萝卜大，小狗俏俏，什么也得不到！”</p><p><br></p><p>不管别的小动物怎么说，小狗俏俏都不理。</p><p><br></p><p>小兔给萝卜浇水，小狗俏俏也给泡泡糖浇水。</p><p><br></p><p>小猴给花生锄草，小狗俏俏也给泡泡糖锄草。</p><p><br></p><p>小熊给玉米施肥，小狗俏俏也给泡泡糖施肥。</p><p><br></p><p>小兔的萝卜长出了叶子，小猴的花生苗蹿得很高，小熊的玉米结出了又长又大的果实。</p><p><br></p><p>可是，小狗俏俏的泡泡糖连一点嫩芽芽都没有冒出来。小狗俏俏不灰心，他每天都给泡泡糖浇水、锄草、施肥。</p><p><br></p><p>秋天来了，金色的叶子随风飘落。丰收的日子到了。</p><p><br></p><p>小兔拔出了一个大萝卜。萝卜好大好大呀，十只小兔都抱不过来。</p><p><br></p><p>小猴刨出来一颗大大的花生，花生壳可以变成两只小船。</p><p><br></p><p>小熊掰下了一个很大很大的玉米棒，立起来比小熊还要高。</p><p><br></p><p>可小狗俏俏的泡泡糖还是一点动静都没有。小狗俏俏继续给泡泡糖施肥浇水。浇着浇着，突然，轰隆一声，地上的土裂开了，冒出一个彩色的大泡泡，就像一个特别大特别大的彩色气球！</p><p><br></p><p>彩色的大泡泡飘了起来，向天空飞去。</p><p><br></p><p>“我种的泡泡糖长出来了！”小狗俏俏一把抓住彩色的大泡泡，也飘了起来。</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/223a9eeb05da68516c6bdf9684d24505-sz_21513.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>小兔抓住了小狗俏俏的花尾巴，小猴抓住了小兔的短尾巴，小熊抓住了小猴的长尾巴，彩色的大泡泡才慢慢地落下来。 这个彩色的大泡泡很有用呢。小狗俏俏在彩色的大泡泡下面拴了一个用竹条编成的大筐，筐边上围了一圈美丽的花朵，又在大筐下系了一根长长的绳子。哪只小动物想去天上瞧一瞧，小狗俏俏就把绳子放长，让彩色的大泡泡升上天空。 小动物们坐在筐里地唱歌：“真好玩儿，真好玩儿，小狗俏俏会种田，种出一个大泡泡，带着我们天上转。”</p><p><br></p><p>这下子，森林里的小动物们就有了一艘“泡泡糖飞船”。</p>', 'http://img.jssns.cn/SHILU/1/41982003064393983.png', 'http://img.jssns.cn/SHILU/1/2f13c2ae8e9502c3ac4a87ff8cb35c04.jpg', null, 'album', 'ID558303512723718144', '129', '11', '2', '168', '2018-12-21 14:51:51', '168', '2019-01-28 09:18:58');
INSERT INTO `audio` VALUES ('ID529380122512326656', '森林里的“月亮池”', 'http://img.jssns.cn/SHILU/1/97da2cf5a5a6e9296e1a02ec0bcdac08.mp3', '<p>在一座茂密的大森林里有一个池塘，每天晚上，月亮的影子都会倒映在池塘里面。大家称之为“月亮池”，小动物们都非常喜欢喝月亮池的水，因为月亮池的水清甜可口。所以，每天晚上都会有很多小动物沿着一条小路走到月亮池边去喝水。</p><p>&nbsp;</p><p>有一天，森林里来了一只大狗熊，他也走到了小路上。</p><p>&nbsp;</p><p>大狗熊看见路上有一排小小的竹叶状脚印，知道小鸡在前面，就“嘭嘭嘭”地追上去，一把拎起小鸡说：“让开!让开!这条路只许我一个人走！”</p><p>&nbsp;</p><p>小鸡吓得一声也不敢吭。大狗熊又看见路上有一排扇子状脚印，知道小鸭在前面，就“嘭嘭嘭”地追上去，一把推开小鸭说：“让开!让开!这条路只许我一个人走！”</p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/5c8aed83b67184c53de386a1b96ef446-sz_7943.jpg?x-oss-process=style/xmorient\"></p><p><br></p><p>小鸭吓得“嘎嘎嘎”乱叫。</p><p>&nbsp;</p><p>大狗熊还看见路上有一排梅花状脚印，知道小狗在前面，就“嘭嘭嘭”地追上去，一脚踢开小狗说：“让开!让开!这条路只许我一个人走！”</p><p>&nbsp;</p><p>小狗吓得呜呜呜叫。</p><p>&nbsp;</p><p>小鸡、小鸭和小狗聚到了一起，大家心里都发愁：路被大狗熊霸占了，月亮池里的水都让大狗熊喝了，我们怎么办?</p><p>&nbsp;</p><p>个子最小的小鸡，想了一个好主意。</p><p>&nbsp;</p><p>第二天，大狗熊又走在小路上，去月亮池喝水。他昂头挺胸，又得意又骄傲：“看我多么高大，瞧我多么强壮，路我一个人走，水我一个人喝！”</p><p>&nbsp;</p><p>正得意呢，大狗熊一脚踩到了坑里，他慌忙低头一看，哎呀，是一个大脚印，这个脚印可真大，大狗熊的两个脚掌摆在里面，还空出一圈哪！</p><p>&nbsp;</p><p>大狗熊往前一看，呵，前面还有一大排这样的大脚印呢!</p><p>&nbsp;</p><p>大狗熊胆战心惊地往前走了几步，心想：谁会有这么大的脚印：大怪兽还是大恐龙?他会把自己拎出去，推出去还是踢出去?</p><p>&nbsp;</p><p>大狗熊越想越害怕，腿脚发软，再也不敢往前走，悄悄地逃离了月亮池。</p><p>&nbsp;</p><p>躲在树丛后的小动物们哈哈哈笑起来。月亮森林里没有大怪兽也没有大恐龙，是他们做了两个大脚板，一起“制造”了那些大脚印!</p><p>&nbsp;</p><p>故事里的小动物们是不是十分的聪明呢!</p><p>论体型，小动物们绝对不会是大狗熊的对手的，如果非得硬碰硬，受伤的肯定是小动物啦!所以当我们遇到比自己强大的敌人时，要积极开动脑筋，用智慧去战胜敌人!</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/42862548704535791.png', 'http://img.jssns.cn/SHILU/1/1cb1af977d7f21100b7fcd480ac3d2d2.jpg', null, 'album', 'ID558316668967714816', '137', null, '2', '432228697144033280', '2018-12-31 19:27:36', '168', '2019-01-28 14:58:26');
INSERT INTO `audio` VALUES ('ID529392370534318080', '培养孩子从画画开始', 'http://img.jssns.cn/SHILU/1/28f61476219e5069e0464b5a02b2c4f0.mp3', '<p>《培养孩子从画画开始》是日本著名儿童教育专家、画家鸟居昭美的经典作品。书中作者结合简单的案例通过朴实的语言，分析了孩子绘画所隐藏的宝贵信息，可以，帮助家长对孩子涂鸦的引导和帮助。作者在文中将孩子的每个阶段作品特点进行了介绍。帮助家长减少对孩子作品的一些误区。是家长们对教育孩子必不可少的一本启蒙教育书。</p><p><br></p><p>1、其中作者说过一句话，教孩子绘画最好时期从6到7岁开始。这是对孩子进行研究后得出的结论。这在中国的大教育背景下也是可以得到理论支持的。但是现实情况却不是这样子，上幼儿园的时候，家长会急于给孩子教授一些简单的话。而且会要求老师在教授美术的时候给孩子画示范画。其实范画对孩子的天性的一种扼杀。这在我的实际教育过程中是可以有所体会的。有些孩子的作品一层盖着一层，你看不懂是什么？你问他，他会告诉你这个是什么那个是什么？你认真观察会发现其实是有一些相似。但有一部分孩子你看他画的作品就能看出来他画的是什么？比如她画一个太阳，她就会画一个圆圈，然后在旁边画上光芒。之前一次园长去我们班级检查绘画的时候。对我们说，小班的孩子画画挺好看的呢！你们是怎么教的呀！我笑了笑，我说我比较懒，不教他们，只是告诉他们今天要画什么，然后找一个类似的作品。让他们自己去观察，然后画出自己的作品。其实我真的是懒吗？这比我要给他们做范画，下的功夫要多得多。我要引导他们对一个事物进行回忆，然后对他们回忆的内容进行分析，最后才让他们画。这个过程远比给他们一个简单的范画要复杂得多。</p><p><br></p><p>2、但这样一来就要求孩子的生活经验是非常丰富的。这让我又想到文中作者写道，艺术的真正本质就是以毁坏、弄脏已有的形象为基础的。现在很多家长都认为孩子干净是非常重要的。讨厌孩子玩沙水一类的东西。因为这一类的东西会把孩子衣服弄得很脏。但事实上，孩子是非常喜欢沙子和水的。文中作者有关于沙和水的一句话是这样说的。恐怕是因为大地和大海，对于所有的生命都像母亲一样，所有的生命都是从水里诞生，扎根于大地而成长。所以，人的幼小生命大概是出于本能，需要沙和水。所以亲爱的朋友们，不要为了干净而剥夺孩子玩沙和水的权利。多给孩子提供这样的机会，会让孩子的生活变得五彩斑斓。</p><p><br></p><p>3、当孩子说出妈妈话的时候请不要急着给孩子做范画。你可以拿一个本子或你生活的一个记录本在他旁边陪着他写，就可以了。</p><p><br></p><p>4、孩子的绘画是孩子的一种表达方式，家长应该认真的听画。当然听话也要根据年龄来分。2到3岁的孩子应该问他这是什么？到4岁以后要问他们，他们在做什么？4岁以后孩子的作品已经开始赋予它故事情节。但也不应该喋喋不休的问个不停。可以等到孩子画画给你看的时候或者画一段时间停休息的时候去问他就可以了。</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/42865468353617666.png', 'http://img.jssns.cn/SHILU/1/2e0df5d6945bf3727bd2a803146834a5.jpg', null, 'album', 'ID515536127436783621', '200', null, '0', '432228697144033280', '2018-12-31 20:16:16', '168', '2019-01-31 23:25:11');
INSERT INTO `audio` VALUES ('ID530070521719554048', '白雪公主', 'http://img.jssns.cn/SHILU/1/956c50756b4a3fc21a9d115f5a9e066a.mp3', '', 'http://img.jssns.cn/SHILU/1/43027152476386015.png', 'http://img.jssns.cn/SHILU/1/43c085d0bedba783ae1383267632ddec.jpg', null, 'album', '', '129', null, '1', '168', '2019-01-02 17:11:00', '168', '2019-01-02 17:27:22');
INSERT INTO `audio` VALUES ('ID530072803815194624', '海的女儿', 'http://img.jssns.cn/SHILU/1/43d47f2b49ce97a26d1a0f85eeb955a7.mp3', '', 'http://img.jssns.cn/SHILU/1/43027696270595656.png', 'http://img.jssns.cn/SHILU/1/847f086a17fed3f53ef59554c540a373.jpg', null, 'album', '', '123', null, '2', '168', '2019-01-02 17:20:04', '168', '2019-01-02 17:27:10');
INSERT INTO `audio` VALUES ('ID530074431402278912', '阿里巴巴', 'http://img.jssns.cn/SHILU/1/6f027794af7f9be964f791ac51a5ce04.mp3', '', 'http://img.jssns.cn/SHILU/1/43028084268358672.png', 'http://img.jssns.cn/SHILU/1/a0b0825f2e27f42b5d04a888280d8a4f.jpg', null, 'album', '', '130', null, '3', '168', '2019-01-02 17:26:32', '168', '2019-01-02 17:27:33');
INSERT INTO `audio` VALUES ('ID530078929201922048', '阿拉丁神灯', 'http://img.jssns.cn/SHILU/1/8cdfe7b131d3d6513e59ee856b4f71dc.mp3', '', 'http://img.jssns.cn/SHILU/1/43029156824276708.png', 'http://img.jssns.cn/SHILU/1/3bebbc8b794aff316bb2c6f48790975b.jpg', null, 'album', '', '127', null, '4', '168', '2019-01-02 17:44:25', '168', '2019-01-02 17:44:25');
INSERT INTO `audio` VALUES ('ID530080891918090240', '康拉德', 'http://img.jssns.cn/SHILU/1/24c4aa504fc1e5207f02aee76c418ab3.mp3', '', 'http://img.jssns.cn/SHILU/1/43029624584189769.png', 'http://img.jssns.cn/SHILU/1/147332058c02b79cfa3df5b49cd49457.jpg', null, 'album', '', '105', null, '5', '168', '2019-01-02 17:52:13', '168', '2019-01-02 17:52:13');
INSERT INTO `audio` VALUES ('ID530081588499709952', '野天鹅', 'http://img.jssns.cn/SHILU/1/4c667b02b36598c3ff18c1df6d0692da.mp3', '', 'http://img.jssns.cn/SHILU/1/43029790724659825.png', 'http://img.jssns.cn/SHILU/1/302d2b874ad27db056e2585a88a3f429.jpg', null, 'album', '', '107', null, '6', '168', '2019-01-02 17:54:59', '168', '2019-01-02 17:54:59');
INSERT INTO `audio` VALUES ('ID530082488131780608', '丑小鸭', 'http://img.jssns.cn/SHILU/1/a6f5cdb163c06d1c540fe220b6a6bbce.mp3', '', 'http://img.jssns.cn/SHILU/1/43030005118517767.png', 'http://img.jssns.cn/SHILU/1/9d83e7be19c30e512aeb96fb8d31a33d.jpg', null, 'album', '', '108', null, '7', '168', '2019-01-02 17:58:33', '168', '2019-01-02 17:58:33');
INSERT INTO `audio` VALUES ('ID530085120019791872', '小熊星', 'http://img.jssns.cn/SHILU/1/a00bc01faf3232edc38dc74fc9f68cb9.mp3', '', 'http://img.jssns.cn/SHILU/1/43030632703690008.png', 'http://img.jssns.cn/SHILU/1/789ea1f567db0fd20df800cdf1921a36.jpg', null, 'album', '', '104', null, '8', '168', '2019-01-02 18:09:01', '168', '2019-01-02 18:09:01');
INSERT INTO `audio` VALUES ('ID530328736772390912', '大狼', 'http://img.jssns.cn/SHILU/1/437bb7cf5036295eb3840705b07f6f56.mp3', '', 'http://img.jssns.cn/SHILU/1/43088715927114743.png', 'http://img.jssns.cn/SHILU/1/bfb6fdb38abc35786207776b9796d89a.jpg', null, 'album', '', '101', null, '9', '168', '2019-01-03 10:17:03', '168', '2019-01-03 10:17:03');
INSERT INTO `audio` VALUES ('ID530342537714466816', '大乌龟', 'http://img.jssns.cn/SHILU/1/ffc766c26d22e1350c7d683b04538eee.mp3', '', 'http://img.jssns.cn/SHILU/1/43092005809749443.png', 'http://img.jssns.cn/SHILU/1/146a5dce451a4f4bc5cd9928eb5b3ef0.jpg', null, 'album', '', '107', null, '10', '168', '2019-01-03 11:11:54', '168', '2019-01-09 10:48:33');
INSERT INTO `audio` VALUES ('ID530395582259265536', '美人和怪兽', 'http://img.jssns.cn/SHILU/1/ca4ac209c76e7a24cc4613fdc01e9742.mp3', '', 'http://img.jssns.cn/SHILU/1/43104652820634075.png', 'http://img.jssns.cn/SHILU/1/6af66da9eb18659a4ec52c4c28cb087a.jpg', null, 'album', '', '103', null, '11', '168', '2019-01-03 14:42:41', '168', '2019-01-03 14:42:41');
INSERT INTO `audio` VALUES ('ID530398186003496960', '穿靴子的猫', 'http://img.jssns.cn/SHILU/1/fb5a2641a9c15dfce409577736c6eb71.mp3', '', 'http://img.jssns.cn/SHILU/1/43105273448495170.png', 'http://img.jssns.cn/SHILU/1/6fc96877c798d3534726ddbf0d61cbc8.jpg', null, 'album', '', '112', null, '12', '168', '2019-01-03 14:53:01', '168', '2019-01-03 14:53:01');
INSERT INTO `audio` VALUES ('ID530438574764457984', '青蛙王子', 'http://img.jssns.cn/SHILU/1/fca87dd52a6b0382b3a9259d329dcbf7.mp3', '', 'http://img.jssns.cn/SHILU/1/43114903440282875.png', 'http://img.jssns.cn/SHILU/1/2d70822140a8a5546f5bd83d2f567e8e.jpg', null, 'album', '', '112', null, '13', '168', '2019-01-03 17:33:31', '168', '2019-01-09 10:44:21');
INSERT INTO `audio` VALUES ('ID531530446631075840', '珍贵的硬币', 'http://img.jssns.cn/SHILU/1/495c13eea7a3d6f7b9a88accda31ff39.mp3', '', 'http://img.jssns.cn/SHILU/1/43375225786799877.png', 'http://img.jssns.cn/SHILU/1/d5ee83a7371f9e18228965018f43a2f8.jpg', null, 'album', 'ID558316172307595264', '120', null, '3', '432228697144033280', '2019-01-06 17:52:13', '168', '2019-01-28 10:38:17');
INSERT INTO `audio` VALUES ('ID531530617293111296', '自信是金', 'http://img.jssns.cn/SHILU/1/fb243c7a6bc98280c2b34a02d2b1420d.mp3', '<p><span style=\"color: rgb(102, 102, 102);\">从前，有一只鸽子。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">这只鸽子全身都是白色的，只有头是灰色的。所以，其它的白鸽子都叫它“灰头”。虽然灰头和白鸽子有一些不同之处，但是它们还是成为了好朋友（它们还会说话）。有时候，灰头有些惭愧：它和别的鸽子长得与众不同。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">有一天，住在海边的灰头竟然对它的伙伴说：“我想到遥远的森林里去游玩。”天哪，从海边到森林是要飞行两天两夜的！伙伴们听了，吃了一惊，说：“灰头，你真的想去吗？那可是要飞行两天两夜的！”“我已经决定了！”灰头坚定地说。伙伴们也不必多说，都为它准备了食物，和它告别。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">经过两天两夜的长途跋涉，灰头终于到达了它梦寐以求的森林里。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">“啊！森林里多美呀！葱绿的树叶遮天盖地，郁郁葱葱。”灰头称赞着这一片美丽的森林，在那里飞行着，欣赏优美的风景。但是，好景不长——“啪”地一声，一支箭早已射在了灰头的身体上。灰头叫了一声，幸好，它掉在树杈之间，没有掉在地上，否则，非落入那个猎人之手。再说那个猎人，看见鸽子没有掉下来，非常气愤，只好走了。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">灰头负了伤。它只能跳到树下，一瘸一拐地走着。走了许久，它看见林子里有一间小木屋，里面住着一位老爷爷。老爷爷看见门前有一只鸽子负了伤，就捧起它，进屋给它治病。灰头非常感谢好心的老爷爷，说：“谢谢！”老爷爷吃了一惊，心想：这鸽子竟然说话了，我也跟它聊天吧！于是，老爷爷跟灰头聊着天：“你有名字吗？”“我叫灰头，因为我和别的鸽子长得不一样，就会感到惭愧。”老爷爷说：“自信才是最重要的，你要有自信才行。长得不一样没关系，只要你的伙伴还和你做朋友就行了。”灰头非常感激。</span></p><p><br></p><p><span style=\"color: rgb(102, 102, 102);\">等灰头的伤愈合后，又飞回了海边。从此，它对自己充满了自信，它明白：自信是金。</span></p><p><br></p>', 'http://img.jssns.cn/SHILU/1/43375266018047903.png', 'http://img.jssns.cn/SHILU/1/95e0970e863793cc5b441b4595be713c.jpg', null, 'album', 'ID558316172307595264', '115', null, '4', '432228697144033280', '2019-01-06 17:52:54', '168', '2019-01-28 15:05:16');
INSERT INTO `audio` VALUES ('ID532501576867119104', '【舌战群儒】如何提高自己的思辨能力', 'http://img.jssns.cn/SHILU/1/74758d595a241b330bd28173ee51063e.mp3', '<h2><strong>舌战群儒</strong></h2><p><br></p><p><strong>舌战</strong>就是激烈争辩的意思，<strong>儒</strong>指的是读书人。因此，舌战群儒的字面意思是与一群读书人激烈争辩。</p><p><br></p><p>为什么诸葛亮要和一群读书人争辩呢？争辩的结果又怎样呢？话不多说，我们开始今天的成语故事新说。</p><p><br></p><p>东汉末期，曹操挟天子以令诸侯，较有实力的军阀大都被他消灭了，惟独刘备和孙权还有发展壮大的可能，曹操自知一下子吞并这两股势力比较困难。于是，曹操就派人拿着他的书信去东吴，想和孙权联手消灭刘备。</p><p><br></p><p>东吴王孙权手下的谋士大都主张降曹自保，只有鲁肃主张联刘抗曹。但鲁肃自知难以说服孙权和东吴的文臣，特意请诸葛亮来当说客。鲁肃引诸葛亮见了东吴的一群谋士，这些人并非泛泛之辈，个个都是学富五车之人。东吴第一大谋士张昭首先发难，说：听说刘备到你家里三趟，才把你请出山，以为有了你就能够顺利夺取荆襄九郡做根据地。但荆襄已被曹操得到，你还有什么主意吗?</p><p><br></p><p>诸葛亮说：刘备取荆襄这块地盘，易如反掌，只是不忍心夺取同宗的基业，才被曹操捡了便宜。现在屯兵江夏，另有宏图大计，等闲之辈哪懂得这个。国家大事，社稷安危，需要有真才实学的人拿出好主意。而那些口舌之徒，碰上大事，却拿不出一个办法来，只能为天下人耻笑。</p><p><br></p><p>这一番话，说得张昭哑口无言。之后，另一个谋士步骘发难，他直接讽刺诸葛亮是苏秦张仪之流，是一个只会舌辨的谋士。诸葛亮没有辩驳，接住话锋说：“步骘先生以为张仪、苏秦是辩士，却大概还不知道他二人也是豪杰吧；苏秦佩挂六国相印，张仪两次为秦国宰相，都是匡扶国家的谋士，可不是那些畏强欺弱、怕刀怕枪的人所能比的。君等只听曹操虚发的假诈之词，就吓得想去投降，还竟好意思在这里笑话苏秦和张仪吗？”</p><p>这番话，让步骘也哑口无言。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/43606904279792275.jpg\"></p><p><br></p><p>东吴的谋士一个接一个地向诸葛亮发难，先后有七人之多，都被诸葛亮反驳得有口难辩。</p><p><br></p><p>诸葛亮之所以要“舌战群儒”，其实就是为了说服孙权联合刘备一起抗击曹操。为何他不直接说服孙权而不是先要说服群儒呢？原因很简单，每个国家的君王在下决定前都需要根据身边文臣谋士的建议来思考。事实上，当时在东吴的阵营中，对于曹操的百万雄兵压境，文臣武将有两派主张，即投降派和主战派。投降派的代表人物就是张昭等群儒，所以想要说服孙权必须先说服这些群儒。但要说服这些满腹经纶的人物，也决非是一件易事，可见诸葛亮的辩论实力!</p><p><br></p><p>舌战群儒指同很多人辩论，并驳倒对方。它强调的是胜利的结果。你和一群同学吵架那不叫舌战群儒，那是蛮不讲理。但如果你们正在针对一个观点激烈地讨论，并且你成功说服了在场的所有人，这就叫做舌战群儒。</p><p><br></p><p>接下来，我们要把诸葛亮的辩论技巧拆解开，让大家学习到“舌战群儒”的智慧与技巧。</p><p><br></p><p>第一个技巧是“<strong>先捧后摔，欲抑先扬</strong>”：</p><p><br></p><p>“群儒”中的张昭一上场，就先用三顾茅庐前的“自比管乐、如鱼得水”等事实将诸葛亮抬高，再列举诸葛亮跟了刘备后的种种败绩：诸葛亮你不是承认自己挺厉害的吗，为何刘备有了你以后地盘反而变小了呢？如果张昭碰上的是普通人，这“先捧后摔”一招肯定让对方哑口无言。但他遇到的是善于辩论的诸葛亮。</p><p><br></p><p>诸葛亮用了第二个技巧<strong>“降维打击</strong>”：</p><p><br></p><p>看过三体的小朋友一定知道“降维打击”的概念，即从更高的维度打击对方，让对方无还手之力。</p><p><br></p><p>面对张昭列举的事实，诸葛亮只是强调了自己的道德境界，说自己，不忍夺同宗之基业，战略上别有良图。这句话威力巨大！为何？因为中国人在传统上崇尚人格魅力，把个人的道德境界看得比能力还重要。</p><p><br></p><p>事实就是事实，越解释反而让人觉得心虚，实际上诸葛亮只是把事情的原因提高了一个层次，从能力上的不足提升到道德上的不忍。就这样对张昭进行了降维打击。</p><p><br></p><p>这样的例子非常多，比如苹果第四代智能手机iPhone 4面试的时候，出现了很多问题，无数果粉反应信号不稳定，电池耗电太快，纷纷投诉。这时候如果你是苹果的创始人你会怎么做？是和别人解释产品为何会信号不稳定，同时告诉大家你的解决办法吗？如果你这样做，别人会觉得你把一个次品，一个实验品卖给他们，他们会感受到不被尊重。</p><p><br></p><p>我们来看看苹果创始人乔布斯怎么做的？他什么都没解释，他只说了一句话：这世界上没有完美的人，同样也没有完美的产品，但我们一直在努力做到完美。</p><p><br></p><p>第三个技巧是，<strong>狠抓对方错误</strong>：</p><p><br></p><p>“孔明欲效仪、秦之舌，游说东吴耶?”步骘直接点出诸葛亮就是来忽悠江东免费抗曹的。但步骘用错了典故，苏秦张仪在历史上算是正面人物，想要黑诸葛亮还用错了人物。</p><p><br></p><p>所以诸葛亮抓住他这个错误直接攻击完胜，而绕过是不是来忽悠的问题。</p><p><br></p><p>最后，我们总结下，诸葛亮“舌战群儒”中涉及几个关键的辩论要点：</p><p><br></p><p><strong>第一，先捧后摔，让对方顺着你立的杆子往上爬。</strong></p><p><br></p><p><strong>第二，比不过能力事实就比道德境界。</strong></p><p><br></p><p><strong>第三，抓住对方言辞错误，以此开辟新的辩论点。</strong></p><p><br></p><p>你学到了吗？</p>', 'http://img.jssns.cn/SHILU/1/43606760859755149.png', 'http://img.jssns.cn/SHILU/1/f76f2d948ac6a96484156d2f7925a114.jpg', null, 'album', 'ID515539237269929986', '133', null, '2', '168', '2019-01-09 10:11:09', '432228697144033280', '2019-02-22 11:24:00');
INSERT INTO `audio` VALUES ('ID533605795837771776', '黄鹂太太的房子', 'http://img.jssns.cn/SHILU/1/6455be66b7d218565b5a99e3f1ea763a.mp3', '<p>黄鹂太太的房子</p><p><br></p><p>春天来到树林里，紫丁香开了一树美丽的花，黄鹂一家从南方飞了回来。</p><p><br></p><p>他们回乡的第一件事就是筑巢。黄鹂太太是位喜欢精致生活的女士，她不能忍受那种简简单单的树枝屋子。她跟丈夫说：“去找一点麻线、棉布来!马上干吧，时间不多了!”</p><p><br></p><p>黄鹂先生唱着歌儿飞走了。他要飞到人类聚居的地方，寻找那些建筑材料。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44844331951318368.jpg\"></p><p><br></p><p>一幢漂亮的农舍出现在眼前，黄鹂先生看到窗台上晾着一团红毛线，他兴奋地冲过去。</p><p><br></p><p>“哎哟!”黄鹂先生惨叫一声——院子里横着一根铁丝，他的翅膀挂到铁丝上，肌肉都撕裂了!&nbsp;</p><p><br></p><p>黄鹂先生忍着剧痛回到小树林。</p><p><br></p><p>黄鹂太太让黄鹂先生养伤，她亲自去找建筑材料。她以前没做过这么辛苦的工作。没过多久，她就相当疲惫了。</p><p><br></p><p>树林里还住着其他鸟。但黄鹂太太瞧不起所有的邻居，常常对丈夫说他们的“恶习”：“乌鸦那家伙，我从来没看到有鸟长得那么丑，还敢飞出来!啄木鸟太没教养，青丝雀……”</p><p><br></p><p>春天过了五分之一，但黄鹂太太只用麻线编出一个悬网。</p><p><br></p><p>邻居们注意到了这一切。</p><p><br></p><p>乌鸦飞来了，他把嘴里的几根树枝铺在网架上，“太太，请允许我帮您做一点力所能及的活儿。”随后，他又飞走了，衔来更多的树枝。</p><p><br></p><p>乌鸦的构架一搭好，珠颈斑鸠飞来了，他用最细小的树枝堵住房屋所有的缝隙。他向女邻居解释：“这样房屋会更结实。”</p><p><br></p><p>接下来，啄木鸟衔来大量的木屑，把所有的缝隙填平。他说：“就像人类用水泥浇灌砖墙一样，这样的房屋不透风雨。”</p><p><br></p><p>小巧的青丝雀也来了。他用最柔软的草茎把房间整体装修了一遍。</p><p><br></p><p>黄鹂太太惊呆了。多么漂亮的房子啊!她简直为以前的刻薄脸红了。</p><p><br></p><p>黄鹂先生激动地向她挥舞那只康复的翅膀，好像在说：“我真希望你能改改对邻居们的看法!”</p><p><br></p><p>从那以后，黄鹂太太常常邀请邻居们来她家吃茶点、开音乐会。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/43870027356752075.png', 'http://img.jssns.cn/SHILU/1/08bb4608492ea78314f766d6c923e5c8.jpg', null, 'album', 'ID515538987750785024', '123', null, '1', '432228697144033280', '2019-01-12 11:18:55', '168', '2019-01-28 09:57:34');
INSERT INTO `audio` VALUES ('ID533620189401448448', '狐狸买青草', 'http://img.jssns.cn/SHILU/1/d81a8d5466235e1cbe73c1840e135c65.mp3', '<p><br></p><p>狐狸买草记</p><p>&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;在人们的心中，狐狸是狡猾的。有一只可爱的狐狸叫可乐，它想以自己的实际行动改变人们对狐狸的看法。</p><p>&nbsp;</p><p>干什么好呢?可乐在床上思来想去，最后决定：去卖青草。</p><p>&nbsp;</p><p>第二天早上，可乐提着一大篮青草去挨家挨户的推销。它先敲开了兔子的家门。兔子刚打开门，一看是可乐，便以迅雷不及掩耳之势从屋子里拿出棍子，指着可乐叫道：“你你你……你别过来!小心我打你!”可乐指了指篮子中的青草，委屈的说：“我只是来卖青草的……”兔子二话不说，拿着棍子便向可乐打来。可乐来不及躲开，被打得浑身是伤。</p><p><br></p><p>&nbsp;<img src=\"http://img.jssns.cn/SHILU/1/43873454763394824.png\"></p><p><br></p><p>可乐拖着伤势敲开了山羊的家门。“吱啊——”一声，门开了。山羊把头探出来，一见是可乐，便低下头，用锋利的角向可乐撞来。可乐连忙爬上了最近的一棵树，大声地说：“山羊大哥，你要青草吗?”山羊一听，冷笑一声：“黄鼠狼给鸡拜年——没安好心。你想毒死我吧!”“绝对没……”可乐话还没说完，山羊就把门关了。可乐心想：难道大家对狐狸的态度都这样吗?</p><p>&nbsp;</p><p>无奈之下，他敲开了牛大哥的门。牛大哥一开门，就被吓了一跳，但很快镇定了下来：“你来干什么?”牛大哥警惕地问。可乐微笑着说：“牛大哥，你要青草吗?很新鲜的青草。”牛大哥这几天不舒服，吃什么都没胃口。他疑惑地看着狐狸。狐狸抓起一把青草，诚恳地说：“你看，都是我精心挑选过的，没有半点杂质。你可以尝一尝。”牛大哥半信半疑地接过青草，放到鼻子边闻了闻。一股清香直扑肺腑。他迫不及待地把草塞进嘴里，津津有味地嚼起来。“果然好吃!太好吃了，这些我全要了!”牛大哥兴奋地说。可乐一蹦三尺高，他心想：我终于成功了!</p><p>&nbsp;</p><p>后来，因为可乐卖的青草味道鲜美，价格便宜，一时间供不应求。狐狸成了森林中最大的企业家。大家对狐狸的看法彻底改变了……</p><p>&nbsp;</p><p><br></p>', 'http://img.jssns.cn/SHILU/1/43873458890798314.png', 'http://img.jssns.cn/SHILU/1/4736c6ad631a1a85f7b049a6eca26a3a.jpg', null, 'album', 'ID558316668967714816', '129', null, '1', '432228697144033280', '2019-01-12 12:16:07', '168', '2019-01-28 09:16:45');
INSERT INTO `audio` VALUES ('ID535153697299103744', '《江南》汉乐府', 'http://img.jssns.cn/SHILU/1/464161484191239dbe4585df3ec8def3.mp3', '<p><strong>江南&nbsp;汉乐府</strong></p><p><br></p><p>江南可采莲，莲叶何田田，鱼戏莲叶间。</p><p>鱼戏莲叶东，鱼戏莲叶西，鱼戏莲叶南，鱼戏莲叶北。</p><p><br></p><p><strong>注释</strong></p><p><br></p><p>何：多么</p><p>田田：莲叶长的茂盛相连的样子。</p><p><br></p><p><strong>译文</strong></p><p><br></p><p>江南水上可以采莲，莲叶多么茂盛，鱼儿在莲叶间嬉戏。</p><p><br></p><p>鱼在莲叶的东边游戏，鱼在莲叶的西边游戏，鱼在莲叶的的南边游戏，鱼在莲叶的北边游戏。</p><h2><br></h2><p><strong>赏析</strong></p><p><br></p><p>这是一首采莲歌，反映了采莲时的光景和采莲人欢乐的心情。在汉乐府民歌中具有独特的风味。</p><p><br></p><p>民歌以简洁明快的语言，回旋反复的音调，优美隽永的意境，清新明快的格调，勾勒了一幅明丽美妙的图画。一望无际的碧绿的荷叶，莲叶下自由自在、欢快戏耍的鱼儿，还有那水上划破荷塘的小船上采莲的壮男俊女的欢声笑语，悦耳的歌喉，多么秀丽的江南风光！多么宁静而又生动的场景！从文化学的角度，我们又会发现这是一首情歌，它隐含着青年男女相互嬉戏，追逐爱情的意思。你看那些鱼儿，在莲叶之间游来躲去，叫人怎能不想起北方的“大姑娘走进青纱帐”？</p><p><br></p><p>读完此诗，仿佛一股夏日的清新迎面扑来，想着就令人觉得清爽。还不止于此，我们感受着诗人那种安宁恬静的情怀的同时，自己的心情也随着变得轻松起来。</p><p><br></p><p>诗中没有一字是写人的，但是我们又仿佛如闻其声，如见其人，如临其境，感受到了一股勃勃生机的青春与活力，领略到了采莲人内心的欢乐和青年男女之间的欢愉和甜蜜。这就是这首民歌不朽的魅力所在。</p>', 'http://img.jssns.cn/SHILU/1/44239076099510625.png', 'http://img.jssns.cn/SHILU/1/04179b7484ea5aeb0d140fd0240e6bff.jpg', null, 'album', 'ID535147574781280256', '356', null, '0', '168', '2019-01-16 17:49:44', '168', '2019-01-31 18:18:24');
INSERT INTO `audio` VALUES ('ID535385304635277312', '《长歌行》汉乐府', 'http://img.jssns.cn/SHILU/1/88aa4334a46b55e93df9a839a8aecdd6.mp3', '<p><strong>长歌行 汉乐府</strong></p><p><br></p><p>青青园中葵，朝露待日晞。</p><p>阳春布德泽，万物生光辉。</p><p>常恐秋节至，焜黄华叶衰。</p><p>百川东到海，何时复西归？</p><p>少壮不努力，老大徒伤悲！</p><p>&nbsp;</p><p><strong>注释</strong></p><p><br></p><p><span style=\"color: rgb(230, 0, 0);\">“葵”</span>是一种蔬菜。朝露表示清晨的露水。</p><p><span style=\"color: rgb(230, 0, 0);\">“晞”</span>表示天亮，引申为阳光照耀。</p><p><span style=\"color: rgb(230, 0, 0);\">“阳”</span>表示温和，</p><p><span style=\"color: rgb(230, 0, 0);\">“布”</span>表示给予，</p><p><span style=\"color: rgb(230, 0, 0);\">“德泽”</span>表示恩惠。</p><p><span style=\"color: rgb(246, 12, 12);\">焜黄</span>，形容草木凋落枯黄的样子。</p><p><span style=\"color: rgb(230, 0, 0);\">“华</span>”同<span style=\"color: rgb(230, 0, 0);\">“花”</span>，表示花儿。</p><p><span style=\"color: rgb(230, 0, 0);\">“衰”</span>读<span style=\"color: rgb(246, 12, 12);\">“cuī”</span>，因为古时候没有“shuāi”这个音；</p><p><span style=\"color: rgb(230, 0, 0);\">少壮</span>，年轻力壮，指青少年时代。</p><p><span style=\"color: rgb(230, 0, 0);\">老大</span>指年老了，到老了。</p><p><span style=\"color: rgb(230, 0, 0);\">“徒”</span>表示白白地。</p><p><br></p><p><strong>译文</strong></p><p><br></p><p>园中的葵菜都郁郁葱葱，晶莹的朝露阳光下飞升。春天把希望洒满了大地，万物呈现出一派繁荣景象。百川奔腾着东流到大海，何时才能重新返回西境？少年人如果不及时努力，到老来只能是悔恨一生。</p><p><br></p><p><strong>赏析</strong></p><p><br></p><p>这是一首咏叹人生的诗。这首诗<strong>借物言理</strong>，首先以园中的葵菜作比喻。“青青”意味着它生长茂盛，活力十足。不仅如此，在整个春天的阳光雨露之下，万物都在争相努力地生长。仿佛，它们知道春天来了秋天也就不远了，而秋天是万物凋零的凄惨时节。接着作者用水流到海不复回打比方，说明光阴如流水，一去不再回。</p><p><br></p><p>大自然的生命节奏如此，人生也是这样。一个人如果不趁着大好时光而努力奋斗，让青春白白地浪费，等到年老时后悔也来不及了。<strong>这首诗由眼前青春美景想到人生易逝，鼓励青年人要珍惜时光，出言警策，催人奋起。</strong></p>', 'http://img.jssns.cn/SHILU/1/44294295636267726.png', 'http://img.jssns.cn/SHILU/1/f1f49e653b22f07d0e9b29c5e69b2fa7.jpg', null, 'album', 'ID535147574781280256', '242', null, '1', '168', '2019-01-17 09:10:03', '168', '2019-01-31 18:19:02');
INSERT INTO `audio` VALUES ('ID535777043741147136', '【杯弓蛇影】如何才能不被表象迷惑？', 'http://img.jssns.cn/SHILU/1/0ec1f2808218ae4751d87c4ac6f9494c.mp3', '<h2><strong>杯弓蛇影</strong></h2><p><br></p><p>晋朝有一个叫乐广的人，他非常喜欢结交朋友，并经常请朋友到家里喝酒聊天。一天，乐广做了一桌好菜宴请了很多好友来家里，大家猜拳作乐，把酒言欢，异常热闹。</p><p><br></p><p>此时，一位客人正要举杯痛饮，可无意中居然发现酒杯中好像有一条游动的小蛇。顿时，他的双手开始发抖，口唇发白，可碍于情面，他硬着头皮把酒喝下了。喝罢，这位客人没有和乐广说明原因就告辞离开了。这让乐广感到非常纳闷～</p><p><br></p><p>过了好几天，乐广一直没有再见到这位朋友。乐广很想念他，于是决定亲自登门去看他。谁知这位朋友已经病了好几天了，而且病得很厉害。乐广好奇地问：“前几天喝酒的时候，你不是还好好的，怎么一下子就病得这么厉害了呢？”</p><p><br></p><p>刚开始这位朋友支支吾吾什么也不说，后来在乐广的再三追问下，这位朋友才说出实情：“那天你盛情招待我，本来大家喝得很高兴。我喝了几杯以后，突然发现我的酒杯里有一条蛇，而且还慢慢地蠕动。我当时感到很害怕，也觉得很恶心。但你的盛情难却，所以我勉强喝了那杯酒，然后就离开了。回到家里以后，我感到全身都不舒服，总觉得肚子里有一条小蛇。就这样，我一病不起了。”</p><p><br></p><p>为了能帮助这位“患病”的好友，乐广决定要搞清楚“这条小蛇”的来历，他想了很久，终于记起他家墙上挂有一张弯弓，他猜测这位朋友所说的蛇一定是倒映在酒杯中的弓影，于是，他再次把客人请到家中，邀朋友举杯，那人刚举起杯子，墙上弯弓的影子又映入杯中，宛如一条游动的小蛇，他惊得目瞪口呆。</p><p><br></p><p>就在这时，乐广指着墙上挂着的弓，说：“都是它在作怪，杯中的蛇是这张弓的影子！”随后，乐广把弓从墙上取下来，杯中小蛇果然消失了。这位朋友恍然大悟，他如释重负地说：“噢，原来是这样啊，杯中的蛇竟然是墙上的弓的影子！”就这样，压在他朋友心中的石头终于被搬掉了，他的病也慢慢康复了。</p><p><br></p><p><img src=\"http://img.xiumi.us/xmi/ua/1qX6m/i/b83a3c28abaf0e6065167ec0cd9e8718-sz_113533.png\"></p><p><br></p><p><strong>杯弓蛇影，</strong>比喻疑神疑鬼，自相惊扰，虚惊一场。</p><p><br></p><p>乐广的朋友被假象所迷惑，疑神疑鬼，差点儿还为此送了命。这不禁让我想起了一个真实的故事：<strong>200年前的印第安人部落里</strong>，一个年轻人不小心得罪了部落最具影响力的巫师，巫师随即诅咒他很快将死于诅咒。年轻人当即被吓住了，觉得自己注定要因诅咒而死。于是他茶不思饭不想，连睡觉都睡不好，看到任何奇怪的事情都觉得是来要他命的。就这样，不到5个月，这位年轻人真的死掉了！但这并不是因为巫师的诅咒，而是他自己把自己给吓死了。</p><p>&nbsp;</p><p><br></p><p><strong>那么到底如何才能摆脱 “杯弓蛇影”式的幻象呢？</strong></p><p><br></p><p><strong>方法很简单，就是深度思考，找到事情发生的原因</strong>。故事里的乐广喜欢追根问底，注重调查研究，终于揭开了“杯弓蛇影”这个谜。同样，<strong>在生活中我们无论遇到什么问题，都要问一个为什么，都要通过调查研究去努力弄清事情的真相，而不是盲目相信权威。</strong>如果那个可怜的印第安人能认真思考下“巫师的诅咒真的存在吗？”，去研究他过去诅咒的案例，哪些灵验了哪些失效了。哪些灵验的诅咒背后的原因又是什么？这样的话，他就不可能被自己给吓死了。</p><p><br></p><p>小智希望你也会是个不被表象迷惑，勇于探索真理的孩子！</p>', 'http://img.jssns.cn/SHILU/1/44387693160926724.png', 'http://img.jssns.cn/SHILU/1/ee0d42aaaf6cfd6c2161bf466da0eb8c.jpg', null, 'album', 'ID515539237269929986', '118', null, '3', '168', '2019-01-18 11:06:41', '432228697144033280', '2019-02-22 11:24:22');
INSERT INTO `audio` VALUES ('ID536928804895981568', '青蛙大侠', 'http://img.jssns.cn/SHILU/1/3abee277918a295bf2561d136f7d8052.mp3', '<p>青蛙大侠</p><p><br></p><p>田边住着一群可爱的小青蛙，大大的眼睛宽宽的嘴巴，身上披着绿衣裳，跳上跳下呱呱呱，伸出长舌把虫抓，农民伯伯好喜欢，伸出拇指把它们夸：＂青蛙青蛙好大侠，保护庄稼顶呱呱！＂</p><p><br></p><p>青蛙大侠好威风呀，每天忙着在田里巡逻。“哎哟！哎哟！谁在哭？” 青蛙大侠赶忙侦察，发现前面有一群蝼蛄、蝗虫、螟虫、金花虫，正大口大口吃庄稼。青蛙大侠很是生气，伸出长长的舌头想要抓他们，害虫吓得四处逃跑，青蛙大侠紧追不舍。就这样，一只青蛙一天就消灭七十多条害虫，害虫们一见青蛙就发抖，再也不敢出来害庄稼。庄稼乐得笑哈哈，一笑开了花，结了果，农民高兴地对青蛙大侠说道：“谢谢你！青蛙好大侠，今年又是丰收年呀！”</p><p><br></p><p>青蛙大侠高高兴兴的，精神抖擞的忙着廵逻去了。突然有几个背着鱼篓的坏小子，悄悄地潜到水田边，一见青蛙就伸手抓。“呱—呱—呱—”，田里响起了青蛙大侠痛苦的叫声。一只青蛙大侠跳起来大声问：“我们正在巡逻捉害虫，你们为什么把我们抓？”</p><p><br></p><p>他们听了哈哈笑：“青蛙，青蛙别生气，谁叫你们的肉质鲜美呢。”说完一把抓住青蛙，折断了他的腿，青蛙大侠好生气，张大嘴巴就使劲咬，“哎哟！”坏小子这才松了手，青蛙大侠赶忙跳进洞里躲起来。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44844620475593045.jpg\"></p><p><br></p><p>过了一会儿，田里变得静悄悄。一只蝼蛄看见了，高兴起来大声喊到：“蝗虫、螟虫、金花虫，快快出来吃庄稼。”害虫一听可开心，全飞出来大口大口吃庄稼。庄稼疼得直呼救：“青蛙大侠，青蛙大侠，快来救救我们吧！”躲在洞里的青蛙大侠使劲往外爬，可是它的腿被折断了，跳不起来捉害虫了。害虫们嘲笑到。“青蛙青蛙别神气，看人们把你们全捉光。”“哎哟！哎哟！哎哟哟！” 庄稼被害虫吃得一片一片倒下了，眼看就要被吃光。“害虫快住嘴，。”害虫一听就发抖，来不及逃跑，就被赶来的青蛙大侠全捉光了。洞里受伤的青蛙好奇怪：“你们不是被坏小子捉走了吗？” 青蛙大侠高兴的说：“捉我们的坏小子遇到了警察叔叔全被抓，警察叔叔立刻开车把我们送回来。看，还给你请来了医生治腿伤！”</p><p><br></p><p>青蛙的腿伤治好了，警察又在田里竖起了大木牌：“青蛙大侠顶呱呱，专捉害虫保庄稼，大家都来保护它！” 青蛙大侠好高兴呀，跳上跳下呱呱呱的叫着。害虫听了更害怕了，再也不敢出来害庄稼啦。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/44662294969005968.png', 'http://img.jssns.cn/SHILU/1/9ab461f6e582a84a5205c4d11825dfd3.jpg', null, 'album', 'ID558316172307595264', '114', null, '1', '168', '2019-01-21 15:23:22', '168', '2019-01-28 09:17:28');
INSERT INTO `audio` VALUES ('ID536931748764712960', '小蜜蜂与花儿', 'http://img.jssns.cn/SHILU/1/842874a909ea307d6e4293836de2c588.mp3', '<p>小蜜蜂与花儿</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;在地球的某一个角落，孤零零地开着一朵美丽的小花。它的身边虽然有绿叶相伴，但它总觉得那些叶子对她好像有敌意，所以它虽然有点闷，可也不愿意主动找它们聊天。后来有一天，飞来一只小蜜蜂，小蜜蜂在它身边忙来忙去，顺便跟它聊聊天，讲他知道的各种稀奇古怪事，讲蜜蜂群体中严格的的分工，讲蚂蚁王国之间的惊心动魄的大战，讲他遇到的各种各样的花儿.....小蜜蜂讲得绘声绘色，小花儿大开眼界，觉得世界好奇妙，觉得生活比以前幸福多了。即使小蜜蜂不与它说话，它看着他在自己身边也觉得幸福。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;小蜜蜂每天早上来，下午回去。有一天，小花忍不住对小蜜蜂说：\"能不能永远不离开我，陪我聊聊天解解闷？我好害怕孤独。\"</p><p><br></p><p>小蜜蜂笑了：\"行啊，只要你永远 这么样开着，源源不断的产生花蜜，我就永远陪着你。今天我该收工了，明天见。\"</p><p><br></p><p>小蜜蜂走后，花儿深深陷入苦苦思索之中：怎么样才能永不衰败？</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44844208723843995.jpg\"></p><p><br></p><p>第二天一大早，小蜜蜂又来了，他一见那花儿不禁大吃一惊：那花竟然已经谢了，就剩最后一口气在了。</p><p><br></p><p>花儿一见到小蜜蜂，便挣扎起来，急切地问：\"你终于来了，快教教我，怎么样才能永葆青春？\"</p><p><br></p><p>小蜜蜂一阵心酸：\"傻孩子，我是跟你开玩笑的，有生就有灭，哪有什么永恒！你怎么能当真呢？\"</p><p><br></p><p>花儿眼里的光芒又黯淡下去：\"那我死后还有没有知觉？还能不能再遇到你？\"</p><p><br></p><p>小蜜蜂刚想说：\"这我也不知道。\"可一看到花儿那哀婉忧伤的样子，又一阵的辛酸涌上心头。便改口说：\"也许吧，也许花魂是不灭的，生命是轮回不已的。你以后可能会变成一朵更漂亮的花呢。\"</p><p><br></p><p>花儿眼睛又亮起来：\"那你可要记得去找我奥，我等着你来。\"小蜜蜂用力点了点头，已经说不出话来。花儿露出最后一丝微笑，彻底死了。</p><p><br></p><p>小蜜蜂伤心了半天，又自责了半天。\"然而我现在必须去寻找另一朵花了。\"他翅膀一振，飞入前方茫茫花丛之中。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/44662996128458747.png', 'http://img.jssns.cn/SHILU/1/12b7063f18294f8230f8a5037b70ec77.jpg', null, 'album', 'ID558316172307595264', '122', null, '0', '168', '2019-01-21 15:35:04', '168', '2019-01-28 09:12:14');
INSERT INTO `audio` VALUES ('ID537561196815974400', '该怎么和孩子解释死亡？', 'http://img.jssns.cn/SHILU/1/c89812144b73d25075fc6a213592e75e.mp3', '<p>该怎么和孩子解释死亡？</p><p><br></p><p>当孩子问你<strong>“人为何会死？死亡是不是很痛苦？”</strong>的时候，你该怎么回答？</p><p><br></p><p>当孩子问你“<strong>世界上为什么有那么多神话故事？</strong>”的时候，你该怎么和他讨论？</p><p><br></p><p>当孩子问你<strong>“小草能不能感受到痛苦？小狗会不会感受到伤心？”</strong>的时候，你又该如何和他解释？</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45009245920051032.jpg\"></p><p><br></p><p>这些直达生命、生活和世界本质的问题常常是孩子最爱问的问题，因为每个孩子天生就是哲学家：美国哈佛大学的认知科学家们开始审慎地探究儿童对想象和虚构的理解，他们研究发现 ，甚至是两三岁的孩子也能够很好地区分现实与想象、真实与虚构 。只不过学前儿童大部分时间都在假装而已&nbsp;，但他们知道自己是在假装 。</p><p><br></p><p>既然孩子天生就是个哲学家，那么哲学家的问题我们大人该怎么回答呢？这是个非常让人头疼的问题。</p><p>&nbsp;</p><p>这一期《给孩子的趣味哲学课》的主题就是<strong>“生与死”</strong>，我们会谈论生命的起源，讨论不同生命的价值，讨论生命的意义，讨论为何每个人都会死亡，讨论我们死后我们的亲人会怎么样，讨论死亡的意义......</p><p>&nbsp;</p><p><strong>这系列课程不仅适合6~18岁的孩子听，更适合我们家长自己聆听。</strong>想想看，因为工作、应酬和孩子的教育忙得焦头烂额的您，每天有多少时间来思考这些有意义的问题，当孩子问你的时候，你也能给孩子苏格拉底式的提问，和孩子一起讨论有价值的哲学问题，让自己的思想格局和孩子一起成长！</p>', 'http://img.jssns.cn/SHILU/1/44813068799616571.png', 'http://img.jssns.cn/SHILU/1/da45e8c5ad22bbf1c164132d2686d639.jpg', null, 'album', 'ID515536344454266882', '137', null, '0', '168', '2019-01-23 09:16:16', '168', '2019-01-26 10:26:21');
INSERT INTO `audio` VALUES ('ID537650488993120256', '最初的生命来自于哪里？', 'http://img.jssns.cn/SHILU/1/dad934c484623c5e3d7fd2b5e0d2356b.mp3', '<p>&nbsp;最初的生命来自于哪里？</p><p><br></p><p>你有没有好奇，我们人类是有生命的，小狗也有生命，那公园里的小草有生命吗？天上的星星有生命吗？河边的岩石有生命吗？</p><p>&nbsp;</p><p>事实上, <strong>我们知道当一个物体吸取养分的时候, 它就是活着的, 就有生命:</strong> 一朵沐浴在阳光和雨水中的鲜花, 靠着水、 空气和阳光里的养分, 不断生长开放。</p><p><br></p><p>另外, 当一个物体能进行自我繁殖的时候, 也就是说当它能够创造出其他生命的时候, 也说明它是活的。 而一块石头却永远不能繁殖出别的石头来。</p><p>&nbsp;</p><p>借助花粉在空中漫舞和蜜蜂的辛勤劳动,一片片雏菊在田野上随风摇曳、生长繁殖。在我们居住的星球上, 存在着几十亿种生命, 真是数不胜数。 我们怎能数得清所有的草木、 贝壳、 蜘蛛、 柳树、 海藻、 鸟鸦、 三文鱼、 蚯蚓和人类呢?</p><p><br></p><p>我们的地球，是一个生命共同体，它不仅是人类的世界, 而且也是海藻、 花草、 树木、 苍蝇、老鼠、 蛇、狮子与狗的世界。</p><p><br></p><p>&nbsp;<img src=\"http://img.jssns.cn/SHILU/1/45010712793947724.jpg\"></p><p><br></p><p><strong>那么最初的生命来自哪里呢？</strong></p><p><br></p><p>地球上最早出现的生命极其微小，微小到只有在高倍放大镜下才能看到它们。人们把这些微小的生命叫作细胞。 其中有些细胞经重新结合, 演变成海藻、 植物等等。 后来又有一些细胞聚合演变成小动物, 或者更大一点儿的动物比如鱼类。然后出现了恐龙，再后来又有了猴子。</p><p>&nbsp;</p><p>有些猴子学会了直立行走, 不再像以前那样用四肢爬行。这样一来,它们的视野更开阔了, 狩猎也从此变得更容易了。</p><p>&nbsp;</p><p>由于前肢不再用于行走, 它们就可以用来做别的事情。为了提高狩猎的成功率，这些猴子们学会了制造工具。做这样的事情,需要不断思考,这又使它们变得越来越聪明。</p><p>&nbsp;</p><p>经过不断的进化和演变, 它们终于变成了今天的人类。这是一个极其漫长的进化过程, 经历了千百万年的时间。</p><p><br></p><p>由此可见，人类的生命如同鱼类、 蛇类、 鸟类、花类一样, 起初都是来自同一种微小细胞。<strong>所以，从生命起源的角度去看，所有生命都是平等的~</strong></p>', 'http://img.jssns.cn/SHILU/1/44834357661469098.png', 'http://img.jssns.cn/SHILU/1/2520ce0711387b96be637acc4e9c2b89.jpg', null, 'album', 'ID515536344454266882', '137', null, '0', '168', '2019-01-23 15:11:05', '168', '2019-01-26 10:27:30');
INSERT INTO `audio` VALUES ('ID537651492618764288', '什么是食物链？', 'http://img.jssns.cn/SHILU/1/06232ad4dd050f4218fee7945f5eb9ff.mp3', '<p>今天一大早，小智和他的同学阿信到他们村子附近的果园里<strong>摘</strong>苹果，现在<strong>正是</strong>采摘苹果的好时节。不到两个小时，他们就<strong>采到</strong>了一百多个苹果。一个苹果可以买1块钱，这么多苹果可以卖很多钱，这些钱足够小智和阿信去游乐园玩好几圈电动碰碰车了。</p><p><br></p><p>这个故事说完了，你是不是觉得这个故事毫无意义。因为它一点都不有趣，也根本不好笑。我们什么也学不到，更不能引发我们的好奇心，甚至一点都不吓人。</p><p>然而，这是一个关于死亡的惊悚故事。不信，我们换几个词语来看看：</p><p><br></p><p>今天一大早，小智和他的同学阿信到他们村子附近的果园里<strong>屠杀</strong>苹果，现在正是<strong>屠杀</strong>苹果的好时节。不到两个小时，他们就<strong>屠杀</strong>了一百多个苹果。一个苹果可以买1块钱，这么多苹果可以卖很多钱，这些钱足够小智和阿信去游乐园玩好几圈电动碰碰车了。</p><p><br></p><p>看看，我们只要把故事里的“采摘”换成“屠杀”就能让这个小故事变得非常吓人。</p><p><br></p><p>事实上，<strong>苹果是有生命的</strong>：它们吸取养分，繁殖出新的苹果。当人们为了食用而把它们从树上采摘起来的时候，它们真的就死去了。但是，小智和阿信并不是罪犯：很简单，为了活着，人们需要吃饭。所有的生物都以其他的生物为生，也就是说靠杀死别的生物来充饥。这就是食物链。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45012217715070808.png\"></p><p><br></p><p><strong>那什么是食物链呢？</strong></p><p><br></p><p>悦悦觉得屠宰奶牛是极其残忍的。每当她的弟弟吃牛排，她就把他视为杀人犯，尤其是当她看到牛肉的血水滴在弟弟的菜盘中的时候。而她呢，总是拿几块面包片，放一些生菜、几段黄瓜、一点奶酪和沙拉酱，她觉得这样吃很可口。可她的弟弟却嘲笑她。他才不在乎悦悦那些悲惨的奶牛故事呢？</p><p><br></p><p>听完了这个小故事，你觉得悦悦这样做就不会伤害生命了吗？实际上，为了制作这些悦悦喜爱的面包片，我们也使用了有生命的东西：做面包，必须有麦子。麦穗在地里的时候还是活的，但是被做成面包后就死了。因为有人将它们拾起、碾碎，做成了面粉。沙拉酱里有鸡蛋，可能还是能孵出小鸡的鸡蛋呢！<strong>而番茄和黄瓜都是有生命的东西。</strong>此外，为了生产奶酪，需要牛奶，为了产奶，奶牛则需要吃草，而青草也是有生命的......</p><p><br></p><p>由此可见，每个生物总是以别的生物为生：鳄鱼吃青蛙，青蛙吃蛐蛐儿，蛐蛐吃蚊子，蚊子则吸食其他动物或者人类的血液。</p><p><br></p><p>悦悦当然有权利喜爱吃面包而拒绝吃肉，对她来说，一头奶牛的生命比麦子的更重要。</p><p>可真的是这样吗？</p>', 'http://img.jssns.cn/SHILU/1/44834596404562144.png', 'http://img.jssns.cn/SHILU/1/383a44fc11c2a768112934b2343baebc.jpg', null, 'album', 'ID515536344454266882', '124', null, '0', '168', '2019-01-23 15:15:04', '168', '2019-01-26 10:29:27');
INSERT INTO `audio` VALUES ('ID537656827878309888', '自己收拾东西', 'http://img.jssns.cn/SHILU/1/445cc1cceb1572773a95a434365c8c50.mp3', '<p>自己收拾东西</p><p><br></p><p>乐嘟嘟是全家的宝贝，外公外婆，爷爷奶奶，姑姑舅舅，当然还有爸爸妈妈，都喜欢给乐嘟嘟买玩具。所以乐嘟嘟的玩具很多很多，他的小房间，从书桌到地面，再到床上，到处堆满了玩具。</p><p><br></p><p>大前天，小姨从外地回来，又给乐嘟嘟带了个挺仿真的“动物之家”。那是一个半米来高半米来宽的小房子，房顶是茅草做的，屋子里面的四壁粘满了墨绿色的干绿苔，毛茸茸的。最好玩的是，屋子里还端坐着四只小动物，小动物耳朵尾巴软绵绵的，像美丽的绸缎子一样，还有那晶亮晶亮的眼睛，仿佛会说话。乐嘟嘟稍微用力捏一下他们的手脚，小动物就会发出叫声：“嘿，朋友!”“嘿，朋友!”</p><p><br></p><p>乐嘟嘟喜欢这个动物小屋，他把朋友们叫过来，一群人在他的小房里玩了一个下午。直到乐嘟嘟妈妈下班回来，大家才知道，要回家吃饭去。</p><p><br></p><p>朋友们回家了，乐嘟嘟还是舍不得离开他的动物小屋。妈妈叫他吃饭，他磨蹭很久还不出房门。直到妈妈把饭菜都摆好了，乐嘟嘟还不见人影。</p><p><br></p><p>没办法，乐嘟嘟的妈妈只好推开乐嘟嘟的小房门，天啊，里面到处都是玩具，书桌摆了一大堆积木，还有不少散在地上。地板上堆的都是火车，轨道，蜡笔，颜料，图画本，小人书，小皮球……完全插不进脚去。乐嘟嘟也不见人影。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44843423608463279.jpg\"></p><p><br></p><p>“天，这哪是房间，是猪窝!”妈妈挺生气，“乐嘟嘟，你在哪呢，你给我出来!”</p><p><br></p><p>“妈妈，我还在玩呢!”乐嘟嘟趴在“动物小屋”门口，头完全伸进了小房的茅草顶下，小屁股露在屋外，正撅得老高。</p><p><br></p><p>“你给我出来!”妈妈一把揪出乐嘟嘟，把他往地上一放。只听一片“嗤嗤——嚓嚓——”的声音。啊，什么被踩破了!</p><p><br></p><p>乐嘟嘟爬起来一看，哎哟，他挺喜欢的赛车轨道，运煤列车被压成了几截!</p><p><br></p><p>妈妈也心疼起来：“你看看你，房间里乱得像什么!玩好的玩具，乱七八糟，都堆在这，也不收进玩具筐!算了算了，我拿个扫把来，把你这些玩意儿全扫到垃圾桶去!”</p><p><br></p><p>乐嘟嘟很怕妈妈这一手，他赶紧开始收拾：“妈妈别扔我的玩具，我会自己捡进玩具筐的。”</p><p><br></p><p>可是，房间里东西太多了，乐嘟嘟心急慌忙，左手抱一堆，右手提一提，一不留神，一个玩具锤子和小皮球没抱牢，哗的掉了下来。不偏不倚，正好砸在“动物小屋”的茅草顶上，“动物小屋”被砸穿了一个大洞，屋顶上的茅草撒了一地。一只小狗被打出来，掉到颜料盒里，还在“嘿，朋友，嘿，朋友!”地叫唤。</p><p><br></p><p>乐嘟嘟一屁股坐在地上，心疼得“哇哇”大哭起来。</p><p>“怎么了这是?”妈妈连忙跑过来。乐嘟嘟指着“动物小屋”，难过得说不出话来。</p><p><br></p><p>“一屋不扫，何以扫天下!”妈妈叹着气，说了句文绉绉的话。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/44835995716776110.png', 'http://img.jssns.cn/SHILU/1/9b38f450e1e7cd1ec84ece1ff60b12d5.jpg', null, 'album', 'ID558313010574131200', '118', null, '0', '168', '2019-01-23 15:36:16', '168', '2019-01-28 09:13:07');
INSERT INTO `audio` VALUES ('ID537657125153800192', '小野猪和妈妈', 'http://img.jssns.cn/SHILU/1/2fc8e78879b2d3f2bbcbcb9a2504f643.mp3', '<p>小野猪和妈妈</p><p><br></p><p>小野猪身上长满了疮。“哟，臭啊！臭啊！”小伙伴们躲得远远的，都不跟它玩了。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44843933849566412.jpg\"></p><p><br></p><p>野猪妈妈急坏了，忙去找医生，河马大夫说：“翻过三座大山，有一眼神奇的泉水，你带小野猪去洗洗吧，一天洗一次，一定要洗三个十天。”</p><p><br></p><p>野猪妈妈带着小野猪出发了，山路又陡又难走，只一会儿，小野猪就“哼哼唧唧”走不动了。怎么办呢？河马大夫说小野猪的疮是会传染的，野猪妈妈还是让小野猪趴在它的背上，背着走。</p><p><br></p><p>太阳照在山路上，小野猪出汗了，小野猪的汗水和脓水“滴滴答答”流在野猪妈妈身上；野猪妈妈的汗水出得更多，“滴滴答答”流在山路上。一直走到太阳躲到树梢头，它们才看见那眼神奇的泉水。</p><p><br></p><p>泉水很细，“丁丁冬冬”流成了一个小小的水潭。野猪妈妈把小野猪放在泉水里，轻轻洗它身上的疮。泉水清凉凉，小野猪舒服极了，一会儿“呼噜呼噜”睡着了。野猪妈妈出了一身汗，小野猪的脓水又流在它身上，浑身难受极了，也很想在泉水里洗一洗，可是水潭很小，每次只能洗一个。野猪妈妈看见小野猪甜甜地打着呼噜，实在不忍心叫醒它。</p><p><br></p><p>太阳快要落山了，野猪妈妈背起干干净净的小野猪回家去。“呀，妈妈身上真臭！”小野猪捂着鼻子说，野猪妈妈就在路边摘了朵香花让小野猪嗅，又在自己背上遮了几片大叶子。小野猪闻不到妈妈身上的气味了，“啦啦啦”唱起了歌。野猪妈妈吃力地走在山路上，心里可高兴了。</p><p><br></p><p>一天又一天，不管刮风下雨，不管烈日高照，野猪妈妈都“吭哧吭哧”地背着小野猪翻山越岭去洗神奇的泉水。小野猪的疮全好了，白白胖胖，干干净净。可野猪妈妈却累病了，小野猪的疮也传染给了妈妈。小野猪渐渐地发现妈妈又瘦又老，背也弯了，身上布满了生过疮的一个个疤痕。小野猪一下子扑到妈妈怀里，“呜呜呜” 哭了起来。</p><p><br></p><p>小野猪扶着妈妈去洗神奇的泉水，它把妈妈手中的拐棍扔得远远的，“妈妈，从明天起，让我当你的拐棍吧！”</p><p>“可是，妈妈身上臭啊，还要走很远很远的路。”</p><p><br></p><p>“不嘛，不嘛，就要陪妈妈，我要天天陪妈妈。”</p><p><br></p><p>小野猪搀着妈妈，一步一步稳稳地走在山路上。林子里静悄悄的，银色的月光洒在山路上，洒在小野猪和它妈妈的身上。</p><p>&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/44835939337397941.png', 'http://img.jssns.cn/SHILU/1/e28e2b3576d9a933a57441571b4ee5f7.jpg', null, 'album', 'ID515538987750785024', '113', null, '0', '168', '2019-01-23 15:37:27', '168', '2019-01-28 09:13:55');
INSERT INTO `audio` VALUES ('ID537922955988959232', '【愚公移山】有志者，未必事竟成！', 'http://img.jssns.cn/SHILU/1/5114cbfb9b22c1529dcfbd61848ece28.mp3', '<h2><strong>愚公移山</strong></h2><p><br></p><p><span style=\"color: rgb(246, 12, 12);\">儿</span>：“爸爸，你在干嘛呀？”</p><p><br></p><p><span style=\"color: rgb(95, 156, 239);\">愚公</span>：“来来来，好孩子！我们一起合作，把挡在门口的这两座山移开，这样就再也不用绕好远好远的路出门了，你们觉得好不好呢?”</p><p><br></p><p><span style=\"color: rgb(246, 12, 12);\">儿</span>：“好呀！好呀！”</p><p><br></p><p><span style=\"color: rgb(255, 129, 36);\">妻子</span>：“这怎么可能！你连搬一块土丘的力气都没有，还想搬走大山？！退一万步来说，就算你搬得动，那些挖出来的泥土石块，你要扔到什么地方去呢?”</p><p><br></p><p><span style=\"color: rgb(95, 156, 239);\">愚公</span>：“哈哈哈哈，你就不懂了吧！这哪有什么困难的！我们可以丢到海里面去呀！”</p><p><br></p><p>第二天开始，愚公与儿子、孙子，三个人一起扛着锄头，挑着扁担，到山边开始挖。愚公的邻居，也兴致勃勃地帮愚公一起来移山。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44899808982286423.png\"></p><p><br></p><p>这时候，有一个叫作智叟的老先生，忍不住嘲笑他们说：“愚公呀！你实在太糊涂了。你都这么老了，还要去移什么山啊？就算搬到你死的那一天，也不可能把大山移开来的！”</p><p><br></p><p>愚公听了他的话，笑笑说：“智叟，你才糊涂呢！我虽然很老，但我的儿子可以继续去搬呀；儿子还会生孙子，孙子还会再生儿子，我们的子子孙孙可以一直搬下去，只要我们搬掉山的一层，就少一层，总有一天我们会把这两座山搬走，天底下哪儿有不能克服的困难呢？”智叟被愚公的决心震撼到说不出话来，只好走开了。</p><p><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/44899825347503317.jpg\"></p><p><br></p><p>后来，山神和海神知道愚公要移山的事情，害怕愚公一家人永不停止的搬下去，会把山搬光，把海填满，就跑去告诉天神，天神一听：“嗯！这个愚公真是有恒心呀！我来帮帮他吧！“天神就派了两个神仙去把王屋山与太行山背走，放到别的地方去，不再挡在愚公家门口了。</p><p><br></p><p>从此以后，我们就用“愚公移山”来<strong>比喻做事有十分坚强的毅力和不怕困难不怕牺牲的精神。</strong></p><p><br></p><p>记得之前呀，婷婷老师看到有人这样评论《愚公移山》：<strong>我觉得愚公是真的愚。听不进去任何人的话，一意孤行，不仅要自己搬，还要让自己的子孙都来移山，而且就算好长时间以后终于移走了山，又有什么意义呢？要是没有天神的帮忙，不知道这个愚公的子子孙孙要在这件无意义的事情上浪费多少时间！</strong></p><p><br></p><p>小朋友们，你们怎么看？</p><p><br></p><p>其实呀，“愚公移山”这个成语本来并没有“坚持不懈、人定胜天”的寓意，这些都是<strong>后人断章取义添加上去的</strong>。在这个信息爆炸的时代，为了搞清楚一则新闻的真假，我们需要回到新闻发生的地方去。这次，婷婷老师邀请你和我一起去到“愚公移山”这个故事的源头，看看它真正的含义是什么？</p><p><br></p><p>愚公移山是<strong>道家经典《列子》第五卷《汤问》里的一段话</strong>，而《汤问》这篇文，通篇都是道家哲学思想，压根和“坚持不懈”没有一丁点关系。</p><p><br></p><p>愚公这一段的上文是这样，商汤问夏革：事物的大小，长短和同异是如何体现的？夏革针对每个问题都单独举了例子。</p><p><br></p><p>传说龙伯国人钓走了驮着海外仙岛的大鳌，造员峤和岱舆两座仙山沉没于大海，亿万仙人流离失所。对比之下，僬侥国的矮人则显得渺小得多，<strong>这充分说明了事物的大小差异。</strong></p><p><br></p><p>又传说存在以五百岁为一季的冥灵和以八千岁为一季的大精树，对比之下，那些白天出生晚上死亡的菌芝的生命长度则显得微不足道。<strong>这说明时间的长短之别。</strong></p><p><br></p><p>又传说有一种大鸟叫鹏，它是天空的霸主；有一种鱼叫鲲，它是海洋的霸主。鲲跃离水面，就会变成鹏；鹏潜入海底则会变成鲲，他们是同一种生物的不同形态。与之类似，有一种极小的虫子叫作焦螟，它自身的状态会随着观察者自身状态的变化而变化，这充分说明事物有各自存在的状态，观察者局限于自身的状态而无法确切的知道其他事物的大小、长短和同异。</p><p><br></p><p>接下来，就轮到我们的主人公愚公出场了，文章<strong>通过愚公和智叟的对比来说明时间观不同的人对于世界认知的不同</strong>。愚公的时间观尺度非常大：“无穷多的子子孙孙来帮我挖山”，那么在无极无尽的宇宙里，移走大山只是一瞬间的事，是一个必然的结果。</p><p><br></p><p>而智叟的时间观尺度则只在于“旦夕”，即只能看到人的一生。在这样渺小的时间观中，智叟所能看到的世界和白天出生晚上死亡的菌芝看到的世界并无差异。</p><p><br></p><p><strong>可见通篇和“做事有毅力，有恒心，坚持不懈，不怕困难”没有丝毫关系。</strong></p><p><br></p><p>小朋友们，你明白了嘛？</p>', 'http://img.jssns.cn/SHILU/1/44899318871112138.png', 'http://img.jssns.cn/SHILU/1/4aabddb45d247a9fee3438fd1894de0b.jpg', null, 'album', 'ID515539237269929986', '120', null, '2', '168', '2019-01-24 09:13:46', '432228697144033280', '2019-02-22 11:22:50');
INSERT INTO `audio` VALUES ('ID537934717702373376', '《咏鹅》 唐·骆宾王', 'http://img.jssns.cn/SHILU/1/037540bbb01b8eb79805eeca8bded3c3.mp3', '<p><strong>咏鹅&nbsp;唐·骆宾王</strong></p><p><br></p><p>鹅，鹅，鹅，曲项向天歌。</p><p>白毛浮绿水，红掌拨清波。</p><p><br></p><p><strong>注释</strong></p><p><br></p><p>曲项：弯着脖子。歌：长鸣。</p><p>拨：划动。</p><h2><br></h2><p><strong>译文</strong></p><p><br></p><p>白天鹅啊白天鹅，脖颈弯弯，向天欢叫。</p><p>洁白的羽毛，漂浮在碧绿水面；红红的脚掌，拨动着清清水波。</p><p><br></p><p><strong>赏析</strong></p><p><br></p><p>诗中，小作者从自己的角度、自己的心态，去理解和观察鹅，用了拟人的手法，如把鹅的叫声说成是“歌”等。同时也把色彩的对比，也就是事物的特征表现传达的丰富和全面。“白毛”、“绿水”、“红掌”、“清波”，相映。</p><p><br></p><p>首句连用三个“鹅”字，表达了诗人对鹅十分喜爱之情。这三个“鹅”字，可以理解为孩子听到鹅叫了三声，也可以理解为孩子看到鹅在水中嬉戏，十分欣喜，高兴地连呼三声“鹅、鹅、鹅”。</p><p><br></p><p>次句“曲项向天歌”，描写鹅鸣叫的神态。“曲项”二字形容鹅向天高歌之态，十分确切。鹅的高歌与鸡鸣不同，鸡是引颈长鸣，鹅是曲项高歌。</p><p><br></p><p>三、四句写鹅游水嬉戏的情景：“白毛浮绿水，红掌拨清波。”“浮”“拨”两个动词生动地表现了鹅游水嬉戏的姿态。“白毛”“红掌”“绿水”等几个色彩鲜艳的词组给人以鲜明的视觉形象。鹅白毛红掌，浮在清水绿波之上，两下互相映衬，构成一幅美丽的“白鹅嬉水图”，表现出儿童时代的骆宾王善于观察事物的能力。</p>', 'http://img.jssns.cn/SHILU/1/44902122606334631.png', 'http://img.jssns.cn/SHILU/1/7525a94e2871301a9a397b6b5f607d91.jpg', null, 'album', 'ID535147574781280256', '137', null, '4', '168', '2019-01-24 10:00:31', '168', '2019-01-31 18:20:59');
INSERT INTO `audio` VALUES ('ID537937799890862080', '《敕勒歌》乐府诗集', 'http://img.jssns.cn/SHILU/1/7b7e6c984a286a698e040995701c1cc1.mp3', '<p><strong>敕勒歌 乐府诗集</strong></p><p><br></p><p>敕勒川，阴山下。天似穹庐，笼盖四野。</p><p>天苍苍，野茫茫。风吹草低见牛羊。</p><p>&nbsp;</p><p><strong>注释</strong></p><p><br></p><p><span style=\"color: rgb(246, 12, 12);\">敕勒</span>：种族名</p><p><span style=\"color: rgb(230, 0, 0);\">川</span>表示平川或平原</p><p><span style=\"color: rgb(246, 12, 12);\">阴山</span>，在今内蒙古自治区北部</p><p><span style=\"color: rgb(246, 12, 12);\">穹庐</span>：表示蒙古<span style=\"color: rgb(0, 0, 0);\">包</span></p><p><span style=\"color: rgb(246, 12, 12);\">四野</span>：草原的四面八方</p><p><span style=\"color: rgb(246, 12, 12);\">苍苍</span>：深蓝色</p><p><span style=\"color: rgb(246, 12, 12);\">茫茫</span>：辽阔无边的样子</p><p><span style=\"color: rgb(246, 12, 12);\">见</span>（xian）同现，显露的意思</p><p><br></p><p><strong>译文</strong></p><p><br></p><p>阴山脚下啊，有敕勒族生活的大平原。敕勒川的天空啊，它的四面与大地相连，看起来好像牧民们居住的毡帐一般。天空蓝蓝的，原野辽阔无边。风儿吹过，牧草低伏，显露出原来隐没于草丛中的众多牛羊。</p><p><br></p><p><strong>赏析</strong></p><p><br></p><p>这首民歌，<strong>勾勒出了北国草原壮丽富饶的风光，抒写敕勒人热爱家乡热爱生活的豪情</strong>，境界开阔，音调雄壮，<strong>语言明白如话，艺术概括力极强</strong>。</p><p><br></p><p>开头两句“敕勒川，阴山下”，交代敕勒川位于高耸云霄的阴山脚下，<strong>将草原的背景衬托得十分雄伟</strong>。</p><p><br></p><p>接着两句“天似穹庐，笼盖四野”，敕勒族人<strong>用</strong>自己生活中的<strong>“穹庐”作比喻，</strong>说天空如毡制的圆顶大帐篷，盖住了草原的四面八方，以此来形容极目远望，天野相接，无比壮阔的景象。这种景象只在大草原或大海上才能见到。</p><p><br></p><p>最后三句“天苍苍，野茫茫，风吹草低见牛羊”是一<strong>幅壮阔无比、生机勃勃的草原全景图</strong>。“风吹草低见牛羊”，一阵风儿吹弯了牧草，显露出成群的牛羊，多么形象生动地写出了这里水草丰盛、牛羊肥壮的景象。全诗寥寥二十余字，就展现出我国古代牧民生活的壮丽图景。</p>', 'http://img.jssns.cn/SHILU/1/44902857406582488.png', 'http://img.jssns.cn/SHILU/1/d7b3aaac268f27cb1e50baa392a85252.jpg', null, 'album', 'ID535147574781280256', '139', null, '3', '168', '2019-01-24 10:12:45', '168', '2019-01-31 18:19:43');
INSERT INTO `audio` VALUES ('ID538378337517568000', '蚊子与小狗', 'http://img.jssns.cn/SHILU/1/b12b9c640d61a8c771d5d8704bc930f4.mp3', '<p><br></p><p>小智在学校门口的台阶上休息，突然，他看到一只蚊子停落在他的胳膊上，于是，小智轻轻地抬起手，“啪”的一声打下去，蚊子就一命鸣呼了！这只可怜的蚊子还没来得及张口，就丢掉了性命。达叔是一位在学校门口维持秩序、帮助孩子们过街的警察叔叔，他和小智非常熟。他笑着说：“小智，好眼力！这该死的蚊子！”</p><p>&nbsp;</p><p>两分钟以后，达叔听到一阵尖叫。原来一位女士的小狗把一大泡屎拉在了一位先生的脚背上。这位先生简直气疯了，对着小狗乱踢。悲剧发生了：小狗死了！达叔赶过去，逮捕了这位先生并将他带去警察局。</p><p>&nbsp;</p><p>可小狗的死无法挽回，失去小狗的夫人蹲在地上伤心地哭着，所有在场的人都对那位先生的行为义愤填膺。</p><p>&nbsp;</p><p>由这个小故事，<strong>我们发现，对于蚊子的生命，大家都不屑一顾，但是小狗的生命对他们而言却非常的重要。</strong>由此可见，<strong style=\"color: rgb(25, 23, 23);\">生命并不具有同样的价值。</strong>没有人会去同情蚊子，尤其是你为了保护自己而打死的蚊子。</p><p>&nbsp;</p><p>但是，如果小智花很多时间“屠杀”蚊子，并以拔掉它们的翅膀为乐，人们则会觉得他的行为十分古怪，因为那些蚊子根本没有来伤害他。</p><p>&nbsp;</p><p>甚至，我们对待同一事物不同的方式也会带来他人完全不同的态度：<strong>在公园里，如果有人采摘一些鲜花，再把它们扔到路边，人们会指责摘花的人，说他不懂得爱惜生命；但如果采摘鲜花是为了将它们扎成一把美丽的花束，几乎所有的人都认为这样很好：花儿虽然死了，但是点缀装饰了我们的家。</strong></p><p><strong>&nbsp;</strong></p><p>然而也有一些人从不摘花儿，他们认为花朵的生命也很针对，他们希望它们能够永远留在枝头生长开放。另外在一些山区，法律禁止人们采花，因为那里的花儿非常稀少。</p><p>&nbsp;</p><p>虽然每个生命都拥有同等的价值，但人类更喜欢去决定其他生物的命运，去决定是让它们继续生长还是立马死亡。<strong>事实上，所有的生命都具有价值，只是对人类而言，生命的价值并不一样，这才是问题的关键所在。</strong></p><p><strong>&nbsp;</strong></p>', 'http://img.jssns.cn/SHILU/1/45007889909062996.png', 'http://img.jssns.cn/SHILU/1/1052d069fa696df284907dde61c4a185.jpg', null, 'album', 'ID515536344454266882', '117', null, '0', '168', '2019-01-25 15:23:18', '168', '2019-01-25 18:15:17');
INSERT INTO `audio` VALUES ('ID538380120281317376', '国王发疯了', 'http://img.jssns.cn/SHILU/1/7fcb58434a9468d1fe1f773a2494999e.mp3', '<p><br></p><p>有时候，人类忘记了所有的生命都具有价值，他们认为只有自己的生命才是弥足珍贵的。因此，他们认为自己比其他的生命更聪明、更威猛、更强大，这种盲目自信让人类时常去做那些忘乎所以的事情，比如征服地球。</p><p>&nbsp;</p><p>这类人认为世界上的一切生命都属于他们，一切生命都得听从他们。<strong>可他们忘记了人类并不能凌驾于其他生命之上，人类只能生活在它们中间，与他们共存。</strong>并且幸亏有这些生命，人类才得以生存。妄图挑战这一真理的人都付出了惨痛的代价，比如下面这一位国王。</p><p>&nbsp;</p><p><strong>潘多拉星球的新任国王叫艾伦</strong>，他是一个非常古怪残酷的人：他个子很矮，而且不能容忍任何东西或者任何人比他高。他已经从他的王国中驱逐了所有比他身材高大的男人和女人，也赶跑了长颈鹿和大象这些身材高大动物。但是还剩下一个极大的问题，就是那些比他高很多的树。由于艾伦不能将树木赶走，所以他就下令把所有的树都砍掉。</p><p>&nbsp;</p><p>六个星期以后大功告成了：潘多拉星球上一棵树也没有了！艾伦国王高兴极了，现在没有任何东西也没有任何人能超过他了。时间一年年地过去，居民们开始担心起来，因为这几年几乎没有下过雨，这里的土地变干了，收成不好，饥荒开始了。又过了几年，潘多拉星球已成为了名副其实的沙漠：所有的居民也都饿死或者渴死了。</p><p>&nbsp;</p><p>在这个故事中，国王忘记了自己也是多亏了这些树木才能活着。其实，树木有助于云层的形成，而云层则给我们带来雨水。雨水滋润了大地，大地里的种子才能发芽长大。只有这样，人类才能收割粮食，远离饥荒。<strong>生命就是这样环环相扣，互为依存。</strong></p><p>&nbsp;</p><p>如果人们毒害奶牛吃的青草，那么他们也是在毒害自己：因为人们喝牛奶吃牛肉的时候就会中毒。为所欲为不顾及别的生命，将给人类自己带来极其严重的问题。</p><p>人类应该牢记，所有的生命都是我们这个大家庭的成员。尽管在这个家庭中，人类有一个特别的位置。</p><p><br></p><p>最后，给大家欣赏一首世界流行天王迈克尔杰克逊的地球保护歌曲：《Earth song》</p><p><strong>&nbsp;</strong></p><p><strong>Earth song 的中英文对照歌词</strong></p><p>What about sunrise 日出呢</p><p>What about rain 雨呢</p><p>What about all the things 还有你说过</p><p>That you said we were to gain... 我们会得到的一切呢...</p><p>What about killing fields 土地在减少呢</p><p>Is there a time 有没有结束的时候</p><p>what about the things 还有你说过</p><p>That you said was yours and mine...属于你和我的一切呢....</p><p>Did you ever stop to notice 你是不是忘了</p><p>All the blood we\'ve shed before 我们曾挥洒下的血汗</p><p>Did you ever stop to notice 你有没有看到</p><p>The crying Earth the weeping shores? 地球在流泪海岸在哭泣</p><p>What have we done to the world 我们对世界做错了什么</p><p>Look what we\'ve done 看看我们做错了什么吧</p><p>What about all the peace 还有你向独子许诺过的</p><p>That you pledge your only son... 一切和平呢</p><p>What about flowering fields 鲜花遍布的田野呢</p><p>Is there a time 有没有结束的时候</p><p>What about all the dreams 还有你说过</p><p>That you said was yours and mine... 属于你和我的所有梦想呢</p><p>Did you ever stop to notice 你是不是忘了</p><p>All the children dead from war 战争中死去的那些孩子</p><p>Did you ever stop to notice 你有没有看到</p><p>The crying Earth the weeping shores? 地球在流泪海岸在哭泣</p><p>I used to dream 我曾经梦想</p><p>I used to glance beyond the stars 我曾经遥望群星之上</p><p>Now I don\'t know where we are 如今不知我们身在何方</p><p>Although I know we\'ve drifted for 尽管我明白我们漂泊了太远</p><p>Hey,what about yesterday (what about us) 嘿,昨天呢(我们呢)</p><p>What about the seas (what about us) 海洋呢</p><p>The heavens are falling down (what about us) 天堂跌落</p><p>I can\'t even breathe (what about us) 我不能呼吸</p><p>What about the bleeding Earth (what about us) 流血的地球呢</p><p>Can\'t we feel its wounds (what about us) 我们难道不能感受到它的伤痕</p><p>What about nature\'s worth (ooo,ooo) 宝贵的自然呢</p><p>It\'s our planet\'s womb (what about us) 那是我们地球的孕育地</p><p>What about animals (what about us) 动物呢</p><p>We\'ve turned kingdoms to dust (what about us) 我们把他们的王国化为灰烬</p><p>What about elephants (what about us) 大象呢</p><p>Have we lost their trust (what about us) 我们是不是已失去它们的信任</p><p>What about crying whales (what about us) 鲸鱼呢</p><p>We\'re ravaging the seas (what about us) 我们污染了海洋</p><p>What about forest trails (ooo,ooo) 森林小径呢</p><p>Burnt despite our please (what about us) 给我们违心的烧毁了</p><p>What about the holy land (what about us) 神圣的土地呢</p><p>Tron apart by creed (what about us) 被四分五裂了</p><p>What about the common man (what about us) 普通人呢</p><p>Can\'t we set him free (what about us) 我们可以给予他自由吗</p><p>What about children dying (what about us) 奄奄一息的孩子呢</p><p>Can\'t you hear them cry (what about us) 你有没有听到他们的哭声</p><p>Where did we go wrong (ooo,ooo) 我们走错了何方</p><p>Someone tell me why (what about us) 有没有人告诉我原因</p><p>What about babies (what about us) 婴儿呢</p><p>What about the days (what about us) 岁月呢</p><p>What about all their joy (what about us) 他们所有的欢乐呢</p><p>What about the man (what about us) 人类呢</p><p>What about the crying man (what about us) 哭喊的人们呢</p><p>What about Abraham (what about us)&nbsp;亚伯拉罕呢</p><p>What about death again (ooo,ooo) 再问一次,死亡呢</p>', 'http://img.jssns.cn/SHILU/1/45008314879106989.png', 'http://img.jssns.cn/SHILU/1/87c4d4729971b49f6377e1a9b2a049f6.jpg', null, 'album', 'ID515536344454266882', '112', null, '0', '168', '2019-01-25 15:30:23', '168', '2019-01-25 18:20:12');
INSERT INTO `audio` VALUES ('ID538380303387852800', '人类的生命', 'http://img.jssns.cn/SHILU/1/2235e7957e6b83f38794984179305961.mp3', '<p><br></p><p>一个人生命的精神价值远远超过他躯体生命本身。当然，每个人都像动物一样，需要生长、吃饭、喝水、呼吸、睡觉、拉屎、撒尿、洗澡或者是保养身体。但是，他的生命同时也是交谈与倾听、阅读与爱恋、观赏日落、吟诗作画、痛哭流涕，还有许许多多别的东西。</p><p>&nbsp;</p><p>如果我们描述一朵花儿的生命，我们可以这样说：“这朵花儿是红色的，并带有黄色的斑点。它的生长期是两个星期。它有三十五个花瓣儿，但是，凋谢得很快。”</p><p>&nbsp;</p><p>当我们描述一头狮子的时候，我们将告诉别人：“它跑得快极了，它有粗大的爪子，它吃斑马。它的皮毛非常漂亮。它和母狮子生小狮子······”</p><p>&nbsp;</p><p>但是，当我们叙述一个人的生命时，我们不会说：“他吃鸡蛋和鱼，他跑的不如斑马快，但是比蚂蚁快多了。他用两条腿走路。当他衰老的时候, 他会变得僵硬。他身上的毛扎人。他打哈欠, 特别是晚上....”</p><p>&nbsp;</p><p>我们宁愿说：“他喜欢音乐, 他热爱读《百年孤独》, 他为好友的离开而伤心落泪。 但是, 当他的孩子做鬼脸的时候, 他笑得很开。他还会制作美丽的木雕.....”这一切使我们的生命成为了人的生命,而不是一个植物的生命或者一个动物的生命。正是因为如此, 绝不能将人类的生命同其他任何一种生命相提并论。</p><p>&nbsp;</p><p>所有的人都赞成彻底禁止杀人, 没有一个人对此唱反调。 可是, 人们并没有按照他们所说的去做。他们发动战争, 自相残杀。</p><p>&nbsp;</p><p>如果一切如我们所愿，那世界将永远和平，可事情远比我们想象的复杂：当我们遭到攻击的时候, 是坐以待毙呢, 还是奋起自卫将敌人消灭？如果入侵者的头儿是一个疯子, 他要把别的人群斩尽杀绝, 我们能对其听之任之吗？有的时候, 杀人是为了保护自己, 或者是为了避免更多的死亡，换句话说，我们是为了保护生命而杀人。</p><p>&nbsp;</p><p>尺管如此, 我们仍然坚信一个人的生命, 无论是谁的, 比一切都重要！我们也仍然坚信，世界上将会一直和平下去！</p>', 'http://img.jssns.cn/SHILU/1/45008358653579014.png', 'http://img.jssns.cn/SHILU/1/d2831d9afa809071b1994e819c85d364.jpg', null, 'album', 'ID515536344454266882', '113', null, '0', '168', '2019-01-25 15:31:06', '168', '2019-01-25 18:16:19');
INSERT INTO `audio` VALUES ('ID538380538935771136', '性格是什么？', 'http://img.jssns.cn/SHILU/1/4cdffe75158bffa55e9055c622241b35.mp3', '<p><br></p><p>蜜蜂不是自由的，它来到地球上是为了酿造蜂蜜；河狸也不是自由的，它终日在河水里筑坝，了此一生。好像所有的动物都出生在一个大剧场中，在那儿每个角色早早就被设定好了，不能够被更改：蜜蜂身着棕黄色的服装，当幕布开启时，它就应该酿蜜。确实如此，谁也不会征求它的意见。当它死了，另一只蜜蜂会代替它的表演。既然它们都完全一样，没有丝毫差异，那谁又能记得这些蜜蜂演员的姓名呢？！</p><p><br></p><p>但我们人类却不是这样。<strong>人出生的时候，既没有服装，也没有角色。</strong>是他本人去创作他的剧本、他的服装和他的角色：他将创建自己的人生。在幕布落下、剧目结束的时候，人们仍然记得关于他的许多事。因为没有任何人能像他那样演戏：<strong>他的人生是唯一的，是独一无二的，和别的人生毫无相似之处。</strong></p><p><br></p><p><strong>人类的生命与动物的生命截然不同。</strong>人类能够驾驭自己的生活，是他自己决定他的生命：他可以选择普普通通地享受生活，也可以选择轰轰烈烈地追求自己的梦想。人类可以自由地选择自己要走的人生道路。人的生活各相同，每个人要走的是自己的路，而不是其他任何人的路。</p><p><br></p><p>人在整个生命过程中一点一点地构建自己，就像在玩一个拼图游戏，你经历的越多，思考的越多，你的拼图就越完整，这些拼图就组成了我们所说的性格。</p><p><br></p><p>性格是人的生命中非常重要的部分，比身体的任何部分，如手、脚、头发、眼睛等都更重要。当我们回忆往事的时候，我能记住他人的也更多是他的性格，就像小智对阿信的回忆一样：</p><p><br></p><p>当小智的父母决定搬家的时候，他只有六岁。离开他的房间和他的小伙伴们使他难过极了，尤其是与他最好的朋友阿信的分离。为此，小智伤心地哭了很久很久。</p><p><br></p><p>今天，小智11岁了。从前房间的样子他已经想不起来了。地毯也许是蓝色的，可是他不敢肯定；还有高高的天花板和木制的房梁，但这也不可能是真的。然而，他曾经是那么的喜欢这个房子，可现在居然想不起来了，这让他感到莫名其妙。</p><p><br></p><p>但是，对他的小伙伴儿阿信他却记得清清楚楚：他们比赛骑自行车；他们因打碎了客厅里的玻璃桌子而紧张不安；阿信将巧克力面包涂满芥未，就在递给讨厌的王明时，他们却忍不住大笑了起来；他们把一只塑料蜘蛛悄悄地放进了美美的书包里······晚上，躺在床上的时候，小智总是喜欢一幕幕地回想这些美好的记忆，就像放电影一样。</p><p><br></p><p>在这个故事里，小智已经说不出阿信的头发是卷的还是直的，也记不住阿信脸是尖尖的还是圆圆的。可是，他仍然记得阿信的笑声，仍然能感受到他们曾经遭遇过的那些紧张不安，以及制造恶作剧捉弄别人所带来的快乐·····</p><p><br></p><p>小智至今还能够告诉我们阿信很滑稽，爱运动，胆子小，热情而诚实，他还可以说出阿信是更喜欢读书还是看电视。所有这一切就构成了阿信的性格。</p><p><br></p><p><strong>当一个人死去的时候，他的身体消失了，但他的性格却保存下来了，继续活在其他人的记忆中，就像阿信存在于小智的记忆中一样。</strong></p><p class=\"ql-align-center\"><br></p>', 'http://img.jssns.cn/SHILU/1/45008414644071352.png', 'http://img.jssns.cn/SHILU/1/dfdc9765de99681b933cba76e81c4f16.jpg', null, 'album', 'ID515536344454266882', '116', null, '0', '168', '2019-01-25 15:32:03', '168', '2019-01-25 18:17:31');
INSERT INTO `audio` VALUES ('ID538783862449242112', '《咏柳》 唐·贺知章', 'http://img.jssns.cn/SHILU/1/4e6f74b86ea1cdb4ba78da0cd915a3b3.mp3', '<p><strong>咏柳 唐·贺知章</strong></p><p><br></p><p>碧玉妆成一树高，万条垂下绿丝绦。</p><p>不知细叶谁裁出，二月春风似剪刀。</p><p><br></p><p><strong>注释</strong></p><p><br></p><p>碧玉：碧绿色的玉。这里用以比喻春天嫩绿的柳叶。</p><p>妆：装饰，打扮。</p><p>一树：满树。一：满，全。在中国古典诗词和文章中，数量词在使用中并不一定表示确切的数量。下一句的“万”，就是表示很多的意思。</p><p>绦（tāo）：用丝编成的绳带。这里指像丝带一样的柳条。</p><p>裁：裁剪。</p><p>似：如同，好像。</p><p><br></p><p><strong>译文</strong></p><p><br></p><p>高高的柳树长满了翠绿的新叶，轻柔的柳枝垂下来，就像万条轻轻飘动的绿色丝带。</p><p><br></p><p>这细细的嫩叶是谁的巧手裁剪出来的呢？原来是那二月里温暖的春风，它就像一把灵巧的剪刀。</p><p><br></p><p><strong>赏析</strong></p><p><br></p><p>首句写树，柳树就像一位经过梳妆打扮的亭亭玉立的美人。柳，单单用碧玉来比有两层意思：一是碧玉这名字和柳的颜色有关，“碧”和下句的“绿”是互相生发、互为补充的。二是碧玉这个字在人们头脑中永远留下年轻的印象。“碧玉”二字用典而不露痕迹，南朝乐府有《碧玉歌》，其中“碧玉破瓜时”已成名句。还有南朝萧绎《采莲赋》有“碧玉小家女”，也很有名，后来形成“小家碧玉”这个成语。“碧玉妆成一树高”就自然地把眼前这棵柳树和那位古代质朴美丽的贫家少女联系起来，而且联想到她穿一身嫩绿，楚楚动人，充满青春活力。</p><p><br></p><p>故第二句就此联想到那垂垂下坠的柳叶就是她身上婀娜多姿下坠的绿色的丝织裙带。中国是产丝大国，丝绸为天然纤维的皇后，向以端庄、华贵、飘逸著称，那么，这棵柳树的风韵就可想而知了。</p><p><br></p><p>第三句由“绿丝绦”继续联想，这些如丝绦的柳条似的细细的柳叶儿是谁剪裁出来的呢？先用一问话句来赞美巧夺天工可以传情的如眉的柳叶，最后一答，是二月的春风姑娘用她那灵巧的纤纤玉手剪裁出这些嫩绿的叶儿，给大地披上新装，给人们以春的信息。这两句把比喻和设问结合起来，用拟人手法刻画春天的美好和大自然的工巧，新颖别致，把春风孕育万物形象地表现出来了，烘托无限的美感。</p><p><br></p><p>总的来说，这首诗的结构独具匠心，先写对柳树的总体印象，再写到柳条，最后写柳叶，由总到分，条序井然。在语言的运用上，既晓畅，又华美。</p>', 'http://img.jssns.cn/SHILU/1/45104574920150315.png', 'http://img.jssns.cn/SHILU/1/362648a7f74465538c047319af372433.jpg', null, 'album', 'ID535147574781280256', '109', null, '6', '168', '2019-01-26 18:14:42', '168', '2019-01-31 18:22:35');
INSERT INTO `audio` VALUES ('ID539453671897825280', '《风》 唐·李峤', 'http://img.jssns.cn/SHILU/1/5c8e66aadb9ce7443f1c9fe6752b1b5d.mp3', '<p><strong>《风》 唐·李峤</strong></p><p><br></p><p>解落三秋叶，能开二月花。</p><p>过江千尺浪，入竹万竿斜。</p><p><br></p><p><strong>注释</strong></p><p><br></p><p>解落：吹落，散落。解：解开，这里指吹。三秋：秋季。一说指农历九月。</p><p>能：能够。二月：农历二月，指春季。</p><p>过：经过。</p><p>斜：倾斜。</p><p><br></p><p><strong>译文</strong></p><p><br></p><p>能吹落秋天金黄的树叶，能吹开春天美丽的鲜花。</p><p>刮过江面能掀千尺巨浪，吹进竹林能使万竿倾斜。</p><p><br></p><p><strong>赏析</strong></p><p><br></p><p>这首诗能让人看到风的力量。如果把诗题盖住，这首诗就是一则谜语，这是此诗的一大妙处。风是无形的，风又是实在的，我们看不到风，却能感受到风。秋风能扫尽落叶，春风能催开鲜花，风能激起千层浪，风能吹得万竹斜。看不见、摸不着、闻不到的“风”在作者笔下，变得形象生动，读后仿佛满纸是 飒飒的风声，似乎手可以捧、鼻可以闻、耳可以听。</p>', 'http://img.jssns.cn/SHILU/1/45264270393342797.png', 'http://img.jssns.cn/SHILU/1/a212a3f8d79601b638d16894963109eb.jpg', null, 'album', 'ID535147574781280256', '114', null, '5', '432228697144033280', '2019-01-28 14:36:17', '168', '2019-01-31 18:22:07');
INSERT INTO `audio` VALUES ('ID539471062065217536', '努力让生命留下痕迹', 'http://img.jssns.cn/SHILU/1/4f8aa2463f26d5416721c2dc81637a0a.mp3', '<p>悦悦和她的父母正在排队参观一个博物馆：这是毕加索画展开幕的第一天，很多人慕名而来。可悦悦早已对博物馆之类的地方腻烦了，他们每年都要去参观各种博物馆，但她已经忘记了自己都看到过那些东西了。当悦悦不断嘀咕抱怨的时候，队伍也在不停地往前走。</p><p><br></p><p>不一会儿，他们来到了第一展厅，站在了十多幅让人难以置信的油画面前。悦悦感到非常不可思议：这些画，就像是孩子画的，东一块西一块，完全没有逻辑啊。画上的女人，头是歪着的，鼻子跑到了耳朵的下面，一只眼睛在脸的上方，另一只在脸的下方。悦悦觉得毕加索的画简直太滑稽了。原来，这个展览并不是一无所获。明天她就把这些告诉她的同学们，她们听了一定会很高兴。</p><p><br></p><p>如果，有一天悦悦有了孩子，也许她也会带他们去看看毕加索的画。当然了，悦悦的孩子的孩子无疑也会去看。哪怕再过一千年、两千年，博物馆门前将仍然有人排着长队等着去看毕加索的画，讨论他的故事。然而，毕加索已经死了：承载他生命的躯体已经消失了。但是，多亏了他的素描和油画，他仍然活着。他给我们的世界留下了一道他的痕迹，一道包含着他的性格的痕迹。</p><p><br></p><p>我们每个人都会留下一道痕迹，一道与他人不同的痕迹。因为我们每个人的人生是不一样的。</p><p><br></p><p>这道痕迹，并不总是一幅画、一本书，这些能看见的东西。它常常是种回忆，是对某个人性格的一种回忆。因此，我们把这道痕迹叫作灵魂。</p><p><br></p><p>灵魂看不见，也摸不着。他没有嘴讲话，没有耳朵倾听，也没有脚走路。因此，你完全没有必要问自己：“灵魂在哪儿？”这就像你无法问“运气”在哪里？“点子”在哪里？一样。</p><p><br></p><p>小智的父亲正在洗青菜准备晚饭，可问题是小智很讨厌吃青菜。所以，他走进厨房，笑嘻嘻地说：“爸爸，你看见我们旁边新开张的那家餐馆吗？他们做了一个非常精彩的广告——北京烤鸭，买一送一！”父亲瞟了他一眼说：“小智，你的脑袋后面藏着一个小小的点子！······小智的弟弟听到了，赶快跑到小智的背后，看哥哥的后脑勺上有什么。他仔仔细细地找。可是，他什么也没有看到，哥哥的脑袋后面除了头发真的什么也没有。</p><p><br></p><p>很显然，小智的脑袋后面什么也没有。可是，那个点子的确存在，这就是去吃北京烤鸭，而不是吃青菜。如果他的父亲要给他的弟弟解释“点子”藏在哪里，那么他就会像人们问灵魂在哪儿一样，自己难为自己。</p>', 'http://img.jssns.cn/SHILU/1/45268415750097026.png', 'http://img.jssns.cn/SHILU/1/ae9b0018245001ce0bfb0abecf1d00f1.jpg', null, 'album', 'ID515536344454266882', '114', null, '0', '432228697144033280', '2019-01-28 15:45:24', '432228697144033280', '2019-01-28 15:47:05');
INSERT INTO `audio` VALUES ('ID540941586649841664', '大公鸡和漏嘴巴', 'http://img.jssns.cn/SHILU/1/7c3a10febde360f90d83491161678a0a.mp3', '<p>有一只大公鸡在院子里走来走去，这里啄啄，那里啄啄，找不到虫子吃，急得“咕咕咕咕”地叫。</p><p><br></p><p>小弟弟捧着饭碗，坐在院子里吃饭。他一边吃，一边瞧着花蝴蝶飞来飞去，饭粒撒了一身，撒了一地。</p><p><br></p><p>大公鸡看见了，可高兴啦！它连忙跑了过去，嘴里嚷着：“好运气，好运气！今天碰到一个漏嘴巴的小弟弟。” 大公鸡跑到小弟弟身边，啄起地上的饭粒来，“哆哆哆”，啄得可快呢。真好玩！小弟弟越看越高兴，连吃饭也忘了。</p><p><br></p><p>一会儿，大公鸡把撒在地上的饭粒吃光了，它还没吃饱呢。大公鸡抬起头来看了看，小弟弟的裤子上也有饭粒，就来啄小弟弟的裤子了。</p><p><br></p><p>小弟弟说：“大公鸡，大公鸡，你怎么啄我呀！” 大公鸡说：“小弟弟，小弟弟，我不是啄你，我是啄饭粒呢！”</p><p><br></p><p>一会儿，大公鸡把撒在裤子上的饭粒吃光了，它还没吃饱呢。大公鸡抬起头来看了看，小弟弟的衣服上还有饭粒，就来啄小弟弟的衣服了。</p><p><br></p><p>小弟弟说：“大公鸡，大公鸡，你怎么啄我呀！” 大公鸡说：“小弟弟，小弟弟，谁啄你了，我是啄饭粒呢！” 一会儿，大公鸡把撒在衣服上的饭粒吃光了，它还没吃饱呢。大公鸡抬起头来看了看，小弟弟嘴巴旁边有一粒饭，就来啄小弟弟的嘴巴。</p><p><br></p><p>小弟弟害怕了，端起饭碗就跑：“大公鸡，大公鸡，别啄我，别啄我！”大公鸡说：“小弟弟，小弟弟，别跑，别跑，我不啄你，我不啄你，你嘴巴旁边有粒饭，让我吃了它！” 大公鸡张开金翅膀，一下子跳到小弟弟的肩膀上，朝着他嘴巴上的饭粒，“哆”的啄了一下。</p><p><br></p><p>小弟弟哭了起来：“奶奶来呀，奶奶来呀！” 大公鸡可高兴呢，它说：“小弟弟是个漏嘴巴，掉下饭来，让我吃得乐哈哈。”奶奶来了，小弟弟问奶奶：“奶奶你说，我的嘴巴漏吗？” 奶奶说：“傻孩子，哪有漏嘴巴呀，是你吃饭的时候，东看看，西瞧瞧，把饭撒了。”</p><p><br></p><p>奶奶又给小弟弟盛了半碗饭，“快吃，快吃，可别再撒了。” 小弟弟端着饭碗吃饭。大公鸡又来了，它说：“我还没吃饱呢，漏嘴巴，漏嘴巴，撒点饭粒让我吃呀！” 大公鸡等呀等，一粒饭也没吃到。哦，小弟弟这回吃饭，可不东看看西瞧瞧了！他把饭吃得干干净净，拿着空碗让大公鸡瞧了瞧，对它说：“我是好弟弟，不是漏嘴巴。”</p><p><br></p><p>大公鸡没办法，耷拉着脑袋，只好去找虫子吃了。</p><p>&nbsp;</p><p>亲爱的宝贝们，今天晚饭的时候有没有东看看，西瞧瞧呀？<strong>吃饭不专心的话就会有大公鸡来啄嘴巴呦！所以，我们要专心的吃饭，不能给大公鸡一点机会！</strong>好啦，晚安喽，婷婷姐姐明天再来给你讲故事。</p>', 'http://img.jssns.cn/SHILU/1/45619016790559251.png', 'http://img.jssns.cn/SHILU/1/311434b09d8f848dd2277a9f8c210a33.jpg', null, 'album', 'ID558313010574131200', '109', null, '3', '168', '2019-02-01 17:08:44', '432228697144033280', '2019-02-14 11:39:59');
INSERT INTO `audio` VALUES ('ID541375809848344576', '《赠汪伦》 唐·李白', 'http://img.jssns.cn/SHILU/1/b7716131097215da5b183f760ad0f961.mp3', '<h2>《赠汪伦》 唐·李白</h2><p><br></p><p>李白乘舟将欲行，忽闻岸上踏歌声。</p><p>桃花潭水深千尺，不及汪伦送我情。</p><p><br></p><h2>注释</h2><p><strong>踏歌：</strong>唐代一作广为流行的民间歌舞形式，一边唱歌，一边用脚踏地打拍子，可以边走边唱。</p><p><strong>桃花潭：</strong>在今安徽泾县西南一百里。</p><p><strong>深千尺：</strong>诗人用潭水深千尺比喻汪伦与他的友情，运用了夸张的手法（潭深千尺不是实有其事）。</p><p><strong>不及：</strong>不如。</p><p><br></p><h2>译文</h2><p>李白坐上小船刚刚要离开，忽然听到岸上传来告别的歌声。</p><p>即使桃花潭水有一千尺那么深，也不及汪伦送别我的一片情深。</p><p><br></p><h2>赏析</h2><p>这首诗是李白即兴脱口吟出，自然入妙，因而历来为人传诵。然而，也因为它像生活一样自然，人们往往知其妙而不知其所以妙。诗的三四句，后代诗家还有一点评论，开头两句口语化的平直叙述，就说不出所以然来了。其实，结合上述背景来看，头两句也是写得极其成功的。</p><p><br></p><p>\"李白乘舟将欲行\"，是说我就要乘船离开桃花潭了。那声口语言简直是不假思索，顺口流出，表现出乘兴而来、兴尽而返的潇洒神态。</p><p><br></p><p>\"忽闻岸上踏歌声\"，\"忽闻\"二字表明，汪伦的到来，确实是不期而至的。人未到而声先闻，从那热情爽朗的歌声，李白就料到一定是汪伦赶来送行了。</p><p><br></p><p>这样的送别，侧面表现出李白和汪伦这两位朋友同是不拘俗礼、快乐自由的人。在山村僻野，本来就没有上层社会送往迎来那套繁琐礼节，看来，李白走时，汪伦不在家中。当汪伦回来得知李白走了，立即携着酒赶到渡头饯别。不辞而别的李白固然洒脱不羁，不讲客套;踏歌欢送的汪伦，也是豪放热情，不作儿女沾巾之态。短短十四字就写出两人乐天派的性格和他们之间不拘形迹的友谊。</p><p><br></p><p>也许正因为两人思想性情契合，李白引为同调，很珍视汪伦的友情。情之所至，遂对着眼前风光绮丽的桃花潭水，深情地吟道:</p><p><br></p><p>\"桃花潭水深千尺，不及汪伦送我情。\"</p><p><br></p><p>结合此时此地，此情此景，这两句诗也如脱口而出，感情真率自然。用水流之深比譬人的感情之深，是诗家常用的写法，如说汪伦的友情真象潭水那样深呀，当然也可以，但显得一般化，还有一点\"做诗\"的味道。现在的写法，好象两个友人船边饯别，一个\"劝君更进一杯酒\"，一个\"一杯一杯复一杯\"。李白酒酣情浓，意态飞扬，举杯对脚下悠悠流水说道:\"桃花潭水啊，别说您多么深了，可不及汪伦的友情深呢!\"口头语，眼前景，自有一种天真自然之趣，隐隐使人看到大诗人豪放不羁的个性。所以，清人沈德潜说:\"若说汪伦之情，比于潭水千尺，便是凡语。妙境只在一转换间。\"</p>', 'http://img.jssns.cn/SHILU/1/45722543033941142.png', 'http://img.jssns.cn/SHILU/1/0a9e1331d26526ae48fa4e5b38ba660f.jpg', null, 'album', 'ID535147574781280256', '108', null, '7', '432228697144033280', '2019-02-02 21:54:11', '168', '2019-02-12 14:30:51');
INSERT INTO `audio` VALUES ('ID541377299564462080', '《题西林壁》 宋·苏轼', 'http://img.jssns.cn/SHILU/1/a00cd2505386c2fde1fd115b8b05e3a1.mp3', '<h2>题西林壁 宋·苏轼</h2><p><br></p><p>横看成岭侧成峰，远近高低各不同。</p><p>不识庐山真面目，只缘身在此山中。</p><p><br></p><h2>注释</h2><p><strong style=\"color: rgb(230, 0, 0);\">题西林壁：</strong>写在西林寺的墙壁上。西林寺在庐山西麓。题：书写，题写。西林：西林寺，在江西庐山。</p><p><strong style=\"color: rgb(0, 102, 204);\">横看：</strong>从正面看。庐山总是南北走向，横看就是从东面西面看.</p><p><strong style=\"color: rgb(230, 0, 0);\">侧：</strong>侧面。</p><p><strong style=\"color: rgb(0, 102, 204);\">各不同：</strong>各不相同。</p><p><strong style=\"color: rgb(230, 0, 0);\">不识：</strong>不能认识，辨别。</p><p><strong style=\"color: rgb(0, 102, 204);\">真面目：</strong>指庐山真实的景色，形状。</p><p><strong style=\"color: rgb(230, 0, 0);\">缘：</strong>因为；由于。</p><p><strong style=\"color: rgb(0, 102, 204);\">此山：</strong>这座山，指庐山。</p><p><strong style=\"color: rgb(230, 0, 0);\">西林：</strong>西林寺，在现在江西省的庐山上。这首诗是题在寺里墙壁上的。</p><p><br></p><h2>译文</h2><p>从正面、侧面看庐山山岭连绵起伏、山峰耸立，从远处、近处、高处、低处看庐山，庐山呈现各种不同的样子。</p><p>我之所以认不清庐山真正的面目，是因为我人身处在庐山之中。</p><p><br></p><h2>赏析</h2><p>此诗描写庐山变化多姿的面貌，并借景说理，指出观察问题应客观全面，如果主观片面，就得不出正确的结论。</p><p><br></p><p>开头两句“横看成岭侧成峰，远近高低各不同”，实写游山所见。庐山是座丘壑纵横、峰峦起伏的大山，游人所处的位置不同，看到的景物也各不相同。这两句概括而形象地写出了移步换形、千姿万态的庐山风景。</p><p><br></p><p>结尾两句“不识庐山真面目，只缘身在此山中”，是即景说理，谈游山的体会。之所以不能辨认庐山的真实面目，是因为身在庐山之中，视野为庐山的峰峦所局限，看到的只是庐山的一峰一岭一丘一壑，局部而已，这必然带有片面性。这两句奇思妙发，整个意境浑然托出，为读者提供了一个回味经验、驰骋想象的空间。这不仅仅是游历山水才有这种理性认识。游山所见如此，观察世上事物也常如此。这两句诗有着丰富的内涵，它启迪人们认识为人处事的一个哲理——由于人们所处的地位不同，看问题的出发点不同，对客观事物的认识难免有一定的片面性；要认识事物的真相与全貌，必须超越狭小的范围，摆脱主观成见。</p><p><br></p><p>仁者见仁，智者见智。一首小诗激起人们无限的回味和深思。所以，《题西林壁》不单单是诗人歌咏庐山的奇景伟观，同时也是苏轼以哲人的眼光从中得出的真理性的认识。由于这种认识是深刻的，是符合客观规律的，所以诗中除了有谷峰的奇秀形象给人以美感之外，又有深永的哲理启人心智。因此，这首小诗格外来得含蓄蕴藉，思致渺远，使人百读不厌。</p><p><br></p><p>这首诗寓意十分深刻，但所用的语言却异常浅显。深入浅出，这正是苏轼的一种语言特色。苏轼写诗，全无雕琢习气。诗人所追求的是用一种质朴无华、条畅流利的语言表现一种清新的、前人未曾道的意境；而这意境又是不时闪烁着荧荧的哲理之光。从这首诗来看，语言的表述是简明的，而其内涵却是丰富的。也就是说，诗语的本身是形象性和逻辑性的高度统一。诗人在四句诗中，概括地描绘了庐山的形象的特征，同时又准确地指出看山不得要领的道理。鲜明的感性与明晰的理性交织一起，互为因果，诗的形象因此升华为理性王国里的典型，这就是人们为什么千百次的把后两句当作哲理的警句的原因。</p>', 'http://img.jssns.cn/SHILU/1/45722898055476924.png', 'http://img.jssns.cn/SHILU/1/c8fb4dfa949ccdb23e75d77b21278d9f.jpg', null, 'album', 'ID535147574781280256', '109', null, '8', '432228697144033280', '2019-02-02 22:00:06', '168', '2019-02-12 14:22:48');
INSERT INTO `audio` VALUES ('ID545558132303069184', '【班门弄斧】如何成为自己的伯乐？', 'http://img.jssns.cn/SHILU/1/fa35a7332081ea7065c3e773e1a62368.mp3', '<p>一说到这个成语，人们常会想到的是那种狂妄的人，在行家面前卖弄本领，不自量力。但婷婷老师倒觉得这个年轻木匠只是对自己的技艺满怀自信，绝不是狂妄自大。并且我主张小朋友们也要学习“班门弄斧”的精神。</p><p><br></p><p>是的，你没有听错。别着急，听完故事，你就明白婷婷老师为什么这样说了。</p><p><br></p><p>这个成语故事讲的是，从前有个叫鲁班的人，以手巧闻名，被奉为匠师之祖。行家们对他敬重得五体投地。有一天，一个年轻的木匠漫不经心地走到一个大红门的房子前，举起自己手里的斧子，说：“我这把斧子，别看它不起眼，可不管是什么木料，只要到了我的手里，用我的斧头这么一搞，就会做出漂亮无比的东西来。”旁边的人听了，觉得他太夸口，就指着身后的大红门说：“小师傅，那你能做出比这扇还好的门吗?”年轻的木匠傲慢地说：“不是我吹牛，告诉你们，我曾经当过鲁班的学生，难道还做不出这样一扇简单的大门来，简直是笑话。”众人听了，忍不住大笑起来，说：“这就是鲁班先生的家，这扇就是他亲手做的，你真的能做出比这扇还好的门吗?”那位年轻的木匠不好意思地跑掉了。</p><p><br></p><p>“班门弄斧”原意为在鲁班门前耍弄斧头，借此比喻在行家面前卖弄本领，是个贬义词。但婷婷老师要说的是，就现代社会而言，“班门弄斧”并非是坏事，<span style=\"color: red;\">甚至是每个人都要学习的本领。</span></p><p><img src=\"http://language.chinadaily.com.cn/images/attachement/jpg/site1/20151222/002564baf31317e3417c20.jpg\" alt=\"âå§æâçå¾çæç´¢ç»æ\"></p><p>大家都知道姚明，他曾是美国男子篮球联盟NBA的统治者之一，是迄今为止闯荡NBA最成功的中国篮球运动员。2002年，初入NBA的姚明不过是一个乳臭未干的小伙子。而他周围则是一帮身经百战的“祖师爷”，但姚明敢于在他们面前“弄斧”，最终成长为火箭队的“姚核心”。</p><p><br></p><p>试想下，如果姚明进入nba后不敢班门弄斧，展示自己“不那么成熟”的技艺，他还会像今天这么成功吗？</p><p><br></p><p>因此，班门弄斧显示出了“弄斧者”的自信，一个人若对自己都不自信，又怎敢到行家面前去献丑呢？正是因为他对自己有十足的信心，所以他才敢在行家面前显示自己的本事。也只有这么做才能得到行家的指点，让自己更上一层楼。所以，对有能力的弄斧者而言，班门弄斧的精神是必要的，是让自己被“伯乐”发现的好方法。</p><p><br></p><p>但也有一批不思进取之人，他们为了赚钱总是夸大自己的能力，欺骗那些毫无经验和见识的人。当这类人遇到懂行的专家时，只能灰溜溜逃走。这种班门弄斧的行为是必须抵制的！</p><p><br></p><p>因此，面对这些专家，我们需要有班门弄斧的精神，去向世俗观念发动挑战。这个社会需要创新，需要具有创新精神的人班门弄斧来推动社会的整体进步。</p><p><br></p><h2><strong>总结下这个成语的精髓：</strong></h2><p><strong>1、</strong>对弄斧者而言，我们即需要尽力提神自己的能力，也需要有敢于在专家面前摆弄能力的勇气和自信；</p><p><strong>2、</strong>&nbsp;对于班门而言，则要敢于接纳那些班门弄斧的新人，了解他们的思想，吸收他们的新鲜血液，让自己不落后于快速变化的时代。</p>', 'http://img.jssns.cn/SHILU/1/46719686497279879.png', 'http://img.jssns.cn/SHILU/1/696e3415978827c46c749eff462e5a67.jpeg', null, 'album', 'ID515539237269929986', '112', null, '9', '432228697144033280', '2019-02-14 10:53:14', '432228697144033280', '2019-02-14 10:55:14');
INSERT INTO `audio` VALUES ('ID545568366073479168', '猪笼草和小蚜虫', 'http://img.jssns.cn/SHILU/1/662a5cf9dbec13aa61f84a7144ed3a17.mp3', '<p>有一只小蚜虫，跟着它的爸爸妈妈和族人寄生在一棵大树的嫩芽里，整天和嫩芽抢好东西吃，有时吃完了还要咬小嫩叶，小嫩叶恨死它们了。</p><p><br></p><p>有一天，小蚜虫正在迷迷糊糊地睡着，忽然肚子一阵咕咕叫，把它闹醒了，它这才想起昨晚自己和哥哥生气还没有吃晚饭呢！爸爸妈妈出门串亲戚还没有回来，它想：如果等爸爸妈妈回来时，肚子早就饿瘪了，我已经长大了，应该自己去找吃的了。于是，它便起床洗漱，打扮得漂漂亮亮的，张开半透明的小翅膀出去找吃的了。</p><p><br></p><p>它飞呀飞呀，飞到一个公园里，公园里正在开菊花展览会，熙熙攘攘的人挤满了公园。五彩缤纷的菊花被设计成各种式样摆在公园的草地上、亭子里……美丽极了。小蚜虫钻进人群中看菊花，把眼都看花了。不知不觉中，小蚜虫飞到了菊花展览处，一双小眼睛在这些菊花中溜来溜去，在它的视线中出现了亭亭玉立的金丝菊。</p><p><br></p><p>它想：先下去填饱肚子再说吧！它飞下去，在金丝菊身上站稳，寻找最好吃的地方，它舔舔这儿，舔舔那儿，最后发现金丝菊那张白白胖胖的娃娃脸和嫩嫩的腿又香又甜，便决定在这两个地方发动进攻。它越吃越欢，痛得金丝菊叫起来：“哎哟哟，小蚜虫别咬了，你咬烂了我的腿，我就站不稳了，你咬坏了我的脸人们就不能欣赏我的美丽了！那这次菊花展览就会失去了意义。”</p><p><br></p><p>“哼！菊花展览会关我什么事？我又不需要看，我只要吃饱肚子去玩才是我的事呢！对不起了，美丽高贵的金丝菊！”小蚜虫就自顾自地津津有味地吃起来了。金丝菊可爱的脸蛋被咬得凹一块凸一块的，腿也被咬得歪歪扭扭的，金丝菊伤心得呜呜地哭了起来。小蚜虫才不理呢，吃饱了就玩去，它飞到一片大草地上去呼吸新鲜空气，做健身操去了。</p><p><br></p><p>小蚜虫正做得起劲，它被一株打扮得红红绿绿、长着长长的、宽宽的叶子、挂着一个长长的袋子的猪笼草吸引住了。它想：这个长长的袋子里肯定有好吃的东西，我先瞧瞧。小蚜虫揭开那个半开着的盖子，看见盖子和袋口上有一层细毛。它一尝，哇，这细毛上的蜜汁甜滋滋的，它就把脚站在袋口上准备饱食一顿。没想到它没有站稳就哧溜一下滑下去了。“哎哎哎！干什么这么滑呀？”</p><p><br></p><p>“哼！你这个好吃懒做的家伙，专门损人利己，你这是自投罗网，今天你是进得来出不去的啦。”猪笼草在一旁开口了。</p><p><br></p><p>小蚜虫把眼睛瞪得大大的，还想张口说什么，但猪笼口袋的积水冒了一个泡，小蚜虫就永远消失了。</p>', 'http://img.jssns.cn/SHILU/1/46722126203693887.png', 'http://img.jssns.cn/SHILU/1/6888578eddece829a3f1dab3f85b9495.jpeg', null, 'album', 'ID515538987750785024', '102', null, '2', '432228697144033280', '2019-02-14 11:33:54', '432228697144033280', '2019-02-14 11:40:26');
INSERT INTO `audio` VALUES ('ID545568979322667008', '幸福的小海豚', 'http://img.jssns.cn/SHILU/1/467e9f7ef3e098482c724dba17ca9068.mp3', '<p>在蔚蓝的大海中，生活着一条可爱的小海豚，他有一只拥有魔力的海螺壳，那是他参加游泳比赛的冠军奖品。这只海螺壳能为拥有者实现一次愿望。小海豚一直没有使用，因为机会只有一次，而他还没有想好是要一件缀满宝石的漂亮衣服，还是要一座种满鲜花的美丽花园。</p><p><br></p><p>这一天，小海豚像往常一样，趁着涨潮的时候游到礁石区去玩。忽然，他发现周围的深水区有几条鲨鱼在游弋。不过，这拦不住他，小海豚轻松地就摆脱了鲨鱼游进了浅水区。这时，小海豚听到了“呜呜”的哭泣声。小海豚向着哭声游去，发现了一只受伤的小海龟。小海龟的前肢被鲨鱼咬伤了，鲜血直流，只能躲在浅水区里。但是，那些鲨鱼还在周围水深的地方等待着潮水的上涨，小海龟的处境非常危险。</p><p><br></p><p>小海豚一连想了好几个办法，但都不能解决这个危机。唯一能够救出小海龟的办法就是立刻治好受伤的前肢，然后躲到礁石后面去，这个办法只有用魔法海螺才能实现。可是，魔法只能用一次，给小海龟治伤了，小海豚自己的愿望就不能实现了。看着随潮水渐渐逼近的鲨鱼，小海豚下定了决心，拿出了魔法海螺。他紧紧捧着海螺，心中默默地许下治好小海螺的愿望。只见七彩的魔法海螺发出耀眼的金光，照射到小海龟的伤口上，在一阵亮的刺眼的白光过后，小海龟的前肢完全恢复了。周围的鲨鱼也被白光吓跑了，小海龟得救了。失去神力的海螺壳变得黯淡无光，在小海豚手中无声地裂开了，化成了粉末，消散在大海中。</p><p><br></p><p>小海豚虽然失去了实现自己愿望的机会，但是却一点也不难过，因为给予是最幸福的。</p>', 'http://img.jssns.cn/SHILU/1/46722273073737237.png', 'http://img.jssns.cn/SHILU/1/784d9ee0df2796a897183d70c2736d43.jpeg', null, 'album', 'ID515538987750785024', '114', null, null, '432228697144033280', '2019-02-14 11:36:20', '432228697144033280', '2019-02-14 11:36:20');
INSERT INTO `audio` VALUES ('ID545571653778669568', '猪笼草与小蚜虫', 'http://img.jssns.cn/SHILU/1/662a5cf9dbec13aa61f84a7144ed3a17.mp3', '<p>有一只小蚜虫，跟着它的爸爸妈妈和族人寄生在一棵大树的嫩芽里，整天和嫩芽抢好东西吃，有时吃完了还要咬小嫩叶，小嫩叶恨死它们了。</p><p><br></p><p>有一天，小蚜虫正在迷迷糊糊地睡着，忽然肚子一阵咕咕叫，把它闹醒了，它这才想起昨晚自己和哥哥生气还没有吃晚饭呢！爸爸妈妈出门串亲戚还没有回来，它想：如果等爸爸妈妈回来时，肚子早就饿瘪了，我已经长大了，应该自己去找吃的了。于是，它便起床洗漱，打扮得漂漂亮亮的，张开半透明的小翅膀出去找吃的了。</p><p><br></p><p>它飞呀飞呀，飞到一个公园里，公园里正在开菊花展览会，熙熙攘攘的人挤满了公园。五彩缤纷的菊花被设计成各种式样摆在公园的草地上、亭子里……美丽极了。小蚜虫钻进人群中看菊花，把眼都看花了。不知不觉中，小蚜虫飞到了菊花展览处，一双小眼睛在这些菊花中溜来溜去，在它的视线中出现了亭亭玉立的金丝菊。它想：先下去填饱肚子再说吧！它飞下去，在金丝菊身上站稳，寻找最好吃的地方，它舔舔这儿，舔舔那儿，最后发现金丝菊那张白白胖胖的娃娃脸和嫩嫩的腿又香又甜，便决定在这两个地方发动进攻。它越吃越欢，痛得金丝菊叫起来：“哎哟哟，小蚜虫别咬了，你咬烂了我的腿，我就站不稳了，你咬坏了我的脸人们就不能欣赏我的美丽了！那这次菊花展览就会失去了意义。”</p><p><br></p><p>“哼！菊花展览会关我什么事？我又不需要看，我只要吃饱肚子去玩才是我的事呢！对不起了，美丽高贵的金丝菊！”小蚜虫就自顾自地津津有味地吃起来了。金丝菊可爱的脸蛋被咬得凹一块凸一块的，腿也被咬得歪歪扭扭的，金丝菊伤心得呜呜地哭了起来。小蚜虫才不理呢，吃饱了就玩去，它飞到一片大草地上去呼吸新鲜空气，做健身操去了。</p><p><br></p><p>小蚜虫正做得起劲，它被一株打扮得红红绿绿、长着长长的、宽宽的叶子、挂着一个长长的袋子的猪笼草吸引住了。它想：这个长长的袋子里肯定有好吃的东西，我先瞧瞧。小蚜虫揭开那个半开着的盖子，看见盖子和袋口上有一层细毛。它一尝，哇，这细毛上的蜜汁甜滋滋的，它就把脚站在袋口上准备饱食一顿。没想到它没有站稳就哧溜一下滑下去了。“哎哎哎！干什么这么滑呀？”</p><p><br></p><p>“哼！你这个好吃懒做的家伙，专门损人利己，你这是自投罗网，今天你是进得来出不去的啦。”猪笼草在一旁开口了。</p><p><br></p><p>小蚜虫把眼睛瞪得大大的，还想张口说什么，但猪笼口袋的积水冒了一个泡，小蚜虫就永远消失了。</p>', 'http://img.jssns.cn/SHILU/1/46722910044700739.png', 'http://img.jssns.cn/SHILU/1/6888578eddece829a3f1dab3f85b9495.jpeg', null, 'album', 'ID515538987750785024', '109', null, null, '432228697144033280', '2019-02-14 11:46:58', '432228697144033280', '2019-02-14 11:46:58');
INSERT INTO `audio` VALUES ('ID546019894789931008', '《九月九日忆山东兄弟》唐·王维', 'http://img.jssns.cn/SHILU/1/6f35be3ce4614dde234966487827f79e.mp3', '<h2><strong>九月九日忆山东兄弟</strong></h2><p>唐代：王维</p><p>独在异乡为异客，每逢佳节倍思亲。</p><p>遥知兄弟登高处，遍插茱萸少一人。</p><p><br></p><h2>注释:</h2><p><span style=\"color: rgb(230, 0, 0);\">九月九日</span>：即重阳节。古以九为阳数，故曰重阳。</p><p><span style=\"color: rgb(230, 0, 0);\">忆：</span>想念。</p><p><span style=\"color: rgb(230, 0, 0);\">山东</span>：王维迁居于蒲县（今山西永济县），在函谷关与华山以东，所以称山东。</p><p><span style=\"color: rgb(230, 0, 0);\">异乡</span>：他乡、外乡。&nbsp;</p><p><span style=\"color: rgb(230, 0, 0);\">为异客</span>：作他乡的客人。</p><p><span style=\"color: rgb(230, 0, 0);\">佳节</span>：美好的节日。</p><p><span style=\"color: rgb(230, 0, 0);\">登高</span>：古有重阳节登高的风俗。</p><p><span style=\"color: rgb(230, 0, 0);\">茱萸（zhūyú）</span>：一种香草，即草决明。古时人们认为重阳节插戴茱萸可以避灾克邪。</p><p><br></p><h2>译文：</h2><p>独自远离家乡无法与家人团聚，每到重阳佳节倍加思念远方的亲人。</p><p>远远想到兄弟们身佩茱萸登上高处，也会因为少我一人而生遗憾之情。</p><p><br></p><h2>赏析：</h2><p>王维是一位早熟的作家，少年时期就创作了不少优秀的诗篇。这首诗就是他十七岁时的作品。和他后来那些富于画意、构图设色非常讲究的山水诗不同，这首抒情小诗写得非常朴素。但千百年来，人们在作客他乡的情况下读这首诗，却都强烈地感受到了它的力量。这种力量，首先来自它的朴质、深厚和高度的概括。</p><p><br></p><p>前两句，可以说是艺术创作的“直接法”。几乎不经任何迂回，而是直插核心，迅即形成高潮，出现警句。但这种写法往往使后两句难以为继，造成后劲不足。这首诗的后两句，如果顺着“佳节倍思亲”作直线式的延伸，就不免蛇足；转出新意而再形成新的高潮，也很难办到。作者采取另一种方式：紧接着感情的激流，出现一泓微波荡漾的湖面，看似平静，实则更加深沉。</p><p><br></p><p>重阳节有登高的风俗，登高时佩带茱萸囊，据说可以避灾。茱萸，又名越椒，一种有香气的植物。三四两句，如果只是一般化地遥想兄弟如何在重阳日登高，佩带茱萸，而自己独在异乡，不能参与，虽然写出了佳节思亲之情，但会显得平直，缺乏新意与深情。诗人遥想的却是：“遍插茱萸少一人。”意思是说，远在故乡的兄弟们今天登高时身上都佩上了茱萸，却发现少了一位兄弟──自己不在内。好像遗憾的不是自己未能和故乡的兄弟共度佳节，反倒是兄弟们佳节未能完全团聚；似乎自己独在异乡为异客的处境并不值得诉说，反倒是兄弟们的缺憾更须体贴。这就曲折有致，出乎常情。而这种出乎常情之处，正是它的深厚处、新警处。</p>', 'http://img.jssns.cn/SHILU/1/46829779622577790.png', 'http://img.jssns.cn/SHILU/1/86fd7fd28181483f1f7fc5d302e08567.jpg', null, 'album', 'ID535147574781280256', '110', null, '0', '168', '2019-02-15 17:28:07', '168', '2019-02-15 17:59:48');
INSERT INTO `audio` VALUES ('ID546021548780158976', '《山行》唐·杜牧', 'http://img.jssns.cn/SHILU/1/a331d4732c82c92e83789d55e1c4ae41.mp3', '<h2>山行</h2><p>唐：杜牧</p><p>远上寒山石径斜，白云深处有人家。</p><p>停车坐爱枫林晚，霜叶红于二月花。</p><p><br></p><h2>注释:</h2><p><span style=\"color: rgb(230, 0, 0);\">山行</span>：在山中行走。</p><p><span style=\"color: rgb(230, 0, 0);\">远上</span>：登上远处的。</p><p><span style=\"color: rgb(230, 0, 0);\">寒山</span>：深秋季节的山。</p><p><span style=\"color: rgb(230, 0, 0);\">石径</span>：石子的小路。</p><p><span style=\"color: rgb(230, 0, 0);\">斜</span>：为倾斜的意思。</p><p><span style=\"color: rgb(230, 0, 0);\">深</span>：另有版本作“生”。（“深”可理解为在云雾缭绕的的深处； “生”可理解为在形成白云的地方）</p><p><span style=\"color: rgb(230, 0, 0);\">车：</span>轿子。</p><p><span style=\"color: rgb(230, 0, 0);\">坐</span>：因为。</p><p><span style=\"color: rgb(230, 0, 0);\">霜叶</span>：枫树的叶子经深秋寒霜之后变成了红色。</p><p><span style=\"color: rgb(230, 0, 0);\">枫林晚</span>：傍晚时的枫树林。</p><p><span style=\"color: rgb(230, 0, 0);\">红于</span>：比……更红，本文指霜叶红于二月花</p><p><br></p><h2>译文：</h2><p>沿着弯弯曲曲的小路上山，在那白云深处，居然还有人家。</p><p>停下车来，是因为喜爱这深秋枫林晚景。枫叶秋霜染过，艳比二月春花。</p><p>&nbsp;</p><h2>&nbsp;赏析：</h2><p>这首诗展现出一幅动人的山林秋色图。诗里写了山路、人家、白云、红叶，构成一幅和谐统一的画面。这些景物不是并列的处于同等地位，而是有机地联系在一起，有主有从，有的处于画面的中心，有的则处于陪衬地位。简单来说，前三句是宾，第四句是主，前三句是为第四句描绘背景、创造气氛，起铺垫和烘托作用的。</p><p><br></p><p>“远上寒山石径斜”，写山，写山路。一条弯弯曲曲的小路蜿蜓伸向山头。“远”字写出了山路的绵长，“斜”字与“上”字呼应，写出了高而缓的山势。</p><p><br></p><p>“白云深处有人家”，写云，写人家。诗人的目光顺着这条山路一直向上望去，在白云飘浮的地方，有几处山石砌成的石屋石墙。这里的“人家”照应了上句的“石径”，—这一条山间小路，就是那几户人家上上下下的通道。这样就把两种景物有机地联系在一起了。有白云缭绕，说明山很高。诗人用横云断岭的手法，让这片片白云遮住读者的视线，却给人留下了想象的空间：在那白云之上，云外有山，一定会有另一种景色。</p><p><br></p><p>对这些景物，诗人只是在作客观的描述。虽然用了一个“寒”字，也只是为了逗出下文的“晚”字和“霜”字，并不表现诗人的感情倾向。它毕竟还只是在为后面的描写蓄势—勾勒枫林所在的环境。</p><p>“停车坐爱枫林晚”便不同了，倾向性已经很鲜明，很强烈了。那山路、白云、人家都没有使诗人动心，这枫林晚景却使得他惊喜之情难以抑制。为了要停下来领略这山林风光，竟然顾不得驱车赶路。这句中的“晚”字用得无比精妙，它蕴含多层意思：（1）点明前两句是白天所见，后两句则是傍晚之景。（2）因为傍晚才有夕照，绚丽的晚霞和红艳的枫叶互相辉映，枫林才格外美丽。（3）诗人流连忘返，到了傍晚，还舍不得登车离去，足见他对红叶喜爱之极。（4）因为停车甚久，观察入微，才能悟出第四句“霜叶红于二月花”这样富有理趣的警句。</p><p><br></p><p>第四句是全诗的中心，是诗人浓墨重彩、凝聚笔力写出来的。不仅前两句疏淡的景致成了这艳丽秋色的衬托，即使“停车坐爱枫林晚”一句，看似抒情叙事，实际上也起着写景衬托的作用：那停车而望、陶然而醉的诗人，也成了景色的一部分，有了这种景象，才更显出秋色的迷人。而一笔重写之后，戛然便止，又显得情韵悠扬，余味无穷。</p><p><br></p><p>全诗构思新颖，布局精巧，于萧瑟秋风中摄取绚丽秋色，与春光争胜，令人赏心悦目，精神发越。兼之语言明畅，音韵和谐。</p>', 'http://img.jssns.cn/SHILU/1/46830173311802713.png', 'http://img.jssns.cn/SHILU/1/2b285ce0f9134ce21bdd738685068871.jpg', null, 'album', 'ID535147574781280256', '130', null, null, '168', '2019-02-15 17:34:41', '168', '2019-02-15 17:34:41');
INSERT INTO `audio` VALUES ('ID547435337442394112', '圣诞节和平安夜的美妙传说', 'http://img.jssns.cn/SHILU/1/bdc3a0aaafb4042d81469bc2b34de358.mp3', '<p><span style=\"color: rgb(51, 51, 51);\">圣诞节是为了庆祝耶稣的出生而设立的，平安夜则是报耶稣即将降生消息的日子，所以平安夜是圣诞节的铺垫，是为迎接圣诞节而做准备的节日。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">圣诞节的时间是每年12月25日，平安夜就是每年12月24日啦，平安夜永远在圣诞节的前一天，因此人们一般都是先过平安夜再过圣诞节。这很像我们国家的除夕和春节，我们也是过完了除夕再过春节。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">西方国家在平安夜晚上会选择回家和家人聚在一起，这一天远在各地的家人都会聚集在一起开party或者聚会，一起围着圣诞树唱圣诞歌曲，吃圣诞大餐，然后分享彼此之间的所见所闻，表达对对方的思念之情。这就和我们的除夕夜一样，家庭团聚是这一天的主题。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">而我们中国人则会在平安夜这天选择去逛街，购买各种打折商品，享受外国圣诞节的气氛。当然，我们也有个非常独特的庆祝平安夜的方式——送苹果，苹果的“苹”与平安的“平”同音，因此送别人苹果就是送别人平安的意思，于是就有了平安夜送苹果的习俗。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">当然，正如除夕夜爸爸妈妈会给小朋友红包一样，在平安夜的晚上，国外的父母会准备好礼物放在孩子的圣诞袜里，等着孩子们醒来拆收礼物。</span></p><p><span style=\"color: rgb(51, 51, 51);\">所以，圣诞节这天，孩子们的主要活动就是交换圣诞礼物，给好友寄圣诞卡片。聚会也是少不了的，在圣诞节这天聚餐会更丰盛，有猪肉、烤火鸡、树干蛋糕、杏仁布丁、姜饼等等。</span></p>', 'http://img.jssns.cn/SHILU/1/47167247276544273.png', 'http://img.jssns.cn/SHILU/1/5992e0152a1bf59a8f31197558730d59.jpg', null, 'album', 'ID547426536010022912', '113', null, '10', '168', '2019-02-19 15:12:35', '168', '2019-02-19 17:28:01');
INSERT INTO `audio` VALUES ('ID547461763847684096', '万圣节', 'http://img.jssns.cn/SHILU/1/1d013d6d2950ca4d7443add475af3a54.mp3', '<p><span style=\"color: rgb(51, 51, 51);\">我们常用单词“Halloween”来表示“万圣节”，不过它还有另外一个英文名字叫作：All Saint\'s Day。而Saint这个单词表示“圣徒”的意思，所以All Saint\'s Day翻译过来就是“所有圣徒的节日”。咿，万圣节为什么会是所有圣徒的节日呢？这一切要从2000年前说起。</span></p><p><br></p><p><span style=\"color: rgb(43, 43, 43);\">2000年前，生活在现在的爱尔兰、英国和法国北部的凯尔特人完全靠农作物为生，而我们都知道农作物的生长是非常依赖自然环境的，自然环境恰恰是人类难以控制的。所以，每当夏天到来的时候，他们会开始种植农作物并在秋天进行收获；而到冬天来临的时候，不仅农作物无法种植，甚至他们自己也可能被寒冷所击倒。</span></p><p><br></p><p><span style=\"color: rgb(43, 43, 43);\">因此，凯尔特人相信太阳神可以帮助他们种植农作物。但是，每年太阳神都会被一个名叫萨温的邪恶力量攻击并被囚禁六个月。小朋友，你想想看，从夏天结束到冬天结束正好6个月，可见，古凯尔特人认为这段时间之所以好少出太阳，就是因为太阳神被这个邪恶的萨温吃掉了。</span></p><p><br></p><p><span style=\"color: rgb(43, 43, 43);\">同时，由于11月1日这天正好是夏季和收获季节的结束以及黑暗和寒冷冬天的开始，所以凯尔特人相信这天也是生和死的边界。因此，凯尔特人非常害怕10月31日的夜晚，他们觉得这晚，有一堆邪恶的萨温会带着一群邪恶的灵魂潜伏在自己的身边。为了驱赶萨温等恶魔，他们不仅会在家里生起红红的火焰，更会把自己装扮成很可怕的样子。</span></p><p><br></p><p><span style=\"color: rgb(43, 43, 43);\">后来，罗马占领了凯尔特人的土地，他们把罗马的节日和凯尔特人10月31日的萨温祭典合在一起，这就成了现在的万圣节。</span></p><p><br></p><p><strong>现在，你知道了万圣节的由来，那么万圣节有什么样的习俗呢？</strong></p><p><br></p><p><strong style=\"color: rgb(128, 0, 0);\">1、面具化装</strong></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">在古时候，如果有旱灾或是其它重大的灾难，人们便会带上丑陋的面具，因为他们害怕深夜还在外面游走的恶灵，如果晚上必须出门，便会戴上面具或用动物的皮毛装饰自己，希望恶灵认不出他们来，或被丑陋的面具吓走。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">后来敬畏鬼神的宗教意味逐渐转薄，慢慢开始有小孩穿上鬼和精灵的衣服，出去吓邻居 trick or treat（不给糖，就捣蛋），要大人请吃糖果的趣味习俗。</span></p><p><br></p><p><strong style=\"color: rgb(128, 0, 0);\">2、南瓜灯</strong></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">在万圣节还有雕刻南瓜灯的习俗，这是一则趣味的爱尔兰的民间传说。据说有一个名叫杰克的酒鬼，他有一天邀请恶灵来一起喝酒，但喝完后却没钱付账，他就设计要恶灵变成六便士来付酒钱，可是杰克又没拿它来付钱，反而用一条银纸镇住恶灵让它出不来。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">恶灵苦苦哀求杰克放他出来并答应不来吓他、骚扰他，于是杰克就它出来，到了第二年万圣节，恶灵又与杰克达成协议，答应这一年不会来骚扰杰克，但没过多久杰克就过世了，这时天堂拒绝收容他，杰克只好到地狱报到，可是因为恶灵已经答应他这一年不骚扰他，所以也无法收容杰克。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">天堂地狱都去不得，杰克怎么办呢？而且路实在是太黑了，杰克也找不出路离开，这时恶灵就丢给他一块已经烧得通红的煤炭让他在黑暗的地狱中比较能看清楚路，杰克将这小块媒炭灰烬放在一个打了许多洞的菜头当中，好让它烧久一点。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">根据这个传说，后来爱尔兰人就用菜头来制作他们所谓的\"杰克灯笼\"。但是当移民们到了美国之后，发现新大陆的南瓜比菜头普遍，于是改为用南瓜雕刻成各种鬼脸，然后在里面摆蜡烛了，这就是“南瓜灯”的由来。</span></p>', 'http://img.jssns.cn/SHILU/1/47173547409848143.png', 'http://img.jssns.cn/SHILU/1/a3f5aa0bbbf937abdc05d2cd14dc71bb.jpg', null, 'album', 'ID547426536010022912', '108', null, '9', '168', '2019-02-19 16:57:35', '168', '2019-02-19 17:56:32');
INSERT INTO `audio` VALUES ('ID547468661670019072', '元旦', 'http://img.jssns.cn/SHILU/1/d24f900bc79948ae006973e2ac047b0e.mp3', '<p><span style=\"color: rgb(62, 62, 62);\">据传说咱们中国的元旦，起于三皇五帝之一的颛顼，距今已有3000多年的历史了。“元旦”一词最早出现于《晋书》：“颛帝以孟夏正月为元，其实正朔元旦之春”的诗中。南北朝时，南朝萧子云的《介雅》诗中也有“四季新元旦，万寿初春朝”的记载。</span></p><p><br></p><p><span style=\"color: rgb(62, 62, 62);\">中国最早称农历正月初一为“元旦”，元是“初”、“始”的意思，旦指“日子”，元旦合称即是“初始的日子”，也就是一年的第一天。正月初一从哪日算起，在汉武帝以前也是很不统一的。因此，历代的元旦月、日也并不一致。夏朝的夏历以孟喜月（元月）为正月，商朝的殷历以腊月（十二月）为正月，周朝的周历以冬月（十一月）为正月。秦始皇统一中国后，又以阳春月（十月）为正月，即十月初一为元旦。从汉武帝起，才规定孟喜月（元月）为正月，把孟喜月的第一天（夏历的正月初一）称为元旦，一直沿用到清朝末年。但这是夏历，亦即农历或阴历，还不是我们今天所说的元旦。</span></p><p><br></p><p><span style=\"color: rgb(62, 62, 62);\">今天所说的“元旦”，是公元1949年9月27日，中国人民政治协商会议第一次全体会议，在决定建立中华人民共和国的同时，也决定采用世界通用的公元纪年法，并将公历１月１日正式定为“元旦”，农历正月初一改为“春节”。</span></p><p><br></p><p><span style=\"color: rgb(62, 62, 62);\">不管是世界上哪个国家的人们，都对新的一年充满美好的希冀。“百里不同风，千里不同俗”，由于各个国家和地区de 历史、文化、宗教信仰、民族习惯不同，因此也都有自己不同的庆祝新年的习俗。在这辞旧迎新的日子里，世界各国的人们都以其别出心裁、独具特色的方式迎接新年的到来。</span></p><p><br></p><p><span style=\"color: rgb(62, 62, 62);\">在德国，元旦期间，家家户户都摆上枞树和横树，树叶间系满绢花。在新年到来前一刻，他们爬到椅子上，钟声一响，就跳下椅子，并将一重物抛向椅背后，以示甩去祸患，跳入新年。</span></p><p><span style=\"color: rgb(62, 62, 62);\">在法国呢，他们以酒来庆祝新年，狂欢痛饮直到1月3日。法国人认为元旦的天气预示着新一年的年景，清晨就上街看风向来占卜。</span></p><p><br></p><p><span style=\"color: rgb(62, 62, 62);\">英国的元旦则有“打井水”的风俗，人们都争取第一个去打水，认为第一个打水人为幸福之人，打来的水是吉祥之水。</span></p><p><span style=\"color: rgb(62, 62, 62);\">希腊的元旦，家家做一个大蛋糕，里面放一枚银币。主人将蛋糕切若干块，分给家人或来访的亲朋好友。谁吃到带有银币的蛋糕，就成了新年最幸运的人，大家都向他祝贺。</span></p><p><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(62, 62, 62);\">我们中国的元旦由春节演化而来，在民国年间诞生，所以庆祝元旦的风俗习惯大都类似于春节。到了现代，元旦的庆祝方法比较普遍的就是由团体组织的活动，如元旦联欢会、挂庆祝元旦的标语、或举行集体活动等。以前有组织敲锣打鼓、集体跳民族舞的，现在在</span><a href=\"https://baike.sogou.com/v4976777.htm?ch=ww.wap.chain.baike\" target=\"_blank\" style=\"color: rgb(62, 62, 62);\">电视记录片</a><span style=\"color: rgb(62, 62, 62);\">上还能看到。到科技发展的今天，就演变为联欢晚会什么的了。近年更是有旅游、聚会等节目，反正元旦这天并没有太多的传统，在这一天放假了，开心最重要啦！</span></p>', 'http://img.jssns.cn/SHILU/1/47175192159354708.png', 'http://img.jssns.cn/SHILU/1/86931f11c29250a6f4897b8fff850d4b.jpg', null, 'album', 'ID547426536010022912', '109', null, '8', '168', '2019-02-19 17:25:00', '168', '2019-02-19 17:57:03');
INSERT INTO `audio` VALUES ('ID547476409900072960', '元宵节', 'http://img.jssns.cn/SHILU/1/916d7e84a4c27b75b626e64385efa0d8.mp3', '<p><span style=\"color: rgb(230, 0, 0);\">“元”</span><span style=\"color: rgb(51, 51, 51);\">指的是古代的元月，现在称为正月。</span><span style=\"color: rgb(230, 0, 0);\">“宵”</span><span style=\"color: rgb(51, 51, 51);\">意思是“夜晚“。</span><span style=\"color: rgb(230, 0, 0);\">“节”</span><span style=\"color: rgb(51, 51, 51);\">当然就是节日的意思。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\"><span class=\"ql-cursor\">﻿</span>那么为何大家要在这一天庆祝呢？正月十五这天有什么特殊的地方吗？实际上，这天意味着一年的开始，大地回春的开启，而这天夜晚也是一年中的第一个</span><a href=\"https://www.baidu.com/s?wd=%E6%9C%88%E5%9C%86%E4%B9%8B%E5%A4%9C&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">月圆之夜</a><span style=\"color: rgb(51, 51, 51);\">，抬起头你会看到比平时圆的多、亮的多的月亮。</span></p><p><br></p><p>元宵节也称灯节，元宵燃灯的风俗起自汉朝，到了唐代，赏灯活动更加兴盛，皇宫里、街道上处处挂灯，还要建立高大的灯轮、灯楼和灯树，唐朝大诗人卢照邻曾在《十五夜观灯》这首诗中这样描述元宵节燃灯的盛况：“接汉疑星落，依楼似月悬。”这句诗的意思是：远处的灯光恍若点点繁星坠地，靠楼的灯光则似明月高悬。</p><p><br></p><p>宋代比唐代更重视元宵节，赏灯活动也更加热闹，赏灯活动要进行整整5天，灯的样式也格外丰富。明代则更进一步，要连续赏灯10天，这是中国历史上最长的灯节了。清代赏灯活动虽然只有3天，但是赏灯活动规模空间盛大，除燃灯这类基本节目外，还会燃放大量烟花来助兴。 </p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">当然，这么有纪念意义的节日，肯定不止这些游戏。从南宋开始，元宵节增加了一个全新的环节——“猜灯谜”，这天，</span>&nbsp;<span style=\"color: rgb(51, 51, 51);\">人们会把谜语写在纸条上，之后把谜条系于五彩花灯上来让路人猜测。</span></p><p><span style=\"color: rgb(51, 51, 51);\">好了，接下来我来讲讲吃元宵这个习俗吧。这个习俗大约形成于宋代。据记载，唐朝时，元宵节吃“面茧”、“圆不落角”，俗称面疙瘩。而到了南宋，出现了“乳糖圆子”，这就是</span><a href=\"https://www.baidu.com/s?wd=%E6%B1%A4%E5%9C%86&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">汤圆</a><span style=\"color: rgb(51, 51, 51);\">的前身。</span></p><p><span style=\"color: rgb(51, 51, 51);\">元宵一开始多被称为“</span><a href=\"https://www.baidu.com/s?wd=%E6%B1%A4%E5%9C%86&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">汤圆</a><span style=\"color: rgb(51, 51, 51);\">”，因为它开锅之后漂在水上，煞是好看，让人联想到一轮明月挂在云空。天上明月，碗里</span><a href=\"https://www.baidu.com/s?wd=%E6%B1%A4%E5%9C%86&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">汤圆</a><span style=\"color: rgb(51, 51, 51);\">，家家户户团团圆圆，象征着团圆吉利。因此，吃元宵表达的是人们喜爱阖家团圆的美意。同时也显示</span><a href=\"https://www.baidu.com/s?wd=%E4%B8%AD%E5%9B%BD%E4%BA%BA&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">中国人</a><span style=\"color: rgb(51, 51, 51);\">对传统节日的传承，也是对</span><a href=\"https://www.baidu.com/s?wd=%E4%B8%AD%E5%9B%BD%E6%96%87%E5%8C%96&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">中国文化</a><span style=\"color: rgb(51, 51, 51);\">的一种热爱。</span></p><p><br></p><p> 一些地方的元宵节还有“走百病”的习俗，又称“烤百病”“散百病”，参与者多为妇女，他们结伴而行，走过墙，走过桥，走过郊外，目的是为了能够驱病除灾。</p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\"> 随着时间的推移，元宵节的活动越来越多，不少地方节庆时增加了耍龙灯、耍狮子、踩高跷、划旱船、扭秧歌、打太平鼓等传统民俗表演。这个传承着两千多年的传统节日，不仅盛行于海峡两岸，就是在海外华人的聚居区也年年欢庆不衰哦。</span></p>', 'http://img.jssns.cn/SHILU/1/47177039288374874.png', 'http://img.jssns.cn/SHILU/1/9b337b50dddc63828ef347cff6ee8dfe.jpg', null, 'album', 'ID547426536010022912', '122', null, null, '168', '2019-02-19 17:55:47', '168', '2019-02-19 17:55:47');
INSERT INTO `audio` VALUES ('ID548205419797938176', '《回乡偶书》唐·贺知章', 'http://img.jssns.cn/SHILU/1/0afd936627adb3e5ec234db469b4103d.mp3', '<h2><span style=\"color: rgb(15, 15, 15);\">回乡偶书</span></h2><p><span style=\"color: rgb(15, 15, 15);\">唐：</span><a href=\"https://so.gushiwen.org/authorv_79e0e9d1f260.aspx\" target=\"_blank\" style=\"color: rgb(15, 15, 15);\">贺知章</a></p><p><span style=\"color: rgb(15, 15, 15);\">少小离家老大回，乡音无改鬓毛衰。</span></p><p><span style=\"color: rgb(15, 15, 15);\">儿童相见不相识，笑问客从何处来。</span></p><p><br></p><h2><span style=\"color: rgb(51, 51, 51);\">注释：</span></h2><p><span style=\"color: rgb(255, 0, 0);\">偶书</span><span style=\"color: rgb(51, 51, 51);\">：随便写的</span><a href=\"https://so.gushiwen.org/shiwenv_f459f8ed8d23.aspx\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">诗</a><span style=\"color: rgb(51, 51, 51);\">。</span></p><p><span style=\"color: rgb(255, 0, 0);\">偶</span><span style=\"color: rgb(51, 51, 51);\">：说明诗写作得很偶然，是随时有所见、有所感就写下来的。</span></p><p><span style=\"color: rgb(255, 0, 0);\">少小离家</span><span style=\"color: rgb(51, 51, 51);\">：</span><a href=\"https://so.gushiwen.org/authorv_79e0e9d1f260.aspx\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">贺知章</a><span style=\"color: rgb(51, 51, 51);\">三十七岁中进士，在此以前就离开家乡。</span></p><p><span style=\"color: rgb(255, 0, 0);\">老大</span><span style=\"color: rgb(51, 51, 51);\">：年纪大了。贺知章回乡时已年逾八十。</span></p><p><span style=\"color: rgb(255, 0, 0);\">乡音</span><span style=\"color: rgb(51, 51, 51);\">：家乡的口音。</span></p><p><span style=\"color: rgb(255, 0, 0);\">无改：</span><span style=\"color: rgb(51, 51, 51);\">没什么变化。一作“难改”。</span></p><p><span style=\"color: rgb(255, 0, 0);\">鬓毛</span><span style=\"color: rgb(51, 51, 51);\">：额角边靠近耳朵的头发。一作“面毛”。</span></p><p><span style=\"color: rgb(255, 0, 0);\">衰</span><span style=\"color: rgb(51, 51, 51);\">：减少，疏落。鬓毛衰：指鬓毛减少，疏落。</span></p><p><span style=\"color: rgb(255, 0, 0);\">相见</span><span style=\"color: rgb(51, 51, 51);\">：即看见我；相：带有指代性的副词。不相识：即不认识我。</span></p><p><span style=\"color: rgb(255, 0, 0);\">笑问</span><span style=\"color: rgb(51, 51, 51);\">：一本作“却问”，一本作“借问”</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">译文：</span></h2><p><span style=\"color: rgb(15, 15, 15);\">我在年少时离开家乡，到了迟暮之年才回来。我的乡音虽未改变，但鬓角的毛发却已经疏落。儿童们看见我，没有一个认识的。他们笑着询问：这客人是从哪里来的呀？　</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">赏析：</span></h2><p><span style=\"color: rgb(15, 15, 15);\">这是一首久客异乡、缅怀故里的感怀</span><a href=\"https://so.gushiwen.org/shiwenv_f459f8ed8d23.aspx\" target=\"_blank\" style=\"color: rgb(25, 83, 125);\"><u>诗</u></a><span style=\"color: rgb(15, 15, 15);\">。在第一、二句中，诗人置身于故乡熟悉而又陌生的环境之中，心情颇不平静：当年离家，风华正茂；今日返归，鬓毛疏落，不禁感慨万分。首句用“少小离家”与“老大回”的句中自对，概括写出数十年久客他乡的事实，暗寓自伤“老大”之情。又以“鬓毛衰”顶承上句，具体写出自己的“老大”之态，并以不变的“乡音”映衬变化了的“鬓毛”，言下大有“我不忘故乡，故乡可还认得我吗”之意，从而为唤起下两句儿童不相识而发问作好铺垫。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">三四句从充满感慨的一幅自画像，转而为富于戏剧性的儿童笑问的场面。“笑问客从何处来”，在儿童，这只是淡淡的一问，言尽而意止；在诗人，却成了重重的一击，引出了他的无穷感慨，自己的老迈衰颓与反主为宾的悲哀，尽都包含在这看似平淡的一问中了。全诗就在这有问无答处悄然作结，而弦外之音却如空谷传响，哀婉备至，久久不绝。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">就全诗来看，一二句尚属平平，三四句却似峰回路转，别有境界。后两句的妙处在于背面敷粉，了无痕迹：虽写哀情，却借欢乐场面表现；虽为写己，却从儿童一面翻出。而所写儿童问话的场面又极富于生活的情趣，即使读者不为诗人久客伤老之情所感染，也不能不被这一饶有趣味的生活场景所打动。</span></p><p><br></p>', 'http://img.jssns.cn/SHILU/1/47350849103270837.png', 'http://img.jssns.cn/SHILU/1/4faedc7167e60d4a4c8bedb330d48a0a.jpg', null, 'album', 'ID535147574781280256', '105', null, '0', '168', '2019-02-21 18:12:37', '168', '2019-02-21 18:15:04');
INSERT INTO `audio` VALUES ('ID548447672898420736', '《凉州词》唐·王之涣', 'http://img.jssns.cn/SHILU/1/4d1e68846f95b123ba392f379a24c305.mp3', '<h2><span style=\"color: rgb(15, 15, 15);\">凉州词</span></h2><p><span style=\"color: rgb(15, 15, 15);\">唐·王之涣</span></p><p><span style=\"color: rgb(15, 15, 15);\">黄河远上白云间，一片孤城万仞山。</span></p><p><span style=\"color: rgb(15, 15, 15);\">羌笛何须怨杨柳，春风不度玉门关。</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">注释：</span></h2><p><span style=\"color: rgb(255, 0, 0);\">凉州词</span><span style=\"color: rgb(15, 15, 15);\">：又名《出塞》。为当时流行的一首曲子（《凉州词》）配的唱词。</span></p><p><span style=\"color: rgb(255, 0, 0);\">远上</span><span style=\"color: rgb(15, 15, 15);\">：远远向西望去。“远”一作“直”。</span></p><p><span style=\"color: rgb(255, 0, 0);\">孤城</span><span style=\"color: rgb(15, 15, 15);\">：指孤零零的戍边的城堡。</span></p><p><span style=\"color: rgb(255, 0, 0);\">仞</span><span style=\"color: rgb(15, 15, 15);\">：古代的长度单位，一仞相当于七尺或八尺</span></p><p><span style=\"color: rgb(255, 0, 0);\">羌笛</span><span style=\"color: rgb(15, 15, 15);\">：古羌族主要分布在甘、青、川一带。羌笛是羌族乐器，属横吹式管乐。属于一种乐器。</span></p><p><span style=\"color: rgb(255, 0, 0);\">何须怨</span><span style=\"color: rgb(15, 15, 15);\">：何必埋怨。</span></p><p><span style=\"color: rgb(255, 0, 0);\">杨柳</span><span style=\"color: rgb(15, 15, 15);\">：杨树的柳条，又指的是《杨柳曲》。</span></p><p><span style=\"color: rgb(255, 0, 0);\">不度</span><span style=\"color: rgb(0, 0, 0);\">：</span><span style=\"color: rgb(15, 15, 15);\">吹不到</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">译文：</span></h2><p><span style=\"color: rgb(15, 15, 15);\">黄河好像从白云间奔流而来，玉门关孤独地耸峙在高山中。</span></p><p><span style=\"color: rgb(15, 15, 15);\">将士何须哀怨那柳树不发芽，春风根本吹不到玉门关外。</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">赏析：</span></h2><p><a href=\"https://so.gushiwen.org/authorv_637fa1f1b67a.aspx\" target=\"_blank\" style=\"color: rgb(15, 15, 15);\">王之涣</a><span style=\"color: rgb(15, 15, 15);\">这首</span><a href=\"https://so.gushiwen.org/shiwenv_3963afd966bc.aspx\" target=\"_blank\" style=\"color: rgb(15, 15, 15);\">诗</a><span style=\"color: rgb(15, 15, 15);\">写戍边士兵的怀乡情。写得苍凉慷慨，悲而不失其壮，虽极力渲染戍卒不得还乡的怨情，但丝毫没有半点颓丧消沉的情调，充分表现出盛唐诗人的豁达广阔胸怀。</span></p><p><span style=\"color: rgb(15, 15, 15);\">首句“黄河远上白云间”抓住远眺的特点，描绘出一幅动人的图画：辽阔的高原上，黄河奔腾而去，远远向西望去，好像流入白云中一般。次句 “一片孤城万仞山”，写塞上的孤城。在高山大河的环抱下，一座地处边塞的孤城巍然屹立。这两句，描写了祖国山川的雄伟气势，勾勒出这个国防重镇的地理形势，突出了戍边士卒的荒凉境遇，为后两句刻画戍守者的心理提供了一个典型环境。</span></p><p><span style=\"color: rgb(15, 15, 15);\">在这种环境中忽然听到了羌笛声，所吹的曲调恰好是《折杨柳》，这就不能不勾起戍卒的离愁。古人有临别折柳相赠的风俗。“柳”与“留”谐音，赠柳表示留念。北朝乐府《鼓角横吹曲》中“上马不捉鞭，反折杨柳枝。下马吹横笛，愁杀行客儿。”提到了行人临去时折柳。这种折柳赠别之风在唐代极为流行。于是，杨柳和离别就有了密切的联系。现在当戍边士卒听到羌笛吹奏着悲凉的《折杨柳》曲调时，就难免会触动离愁别恨。于是，诗人用豁达的语调排解道：羌笛何须老是吹奏那哀怨的《折杨柳》曲调呢？要知道，玉门关外本来就是春风吹不到的地方，哪有杨柳可折！说“何须怨”，并不是没有怨，也不是劝戍卒不要怨，而是说怨也没用。用了“何须怨”三字，使诗意更加含蓄，更有深意。</span></p>', 'http://img.jssns.cn/SHILU/1/47408606608858683.png', 'http://img.jssns.cn/SHILU/1/899b97d9b6485dcbc00a3de057a6ef97.jpg', null, 'album', 'ID535147574781280256', '103', null, null, '168', '2019-02-22 10:15:14', '168', '2019-02-22 10:15:14');
INSERT INTO `audio` VALUES ('ID548462666079797248', '【精卫填海】论运气对成功的重要性！', 'http://img.jssns.cn/SHILU/1/6867fa7fb9bece2a463e37a27fe4fe0a.mp3', '<p>夏朝以前，还没有国家这个概念，那时的帝王，远没有后来的皇帝阔气，也无法享受到许多特权；没错，那时的帝王只是纯粹的人民公仆。同样，帝王的子女也没有太子、公主之类的称呼，和普通老百姓的子女一样，一点不特殊。</p><p><br></p><p>故事的主人公<strong style=\"color: rgb(241, 27, 27);\">精卫</strong>是炎帝的女儿，她性格开朗活泼，喜欢打抱不平。一天，她走出小村，找小朋友玩耍，突然看到一个大孩子把小孩子当马骑。小孩都累爬下了，大孩子还不肯罢休。于是，精卫走了过去，指着大孩子的脑门怒斥道：“你这个人太不知羞耻啦，欺负小孩子算什么本事，有力气，去打虎打熊呀。”大孩子见精卫是个小姑娘，又长得柔柔弱弱的，根本不把她放在眼里。他从小孩背上跳下来，走到精卫面前说：“我是海龙王的儿子，你是什么人？竟敢来管我！”</p><p>&nbsp;</p><p>精卫说：“龙王的儿子有什么了不起，我还是炎帝的女儿呢，以后你少到陆地上撒野，小心我把你挂到树上晒干。”龙王的儿子说：“我先让你知道知道我的厉害，往后少管我闲事。”说完立马动手要打精卫。精卫并不示弱，她闪身躲开对方的拳头后，飞起一腿便将龙王的儿子踢倒在地上了。龙王的儿子站起来，不肯服输，挥拳又打，被精卫当胸一拳，又倒下了。龙王的儿子见打不过精卫，只好灰溜溜地返回了大海。</p><p>&nbsp;</p><p>过了几天，精卫到海中游泳，正玩得十分开心，刚巧让龙王的儿子发现了。他游过来，对精卫说：那天在陆地上让你捡了便宜，今天你可是在我家门前，赶快认个错，不然我掀浪淹死你。”精卫倔强地说：“我没错，认什么错。”龙王的儿子见精卫倔强，根本没有服输的意思，立即搅动海水，掀起狂风恶浪，精卫来不及挣扎，就被淹死了。</p><p><br></p><p>精卫死后，化身为一只红爪白嘴的小鸟并立志要把大海填平。她不断的用嘴衔来石头与树枝投向大海，年年月月，永不停歇。</p><p>&nbsp;</p><p>大海奔腾着，咆哮着，露出雪亮亮的牙齿。凶恶地嘲笑着：“小鸟儿，算了罢，你这工作就算干上一百万年，也休想把大海填平！”</p><p><br></p><p>精卫在高空答复大海：“哪怕是干上一千万年，一万万年，干到世界的末日，宇宙的终尽，我也要把你填平！”</p><p><br></p><p>因此，精卫填海这个成语原先是指有深仇大恨，立志必报。<strong style=\"color: rgb(241, 27, 27);\">后来则比喻意志坚决，不畏艰难。</strong></p><p><br></p><p>比如，你的同班同学小智为了考上国家重点大学，每天早上5点起来阅读，晚上10点还在做数学练习题，那么我们可以说小智拥有精卫填海的精神。</p><p><br></p><p>精卫填海的精神确实非常值得我们借鉴和学习，同样有这种精神的还有愚公。如果你听过第八期的成语《愚公移山》，那么你会发现这两个成语讲述的都是利用自身力量努力战胜大自然的故事，但他们的结局完全不同，直到精卫最后化为青鸟，她也没能把东海填平，而愚公却在有生之年让山“移”走了。</p><p><br></p><p>比较两者的区别你会发现，运气起到了决定性的作用！比起精卫愚公的运气显然好太多——愚公矢志不渝的移山行为感动了玉帝，玉帝派了两个大力神把山搬走了。</p><p><br></p><p><strong style=\"color: rgb(241, 27, 27);\">可惜，精卫始终没有这样的运气！</strong></p><p><br></p><p>我们的老师和父母强调了太多的努力，而忽略了运气对于成功的影响！运气到底有多重要！只要看看亿万富翁比尔盖茨的早期生涯就知道了：首先，比尔盖茨正好出生在1955年，如果晚出生几年，他的青年时代就赶不上个人电脑的第一波浪潮。</p><p><br></p><p>其次，盖茨家境很好，更好的是他上的那所私立高中，是当时全美国唯一一个给学生提供免费计算机终端的中学，那时候绝大多数学校还没有这个条件，不然少年的盖茨就没法学习编程技术了。</p><p><br></p><p>最后，盖茨退学创业的时候，正好赶上了IBM需要个人操作系统。IBM本来就没想从别的公司买操作系统，但很偶然没有谈成，最后买了盖茨的操作系统。</p><p><br></p><p>只要上面任何一条没有成立，盖茨绝不会如此成功。我们当然不能说盖茨全靠运气成功，他很有天赋而且非常努力。我想强调的是，面对成功人士，不要只看到他们的努力和天赋，而忽视了他们的好运气。</p><p>&nbsp;</p><p>那么怎么才能提高自己的运气呢？有以下三个方法：</p><p><strong>1、&nbsp;不断学习，努力提高自身的能力；</strong></p><p><strong>2、&nbsp;紧随大势，即了解科技发展趋势和国家经济发展趋势来选择自己所要从事的行业；</strong></p><p><strong>3、&nbsp;多和别人交流，多和别人合作，很多时候机会来自于别人的口中。</strong></p>', 'http://img.jssns.cn/SHILU/1/47412181144930394.png', 'http://img.jssns.cn/SHILU/1/8c5e7459b903e792d3db44c98ab91d03.png', null, 'album', 'ID515539237269929986', '106', null, '1', '432228697144033280', '2019-02-22 11:14:49', '168', '2019-02-25 11:11:26');
INSERT INTO `audio` VALUES ('ID550352358605848576', '《春晓》唐·孟浩然', 'http://img.jssns.cn/SHILU/1/74f651227a693a7d99a664883a69b59f.mp3', '<h2><strong style=\"color: rgb(15, 15, 15);\">春晓</strong></h2><p><a href=\"https://www.gushiwen.org/shiwen/default.aspx?cstr=%e5%94%90%e4%bb%a3\" target=\"_blank\" style=\"color: rgb(101, 100, 95);\"><u>唐代</u></a><span style=\"color: rgb(101, 100, 95);\">：</span><a href=\"https://so.gushiwen.org/authorv_3811e4e1f460.aspx\" target=\"_blank\" style=\"color: rgb(101, 100, 95);\"><u>孟浩然</u></a></p><p><span style=\"color: rgb(15, 15, 15);\">春眠不觉晓，处处闻啼鸟。</span></p><p><span style=\"color: rgb(15, 15, 15);\">夜来风雨声，花落知多少。</span></p><p><br></p><h2><strong style=\"color: rgb(15, 15, 15);\">注释：</strong></h2><p><span style=\"color: rgb(255, 0, 0);\">晓</span><span style=\"color: rgb(15, 15, 15);\">：天刚亮的时候，春晓：春天的早晨。</span></p><p><span style=\"color: rgb(255, 0, 0);\">不觉晓</span><span style=\"color: rgb(15, 15, 15);\">：不知不觉天就亮了。</span></p><p><span style=\"color: rgb(255, 0, 0);\">啼鸟</span><span style=\"color: rgb(15, 15, 15);\">：鸟的啼叫声。</span></p><p><span style=\"color: rgb(255, 0, 0);\">知多少</span><span style=\"color: rgb(15, 15, 15);\">：不知有多少。</span></p><p><br></p><h2><strong style=\"color: rgb(15, 15, 15);\">译文：</strong></h2><p><span style=\"color: rgb(15, 15, 15);\">春日里贪睡不知不觉天已破晓，搅乱我酣眠的是那啁啾的小鸟。</span></p><p><span style=\"color: rgb(15, 15, 15);\">昨天夜里风声雨声一直不断，那娇美的春花不知被吹落了多少？</span></p><h2><br></h2><h2><strong style=\"color: rgb(15, 15, 15);\">赏析：</strong></h2><p><span style=\"color: rgb(15, 15, 15);\">《春晓》这首小</span><a href=\"https://so.gushiwen.org/shiwenv_ccee5691ba93.aspx\" target=\"_blank\" style=\"color: rgb(25, 83, 125);\"><u>诗</u></a><span style=\"color: rgb(15, 15, 15);\">，刚开始读觉得平淡无奇，反复读来，便觉诗中别有一番天地。它的艺术魅力不在于华丽的辞藻，不在于奇绝的艺术手法，而在于它的韵味。整首诗的风格就像行云流水一样平易自然，悠远深厚。千百年来，人们传诵它，探讨它，仿佛在这短短的四行诗里，蕴涵着开掘不完的艺术宝藏。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">诗人要表现他喜爱春天的感情，却又不说尽，不说透，让读者去捉摸、去猜想，处处表现得隐秀曲折。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">春天，有迷人的色彩，有醉人的芬芳，诗人都不去写。他只是从听觉角度着笔，写春之声：那处处啼鸟，那潇潇风雨。鸟声婉转，悦耳动听，是美的。加上“处处”二字，远近应和，就更使人有置身山阴道上，应接不暇的感受。春风春雨，纷纷洒洒，但在静谧的春夜，这沙沙声响却也让人想到那如烟似梦般的凄迷意境。这些都只是诗人在室内的耳闻，然而这阵阵春声却逗露了无边的春色，把读者引向了广阔的大自然，使读者自己去想象、自己去体味那莺啭(</span><span style=\"color: rgb(255, 0, 0);\">四声)</span><span style=\"color: rgb(15, 15, 15);\">花香的烂熳春光，这是用春声来渲染户外春意的美好景象。这些景物是活泼跳跃的，生机勃勃的。它写出了诗人的感受，表现了诗人内心的喜悦和对大自然的热爱。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">《春晓》的语言平易浅近，自然天成，一点也看不出人工雕琢的痕迹。而言浅意浓，景真情真，就像是从诗人心灵深处流出的一股泉水，晶莹透澈，灌注着诗人的生命，跳动着诗人的脉搏。这是最自然的诗篇，是天籁。</span></p>', 'http://img.jssns.cn/SHILU/1/47862719475843428.png', 'http://img.jssns.cn/SHILU/1/8b24b09a58a5e5e9c45e4e115f81de43.jpg', null, 'album', 'ID535147574781280256', '101', null, '0', '168', '2019-02-27 16:23:47', '168', '2019-02-27 16:26:03');
INSERT INTO `audio` VALUES ('ID550718369184088064', '《登鹳雀楼》唐·王之涣', 'http://img.jssns.cn/SHILU/1/ed8cb3655e5ca45235cf340f5fcbc058.mp3', '<h2><span style=\"color: rgb(15, 15, 15);\">登鹳雀楼</span></h2><p><span style=\"color: rgb(15, 15, 15);\">唐·</span><a href=\"https://so.gushiwen.org/authorv_637fa1f1b67a.aspx\" target=\"_blank\" style=\"color: rgb(15, 15, 15);\">王之涣</a></p><p><span style=\"color: rgb(15, 15, 15);\">白日依山尽，黄河入海流。</span></p><p><span style=\"color: rgb(15, 15, 15);\">欲穷千里目，更上一层楼。</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">注释：</span></h2><p><span style=\"color: rgb(230, 0, 0);\">白日</span><span style=\"color: rgb(15, 15, 15);\">：太阳。</span></p><p><span style=\"color: rgb(230, 0, 0);\">依</span><span style=\"color: rgb(15, 15, 15);\">：依傍。</span></p><p><span style=\"color: rgb(230, 0, 0);\">尽</span><span style=\"color: rgb(15, 15, 15);\">：消失。 这句话是说太阳依傍山峦沉落。</span></p><p><span style=\"color: rgb(230, 0, 0);\">欲</span><span style=\"color: rgb(15, 15, 15);\">：想要得到某种东西或达到某种目的的愿望，但也有希望、想要的意思。</span></p><p><span style=\"color: rgb(230, 0, 0);\">穷</span><span style=\"color: rgb(15, 15, 15);\">：尽，使达到极点。</span></p><p><span style=\"color: rgb(230, 0, 0);\">千里目</span><span style=\"color: rgb(15, 15, 15);\">：眼界宽阔。</span></p><p><span style=\"color: rgb(230, 0, 0);\">更：</span><span style=\"color: rgb(15, 15, 15);\">替、换。</span></p><p><br></p><h2>译文：</h2><p><span style=\"color: rgb(15, 15, 15);\">夕阳依傍着西山慢慢地沉没， 滔滔黄河朝着东海汹涌奔流。</span></p><p><span style=\"color: rgb(15, 15, 15);\">若想把千里的风光景物看够， 那就要登上更高的一层城楼</span></p><p><br></p><h2><span style=\"color: rgb(15, 15, 15);\">赏析：</span></h2><p><span style=\"color: rgb(15, 15, 15);\">这首</span><a href=\"https://so.gushiwen.org/shiwenv_c90ff9ea5a71.aspx\" target=\"_blank\" style=\"color: rgb(15, 15, 15);\">诗</a><span style=\"color: rgb(15, 15, 15);\">写诗人在登高望远中表现出来的不凡的胸襟抱负，反映了盛唐时期人们积极向上的进取精神。其中，前两句&nbsp;写所见。“白日依山尽”写远景，写山，写的是登楼望见的景色，“黄河入海流”写近景，写水，景象壮观，气势磅礴。这里，诗人运用极其朴素、极其浅显的语言，既高度形象又高度概括地把进入广大视野的万里河山，收入短短十个字之中；而后人在读到这十个字时，也是如临其地，如见其景。首句写遥望一轮落日向着楼前一望无际、连绵起伏的群山西沉，在视野的尽头冉冉而没。这是天空景、远方景、西望景。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\"> 次句写目送流经&nbsp;楼前&nbsp;下方的黄河，奔腾咆哮、滚滚南来，又在远处折而东向，流归大海。这是由地面望到天边，由近望到远，由西望到东。这两句诗合起来，就把上下、远近、东西的景物，全都容纳进诗笔之下，使画面显得特别宽广，特别辽远。第三句，诗人身在鹳雀楼上，不可能望见黄河入海，句中写的是诗人目送黄河远去天边而产生的意中景，是把当前景与意中景溶合为一的写法。这样写，增加了画面的广度和深度。而称太阳为“白日”，这是写实的笔调。落日衔山，云遮雾障，那本已减弱的太阳的光辉，此时显得更加暗淡，所以诗人直接观察到“白日”的奇景。至于“黄河”，当然也是写实。它宛若一条金色的飘带，飞舞于层峦叠嶂之间。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">诗人眼前所呈现的，是一幅溢光流彩、金碧交辉的壮丽图画。这幅图画还处于瞬息多变的动态之中。白日依山而尽，这仅仅是一个极短暂的过程；黄河向海而流，却是一种永恒的运动。如果说．这种景色很美，那么，它便是一种动态的美，充满了无限生机的活泼的美。这不是所谓“定格”，不是被珍藏的化石或标本。读者深深地为诗人的大手笔所折服。后两句写所想。“欲穷千里目”，写诗人一种无止境探求的愿望，还想看得更远，看到目力所能达到的地方，唯一的办法就是要站得更高些，“更上一层楼”。&nbsp;&nbsp;这两句诗，是千古传诵的名句，既别翻新意，出人意表，又与前两句诗承接得十分自然、十分紧密 。</span></p><p><br></p><p><span style=\"color: rgb(15, 15, 15);\">这首诗，把道理与景物、情事&nbsp;溶化得天衣无缝，读者并不觉得它在说理，而理自在其中。这是根据诗歌特点、运用形象思维来显示生活哲理的典范。</span></p><p><br></p>', 'http://img.jssns.cn/SHILU/1/47949982817469146.png', 'http://img.jssns.cn/SHILU/1/0ebc4b32cd6912818e9971b5a403310a.jpg', null, 'album', 'ID535147574781280256', '104', null, null, '168', '2019-02-28 16:38:11', '168', '2019-02-28 16:38:11');
INSERT INTO `audio` VALUES ('ID550721224100020224', '沙漏的启示', 'http://img.jssns.cn/SHILU/1/0482f31e067873189950c11879e5c6e4.mp3', '<p class=\"ql-align-justify\">沙漏的启示</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">小男孩弗兰克是个善于观察爱提问题的孩子，如果他发现件新鲜东西，肯定会提出许多许多的问题来。他的母亲总是不厌其烦地、耐心和蔼地，尽力回答可以回答的问题</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">偶尔，她也会在这样说：“孩子，现在你还小，到你长大到十岁的时候，再来问我这个问题怎么样？到时候我会详细地告诉你，现在说了你也不理解。”。</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">每当这个时候，弗兰克便会放下他的问题，不再强求了。因为他知道，只要提出的问题合适，妈妈就一定会认真地回答他的。</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">古代有一种计时器叫沙漏。弗兰克第一次看到，便被它吸引了。至于沙漏的作用，他并不知道。</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">母亲说：“按 8字外形制成沙漏，是古代的一种计时器。沙从一端倒人后，便流过中间的小孔。至于往里面装多少沙子，那要看一个小时沙子从小孔漏过的数量来定了。”</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">那细细的沙流流得好慢，弗兰克看着看着，不耐烦了。“妈妈，让我帮助它摇一摇吧。”他着急地说道，“流得这么慢了，可没有时间流完了。”</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">“对，孩子，就是这样的，”母亲说：“这沙子虽然流动得很慢，却没有停止流动。你观察钟表上的指针，是否发现也走得极其慢。是啊，的确如此，不过，它们并没停下来过。孩子，不管你是在玩还是睡觉，这些沙子依然在一粒粒地流动，钟表指针在一秒接一秒地转动。整个晚上，时钟上的时针，将转整个一圈，沙漏中的沙子，将流经小孔12次。因为，它们从未停下工作，它们不愿停下自己的脚步，去过多思虑该做多少。”</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">如今，妈妈想让弗兰克学一首赞美诗，可他却退却说：“不要吧，我可学不会，妈妈。”</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">母亲语重心长地教导说：“孩子呀，千万别停下来问，你只要一直坚持学习，自然就能学会的。”</span></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><span style=\"color: rgb(51, 51, 51);\">听从了母亲的教导，弗兰克真的非常勤奋地一行一行地学了起来。几小时过去后，他真得懂得了那赞美诗的含义啦！</span></p>', 'http://img.jssns.cn/SHILU/1/47950663295603098.png', 'http://img.jssns.cn/SHILU/1/942dea338f7de0848a18b90732032090.jpg', null, 'album', 'ID558316668967714816', '3', null, '0', '168', '2019-02-28 16:49:31', '168', '2019-02-28 17:21:12');
INSERT INTO `audio` VALUES ('ID550725286547685376', '老鼠娶亲', 'http://img.jssns.cn/SHILU/1/c15d6d30f9d231d8bec8a8703afafefe.mp3', '<h2><span style=\"color: rgb(51, 51, 51);\">老鼠娶亲</span></h2><p><span style=\"color: rgb(51, 51, 51);\"><span class=\"ql-cursor\">﻿</span></span></p><p><span style=\"color: rgb(51, 51, 51);\">很久以前，有一对老鼠夫妻，他们的年纪都已经很大了，而他们的女儿也到了谈婚论嫁的年龄。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">眼看就要过年了，鼠爸爸和鼠妈妈急着要为女儿找一位世界上最伟大、最有本领的丈夫。于是，第二天一大早，鼠爸爸和鼠妈妈便走出家门，开始为女儿寻找如意郎君。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">这时，太阳公公从东方冉冉升起，给大地带来一片光明，鼠爸爸和鼠妈妈相视一笑，不约而同地说 太阳公公正是我们所要寻找的理想对象呀！</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">太阳公公知道了他们的来意以后 ，不禁笑着对他们说我虽然能够光芒普照大地，给大家带来温暖，但是，当乌云来的时候，我就会变得黯淡无光了。因此，乌云才是天下 最伟大的。而且我已经这样一大把年纪了，实在不适合做你们的女婿。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">鼠爸爸和鼠妈妈觉得太阳公公的话很有道理，因此打算去找乌云。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">当他们正要离开去找乌云的时候，天空忽然暗了下来。原来，乌云正好来拜访太阳公公，当他得知鼠爸爸和鼠妈妈的来意后，急忙说：“啊！不不，虽然我可以挡住太阳公公的光，但是，我可不是最有本领的，风才是你们理想的对象，因为只要他一来，我就会被吹得七零八落，晕头转向，他才是世界上最伟大的。”</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">说时迟那时快，突然， 呼 地一声，风挥舞着他的大披风，神气活现地飞了过来。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">当时大家都被吹得东倒西歪，感觉到风的威力的确如乌云所说，非常强大。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">太阳公公和乌云极力推选风作鼠爸爸和鼠妈妈的女婿。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">风被他们的话说得有些不好意思了，说道： 你们别看我有时候非常威风，但是只要有一堵墙，就可以将我弹倒在地，摔得浑身是伤！所以，在我看来，墙才是世界上最有本领、最伟大的，你们应该去找墙作你们的女婿。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">鼠爸爸和鼠妈妈听了这话，看看四周一片广大的草原，对风说：“这里一片空旷，你让我们到哪里去找墙呢？”</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">风说：“你们顺着这个方向一直往前走，到了一个村子以后，就可以找到一面大墙了。”</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">鼠爸爸和鼠妈妈只好继续往前走，走了好几天，终于来到了那个村子，鼠妈妈眼睛一亮，大声说： 那儿果然有一堵大墙！</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">他们急忙跑过去，正准备开口请求大墙娶他们的女儿为妻时，却看见墙愁眉苦脸地说：“看哪！你们这些老鼠，就是喜欢在我身上打洞，我真是拿你们没有办法。”</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">原来，这时有一只年轻力壮的老鼠正在大墙底下挖洞呢！</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">直到这时，鼠爸爸和鼠妈妈才恍然大悟，原来，他们也有让别人羡慕和无奈的才能。于是，就把女儿嫁给了这只年轻力壮的老鼠。这天正好是农历正月初三，因此人们就把这一天称为“老鼠娶亲”的日子.</span></p>', 'http://img.jssns.cn/SHILU/1/47951631881124799.png', 'http://img.jssns.cn/SHILU/1/db2a272d5adc28827ddcb722b3d22488.jpg', null, 'album', 'ID558316668967714816', '103', null, null, '168', '2019-02-28 17:05:40', '168', '2019-02-28 17:05:40');
INSERT INTO `audio` VALUES ('ID557940478700421120', '【鹤立鸡群】如何才能与学霸为伍？', 'http://img.jssns.cn/SHILU/1/e8aa3ca4e69586290d0e4229c97a2d12.mp3', '<p><img src=\"http://img.xiumi.us/xmi/ua/GA55/i/89b31020d00dfaaad3ab67ea8ba5a061-sz_182315.jpeg?x-oss-process=style/xmorient\"></p><p>嵇绍的身材高大，一次，他上朝时，有人称赞他：“你是那么高大神奇，就像一只鹤站在一大群鸡中间！”&nbsp;</p><p><br></p><p>晋惠帝时，嵇绍官为侍中。当时皇族争权夺利。互相攻杀，史称为“八王之乱”。&nbsp;</p><p>&nbsp;&nbsp;</p><p>嵇绍对皇帝始终非常忠诚，一次他跟着皇帝出去打仗，不料被敌人包围。其他卫官都只顾自己逃命，只有嵇绍，保护皇帝勇敢地杀出了重围。许多人看到嵇绍奋勇杀敌的情景很受感动，于是有人对司徒王戎说：<strong>稽绍真像一只野鹤站立在鸡群中一样，仪表出众，气度不凡。</strong>&nbsp;</p><p>&nbsp;</p><p>因此，我们就用“鹤立鸡群”这个成语比喻一个人的仪表或才能在周围一群人里显的很突出。&nbsp;</p><p><br></p><p>有这样一个实验，研究者在一群鸟中随机抽选了一只并系上了红丝带，可没过几天，这只鸟就被其他鸟啄死了。&nbsp;</p><p>&nbsp;&nbsp;</p><p>你可以说是嫉妒、讨厌或嘲讽，也可以从进化论的角度去分析，这些鸟类看到一个与众不同的同伴，它们会猜测这个同伴是不是携带病毒？出于对整个族群的保护，只能把系丝带的这只鸟啄死。&nbsp;</p><p><br></p><p>童童：你说的是一只鸟在一群鸟里，他们战斗力差不多！但这是鹤在鸡群里啊，鸡的战斗力明显不如鹤！&nbsp;</p><p><br></p><p>婷婷老师：鹤在鸡群里是否会有同等的待遇我就不知道了，因为鹤跟鸡差别太大了，鸡或许压根就忽视了鹤。要知道，只有同类之间才存在嫉妒呢？&nbsp;</p><p><br></p><p>童童：我明白了。婷婷老师，我又想到一个问题！鹤不是鸡，那它为什么要在鸡群里？&nbsp;</p><p><br></p><p>婷婷老师：这是个非常好的问题！我们需要分两种情况来思考这个问题。&nbsp;</p><p><br></p><p>第一种情况，鹤主动要求站在鸡群中间。要知道，鹤是听不懂鸡说的话的，它还强行呆在鸡中间就是自己的问题！&nbsp;</p><p><br></p><p>他为什么要跟鸡混在一起来彰显自己的优越感呢？其中一个原因可能是，它是鹤群中的混的最不好的，在鹤群中毫无地位，只能在鸡群中获得别“鸡”的尊敬。&nbsp;</p><p>第二种情况，鹤由于某些原因被逼无奈和一群鸡在一起，可能是因为它正在被天敌追杀，可能是因为受伤失去了飞行的能力。这些情况下，“鹤立鸡群”的行为可以理解为鹤对现实困难的一种应对，是一种值得赞赏的适应性行为。&nbsp;</p><p><br></p><p>现在，让我们把视角从鹤身上转移到人身上。有句话是这么说的，“看看你周围人的水平，就知道你是什么水平！”&nbsp;</p><p><br></p><p>学霸的好朋友一般都是学霸，学渣的好朋友几乎都是学渣，就是这个道理。&nbsp;</p><p><br></p><p>我们要跟比自己优秀的人做朋友，学习他们学习的方法和对生活的态度。而不是去找那些远不如自己的同学，以显示自己的牛逼！&nbsp;</p><p><br></p><p>童童：那学渣怎么才能成为学霸的朋友呢？&nbsp;</p><p><br></p><p>婷婷老师：很简答，价值交换。每个人都有自己擅长的和不擅长的。比如打篮球这件事，学渣很擅长打篮球，但学霸完全不会打。那么你就可以在打篮球的时候带上学霸，教他怎么打球。这样，他在学习的时候也会主动带上你。&nbsp;</p><p><br></p><p>所以，你会发现从一个圈子融入另外一个圈子的关键，是认清楚自己的优劣势，利用自己的优势去引起别人的关注，进而不断提升自己的见识。&nbsp;</p><p><br></p><p>宁可在比你更优秀的人中毫不起眼，也别在不如你的人中刷存在感，这就是鹤立鸡群这个成语的精髓所在！&nbsp;</p><p><br></p><p>所以，正在收听课程的小朋友和大朋友们，跳出舒适区，去追求更好的人生吧！我们下次再见！&nbsp;</p>', 'http://img.jssns.cn/SHILU/1/49671868152390089.png', 'http://img.jssns.cn/SHILU/1/2a8225930cdbeb974842fce69a6ddaf3.png', null, 'album', 'ID515539237269929986', '111', null, '0', '432228697144033280', '2019-03-20 14:56:16', '432228697144033280', '2019-03-20 15:16:58');
INSERT INTO `audio` VALUES ('ID560427229113221120', '《鹿柴》唐·王维', 'http://img.jssns.cn/SHILU/1/af8a88f8b0a420201d1cfb8ddeb19a35.mp3', '<p><span style=\"color: rgb(33, 33, 33);\">鹿柴（唐）王维</span></p><p><span style=\"color: rgb(33, 33, 33);\">空山不见人，但闻人语响。</span></p><p><span style=\"color: rgb(33, 33, 33);\">返景入深林，复照青苔上。</span></p><p><br></p><h2><span style=\"color: rgb(33, 33, 33);\">注释：</span></h2><p><br></p><p><span style=\"color: rgb(255, 0, 0);\">鹿柴</span><span style=\"color: rgb(33, 33, 33);\">（zhài）：“柴”同“寨“，栅栏。此为地名。</span></p><p><span style=\"color: rgb(255, 0, 0);\">但</span><span style=\"color: rgb(33, 33, 33);\">：只。</span></p><p><span style=\"color: rgb(255, 0, 0);\">闻</span><span style=\"color: rgb(33, 33, 33);\">：听见。</span></p><p><span style=\"color: rgb(255, 0, 0);\">返景</span><span style=\"color: rgb(33, 33, 33);\">：夕阳返照的光。“景”古时同“影”。</span></p><p><span style=\"color: rgb(255, 0, 0);\">照</span><span style=\"color: rgb(33, 33, 33);\">：照耀(着)。</span></p><p><br></p><h2><span style=\"color: rgb(33, 33, 33);\">译文：</span></h2><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">幽静的山谷里看不见人，只能听到那说话的声音。</span></p><p><span style=\"color: rgb(33, 33, 33);\">落日的影晕映入了深林，又照在青苔上景色宜人。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">这首</span><a href=\"https://so.gushiwen.org/shiwenv_e9b1a8b4def0.aspx\" target=\"_blank\" style=\"color: rgb(33, 33, 33);\">诗</a><span style=\"color: rgb(33, 33, 33);\">描绘的是鹿柴附近的空山深林在傍晚时分的幽静景色。诗的绝妙处在于以动衬静，以局部衬全局，清新自然，毫不做作。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">但凡写山水，总离不开具体景物，或摹状嶙峋怪石，或描绘参天古木，或渲染飞瀑悬泉，其着眼点在于景物之奇。而此诗则从一个奇特的现象着笔：“空山不见人，但闻人语响。”层岩迭嶂，看去空无一人。可是有时会突然听得朗朗笑语，但由于回声的多重反射，一时间很难判断人声究竟从何而起。人们大约都有类似的经验，本来很平常。但是将这种视觉与听觉互补的观察事物的方法以诗的形式加以表现，就不能不说是一个创造。从诗的表现说，它别出新意；从作品的接受者说，是那样新奇有趣，俨如身临其境，由此引起积极的情感活动。前两句诗用直白的语言，略作点染，境界即出。诗开头的“空山”，二字，是相对于无人而言，同时表明诗人的视野比较开阔，可以一视无碍；如果置身于隐天蔽日的原始森林中，就得不到“空山”的意象。从这两个字，也可以窥见山中的景物形势特点。对句的“响”字与“空山”相呼应：只有在没有太多障碍物的情况下，声音才能在山谷中往复回荡，方才可以说“人语响”。因此，周遭景物必是疏朗的。前二句写幽静，因声传神；后二句写幽深，以光敷色。山中景色会因朝夕晦暝、风雨因时而变化。此诗则选取傍晚时分的景色作为描写对象。这时夕阳返照射入树林深处，又有一部分光线落到青苔上面。天色就要暗下来，各类景物斑斑驳驳的，明暗对比鲜明。近处，投在地面上的蓊郁的树影渐渐拉长；树林深处，因黝暗而显得十分幽邃。这种景观的最佳时期是夏末秋初，而且必须是晴朗的傍晚，阴雨绵绵是不行的。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">这首诗创造了一种幽深而光明的象征性境界，表现了作者在深幽的修禅过程中的豁然开朗。诗中虽有禅意，却不诉诸议论说理，而全渗透于自然景色的生动描绘之中。</span></p><p><br></p><p><a href=\"https://so.gushiwen.org/authorv_52fceee85532.aspx\" target=\"_blank\" style=\"color: rgb(33, 33, 33);\">王维</a><span style=\"color: rgb(33, 33, 33);\">是诗人、画家兼音乐家。这首诗正体现出诗、画、乐的结合。他以音乐家对声的感悟，画家对光的把握，诗人对语言的提炼，刻画了空谷人语、斜辉返照那一瞬间特有的寂静清幽，耐人寻味。</span></p>', 'http://img.jssns.cn/SHILU/1/50264755291755281.png', 'http://img.jssns.cn/SHILU/1/ebf8c4e811715dc744b2ad1b3f4830dc.jpg', null, 'album', 'ID535147574781280256', '104', null, null, '168', '2019-03-27 11:37:43', '168', '2019-03-27 11:37:43');
INSERT INTO `audio` VALUES ('ID560428287956877312', '《送元二使安西》唐·王维', 'http://img.jssns.cn/SHILU/1/1f703ab4eabfe146a18cbfa1689bb572.mp3', '<p><span style=\"color: rgb(33, 33, 33);\">送元二使安西（唐）王维</span></p><p><span style=\"color: rgb(33, 33, 33);\">渭城朝雨浥轻尘，客舍青青柳色新。</span></p><p><span style=\"color: rgb(33, 33, 33);\">劝君更尽一杯酒，西出阳关无故人。</span></p><p><br></p><h2><span style=\"color: rgb(33, 33, 33);\">注释：</span></h2><p><br></p><p><span style=\"color: rgb(230, 0, 0);\">渭城</span><span style=\"color: rgb(33, 33, 33);\">：在今陕西省西安市西北，即秦代咸阳古城。</span></p><p><span style=\"color: rgb(230, 0, 0);\">浥</span><span style=\"color: rgb(33, 33, 33);\">（yì）：润湿。</span></p><p><span style=\"color: rgb(230, 0, 0);\">客舍</span><span style=\"color: rgb(33, 33, 33);\">：旅馆。</span></p><p><span style=\"color: rgb(230, 0, 0);\">柳色</span><span style=\"color: rgb(33, 33, 33);\">：柳树象征离别。</span></p><p><span style=\"color: rgb(230, 0, 0);\">阳关</span><span style=\"color: rgb(33, 33, 33);\">：在今甘肃省敦煌西南，为自古赴西北边疆的要道。</span></p><p><br></p><h2><strong style=\"color: rgb(33, 33, 33);\">译文：</strong></h2><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">渭城早晨一场春雨沾湿了轻尘，客舍周围柳树的枝叶翠嫩一新。</span></p><p><span style=\"color: rgb(33, 33, 33);\">老朋友请你再干一杯美酒，向西出了阳关就难以遇到故旧亲人。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">“渭城朝雨浥轻尘，客色青青柳色新。”生动形象地写出了诗人对将要去荒凉之地的友人元二的深深依恋和牵挂。诗的前两句明写春景，暗寓离别。其中不仅“柳”与“留”谐音，是离别的象征，“轻尘”“客舍”也都暗示了旅行的目的，巧妙地点出了送别的时间、地点和环境。后两句点明了主题是以酒饯别，诗人借分手时的劝酒，表达对友人深厚的情意。友人此行要去的安西，在今天的新疆库车县境，同时代的</span><a href=\"https://so.gushiwen.org/authorv_637fa1f1b67a.aspx\" target=\"_blank\" style=\"color: rgb(33, 33, 33);\">王之涣</a><span style=\"color: rgb(33, 33, 33);\">有“春风不度玉门关”的形容，何况安西更在玉门之外，其荒凉遥远可想而知。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">绝句在篇幅上受到严格限制。这首诗，对如何设宴饯别，宴席上如何频频举杯，殷勤话别，以及启程时如何依依不舍，登程后如何瞩目遥望等等，一概舍去，只剪取饯行宴席即将结束时主人的劝酒辞：再干了这一杯吧，出了阳关，可就再也见不到老朋友了。诗人像高明的摄影师，摄下了最富表现力的镜头。宴席已经进行了很长一段时间，酿满别情的酒已经喝过多巡，殷勤告别的话已经重复过多次，朋友上路的时刻终于不能不到来，主客双方的惜别之情在这一瞬间都到达了顶点。主人的这句似乎脱口而出的劝酒辞就是此刻强烈、深挚的惜别之情的集中表现。 </span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">这首诗所描写的是一种最有普遍性的离别。它没有特殊的背景，而自有深挚的惜别之情，这就使它适合于绝大多数离筵别席演唱，后来编入乐府，成为最流行、传唱最久的歌曲。</span></p>', 'http://img.jssns.cn/SHILU/1/50265007628151540.png', 'http://img.jssns.cn/SHILU/1/e8302e8ccc7e489a713e142aa5bb45f9.jpg', null, 'album', 'ID535147574781280256', '100', null, null, '168', '2019-03-27 11:41:56', '168', '2019-03-27 11:41:56');
INSERT INTO `audio` VALUES ('ID562333841675517952', '【暴虎冯河】做事需要 “有勇无谋”', 'http://img.jssns.cn/SHILU/1/4e10ce7c4abebb50e2933839be91cefb.mp3', '<p><span style=\"color: rgb(51, 51, 51);\">春秋末期，鲁国卞地有一位名士，姓仲名由，字子路。他性情刚直，酷爱耍弄兵器，年轻时就是乡间出了名的勇士。后来，子路拜孔子为师。每当孔子外出时，子路就常常在左右护卫他。孔子曾感慨地说：“自我收了子路做弟子以来，再也没有人敢当着我的面用恶毒的话语污蔑我了。”</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">子路不喜欢读书，孔子常劝他用心习文。子路却说：“南山上产的竹子，生来就很笔直。如果砍下来做成箭，一样能射穿厚厚的犀牛皮。学习有什么益处？”孔子说：“如果为竹子粘上羽毛，安上箭镞，岂不是能增强它的威力？”子路听完后，还是不愿学习。</span></p><p><br></p><p>&nbsp;后来，子路去了卫国，在大夫孔悝的门下做事。公元前480年，卫国爆发了一场内乱，孔悝与在外流亡的前太子蒯聩</p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">合力赶跑了现任国君卫出公。孔子闻讯后，悲叹道：“可惜啊，子路必定死于此次灾难。”事情果真如孔子预言的一样，子路听说都城发生内乱，立即快速赶了回去。他孤身闯到蒯聩处，要求蒯聩斩杀孔悝。蒯聩不答应子路的要求，和孔悝登上了一座高台。子路欲在台下点火，结果被蒯聩的武士乱刀砍死了。</span></p><p><span style=\"color: rgb(51, 51, 51);\">&nbsp;</span></p><p><span style=\"color: rgb(51, 51, 51);\">这个世界变化是如此的快，刚学会一个新工具，就又被替代了。想想看，你爸妈那时候只能去图书馆借书，去文具店买笔记本，但你现在却可以直接用手机看书，在网上超市购买笔记本。</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">伴随新技术而来的就是新知识的大爆炸，关于这点，你想想看游戏与游戏攻略的关系就明白了。哪里有新的游戏，哪里就会有大量的游戏攻略。这时候你是先仔细阅读大量攻略再去玩游戏呢？还是先玩起来，遇到不懂的再去查看攻略呢？</span></p><p><br></p><p><span style=\"color: rgb(51, 51, 51);\">综上，在这个快速变化的时代，任何人都不可能把一件事情考虑周全，很多时候你需要暴虎冯河的精神，在做的过程中学习，遇到问题解决问题，就这么简单。</span></p>', 'http://img.jssns.cn/SHILU/1/50719327209601276.png', '', null, 'album', 'ID515539237269929986', '102', null, null, '168', '2019-04-01 17:53:55', '168', '2019-04-01 17:53:55');
INSERT INTO `audio` VALUES ('ID565230834248843264', '含着石头说话的孩子', 'http://img.jssns.cn/SHILU/1/72128ec48502c019fae4e12feda5d8f1.mp3', '', 'http://img.jssns.cn/SHILU/1/51410024477966559.png', 'http://img.jssns.cn/SHILU/1/8f6ceeac3c7c414a550773aa4e5805fa.jpg', null, 'album', 'ID558316172307595264', '101', null, '0', '168', '2019-04-09 17:45:31', '168', '2019-04-09 18:08:03');
INSERT INTO `audio` VALUES ('ID565231276592726016', '划粥度日苦读书', 'http://img.jssns.cn/SHILU/1/4abd708d4f0aad6f304a352f883cc0b9.mp3', '', 'http://img.jssns.cn/SHILU/1/51410129352659608.png', 'http://img.jssns.cn/SHILU/1/9be057f7cfb8a383a02c3e3ecad1b874.jpg', null, 'album', 'ID558316172307595264', '101', null, null, '168', '2019-04-09 17:47:17', '168', '2019-04-09 17:47:17');
INSERT INTO `audio` VALUES ('ID565231867960229888', '桥梁专家的诞生', 'http://img.jssns.cn/SHILU/1/50b2694bd945be5f22643bedff58a12c.mp3', '', 'http://img.jssns.cn/SHILU/1/51410270325362292.png', 'http://img.jssns.cn/SHILU/1/226d68a273472e7c4e7cd5e910e095fe.jpg', null, 'album', 'ID558316172307595264', null, null, null, '168', '2019-04-09 17:49:38', '168', '2019-04-09 17:49:38');
INSERT INTO `audio` VALUES ('ID565232320047480832', '乔丹落选之后', 'http://img.jssns.cn/SHILU/1/1e43b1a2bc400abb504c5329888607b3.mp3', '', 'http://img.jssns.cn/SHILU/1/51410378081046918.png', 'http://img.jssns.cn/SHILU/1/e5f9e6ec0014521ceda94285be43d537.jpg', null, 'album', 'ID558316172307595264', '101', null, null, '168', '2019-04-09 17:51:26', '168', '2019-04-09 17:51:26');
INSERT INTO `audio` VALUES ('ID566317727111708672', '为中华之崛起而读书', 'http://img.jssns.cn/SHILU/1/1a5cb1e84474164ebf9c6c08df1f9be4.mp3', '', 'http://img.jssns.cn/SHILU/1/51669160022426420.png', 'http://img.jssns.cn/SHILU/1/c695ac1e66c761ecd6b1c5b241015796.jpg', null, 'album', 'ID558316172307595264', null, null, null, '168', '2019-04-12 17:44:27', '168', '2019-04-12 17:44:27');
INSERT INTO `audio` VALUES ('ID572460652170313728', '《望庐山瀑布》唐·李白', 'http://img.jssns.cn/SHILU/1/ab168ae779a7563d0e168860b936a240.mp3', '<p><span style=\"color: rgb(33, 33, 33);\">望庐山瀑布</span></p><p><span style=\"color: rgb(33, 33, 33);\">（唐）李白</span></p><p><span style=\"color: rgb(33, 33, 33);\">日照香炉生紫烟，</span></p><p><span style=\"color: rgb(33, 33, 33);\">遥看瀑布挂前川，</span></p><p><span style=\"color: rgb(33, 33, 33);\">飞流直下三千尺。</span></p><p><span style=\"color: rgb(33, 33, 33);\">疑是银河落九天。</span></p><p><br></p><h2><span style=\"color: rgb(33, 33, 33);\">注释：</span></h2><p><br></p><p><span style=\"color: rgb(230, 0, 0);\">香炉</span><span style=\"color: rgb(33, 33, 33);\">：指香炉峰。紫烟：指日光透过云雾，远望如紫色的烟云。</span></p><p><span style=\"color: rgb(230, 0, 0);\">遥看</span><span style=\"color: rgb(33, 33, 33);\">：从远处看。</span></p><p><span style=\"color: rgb(230, 0, 0);\">挂</span><span style=\"color: rgb(33, 33, 33);\">：悬挂。</span></p><p><span style=\"color: rgb(230, 0, 0);\">前川</span><span style=\"color: rgb(33, 33, 33);\">：一作“长川”。川：河流，这里指瀑布。</span></p><p><span style=\"color: rgb(230, 0, 0);\">直</span><span style=\"color: rgb(33, 33, 33);\">：笔直。三千尺：形容山高。这里是夸张的说法，不是实指。</span></p><p><span style=\"color: rgb(230, 0, 0);\">疑</span><span style=\"color: rgb(33, 33, 33);\">：怀疑。银河：古人指银河系构成的带状星群。</span></p><p><span style=\"color: rgb(230, 0, 0);\">九天</span><span style=\"color: rgb(33, 33, 33);\">：一作“半天”。</span></p><p><br></p><h2><span style=\"color: rgb(33, 33, 33);\">译文:</span></h2><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">香炉峰在阳光的照射下生起紫色烟霞，远远望见瀑布似白色绢绸悬挂山前。</span></p><p><span style=\"color: rgb(33, 33, 33);\">高崖上飞腾直落的瀑布好像有几千尺，好像是银河从九天垂落山崖间。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">这是</span><a href=\"https://so.gushiwen.org/shiwenv_62802abab937.aspx\" target=\"_blank\" style=\"color: rgb(33, 33, 33);\">诗</a><span style=\"color: rgb(33, 33, 33);\">人五十岁左右隐居庐山时写的一首风景诗。这首诗形象地描绘了庐山瀑布雄奇壮丽的景色，反映了诗人对祖国大好河山的无限热爱。 </span></p><p><span style=\"color: rgb(33, 33, 33);\"> </span></p><p><span style=\"color: rgb(33, 33, 33);\">首句“日照香炉生紫烟”。“香炉”是指庐山的香炉峰。此峰在庐山西北，形状尖圆，像座香炉。由于瀑布飞泻，水气蒸腾而上，在丽日照耀下，仿佛有座顶天立地的香炉冉冉升起了团团紫烟。一个“生”字把烟云冉冉上升的景象写活了。此句为瀑布设置了雄奇的背景，也为下文直接描写瀑布渲染了气氛。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">次句“遥看瀑布挂前川”。“遥看瀑布”四字照应了题目《望庐山瀑布》。“挂前川” 是说瀑布像一条巨大的白练从悬崖直挂到前面的河流上。“挂”字化动为静，维纱维肖地写出遥望中的瀑布。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">诗的前两句从大处着笔，概写望中全景：山顶紫烟缭绕，山间白练悬挂，山下激流奔腾，构成一幅绚丽壮美的图景。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">第三句“飞流直下三千尺”，一笔挥洒，字字铿锵有力。“飞”字，把瀑布喷涌而出的景象描绘得极为生动；“直下”，既写出山之高峻陡峭，又可以见出水流之急，那高空直落，势不可挡之状如在眼前。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">诗人犹嫌未足，接着又写上一句“疑是银河落九天”，真是想落天外，惊人魂魄。“疑是”值得细味，诗人明明说得恍恍惚惚，而读者也明知不是，但是又都觉得只有这样写，才更为生动、逼真，其奥妙就在于诗人前面的描写中已经孕育了这一形象。巍巍香炉峰藏在云烟雾霭之中，遥望瀑布就如从云端飞流直下，临空而落，这就自然地联想到像是一条银河从天而降。可见，“疑是银河落九天”这一比喻，虽是奇特，但在诗中并不是凭空而来，而是在形象的刻画中自然地生发出来的。</span></p><p><br></p><p><span style=\"color: rgb(33, 33, 33);\">这首诗极其成功地运用了比喻、夸张和想象，构思奇特，语言生动形象、洗炼明快。苏东坡十分赞赏这首诗，说“帝遣银河一脉垂，古来唯有谪仙词”。“谪仙”就是李白。《望庐山瀑布》的确是状物写景和抒情的范例。</span></p>', 'http://img.jssns.cn/SHILU/1/53133747298935803.png', 'http://img.jssns.cn/SHILU/1/7fc0f2763a30dd69c65ee328e0cc072f.jpg', null, 'album', 'ID535147574781280256', '100', null, null, '168', '2019-04-29 16:34:15', '168', '2019-04-29 16:34:15');

-- ----------------------------
-- Table structure for `base_system_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `base_system_parameter`;
CREATE TABLE `base_system_parameter` (
  `REC_ID` varchar(30) NOT NULL,
  `PARAMETER_TYPE` varchar(50) DEFAULT NULL,
  `PARAMETER_KEY` varchar(100) DEFAULT NULL,
  `PARAMETER_NAME` varchar(100) DEFAULT NULL,
  `PARAMETER_VALUE` varchar(200) DEFAULT NULL,
  `WEIGHT` int(5) DEFAULT NULL,
  `PARENT_PARAMETER_TYPE` varchar(50) DEFAULT NULL,
  `PARENT_PARAMETER_KEY` varchar(100) DEFAULT NULL,
  `CREATE_TIME` varchar(100) DEFAULT NULL,
  `UPDATE_TIME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`REC_ID`),
  KEY `key_v_t_pid_idx` (`PARAMETER_KEY`,`PARAMETER_TYPE`,`PARAMETER_VALUE`,`PARENT_PARAMETER_KEY`),
  KEY `key_value_type_idx` (`PARAMETER_KEY`,`PARAMETER_TYPE`,`PARAMETER_VALUE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_system_parameter
-- ----------------------------
INSERT INTO `base_system_parameter` VALUES ('1', 'Reading_Type', '1', '阅读类型', '音频', '1', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('101', 'collect_type ', 'info', '被收藏类型', '资讯', '19', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('102', 'collect_type ', 'audio', '被收藏类型', '音频', '20', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('103', 'collect_type ', 'vedio', '被收藏类型', '视频', '21', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('104', 'like_type  ', 'info', '被点赞类型', '资讯', '22', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('105', 'like_type  ', 'audio', '被点赞类型', '音频', '23', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('106', 'like_type  ', 'vedio', '被点赞类型', '视频', '24', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('121', 'level', '1', '推荐年级', '七年级上', '28', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('122', 'level', '2', '推荐年级', '七年级下', '29', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('123', 'level', '3', '推荐年级', '八年级上', '30', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('124', 'level', '4', '推荐年级', '八年级下', '31', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('125', 'level', '5', '推荐年级', '九年级上', '32', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('126', 'level', '6', '推荐年级', '九年级下', '33', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('131', 'level', '1', '目录等级', '一级目录', '34', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('132', 'level', '2', '目录等级', '二级目录', '35', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('133', 'level', '3', '目录等级', '三级目录', '36', null, null, '2019-01-22 14:13:04', '2019-01-22 14:13:04');
INSERT INTO `base_system_parameter` VALUES ('150', 'recommend_meun', '1', '推荐栏目', '本周推荐', '40', null, null, '2019-01-25 16:11:44', '2019-01-25 16:11:44');
INSERT INTO `base_system_parameter` VALUES ('151', 'recommend_meun', '2', '推荐栏目', '经典必读', '41', null, null, '2019-01-25 16:11:44', '2019-01-25 16:11:44');
INSERT INTO `base_system_parameter` VALUES ('152', 'recommend_meun', '3', '推荐栏目', '中考必备', '42', null, null, '2019-01-25 16:11:44', '2019-01-25 16:11:44');
INSERT INTO `base_system_parameter` VALUES ('153', 'recommend_meun', '4', '推荐栏目', '高考必备', '43', null, null, '2019-01-25 16:11:44', '2019-01-25 16:11:44');
INSERT INTO `base_system_parameter` VALUES ('154', 'recommend_meun', '5', '推荐栏目', '教育部推荐书籍', '44', null, null, '2019-01-25 16:11:44', '2019-01-25 16:11:44');
INSERT INTO `base_system_parameter` VALUES ('2', 'Reading_Type', '2', '阅读类型', '视频', '2', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('200', 'PHASE', '1', '学段', '学前教育', '1', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('201', 'PHASE', '2', '学段', '小学', '2', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('202', 'PHASE', '3', '学段', '初中', '3', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('203', 'PHASE', '4', '学段', '高中', '4', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('204', 'SUBJECT', '1', '学科', '语文', '1', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('205', 'SUBJECT', '2', '学科', '数学', '2', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('206', 'SUBJECT', '3', '学科', '英语', '3', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('207', 'SUBJECT', '4', '学科', '道德与法治', '4', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('208', 'SUBJECT', '5', '学科', '历史', '5', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('209', 'SUBJECT', '6', '学科', '地理', '6', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('21', 'Album_Publish_Status', '0', '专辑发布状态', '未发布', '3', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('210', 'SUBJECT', '7', '学科', '物理', '7', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('211', 'SUBJECT', '8', '学科', '化学', '8', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('212', 'SUBJECT', '9', '学科', '生物', '9', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('213', 'SUBJECT', '10', '学科', '体育', '10', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('214', 'SUBJECT', '11', '学科', '劳动与技术', '11', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('215', 'SUBJECT', '12', '学科', '美术', '12', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('216', 'SUBJECT', '13', '学科', '音乐', '13', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('217', 'SUBJECT', '14', '学科', '综合实践', '14', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('218', 'SUBJECT', '15', '学科', '信息技术', '15', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('219', 'SUBJECT', '16', '学科', '通用技术', '16', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('22', 'Album_Publish_Status', '1', '专辑发布状态', '已发布', '4', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('220', 'SUBJECT', '17', '学科', '其他', '17', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('221', 'SUBJECT', '18', '学科', '教育管理', '18', '', '', '2017/12/9 16:44', '2017/12/9 16:44');
INSERT INTO `base_system_parameter` VALUES ('222', 'PHASE', '5', '学段', '其他', '5', '', '', '2017/12/9 17:34', '2017/12/9 17:34');
INSERT INTO `base_system_parameter` VALUES ('223', 'PHASE', '6', '学段', '职业高中', '6', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('224', 'SUBJECT', '19', '学科', '体育与健康', '19', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('225', 'SUBJECT', '20', '学科', '思想品德', '20', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('226', 'SUBJECT', '21', '学科', '艺术或音乐美术', '21', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('227', 'SUBJECT', '22', '学科', '财经商贸', '22', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('228', 'SUBJECT', '23', '学科', '电子电工', '23', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('229', 'SUBJECT', '24', '学科', '纺织服装', '24', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('230', 'SUBJECT', '25', '学科', '机电', '25', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('231', 'SUBJECT', '26', '学科', '机械', '26', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('232', 'SUBJECT', '27', '学科', '计算机', '27', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('233', 'SUBJECT', '28', '学科', '汽修', '28', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('234', 'SUBJECT', '29', '学科', '外语', '29', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('235', 'SUBJECT', '30', '学科', '旅游管理', '30', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('236', 'SUBJECT', '31', '学科', '教育技术', '31', '', '', '2018/4/11 22:32', '2018/4/11 22:32');
INSERT INTO `base_system_parameter` VALUES ('237', 'SUBJECT', '32', '学科', '政治', '32', '', '', '2018/4/21 15:50', '2018/4/21 15:50');
INSERT INTO `base_system_parameter` VALUES ('238', 'SUBJECT', '33', '学科', '心理', '33', '', '', '2018/4/21 15:50', '2018/4/21 15:50');
INSERT INTO `base_system_parameter` VALUES ('239', 'SUBJECT', '34', '学科', '烹饪', '34', '', '', '2018/4/21 15:50', '2018/4/21 15:50');
INSERT INTO `base_system_parameter` VALUES ('240', 'SUBJECT', '35', '学科', '舞蹈', '35', '', '', '2018/4/21 15:50', '2018/4/21 15:50');
INSERT INTO `base_system_parameter` VALUES ('241', 'SUBJECT', '36', '学科', '艺术设计', '36', '', '', '2018/4/21 15:50', '2018/4/21 15:50');
INSERT INTO `base_system_parameter` VALUES ('242', 'SUBJECT', '', '学科', '全学科', '0', '', '', '2018/9/7 18:02', '2018/9/7 18:02');
INSERT INTO `base_system_parameter` VALUES ('243', 'PHASE', '', '学段', '全学段', '0', '', '', '2018/9/7 18:02', '2018/9/7 18:02');
INSERT INTO `base_system_parameter` VALUES ('31', 'Album_Status', '0', '专辑状态', '删除', '5', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('32', 'Album_Status', '1', '专辑状态', '正常', '6', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('41', 'Audio_Type', 'album', '音频类型', '专辑', '7', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('42', 'Audio_Type', 'book', '音频类型', '书籍', '8', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('51', 'Video_Type', 'album', '视频类型', '专辑', '9', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('52', 'Video_Type', 'book', '视频类型', '书籍', '10', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('61', 'Comment_Type', 'info', '被评论类型', '资讯', '11', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('62', 'Comment_Type', 'reply', '被评论类型', '评论回复', '12', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('71', 'Review_Status', '0', '评论状态', '删除', '13', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('72', 'Review_Status', '1', '评论状态', '正常', '14', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('81', 'Information_publish_status ', '0', '资讯发布状态', '未发布', '15', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('82', 'Information_publish_status ', '1', '资讯发布状态', '已发布', '16', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('91', 'Information_status ', '0', '资讯状态', '删除', '17', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');
INSERT INTO `base_system_parameter` VALUES ('92', 'Information_status ', '1', '资讯状态', '正常', '18', null, null, '2019-01-22 14:12:50', '2019-01-22 14:12:50');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '书籍名称',
  `author` varchar(30) DEFAULT NULL COMMENT '书籍作者名称',
  `intro` text COMMENT '书籍描述',
  `note` text COMMENT '笔记',
  `slogan` varchar(200) DEFAULT NULL COMMENT 'slogan',
  `type` varchar(6) DEFAULT NULL COMMENT '书籍类型(1 音频，2视频，3音频+视频）',
  `cover` varchar(200) DEFAULT NULL COMMENT '书籍封面(封面图片URL)',
  `pc_cover` varchar(200) DEFAULT NULL COMMENT 'pc端书籍封面',
  `banner` varchar(200) DEFAULT NULL COMMENT 'banner',
  `pc_banner` varchar(200) DEFAULT NULL COMMENT 'pc替换书籍封面',
  `qr_code` varchar(100) DEFAULT NULL COMMENT '二维码',
  `publish_status` varchar(6) DEFAULT NULL COMMENT '发布状态(0 未发布，1已发布)',
  `menu` varchar(30) DEFAULT NULL COMMENT '栏目',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `visit_num` bigint(11) DEFAULT NULL COMMENT '访问数量',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('ID532982257195941888', '《背影》', '朱自清', '<p class=\"ql-align-justify\"><strong>一、语言特色</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">这篇散文的语言非常忠实朴素，又非常典雅文质。这种高度民族化的语言，和文章所表现的民族的精神气质，和文章的完美结构，恰成和谐的统一。没有《背影》语言的简洁明丽、古朴质实，就没有《背影》的一切风采。《背影》的语言还有文白夹杂的特点。例如不说“失业”，而说“赋闲”，最后一节因父亲来信是文言，引用原句，更见真实，也表达了家庭、父亲的困境和苍凉的心情与复杂的感受，同时，文白夹杂的语句，也笼上了一层时代赋予小资产阶级知识分子的特殊语言色彩。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>二、写作特色</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">这篇散文写作上的主要特点是白描。全文集中描写的，是父亲在特定场合下使作者极为感动的那一个背影。作者写了当时父亲的体态、穿着打扮，更主要地写了买橘子时穿过铁路的情形。并不借助于什么修饰、陪衬之类，只把当时的情景再现于眼前。这种白描的文字，读起来清淡质朴，却情真昧浓，蕴藏着一段深情。所谓于平淡中见神奇。其次，作品还运用了侧面烘托的手法。如写儿子“看见他的背影”，“泪很快地流下来了”。又写父亲买桔子回来时，儿子“赶紧去搀他”。这些侧面烘托手法的运用，更加反衬出父亲爱子的动人力量。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\"><strong>三、行文立意</strong></p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">这篇散文的特点是抓住人物形象的特征“背影”命题立意，在叙事中抒发父子深情。“背影”在文章中出现了四次，每次的情况有所不同，而思想感情却是一脉相承。第一次开篇点题“背影”，有一种浓厚的感情气氛笼罩全文。第二次车站送别，作者对父亲的“背影”做了具体的描绘。第三次是父亲和儿子告别后，儿子眼望着父亲的“背影”在人群中消逝，离情别绪，催人泪下。第四次在文章的结尾，儿子读着父亲的来信，在泪光中再次浮现了父亲的“背影”，思念之情不能自已，与文章开头呼应，把父子之间的真挚感情表现得淋漓尽致。</p>', null, '背影', 'book', 'http://img.jssns.cn/SHILU/1/209cfb7f4e455d164be90535f9ab218d.jpg', null, 'http://img.jssns.cn/SHILU/1/48f027011ef49f79c16b8a98dcaf9139.png', null, 'http://img.jssns.cn/SHILU/1/44071886939508952.png', '0', null, '0', '4', '0', '168', '2019-01-10 18:01:12', '168', '2019-01-31 22:34:41');
INSERT INTO `book` VALUES ('ID534321710904639488', '《雨巷》', '', '<p class=\"ql-align-justify\">《雨巷》是戴望舒的成名作。这首诗一扫当时诗坛坦白直露之风，在中西诗歌技巧的融汇上做出了可贵的探索。具体地说，便是象征主义诗歌的技巧与中国古典诗词意象的结合。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">此诗最直观的美感是音乐美。“彷徨”、“悠长”、“雨巷”，“丁香”、“姑娘”、“惆怅”、“迷茫”均用唐韵或“江阳辙”，回环吟叹，更增添了全诗幽茫惆怅的情致。其用韵与古典诗歌将韵用在诗脚不同，而直接受到象征主义诗人魏尔仑的影响，采取了较为自由的诗歌格律，让同样的子音和母音在诗行中反复出现，以达到听觉的和谐和加强某种诗情的效果。这种手法在当时是很新鲜的，叶圣陶称《雨巷》“替新诗底音节开了一个新的纪元”（杜衡：《（望舒草）序》），他所称许的就是《雨巷》音乐美的非传统性。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">从立意上看，《雨巷》也呈现了象征主义诗歌的主题朦胧性的特征。这首诗写于1927年大革命挫败之时，评论者多认为有所寄托，它既可以看作是表达了诗人对理想事物的模糊追求和在黑暗现实中产生的感伤怅惘的情绪，亦可理解为对革命事业的想望和大革命失败后的幻灭感。如结合诗人当时正值韶华和恋爱上的一再挫败，我们也可回复到诗的表层意义，看作是诗人对丁香一样结着愁怨的姑娘的向往与爱慕，想爱而不得，与爱擦肩而过的淡淡的怅惘与忧伤。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">诗中的意象是纯粹中国式的，丁香与愁心，是中国古典诗词中惯用的典故。李商隐曾有“芭焦不展丁香结，同向春风各自愁”的诗句；李球也有“青鸟不传云外信，丁香空结雨中愁”的词语。但在此诗中，丁香的形象又有所发展，不仅有愁怨，也有芬芳与颜色，成为美好事物的代称。戴望舒的古典文学修养作为一种艺术素质成为他审美理想的重要部分，这就使他的诗在吸取外国诗歌养分时，并没有流于晦涩。他注意化用中国古典诗歌的传统意象，融汇西方现代诗歌技巧，形成自己诗技艺的特色。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">《雨巷》就是对中西诗歌艺术的完美融合，是现代新诗史不可忽视的一首精品。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">《雨巷》是戴望舒的成名作和前期的代表作，他曾因此而赢得了“雨巷诗人”的雅号。这首诗写于1927年夏天。当时全国处于白色恐怖之汇总，戴望舒因曾参加进步活动而不得不避居于松江的友人家中，在孤寂中咀嚼着大革命失败后的幻灭与痛苦，心汇总充满了迷惘的情绪和朦胧的希望。《雨巷》通篇描绘了一幅梅雨季节江南小巷的阴沉图景，诗作就是他的这种心情的表现，其中交织着失望和希望、幻灭和追求的双重情调。这种情怀在当时是有一定的普遍性的。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">《雨巷》运用了象征性的抒情手法。诗中那狭窄阴沉的雨巷一一黑暗沉闷的社会现实；在雨巷中徘徊的独行者；以及那个像丁香一样结着愁怨的姑娘一一她的出现及飘然而去象征着诗人的理想、追求和幻灭的痛苦都是象征性的意象。这些意象又共同构成了一种象征性的意境，含蓄地暗示出作者即迷惘感伤又有期待的情怀，并给人一种朦胧而又幽深的美感。富于音乐性是《雨巷》的另一个突出的艺术特色。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">诗中运用了复沓、叠句、重唱等手法，造成了回环往复的旋律和宛转悦耳的乐感。因此叶圣陶先生称赞这首诗为中国新诗的音节开了一个“新纪元”。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">全诗所构成的是一个富有浓重的象征色彩的抒情意境。在这里，诗人反当时的黑暗喻为悠长而寂廖的“雨巷”，没有欢乐，没有阳光，而诗人自己，就是在这样的雨巷中孤独徘徊者。他在孤寂中仍怀着美好的理想和希望。</p><p class=\"ql-align-justify\">诗人笔下的“丁香一样的”姑娘，就是这种美好理想的象征。然而诗人知道，这美好理想是很难实现的，他的希望也将是落空的。这种心情，正是1927年大革命失败后一部分进步青年由于找不到出路、看不到前途而在痛苦中陷于彷德迷惘的真实反映，这是现实的黑培和理想的幻灭在诗人心中的投影，是当时一部分青年心灵深处典型的声音的再现。</p><p class=\"ql-align-justify\">&nbsp;</p>', null, '', 'book', 'http://img.jssns.cn/SHILU/1/36a5d0a774ca4c5f61a99f69ec501ea0.jpg', null, 'http://img.jssns.cn/SHILU/1/89048365cd77d1cf22972a185e4829c7.jpg', null, 'http://img.jssns.cn/SHILU/1/44071914168515322.png', '0', null, '0', '2', '0', '168', '2019-01-14 10:43:43', '168', '2019-01-31 22:34:44');
INSERT INTO `book` VALUES ('ID534322399064096768', '《再别康桥》', '', '<p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">一、基本解读</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">“康桥”是徐志摩精神的故乡，与康桥匆匆作别，那种心情自然是依依难舍的。以悄然的惜别，抒写无尽的眷恋之意，是这首诗的特点。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">夕阳下的康河，波光激滟；河畔的金柳，似蒙着轻纱的新娘，那璀璨的艳影，令诗人的心湖荡漾；软泥上的青若在水底里招摇，让人心醉——诗人宁愿做一根水草，永远植根于康河的柔波里；榆荫下的清潭，天上的彩虹，人间的梦，一切的一切，揉碎在浮藻之间。尽管一切都被揉碎了，诗人依然撑着长篇在寻梦。在青草的深处，他宁愿满载一船星辉，放歌而归。但在现实中，诗人却不愿惊醒他心中的梦，千万缕惜别下之情，只化作心底里缠绵的笙箫、夜空中沉默的夏虫，在“悄悄”之中告别，在“悄悄”中离去，不带走一片云彩。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">二、精华鉴赏</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">“康桥”是徐志摩精神的故乡，与康桥匆匆作别，那种心情自然是依依难舍的。以悄然的惜别，抒写无尽的眷恋之意，是这首诗的特点。夕阳下的康河，波光激滟；河畔的金柳，似蒙着轻纱的新娘，那璀璨的艳影，令诗人的心湖荡漾；软泥上的青若在水底里招摇，让人心醉——诗人宁愿做一根水草，永远植根于康河的柔波里；榆荫下的清潭，天上的彩虹，人间的梦，一切的一切，揉碎在浮藻之间。</p><p class=\"ql-align-justify\"><br></p><p class=\"ql-align-justify\">尽管一切都被揉碎了，诗人依然撑着长篇在寻梦。在青草的深处，他宁愿满载一船星辉，放歌而归。但在现实中，诗人却不愿惊醒他心中的梦，千万缕惜别下之情，只化作心底里缠绵的笙箫、夜空中沉默的夏虫，在“悄悄”之中告别，在“悄悄”中离去，不带走一片云彩。</p>', null, '', 'book', 'http://img.jssns.cn/SHILU/1/462ce11f6e6f1e1939c160d872cb0869.jpg', null, 'http://img.jssns.cn/SHILU/1/14edb3f4f20fdbd89aa65d325a4b1e8d.jpg', null, 'http://img.jssns.cn/SHILU/1/44071929081739911.png', '0', null, '0', '3', '0', '168', '2019-01-14 10:46:27', '168', '2019-01-31 22:34:47');
INSERT INTO `book` VALUES ('ID538015249526161408', '创意写作', '', '<p><strong>什么是创意写作?</strong></p><p><br></p><p>网上的定义很多，比如“创意写作是这样一种写作，它以一种具有想象力的、通常是独特的又赋有诗意的方式表达作者的思想和情感。”或者创意写作是文字创作为形式、以作品为载体的创造性活动等等，但所谓万变不离其宗。</p><p><br></p><p>总结下我们发现，创意写作指任何形式的写作，但它不是简单意义上的信息表达，而是以表达思想、感受和情绪为目的。因此，创意写作的关键在于表达的动力和欲望。要想提高孩子表达的欲望，需要让孩子看到、体验到更多样的人生。但不是每个孩子都有机会去旅游，去参加各类游学活动。因此，借助电影、纪录片等媒介去体验另外一种生活，感受另外一种文化，是非常有价值的。</p><p><br></p><p>小小剧作家创意写作课程的灵感来自于朱自强老师的著作《光影中的创意写作》，即通过总结与提炼微电影的核心价值来辅助儿童进行创意写作。朱自强老师在书中是这么总结微电影创意写作的价值：</p><p><br></p><p>1、电影艺术的直观性符合儿童的内在成长规律。</p><p><br></p><p>2、电影题材的丰富性能够拓展儿童写作素材的广度。</p><p><br></p><p>3、电影表现技法与文学语言手法的相似性，能提高儿童的写作水平。</p><p><br></p><p>4、微电影本身的无限创意，能进一步激活儿童的创意思维。</p><p><br></p><p>5、电影促进儿童精神的成长，又反哺着儿童写作。</p><p><br></p><p>毫不夸张地说，微电影，是儿童创意写作的最佳范本。</p>', null, '', 'book', 'http://img.jssns.cn/SHILU/1/ac4496ae8a264dd4d6fab7cc8b7a97aa.jpg', null, 'http://img.jssns.cn/SHILU/1/12cac05665f234cced2bb25e7e6fbe64.jpg', null, 'http://img.jssns.cn/SHILU/1/44921322816463350.png', '1', null, '0', '1', '100', '168', '2019-01-24 15:20:31', '432228697144033280', '2019-03-20 14:43:21');
INSERT INTO `book` VALUES ('ID540612082446368768', '字里行间', '', '0', null, '', '', '', null, '', null, 'http://img.jssns.cn/SHILU/1/45540456700617349.png', '0', null, '0', '2', '0', '168', '2019-01-31 19:19:23', '168', '2019-01-31 23:40:52');
INSERT INTO `book` VALUES ('ID540677444353392640', '《小王子》', '安东尼·德·圣埃克苏佩', '<p>小王子来自遥远的612星球，降落至地球沙漠深处。他的星球很小，星球上有他的小房子，美丽的玫瑰，不会爆发的火山以及可恶的猴面包树。清除猴面包树，浇灌玫瑰，是他在这个星球的日常生活，重复但并不枯燥乏味。</p><p><br></p><p>小王子爱着玫瑰，因为她是他亲手浇灌的，是他亲手放在花罩的，是他亲自用屏风保护起来的。因为爱她，所以呵护她。</p><p><br></p><p>他倾听过她的怨艾和自诩，甚至有时，他聆听她的沉默。因为她是他的玫瑰。</p><p><br></p><p>玫瑰花的骄傲和再三试探使小王子负气离开家园，开始了宇宙旅行。</p><p><br></p><p>当失去一些东西时，才感到弥足珍贵。越是在生活中常见的，容易得到的东西，失去会越让人觉得后悔。我们的亲人，朋友，虽然每天都能见到，但是我们很多人没能感觉到他们对我们价值，许多人被其他被认为重要的事情而忽略了他们。但是，等到他们有一天不在时，我们才感到伤心，甚至难以接受。</p><p><br></p><p>拥有爱你的人，是一种幸福。在小王子离开的前一天，他们双方才意识到彼此在自己心中的重量。纵然后悔，为了赌气，小王子毅然离开了。玫瑰默默的流泪，小王子又何尝不是？但双方难以打破那层隔膜，难以妥协。</p><p><br></p><p>地球的花园里有五千朵玫瑰，它们美丽又高贵，小王子只拥有有一株玫瑰，但在他的心中是独一无二的。</p><p><br></p><p>纵然你拥有整个花园，拥有无数的玫瑰，但也无法代替心中独一无二的玫瑰。</p><p><br></p><p>小王子在地球上难以忍受孤独与对玫瑰的思念，宁愿以肉体的毁灭为代价，也要回去陪着玫瑰。他实在担心在没有自己的日子里，玫瑰的生活是否很好。他需要绵羊，但必须有牙套。因为只有这样，才能保障玫瑰的安全。</p><p><br></p><p>人只有在失去后才懂得珍惜，珍惜你爱的人，承担起你对她的责任，不要付出巨大的代价而弥补后悔。</p><p><br></p><p>这个星球上的人们每天忙忙碌碌，这是小王子对地球人的第一印象。</p><p><br></p><p>在长长轨道上，火车拉了一波又一波的人。小王子很不解，人们为了什么而忙碌，为了什么而奔波。</p><p><br></p><p>人们每天奔波，实际上自己也不知道为了什么。人们在忙碌中早已忘记的最初的理想，最初是为了什么而奋斗，只知道随波逐流，在人流中，渐渐的失去了那个本来的自我。</p><p><br></p><p>或许你最初的梦想，就是简单的追求幸福。那么何为幸福？在小王子看来，幸福就是在自己的星球上除一除害草，通一通火山，与玫瑰看一看日落。</p><p><br></p><p>但是人们并不会满足，他们不断的追求。得到的越多，他心里的欲望越是膨胀。与他人不断的攀比，最终也在攀比中劳烦身心，得不到幸福。</p><p><br></p><p>为什么人们不知道满足呢？小王子不解道。</p><p><br></p><p>孩子们自小以来，都要顺着大人们的思维生长，发育，如果违背大人们的意志，轻则予以否定，重则受到惩罚。</p><p><br></p><p>不要问为什么，因为大人们也不知道为什么。他们只知道自己的儿时也是这样过来的。</p><p><br></p><p>这就是这个恶性循环形成的原因。</p><p><br></p><p>在小说开头，作者给大人们画了一只吞了大象的蟒蛇，大人们认为这没有任何意义，于是不断的对此做出否定。也就是在大人一次一次的否定中，我们可怜的作者失去了对绘画的兴趣，从此画不出什么东西。</p><p><br></p><p>人就是这样，当自己的所做得不到任何的肯定，在别人看来只是毫无价值的垃圾时，他就会对比做出改变。更不用说被否定的对象是儿时的作者。</p><p><br></p><p>当作者将这幅画给小王子看时，小王子立刻说出了作者所画的内容，让作者感到安慰。他想，如果早点遇到小王子，他的人生轨迹或许会有所不同。</p><p><br></p><p>在大人们的视角的影响下，孩子们失去了自己的童真。有不少的孩子过度早熟，在各类节目都有神童的出现，每当我看到这些神童时，没有与他人一样的羡慕，只有深深的惋惜。三四岁，甚至是五六岁的孩子，正是孩子们天马行空的想象着一草一木，认识这个未知的世界的时候。本该天真烂漫的时候，却被无数的奥数题，钢琴，各种父母希望，大人们认可的标准所禁锢。</p><p><br></p><p>让我不解的是，大人们的思维，为何要强加在孩子的身上。当孩子们说着与自己年龄不相符合的话，做着成熟的动作，穿着成熟的服装出现在舞台上。让大人们连连点头称赞，而让我感到只有做作，虚伪以及对这些孩子的惋惜。这些孩子在无形就被剥夺了在这个年龄段本该拥有的最珍贵的东西。</p><p><br></p><p>如今出现了一种奇怪的现象，孩子们很成熟，但很多大人装嫩，发嗲，犯贱，并且这很受人们的欢迎。这种本末的倒置，或许小王子一生都难以理解吧。</p><p><br></p><p><strong>人与人之间为何会产生联系？</strong></p><p><br></p><p>狐狸与小王子相识在花园中，两者都很孤独。</p><p><br></p><p>狐狸请求小王子驯服自己，当驯服成功后，两者建立联系，当彼此分开时，又感到难舍。</p><p><br></p><p>小王子顿悟到，自己之所以想念玫瑰，是因为玫瑰驯服了自己。</p><p><br></p><p>人与人之间又何尝不是吗？将对方的存在当成习惯，习惯对方的一切习惯，这就是建立联系的起源，也就是驯服。</p><p><br></p><p>驯服是责任，是担当。本质的东西是用眼睛看不见的，只能用心去看。小王子为玫瑰花费时光，才使得他的玫瑰变得如此重要。对你驯养过的东西，你永远都有责任。当你离不开对方时，要懂得珍惜。</p><p><br></p><p>珍惜驯服了你或你驯服的人，因为这个过程并不容易，茫茫人海中，与你建立联系，便是缘。一切都是缘起，终结于缘。</p><p><br></p><p>想想自己有多久没有坐在椅子上，心里没有任何杂乱的事，只是一心一意，心平气和的看一次日出。</p><p><br></p><p>也许许多人好多年都没有这样做过了。在现在快节奏的生活中，任何事都讲究效率，人们做什么事也讲究功利主义。所以许多最为自然与本真的东西被我们忽略。</p><p><br></p><p>看看日出，对许多人来说，并不是很难。也就是刷朋友圈的时间，或者打游戏的时间。但是，想要抠出这些时间对人们来说很难很难。</p><p><br></p><p>人们知道旅游，想要融入自然。但是，又何尝认识到，其实，你只需要抬一抬头，便能欣赏自然的风光。</p><p><br></p><p>许多人对比表示不屑，日出，这种最平常，最无聊的东西，有什么可看的。但是，你不可否认的是，日出象征着新的一天的开始，是希望的象征。</p><p>小王子说:“你知道，当人们感到非常苦闷时，总是喜欢日落的。”</p><p><br></p><p>也许看看日落能让小王子回忆起自己与玫瑰的时光，或许他们一同看过日出日落。</p><p><br></p><p>珍惜你现在能够与你相爱的人一同看日出的机会，不要等到迟暮之年，冥冥之际留下遗憾。</p>', null, '', '', 'http://img.jssns.cn/SHILU/1/d9b2961c708ce42e923b07456c888eef.jpg', null, 'http://img.jssns.cn/SHILU/1/7c8bb5267170d359f9bf641df7a68ab5.jpg', null, 'http://img.jssns.cn/SHILU/1/45556040186002891.png', '1', null, '1', '0', '0', '168', '2019-01-31 23:39:08', '168', '2019-02-27 11:52:40');
INSERT INTO `book` VALUES ('ID540677937712594944', '《字里行间》', null, '', null, null, null, '', null, '', null, 'http://img.jssns.cn/SHILU/1/45556157179856201.png', '0', null, '0', null, null, '168', '2019-01-31 23:41:05', '168', '2019-02-01 10:09:40');
INSERT INTO `book` VALUES ('ID540846505183936512', '《海底两万里》', '儒勒·凡尔纳', '<p><span style=\"color: rgb(51, 51, 51);\">《海底两万里》是凡尔纳三部曲中的第二部，另外两部是《</span><a href=\"https://baike.sogou.com/lemma/ShowInnerLink.htm?lemmaId=183708&amp;ss_c=ssc.citiao.link\" target=\"_blank\" style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">格兰特船长的儿女</a><span style=\"color: rgb(51, 51, 51);\">》和《</span><a href=\"https://baike.sogou.com/lemma/ShowInnerLink.htm?lemmaId=64591712&amp;ss_c=ssc.citiao.link\" target=\"_blank\" style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">神秘岛</a><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">》。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳，出生于19世纪，1828年，距今，已经过了190年了，他是法国的小说家，剧作家以及诗人，凡尔纳出生于海国海港城市，叫做南特。出生在一个中产阶级的家庭，早年间依父亲的意愿在巴黎学习法律之后走上了写编剧以及杂志文章这条路。他的文章有很多被翻译成了多种语言并且是广泛流传。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">他的作品对科幻文学流派产生了巨大影响，因此也被成为科幻小说之父。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">据说他的第一部作品《气球上的星期五》连投了16家出版社都没有人愿意为他出版，他一气之下就把手稿扔进了火盆中，妻子看到后火速的抢救下来，才有机会让他遇到第17家出版社为他出版了这本书。名声大震，至此凡尔纳也就成了非常有名的科幻小说家。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">在凡尔纳的作品当作充满了明显的社会倾向，同时也充满了许多科学知识。但他本人确是一名宇宙神秘主义者，对世界有着崇拜感的。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳的才能在于他是在科学发展的范围之内，根据科学发展的规律和必然的趋势做出种种奇妙无比的构想。这些构想符合了当时科学发展的趋势，在20世纪之后这些全部成为了现实。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">而且他对于科学的态度是相当的严谨，相当认真的。它的想象是建立在科学之上的。比如说，他为了写地球飞到月球的故事，便事先研究了很多有关于空气动力，飞行速度，太空中的失重等等复杂的科技问题。正因如此他的很多科学幻想都成为了科学语言。其中就包括《海底两万里》当中我们都知道的潜水艇“鹦鹉螺号”。而在之后的1886年英国就真的建构了一艘用蓄电池推动的潜艇，就被命名为了“鹦鹉螺号”。当时的“鹦鹉螺号”成功的完成了水下航行。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">说到凡尔纳的写作风格，其实凡尔纳的作品基本属于浪漫主义文学。他总是在一个科学幻想的框架里面编织一个复杂曲折而又有趣的故事。惊险、刺激在衬托上非凡的大自然中奇景渲染了一种非常浓重的浪漫主义色彩，再加上凡尔纳他的文笔的流畅叙述清晰，从平淡的文字当中就可以传达出人类的热情。所以俄国作家列夫托尔福泰就曾经赞扬过他说凡尔纳创作的长篇小说使自己赞赏不已，在构思引发身省，情节入胜方面凡尔纳堪称一个大师。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳的作品不仅具有独特的艺术魅力，在现实生活中也产生了一场深远的影响。他在小说中塑造的一位位科学勇士和先驱的形象就影响了许多后代的科学家，许多科学家也都坦言，自己是受到了凡尔纳的启迪才走上的科学探索之路。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">收回到凡尔纳的科学探索之路，有很多科学家都说过凡尔纳是自己科学之路的一个引路者，如：潜水艇的发明者西蒙*莱克。在他的自传中第一句话就是“凡尔纳是我一生事业的总指挥”而海军少将伯德在飞越北极之后说：凡尔纳是他的领路人。瑞士著名深海探险家皮卡德以及无线电发明者马可尼都一致认为：凡尔纳是启发他们发明的重要人物，所以，后人为了纪念凡尔纳在文学上的付出，法国的赫切特图书公司于1927年开始设立了儒勒凡尔纳大奖专门奖励优秀的科幻原创作品，奖金高达5000法郎，折合人民币30500</span></p><p><br></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">好了，现在我们对凡尔纳的生平有了一个了解，那么打开你手中的《海底两万里》和婷婷老师开始遨游海底世界吧！</strong></p><p>&nbsp;</p>', null, '', '', 'http://img.jssns.cn/SHILU/1/7e2b9a951ee50296c6f5104266dacc48.jpg', null, 'http://img.jssns.cn/SHILU/1/19a83e5410706c86715f388d3663d886.jpg', null, 'http://img.jssns.cn/SHILU/1/45596347013980139.png', '1', null, '1', '0', '0', '168', '2019-02-01 10:50:55', '168', '2019-02-27 11:53:05');
INSERT INTO `book` VALUES ('ID542288738995142656', '《字里行间》', '冒继承', '<p>日常学习、生活离不开汉字，汉字是用来记录汉语的工具。我们学习汉字，用汉字记录我们的思考，表达我们的发现。用汉语阅读，与一位位高尚的人对话。看到一个个汉字，很多同学一定会觉得太简单了，谁不认识啊！可是，熟悉的并不等于熟知，看似简单的汉字背后还蕴藏着很大的学问。本书通过身体篇、天地篇、植物篇、动物篇、生活篇五个部分，生动展示了汉字的魅力。</p>', null, '', '', 'http://img.jssns.cn/SHILU/1/d218ce0cadfcfda6568a981820c6510d.png', null, 'http://img.jssns.cn/SHILU/1/a6b00b8db9c66d68c3212d3b2ab4971e.png', null, 'http://img.jssns.cn/SHILU/1/45940202458943167.png', '1', null, '0', '0', '0', '432228697144033280', '2019-02-05 10:21:50', '432228697144033280', '2019-02-05 12:01:18');
INSERT INTO `book` VALUES ('ID567793485105594368', '《傅雷家书》', '傅雷', '<p><img src=\"http://img.jssns.cn/SHILU/1/52104794255726490.jpeg\"></p>', null, '', 'book', 'http://img.jssns.cn/SHILU/1/fabc1567aab98ec1058303cb404cb506.png', null, '', null, 'http://img.jssns.cn/SHILU/1/52021008008068931.png', '1', null, '1', '0', '0', '168', '2019-04-16 19:28:35', '432228697144033280', '2019-04-17 18:48:16');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(200) DEFAULT NULL COMMENT '目录名字',
  `pid` varchar(30) DEFAULT NULL COMMENT '父级id',
  `ppid` varchar(30) DEFAULT NULL COMMENT '爷级id',
  `level` varchar(30) DEFAULT NULL COMMENT '等级',
  `weight` varchar(30) DEFAULT NULL COMMENT '排序',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='推荐中高考书籍目录（三级）';

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `discuss`
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `comment_type` varchar(10) DEFAULT NULL COMMENT '被评论类型(info:资讯,reply:评论回复)',
  `comment_id` varchar(30) DEFAULT NULL COMMENT '被评论主键',
  `reply_id` varchar(30) DEFAULT NULL COMMENT '回复评论',
  `content` varchar(2000) DEFAULT NULL COMMENT '评论内容',
  `like_num` bigint(11) DEFAULT '0' COMMENT '点赞数量',
  `status` varchar(6) DEFAULT NULL COMMENT '评论状态(0:删除,1正常)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '评论人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`rec_id`),
  KEY `idx_discuss` (`comment_type`,`comment_id`,`status`,`create_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES ('1', 'reply', 'ID528240846328299520', '14', '22', '0', null, '107', null);
INSERT INTO `discuss` VALUES ('12', 'reply', 'ID528240846328299520', '14', '2323', '0', null, '104', null);
INSERT INTO `discuss` VALUES ('121', 'reply', 'ID528240461635125248', 'ID528585173260828672', '2323', '0', '0', '516919611287928832', null);
INSERT INTO `discuss` VALUES ('1232', 'book', 'ID528240461635125248', null, '132424', '0', '0', '516919611287928832', null);
INSERT INTO `discuss` VALUES ('14', 'vedio', 'ID528240846328299520', '', '2324', '12', null, '103', null);
INSERT INTO `discuss` VALUES ('ID528585173260828672', 'book', 'ID528240461635125248', null, 'wFWEFWef', null, '1', '516919611287928832', '2018-12-29 14:48:45');
INSERT INTO `discuss` VALUES ('ID528606786513534976', 'book', 'ID528240461635125248', null, '和规范化', null, '0', '516919611287928832', '2018-12-29 16:14:38');
INSERT INTO `discuss` VALUES ('ID528625907313672192', 'reply', 'ID528240461635125248', 'ID528585173260828672', null, null, '1', '516919611287928832', '2018-12-29 17:30:37');
INSERT INTO `discuss` VALUES ('ID528627749229690880', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '1', '516919611287928832', '2018-12-29 17:37:56');
INSERT INTO `discuss` VALUES ('ID528627955543310336', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '1', '516919611287928832', '2018-12-29 17:38:46');
INSERT INTO `discuss` VALUES ('ID528629014789619712', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '0', '517349219414048768', '2018-12-29 17:42:58');
INSERT INTO `discuss` VALUES ('ID528629132716670976', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '1', '517349219414048768', '2018-12-29 17:43:26');
INSERT INTO `discuss` VALUES ('ID528629143110156288', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '517349219414048768', '2018-12-29 17:43:29');
INSERT INTO `discuss` VALUES ('ID529955629289177088', 'book', 'ID528240461635125248', null, '和女的', null, '0', '516919611287928832', '2019-01-02 09:34:28');
INSERT INTO `discuss` VALUES ('ID529981250086109184', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 11:16:16');
INSERT INTO `discuss` VALUES ('ID529991136677199872', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 11:55:33');
INSERT INTO `discuss` VALUES ('ID529991158089121792', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 11:55:38');
INSERT INTO `discuss` VALUES ('ID529992523528011776', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '1', '516919611287928832', '2019-01-02 12:01:04');
INSERT INTO `discuss` VALUES ('ID530024704342228992', 'book', 'ID528240461635125248', null, '胡说八道半个西瓜好多红包都不方便吃不饱吃不吃饭还吃饭不对不对不行不行不对不对吃饱吃吧吃吧不错不错', null, '0', '516919611287928832', '2019-01-02 14:08:56');
INSERT INTO `discuss` VALUES ('ID530024950598205440', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 14:09:55');
INSERT INTO `discuss` VALUES ('ID530030649172557824', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 14:32:34');
INSERT INTO `discuss` VALUES ('ID530033557679112192', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 14:44:07');
INSERT INTO `discuss` VALUES ('ID530033849028050944', 'reply', 'ID528240461635125248', 'ID529955629289177088', '和女的', null, '1', '516919611287928832', '2019-01-02 14:45:17');
INSERT INTO `discuss` VALUES ('ID530035581304963072', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '1', '516919611287928832', '2019-01-02 14:52:09');
INSERT INTO `discuss` VALUES ('ID530039205204590592', 'reply', 'ID528240461635125248', 'ID528606786513534976', '和规范化', null, '0', '516919611287928832', '2019-01-02 15:06:34');
INSERT INTO `discuss` VALUES ('ID530040797085564928', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'wFWEFWef', null, '1', '516919611287928832', '2019-01-02 15:12:53');
INSERT INTO `discuss` VALUES ('ID530041123486302208', 'book', 'ID528240461635125248', null, 'i下一次刚才开会吃快餐刚开车苦瓜香菇凯旋国际新开业', null, '1', '516919611287928832', '2019-01-02 15:14:11');
INSERT INTO `discuss` VALUES ('ID530042632559132672', 'reply', 'ID528240461635125248', 'ID529955629289177088', '和女的', null, '1', '516919611287928832', '2019-01-02 15:20:11');
INSERT INTO `discuss` VALUES ('ID530042746237353984', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'i下一次刚才开会吃快餐刚开车苦瓜香菇凯旋国际新开业', null, '0', '516919611287928832', '2019-01-02 15:20:38');
INSERT INTO `discuss` VALUES ('ID530042907873247232', 'book', 'ID528240461635125248', null, '还是不是不得不变小白菜你都觉得', null, '1', '516919611287928832', '2019-01-02 15:21:16');
INSERT INTO `discuss` VALUES ('ID530043523668377600', 'book', 'ID528240461635125248', null, '：多喝点行吧行吧', null, '0', '516919611287928832', '2019-01-02 15:23:43');
INSERT INTO `discuss` VALUES ('ID530043553011728384', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'i下一次刚才开会吃快餐刚开车苦瓜香菇凯旋国际新开业', null, '0', '516919611287928832', '2019-01-02 15:23:50');
INSERT INTO `discuss` VALUES ('ID530043659295391744', 'reply', 'ID528240461635125248', 'ID530042907873247232', '还是不是不得不变小白菜你都觉得', null, '1', '516919611287928832', '2019-01-02 15:24:16');
INSERT INTO `discuss` VALUES ('ID530044257860321280', 'reply', 'ID528240461635125248', 'ID530042907873247232', '还是不是不得不变小白菜你都觉得', null, '1', '516919611287928832', '2019-01-02 15:26:38');
INSERT INTO `discuss` VALUES ('ID530044432670523392', 'reply', 'ID528240461635125248', 'ID530042907873247232', '还是不是不得不变小白菜你都觉得', null, '1', '516919611287928832', '2019-01-02 15:27:20');
INSERT INTO `discuss` VALUES ('ID530044961761001472', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'i下一次刚才开会吃快餐刚开车苦瓜香菇凯旋国际新开业', null, '0', '516919611287928832', '2019-01-02 15:29:26');
INSERT INTO `discuss` VALUES ('ID530048381947478016', 'reply', 'ID528240461635125248', 'ID529955629289177088', 'xascsc', null, '1', '516919611287928832', '2019-01-02 15:43:01');
INSERT INTO `discuss` VALUES ('ID530057491728302080', 'book', 'ID528240461635125248', null, '好的好的边伯贤', null, '1', '516919611287928832', '2019-01-02 16:19:13');
INSERT INTO `discuss` VALUES ('ID530059099073675264', 'book', 'ID528240461635125248', null, '好的笨蛋笨蛋', null, '0', '516919611287928832', '2019-01-02 16:25:37');
INSERT INTO `discuss` VALUES ('ID530059674775453696', 'book', 'ID528240461635125248', null, '横徐线', null, '0', '516919611287928832', '2019-01-02 16:27:54');
INSERT INTO `discuss` VALUES ('ID530059793381982208', 'book', 'ID528240461635125248', null, '此言差矣吃药', null, '0', '516919611287928832', '2019-01-02 16:28:22');
INSERT INTO `discuss` VALUES ('ID530060014996422656', 'book', 'ID528240461635125248', null, '不行不行吧', null, '0', '516919611287928832', '2019-01-02 16:29:15');
INSERT INTO `discuss` VALUES ('ID530060036303486976', 'book', 'ID528240461635125248', null, '好像不行', null, '0', '516919611287928832', '2019-01-02 16:29:20');
INSERT INTO `discuss` VALUES ('ID530060319632916480', 'book', 'ID528240461635125248', null, 'v等宝宝下班', null, '0', '516919611287928832', '2019-01-02 16:30:28');
INSERT INTO `discuss` VALUES ('ID530060427204231168', 'book', 'ID528240461635125248', null, '不对不对不错', null, '0', '516919611287928832', '2019-01-02 16:30:53');
INSERT INTO `discuss` VALUES ('ID530060439044751360', 'book', 'ID528240461635125248', null, '不对不对不错', null, '0', '516919611287928832', '2019-01-02 16:30:56');
INSERT INTO `discuss` VALUES ('ID530060450721693696', 'book', 'ID528240461635125248', null, '不对不对不错', null, '0', '516919611287928832', '2019-01-02 16:30:59');
INSERT INTO `discuss` VALUES ('ID530060942898102272', 'book', 'ID528240461635125248', null, '应该是vv', null, '0', '516919611287928832', '2019-01-02 16:32:56');
INSERT INTO `discuss` VALUES ('ID530060958354112512', 'book', 'ID528240461635125248', null, '应该是vv', null, '0', '516919611287928832', '2019-01-02 16:33:00');
INSERT INTO `discuss` VALUES ('ID530060972266618880', 'book', 'ID528240461635125248', null, '应该是vv', null, '0', '516919611287928832', '2019-01-02 16:33:03');
INSERT INTO `discuss` VALUES ('ID530060980684587008', 'book', 'ID528240461635125248', null, '应该是vv', null, '0', '516919611287928832', '2019-01-02 16:33:05');
INSERT INTO `discuss` VALUES ('ID530061260356583424', 'book', 'ID528240461635125248', null, '不大不小', null, '0', '516919611287928832', '2019-01-02 16:34:12');
INSERT INTO `discuss` VALUES ('ID530061272977244160', 'book', 'ID528240461635125248', null, '不大不小', null, '0', '516919611287928832', '2019-01-02 16:34:15');
INSERT INTO `discuss` VALUES ('ID530061280870924288', 'book', 'ID528240461635125248', null, '不大不小', null, '0', '516919611287928832', '2019-01-02 16:34:17');
INSERT INTO `discuss` VALUES ('ID530061801098838016', 'book', 'ID528240461635125248', null, '改善伙食吧', null, '0', '516919611287928832', '2019-01-02 16:36:21');
INSERT INTO `discuss` VALUES ('ID530061816017977344', 'book', 'ID528240461635125248', null, '改善伙食吧', null, '0', '516919611287928832', '2019-01-02 16:36:25');
INSERT INTO `discuss` VALUES ('ID530061825866203136', 'book', 'ID528240461635125248', null, '改善伙食吧', null, '0', '516919611287928832', '2019-01-02 16:36:27');
INSERT INTO `discuss` VALUES ('ID530062212073521152', 'book', 'ID528240461635125248', null, '改善伙食吧', null, '0', '516919611287928832', '2019-01-02 16:37:59');
INSERT INTO `discuss` VALUES ('ID530062253903314944', 'book', 'ID528240461635125248', null, '改善伙食吧', null, '0', '516919611287928832', '2019-01-02 16:38:09');
INSERT INTO `discuss` VALUES ('ID530062882394603520', 'book', 'ID528240461635125248', null, 'qwwqcq', null, '0', '516919611287928832', '2019-01-02 16:40:39');
INSERT INTO `discuss` VALUES ('ID530063496348434432', 'book', 'ID528240461635125248', null, 'rverv', null, '0', '516919611287928832', '2019-01-02 16:43:05');
INSERT INTO `discuss` VALUES ('ID530082634395549696', 'reply', 'ID528240461635125248', 'ID528606786513534976', '好的吧不错不错', null, '1', '516919611287928832', '2019-01-02 17:59:08');
INSERT INTO `discuss` VALUES ('ID530083356583395328', 'reply', 'ID528240461635125248', 'ID530043523668377600', '随便吧行吧行吧', null, '1', '516919611287928832', '2019-01-02 18:02:00');
INSERT INTO `discuss` VALUES ('ID530327847097597952', 'reply', 'ID528240461635125248', '', '八点半下班不行不行', null, '1', '516919611287928832', '2019-01-03 10:13:31');
INSERT INTO `discuss` VALUES ('ID530400163638804480', 'reply', 'ID528240461635125248', '', '不大好吧不错', null, '1', '516919611287928832', '2019-01-03 15:00:53');
INSERT INTO `discuss` VALUES ('ID530402791483506688', 'reply', 'ID528240461635125248', '', '手机京东办不成', null, '1', '516919611287928832', '2019-01-03 15:11:19');
INSERT INTO `discuss` VALUES ('ID530415202089304064', 'reply', 'ID528240461635125248', '', '不上班吧大包小包', null, '1', '516919611287928832', '2019-01-03 16:00:38');
INSERT INTO `discuss` VALUES ('ID530415265628815360', 'reply', 'ID528240461635125248', '', '荷包蛋棒棒哒', null, '1', '516919611287928832', '2019-01-03 16:00:53');
INSERT INTO `discuss` VALUES ('ID530415408235151360', 'reply', 'ID528240461635125248', 'ID530043523668377600', '不上班不行', null, '1', '516919611287928832', '2019-01-03 16:01:27');
INSERT INTO `discuss` VALUES ('ID530415607024189440', 'reply', 'ID528240461635125248', 'ID530043523668377600', '寻宝', null, '1', '516919611287928832', '2019-01-03 16:02:15');
INSERT INTO `discuss` VALUES ('ID530415676813213696', 'reply', 'ID528240461635125248', 'ID530043523668377600', '发个v', null, '1', '516919611287928832', '2019-01-03 16:02:31');
INSERT INTO `discuss` VALUES ('ID530416708347756544', 'reply', 'ID528240461635125248', '', '哥vvv下', null, '1', '516919611287928832', '2019-01-03 16:06:37');
INSERT INTO `discuss` VALUES ('ID530416792317722624', 'reply', 'ID528240461635125248', '', '到', null, '1', '516919611287928832', '2019-01-03 16:06:57');
INSERT INTO `discuss` VALUES ('ID530416885926199296', 'reply', 'ID528240461635125248', '', '分分彩', null, '1', '516919611287928832', '2019-01-03 16:07:20');
INSERT INTO `discuss` VALUES ('ID530417722400440320', 'reply', 'ID528240461635125248', '', '还是不行不行', null, '1', '516919611287928832', '2019-01-03 16:10:39');
INSERT INTO `discuss` VALUES ('ID530417986712895488', 'reply', 'ID528240461635125248', '', '呵呵笨蛋笨笨熊', null, '1', '516919611287928832', '2019-01-03 16:11:42');
INSERT INTO `discuss` VALUES ('ID530420384869122048', 'reply', 'ID528240461635125248', '', '红本本不喜欢╮（﹀＿﹀）╭', null, '1', '516919611287928832', '2019-01-03 16:21:14');
INSERT INTO `discuss` VALUES ('ID530420531971751936', 'reply', 'ID528240461635125248', 'ID529955629289177088', '版本的', null, '1', '516919611287928832', '2019-01-03 16:21:49');
INSERT INTO `discuss` VALUES ('ID530421724332687360', 'reply', 'ID528240461635125248', '', '哈哈哈', null, '1', '516919611287928832', '2019-01-03 16:26:33');
INSERT INTO `discuss` VALUES ('ID530422629908086784', 'reply', 'ID528240461635125248', '', 'asdafa', null, '1', '516919611287928832', '2019-01-03 16:30:09');
INSERT INTO `discuss` VALUES ('ID530422839795253248', 'reply', 'ID528240461635125248', '', 'dsadad', null, '1', '516919611287928832', '2019-01-03 16:30:59');
INSERT INTO `discuss` VALUES ('ID530423459239428096', 'reply', 'ID528240461635125248', '', 'vrwevwv', null, '1', '516919611287928832', '2019-01-03 16:33:27');
INSERT INTO `discuss` VALUES ('ID530423606916677632', 'reply', 'ID528240461635125248', '', 'fsadad', null, '1', '516919611287928832', '2019-01-03 16:34:02');
INSERT INTO `discuss` VALUES ('ID530424240634068992', 'reply', 'ID528240461635125248', '', 'fggvghvh', null, '1', '516919611287928832', '2019-01-03 16:36:33');
INSERT INTO `discuss` VALUES ('ID530427223744708608', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'hjhjhkjhkk', null, '1', '516919611287928832', '2019-01-03 16:48:24');
INSERT INTO `discuss` VALUES ('ID530428094184423424', 'reply', 'ID528240461635125248', 'ID530041123486302208', '发生过八点半', null, '1', '516919611287928832', '2019-01-03 16:51:52');
INSERT INTO `discuss` VALUES ('ID530429020962029568', 'reply', 'ID528240461635125248', 'ID529955629289177088', '后边的不行', null, '1', '516919611287928832', '2019-01-03 16:55:33');
INSERT INTO `discuss` VALUES ('ID530431665567170560', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'asdafsa', null, '1', '516919611287928832', '2019-01-03 17:06:04');
INSERT INTO `discuss` VALUES ('ID530431895289200640', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'revg', null, '1', '516919611287928832', '2019-01-03 17:06:58');
INSERT INTO `discuss` VALUES ('ID530433668737400832', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'hjhj', null, '1', '516919611287928832', '2019-01-03 17:14:01');
INSERT INTO `discuss` VALUES ('ID530433934291369984', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'vfddg', null, '1', '516919611287928832', '2019-01-03 17:15:04');
INSERT INTO `discuss` VALUES ('ID530434963175112704', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'fsdfdsf', null, '1', '516919611287928832', '2019-01-03 17:19:10');
INSERT INTO `discuss` VALUES ('ID530434995509002240', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'ghgfh', null, '1', '516919611287928832', '2019-01-03 17:19:17');
INSERT INTO `discuss` VALUES ('ID530435575820320768', 'reply', 'ID528240461635125248', 'ID529955629289177088', 'erwrwe', null, '1', '516919611287928832', '2019-01-03 17:21:36');
INSERT INTO `discuss` VALUES ('ID530436340269973504', 'reply', 'ID528240461635125248', 'ID529955629289177088', 'fdsfs', null, '1', '516919611287928832', '2019-01-03 17:24:38');
INSERT INTO `discuss` VALUES ('ID530436706235580416', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'lllll', null, '1', '516919611287928832', '2019-01-03 17:26:05');
INSERT INTO `discuss` VALUES ('ID530436989011361792', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'sadafasfa', null, '1', '516919611287928832', '2019-01-03 17:27:13');
INSERT INTO `discuss` VALUES ('ID530439160213798912', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'sdfdsfs', null, '1', '516919611287928832', '2019-01-03 17:35:50');
INSERT INTO `discuss` VALUES ('ID530441630071652352', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'gghgfh', null, '1', '516919611287928832', '2019-01-03 17:45:39');
INSERT INTO `discuss` VALUES ('ID530441675017814016', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'ikoko', null, '1', '516919611287928832', '2019-01-03 17:45:50');
INSERT INTO `discuss` VALUES ('ID530442409134260224', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'wqeqe', null, '1', '516919611287928832', '2019-01-03 17:48:45');
INSERT INTO `discuss` VALUES ('ID530442472581496832', 'reply', 'ID528240461635125248', 'ID530043523668377600', 'sdfdf', null, '1', '516919611287928832', '2019-01-03 17:49:00');
INSERT INTO `discuss` VALUES ('ID530442751477547008', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'safafs', null, '1', '516919611287928832', '2019-01-03 17:50:07');
INSERT INTO `discuss` VALUES ('ID530443004427632640', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'efsf', null, '1', '516919611287928832', '2019-01-03 17:51:07');
INSERT INTO `discuss` VALUES ('ID530443987408912384', 'reply', 'ID528240461635125248', 'ID528585173260828672', 'feeew', null, '1', '516919611287928832', '2019-01-03 17:55:01');
INSERT INTO `discuss` VALUES ('ID530444488095563776', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'safsaa', null, '1', '516919611287928832', '2019-01-03 17:57:01');
INSERT INTO `discuss` VALUES ('ID530444552893366272', 'reply', 'ID528240461635125248', 'ID530042907873247232', 'hgh', null, '1', '516919611287928832', '2019-01-03 17:57:16');
INSERT INTO `discuss` VALUES ('ID530444921904037888', 'reply', 'ID528240461635125248', 'ID530041123486302208', 'ascsafa', null, '0', '516919611287928832', '2019-01-03 17:58:44');
INSERT INTO `discuss` VALUES ('ID530445653856223232', 'reply', 'ID528240461635125248', 'ID530043523668377600', '1111111111', null, '1', '516919611287928832', '2019-01-03 18:01:39');
INSERT INTO `discuss` VALUES ('ID530447719035043840', 'reply', 'ID528240461635125248', 'ID529955629289177088', 'dsaas', null, '1', '516919611287928832', '2019-01-03 18:09:51');
INSERT INTO `discuss` VALUES ('ID530447868129968128', 'reply', 'ID528240461635125248', 'ID530041123486302208', '11111', null, '0', '516919611287928832', '2019-01-03 18:10:27');
INSERT INTO `discuss` VALUES ('ID530458959568437248', 'reply', 'ID528240461635125248', 'ID529955629289177088', '11111', null, '1', '516919611287928832', '2019-01-03 18:54:31');
INSERT INTO `discuss` VALUES ('ID530459301316132864', 'reply', 'ID528240461635125248', 'ID530042907873247232', '啊途虎', null, '1', '517713552572678144', '2019-01-03 18:55:52');
INSERT INTO `discuss` VALUES ('ID530459337210986496', 'reply', 'ID528240461635125248', 'ID530042907873247232', '阿鲁', null, '1', '517713552572678144', '2019-01-03 18:56:01');
INSERT INTO `discuss` VALUES ('ID530459375186214912', 'reply', 'ID528240461635125248', 'ID530042907873247232', '阿里巴巴', null, '1', '517713552572678144', '2019-01-03 18:56:10');
INSERT INTO `discuss` VALUES ('ID530459450037764096', 'reply', 'ID528240461635125248', 'ID530042907873247232', '您', null, '1', '517713552572678144', '2019-01-03 18:56:28');
INSERT INTO `discuss` VALUES ('ID530459586822406144', 'reply', 'ID528240461635125248', 'ID530043523668377600', '出去', null, '1', '517713552572678144', '2019-01-03 18:57:00');
INSERT INTO `discuss` VALUES ('ID530459690392354816', 'reply', 'ID528240461635125248', 'ID530043523668377600', '就去', null, '1', '517713552572678144', '2019-01-03 18:57:25');
INSERT INTO `discuss` VALUES ('ID530459723468636160', 'reply', 'ID528240461635125248', 'ID530043523668377600', '记录', null, '1', '517713552572678144', '2019-01-03 18:57:33');
INSERT INTO `discuss` VALUES ('ID530472035843833856', 'book', 'ID528240461635125248', null, '11111', null, '0', '516919611287928832', '2019-01-03 19:46:28');
INSERT INTO `discuss` VALUES ('ID530472373959262208', 'book', 'ID528240461635125248', null, '1111111', null, '0', '516919611287928832', '2019-01-03 19:47:49');
INSERT INTO `discuss` VALUES ('ID530472991444697088', 'book', 'ID528240461635125248', null, 'adsdsa', null, '0', '516919611287928832', '2019-01-03 19:50:16');
INSERT INTO `discuss` VALUES ('ID530491717128814592', 'reply', 'ID528240461635125248', 'ID530057491728302080', '高v额vvv徐v下', null, '0', '516919611287928832', '2019-01-03 21:04:41');
INSERT INTO `discuss` VALUES ('ID530491754684612608', 'reply', 'ID528240461635125248', 'ID530057491728302080', '不合适吧徐', null, '1', '516919611287928832', '2019-01-03 21:04:50');
INSERT INTO `discuss` VALUES ('ID531128525508313088', 'book', 'ID528240461635125248', null, '好多红包下班', null, '1', '516919611287928832', '2019-01-05 15:15:08');
INSERT INTO `discuss` VALUES ('ID531128540658139136', 'book', 'ID528240461635125248', null, '不上班不行', null, '0', '516919611287928832', '2019-01-05 15:15:11');
INSERT INTO `discuss` VALUES ('ID531128555409506304', 'book', 'ID528240461635125248', null, '那你写吧吃', null, '0', '516919611287928832', '2019-01-05 15:15:15');
INSERT INTO `discuss` VALUES ('ID531136068058087424', 'reply', 'ID528240461635125248', '', '更新', null, '1', '516919611287928832', '2019-01-05 15:45:06');
INSERT INTO `discuss` VALUES ('ID531138126177894400', 'reply', 'ID528240461635125248', '', '好多红包吃', null, '1', '516919611287928832', '2019-01-05 15:53:17');
INSERT INTO `discuss` VALUES ('ID531139250586910720', 'book', 'ID528240461635125248', null, '横向', null, '0', '516919611287928832', '2019-01-05 15:57:45');
INSERT INTO `discuss` VALUES ('ID531139283092766720', 'book', 'ID528240461635125248', null, '一会我把对吧', null, '0', '516919611287928832', '2019-01-05 15:57:53');
INSERT INTO `discuss` VALUES ('ID531139443797524480', 'book', 'ID528240461635125248', null, '路虎', null, '0', '517713552572678144', '2019-01-05 15:58:31');
INSERT INTO `discuss` VALUES ('ID531151608143151104', 'book', 'ID528240461635125248', null, '哈哈哈', null, '0', '517713552572678144', '2019-01-05 16:46:51');
INSERT INTO `discuss` VALUES ('ID531159811601989632', 'book', 'ID528240461635125248', null, '663', null, '1', '517713552572678144', '2019-01-05 17:19:27');
INSERT INTO `discuss` VALUES ('ID531162607403401216', 'reply', 'ID528240461635125248', 'ID528585173260828672', '真的是', null, '1', '517713552572678144', '2019-01-05 17:30:34');
INSERT INTO `discuss` VALUES ('ID531166432700923904', 'reply', 'ID528240461635125248', 'ID528585173260828672', '后边的不行', null, '1', '516919611287928832', '2019-01-05 17:45:46');
INSERT INTO `discuss` VALUES ('ID532130072560140288', 'book', 'ID528240461635125248', null, '我要删除', null, '0', '517349219414048768', '2019-01-08 09:34:55');
INSERT INTO `discuss` VALUES ('ID532130177774256128', 'book', 'ID528240461635125248', null, '位置在哪？', null, '1', '517349219414048768', '2019-01-08 09:35:20');
INSERT INTO `discuss` VALUES ('ID532143984709992448', 'book', 'ID528240461635125248', null, '好想抱抱下', null, '1', '516919611287928832', '2019-01-08 10:30:12');
INSERT INTO `discuss` VALUES ('ID532144051412008960', 'book', 'ID528240461635125248', null, '就不行不行', null, '1', '516919611287928832', '2019-01-08 10:30:28');
INSERT INTO `discuss` VALUES ('ID532144083624263680', 'book', 'ID528240461635125248', null, '聚聚吧', null, '1', '516919611287928832', '2019-01-08 10:30:36');
INSERT INTO `discuss` VALUES ('ID532144378286702592', 'book', 'ID528240461635125248', null, '呵呵哒不行', null, '1', '516919611287928832', '2019-01-08 10:31:46');
INSERT INTO `discuss` VALUES ('ID532146935646126080', 'book', 'ID528240461635125248', null, '好', null, '0', '516919611287928832', '2019-01-08 10:41:56');
INSERT INTO `discuss` VALUES ('ID532150330771636224', 'book', 'ID528240461635125248', null, '好好上班下', null, '0', '516919611287928832', '2019-01-08 10:55:25');
INSERT INTO `discuss` VALUES ('ID532250336618872832', 'reply', 'ID528240461635125248', 'ID530041123486302208', '？？？', null, '1', '517349219414048768', '2019-01-08 17:32:48');
INSERT INTO `discuss` VALUES ('ID532993955608920064', '', 'ID532982257195941888', null, '评论一下', null, '1', '517713552572678144', '2019-01-10 18:47:41');
INSERT INTO `discuss` VALUES ('ID532994004275429376', '', 'ID532982257195941888', null, '评论一下', null, '1', '517713552572678144', '2019-01-10 18:47:53');
INSERT INTO `discuss` VALUES ('ID532994717227417600', '', 'ID532982257195941888', null, '5555', null, '1', '517713552572678144', '2019-01-10 18:50:43');
INSERT INTO `discuss` VALUES ('ID532996614374031360', '', 'ID532982257195941888', null, '背影', null, '1', '517349219414048768', '2019-01-10 18:58:15');
INSERT INTO `discuss` VALUES ('ID532996865587675136', '', 'ID532982257195941888', null, '分分合合', null, '1', '517349219414048768', '2019-01-10 18:59:15');
INSERT INTO `discuss` VALUES ('ID532996978599002112', '', 'ID532982257195941888', null, '滚回家去', null, '1', '517349219414048768', '2019-01-10 18:59:42');
INSERT INTO `discuss` VALUES ('ID532996998001852416', '', 'ID532982257195941888', null, 'VB', null, '1', '517349219414048768', '2019-01-10 18:59:46');
INSERT INTO `discuss` VALUES ('ID532997018763657216', '', 'ID532982257195941888', null, '更何况', null, '1', '517349219414048768', '2019-01-10 18:59:51');
INSERT INTO `discuss` VALUES ('ID533216520222801920', '', 'ID532982257195941888', null, '测试一下品论', null, '1', '517349219414048768', '2019-01-11 09:32:04');
INSERT INTO `discuss` VALUES ('ID533216554255384576', '', 'ID532982257195941888', null, '？？？', null, '1', '517349219414048768', '2019-01-11 09:32:13');
INSERT INTO `discuss` VALUES ('ID533218523560804352', 'book', 'ID532982257195941888', null, '???', null, '0', '517349219414048768', '2019-01-11 09:40:02');
INSERT INTO `discuss` VALUES ('ID533220125378084864', 'book', 'ID532982257195941888', null, '测试频率', null, '0', '517349219414048768', '2019-01-11 09:46:24');
INSERT INTO `discuss` VALUES ('ID533220266755489792', 'book', 'ID532982257195941888', null, '测试评论', null, '0', '517349219414048768', '2019-01-11 09:46:58');
INSERT INTO `discuss` VALUES ('ID533222183422394368', '', 'ID532982257195941888', null, '测试？', null, '1', '517349219414048768', '2019-01-11 09:54:35');
INSERT INTO `discuss` VALUES ('ID533222299235516416', 'book', 'ID532982257195941888', null, '测试', null, '0', '517349219414048768', '2019-01-11 09:55:02');
INSERT INTO `discuss` VALUES ('ID533222716283551744', '', 'ID532982257195941888', null, '？？？', null, '1', '517349219414048768', '2019-01-11 09:56:42');
INSERT INTO `discuss` VALUES ('ID533238870574104576', 'book', 'ID532982257195941888', null, '并不代表都不行不行', null, '0', '516919611287928832', '2019-01-11 11:00:53');
INSERT INTO `discuss` VALUES ('ID533239344136192000', 'book', 'ID532982257195941888', null, '荷荷巴吧', null, '0', '516919611287928832', '2019-01-11 11:02:46');
INSERT INTO `discuss` VALUES ('ID533239352440913920', 'book', 'ID532982257195941888', null, '后边的不行吧', null, '0', '516919611287928832', '2019-01-11 11:02:48');
INSERT INTO `discuss` VALUES ('ID533241375378898944', 'book', 'ID532982257195941888', null, '恒大', null, '0', '516919611287928832', '2019-01-11 11:10:51');
INSERT INTO `discuss` VALUES ('ID533241394483953664', 'book', 'ID532982257195941888', null, '包包菜不错', null, '0', '516919611287928832', '2019-01-11 11:10:55');
INSERT INTO `discuss` VALUES ('ID533241415820378112', 'book', 'ID532982257195941888', null, '不不不差不多', null, '0', '516919611287928832', '2019-01-11 11:11:00');
INSERT INTO `discuss` VALUES ('ID533241536696025088', 'book', 'ID532982257195941888', null, '督促', null, '0', '516919611287928832', '2019-01-11 11:11:29');
INSERT INTO `discuss` VALUES ('ID533243467325767680', 'book', 'ID532982257195941888', null, '庚戌', null, '0', '516919611287928832', '2019-01-11 11:19:09');
INSERT INTO `discuss` VALUES ('ID533243592362164224', 'book', 'ID532982257195941888', null, '1111', null, '1', '517349219414048768', '2019-01-11 11:19:39');
INSERT INTO `discuss` VALUES ('ID533243813712363520', '', 'ID532982257195941888', null, '3*$;$', null, '1', '517349219414048768', '2019-01-11 11:20:32');
INSERT INTO `discuss` VALUES ('ID533243876106829824', '', 'ID532982257195941888', null, '123', null, '1', '517349219414048768', '2019-01-11 11:20:47');
INSERT INTO `discuss` VALUES ('ID533243909875171328', 'book', 'ID532982257195941888', null, '呵呵哒不行', null, '0', '516919611287928832', '2019-01-11 11:20:55');
INSERT INTO `discuss` VALUES ('ID533243969337819136', '', 'ID532982257195941888', null, '123', null, '1', '517349219414048768', '2019-01-11 11:21:09');
INSERT INTO `discuss` VALUES ('ID533244377254854656', 'book', 'ID532982257195941888', null, '追求', null, '1', '517713552572678144', '2019-01-11 11:22:46');
INSERT INTO `discuss` VALUES ('ID533244558637531136', 'book', 'ID532982257195941888', null, '123', null, '1', '517349219414048768', '2019-01-11 11:23:29');
INSERT INTO `discuss` VALUES ('ID533244623221424128', 'book', 'ID532982257195941888', null, '666666', null, '1', '517349219414048768', '2019-01-11 11:23:45');
INSERT INTO `discuss` VALUES ('ID533247604599816192', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:35:36');
INSERT INTO `discuss` VALUES ('ID533248725552726016', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:40:03');
INSERT INTO `discuss` VALUES ('ID533248727180115968', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:40:03');
INSERT INTO `discuss` VALUES ('ID533248858646380544', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:40:35');
INSERT INTO `discuss` VALUES ('ID533248860949053440', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:40:35');
INSERT INTO `discuss` VALUES ('ID533248866305179648', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:40:37');
INSERT INTO `discuss` VALUES ('ID533248988447506432', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:41:06');
INSERT INTO `discuss` VALUES ('ID533248990527881216', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:41:06');
INSERT INTO `discuss` VALUES ('ID533248991857475584', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '1', '516919611287928832', '2019-01-11 11:41:06');
INSERT INTO `discuss` VALUES ('ID533248992968966144', 'reply', 'ID532982257195941888', 'ID533244623221424128', '666666', null, '0', '516919611287928832', '2019-01-11 11:41:07');
INSERT INTO `discuss` VALUES ('ID533249077081538560', 'reply', 'ID532982257195941888', 'ID533244558637531136', '123', null, '1', '516919611287928832', '2019-01-11 11:41:27');
INSERT INTO `discuss` VALUES ('ID533249946132938752', 'reply', 'ID532982257195941888', 'ID533244623221424128', '阿萨德撒大', null, '0', '516919611287928832', '2019-01-11 11:44:54');
INSERT INTO `discuss` VALUES ('ID533285793045676032', 'reply', 'ID532982257195941888', 'ID533244558637531136', '深呼吸', null, '0', '516919611287928832', '2019-01-11 14:07:21');
INSERT INTO `discuss` VALUES ('ID533287064817369088', 'reply', 'ID532982257195941888', 'ID533244623221424128', '11', null, '0', '516919611287928832', '2019-01-11 14:12:24');
INSERT INTO `discuss` VALUES ('ID533287231276711936', 'reply', 'ID532982257195941888', 'ID533244558637531136', '11', null, '0', '516919611287928832', '2019-01-11 14:13:03');
INSERT INTO `discuss` VALUES ('ID533290697327902720', 'book', 'ID532982257195941888', null, '公司vv下', null, '0', '516919611287928832', '2019-01-11 14:26:50');
INSERT INTO `discuss` VALUES ('ID533295809026850816', 'book', 'ID532982257195941888', null, '11', null, '0', '516919611287928832', '2019-01-11 14:47:09');
INSERT INTO `discuss` VALUES ('ID533295881030467584', 'reply', 'ID532982257195941888', 'ID533241536696025088', '11', null, '0', '516919611287928832', '2019-01-11 14:47:26');
INSERT INTO `discuss` VALUES ('ID533295926463168512', 'book', 'ID532982257195941888', null, '22', null, '0', '516919611287928832', '2019-01-11 14:47:37');
INSERT INTO `discuss` VALUES ('ID533295949997408256', 'book', 'ID532982257195941888', null, '33', null, '0', '516919611287928832', '2019-01-11 14:47:42');
INSERT INTO `discuss` VALUES ('ID533296094663147520', 'book', 'ID532982257195941888', null, 'qq', null, '0', '516919611287928832', '2019-01-11 14:48:17');
INSERT INTO `discuss` VALUES ('ID533296181137113088', 'reply', 'ID532982257195941888', 'ID533244623221424128', '不是吧', null, '0', '516919611287928832', '2019-01-11 14:48:37');
INSERT INTO `discuss` VALUES ('ID533298001548935168', 'reply', 'ID532982257195941888', 'ID533244623221424128', '高v是v着', null, '0', '516919611287928832', '2019-01-11 14:55:51');
INSERT INTO `discuss` VALUES ('ID533300500477509632', 'book', 'ID532982257195941888', null, '大大', null, '0', '516919611287928832', '2019-01-11 15:05:47');
INSERT INTO `discuss` VALUES ('ID533300501081489408', 'book', 'ID532982257195941888', null, '是发发', null, '0', '516919611287928832', '2019-01-11 15:05:47');
INSERT INTO `discuss` VALUES ('ID533300514369044480', 'book', 'ID532982257195941888', null, '啊是飞洒发', null, '0', '516919611287928832', '2019-01-11 15:05:50');
INSERT INTO `discuss` VALUES ('ID533300523386798080', 'book', 'ID532982257195941888', null, '是飞洒发', null, '0', '516919611287928832', '2019-01-11 15:05:53');
INSERT INTO `discuss` VALUES ('ID533301044701036544', 'book', 'ID532982257195941888', null, '撒旦撒旦', null, '0', '516919611287928832', '2019-01-11 15:07:57');
INSERT INTO `discuss` VALUES ('ID533301058009563136', 'book', 'ID532982257195941888', null, '发发', null, '0', '516919611287928832', '2019-01-11 15:08:00');
INSERT INTO `discuss` VALUES ('ID533301069451624448', 'book', 'ID532982257195941888', null, '发发', null, '0', '516919611287928832', '2019-01-11 15:08:03');
INSERT INTO `discuss` VALUES ('ID533302757851922432', 'book', 'ID532982257195941888', null, '11', null, '1', '516919611287928832', '2019-01-11 15:14:45');
INSERT INTO `discuss` VALUES ('ID533302773609922560', 'book', 'ID532982257195941888', null, '22', null, '0', '516919611287928832', '2019-01-11 15:14:49');
INSERT INTO `discuss` VALUES ('ID533303123402293248', 'book', 'ID532982257195941888', null, '鱼', null, '0', '516919611287928832', '2019-01-11 15:16:12');
INSERT INTO `discuss` VALUES ('ID533303177676587008', 'book', 'ID532982257195941888', null, '看看', null, '1', '516919611287928832', '2019-01-11 15:16:25');
INSERT INTO `discuss` VALUES ('ID533303207682637824', 'reply', 'ID532982257195941888', 'ID533303177676587008', '哈哈哈', null, '0', '516919611287928832', '2019-01-11 15:16:33');
INSERT INTO `discuss` VALUES ('ID533304157449224192', 'reply', 'ID532982257195941888', 'ID533244558637531136', '很棒棒', null, '1', '516919611287928832', '2019-01-11 15:20:19');
INSERT INTO `discuss` VALUES ('ID533306554925973504', 'reply', 'ID532982257195941888', 'ID533244623221424128', 'qq', null, '1', '516919611287928832', '2019-01-11 15:29:51');
INSERT INTO `discuss` VALUES ('ID533306841522765824', 'reply', 'ID532982257195941888', 'ID533244623221424128', '??', null, '0', '517349219414048768', '2019-01-11 15:30:59');
INSERT INTO `discuss` VALUES ('ID533307374543306752', 'reply', 'ID532982257195941888', 'ID533243592362164224', '???', null, '1', '517349219414048768', '2019-01-11 15:33:06');
INSERT INTO `discuss` VALUES ('ID533307484652175360', 'reply', 'ID532982257195941888', 'ID533243592362164224', '*', null, '1', '517349219414048768', '2019-01-11 15:33:32');
INSERT INTO `discuss` VALUES ('ID533307773430005760', 'reply', 'ID532982257195941888', 'ID533243592362164224', '?', null, '1', '517349219414048768', '2019-01-11 15:34:41');
INSERT INTO `discuss` VALUES ('ID533307825372266496', 'reply', 'ID532982257195941888', 'ID533244377254854656', '111', null, '1', '517349219414048768', '2019-01-11 15:34:53');
INSERT INTO `discuss` VALUES ('ID533307882846814208', 'reply', 'ID532982257195941888', 'ID533302757851922432', '***', null, '1', '517349219414048768', '2019-01-11 15:35:07');
INSERT INTO `discuss` VALUES ('ID533308949357658112', 'reply', 'ID532982257195941888', 'ID533244377254854656', '糊糊饭', null, '1', '516919611287928832', '2019-01-11 15:39:21');
INSERT INTO `discuss` VALUES ('ID533309020979593216', 'reply', 'ID532982257195941888', 'ID533244377254854656', 'vv看', null, '1', '516919611287928832', '2019-01-11 15:39:39');
INSERT INTO `discuss` VALUES ('ID533310559995559936', 'book', 'ID532982257195941888', null, '111', null, '1', '516919611287928832', '2019-01-11 15:45:45');
INSERT INTO `discuss` VALUES ('ID533310856809676800', 'reply', 'ID532982257195941888', 'ID533310559995559936', '111', null, '1', '516919611287928832', '2019-01-11 15:46:56');
INSERT INTO `discuss` VALUES ('ID533311434386309120', 'book', 'ID532982257195941888', null, '1', null, '1', '516919611287928832', '2019-01-11 15:49:14');
INSERT INTO `discuss` VALUES ('ID533311450068811776', 'reply', 'ID532982257195941888', 'ID533311434386309120', '1', null, '1', '516919611287928832', '2019-01-11 15:49:18');
INSERT INTO `discuss` VALUES ('ID533311470729953280', 'reply', 'ID532982257195941888', 'ID533311434386309120', '1', null, '1', '516919611287928832', '2019-01-11 15:49:23');
INSERT INTO `discuss` VALUES ('ID533311501751025664', 'book', 'ID532982257195941888', null, '1', null, '1', '516919611287928832', '2019-01-11 15:49:30');
INSERT INTO `discuss` VALUES ('ID533311518398218240', 'reply', 'ID532982257195941888', 'ID533311501751025664', '1', null, '1', '516919611287928832', '2019-01-11 15:49:34');
INSERT INTO `discuss` VALUES ('ID533312318373625856', 'reply', 'ID532982257195941888', 'ID533311501751025664', '11', null, '1', '516919611287928832', '2019-01-11 15:52:45');
INSERT INTO `discuss` VALUES ('ID533312626348785664', 'reply', 'ID532982257195941888', 'ID533311501751025664', '22', null, '1', '516919611287928832', '2019-01-11 15:53:58');
INSERT INTO `discuss` VALUES ('ID533312990317903872', 'reply', 'ID532982257195941888', 'ID533311501751025664', '22', null, '1', '516919611287928832', '2019-01-11 15:55:25');
INSERT INTO `discuss` VALUES ('ID533313041903648768', 'reply', 'ID532982257195941888', 'ID533311501751025664', '11', null, '1', '516919611287928832', '2019-01-11 15:55:37');
INSERT INTO `discuss` VALUES ('ID533313081569181696', 'reply', 'ID532982257195941888', 'ID533311501751025664', '22', null, '1', '516919611287928832', '2019-01-11 15:55:47');
INSERT INTO `discuss` VALUES ('ID533722508730302464', 'book', 'ID532982257195941888', null, '抢我的我的', null, '1', '516919611287928832', '2019-01-12 19:02:42');
INSERT INTO `discuss` VALUES ('ID534324397205356544', 'book', 'ID532982257195941888', null, '，，', null, '1', '518084122451640320', '2019-01-14 10:54:23');
INSERT INTO `discuss` VALUES ('ID534701766235652096', 'book', 'ID532982257195941888', null, '您好', null, '1', '517366313497133056', '2019-01-15 11:53:55');
INSERT INTO `discuss` VALUES ('ID534748516480712704', 'reply', 'ID532982257195941888', 'ID533311501751025664', '?', null, '0', '517349219414048768', '2019-01-15 14:59:41');
INSERT INTO `discuss` VALUES ('ID534748575033196544', 'reply', 'ID532982257195941888', 'ID533310559995559936', '?', null, '0', '517349219414048768', '2019-01-15 14:59:55');
INSERT INTO `discuss` VALUES ('ID534751358197170176', 'reply', 'ID532982257195941888', 'ID533722508730302464', '111', null, '1', '516919611287928832', '2019-01-15 15:10:58');
INSERT INTO `discuss` VALUES ('ID534755297625899008', 'reply', 'ID532982257195941888', 'ID533244558637531136', '你还', null, '0', '517349219414048768', '2019-01-15 15:26:38');
INSERT INTO `discuss` VALUES ('ID534755405209796608', 'reply', 'ID532982257195941888', 'ID533722508730302464', '?', null, '0', '517349219414048768', '2019-01-15 15:27:03');
INSERT INTO `discuss` VALUES ('ID534775789032308736', 'book', 'ID532982257195941888', null, 'haba', null, '1', '518881498053476352', '2019-01-15 16:48:03');
INSERT INTO `discuss` VALUES ('ID534775865272172544', 'book', 'ID532982257195941888', null, '看见了', null, '1', '518881498053476352', '2019-01-15 16:48:21');
INSERT INTO `discuss` VALUES ('ID534780364086837248', 'book', 'ID532982257195941888', null, 'jierxi', null, '1', '518881498053476352', '2019-01-15 17:06:14');
INSERT INTO `discuss` VALUES ('ID534783426192998400', 'book', 'ID532982257195941888', null, '22', null, '1', '516919611287928832', '2019-01-15 17:18:24');
INSERT INTO `discuss` VALUES ('ID534837939713081344', 'book', 'ID532982257195941888', null, '这本书很好看哟', null, '1', '518881498053476352', '2019-01-15 20:55:01');
INSERT INTO `discuss` VALUES ('ID534841801840787456', 'reply', 'ID532982257195941888', 'ID534837939713081344', '你是', null, '1', '517366532112646144', '2019-01-15 21:10:22');
INSERT INTO `discuss` VALUES ('ID534842154661445632', 'book', 'ID532982257195941888', null, '工', null, '1', '517713552572678144', '2019-01-15 21:11:46');
INSERT INTO `discuss` VALUES ('ID534842463811010560', 'book', 'ID532982257195941888', null, '11', null, '0', '516919611287928832', '2019-01-15 21:13:00');
INSERT INTO `discuss` VALUES ('ID534845539095674880', 'book', 'ID532982257195941888', null, '发不了？', null, '0', '517349219414048768', '2019-01-15 21:25:13');
INSERT INTO `discuss` VALUES ('ID535200863476514816', 'book', 'ID532982257195941888', null, '我也想起我父亲的背影来', null, '0', '518881590537879552', '2019-01-16 20:57:09');
INSERT INTO `discuss` VALUES ('ID535200898322792448', 'book', 'ID534321710904639488', null, 'Dhsjsh', null, '1', '518880937937731584', '2019-01-16 20:57:17');
INSERT INTO `discuss` VALUES ('ID535200933894684672', 'book', 'ID532982257195941888', null, '我也想起父亲的背影了', null, '1', '518881590537879552', '2019-01-16 20:57:26');
INSERT INTO `discuss` VALUES ('ID535548278847045632', 'reply', 'ID532982257195941888', 'ID534837939713081344', '哦公司', null, '1', '518884655118680064', '2019-01-17 19:57:39');
INSERT INTO `discuss` VALUES ('ID538361948069167104', 'book', 'ID534321710904639488', null, '好文章！', null, '1', '528504526999650304', '2019-01-25 14:18:10');
INSERT INTO `discuss` VALUES ('ID538361994537861120', 'reply', 'ID534321710904639488', 'ID538361948069167104', '我也觉得！', null, '1', '528504526999650304', '2019-01-25 14:18:21');
INSERT INTO `discuss` VALUES ('ID538362029921009664', 'reply', 'ID534321710904639488', 'ID538361948069167104', '哈哈', null, '1', '528504526999650304', '2019-01-25 14:18:30');
INSERT INTO `discuss` VALUES ('ID538362704423813120', 'book', 'ID532982257195941888', null, '好文章', null, '1', '528504526999650304', '2019-01-25 14:21:11');
INSERT INTO `discuss` VALUES ('ID540851106423504896', 'book', 'ID540846505183936512', null, '智性阅读，大美人生，让经典陪伴我们成长', null, '1', '518084122451640320', '2019-02-01 11:09:12');
INSERT INTO `discuss` VALUES ('ID540851129622200320', 'book', 'ID540846505183936512', null, '老铁666', null, '1', '518881699824664576', '2019-02-01 11:09:17');
INSERT INTO `discuss` VALUES ('ID540851229626990592', 'book', 'ID540846505183936512', null, '? ? ? ? ? ? ? ? ? ? ', null, '1', '538370652508258304', '2019-02-01 11:09:41');
INSERT INTO `discuss` VALUES ('ID540851256155963392', 'book', 'ID540846505183936512', null, '爱我爱我', null, '0', '518882036950237184', '2019-02-01 11:09:47');
INSERT INTO `discuss` VALUES ('ID540851280885579776', 'book', 'ID540846505183936512', null, '厉害', null, '1', '518884655118680064', '2019-02-01 11:09:53');
INSERT INTO `discuss` VALUES ('ID540851295980879872', 'book', 'ID540846505183936512', null, '智性阅读，大美人生，让经典陪伴孩子成长', null, '1', '517366313497133056', '2019-02-01 11:09:57');
INSERT INTO `discuss` VALUES ('ID540851423458361344', 'book', 'ID540846505183936512', null, '。。。。', null, '1', '526060397392822272', '2019-02-01 11:10:27');
INSERT INTO `discuss` VALUES ('ID540851526772457472', 'book', 'ID540846505183936512', null, '㊗️ ㊗️ ㊗️ 智性阅读', null, '1', '531053882562838528', '2019-02-01 11:10:52');
INSERT INTO `discuss` VALUES ('ID540851771870806016', 'book', 'ID540846505183936512', null, '可以', null, '1', '540849671703101440', '2019-02-01 11:11:50');
INSERT INTO `discuss` VALUES ('ID540851817873932288', 'book', 'ID540846505183936512', null, '不能分享', null, '1', '540849671703101440', '2019-02-01 11:12:01');
INSERT INTO `discuss` VALUES ('ID540852759088332800', 'book', 'ID540846505183936512', null, '连自己的命运都不能主宰的人是没有自由可以享受的。', null, '1', '528504526999650304', '2019-02-01 11:15:46');
INSERT INTO `discuss` VALUES ('ID541373806262878208', 'book', 'ID540846505183936512', null, '加油', null, '1', '525776779072241664', '2019-02-02 21:46:13');
INSERT INTO `discuss` VALUES ('ID541379947952865280', 'book', 'ID540846505183936512', null, '真棒', null, '1', '521720061925261312', '2019-02-02 22:10:37');
INSERT INTO `discuss` VALUES ('ID547813807443935232', 'book', 'ID538015249526161408', null, '真好', null, '0', '516919611287928832', '2019-02-20 16:16:29');
INSERT INTO `discuss` VALUES ('ID547840748230279168', 'book', 'ID538015249526161408', null, '123', null, '1', '547840691636535296', '2019-02-20 18:03:32');
INSERT INTO `discuss` VALUES ('ID547840875313496064', 'reply', 'ID538015249526161408', 'ID547813807443935232', ' 222', null, '1', '547840691636535296', '2019-02-20 18:04:03');
INSERT INTO `discuss` VALUES ('ID547841759523110912', 'book', 'ID540846505183936512', null, '? ? ? ', null, '0', '547840691636535296', '2019-02-20 18:07:33');
INSERT INTO `discuss` VALUES ('ID547842087932919808', 'book', 'ID540846505183936512', null, '[新年快乐],点击[ http://pinyin.cn/e210144 ]查看表情', null, '0', '547840691636535296', '2019-02-20 18:08:52');
INSERT INTO `discuss` VALUES ('ID547842433983971328', 'book', 'ID540846505183936512', null, '1', null, '1', '547840691636535296', '2019-02-20 18:10:14');
INSERT INTO `discuss` VALUES ('ID549630091831803904', 'book', 'ID540846505183936512', null, '  厉害', null, '1', '537581987150430208', '2019-02-25 16:33:45');
INSERT INTO `discuss` VALUES ('ID557939523359604736', 'reply', 'ID540846505183936512', 'ID547842433983971328', '11', null, '1', '516919611287928832', '2019-03-20 14:52:28');
INSERT INTO `discuss` VALUES ('ID562369795266183168', 'book', 'ID542288738995142656', null, '不错，既有甲骨文的讲解，又有人生哲理的启示。除了对本字的解释，还有字根的延伸。', null, '1', '562367609350127616', '2019-04-01 20:16:47');
INSERT INTO `discuss` VALUES ('ID562397795282059264', 'book', 'ID540846505183936512', null, '小米宝宝加', null, '0', '537727200229588992', '2019-04-01 22:08:03');
INSERT INTO `discuss` VALUES ('ID562400194503639040', 'book', 'ID540846505183936512', null, '米宝宝加油加油！', null, '1', '537727200229588992', '2019-04-01 22:17:35');
INSERT INTO `discuss` VALUES ('ID568542375874396160', 'reply', 'ID540846505183936512', 'ID562400194503639040', '谢谢鼓励', null, '1', '537581987150430208', '2019-04-18 21:04:25');

-- ----------------------------
-- Table structure for `expert`
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `user_id` varchar(30) DEFAULT NULL COMMENT '专家自己id，以后专家登录使用（暂时用不上）',
  `name` varchar(30) DEFAULT NULL COMMENT '专家名称',
  `intro` text COMMENT '专家描述',
  `image` varchar(200) DEFAULT NULL COMMENT '专家头像',
  `title` varchar(200) DEFAULT NULL COMMENT '专家头衔',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='专家';

-- ----------------------------
-- Records of expert
-- ----------------------------

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `content` text COMMENT '意见',
  `create_id` varchar(30) NOT NULL COMMENT '用户（当前登录的用户信息）',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='意见反馈';

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('ID527489639968145408', 'FASDASD', '516919611287928832', '2018-12-26 14:15:30');
INSERT INTO `feedback` VALUES ('ID527489646624505856', 'FASDASD', '516919611287928832', '2018-12-26 14:15:32');
INSERT INTO `feedback` VALUES ('ID527489650361630720', 'FASDASD', '516919611287928832', '2018-12-26 14:15:32');
INSERT INTO `feedback` VALUES ('ID527492818113921024', 'sdada', '516919611287928832', '2018-12-26 14:28:08');
INSERT INTO `feedback` VALUES ('ID527493779381288960', 'sadaa', '516919611287928832', '2018-12-26 14:31:57');
INSERT INTO `feedback` VALUES ('ID527495456725401600', 'sadsada', '516919611287928832', '2018-12-26 14:38:37');
INSERT INTO `feedback` VALUES ('ID527497356728336384', 'gds', '516919611287928832', '2018-12-26 14:46:10');
INSERT INTO `feedback` VALUES ('ID527497702204768256', 'sfsdf', '516919611287928832', '2018-12-26 14:47:32');
INSERT INTO `feedback` VALUES ('ID527498084809179136', 'asdsadasd', '516919611287928832', '2018-12-26 14:49:03');
INSERT INTO `feedback` VALUES ('ID527498317920206848', 'sfsdfa', '516919611287928832', '2018-12-26 14:49:59');
INSERT INTO `feedback` VALUES ('ID527498498883452928', 'SFDFSDFS', '516919611287928832', '2018-12-26 14:50:42');
INSERT INTO `feedback` VALUES ('ID527498668559826944', 'vada', '516919611287928832', '2018-12-26 14:51:23');
INSERT INTO `feedback` VALUES ('ID527500394725638144', 'asfsaf', '516919611287928832', '2018-12-26 14:58:14');
INSERT INTO `feedback` VALUES ('ID527500599042768896', 'asfasf', '516919611287928832', '2018-12-26 14:59:03');
INSERT INTO `feedback` VALUES ('ID527500804479778816', 'sadsada', '516919611287928832', '2018-12-26 14:59:52');
INSERT INTO `feedback` VALUES ('ID527501434606845952', 'fsafasfsadas', '516919611287928832', '2018-12-26 15:02:22');
INSERT INTO `feedback` VALUES ('ID527501963655380992', 'sadsada', '516919611287928832', '2018-12-26 15:04:28');
INSERT INTO `feedback` VALUES ('ID527501982756241408', 'sadsada', '516919611287928832', '2018-12-26 15:04:33');
INSERT INTO `feedback` VALUES ('ID527504166210240512', '不喝酒', '516919611287928832', '2018-12-26 15:13:13');
INSERT INTO `feedback` VALUES ('ID527504651780620288', '不吃打扮打扮', '516919611287928832', '2018-12-26 15:15:09');
INSERT INTO `feedback` VALUES ('ID527505225695625216', 'sfsdsds', '516919611287928832', '2018-12-26 15:17:26');
INSERT INTO `feedback` VALUES ('ID527505405115367424', 'asdasfasfsaa', '516919611287928832', '2018-12-26 15:18:09');
INSERT INTO `feedback` VALUES ('ID527505557003698176', '阿萨德撒发', '516919611287928832', '2018-12-26 15:18:45');
INSERT INTO `feedback` VALUES ('ID527507065019564032', 'fdsdsfsd', '516919611287928832', '2018-12-26 15:24:44');
INSERT INTO `feedback` VALUES ('ID527507328472186880', 'sfsfv', '516919611287928832', '2018-12-26 15:25:47');
INSERT INTO `feedback` VALUES ('ID527507574149349376', 'sfafa', '516919611287928832', '2018-12-26 15:26:46');
INSERT INTO `feedback` VALUES ('ID527508524171788288', 'dsffs', '516919611287928832', '2018-12-26 15:30:32');
INSERT INTO `feedback` VALUES ('ID527509560118738944', 'sfdsfsdgs', '516919611287928832', '2018-12-26 15:34:39');
INSERT INTO `feedback` VALUES ('ID527509960582496256', 'rgerge', '516919611287928832', '2018-12-26 15:36:15');
INSERT INTO `feedback` VALUES ('ID527511049558032384', 'sfsssef', '516919611287928832', '2018-12-26 15:40:34');
INSERT INTO `feedback` VALUES ('ID527511305574154240', 'hrherher', '516919611287928832', '2018-12-26 15:41:35');
INSERT INTO `feedback` VALUES ('ID527511642661978112', '热身ebreb', '516919611287928832', '2018-12-26 15:42:56');
INSERT INTO `feedback` VALUES ('ID527512508299214848', 'vwerwrvwv', '516919611287928832', '2018-12-26 15:46:22');
INSERT INTO `feedback` VALUES ('ID527513069639696384', 'sfsdfs', '516919611287928832', '2018-12-26 15:48:36');
INSERT INTO `feedback` VALUES ('ID527513216897515520', '合法吉安市撒厚道', '516919611287928832', '2018-12-26 15:49:11');
INSERT INTO `feedback` VALUES ('ID527517086751129600', 'cavaa', '516919611287928832', '2018-12-26 16:04:34');
INSERT INTO `feedback` VALUES ('ID527517425281794048', 'safaa', '516919611287928832', '2018-12-26 16:05:54');
INSERT INTO `feedback` VALUES ('ID527534177147420672', '测试', '517349219414048768', '2018-12-26 17:12:28');
INSERT INTO `feedback` VALUES ('ID527575718238879744', 'vsdvdsvs', '516919611287928832', '2018-12-26 19:57:33');
INSERT INTO `feedback` VALUES ('ID527575981502758912', '还可以', '516919611287928832', '2018-12-26 19:58:35');
INSERT INTO `feedback` VALUES ('ID527585044877803520', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045343371264', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045389508608', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045460811776', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045532114944', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045607612416', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585045716664320', '哈哈哈', '517713552572678144', '2018-12-26 20:34:36');
INSERT INTO `feedback` VALUES ('ID527585116793339904', '1', '517713552572678144', '2018-12-26 20:34:53');
INSERT INTO `feedback` VALUES ('ID527585176872550400', '聂宁哦吼吼', '517713552572678144', '2018-12-26 20:35:08');
INSERT INTO `feedback` VALUES ('ID528504835390046208', '太帅老！', '528504526999650304', '2018-12-29 09:29:31');
INSERT INTO `feedback` VALUES ('ID528586083684843520', '挂电话大包小包', '516919611287928832', '2018-12-29 14:52:22');
INSERT INTO `feedback` VALUES ('ID545644118823403520', '得到', '517366532112646144', '2019-02-14 16:34:55');
INSERT INTO `feedback` VALUES ('ID564869312779649024', '快点出新功能', '517713552572678144', '2019-04-08 17:48:58');
INSERT INTO `feedback` VALUES ('ID564869315275259904', '快点出新功能', '517713552572678144', '2019-04-08 17:48:59');

-- ----------------------------
-- Table structure for `information`
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `author` varchar(10) DEFAULT NULL COMMENT '作者',
  `content` text COMMENT '内容',
  `url` varchar(500) DEFAULT NULL COMMENT '公众号文章地址',
  `cover` varchar(200) DEFAULT NULL COMMENT '封面',
  `read_num` bigint(11) DEFAULT '0' COMMENT '阅读数量',
  `like_num` bigint(11) DEFAULT '0' COMMENT '点赞数量',
  `publish_status` varchar(6) DEFAULT NULL COMMENT '0 未发布，1已发布',
  `status` varchar(6) DEFAULT NULL COMMENT '0 删除，1正常',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资讯模块';

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('ID519100605982048256', '好师傅回到家撒谎的空间爱好擦擦吧BCABC祭敖包', '够够够', '<p>撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦撒的撒爱上大撒擦拭擦上擦拭擦</p>', 'https://mp.weixin.qq.com/s/PgF6KbKvuZKNwmxLM_RncQ', 'http://img.jssns.cn/SHILU/1/bbd77e828d52a830f9186131b8a8b510.jpg', '1', '0', '1', '0', '2453453', '1212', '168', '2018-12-19 14:57:45');
INSERT INTO `information` VALUES ('ID519109899150426112', '大师傅', '够够够', '<p>vascascsacsasada</p>', 'https://mp.weixin.qq.com/s/PgF6KbKvuZKNwmxLM_RncQ', 'http://img.jssns.cn/SHILU/1/b9e31094ef25b321c4fd3c9aa57d2e20.jpg', '1', '0', '1', '0', '115616', '1232', '168', '2018-12-19 14:57:48');
INSERT INTO `information` VALUES ('ID519604878759165952', 'lol', 'rookie', '<p>我们是冠军</p>', 'https://mp.weixin.qq.com/s/PgF6KbKvuZKNwmxLM_RncQ', 'http://img.jssns.cn/SHILU/1/6524d67b50c26be976bba8abb2dd2626.jpg', '1', '0', '1', '0', '785665', '1545', '168', '2018-12-19 14:57:50');
INSERT INTO `information` VALUES ('ID524960787945488384', null, null, null, '123123', '', null, null, null, '0', '432228697144033280', '2018-12-19 14:46:45', '432228697144033280', '2018-12-19 14:49:08');
INSERT INTO `information` VALUES ('ID524963933627351040', '替孩子存下吧，很难找全的文学常识！老师家长也不一定都懂！', null, null, 'https://mp.weixin.qq.com/s/JoJnTmZEcFYxKwRcbuH1KA', 'http://img.jssns.cn/SHILU/1/185a1af61ff6e99ede3c7de1d31b91ef.jpg', null, null, null, '0', '168', '2018-12-19 14:59:15', '168', '2018-12-19 15:05:33');
INSERT INTO `information` VALUES ('ID524963934088724480', '替孩子存下吧，很难找全的文学常识！老师家长也不一定都懂！', null, null, 'https://mp.weixin.qq.com/s/JoJnTmZEcFYxKwRcbuH1KA', 'http://img.jssns.cn/SHILU/1/185a1af61ff6e99ede3c7de1d31b91ef.jpg', null, null, null, '0', '168', '2018-12-19 14:59:15', '168', '2018-12-19 14:59:55');
INSERT INTO `information` VALUES ('ID524965103498428416', '没有海量阅读支撑，只会饿死天赋，制造短命高分', '', '<p>6-12岁，是阅读能力（即学习能力的基础）长足发展的最黄金时期。这六年，可以说什么都没有提高阅读能力重要。有海量阅读支撑的孩子们成绩上升力量强大、后发制人、潜力无穷。中高考已经证明：语文才是拉分王，得语文者得天下，语文更是学霸之间拉分的利器！</p>', 'https://mp.weixin.qq.com/s/2zBF6PVdUgADr5g8Dgtqxg', 'http://img.jssns.cn/SHILU/1/1f5164847512ba47d6db9c907dc59cf2.jpg', '0', '0', '', '1', '168', '2018-12-19 15:03:54', '168', '2019-01-25 10:10:24');
INSERT INTO `information` VALUES ('ID524966507659132928', '小学高年级阅读痛点全攻略', '', '<p class=\"ql-align-justify\">当孩子可以读懂长篇小说里的喜乐哀愁，代表孩子生活比较从容，可以在漫长的小说旅程中，随着主角的经历思考更深层次的情绪和人生际遇。希望以此篇，献给许多不知道如何提升孩子长篇阅读能力的家长老师，让阅读更进一步！</p><p><br></p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247487059&idx=1&sn=d6d48ba355dda9b0890f9c963cb7a68b&chksm=ec13e5addb646cbb9557baefb0f49a7e68bee1faa4d4bda8f7be22fde7dd1956bf032e91ca0e&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/be5c76392f1f1114c7a8ed03cfcfadef.jpg', '0', '0', '', '1', '168', '2018-12-19 15:09:28', '168', '2019-01-25 10:36:47');
INSERT INTO `information` VALUES ('ID524967205822005248', '初二女儿收到情书，妈妈只说了五句话', '', '<p>如果你收到了情书，你要分析一下自己的魅力是什么？品德好、学习好、气质好、脾气好、形象好、身材好……</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247487059&idx=4&sn=469cf50f6406ab9c53b53bfec35b930c&chksm=ec13e5addb646cbb59785071742e8303078d6463c0ecc0bd134d2439438e43a7b288d364f4b3&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/dbb8d1a06e478e7c461b5766a07553ef.jpg', '0', '0', '', '1', '168', '2018-12-19 15:12:15', '168', '2019-01-26 09:48:24');
INSERT INTO `information` VALUES ('ID524967738238566400', '孩子一回家你就让他去写作业？', '', '<p class=\"ql-align-justify\">“与时间赛跑”是最大的教育陷阱，童年不应是一场赛跑，而是一场那旅行，爱对了，就什么都对了。请全天下的父母记住一句话：“孩子不怕累，不怕苦，怕的是不被理解，不被真爱！”</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247487030&idx=3&sn=37c9d67e3fe16a3c3859ce8118841e29&chksm=ec13e5c8db646cde69f02be83740f27b386433e386997bad9e7e41faab7cd2d1b04dea24c177&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/7d88c85ce5ee5c04cb0ae1dc6c114cb5.jpg', '0', '0', '', '1', '168', '2018-12-19 15:14:22', '168', '2019-01-26 09:49:15');
INSERT INTO `information` VALUES ('ID524969383236206592', '全国68个高考状元，家庭教育惊人相似！', '', '<p><span style=\"color: rgb(51, 51, 51);\">状元们都这样形容自己的父母——“宽松、信任、像朋友一样。”</span></p>', 'https://mp.weixin.qq.com/s/e8qVxP7skksHEyntyWGv4A', 'http://img.jssns.cn/SHILU/1/0b66ea803f1096f06239dcfd32cbd638.jpg', '0', '0', '', '0', '168', '2018-12-19 15:20:54', '168', '2018-12-19 15:50:27');
INSERT INTO `information` VALUES ('ID524970126366212096', '小学生除了学习，还有哪些更重要的事呢？', '', '<p>小学，是孩子成长中一个承前启后的关键阶段，而在孩子6-12岁这段成长的时光里，除了学习，还有哪些更重要的事儿呢？</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486716&idx=1&sn=4fec56687fe3d56cb06601f28e7d4472&chksm=ec13e702db646e147d822c8e96fd8ff21f410f79cb98785413da794e24b361085f6c2c8536b3&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/74d0118c61e530ce0b26fe5397e50801.jpg', '0', '0', '', '1', '168', '2018-12-19 15:23:51', '168', '2019-01-26 09:49:42');
INSERT INTO `information` VALUES ('ID524970563798564864', '哈佛大学推荐的20个快乐习惯，您值得拥有！', '', '<p>让自己变慢脚步，看看你的四周，关注生活中的细微之处：人行道上淡紫色的花，美丽的日落，洗去你一天疲惫的淋浴，伴侣眼中的笑容。当你的感恩之心能够欣赏生活的美，思考和祝福，你自然就充满了幸福感。</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486704&idx=1&sn=ab3c7bff5b6588207defdce777984830&chksm=ec13e70edb646e184a34f180b7834026e0847c8e1b5f53bf5c60f3e91ed2ea6ba0c955ccb9f9&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/3888597d305f36e1615bc268953df915.jpg', '0', '0', '', '1', '168', '2018-12-19 15:25:35', '168', '2019-01-26 09:59:40');
INSERT INTO `information` VALUES ('ID524971649510932480', '胡适：好的关系，都是“麻烦”出来的。', '', '<p class=\"ql-align-justify\">好的关系，是可以相互“麻烦”的，大家彼此温暖，相互帮助，这样才能使关系更加亲密。只要不是太过分的要求，都可以放心的“麻烦”朋友。最怕的就是：你不说，我不问。很多关系就这样慢慢变得生疏，直到再也无法亲近了。</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486704&idx=2&sn=afc579a21b28442af8c98d49d8ff4ef1&chksm=ec13e70edb646e1816e8b27f704d78db6eb6e2c142f690f05a4d9583eaf93a87ac222bd44794&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/aa773fb8b1de89bead3e470cc34f2491.jpg', '0', '0', '', '1', '168', '2018-12-19 15:29:54', '168', '2019-01-26 09:50:21');
INSERT INTO `information` VALUES ('ID524974362399342592', '中国教育最可悲的是：家长舍不得管，老师不敢管，外人不方便管！', '', '<p class=\"ql-align-justify\">没有哪个孩子生下来就是是非分明的好孩子，也没有哪个孩子生下来就是人见人厌的熊孩子……重要的是，家长到底要如何去教育。好好的风筝，放的时候不认真，放飞的时候自有人替你剪断它；好好的孩子，你不教育他，日后自有人替你教育。严父出孝子，慈母多败儿。如果孩子被溺爱到碰不得、摸不得，那孩子迟早会闯出泼天大祸。</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486386&idx=1&sn=bbad053f0a0bfab2cfc7bae69af99c4c&chksm=ec13e04cdb64695ae6b4f422b4b9ad03dd0a26512c316ed5517e55f2c5a16c6c3250003313d0&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/8d0655a8092183376de24b730cb8f718.jpg', '0', '0', '', '1', '168', '2018-12-19 15:40:41', '168', '2019-01-26 09:51:00');
INSERT INTO `information` VALUES ('ID524974930857558016', '孩子什么年龄上什么培训班？', '', '<p>很多家长都希望自己家的小孩子多才多艺，倒不是希望孩子成为多厉害的人，而是希望他们有一定的艺术修养。什么年龄适合上什么培训班？这是很多家长疑惑的问题。这篇综合专家意见的文章，分享给大家，提供一点参考。</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486303&idx=1&sn=8a1c3e999a97e30e7b90ef07fe728717&chksm=ec13e0a1db6469b78b9acd2014d18443a6aef532d1bbcb65c32d3453fe609d5d6a297318799c&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/c44094c47f2bcce9228739d730ebb9b0.jpg', '0', '0', '', '1', '168', '2018-12-19 15:42:57', '168', '2019-01-25 14:17:22');
INSERT INTO `information` VALUES ('ID524977608564146176', '这4种情况，父母千万别让孩子善良！', '', '<p>我们从小教导孩子要善良，但是在复杂的今天，又有多少孩子甚至大人，被善良害死了？难道要从小教孩子不善良？这也违背我们做人的原则！那么请你至少告诉孩子，在这四种情况下，要收起自己的善良！</p>', 'https://mp.weixin.qq.com/s?__biz=MzI5MTMwNzE1Mw==&mid=2247486286&idx=3&sn=5e42ede50f721f7cf26571dea3d6e619&chksm=ec13e0b0db6469a69ab5eff683df00fa9f32c4baf972e2a3cb7c2d74613d6e1013f92ac85b7a&token=511203242&lang=zh_CN#rd', 'http://img.jssns.cn/SHILU/1/a8b90ed559615c67eb9761c9805b9f83.jpg', '0', '0', '', '1', '168', '2018-12-19 15:53:35', '168', '2019-01-26 09:51:18');
INSERT INTO `information` VALUES ('ID525606439943667712', '很难找全的文学常识！替孩子存下吧！', '', '<p>语文要学好，积累少不了。小智整理了这些文学常识送给孩子，老师、家长快为孩子收藏吧！</p>', 'https://mp.weixin.qq.com/s/uW5KKPqqPzE-77F-zoc-Eg', 'http://img.jssns.cn/SHILU/1/d285e9669ae6a2d967779090d9a86008.jpg', '0', '0', '', '1', '168', '2018-12-21 09:32:20', '168', '2019-01-26 09:51:56');
INSERT INTO `information` VALUES ('ID525637192593178624', '替孩子存下吧，很难找全的文学常识！', null, null, 'https://mp.weixin.qq.com/s/uW5KKPqqPzE-77F-zoc-Eg', '', null, null, null, '0', '168', '2018-12-21 11:34:32', '168', '2018-12-21 11:43:26');
INSERT INTO `information` VALUES ('ID525639373048250368', '替孩子存下吧，很难找全的文学常识！', null, '<p><span style=\"color: rgb(25, 25, 25);\">语文要学好，积累少不了。今天小智君整理了这些文学常识送给孩子，老师、家长快为孩子收藏吧！</span></p>', 'https://mp.weixin.qq.com/s/uW5KKPqqPzE-77F-zoc-Eg', 'http://img.jssns.cn/SHILU/1/285a7328a8dac4b923cdca16c3894060.jpg', null, null, null, '0', '168', '2018-12-21 11:43:12', '168', '2018-12-21 11:43:44');
INSERT INTO `information` VALUES ('ID525641099935481856', 'BBC跟拍14个孩子56年，揭露出了教育真相！', '', '<p>并不是说在中国突破阶层变得困难了，而应该说，想要依靠传统方法突破阶层变得困难了。因此，如果你想要突破阶层，就需要升级自己的思维方式，学会从更多元的看待问题视角，让自己具有创新能力。用万维钢老师的话说，你需要变得复杂。</p>', 'https://mp.weixin.qq.com/s/RVtBKDaHiYsEjQbMJv10lQ', 'http://img.jssns.cn/SHILU/1/60e448a68836f31283907794d779c3ac.jpg', '0', '0', '', '1', '168', '2018-12-21 11:50:04', '168', '2019-01-26 09:52:20');
INSERT INTO `information` VALUES ('ID525642043955871744', '美貌往往比文化修养更重要', '', '<p>这是一个注重颜值的时代。“好看的皮囊千篇一律，有趣的灵魂两百多斤”，这更多是肥胖者的自我安慰。如果有重新选择的机会，他们会选好看却又千篇一律的皮囊还是两百多斤的有趣灵魂呢？实际上，这个世界从来不是非此即彼的二分世界，为何不去选择好看又有趣的灵魂呢？</p>', 'https://mp.weixin.qq.com/s/5ReXMMjB-mGJK4I26EIjtA', 'http://img.jssns.cn/SHILU/1/0fa23da7b66d123533ef564466de484d.jpg', '0', '0', '', '1', '168', '2018-12-21 11:53:49', '168', '2019-01-26 09:52:51');
INSERT INTO `information` VALUES ('ID527067444838137856', '【答题抽奖】圣诞福利来喽！', null, '<p class=\"ql-align-justify\">足够聪明的你还不赶紧来挑战下<strong>“圣诞节冷知识挑战赛”</strong>！</p><p class=\"ql-align-justify\">只要得到70分就可以参与抽奖，中奖率高达68%！</p><p><br></p>', 'https://mp.weixin.qq.com/s/XXb1OLl176K-sUi18EJLTw', 'http://img.jssns.cn/SHILU/1/590525ccba5919fa52f38c494d461477.jpg', null, null, null, '1', '168', '2018-12-25 10:17:51', '168', '2018-12-25 10:17:51');
INSERT INTO `information` VALUES ('ID527068402573901824', '研学宝', null, null, 'https://mp.weixin.qq.com/s/PNerW7QvJaoLD1MRbmTohQ', '', null, null, null, '0', '168', '2018-12-25 10:21:39', '168', '2018-12-25 10:23:55');
INSERT INTO `information` VALUES ('ID528523190591291392', '当心！毒品就在你孩子身边', '', '<p>随着近几年广泛的禁毒宣传，那些主流毒品，基本被大家所熟知，如海洛因、冰毒、麻古、摇头丸等。如今，毒品又穿上了华丽的外衣，被重新包装，伪装成儿童食品的样子来逃避检查，更可怕的是这些“新型毒品”还吸引到了到了不少未成年人的购买。</p>', 'https://mp.weixin.qq.com/s/4aPjvd6Byc1GLQjpBYZDgw', 'http://img.jssns.cn/SHILU/1/6140ae8706d6bd0723d067c43d0f03fe.jpg', '0', '0', '', '1', '168', '2018-12-29 10:42:26', '168', '2019-01-26 09:54:00');
INSERT INTO `information` VALUES ('ID528523933176037376', '孩子帮忙做家务，并不想被奖赏——来自一位儿童心理学家的警告', '', '<p>“受到悉心照顾”和“娇生惯养毫无做事能力”是有差别的。其实，如果父母处理得当，适当的劳动，会让孩子紧张的大脑得到调剂，做做家务出出汗，身体得到锻炼，对孩子来说是利大于弊的。</p>', 'https://mp.weixin.qq.com/s/cUMtf0amdQtefDEmDU_Y-Q', 'http://img.jssns.cn/SHILU/1/81883b62b42105b75ddbac075422e56a.jpg', '0', '0', '', '1', '168', '2018-12-29 10:45:25', '168', '2019-01-26 09:54:26');
INSERT INTO `information` VALUES ('ID530685580434997248', '“为什么我不能玩抖音”，这位妈妈的回答霸气极了！', '', '<p class=\"ql-align-justify\">在这个信息化爆炸，娱乐新宠频繁更换的年代，抖音以不超过15秒的音乐创意短视频，稳稳的坐上了“江山易改，抖音仍在”的宝座。然而，在给人们的生活带来无限娱乐的同时，抖音的一些负能量和恶趣味也在悄无声息地毒害着我们的孩子，刺激着他们感官，危害着他们的身体，扭曲着他们的价值观。</p>', 'https://mp.weixin.qq.com/s/lC34WZ7i_2XaTIS0ra7K2A', 'http://img.jssns.cn/SHILU/1/575ca41dfa70ca7b0e4922b3cba28b02.jpg', '0', '0', '', '1', '168', '2019-01-04 09:55:02', '168', '2019-01-26 09:54:55');
INSERT INTO `information` VALUES ('ID530685908442152960', '董卿在《中国诗词大会3》1-10期的开场白完整版，教科书般的作文素材！', '', '<p>中国是一个爱诗的国度，中国人是一个爱诗的民族。我们从祖先三千多年前留下来的《诗经》里，依然可以找到今天我们所渴望的生活的样子。这世世代代相传的精神财富，早已融入了我们的血脉里，塑造着我们的容貌，淬炼着我们的思想，让我们继续去追寻这些民族的文化基因，去拥抱那最美的诗和远方。</p>', 'https://mp.weixin.qq.com/s/1SbneA7UEy9XpDHWcFbPqQ', 'http://img.jssns.cn/SHILU/1/b70690aa2cff0a62653f5a24d0faba74.jpg', '0', '0', '', '1', '168', '2019-01-04 09:56:20', '168', '2019-01-26 09:55:30');
INSERT INTO `information` VALUES ('ID530686243135029248', '成绩第一名和倒数的孩子，差距真的不在老师，在于.......', '', '<p>同样的老师，同样的学习方式，为什么有些孩子是第一名，有些孩子的成绩却让人挠心挠肺???</p>', 'https://mp.weixin.qq.com/s/5MatBPbPXmInpnMRjMuQdA', 'http://img.jssns.cn/SHILU/1/ef1d33cb57ad8391265fc29ccabe696d.jpg', '0', '0', '', '1', '168', '2019-01-04 09:57:40', '168', '2019-01-04 10:08:55');
INSERT INTO `information` VALUES ('ID534417993141059584', '小学的重点不在成绩，在于阅读！', '', '<p>小学阶段是培养良好阅读习惯和阅读能力的黄金塑造期，如果此时父母过于强调成绩，极有可能会扼杀孩子的兴趣、天赋和创造力。</p>', 'https://mp.weixin.qq.com/s/p31SdN3xr5DJTByz6X30iA', 'http://img.jssns.cn/SHILU/1/fbde52604f908919f2ba8fa28b631884.jpg', '0', '0', '', '1', '168', '2019-01-14 17:06:18', '168', '2019-01-26 09:56:02');
INSERT INTO `information` VALUES ('ID534418698010624000', '最失败的家庭教育，是有一个包办一切的妈，加上一个啥都不管的爹！', '', '<p>教育孩子不是帮他做事，不是给他挣钱，而是陪伴他成长，让他的人生步入正轨。而在这个过程中，我们不能越俎代庖，也不能袖手旁观，不做包办一切的妈，也不做啥都不管的爹。否则，可能我们看似很努力，其实是在帮孩子倒忙。</p>', 'https://mp.weixin.qq.com/s/yIyyERG5_Ij6XWsXS3L3cw', 'http://img.jssns.cn/SHILU/1/f9c71f9f8d6b6b023d2edf1bcbe62d36.jpg', '0', '0', '', '1', '168', '2019-01-14 17:09:06', '168', '2019-01-26 09:56:45');
INSERT INTO `information` VALUES ('ID534421457485168640', '如何和孩子谈论“北京宣师附小伤人事件”？', '', '<p class=\"ql-align-justify\">校园伤害学生的恶性案件频频发生，每每面对类此恶性事件，作为父母的我们，另一种心情也是极其复杂的——从米脂杀人事件，到上海世外的砍人案，再到辽宁葫芦岛市建昌县的学校门口冲撞学生事件，如果孩子好奇地问起来，我们要不要，以及应该如何和Ta谈论这些事？</p>', 'https://mp.weixin.qq.com/s/vkv5j-X2r074P9Y1Q9TxYw', 'http://img.jssns.cn/SHILU/1/8a1c58a4637d719563ebac6f7a9f8fd8.jpg', '0', '0', '', '1', '168', '2019-01-14 17:20:04', '168', '2019-01-26 09:57:05');
INSERT INTO `information` VALUES ('ID536933661522526208', '让孩子爱上学习的100种方法，写的真细！', '', '<p>不管时代如何变化，我们都要相信读书能改变命运，要相信阅读的力量。特别是对于普通家庭，在学习资源落后的情况下，阅读反而是获取知识比较公平的一个途径。你一定要相信并且鼓励孩子，因为父母的眼光和格局，就是孩子站的高度。</p>', 'https://mp.weixin.qq.com/s/pKSWgGYAE3Y69aNXS2C2Gw', 'http://img.jssns.cn/SHILU/1/d52d664a9e5301773f3b2afe0805e5ee.jpg', '0', '0', '', '1', '168', '2019-01-21 15:42:39', '168', '2019-01-26 09:57:26');
INSERT INTO `information` VALUES ('ID536943250125094912', '寒假必修课：1~12年级必背208篇古诗文,全在这里，收下它让寒假更充实！', '', '<p>俗话说“熟读唐诗三百首，不会作诗也会吟”！寒假即将到来，快快转发起来，拒绝孩子玩手机、玩游戏、看无营养的电视剧，让孩子们在诗词歌赋中度过一个有意义的寒假吧！</p>', 'https://mp.weixin.qq.com/s/XIOCkrZWTzmZ7gRPMUu7vw', 'http://img.jssns.cn/SHILU/1/53ac543c4a25d83005fa9b41bf7a22bd.jpg', '0', '0', '', '1', '168', '2019-01-21 16:20:46', '168', '2019-01-26 09:57:49');
INSERT INTO `information` VALUES ('ID539467127493492736', '阶层终将固化，我们该怎样教育孩子？', null, '<p>我们所能做的，就是努力发展自己，提高收入，成为一个更好的人，在能力范围内，给下一代更多的关注和更好的教育，更为他们树立努力的榜样。&nbsp;希望当孩子长大，直面生活的残酷时，他能够在心里告诉自己，谢谢爸爸妈妈，我终于成为了一个斗士！</p>', 'https://mp.weixin.qq.com/s/QhD4PoPIY4Qsycgw8lj2Kg', 'http://img.jssns.cn/SHILU/1/17078cbd40dc75c089e5ecd1f7c73aaa.jpg', null, null, null, '1', '168', '2019-01-28 15:29:46', '168', '2019-01-28 15:29:46');
INSERT INTO `information` VALUES ('ID539468423134969856', '寒假是孩子养成好习惯的最佳时机，这些建议太实用了！', null, '<p>好的习惯陪伴孩子一生，终生受益，有条不紊的生活习惯，提高生活品质，培养孩子自律的态度，何乐而不为？</p>', 'https://mp.weixin.qq.com/s/h-JUkDTSPwP7lDprAQj4eQ', 'http://img.jssns.cn/SHILU/1/d3409f1527ed9778fa5546e3170bd821.jpg', null, null, null, '1', '168', '2019-01-28 15:34:54', '168', '2019-01-28 15:34:54');
INSERT INTO `information` VALUES ('ID539472195034808320', '1-6年级学生的寒假超级阅读大餐（72本童书+72部电影）', null, '<p>如果你正在纠结你的孩子不爱阅读，那么这份书单是最适合的。看完电影再翻开书本，或者读完书再看电影，相信你的孩子一定会在这个寒假爱上阅读！</p>', 'https://mp.weixin.qq.com/s/iT2w1e6Dp7uD8K8Jkeu8OA', 'http://img.jssns.cn/SHILU/1/494cf5d5290bd02ae4edaa50cdb98b7e.jpg', null, null, null, '0', '168', '2019-01-28 15:49:54', '168', '2019-01-31 18:44:39');
INSERT INTO `information` VALUES ('ID540847704889098240', '1-6年级学生的寒假超级阅读大餐（72本童书+72部电影）', null, '<p><span style=\"background-color: rgb(255, 255, 255); color: rgb(81, 90, 110);\">如果你正在纠结你的孩子不爱阅读，那么这份书单是最适合的。看完电影再翻开书本，或者读完书再看电影，相信你的孩子一定会在这个寒假爱上阅读！</span></p>', 'https://mp.weixin.qq.com/s/iT2w1e6Dp7uD8K8Jkeu8OA', 'http://img.jssns.cn/SHILU/1/494cf5d5290bd02ae4edaa50cdb98b7e.jpg', null, null, null, '0', '168', '2019-02-01 10:55:41', '168', '2019-02-01 10:56:59');
INSERT INTO `information` VALUES ('ID544805581383270400', '1-6年级学生的寒假超级阅读大餐（72本童书+72部电影）', '', '<p>如果你正在纠结你的孩子不爱阅读，那么这份书单是最适合的。看完电影再翻开书本，或者读完书再看电影，相信你的孩子一定会在这个寒假爱上阅读！</p>', 'https://mp.weixin.qq.com/s/iT2w1e6Dp7uD8K8Jkeu8OA', 'http://img.jssns.cn/SHILU/1/494cf5d5290bd02ae4edaa50cdb98b7e.jpg', '100', null, null, '1', '168', '2019-02-12 09:02:52', '168', '2019-02-12 09:02:52');
INSERT INTO `information` VALUES ('ID546989826109341696', '寒假余额不足，如何让孩子收心？', '', '<p>开学前，家长们是否因为不知该为孩子做什么而感到焦虑呢？以下10项准备工作是北京师范大学教授边玉芳结合孩子的心理发展特点以及学习适应规律梳理总结出的，可供广大家长参考。</p>', 'https://mp.weixin.qq.com/s/jjRFjidfZapQujU4T4_t4A', 'http://img.jssns.cn/SHILU/1/6728d018c6ff532688fa5b9e2d83ddf7.jpg', null, null, null, '1', '168', '2019-02-18 09:42:17', '168', '2019-02-18 09:42:17');
INSERT INTO `information` VALUES ('ID546990855299268608', '教育若只靠老师，就太耽误孩子了！这11点真相，残酷而现实！', '', '<p>很多家长以为把孩子送进学校，对孩子的教育就可以全部仰仗老师了。自己对孩子的生活和学习习惯关注太少，导致不能及时发现孩子成长过程中出现的一些问题，并采取相应的措施。&nbsp;以下这11点，能够充分地说明，如果单靠老师，那就太耽误孩子了。很残酷，却很现实，愿所有的父母都能看到！</p>', 'https://mp.weixin.qq.com/s/zC2aldm8_I2TGxmcTxk-ZQ', 'http://img.jssns.cn/SHILU/1/ba4f3aba0d6c1c710249568a9197c486.jpg', null, null, null, '1', '168', '2019-02-18 09:46:22', '168', '2019-02-18 09:46:22');
INSERT INTO `information` VALUES ('ID546991783351943168', '13岁河南女生“诗词大会”爆火：你的气质里，藏着你走过的路、读过的书！', '', '<p>《中国诗词大会》第四季已经播出了5期，13岁的小学霸邓雅文走红，她不仅连续4期夺得擂主，而且淡定从容的表现也赢得董卿、康震等人的赞赏。节目播出以后，不少网友为邓雅文的表现点赞。</p>', 'https://mp.weixin.qq.com/s/u8ZbYb3McPpQYTNW9sR6Iw', 'http://img.jssns.cn/SHILU/1/3549c35859600023373bba547b365951.jpg', null, null, null, '1', '168', '2019-02-18 09:50:03', '168', '2019-02-18 09:50:03');
INSERT INTO `information` VALUES ('ID546992253319512064', '春晚小品《占位子》直击教育三大痛点：我们何时变得如此焦虑？', '', '<p>今年春晚，要数沈腾这个抢座位的小品最接地气。多少家长，笑着笑着却哭了。这是因为小品击中当下教育三大痛点，引发教育者、家长的广泛共鸣!</p>', 'https://mp.weixin.qq.com/s/KkMwSAMdBY_xiCgEc6pZFA', 'http://img.jssns.cn/SHILU/1/48a628e67c95fe64b0009781d119cbc5.jpg', '0', '0', '', '1', '168', '2019-02-18 09:51:55', '168', '2019-02-18 09:56:12');
INSERT INTO `information` VALUES ('ID549545891535519744', '教育部长说：2019年始，家长也要接受教育！', '', '<p>家庭是人生最重要的场所。&nbsp;家庭，永远是孩子真正诞生与成长的摇篮。&nbsp;将家庭教育纳入公共服务体系，让父母也接受教育，真正为孩子上好人生第一课！</p>', 'https://mp.weixin.qq.com/s/yLj5qXh7BwqgEeOX--Phrg', 'http://img.jssns.cn/SHILU/1/2a3c86ec576a06a7687e666fbd555852.jpg', '0', '0', '', '1', '168', '2019-02-25 10:59:10', '168', '2019-02-25 11:00:25');
INSERT INTO `information` VALUES ('ID549547162363494400', '人最大的教养，就是和颜悦色', '', '<p>俗话说，“脾气人人有，拿出来是本能，压下去才是本事。” 胡适先生也曾说过：“世间最可恶的事，莫如一张生气的脸。” 待人和颜悦色，不仅是一种美德，更是一个人最大的教养。</p>', 'https://mp.weixin.qq.com/s/KYBignP5QAW42pDNsrMDTw', 'http://img.jssns.cn/SHILU/1/5ce8d327ccf90e21f868ef76fb8f1304.jpg', null, null, null, '1', '168', '2019-02-25 11:04:13', '168', '2019-02-25 11:04:13');
INSERT INTO `information` VALUES ('ID549547787188961280', '一个家庭里为什么有这么多矛盾，看了才恍然大悟！', '', '<p>老人无德，一家灾殃；子女不孝，没有福报；男人无志，家道不兴；女人不柔，把财赶走。&nbsp;老人要宣扬家风，父母要示范家风，夫妻要掌舵家风，子女要继承家风，孙辈要顺受家风，兄弟姐妹要竞比家风。&nbsp;有道才有德，无道便无德，有德才有福，无德便无福。</p>', 'https://mp.weixin.qq.com/s/NonUFxtM-KgX0G0aWCzdZw', 'http://img.jssns.cn/SHILU/1/0ba06b7b76340002e74d3b3ed50827be.jpg', '0', '0', '', '1', '168', '2019-02-25 11:06:42', '168', '2019-02-25 11:07:10');
INSERT INTO `information` VALUES ('ID553535651069296640', '100个古汉语词汇，读懂这些，就读懂了诗词', '', '<p>下面100个古语， 不仅美，而且极富韵味， 了解了它们，读懂诗词不再难。 老师们，家长们，转发起来，让更多的孩子读懂诗词！</p>', 'https://mp.weixin.qq.com/s/ivLOk0wGnVJqQsmJBlTKGg', 'http://img.jssns.cn/SHILU/1/87db6178dec2a6e9b64b5c2f8c498bff.jpg', null, null, null, '1', '168', '2019-03-08 11:13:03', '168', '2019-03-08 11:13:03');
INSERT INTO `information` VALUES ('ID553536844055183360', '改掉这10大坏习惯，你的孩子将“无人能敌”！', '', '<p>学习效果不好，不一定是因为不够努力&nbsp;可能是一些坏习惯在作怪！</p>', 'https://mp.weixin.qq.com/s/mVArfArHC397dwX9L8-sfQ', 'http://img.jssns.cn/SHILU/1/a05f8e8bcdfa86f7815e4d585a75c46d.jpg', null, null, null, '1', '168', '2019-03-08 11:17:47', '168', '2019-03-08 11:17:47');
INSERT INTO `information` VALUES ('ID553538287944335360', '人最大的教养，是原谅父母的不完美！', '', '<p>如果有一天，你发现父母爱吃煮得烂烂的菜；&nbsp;如果有一天，你发现父母喜欢吃稀饭；&nbsp;如果有一天，你发现他们过马路行动反应都慢了；&nbsp;如果有一天，你发现老父老母的一些习惯不再是习惯时，就像他们不再想要天天洗澡时；&nbsp;如果有一天，你发现吃饭时间他们老是咳个不停，千万别误以为他们感冒或着凉，（那是吞咽神经老化的现象）；如果有一天，你发觉他们不再爱出门……</p>', 'https://mp.weixin.qq.com/s/LmM4VB1lmMHkM96rvdh2ow', 'http://img.jssns.cn/SHILU/1/7e658c765d30e0f09c6b98f3493eacc9.jpg', null, null, null, '1', '168', '2019-03-08 11:23:32', '168', '2019-03-08 11:23:32');
INSERT INTO `information` VALUES ('ID554687830870196224', '为什么家长们都在讨论《头脑特工队》？', '', '<p>这是一部没有反派的动画，在给孩子看的低龄冒险故事之下，却是成年人更能体会到的源自心理经验的非凡想象。很多时候，我们稀里糊涂就“长大”了，这部动画却让我们真正地“看”到了，长大究竟是怎么一回事。</p>', 'https://mp.weixin.qq.com/s/wum5mb19v3_BTyHybRxyJQ', 'http://img.jssns.cn/SHILU/1/b53c8bc628248e40f4421bedf2c0d756.jpg', null, null, null, '1', '168', '2019-03-11 15:31:24', '168', '2019-03-11 15:31:24');
INSERT INTO `information` VALUES ('ID554689030944456704', '李湘女儿两条手链价值5万：奢侈品，孩子到底该不该碰？这是我见过最好的答案', '', '<p>重点不是我脚上穿什么鞋，而是我有没有自己的想法；&nbsp;重点不在于我穿的鞋子或衣服是哪个牌子，而是我知不知道自己想要的是什么。&nbsp;你迟早会穿不下这些鞋子，所以真正重要的还是你脑中的想法、你累积的智慧以及知识，以及你有没有能力去启发别人。</p>', 'https://mp.weixin.qq.com/s/N0SSK_mJPF5REn5SDnxqog', 'http://img.jssns.cn/SHILU/1/1191d3b33e19d53b3412e6864fdd1f49.jpg', null, null, null, '1', '168', '2019-03-11 15:36:10', '168', '2019-03-11 15:36:10');
INSERT INTO `information` VALUES ('ID554691319730012160', '母亲越强势，对家庭毁灭性越大', '', '<p>很多人知道，母亲对于孩子，对于家庭来说十分重要。俗话说：娶一个好太太富三代！但是，一个过于强势的母亲对于家庭来说却是毁灭性的。为什么呢？</p>', 'https://mp.weixin.qq.com/s/FsIJYgFVn1kQ8fCiLRw5xA', 'http://img.jssns.cn/SHILU/1/cd10fd862f2b6699440caea82cc6cc51.jpg', null, null, null, '1', '168', '2019-03-11 15:45:16', '168', '2019-03-11 15:45:16');
INSERT INTO `information` VALUES ('ID554693304726323200', '当孩子问“妈妈，这个世界为什么会有不公平？”，你的回答很重要', '', '<p>世界并不完美，但仍值得热爱，值得我们去体会那些美好的东西并为之努力。&nbsp;父母自己要做一个乐观上进、充满希望的人，不怨天尤人，不乱发牢骚。&nbsp;正视生活中的不公平，用爱建立孩子的安全感，用智慧建立孩子的是非观，用自己的言传身教建立孩子的积极心态。</p>', 'https://mp.weixin.qq.com/s/fJxD4D-WOgS1Pnko277zVA', 'http://img.jssns.cn/SHILU/1/632c2f9d2042cc279bb57e95c30d6382.jpg', '0', '0', '', '1', '168', '2019-03-11 15:53:09', '168', '2019-03-11 16:36:35');
INSERT INTO `information` VALUES ('ID567310751652380672', '教育最大的骗局，叫做释放孩子的天性', '', '<p>很多父母把“放养”捧上了天，并找到了一条很好的理由：“释放孩子的天性”，他们以为这样的爱很伟大，但其实很廉价，这种廉价的爱，正在一步一步废掉我们的下一代。</p>', '教育最大的骗局，叫做释放孩子的天性', 'http://img.jssns.cn/SHILU/1/d1ebeaeec1e70e1609b148ee56233151.jpg', '0', '0', '', '1', '168', '2019-04-15 11:30:22', '168', '2019-04-15 11:31:47');
INSERT INTO `information` VALUES ('ID567311960333352960', '真正的专注力培养，秘诀恰恰在于“间断式学习”', '', '<p>学习就像做大蛋糕，很多材料要齐备，蛋糕基础稳，才能一层层往上叠。如果不是每天固定学，而是拖到最后一分钟才来学，无法建立稳固的知识基础，形成长期记忆与能力。</p>', 'https://mp.weixin.qq.com/s/HTaHh3fL5Jf750iQFslABw', 'http://img.jssns.cn/SHILU/1/d9d152e229c826f8919f7b074cbf6314.jpg', null, null, null, '1', '168', '2019-04-15 11:35:11', '168', '2019-04-15 11:35:11');
INSERT INTO `information` VALUES ('ID567312898603352064', '假如有一天，我老无所依……（看完我沉默了）', '', '<p>当我们老了，是依靠自己，还是依靠孩子，或者依靠保姆？&nbsp;这是我们每个人都会面临的问题，说到底，养老真的还是要靠自己，靠自己硬朗的身体，靠自己内心的充盈。</p>', 'https://mp.weixin.qq.com/s/qf4eAh0c9HUlYY92sCkvqQ', 'http://img.jssns.cn/SHILU/1/c4c94143b711eadfb5b4c638bf2dafd1.jpg', '0', '0', '', '1', '168', '2019-04-15 11:38:55', '168', '2019-04-15 11:40:50');
INSERT INTO `information` VALUES ('ID567349433365168128', '俞敏洪：先别要求孩子考一个好大学，这4样东西比任何事情都重要！', '', '<p>在座的父母，你对孩子传递情商和逆商，比传递任何东西都要重要，先不要要求孩子考一个好大学，不要让他出国，这些东西真的不重要，重要的是你把情商和逆商这样的本领传递出来。</p>', 'https://mp.weixin.qq.com/s/6RSgT9kbD1zkOA3rr3u01A', 'http://img.jssns.cn/SHILU/1/44e6395c95574db836b714f4001128d9.jpg', null, null, null, '1', '168', '2019-04-15 14:04:05', '168', '2019-04-15 14:04:05');
INSERT INTO `information` VALUES ('ID567350269927489536', '假如有一天，我老无所依……（看完我沉默了）', '', '<p>当我们老了，是依靠自己，还是依靠孩子，或者依靠保姆？&nbsp;这是我们每个人都会面临的问题，说到底，养老真的还是要靠自己，靠自己硬朗的身体，靠自己内心的充盈。</p>', 'https://mp.weixin.qq.com/s/qf4eAh0c9HUlYY92sCkvqQ', 'http://img.jssns.cn/SHILU/1/94957eb613aa3ccc4d57eaf862cc01cc.jpg', null, null, null, '0', '168', '2019-04-15 14:07:25', '168', '2019-04-15 14:07:34');
INSERT INTO `information` VALUES ('ID567351238748798976', '妈妈，求你别再骂我了，哈佛医学博士：语言暴力改变大脑结构，对孩子影响太可怕了！', '', '<p>&nbsp;与孩子进行良好沟通从来不是一件容易的事，毕竟孩子和父母有着多年生活经验的差距。&nbsp;很多在父母看来很容易的事情，对孩子来说却非常困难的。&nbsp;这就需要父母多一些耐心，认真观察孩子的行为，仔细感受孩子的心理，分析其原因，然后对孩子提出具体的要求。</p>', 'https://mp.weixin.qq.com/s/OUc3oUNkBFOKTVl6yXFn_g', 'http://img.jssns.cn/SHILU/1/4c6f8b97025d2975520b809de3f27a0e.jpg', null, null, null, '1', '168', '2019-04-15 14:11:16', '168', '2019-04-15 14:11:16');

-- ----------------------------
-- Table structure for `issue`
-- ----------------------------
DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `content` varchar(500) DEFAULT NULL COMMENT '题目内容',
  `belong_to` varchar(10) DEFAULT NULL COMMENT '属于哪个栏目(album 专辑，book书籍)',
  `belong_to_id` varchar(30) DEFAULT NULL COMMENT '属于哪个栏目ID(专辑或书籍主键)',
  `img1` varchar(200) DEFAULT NULL COMMENT '图片1',
  `img2` varchar(200) DEFAULT NULL COMMENT '图片2',
  `img3` varchar(200) DEFAULT NULL COMMENT '图片3',
  `type` varchar(6) DEFAULT NULL COMMENT '题目类型(single 单选，multi多选)',
  `analysis` varchar(500) DEFAULT NULL COMMENT '题目解析',
  `difficulty` varchar(6) DEFAULT NULL COMMENT '难度系数',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='观看视频回答题目';

-- ----------------------------
-- Records of issue
-- ----------------------------
INSERT INTO `issue` VALUES ('ID532645024467255296', '文中多次写父亲的“踌躇”和“嘱咐”，其目的是什么？', 'book', 'ID532982257195941888', '', '', '', 'single', '“踌躇”和“嘱咐”充分体现出父亲的爱子心切，对儿子的不放心', '3', '1', '168', '2019-01-09 19:41:09', '168', '2019-01-09 19:41:09');
INSERT INTO `issue` VALUES ('ID532645024467255297', '《背影》一文将“勾留南京”一事一笔带过，原因是？', 'book', 'ID532982257195941888', '', '', '', 'single', '与文章的中心思想无联系，故略写', '1', '1', '168', '2019-01-09 19:41:09', '168', '2019-01-09 19:41:09');
INSERT INTO `issue` VALUES ('ID532646814835277824', '“我那时真是聪明过分，总觉得他说话不大漂亮”中“聪明”和“漂亮”的同义词分别是？', 'book', 'ID532982257195941888', '', '', '', 'single', '这里“聪明”的意思都是糊涂，是反语。表明作者悔恨自己当时未能体会父亲的深情。\r\n“不大漂亮”即指说话不太好听，不太动听。', '5', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277825', '下列词语书写有误的一项是（）', 'book', 'ID534321710904639488', null, null, null, 'single', '凄婉', '1', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277826', '下面四项中，诗歌节奏划分错误的一项是（）', 'book', 'ID534321710904639488', null, null, null, 'single', '波光里的/艳影，//在我的心头/荡漾', '2', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277827', '下列解说不正确的一项是（）', 'book', 'ID534321710904639488', null, null, null, 'single', '应为象征派', '4', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277828', '选出解说错误的一项（）', 'book', 'ID534322399064096768', null, null, null, 'single', '“永远记在心上”不对，应是作者对此感到激动陶醉', '1', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277829', '下面是对有关词语的分析，选出错误的一项（）', 'book', 'ID534322399064096768', null, null, null, 'single', '“短暂虚幻”从诗中看不出来', '3', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277830', '下列各句使用的修辞手法与其他三项不同的一项是（）', 'book', 'ID534322399064096768', null, null, null, 'single', 'A项，是拟人的修辞手法，其余均为比喻的修辞手法', '4', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277831', '对诗句品析有误的一项是（）', 'book', 'ID534321710904639488', null, null, null, 'single', '肝肠寸断不准确。', '3', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277832', '下列对《雨巷》赏析不正确的是（）', 'book', 'ID534321710904639488', null, null, null, 'single', '“迷失了方向”说法欠妥；“绝望”错误。', '5', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277833', '选出解说错误的一项（）', 'book', 'ID534322399064096768', null, null, null, 'single', '“永远记在心上”不对，应是作者对此感到激动陶醉', '2', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID532646814835277834', '对运用的表现手法解释不恰当的一项是（）', 'book', 'ID534322399064096768', null, null, null, 'single', '这首诗在修辞手法的运用上有比喻：“那河畔的金柳，是夕阳中的新娘”、“彩虹似的梦”；有拟人：“软泥上的青荐，油油的在水底招摇”；有顶针：“夏虫也为我沉默，沉默是今晚的康桥”有反复：“轻轻的我走了，正如我轻轻的来”，没有借代。', '5', '1', '168', '2019-01-09 19:48:15', '168', '2019-01-09 19:48:15');
INSERT INTO `issue` VALUES ('ID535175632514973696', '111', 'book', 'ID532982257195941888', '', '', '', 'single', '是吃撒差', '2', '', '517281575629488128', '2019-01-16 19:16:53', '517281575629488128', '2019-01-16 19:16:53');
INSERT INTO `issue` VALUES ('ID535177973293121536', '22', 'book', 'ID532982257195941888', '', '', '', 'single', '撒旦撒', '33', '', '517281575629488128', '2019-01-16 19:26:11', '517281575629488128', '2019-01-16 19:26:11');
INSERT INTO `issue` VALUES ('ID535178186984521728', '21', 'book', 'ID532982257195941888', '', '', '', 'single', '未确定多群', '33', '0', '517281575629488128', '2019-01-16 19:27:02', '517281575629488128', '2019-01-16 19:49:50');
INSERT INTO `issue` VALUES ('ID535180373735243776', '哈哈哈哈哈哈哈哈', 'book', 'ID532982257195941888', '', '', '', 'single', '哈哈哈哈哈哈哈哈或', '2', '0', '517281575629488128', '2019-01-16 19:35:44', '517281575629488128', '2019-01-16 19:48:48');
INSERT INTO `issue` VALUES ('ID535184399113650176', '111', 'book', 'ID532982257195941888', '', '', '', 'single', '是吃撒差', '2', '0', '517281575629488128', '2019-01-16 19:51:43', '517281575629488128', '2019-01-16 19:55:13');
INSERT INTO `issue` VALUES ('ID535186448148594688', '111', 'book', 'ID532982257195941888', '', '', '', 'single', '二道区无多群', '22', '0', '517281575629488128', '2019-01-16 19:59:52', '517281575629488128', '2019-01-16 20:01:30');
INSERT INTO `issue` VALUES ('ID535186672178954240', '111', 'book', 'ID532982257195941888', '', '', '', 'single', '二道区无多群', '22', '0', '517281575629488128', '2019-01-16 20:00:45', '517281575629488128', '2019-01-16 20:01:35');
INSERT INTO `issue` VALUES ('ID535189793902952448', '1`2', 'book', 'ID532982257195941888', '', '', '', 'single', '`13`12', '', '0', '517281575629488128', '2019-01-16 20:13:10', '517281575629488128', '2019-01-16 20:18:51');
INSERT INTO `issue` VALUES ('ID535190191187427328', '我2我', 'book', 'ID532982257195941888', '', '', '', 'single', '爽歪歪', '', '0', '517281575629488128', '2019-01-16 20:14:44', '517281575629488128', '2019-01-16 20:18:47');
INSERT INTO `issue` VALUES ('ID535190294002401280', '我2我', 'book', 'ID532982257195941888', '', '', '', 'single', '爽歪歪', '', '0', '517281575629488128', '2019-01-16 20:15:09', '517281575629488128', '2019-01-16 20:18:54');
INSERT INTO `issue` VALUES ('ID535396695660298240', '2', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/b9e31094ef25b321c4fd3c9aa57d2e20.jpg', 'http://img.jssns.cn/SHILU/1/0886dcb7b854407587688bea68b56510.jpg', 'http://img.jssns.cn/SHILU/1/9e9aecd204b298ecd96a74ac81e30564.png', 'single', 'ahsdjkhasjkd', '1', '0', '517281575629488128', '2019-01-17 09:55:19', '517281575629488128', '2019-01-17 09:55:19');
INSERT INTO `issue` VALUES ('ID535484045283295232', '题目', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/0886dcb7b854407587688bea68b56510.jpg', 'http://img.jssns.cn/SHILU/1/0886dcb7b854407587688bea68b56510.jpg', 'http://img.jssns.cn/SHILU/1/0886dcb7b854407587688bea68b56510.jpg', 'single', '', '2', '0', '517281575629488128', '2019-01-17 15:42:25', '517281575629488128', '2019-01-17 16:25:14');
INSERT INTO `issue` VALUES ('ID535490706018402304', '22', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/b9e31094ef25b321c4fd3c9aa57d2e20.jpg', '', '', 'single', '我的钱无', '1', '0', '517281575629488128', '2019-01-17 16:08:53', '517281575629488128', '2019-01-21 15:47:00');
INSERT INTO `issue` VALUES ('ID540656937042182144', '海报这一名称，最早起源于（      ）', 'book', 'ID538015249526161408', '', '', '', 'single', 'A 、上海', '2', '1', '168', '2019-01-31 22:17:38', '168', '2019-01-31 22:17:38');
INSERT INTO `issue` VALUES ('ID540660187896217600', '微电影一般多长时间', 'book', 'ID538015249526161408', '', '', '', 'single', '用做企业宣传片，是5-10分，用做商业则不超过40分。', '3', '1', '168', '2019-01-31 22:30:33', '168', '2019-01-31 22:30:33');
INSERT INTO `issue` VALUES ('ID540660187988492288', '爷爷和爸爸的第2次吵架是因为？', 'book', 'ID538015249526161408', '', '', '', 'single', '爷爷和爸爸的前两次吵架都是希望孩子能够根据他们的想法行动，而第3次吵架是因为他们遇到了无法解决的新问题', '4', '1', '168', '2019-01-31 22:30:33', '168', '2019-01-31 22:30:33');
INSERT INTO `issue` VALUES ('ID540660188089155584', '面对巨大的星星，小男孩用自己的方法解决了问题，他的方法是？', 'book', 'ID538015249526161408', '', '', '', 'single', '小男孩用锤子敲碎大星星这一幕，是整个微电影的高潮，当爷爷和爸爸都在为如何打扫大星星而争吵的时候，他用自己的方法解决了大星星。这里，导演想告诉我们每个孩子都有自己的优势，只要顺从天性，一定会闪闪发光', '2', '1', '168', '2019-01-31 22:30:33', '168', '2019-01-31 22:30:33');
INSERT INTO `issue` VALUES ('ID540660188189818880', '视频中微电影的名字叫做？', 'book', 'ID538015249526161408', '', '', '', 'single', 'A、《月神》', '', '1', '168', '2019-01-31 22:30:33', '168', '2019-01-31 22:30:33');
INSERT INTO `issue` VALUES ('ID540849222807715840', '（）是加拿大人，勇敢机智，捕鲸技艺天下无双。', 'book', 'ID540846505183936512', '', '', '', 'single', '康塞尔：知识渊博,性格冷静、执著,忠诚于主人的博物学家\n阿龙纳斯：生物学家，有知识而勇于探索，永不满足', '1', '1', '168', '2019-02-01 11:01:43', '168', '2019-02-01 11:01:43');
INSERT INTO `issue` VALUES ('ID540849222904184832', '鹦鹅螺号是用（）作为动力源的。', 'book', 'ID540846505183936512', '', '', '', 'single', '', '', '1', '168', '2019-02-01 11:01:43', '168', '2019-02-01 11:01:43');
INSERT INTO `issue` VALUES ('ID540849222975488000', '鹦鹉螺号总计费用是（）法郎。', 'book', 'ID540846505183936512', '', '', '', 'single', '', '', '1', '168', '2019-02-01 11:01:43', '168', '2019-02-01 11:01:43');

-- ----------------------------
-- Table structure for `issue_answer`
-- ----------------------------
DROP TABLE IF EXISTS `issue_answer`;
CREATE TABLE `issue_answer` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `issue_id` varchar(30) NOT NULL COMMENT '题目主键',
  `item_id` varchar(30)  COMMENT '选项主键',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '回答人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '回答时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问题回答';

-- ----------------------------
-- Records of issue_answer
-- ----------------------------
INSERT INTO `issue_answer` VALUES ('ID534336488263909376', 'ID532645024467255296', '2', '1', '518084122451640320', '2019-01-14 11:42:26');
INSERT INTO `issue_answer` VALUES ('ID534336499064242176', 'ID532645024467255297', '5', '1', '518084122451640320', '2019-01-14 11:42:28');
INSERT INTO `issue_answer` VALUES ('ID534336508153298944', 'ID532646814835277824', '9', '1', '518084122451640320', '2019-01-14 11:42:31');
INSERT INTO `issue_answer` VALUES ('ID534417702186385408', 'ID532646814835277828', '22', '1', '516919611287928832', '2019-01-14 17:05:09');
INSERT INTO `issue_answer` VALUES ('ID534417715222282240', 'ID532646814835277829', '28', '1', '516919611287928832', '2019-01-14 17:05:12');
INSERT INTO `issue_answer` VALUES ('ID534417728253984768', 'ID532646814835277830', '31', '1', '516919611287928832', '2019-01-14 17:05:15');
INSERT INTO `issue_answer` VALUES ('ID534417740807536640', 'ID532646814835277833', '42', '1', '516919611287928832', '2019-01-14 17:05:18');
INSERT INTO `issue_answer` VALUES ('ID534417749917564928', 'ID532646814835277834', '46', '1', '516919611287928832', '2019-01-14 17:05:20');
INSERT INTO `issue_answer` VALUES ('ID534430526136647680', 'ID532646814835277828', '25', '1', '517713552572678144', '2019-01-14 17:56:06');
INSERT INTO `issue_answer` VALUES ('ID534430527826952192', 'ID532646814835277828', '25', '1', '517713552572678144', '2019-01-14 17:56:07');
INSERT INTO `issue_answer` VALUES ('ID534430540149817344', 'ID532646814835277829', '28', '1', '517713552572678144', '2019-01-14 17:56:10');
INSERT INTO `issue_answer` VALUES ('ID534430550555885568', 'ID532646814835277830', '31', '1', '517713552572678144', '2019-01-14 17:56:12');
INSERT INTO `issue_answer` VALUES ('ID534430558730584064', 'ID532646814835277833', '43', '1', '517713552572678144', '2019-01-14 17:56:14');
INSERT INTO `issue_answer` VALUES ('ID534430566842368000', 'ID532646814835277834', '47', '1', '517713552572678144', '2019-01-14 17:56:16');
INSERT INTO `issue_answer` VALUES ('ID534457209568886784', 'ID532646814835277825', '13', '1', '516919611287928832', '2019-01-14 19:42:08');
INSERT INTO `issue_answer` VALUES ('ID534457218070740992', 'ID532646814835277826', '15', '1', '516919611287928832', '2019-01-14 19:42:10');
INSERT INTO `issue_answer` VALUES ('ID534457235045089280', 'ID532646814835277827', '18', '1', '516919611287928832', '2019-01-14 19:42:14');
INSERT INTO `issue_answer` VALUES ('ID534661733961170944', 'ID532646814835277825', '13', '1', '518084122451640320', '2019-01-15 09:14:50');
INSERT INTO `issue_answer` VALUES ('ID534661741842268160', 'ID532646814835277826', '15', '1', '518084122451640320', '2019-01-15 09:14:52');
INSERT INTO `issue_answer` VALUES ('ID534661749928886272', 'ID532646814835277827', '20', '1', '518084122451640320', '2019-01-15 09:14:54');
INSERT INTO `issue_answer` VALUES ('ID534661765607194624', 'ID532646814835277831', '37', '1', '518084122451640320', '2019-01-15 09:14:58');
INSERT INTO `issue_answer` VALUES ('ID534661773446348800', 'ID532646814835277832', '40', '1', '518084122451640320', '2019-01-15 09:15:00');
INSERT INTO `issue_answer` VALUES ('ID534756879688007680', 'ID532645024467255296', '1', '1', '521736048980525056', '2019-01-15 15:32:55');
INSERT INTO `issue_answer` VALUES ('ID534780610137292800', 'ID532645024467255296', '2', '1', '518881498053476352', '2019-01-15 17:07:13');
INSERT INTO `issue_answer` VALUES ('ID534780756929544192', 'ID532645024467255297', '5', '1', '518881498053476352', '2019-01-15 17:07:48');
INSERT INTO `issue_answer` VALUES ('ID534780786818154496', 'ID532646814835277824', '8', '1', '518881498053476352', '2019-01-15 17:07:55');
INSERT INTO `issue_answer` VALUES ('ID534989878568419328', 'ID532646814835277825', '11', '1', '522515811546431488', '2019-01-16 06:58:46');
INSERT INTO `issue_answer` VALUES ('ID534990072311709696', 'ID532646814835277826', '15', '1', '522515811546431488', '2019-01-16 06:59:32');
INSERT INTO `issue_answer` VALUES ('ID534990224497836032', 'ID532646814835277827', '21', '1', '522515811546431488', '2019-01-16 07:00:09');
INSERT INTO `issue_answer` VALUES ('ID534990303896010752', 'ID532646814835277831', '35', '1', '522515811546431488', '2019-01-16 07:00:28');
INSERT INTO `issue_answer` VALUES ('ID534990435676848128', 'ID532646814835277832', '40', '1', '522515811546431488', '2019-01-16 07:00:59');
INSERT INTO `issue_answer` VALUES ('ID535068708020682752', 'ID532645024467255296', '1', '1', '535065548703137792', '2019-01-16 12:12:01');
INSERT INTO `issue_answer` VALUES ('ID535068807329218560', 'ID532645024467255297', '6', '1', '535065548703137792', '2019-01-16 12:12:24');
INSERT INTO `issue_answer` VALUES ('ID535068961025294336', 'ID532646814835277824', '9', '1', '535065548703137792', '2019-01-16 12:13:01');
INSERT INTO `issue_answer` VALUES ('ID535202553059606528', 'ID532646814835277825', '10', '1', '518881590537879552', '2019-01-16 21:03:52');
INSERT INTO `issue_answer` VALUES ('ID535202643153256448', 'ID532646814835277826', '15', '1', '518881590537879552', '2019-01-16 21:04:13');
INSERT INTO `issue_answer` VALUES ('ID535202691354198016', 'ID532646814835277827', '21', '1', '518881590537879552', '2019-01-16 21:04:25');
INSERT INTO `issue_answer` VALUES ('ID535202716381609984', 'ID532646814835277831', '35', '1', '518881590537879552', '2019-01-16 21:04:31');
INSERT INTO `issue_answer` VALUES ('ID535202725760073728', 'ID532646814835277832', '39', '1', '518881590537879552', '2019-01-16 21:04:33');
INSERT INTO `issue_answer` VALUES ('ID535491632347217920', 'ID532645024467255296', 'ID535490705791909888', '1', '522000062855774208', '2019-01-17 16:12:34');
INSERT INTO `issue_answer` VALUES ('ID535491647190859776', 'ID532645024467255297', 'ID535490705879990272', '1', '522000062855774208', '2019-01-17 16:12:37');
INSERT INTO `issue_answer` VALUES ('ID535491838996381696', 'ID532646814835277828', '24', '1', '522000062855774208', '2019-01-17 16:13:23');
INSERT INTO `issue_answer` VALUES ('ID535516650913398784', 'ID532645024467255296', 'ID535495116983369728', '1', '518881498053476352', '2019-01-17 17:51:58');
INSERT INTO `issue_answer` VALUES ('ID535516664570052608', 'ID532645024467255297', 'ID535495117029507072', '1', '518881498053476352', '2019-01-17 17:52:02');
INSERT INTO `issue_answer` VALUES ('ID535516687240265728', 'ID532646814835277824', 'ID535495117092421632', '1', '518881498053476352', '2019-01-17 17:52:07');
INSERT INTO `issue_answer` VALUES ('ID535560269665927168', 'ID532645024467255296', 'ID535495116924649472', '1', '521736048980525056', '2019-01-17 20:45:18');
INSERT INTO `issue_answer` VALUES ('ID536956107130667008', 'ID532646814835277828', '23', '1', '517349219414048768', '2019-01-21 17:11:52');
INSERT INTO `issue_answer` VALUES ('ID536956120036540416', 'ID532646814835277829', '26', '1', '517349219414048768', '2019-01-21 17:11:55');
INSERT INTO `issue_answer` VALUES ('ID536956120317558784', 'ID532646814835277829', '26', '1', '517349219414048768', '2019-01-21 17:11:55');
INSERT INTO `issue_answer` VALUES ('ID536956129964457984', 'ID532646814835277830', '30', '1', '517349219414048768', '2019-01-21 17:11:57');
INSERT INTO `issue_answer` VALUES ('ID536956140471189504', 'ID532646814835277833', '42', '1', '517349219414048768', '2019-01-21 17:12:00');
INSERT INTO `issue_answer` VALUES ('ID536956152521424896', 'ID532646814835277834', '47', '1', '517349219414048768', '2019-01-21 17:12:02');
INSERT INTO `issue_answer` VALUES ('ID536967791329148928', 'ID532645024467255296', 'ID535495116962398208', '1', '517366532112646144', '2019-01-21 17:58:17');
INSERT INTO `issue_answer` VALUES ('ID536967793938006016', 'ID532645024467255296', 'ID535495116924649472', '1', '517366532112646144', '2019-01-21 17:58:18');
INSERT INTO `issue_answer` VALUES ('ID537240621811761152', 'ID532646814835277828', '22', '1', '518503409347723264', '2019-01-22 12:02:25');
INSERT INTO `issue_answer` VALUES ('ID537240638882578432', 'ID532646814835277829', '28', '1', '518503409347723264', '2019-01-22 12:02:29');
INSERT INTO `issue_answer` VALUES ('ID537639560683716608', 'ID532645024467255296', 'ID535495116962398208', '1', '516919611287928832', '2019-01-23 14:27:40');
INSERT INTO `issue_answer` VALUES ('ID537639567394603008', 'ID532645024467255297', 'ID535495117029507072', '1', '516919611287928832', '2019-01-23 14:27:41');
INSERT INTO `issue_answer` VALUES ('ID537639574046769152', 'ID532646814835277824', 'ID535495117075644416', '1', '516919611287928832', '2019-01-23 14:27:43');
INSERT INTO `issue_answer` VALUES ('ID538365135207530496', 'ID532645024467255296', 'ID535495116924649472', '1', '518881699824664576', '2019-01-25 14:30:50');
INSERT INTO `issue_answer` VALUES ('ID538365185165885440', 'ID532645024467255297', 'ID535495117046284288', '1', '518881699824664576', '2019-01-25 14:31:02');
INSERT INTO `issue_answer` VALUES ('ID538365260579471360', 'ID532646814835277824', 'ID535495117105004544', '1', '518881699824664576', '2019-01-25 14:31:20');
INSERT INTO `issue_answer` VALUES ('ID538410377176678400', 'ID532646814835277825', '10', '1', '517713552572678144', '2019-01-25 17:30:37');
INSERT INTO `issue_answer` VALUES ('ID538410390350987264', 'ID532646814835277826', '17', '1', '517713552572678144', '2019-01-25 17:30:40');
INSERT INTO `issue_answer` VALUES ('ID538410398546657280', 'ID532646814835277827', '21', '1', '517713552572678144', '2019-01-25 17:30:42');
INSERT INTO `issue_answer` VALUES ('ID538410414136885248', 'ID532646814835277831', '37', '1', '517713552572678144', '2019-01-25 17:30:45');
INSERT INTO `issue_answer` VALUES ('ID538410424744280064', 'ID532646814835277832', '41', '1', '517713552572678144', '2019-01-25 17:30:48');
INSERT INTO `issue_answer` VALUES ('ID540246411141185536', 'ID532645024467255296', 'ID535495116962398208', '1', '518880937937731584', '2019-01-30 19:06:21');
INSERT INTO `issue_answer` VALUES ('ID540250415459991552', 'ID532645024467255296', 'ID535495116962398208', '1', '517713552572678144', '2019-01-30 19:22:16');
INSERT INTO `issue_answer` VALUES ('ID540250417938825216', 'ID532645024467255296', 'ID535495116962398208', '1', '517713552572678144', '2019-01-30 19:22:16');
INSERT INTO `issue_answer` VALUES ('ID540250432971210752', 'ID532645024467255297', 'ID535495117029507072', '1', '517713552572678144', '2019-01-30 19:22:20');
INSERT INTO `issue_answer` VALUES ('ID540250444828508160', 'ID532646814835277824', 'ID535495117092421632', '1', '517713552572678144', '2019-01-30 19:22:23');
INSERT INTO `issue_answer` VALUES ('ID540578015973736448', 'ID532646814835277825', '12', '1', '517366313497133056', '2019-01-31 17:04:02');
INSERT INTO `issue_answer` VALUES ('ID540639892514799616', 'ID532646814835277828', '23', '1', '517366313497133056', '2019-01-31 21:09:54');
INSERT INTO `issue_answer` VALUES ('ID540639892523188224', 'ID532646814835277828', '23', '1', '517366313497133056', '2019-01-31 21:09:54');
INSERT INTO `issue_answer` VALUES ('ID540639893508849664', 'ID532646814835277828', '23', '1', '517366313497133056', '2019-01-31 21:09:55');
INSERT INTO `issue_answer` VALUES ('ID540639913482125312', 'ID532646814835277829', '28', '1', '517366313497133056', '2019-01-31 21:09:59');
INSERT INTO `issue_answer` VALUES ('ID540639915881267200', 'ID532646814835277829', '28', '1', '517366313497133056', '2019-01-31 21:10:00');
INSERT INTO `issue_answer` VALUES ('ID540639945967009792', 'ID532646814835277830', '31', '1', '517366313497133056', '2019-01-31 21:10:07');
INSERT INTO `issue_answer` VALUES ('ID540639946839425024', 'ID532646814835277830', '31', '1', '517366313497133056', '2019-01-31 21:10:07');
INSERT INTO `issue_answer` VALUES ('ID540639948517146624', 'ID532646814835277830', '31', '1', '517366313497133056', '2019-01-31 21:10:08');
INSERT INTO `issue_answer` VALUES ('ID540639958071771136', 'ID532646814835277833', '44', '1', '517366313497133056', '2019-01-31 21:10:10');
INSERT INTO `issue_answer` VALUES ('ID540639960185700352', 'ID532646814835277833', '44', '1', '517366313497133056', '2019-01-31 21:10:11');
INSERT INTO `issue_answer` VALUES ('ID540656994537701376', 'ID540656937042182144', 'ID540656937163816960', '1', '518084122451640320', '2019-01-31 22:17:52');
INSERT INTO `issue_answer` VALUES ('ID540657124397547520', 'ID540656937042182144', 'ID540657099894423552', '1', '518084122451640320', '2019-01-31 22:18:23');
INSERT INTO `issue_answer` VALUES ('ID540660219521269760', 'ID540656937042182144', 'ID540660187795554304', '1', '518084122451640320', '2019-01-31 22:30:41');
INSERT INTO `issue_answer` VALUES ('ID540660233744154624', 'ID540660187896217600', 'ID540660187946549248', '1', '518084122451640320', '2019-01-31 22:30:44');
INSERT INTO `issue_answer` VALUES ('ID540660374559522816', 'ID540660187988492288', 'ID540660188068184064', '1', '518084122451640320', '2019-01-31 22:31:18');
INSERT INTO `issue_answer` VALUES ('ID540660446084988928', 'ID540660188089155584', 'ID540660188168847360', '1', '518084122451640320', '2019-01-31 22:31:35');
INSERT INTO `issue_answer` VALUES ('ID540660580713758720', 'ID540660188189818880', 'ID540660188219179008', '1', '518084122451640320', '2019-01-31 22:32:07');
INSERT INTO `issue_answer` VALUES ('ID540788695792353280', 'ID540656937042182144', 'ID540660619007754240', '1', '523131306125557760', '2019-02-01 07:01:12');
INSERT INTO `issue_answer` VALUES ('ID540849514588667904', 'ID540849222807715840', 'ID540849239069032448', '1', '518881699824664576', '2019-02-01 11:02:52');
INSERT INTO `issue_answer` VALUES ('ID540849541830672384', 'ID540849222904184832', 'ID540849239165501440', '1', '518881699824664576', '2019-02-01 11:02:59');
INSERT INTO `issue_answer` VALUES ('ID540849542703087616', 'ID540849222904184832', 'ID540849239165501440', '1', '518881699824664576', '2019-02-01 11:02:59');
INSERT INTO `issue_answer` VALUES ('ID540849574986645504', 'ID540849222975488000', 'ID540849239194861568', '1', '518881699824664576', '2019-02-01 11:03:07');
INSERT INTO `issue_answer` VALUES ('ID540849593466748928', 'ID540849222807715840', 'ID540849239069032448', '1', '518884655118680064', '2019-02-01 11:03:11');
INSERT INTO `issue_answer` VALUES ('ID540849624412323840', 'ID540849222904184832', 'ID540849239165501440', '1', '518884655118680064', '2019-02-01 11:03:18');
INSERT INTO `issue_answer` VALUES ('ID540849626958266368', 'ID540849222904184832', 'ID540849239165501440', '1', '518884655118680064', '2019-02-01 11:03:19');
INSERT INTO `issue_answer` VALUES ('ID540849642623991808', 'ID540849222975488000', 'ID540849239232610304', '1', '518884655118680064', '2019-02-01 11:03:23');
INSERT INTO `issue_answer` VALUES ('ID540849645362872320', 'ID540849222975488000', 'ID540849239232610304', '1', '518884655118680064', '2019-02-01 11:03:23');
INSERT INTO `issue_answer` VALUES ('ID540849712165552128', 'ID540849222807715840', 'ID540849239069032448', '1', '518882518661857280', '2019-02-01 11:03:39');
INSERT INTO `issue_answer` VALUES ('ID540849712467542016', 'ID540849222807715840', 'ID540849239085809664', '1', '518882036950237184', '2019-02-01 11:03:39');
INSERT INTO `issue_answer` VALUES ('ID540849725985783808', 'ID540849222904184832', 'ID540849239127752704', '1', '518882036950237184', '2019-02-01 11:03:43');
INSERT INTO `issue_answer` VALUES ('ID540849728091324416', 'ID540849222904184832', 'ID540849239127752704', '1', '518882518661857280', '2019-02-01 11:03:43');
INSERT INTO `issue_answer` VALUES ('ID540849729353809920', 'ID540849222904184832', 'ID540849239127752704', '1', '518882036950237184', '2019-02-01 11:03:43');
INSERT INTO `issue_answer` VALUES ('ID540849730473689088', 'ID540849222904184832', 'ID540849239127752704', '1', '518882518661857280', '2019-02-01 11:03:44');
INSERT INTO `issue_answer` VALUES ('ID540849742037385216', 'ID540849222975488000', 'ID540849239232610304', '1', '518882518661857280', '2019-02-01 11:03:47');
INSERT INTO `issue_answer` VALUES ('ID540849744767877120', 'ID540849222975488000', 'ID540849239232610304', '1', '518882518661857280', '2019-02-01 11:03:47');
INSERT INTO `issue_answer` VALUES ('ID540849753143902208', 'ID540849222807715840', 'ID540849239069032448', '1', '517366313497133056', '2019-02-01 11:03:49');
INSERT INTO `issue_answer` VALUES ('ID540849765747785728', 'ID540849222904184832', 'ID540849239127752704', '1', '517366313497133056', '2019-02-01 11:03:52');
INSERT INTO `issue_answer` VALUES ('ID540849793434386432', 'ID540656937042182144', 'ID540660619007754240', '1', '518882959818752000', '2019-02-01 11:03:59');
INSERT INTO `issue_answer` VALUES ('ID540849794348744704', 'ID540656937042182144', 'ID540660619028725760', '1', '518882959818752000', '2019-02-01 11:03:59');
INSERT INTO `issue_answer` VALUES ('ID540849795753836544', 'ID540656937042182144', 'ID540660619045502976', '1', '518882959818752000', '2019-02-01 11:03:59');
INSERT INTO `issue_answer` VALUES ('ID540849796919853056', 'ID540656937042182144', 'ID540660619045502976', '1', '518882959818752000', '2019-02-01 11:04:00');
INSERT INTO `issue_answer` VALUES ('ID540849797146345472', 'ID540656937042182144', 'ID540660619045502976', '1', '518882959818752000', '2019-02-01 11:04:00');
INSERT INTO `issue_answer` VALUES ('ID540849815928438784', 'ID540849222807715840', 'ID540849239069032448', '1', '540849671703101440', '2019-02-01 11:04:04');
INSERT INTO `issue_answer` VALUES ('ID540849824342212608', 'ID540849222975488000', 'ID540849239211638784', '1', '518882036950237184', '2019-02-01 11:04:06');
INSERT INTO `issue_answer` VALUES ('ID540849826657468416', 'ID540849222975488000', 'ID540849239211638784', '1', '518882036950237184', '2019-02-01 11:04:07');
INSERT INTO `issue_answer` VALUES ('ID540849830205849600', 'ID540849222904184832', 'ID540849239127752704', '1', '540849671703101440', '2019-02-01 11:04:08');
INSERT INTO `issue_answer` VALUES ('ID540849836778323968', 'ID540849222975488000', 'ID540849239232610304', '1', '517366313497133056', '2019-02-01 11:04:09');
INSERT INTO `issue_answer` VALUES ('ID540849844462288896', 'ID540849222975488000', 'ID540849239232610304', '1', '540849671703101440', '2019-02-01 11:04:11');
INSERT INTO `issue_answer` VALUES ('ID540849911655038976', 'ID540849222807715840', 'ID540849239069032448', '1', '519047766756818944', '2019-02-01 11:04:27');
INSERT INTO `issue_answer` VALUES ('ID540849929275310080', 'ID540849222904184832', 'ID540849239148724224', '1', '519047766756818944', '2019-02-01 11:04:31');
INSERT INTO `issue_answer` VALUES ('ID540849940113391616', 'ID540849222807715840', 'ID540849239069032448', '1', '518896990185062400', '2019-02-01 11:04:34');
INSERT INTO `issue_answer` VALUES ('ID540849949944840192', 'ID540849222904184832', 'ID540849239127752704', '1', '518896990185062400', '2019-02-01 11:04:36');
INSERT INTO `issue_answer` VALUES ('ID540849958132121600', 'ID540849222975488000', 'ID540849239232610304', '1', '518896990185062400', '2019-02-01 11:04:38');
INSERT INTO `issue_answer` VALUES ('ID540849967388950528', 'ID540849222975488000', 'ID540849239194861568', '1', '519047766756818944', '2019-02-01 11:04:40');
INSERT INTO `issue_answer` VALUES ('ID540850002218450944', 'ID540849222807715840', 'ID540849239069032448', '1', '538370652508258304', '2019-02-01 11:04:49');
INSERT INTO `issue_answer` VALUES ('ID540850038021029888', 'ID540849222904184832', 'ID540849239165501440', '1', '538370652508258304', '2019-02-01 11:04:57');
INSERT INTO `issue_answer` VALUES ('ID540850057285468160', 'ID540849222807715840', 'ID540849239069032448', '1', '531053882562838528', '2019-02-01 11:05:02');
INSERT INTO `issue_answer` VALUES ('ID540850063782445056', 'ID540849222975488000', 'ID540849239194861568', '1', '538370652508258304', '2019-02-01 11:05:03');
INSERT INTO `issue_answer` VALUES ('ID540850095935979520', 'ID540849222904184832', 'ID540849239127752704', '1', '531053882562838528', '2019-02-01 11:05:11');
INSERT INTO `issue_answer` VALUES ('ID540850111664619520', 'ID540849222975488000', 'ID540849239232610304', '1', '531053882562838528', '2019-02-01 11:05:15');
INSERT INTO `issue_answer` VALUES ('ID540850229126103040', 'ID540849222807715840', 'ID540849239085809664', '1', '526060397392822272', '2019-02-01 11:05:43');
INSERT INTO `issue_answer` VALUES ('ID540850231554605056', 'ID540849222807715840', 'ID540849239085809664', '1', '526060397392822272', '2019-02-01 11:05:43');
INSERT INTO `issue_answer` VALUES ('ID540850282058219520', 'ID540849222904184832', 'ID540849239148724224', '1', '526060397392822272', '2019-02-01 11:05:55');
INSERT INTO `issue_answer` VALUES ('ID540850282939023360', 'ID540849222904184832', 'ID540849239148724224', '1', '526060397392822272', '2019-02-01 11:05:55');
INSERT INTO `issue_answer` VALUES ('ID540850285317193728', 'ID540849222904184832', 'ID540849239148724224', '1', '526060397392822272', '2019-02-01 11:05:56');
INSERT INTO `issue_answer` VALUES ('ID540850310604652544', 'ID540849222975488000', 'ID540849239211638784', '1', '526060397392822272', '2019-02-01 11:06:02');
INSERT INTO `issue_answer` VALUES ('ID540850311355432960', 'ID540849222975488000', 'ID540849239211638784', '1', '526060397392822272', '2019-02-01 11:06:02');
INSERT INTO `issue_answer` VALUES ('ID540850313683271680', 'ID540849222975488000', 'ID540849239211638784', '1', '526060397392822272', '2019-02-01 11:06:03');
INSERT INTO `issue_answer` VALUES ('ID540851853236109312', 'ID540849222807715840', 'ID540849239085809664', '1', '518882959818752000', '2019-02-01 11:12:10');
INSERT INTO `issue_answer` VALUES ('ID540851908332486656', 'ID540849222904184832', 'ID540849239127752704', '1', '518882959818752000', '2019-02-01 11:12:23');
INSERT INTO `issue_answer` VALUES ('ID540851931132723200', 'ID540849222975488000', 'ID540849239232610304', '1', '518882959818752000', '2019-02-01 11:12:28');
INSERT INTO `issue_answer` VALUES ('ID540861431147397120', 'ID540849222807715840', 'ID540849239052255232', '1', '540860779990089728', '2019-02-01 11:50:13');
INSERT INTO `issue_answer` VALUES ('ID540861484524109824', 'ID540849222904184832', 'ID540849239165501440', '1', '540860779990089728', '2019-02-01 11:50:26');
INSERT INTO `issue_answer` VALUES ('ID540861486860337152', 'ID540849222904184832', 'ID540849239165501440', '1', '540860779990089728', '2019-02-01 11:50:27');
INSERT INTO `issue_answer` VALUES ('ID540861528316837888', 'ID540849222975488000', 'ID540849239194861568', '1', '540860779990089728', '2019-02-01 11:50:37');
INSERT INTO `issue_answer` VALUES ('ID544802126673477632', 'ID540849222807715840', 'ID540849239085809664', '1', '518084122451640320', '2019-02-12 08:49:08');
INSERT INTO `issue_answer` VALUES ('ID544802146747416576', 'ID540849222904184832', 'ID540849239127752704', '1', '518084122451640320', '2019-02-12 08:49:13');
INSERT INTO `issue_answer` VALUES ('ID544802167605690368', 'ID540849222975488000', 'ID540849239211638784', '1', '518084122451640320', '2019-02-12 08:49:18');
INSERT INTO `issue_answer` VALUES ('ID545685999208890368', 'ID540849222807715840', 'ID540849239069032448', '1', '537692823621730304', '2019-02-14 19:21:20');
INSERT INTO `issue_answer` VALUES ('ID545686034390712320', 'ID540849222904184832', 'ID540849239165501440', '1', '537692823621730304', '2019-02-14 19:21:28');
INSERT INTO `issue_answer` VALUES ('ID545686077772398592', 'ID540849222975488000', 'ID540849239194861568', '1', '537692823621730304', '2019-02-14 19:21:39');
INSERT INTO `issue_answer` VALUES ('ID545686080200900608', 'ID540849222975488000', 'ID540849239194861568', '1', '537692823621730304', '2019-02-14 19:21:39');
INSERT INTO `issue_answer` VALUES ('ID547839472100704256', 'ID540849222807715840', 'ID540849239069032448', '1', '516919611287928832', '2019-02-20 17:58:28');
INSERT INTO `issue_answer` VALUES ('ID547839482645184512', 'ID540849222904184832', 'ID540849239165501440', '1', '516919611287928832', '2019-02-20 17:58:31');
INSERT INTO `issue_answer` VALUES ('ID547839484499066880', 'ID540849222904184832', 'ID540849239165501440', '1', '516919611287928832', '2019-02-20 17:58:31');
INSERT INTO `issue_answer` VALUES ('ID547839500131237888', 'ID540849222975488000', 'ID540849239211638784', '1', '516919611287928832', '2019-02-20 17:58:35');
INSERT INTO `issue_answer` VALUES ('ID547839510738632704', 'ID540849222975488000', 'ID540849239211638784', '1', '516919611287928832', '2019-02-20 17:58:37');
INSERT INTO `issue_answer` VALUES ('ID547839510784770048', 'ID540849222975488000', 'ID540849239232610304', '1', '516919611287928832', '2019-02-20 17:58:37');
INSERT INTO `issue_answer` VALUES ('ID547839511439081472', 'ID540849222975488000', 'ID540849239211638784', '1', '516919611287928832', '2019-02-20 17:58:37');
INSERT INTO `issue_answer` VALUES ('ID547841668246667264', 'ID540849222807715840', 'ID540849239069032448', '1', '547840691636535296', '2019-02-20 18:07:12');
INSERT INTO `issue_answer` VALUES ('ID548505044153008128', 'ID540656937042182144', 'ID540660619028725760', '1', '517366532112646144', '2019-02-22 14:03:12');
INSERT INTO `issue_answer` VALUES ('ID554779221814149120', 'ID540849222807715840', 'ID540849239069032448', '1', '517366532112646144', '2019-03-11 21:34:33');
INSERT INTO `issue_answer` VALUES ('ID557564093746118656', 'ID540656937042182144', 'ID540660619007754240', '1', '516919611287928832', '2019-03-19 14:00:38');
INSERT INTO `issue_answer` VALUES ('ID557564113794891776', 'ID540660187896217600', 'ID540660619271995392', '1', '516919611287928832', '2019-03-19 14:00:43');
INSERT INTO `issue_answer` VALUES ('ID557564125178232832', 'ID540660187988492288', 'ID540660619318132736', '1', '516919611287928832', '2019-03-19 14:00:46');
INSERT INTO `issue_answer` VALUES ('ID557564139250122752', 'ID540660188089155584', 'ID540660619385241600', '1', '516919611287928832', '2019-03-19 14:00:49');
INSERT INTO `issue_answer` VALUES ('ID557564151728177152', 'ID540660188189818880', 'ID540660619498487808', '1', '516919611287928832', '2019-03-19 14:00:52');
INSERT INTO `issue_answer` VALUES ('ID563350041620643840', 'ID540656937042182144', 'ID540660619045502976', '1', '517349219414048768', '2019-04-04 13:11:56');
INSERT INTO `issue_answer` VALUES ('ID563350053150785536', 'ID540660187896217600', 'ID540660619288772608', '1', '517349219414048768', '2019-04-04 13:11:59');
INSERT INTO `issue_answer` VALUES ('ID563350065670782976', 'ID540660187988492288', 'ID540660619351687168', '1', '517349219414048768', '2019-04-04 13:12:02');
INSERT INTO `issue_answer` VALUES ('ID563350085740527616', 'ID540660188089155584', 'ID540660619402018816', '1', '517349219414048768', '2019-04-04 13:12:06');
INSERT INTO `issue_answer` VALUES ('ID563350105101434880', 'ID540660188189818880', 'ID540660619523653632', '1', '517349219414048768', '2019-04-04 13:12:11');
INSERT INTO `issue_answer` VALUES ('ID565911787698913280', 'ID540849222807715840', 'ID540849239052255232', '1', '565846807398055936', '2019-04-11 14:51:24');
INSERT INTO `issue_answer` VALUES ('ID565911817050652672', 'ID540849222904184832', 'ID540849239127752704', '1', '565846807398055936', '2019-04-11 14:51:31');
INSERT INTO `issue_answer` VALUES ('ID565911830032023552', 'ID540849222975488000', 'ID540849239232610304', '1', '565846807398055936', '2019-04-11 14:51:34');
INSERT INTO `issue_answer` VALUES ('ID565911967470977024', 'ID540849222807715840', 'ID540849239069032448', '1', '565911816136294400', '2019-04-11 14:52:07');
INSERT INTO `issue_answer` VALUES ('ID565911979219222528', 'ID540849222904184832', 'ID540849239127752704', '1', '565911816136294400', '2019-04-11 14:52:09');
INSERT INTO `issue_answer` VALUES ('ID565911988283113472', 'ID540849222975488000', 'ID540849239232610304', '1', '565911816136294400', '2019-04-11 14:52:12');
INSERT INTO `issue_answer` VALUES ('ID568454106620887040', 'ID540849222807715840', 'ID540849239069032448', '1', '517349219414048768', '2019-04-18 15:13:40');
INSERT INTO `issue_answer` VALUES ('ID568454117165367296', 'ID540849222904184832', 'ID540849239165501440', '1', '517349219414048768', '2019-04-18 15:13:42');
INSERT INTO `issue_answer` VALUES ('ID568454126787100672', 'ID540849222975488000', 'ID540849239232610304', '1', '517349219414048768', '2019-04-18 15:13:45');
INSERT INTO `issue_answer` VALUES ('ID568542164573749248', 'ID540849222807715840', 'ID540849239052255232', '1', '537581987150430208', '2019-04-18 21:03:35');
INSERT INTO `issue_answer` VALUES ('ID572358699079696384', 'ID540849222807715840', 'ID540849239085809664', '1', '517713552572678144', '2019-04-29 09:49:07');
INSERT INTO `issue_answer` VALUES ('ID572358710068772864', 'ID540849222904184832', 'ID540849239148724224', '1', '517713552572678144', '2019-04-29 09:49:10');
INSERT INTO `issue_answer` VALUES ('ID572358719145246720', 'ID540849222975488000', 'ID540849239194861568', '1', '517713552572678144', '2019-04-29 09:49:12');

-- ----------------------------
-- Table structure for `issue_item`
-- ----------------------------
DROP TABLE IF EXISTS `issue_item`;
CREATE TABLE `issue_item` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `issue_id` varchar(30) NOT NULL COMMENT '题目主键',
  `content` varchar(500) DEFAULT NULL COMMENT '选项内容',
  `img1` varchar(200) DEFAULT NULL COMMENT '图片1',
  `img2` varchar(200) DEFAULT NULL COMMENT '图片2',
  `img3` varchar(200) DEFAULT NULL COMMENT '图片3',
  `is_answer` varchar(6) DEFAULT NULL COMMENT '是否正确答案(0否,1是)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题目选项';

-- ----------------------------
-- Records of issue_item
-- ----------------------------
INSERT INTO `issue_item` VALUES ('', '', null, null, null, null, null, null, null, null, null);
INSERT INTO `issue_item` VALUES ('10', 'ID532646814835277825', '悠长  彷徨  荡漾  寂寥', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('11', 'ID532646814835277825', '愁怨  颓记  紧绷  苍劲', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('12', 'ID532646814835277825', '摇曳  敞开  严峻  凄碗', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('13', 'ID532646814835277825', '坍塌  迷茫  冷漠  篱墙', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('14', 'ID532646814835277826', '轻轻的/我走了，//正如我/轻轻的来。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('15', 'ID532646814835277826', '波光里的/艳影，//在我的/心头荡漾', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('16', 'ID532646814835277826', '她//彷徨在/这寂寥的雨巷', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('17', 'ID532646814835277826', '一个/丁香一样的/结着愁怨的//姑娘', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('18', 'ID532646814835277827', '后期诗歌主要表现热爱祖国、憎恨侵略者的强烈感情和对美好未来的热烈向\r\n往，诗风明朗、沉挚。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('19', 'ID532646814835277827', '戴望舒早期的诗歌受西方印象派的影响，意象朦胧、含蓄。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('20', 'ID532646814835277827', '《雨巷》是戴望舒早期的成名作和代表作，诗歌发表后产生了较大影响，诗人\r\n也因此被称为“雨巷诗人”。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('21', 'ID532646814835277827', '戴课舒是中国现代诗人。主要诗集有《我的记忆》、《塑舒草》、《望舒诗稿》、《灾难的岁月》。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('22', 'ID532646814835277828', '“夕阳下的新娘”，是说夕阳照射下的柳枝，镀上了一层妩媚的金色，那金色的枝条随风轻轻摇摆，影子倒映在水中，像一位美艳的新娘。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('23', 'ID532646814835277828', '“波光里的艳影，在我的心头荡漾”，倒映在水中的金柳，随波光一起荡漾，显得更加美艳，作者对如此美景，永远记在心上。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('24', 'ID532646814835277828', '“软泥上的青荇，油油的在水底招摇”，是说绿油油的水草在柔波中招摇，仿佛是在向诗人招手示意。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('25', 'ID532646814835277828', '“揉碎在浮藻间，沉淀着彩虹似的梦”，是说天上被操碎了的彩虹和漂浮在潭水上的水草相杂在一起，沉淀在潭水的深处，就如同彩虹似的梦一般。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('26', 'ID532646814835277829', '作者用“新娘”来比喻“金柳”，显得艳丽妩媚，表现了作者无限欢喜和眷恋的感情。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('27', 'ID532646814835277829', '“招摇”二字，生动地写出了康桥对诗人热忱欢迎的态度。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('28', 'ID532646814835277829', '诗人为承受康河清波的爱抚，情愿做一条水草，这里的“甘心”二字，写出了诗人对康桥的永久恋情。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('29', 'ID532646814835277829', '用“彩虹”来修饰“梦”，表明梦境的美好，也表明梦境的短暂虚幻。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('30', 'ID532646814835277830', '夏虫也为我沉默，沉默是今晚的康桥！', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('31', 'ID532646814835277830', '那榆阴下的一潭，不是清泉，是天上虹；揉碎在浮藻间，沉淀着彩虹似的梦。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('32', 'ID532646814835277830', '那河畔的金柳，是夕阳中的新娘；波光里的艳影，在我的心头荡漾。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('33', 'ID532646814835277830', '我希望逢着一个丁香一样的结着愁怨的姑娘。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('34', 'ID532646814835277831', '整首诗凄清，婉转，而又含意绵绵。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('35', 'ID532646814835277831', '整首诗意境深远，表达了一种肝肠寸断之感。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('36', 'ID532646814835277831', '诗人以“雨巷”为题，揭示内心的苦闷、惆怅以及对理想的渴望。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('37', 'ID532646814835277831', '诗人大量运用反复、排比等修辞手法，给人回味。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('38', 'ID532646814835277832', '诗人在《雨巷》中创造了一个丁香一样的结着愁怨的姑娘。这受中国古代诗词、\r\n的启发，用丁香结即丁香的花蕾来象征人的愁心。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('39', 'ID532646814835277832', '《雨巷》运用了象征的手法。诗中的“我”“雨巷”“姑娘”并非是对生活的具体写照，而是充满了象征意味的抒情形象。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('40', 'ID532646814835277832', '诗中借江南小巷的阴沉来象征当时社会的黑暗；“我”在黑暗中迷失了方向，\r\n找不到出路，充满了迷惘和绝望。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('41', 'ID532646814835277832', '《雨巷》运用了复杏重唱手法，造成了回环往复的旋律，强化了音乐效果。替\r\n新诗的音节开了一个新纪元。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('42', 'ID532646814835277833', '“夕阳下的新娘”，是说夕阳照射下的柳枝，镀上了一层妩媚的金色，那金色的枝条随风轻轻摇摆，影子倒映在水中，像一位美艳的新娘。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('43', 'ID532646814835277833', '“波光里的艳影，在我的心头荡漾”，倒映在水中的金柳，随波光一起荡漾，显得更加美艳，作者对如此美景，永远记在心上。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('44', 'ID532646814835277833', '“软泥上的青荇，油油的在水底招摇”，是说绿油油的水草在柔波中招摇，仿佛是在向诗人招手示意。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('45', 'ID532646814835277833', '“揉碎在浮藻间，沉淀着彩虹似的梦”，是说天上被操碎了的彩虹和漂浮在潭水上的水草相杂在一起，沉淀在潭水的深处，就如同彩虹似的梦一般。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('46', 'ID532646814835277834', '诗中笼罩着一种宁静、安谧的氛围，水草、柔波、彩虹、星辉，恰当地衬托了诗人静默的心境。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('47', 'ID532646814835277834', '诗人运用比喻、拟人、借代等修辞手法，写出了康桥那特有的优美景色，表达了自己那追梦般的思念之情。', null, null, null, '1', '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('48', 'ID532646814835277834', '.诗人把自己对母校的深情融进了悄悄别离时那富有特色的形象和想像中，形成了一种轻柔、明丽而又俊逸的格调。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('49', 'ID532646814835277834', '全诗四行一节，诗行排列错落有致，每句字数基本为六七字，于参差变化中见整齐；海节押一韵，黑现出明显的旋律感。', null, null, null, null, '168', null, '168', null);
INSERT INTO `issue_item` VALUES ('ID535177973192458240', 'ID535175632514973696', '222', '', '', '', '1', '517281575629488128', '2019-01-16 19:26:11', '', '2019-01-16 19:26:11');
INSERT INTO `issue_item` VALUES ('ID535177973234401280', 'ID535175632514973696', '33', '', '', '', '', '517281575629488128', '2019-01-16 19:26:11', '', '2019-01-16 19:26:11');
INSERT INTO `issue_item` VALUES ('ID535177973263761408', 'ID535175632514973696', '44', '', '', '', '', '517281575629488128', '2019-01-16 19:26:11', '', '2019-01-16 19:26:11');
INSERT INTO `issue_item` VALUES ('ID535178186921607168', 'ID535177973293121536', '33', '', '', '', '1', '517281575629488128', '2019-01-16 19:27:02', '', '2019-01-16 19:27:02');
INSERT INTO `issue_item` VALUES ('ID535178186955161600', 'ID535177973293121536', '44', '', '', '', '', '517281575629488128', '2019-01-16 19:27:02', '', '2019-01-16 19:27:02');
INSERT INTO `issue_item` VALUES ('ID535495116924649472', 'ID532645024467255296', '表现父亲爱子情深，对儿子放心不下。', '', '', '', '1', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495116962398208', 'ID532645024467255296', '表现出父亲的焦躁、不安', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495116983369728', 'ID532645024467255296', '表现出父亲年纪大了', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117012729856', 'ID532645024467255297', '南京并不好玩，所以不必多写。', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117029507072', 'ID532645024467255297', '南京是路过，不是目的地。', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117046284288', 'ID532645024467255297', '与文章主旨关系不大，应该略写。', '', '', '', '1', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117075644416', 'ID532646814835277824', '聪慧  丑陋', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117092421632', 'ID532646814835277824', '糊涂  动听', '', '', '', '1', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID535495117105004544', 'ID532646814835277824', '聪颖  精彩', '', '', '', '', '517281575629488128', '2019-01-17 16:26:24', '168', '2019-01-17 16:26:24');
INSERT INTO `issue_item` VALUES ('ID540660619007754240', 'ID540656937042182144', '上海', '', '', '', '1', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619028725760', 'ID540656937042182144', '北京', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619045502976', 'ID540656937042182144', '南昌', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619079057408', 'ID540660187896217600', '8~10分钟', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619271995392', 'ID540660187896217600', '40分钟以内', '', '', '', '1', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619288772608', 'ID540660187896217600', '8~30分钟', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619318132736', 'ID540660187988492288', '小男孩不听话', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619334909952', 'ID540660187988492288', '遇到了无法解决的新问题', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619351687168', 'ID540660187988492288', '希望小男孩能够根据他们的想法行动', '', '', '', '1', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619385241600', 'ID540660188089155584', '寻求爸爸和爷爷的帮助', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619402018816', 'ID540660188089155584', '敲碎大星星', '', '', '', '1', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619427184640', 'ID540660188089155584', '扫除大星星', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619481710592', 'ID540660188189818880', '《月神》', '', '', '', '1', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619498487808', 'ID540660188189818880', '《月光》', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540660619523653632', 'ID540660188189818880', '《月亮》', '', '', '', '', '168', '2019-01-31 22:32:16', '', '2019-01-31 22:32:16');
INSERT INTO `issue_item` VALUES ('ID540849239052255232', 'ID540849222807715840', '康塞尔', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239069032448', 'ID540849222807715840', '尼德兰', '', '', '', '1', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239085809664', 'ID540849222807715840', '阿龙纳斯', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239127752704', 'ID540849222904184832', '电', '', '', '', '1', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239148724224', 'ID540849222904184832', '太阳能', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239165501440', 'ID540849222904184832', '海水', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239194861568', 'ID540849222975488000', '225万', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239211638784', 'ID540849222975488000', '100万', '', '', '', '', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');
INSERT INTO `issue_item` VALUES ('ID540849239232610304', 'ID540849222975488000', '500万', '', '', '', '1', '168', '2019-02-01 11:01:47', '', '2019-02-01 11:01:47');

-- ----------------------------
-- Table structure for `lesson`
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  `simple_intro` varchar(500) DEFAULT NULL COMMENT '课程名称',
  `intro` text COMMENT '课程描述',
  `audio_intro` varchar(200) DEFAULT NULL COMMENT '课程音频介绍',
  `video_intro` varchar(200) DEFAULT NULL COMMENT '课程视频介绍',
  `image` varchar(200) DEFAULT NULL COMMENT '图片URL',
  `qr_code` varchar(100) DEFAULT NULL COMMENT '二维码',
  `banner` varchar(200) DEFAULT NULL COMMENT 'banner',
  `discount` varchar(30) DEFAULT NULL COMMENT '折扣',
  `tag` varchar(200) DEFAULT NULL COMMENT '标签',
  `original_price` varchar(50) DEFAULT NULL COMMENT '原价',
  `present_price` varchar(50) DEFAULT NULL COMMENT '现价',
  `expert_id` varchar(50) DEFAULT NULL COMMENT '专家id',
  `publish_status` varchar(6) DEFAULT NULL COMMENT '发布状态(0 未发布，1已发布)',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `visit_num` bigint(11) DEFAULT '0' COMMENT '访问数量',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程';

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('12', '字里行间', '浓缩20年汉字教学精髓，领略汉字文化的魅力！', '<img src=\'http://img.jssns.cn/SHILU/1/0ea35d43d7cf89272d3eb2832fcc5d5c.jpg\'/>', '', '', 'http://img.jssns.cn/SHILU/1/306a98f4dc31134fb1a2b60a36bdb61c.jpg', 'http://img.jssns.cn/SHILU/1/52699683001465201.png', 'http://img.jssns.cn/SHILU/1/afd35b72f727cbd95bf2c45ff117edb7.jpg', '', '汉字文化启蒙,3-8岁', '', '', '432228697144033280', '1', '1', '11', '446', '432228697144033280', null, '432228697144033280', '2019-04-24 15:59:51');
INSERT INTO `lesson` VALUES ('13', '我和陆陆玩汉字', '浓缩30年语文教学精髓，在亲子对话中启迪智慧！', '<img src=\'http://img.jssns.cn/SHILU/1/1795b0d0c43dc9bc4c214b9709817fd0.jpg\'/>', '', '', 'http://img.jssns.cn/SHILU/1/860c053ae75495763b13864c45b20cd4.png', 'http://img.jssns.cn/SHILU/1/53834522723565461.png', 'http://img.jssns.cn/SHILU/1/d77269ba23972af769334d683725a60f.png', '', '激发汉字兴趣,创新思维,6~12岁', '', '', '517353407590170624', '1', '1', '12', '143', '517353407590170624', '', '517353407590170624', '2019-05-07 19:13:51');

-- ----------------------------
-- Table structure for `media_counts`
-- ----------------------------
DROP TABLE IF EXISTS `media_counts`;
CREATE TABLE `media_counts` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `media_id` varchar(30) NOT NULL COMMENT '被播放ID',
  `media_type` varchar(30) NOT NULL COMMENT '播放类型',
  `clicked` varchar(10) DEFAULT NULL COMMENT '点击音频，未播放完成',
  `finished` varchar(10) DEFAULT NULL COMMENT '音频播放完成',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='统计播放量';

-- ----------------------------
-- Records of media_counts
-- ----------------------------
INSERT INTO `media_counts` VALUES ('ID527446416801398784', 'ID518128033970782208', 'audio', '5', '1', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527446478419918848', 'ID518136921315082240', 'audio', '4', '0', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527576709826871296', 'ID518098356564656128', 'audio', '1', '0', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527577370832404480', 'ID518137315487383552', 'audio', '6', '1', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527585667123773440', 'ID518137406327619584', 'audio', '1', '0', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527634275252568064', 'ID527180421717295104', 'audio', '1', '0', '2018-12-26');
INSERT INTO `media_counts` VALUES ('ID527817439350620160', 'ID518128033970782208', 'audio', '3', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID527835627744395264', 'ID518137315487383552', 'audio', '8', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID527878176387366912', 'ID518417172242890752', 'audio', '1', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID527896462277738496', 'ID518137166967078912', 'audio', '2', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID527904830815993856', 'ID518136921315082240', 'audio', '2', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID527969362305351680', 'ID518087482479214592', 'audio', '1', '0', '2018-12-27');
INSERT INTO `media_counts` VALUES ('ID528164460427214848', 'ID518092325025480704', 'audio', '1', '1', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528165826176483328', 'ID518098356564656128', 'audio', '2', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528220106531012608', 'ID518137501840310272', 'audio', '1', '1', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528223275566759936', 'ID518417172242890752', 'audio', '1', '1', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528227291315044352', 'ID518418068611792896', 'audio', '1', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528291652729569280', 'ID525680320045907968', 'audio', '3', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528330106125418496', 'ID518137166967078912', 'audio', '1', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528342507449221120', 'ID518136921315082240', 'audio', '1', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528342684364963840', 'ID518137315487383552', 'audio', '1', '0', '2018-12-28');
INSERT INTO `media_counts` VALUES ('ID528504563435569152', 'ID518083290419167232', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528505115355643904', 'ID518097240917540864', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528520509889970176', 'ID518137315487383552', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528520887515742208', 'ID518128033970782208', 'audio', '3', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528521253665898496', 'ID518137166967078912', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528524619733270528', 'ID518098356564656128', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528531388844998656', 'ID518136921315082240', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528545751387602944', 'ID525680320045907968', 'audio', '2', '1', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528669166744371200', 'ID520180836125900800', 'audio', '1', '0', '2018-12-29');
INSERT INTO `media_counts` VALUES ('ID528913887957876736', 'ID518098356564656128', 'audio', '2', '0', '2018-12-30');
INSERT INTO `media_counts` VALUES ('ID528917996656132096', 'ID518137406327619584', 'audio', '2', '0', '2018-12-30');
INSERT INTO `media_counts` VALUES ('ID528920643974987776', 'ID527180421717295104', 'audio', '1', '0', '2018-12-30');
INSERT INTO `media_counts` VALUES ('ID529012054023995392', 'ID518128033970782208', 'audio', '2', '0', '2018-12-30');
INSERT INTO `media_counts` VALUES ('ID529017357817872384', 'ID518137315487383552', 'audio', '1', '0', '2018-12-30');
INSERT INTO `media_counts` VALUES ('ID529278030695104512', 'ID518128033970782208', 'audio', '1', '0', '2018-12-31');
INSERT INTO `media_counts` VALUES ('ID529598830539177984', 'ID525686848677216256', 'audio', '1', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529598871064543232', 'ID529380122512326656', 'audio', '1', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529626031242346496', 'ID519448959479971840', 'audio', '1', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529626686493294592', 'ID518424324789501952', 'audio', '1', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529627624641658880', 'ID519446741330690048', 'audio', '3', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529652723121913856', 'ID529652308217167872', 'audio', '3', '1', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529656146198265856', 'ID527180801658322944', 'audio', '1', '0', '2019-01-01');
INSERT INTO `media_counts` VALUES ('ID529974157555793920', 'ID518092325025480704', 'audio', '2', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530034485031337984', 'ID529392370534318080', 'audio', '4', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530061319504658432', 'ID518128033970782208', 'audio', '2', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530061809806213120', 'ID518136921315082240', 'audio', '3', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530068874725425152', 'ID518098356564656128', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530069618794954752', 'ID518098925983367168', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530070886397509632', 'ID518424324789501952', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530071882989305856', 'ID518099783953416192', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530072886925328384', 'ID518101884913844224', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530074022486999040', 'ID518103250356928512', 'audio', '1', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530078803414745088', 'ID530070521719554048', 'audio', '3', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530078964517961728', 'ID530072803815194624', 'audio', '9', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530096888913854464', 'ID530080891918090240', 'audio', '2', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530103902016634880', 'ID530078929201922048', 'audio', '2', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530111928119328768', 'ID518430406542884864', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530122235415887872', 'ID518095629965066240', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530123575315660800', 'ID518096933240176640', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530124677025103872', 'ID518449187038167040', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530125775316189184', 'ID530081588499709952', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530125791812386816', 'ID520184891380334592', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530126821849563136', 'ID518098057879879680', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530128220754804736', 'ID529380122512326656', 'audio', '2', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530128317433511936', 'ID518449521076731904', 'audio', '1', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530129407537315840', 'ID530082488131780608', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530132279121412096', 'ID530085120019791872', 'audio', '1', '1', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530134475640668160', 'ID527180801658322944', 'audio', '1', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530134529235484672', 'ID529652308217167872', 'audio', '1', '0', '2019-01-02');
INSERT INTO `media_counts` VALUES ('ID530311855185330176', 'ID518098925983367168', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530312662827925504', 'ID518092325025480704', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530351676045918208', 'ID518136921315082240', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530353290446110720', 'ID518083290419167232', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530404721840619520', 'ID530082488131780608', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530423108398481408', 'ID518101884913844224', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530423155622150144', 'ID525680320045907968', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530423561748217856', 'ID518098356564656128', 'audio', '3', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530423575027384320', 'ID529392370534318080', 'audio', '4', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530445686307553280', 'ID518417670446514176', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530458202454622208', 'ID529652308217167872', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530458324836024320', 'ID527180801658322944', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530462526756880384', 'ID518128033970782208', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530464317208788992', 'ID518424324789501952', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530482966611099648', 'ID518137315487383552', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530485193811689472', 'ID518137166967078912', 'audio', '2', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530521444568793088', 'ID530342530588344320', 'audio', '1', '0', '2019-01-03');
INSERT INTO `media_counts` VALUES ('ID530638693623398400', 'ID530074431402278912', 'audio', '14', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530639717033574400', 'ID530438574764457984', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530640539591114752', 'ID530078929201922048', 'audio', '6', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530640773658443776', 'ID518417172242890752', 'audio', '4', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530641031364870144', 'ID518418068611792896', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530641151342936064', 'ID518089984079560704', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530641725492822016', 'ID518107379900874752', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530642137243451392', 'ID518089575046840320', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530642242268823552', 'ID518098925983367168', 'audio', '2', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530644429682245632', 'ID529392370534318080', 'audio', '6', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530644608665780224', 'ID518087482479214592', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530647058558746624', 'ID518092325025480704', 'audio', '4', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530647196660400128', 'ID530070521719554048', 'audio', '4', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530649003176493056', 'ID518083290419167232', 'audio', '4', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530674640389931008', 'ID530398186003496960', 'audio', '8', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530683039194284032', 'ID529380122512326656', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530684779301961728', 'ID518083668560838656', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530695862402154496', 'ID518098356564656128', 'audio', '2', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530698925569474560', 'ID518137166967078912', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530702414320238592', 'ID518137315487383552', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530705972964884480', 'ID518424324789501952', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530706239827476480', 'ID518137406327619584', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530706972496887808', 'ID518099783953416192', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530707924473872384', 'ID518128033970782208', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530707978647502848', 'ID518101884913844224', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530708032628195328', 'ID521698898528436224', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530708570828701696', 'ID518137501840310272', 'audio', '1', '1', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530709124657184768', 'ID518103250356928512', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530710903637671936', 'ID518090756984930304', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530719201690648576', 'ID518095629965066240', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530764005191450624', 'ID519448959479971840', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530775234425389056', 'ID518136921315082240', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530790333294837760', 'ID530072803815194624', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530790398608539648', 'ID530342537714466816', 'audio', '5', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530790789458952192', 'ID530080891918090240', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530791631276736512', 'ID530081588499709952', 'audio', '2', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID530819172087627776', 'ID518097240917540864', 'audio', '1', '0', '2019-01-04');
INSERT INTO `media_counts` VALUES ('ID531020016309501952', 'ID518424324789501952', 'audio', '3', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531020513137393664', 'ID518098925983367168', 'audio', '4', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531021573155454976', 'ID518099783953416192', 'audio', '1', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531022578005835776', 'ID518101884913844224', 'audio', '1', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531023716562239488', 'ID518103250356928512', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531031141088493568', 'ID529392370534318080', 'audio', '14', '2', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531035447741120512', 'ID518092325025480704', 'audio', '7', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531036526813904896', 'ID518128033970782208', 'audio', '5', '2', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531038129981751296', 'ID518136921315082240', 'audio', '5', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531041111129456640', 'ID518137166967078912', 'audio', '1', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531042367579357184', 'ID518087482479214592', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531043783232454656', 'ID518137315487383552', 'audio', '3', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531043839381602304', 'ID518137406327619584', 'audio', '3', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531043855315763200', 'ID518137501840310272', 'audio', '2', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531043892288552960', 'ID518417172242890752', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054151040237568', 'ID529380122512326656', 'audio', '6', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054219516444672', 'ID525680320045907968', 'audio', '3', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054222108524544', 'ID518098356564656128', 'audio', '7', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054243524640768', 'ID530082488131780608', 'audio', '5', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054518083780608', 'ID527180801658322944', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531054650665730048', 'ID518087104530481152', 'audio', '3', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531055036147433472', 'ID518089984079560704', 'audio', '1', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531056617513287680', 'ID518090756984930304', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531060716510117888', 'ID518104967974748160', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531060879144255488', 'ID518087803364442112', 'audio', '3', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531061580851314688', 'ID518096552670003200', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531062423126278144', 'ID518083290419167232', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531131096566333440', 'ID529652308217167872', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531165895960035328', 'ID530070521719554048', 'audio', '1', '1', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531166133831598080', 'ID530072803815194624', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531166352107372544', 'ID530074431402278912', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531166440233893888', 'ID530085120019791872', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531166556520972288', 'ID530078929201922048', 'audio', '12', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531178434882174976', 'ID518083668560838656', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531180179985268736', 'ID530438574764457984', 'audio', '2', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531182133683683328', 'ID530342537714466816', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531182975807651840', 'ID530395582259265536', 'audio', '1', '0', '2019-01-05');
INSERT INTO `media_counts` VALUES ('ID531387811668951040', 'ID529392370534318080', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531387969299283968', 'ID529380122512326656', 'audio', '1', '1', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531389194279321600', 'ID525680320045907968', 'audio', '2', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531394378581671936', 'ID530070521719554048', 'audio', '5', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531414355015630848', 'ID518083290419167232', 'audio', '1', '1', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531415820035686400', 'ID518083668560838656', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531433544237449216', 'ID518136921315082240', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531478605176242176', 'ID518092325025480704', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531479447828692992', 'ID518087803364442112', 'audio', '3', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531527262948818944', 'ID518096933240176640', 'audio', '2', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531528347084128256', 'ID525686848677216256', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531528665645711360', 'ID520180836125900800', 'audio', '2', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531528690572460032', 'ID518096552670003200', 'audio', '2', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531528789885190144', 'ID527180801658322944', 'audio', '1', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531559097464520704', 'ID529652308217167872', 'audio', '3', '0', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531576555319590912', 'ID531530617293111296', 'audio', '1', '1', '2019-01-06');
INSERT INTO `media_counts` VALUES ('ID531761061422956544', 'ID518098925983367168', 'audio', '2', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531772669360603136', 'ID530078929201922048', 'audio', '4', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531777078870147072', 'ID530080891918090240', 'audio', '2', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531777088579960832', 'ID530081588499709952', 'audio', '4', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531780721920966656', 'ID530082488131780608', 'audio', '1', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531783594163568640', 'ID530085120019791872', 'audio', '1', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531785556263174144', 'ID530328736772390912', 'audio', '1', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531787476809809920', 'ID530342530588344320', 'audio', '1', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531789633684504576', 'ID530342537714466816', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531789907509641216', 'ID530395582259265536', 'audio', '2', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531791879868514304', 'ID530398186003496960', 'audio', '4', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531793805309902848', 'ID530438574764457984', 'audio', '7', '3', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531797808542384128', 'ID518092325025480704', 'audio', '4', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531798229621145600', 'ID518083290419167232', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531798781809655808', 'ID527180801658322944', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531799332421107712', 'ID530074431402278912', 'audio', '6', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531799434258808832', 'ID530070521719554048', 'audio', '11', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531862802235654144', 'ID529392370534318080', 'audio', '4', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531862957282295808', 'ID525680320045907968', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531863132897804288', 'ID518137166967078912', 'audio', '2', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531890130634407936', 'ID518087803364442112', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531903628881952768', 'ID518449521076731904', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531903698775834624', 'ID530072803815194624', 'audio', '6', '1', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531917920016531456', 'ID518136921315082240', 'audio', '1', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531921389226033152', 'ID518098356564656128', 'audio', '3', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531922004073250816', 'ID531530446631075840', 'audio', '2', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID531922504214642688', 'ID529380122512326656', 'audio', '4', '0', '2019-01-07');
INSERT INTO `media_counts` VALUES ('ID532177953698611200', 'ID518087803364442112', 'audio', '1', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532178316203917312', 'ID530070521719554048', 'audio', '2', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532241714694324224', 'ID527180801658322944', 'audio', '1', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532259541585231872', 'ID530074431402278912', 'audio', '1', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532276537089589248', 'ID529652308217167872', 'audio', '1', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532308056046829568', 'ID520180836125900800', 'audio', '2', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532310100505788416', 'ID518449187038167040', 'audio', '2', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532311408306552832', 'ID524909182437031936', 'audio', '1', '0', '2019-01-08');
INSERT INTO `media_counts` VALUES ('ID532491369411772416', 'ID530074431402278912', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532491462164611072', 'ID531530446631075840', 'audio', '3', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532501876206206976', 'ID532501576867119104', 'audio', '14', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532502530391801856', 'ID524909182437031936', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532502868356235264', 'ID518090756984930304', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532504726143500288', 'ID518083668560838656', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532509330369413120', 'ID518083290419167232', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532543510419603456', 'ID527180801658322944', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532625544701804544', 'ID519454529536655360', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532652946001756160', 'ID532516960567558144', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532665118874402816', 'ID529392370534318080', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532672108795265024', 'ID529380122512326656', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532674160048996352', 'ID531530617293111296', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532675256955961344', 'ID525680320045907968', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532676763617067008', 'ID520180836125900800', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532678147175350272', 'ID525686848677216256', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532679353171968000', 'ID518087803364442112', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532680320542048256', 'ID518096552670003200', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532681440635125760', 'ID518097240917540864', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532683012777705472', 'ID518450921814884352', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532684125392338944', 'ID518095629965066240', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532685466214858752', 'ID518096933240176640', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532686567093829632', 'ID518449187038167040', 'audio', '1', '1', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532687680501186560', 'ID520184891380334592', 'audio', '1', '0', '2019-01-09');
INSERT INTO `media_counts` VALUES ('ID532838630570328064', 'ID530074431402278912', 'audio', '1', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID532862765396656128', 'ID518137166967078912', 'audio', '1', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID532862975153799168', 'ID518418068611792896', 'audio', '1', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID532891517006643200', 'ID529380122512326656', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID532938206396547072', 'ID518136921315082240', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID532938271970295808', 'ID518417172242890752', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533000103846215680', 'ID518137315487383552', 'audio', '1', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533017887724535808', 'ID530070521719554048', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533032712668184576', 'ID525680320045907968', 'audio', '3', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533032747388633088', 'ID520180836125900800', 'audio', '3', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533032761074647040', 'ID525686848677216256', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533032766107811840', 'ID518087803364442112', 'audio', '3', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533032818477891584', 'ID518096552670003200', 'audio', '4', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533033088087752704', 'ID518097240917540864', 'audio', '3', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533034277051301888', 'ID518450921814884352', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533034345712058368', 'ID518095629965066240', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533034347964399616', 'ID518096933240176640', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533034459981676544', 'ID518449187038167040', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533034489190809600', 'ID520184891380334592', 'audio', '3', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533036326421790720', 'ID518098057879879680', 'audio', '2', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533037004321980416', 'ID518449521076731904', 'audio', '2', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533037071183380480', 'ID518081228029558784', 'audio', '3', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533037113910755328', 'ID531530617293111296', 'audio', '3', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533040052771487744', 'ID518126692514922496', 'audio', '1', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533041342511579136', 'ID518096019230031872', 'audio', '1', '1', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533042775420043264', 'ID532510358569484288', 'audio', '1', '0', '2019-01-10');
INSERT INTO `media_counts` VALUES ('ID533241082436124672', 'ID518417172242890752', 'audio', '1', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533300883224526848', 'ID518098925983367168', 'audio', '3', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533300923661811712', 'ID518103250356928512', 'audio', '2', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533309581305053184', 'ID524909182437031936', 'audio', '1', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533329592362991616', 'ID533211149080985600', 'audio', '4', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533329653604024320', 'ID533207912613412864', 'audio', '3', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533329676559450112', 'ID533210403841245184', 'audio', '3', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533330020580458496', 'ID533210908713811968', 'audio', '1', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533330035566706688', 'ID533211351149969408', 'audio', '2', '0', '2019-01-11');
INSERT INTO `media_counts` VALUES ('ID533443836479799296', 'ID530070521719554048', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533547744661340160', 'ID529380122512326656', 'audio', '3', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533548975232385024', 'ID531530446631075840', 'audio', '2', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533549804383371264', 'ID531530617293111296', 'audio', '4', '2', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533550891786043392', 'ID525680320045907968', 'audio', '4', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533552396249333760', 'ID520180836125900800', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533553778519965696', 'ID525686848677216256', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533554635181391872', 'ID518092325025480704', 'audio', '2', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533556004038639616', 'ID518098356564656128', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533556750217904128', 'ID518098925983367168', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533558024145469440', 'ID518424324789501952', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533559021978779648', 'ID518099783953416192', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533560025243713536', 'ID518101884913844224', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533561161992372224', 'ID518103250356928512', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533562516735787008', 'ID518104967974748160', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533563909597036544', 'ID518107379900874752', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533565172434862080', 'ID518118251692032000', 'audio', '1', '1', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533566472815902720', 'ID518429063644184576', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533596043556683776', 'ID530072803815194624', 'audio', '4', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533602790480543744', 'ID524909182437031936', 'audio', '2', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533605392144400384', 'ID529652308217167872', 'audio', '6', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533609838437990400', 'ID533207912613412864', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533609909808267264', 'ID533210403841245184', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533611501739573248', 'ID533605795837771776', 'audio', '2', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533620325380784128', 'ID533620189401448448', 'audio', '4', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533620376735842304', 'ID518087803364442112', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533680383548456960', 'ID529392370534318080', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533680514389770240', 'ID530074431402278912', 'audio', '1', '0', '2019-01-12');
INSERT INTO `media_counts` VALUES ('ID533995872472530944', 'ID529392370534318080', 'audio', '1', '0', '2019-01-13');
INSERT INTO `media_counts` VALUES ('ID534011035061846016', 'ID529380122512326656', 'audio', '1', '0', '2019-01-13');
INSERT INTO `media_counts` VALUES ('ID534275023293120512', 'ID533207912613412864', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534275135436226560', 'ID530078929201922048', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534275232043630592', 'ID518137501840310272', 'audio', '2', '1', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534275285235793920', 'ID518417172242890752', 'audio', '2', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534275426420260864', 'ID519450551428055040', 'audio', '1', '1', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534277409428471808', 'ID519448959479971840', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534319251654180864', 'ID529392370534318080', 'audio', '7', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534319311917940736', 'ID518128033970782208', 'audio', '6', '2', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534347287711711232', 'ID518136921315082240', 'audio', '3', '2', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534350263260020736', 'ID518137166967078912', 'audio', '2', '1', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534353747430604800', 'ID518137315487383552', 'audio', '1', '1', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534357573852200960', 'ID518137406327619584', 'audio', '1', '1', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534399841908817920', 'ID518092325025480704', 'audio', '2', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534401928856076288', 'ID534401259780702208', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534427130218414080', 'ID518098925983367168', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534429462008168448', 'ID533605795837771776', 'audio', '2', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534429596091678720', 'ID531530446631075840', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534429824580583424', 'ID525686848677216256', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534431223729094656', 'ID518083290419167232', 'audio', '2', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534431366708723712', 'ID519454529536655360', 'audio', '5', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534431627225333760', 'ID520176596611497984', 'audio', '2', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534434230453665792', 'ID518083668560838656', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534434259511803904', 'ID518087975544815616', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534434320111108096', 'ID524909182437031936', 'audio', '1', '0', '2019-01-14');
INSERT INTO `media_counts` VALUES ('ID534541417926623232', 'ID529392370534318080', 'audio', '4', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534541859507142656', 'ID518128033970782208', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534740871422148608', 'ID518136921315082240', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534825451370053632', 'ID518137406327619584', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534825525009448960', 'ID534414899401457664', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534826548813889536', 'ID519454529536655360', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534855749612863488', 'ID518418068611792896', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534856442092453888', 'ID518137315487383552', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534856511533350912', 'ID530438574764457984', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534856797643603968', 'ID533620189401448448', 'audio', '2', '2', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534857906244288512', 'ID518092325025480704', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534857915341733888', 'ID532501576867119104', 'audio', '2', '1', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534857953732198400', 'ID525680320045907968', 'audio', '2', '1', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534858227012075520', 'ID518103250356928512', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534858674825330688', 'ID519446741330690048', 'audio', '1', '1', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534859160597037056', 'ID518083290419167232', 'audio', '2', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534859560716861440', 'ID518118251692032000', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534860471975542784', 'ID524909182437031936', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534860696660213760', 'ID518089575046840320', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534861243341602816', 'ID533605795837771776', 'audio', '1', '1', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID534863115171397632', 'ID520180836125900800', 'audio', '1', '0', '2019-01-15');
INSERT INTO `media_counts` VALUES ('ID535057445303615488', 'ID530074431402278912', 'audio', '3', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535058266460258304', 'ID518137501840310272', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535059151642951680', 'ID518128033970782208', 'audio', '13', '2', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535060221635067904', 'ID518417486404648960', 'audio', '2', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535060755062456320', 'ID521698898528436224', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535060810901225472', 'ID518137166967078912', 'audio', '3', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535062643732381696', 'ID518136921315082240', 'audio', '3', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535063858830639104', 'ID518137315487383552', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535065536321552384', 'ID518417172242890752', 'audio', '3', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535066963139887104', 'ID518418068611792896', 'audio', '3', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535067011189833728', 'ID529392370534318080', 'audio', '3', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535168155337621504', 'ID519450551428055040', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535170241148223488', 'ID530078929201922048', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535170271728893952', 'ID534414899401457664', 'audio', '1', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535172400338173952', 'ID534415222690021376', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535197838745796608', 'ID535153697299103744', 'audio', '6', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535202466845687808', 'ID518092325025480704', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535202702854979584', 'ID518099783953416192', 'audio', '1', '1', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535203704974868480', 'ID518101884913844224', 'audio', '1', '0', '2019-01-16');
INSERT INTO `media_counts` VALUES ('ID535274779213561856', 'ID518089540838096896', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535356335881977856', 'ID535153697299103744', 'audio', '17', '6', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535361496020942848', 'ID527180801658322944', 'audio', '2', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535365052518105088', 'ID533620189401448448', 'audio', '4', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535372967425605632', 'ID525680320045907968', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535385571623698432', 'ID518418068611792896', 'audio', '3', '2', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535386925440172032', 'ID534414899401457664', 'audio', '4', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535387031077912576', 'ID534401259780702208', 'audio', '3', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535387155464192000', 'ID532501576867119104', 'audio', '6', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535390791401472000', 'ID524909182437031936', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535393474522906624', 'ID518417486404648960', 'audio', '2', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535402328182751232', 'ID535385304635277312', 'audio', '6', '3', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535405582174126080', 'ID529652308217167872', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535412337662754816', 'ID533207912613412864', 'audio', '3', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535424454931513344', 'ID529392370534318080', 'audio', '2', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535424469687074816', 'ID518128033970782208', 'audio', '3', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535424488351727616', 'ID518136921315082240', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535462925997965312', 'ID519446741330690048', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535463409978703872', 'ID518083290419167232', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535464786528305152', 'ID518083668560838656', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535465981091250176', 'ID518087104530481152', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535467834419970048', 'ID518087482479214592', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535470582783803392', 'ID534415222690021376', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535474635865587712', 'ID535472983561469952', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535479070163468288', 'ID533210403841245184', 'audio', '2', '2', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535481414997508096', 'ID533210908713811968', 'audio', '3', '2', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535483995215888384', 'ID533211149080985600', 'audio', '2', '2', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535485927997308928', 'ID533211351149969408', 'audio', '2', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535539922455494656', 'ID535476360655667200', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535543524737679360', 'ID535487247672147968', 'audio', '2', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535545493518811136', 'ID535489560918884352', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535548496011329536', 'ID518101884913844224', 'audio', '1', '0', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535551646319509504', 'ID530078929201922048', 'audio', '1', '1', '2019-01-17');
INSERT INTO `media_counts` VALUES ('ID535722340877598720', 'ID529392370534318080', 'audio', '2', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535722383491727360', 'ID518417670446514176', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535725180782116864', 'ID518128033970782208', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535731564764463104', 'ID535153697299103744', 'audio', '2', '1', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535762447907160064', 'ID535385304635277312', 'audio', '2', '1', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535777196875186176', 'ID535777043741147136', 'audio', '7', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535787555719741440', 'ID533620189401448448', 'audio', '2', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535800193707147264', 'ID518417486404648960', 'audio', '3', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535841247953158144', 'ID518136921315082240', 'audio', '2', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535842591598444544', 'ID518137166967078912', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535862765428932608', 'ID519448959479971840', 'audio', '2', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535863217017061376', 'ID518089984079560704', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535864045580845056', 'ID532514201436946432', 'audio', '2', '1', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535865411242033152', 'ID532515777736081408', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535871701330690048', 'ID518103250356928512', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535909424322052096', 'ID534404740755226624', 'audio', '1', '0', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID535912992080920576', 'ID530074431402278912', 'audio', '1', '1', '2019-01-18');
INSERT INTO `media_counts` VALUES ('ID536169700069998592', 'ID532501576867119104', 'audio', '1', '0', '2019-01-19');
INSERT INTO `media_counts` VALUES ('ID536176002921922560', 'ID525680320045907968', 'audio', '1', '0', '2019-01-19');
INSERT INTO `media_counts` VALUES ('ID536220104610807808', 'ID518128033970782208', 'audio', '1', '0', '2019-01-19');
INSERT INTO `media_counts` VALUES ('ID536484443402010624', 'ID535153697299103744', 'audio', '1', '1', '2019-01-20');
INSERT INTO `media_counts` VALUES ('ID536491410111594496', 'ID518095629965066240', 'audio', '2', '0', '2019-01-20');
INSERT INTO `media_counts` VALUES ('ID536658531663740928', 'ID518128033970782208', 'audio', '1', '0', '2019-01-20');
INSERT INTO `media_counts` VALUES ('ID536822459286945792', 'ID535153697299103744', 'audio', '10', '3', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536824231682375680', 'ID535385304635277312', 'audio', '4', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536824505503318016', 'ID518137315487383552', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536844557996785664', 'ID518098925983367168', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536844693703491584', 'ID518103250356928512', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536844792848449536', 'ID518107379900874752', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536845799808565248', 'ID518118251692032000', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536846911869550592', 'ID529392370534318080', 'audio', '6', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536847106309095424', 'ID518429063644184576', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536848241656856576', 'ID518418068611792896', 'audio', '4', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536857036680331264', 'ID518128033970782208', 'audio', '2', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536911201867661312', 'ID535487247672147968', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536924963005792256', 'ID532501441474985984', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536924996828659712', 'ID532501576867119104', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536925262755921920', 'ID521698898528436224', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536925540699865088', 'ID533620189401448448', 'audio', '2', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536929071108456448', 'ID529380122512326656', 'audio', '3', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID536993739852218368', 'ID518092325025480704', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537044731222294528', 'ID525680320045907968', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537046239020056576', 'ID533605795837771776', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537048488395931648', 'ID520180836125900800', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537049875573899264', 'ID525686848677216256', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537052307703988224', 'ID518087803364442112', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537053276307193856', 'ID531530446631075840', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537054106854883328', 'ID518096552670003200', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537055228688596992', 'ID518097240917540864', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537056797593174016', 'ID531530617293111296', 'audio', '1', '1', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537057888330317824', 'ID518450921814884352', 'audio', '1', '0', '2019-01-21');
INSERT INTO `media_counts` VALUES ('ID537058995106480128', 'ID518450921814884352', 'audio', '0', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537058995517521920', 'ID518095629965066240', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537060350034444288', 'ID518096933240176640', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537061545788571648', 'ID518449187038167040', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537062553365250048', 'ID520184891380334592', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537063582974607360', 'ID518098057879879680', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537170065162764288', 'ID535385304635277312', 'audio', '59', '4', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537173623316676608', 'ID535153697299103744', 'audio', '123', '5', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537245366471360512', 'ID518092325025480704', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537359865157255168', 'undefined', 'audio', '4', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376158065360896', 'ID529392370534318080', 'audio', '2', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376184460115968', 'ID518128033970782208', 'audio', '3', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376190919344128', 'ID518136921315082240', 'audio', '4', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376202365599744', 'ID518137166967078912', 'audio', '2', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376228928126976', 'ID521698898528436224', 'audio', '2', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376311862099968', 'ID518137315487383552', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376321781628928', 'ID518137406327619584', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376330937794560', 'ID518137501840310272', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376338357518336', 'ID518417172242890752', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376346158923776', 'ID518418068611792896', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376354631417856', 'ID518417486404648960', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376364504809472', 'ID518417670446514176', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537376381034561536', 'ID521699097439109120', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537401761942470656', 'ID533620189401448448', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537402635456610304', 'ID520180836125900800', 'audio', '2', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537403058045321216', 'ID525686848677216256', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537404280835932160', 'ID529380122512326656', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537405534110744576', 'ID518087803364442112', 'audio', '1', '1', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537406450759106560', 'ID531530446631075840', 'audio', '1', '0', '2019-01-22');
INSERT INTO `media_counts` VALUES ('ID537563076614946816', 'ID535153697299103744', 'audio', '42', '3', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537570319234236416', 'ID518128033970782208', 'audio', '4', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537570345234726912', 'ID529392370534318080', 'audio', '14', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571901149544448', 'ID518418068611792896', 'audio', '4', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571906803466240', 'ID518417172242890752', 'audio', '2', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571931340144640', 'ID518417486404648960', 'audio', '4', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571938512404480', 'ID518417670446514176', 'audio', '6', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571952085172224', 'ID521698898528436224', 'audio', '5', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537571959957880832', 'ID521699097439109120', 'audio', '3', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537573982212194304', 'ID518137501840310272', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537573987077586944', 'ID518137406327619584', 'audio', '4', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537573994107240448', 'ID518137315487383552', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537574002902695936', 'ID518137166967078912', 'audio', '2', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537574009630359552', 'ID518136921315082240', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537581752864997376', 'ID537561196815974400', 'audio', '10', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537638177158987776', 'ID518098925983367168', 'audio', '3', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537638276576575488', 'ID535385304635277312', 'audio', '12', '2', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537651585212219392', 'ID518092325025480704', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537657563466956800', 'ID536928804895981568', 'audio', '5', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537657996948275200', 'ID536931748764712960', 'audio', '5', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658325043511296', 'ID533605795837771776', 'audio', '6', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658367791857664', 'ID533620189401448448', 'audio', '3', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658410074636288', 'ID520180836125900800', 'audio', '3', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658454597173248', 'ID525686848677216256', 'audio', '3', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658636730630144', 'ID537657125153800192', 'audio', '4', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537658704611246080', 'ID525680320045907968', 'audio', '3', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537666224918626304', 'ID518099783953416192', 'audio', '2', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537666277041242112', 'ID537651492618764288', 'audio', '5', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537687080545812480', 'ID537656827878309888', 'audio', '3', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537688068086300672', 'ID537650488993120256', 'audio', '7', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537690060460392448', 'ID518098356564656128', 'audio', '4', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537693705088270336', 'ID529380122512326656', 'audio', '2', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537693782032777216', 'ID518096019230031872', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537693816673533952', 'ID531530446631075840', 'audio', '2', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537762078262296576', 'ID518086312704606208', 'audio', '1', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537762208302497792', 'ID518449521076731904', 'audio', '2', '1', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537762250123902976', 'ID518098057879879680', 'audio', '3', '0', '2019-01-23');
INSERT INTO `media_counts` VALUES ('ID537917173381726208', 'ID536931748764712960', 'audio', '2', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537917804532203520', 'ID537561196815974400', 'audio', '3', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537917822886477824', 'ID518098925983367168', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537923028789493760', 'ID537922955988959232', 'audio', '4', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537923065053446144', 'ID532501576867119104', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537923087383920640', 'ID524909182437031936', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537923106698690560', 'ID519454529536655360', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537923179838963712', 'ID535153697299103744', 'audio', '17', '2', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537924398271692800', 'ID535385304635277312', 'audio', '18', '2', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537937694961958912', 'ID537934717702373376', 'audio', '16', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537941557043527680', 'undefined', 'audio', '2', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537943995683176448', 'ID537937799890862080', 'audio', '17', '3', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537946423719624704', 'ID518098356564656128', 'audio', '3', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537963632726638592', 'ID529392370534318080', 'audio', '6', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID537997402884276224', 'ID530072803815194624', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538009107496435712', 'ID538008341738160128', 'audio', '2', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538043994622394368', 'ID537650488993120256', 'audio', '3', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538072531643400192', 'ID518137315487383552', 'audio', '2', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538077964043026432', '131231231', 'audio', '7', '1', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538106249238020096', 'ID518417486404648960', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538118591170478080', 'ID518083668560838656', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538118701409370112', 'ID518126692514922496', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538120366317371392', 'ID531530446631075840', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538121468005842944', 'ID518137166967078912', 'audio', '1', '0', '2019-01-24');
INSERT INTO `media_counts` VALUES ('ID538280002546827264', 'ID537561196815974400', 'audio', '5', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538292249839009792', 'ID518137166967078912', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538292630119776256', 'ID519450551428055040', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538295476886175744', 'ID518128033970782208', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538295482099695616', 'ID518136921315082240', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538295516769812480', 'ID529392370534318080', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538295539456802816', 'ID518418068611792896', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538295884257951744', '131231231', 'audio', '2', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538301047630725120', 'ID535385304635277312', 'audio', '3', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538302333889544192', 'ID535153697299103744', 'audio', '2', '1', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538302461551575040', 'ID537937799890862080', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538367854811021312', 'ID537922955988959232', 'audio', '3', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538368044682969088', 'ID535777043741147136', 'audio', '4', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538378165114896384', 'ID518430406542884864', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538391639337467904', 'ID538378337517568000', 'audio', '2', '1', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538399304499331072', 'ID537650488993120256', 'audio', '7', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538400291125460992', 'ID537651492618764288', 'audio', '3', '1', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538400296297037824', 'ID537656827878309888', 'audio', '2', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538403008292061184', 'ID538380120281317376', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538422484483964928', 'ID538380303387852800', 'audio', '2', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538431530888855552', 'ID537934717702373376', 'audio', '2', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538438613973598208', 'ID524909182437031936', 'audio', '3', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538444778589650944', 'ID536931748764712960', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538445006881423360', 'ID538380538935771136', 'audio', '1', '0', '2019-01-25');
INSERT INTO `media_counts` VALUES ('ID538622231131979776', 'ID525680320045907968', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538622252120276992', 'ID533605795837771776', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538649570121351168', 'ID537922955988959232', 'audio', '4', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538650981806637056', 'ID538380120281317376', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538651003025620992', 'ID538380303387852800', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538651105383415808', 'ID537937799890862080', 'audio', '3', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538651214120747008', 'ID537657125153800192', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538746731861377024', 'ID537651492618764288', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538747034706903040', 'ID521698898528436224', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538748980415168512', 'ID529392370534318080', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538778521032458240', 'ID532501576867119104', 'audio', '2', '1', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538781293895221248', 'ID524909182437031936', 'audio', '1', '1', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538783079389462528', 'ID520176596611497984', 'audio', '1', '1', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538784838061129728', 'ID519454529536655360', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538821905071734784', 'ID538380538935771136', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538822063796781056', 'ID538783862449242112', 'audio', '1', '1', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID538825232958357504', '131231231', 'audio', '1', '0', '2019-01-26');
INSERT INTO `media_counts` VALUES ('ID539158328987615232', 'ID537561196815974400', 'audio', '1', '0', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539158363938750464', 'ID537651492618764288', 'audio', '2', '1', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539159920025534464', 'ID538378337517568000', 'audio', '4', '0', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539161097769320448', 'ID538380120281317376', 'audio', '2', '1', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539162820286087168', 'ID538380303387852800', 'audio', '2', '1', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539163717330272256', 'ID538380538935771136', 'audio', '3', '1', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539165041681760256', 'ID518092325025480704', 'audio', '2', '0', '2019-01-27');
INSERT INTO `media_counts` VALUES ('ID539415344771497984', 'ID521698898528436224', 'audio', '2', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539415889636753408', 'ID538380538935771136', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539417082891075584', 'ID518092325025480704', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539418443741396992', 'ID518098356564656128', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539419189413150720', 'ID518098925983367168', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539420466645827584', 'ID518424324789501952', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539421465485770752', 'ID518099783953416192', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539422470998851584', 'ID518101884913844224', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539423609186156544', 'ID518103250356928512', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539449202896273408', 'ID535153697299103744', 'audio', '10', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539454112865976320', 'ID539453671897825280', 'audio', '4', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539455402887086080', 'ID537934717702373376', 'audio', '6', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539458168829247488', 'ID538783862449242112', 'audio', '3', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539458901058256896', 'ID536931748764712960', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539458988450775040', 'ID529380122512326656', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539459758004895744', 'ID518092557754826752', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539466846651285504', 'ID535385304635277312', 'audio', '2', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539466894952890368', 'ID537937799890862080', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539492257401667584', 'ID535777043741147136', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539492640748470272', 'ID537922955988959232', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539492680573386752', 'ID532501576867119104', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539503460882579456', 'ID518137166967078912', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539503467220172800', 'ID518137315487383552', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539507941925978112', 'ID520176596611497984', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539509707237228544', 'ID519454529536655360', 'audio', '1', '1', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539511509009563648', 'ID519450551428055040', 'audio', '1', '0', '2019-01-28');
INSERT INTO `media_counts` VALUES ('ID539840062737612800', 'ID518136921315082240', 'audio', '2', '1', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539842887412613120', 'ID537561196815974400', 'audio', '7', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539843044598349824', 'ID518137166967078912', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539849251660759040', 'ID538378337517568000', 'audio', '1', '1', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539850263402381312', 'ID538380120281317376', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539860281514262528', 'ID537650488993120256', 'audio', '8', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539871453344956416', 'ID518107379900874752', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539871768161026048', 'ID539471062065217536', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539871995731378176', 'ID537651492618764288', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539873107817529344', 'ID518137315487383552', 'audio', '1', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539873130835869696', 'ID518137406327619584', 'audio', '2', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID539873157893324800', 'ID537922955988959232', 'audio', '2', '0', '2019-01-29');
INSERT INTO `media_counts` VALUES ('ID540100332944883712', 'ID518137406327619584', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540101538727591936', 'ID537650488993120256', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540102187292819456', 'ID518083290419167232', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540102460140683264', 'ID518083668560838656', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540102885241782272', 'ID529392370534318080', 'audio', '3', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540103921536860160', 'ID518090756984930304', 'audio', '2', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540114465467662336', 'ID518092325025480704', 'audio', '3', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540114541657194496', 'ID538378337517568000', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540118704327753728', 'ID518430406542884864', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540119876103045120', 'ID536931748764712960', 'audio', '3', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540119929400066048', 'ID518096019230031872', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540120268874448896', 'ID520176596611497984', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540124213311176704', 'ID535153697299103744', 'audio', '3', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540124241404624896', 'ID537934717702373376', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540124714253680640', 'ID539453671897825280', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540128585919234048', 'ID537561196815974400', 'audio', '4', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540128777766699008', 'ID518098356564656128', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540130677245345792', 'ID537656827878309888', 'audio', '2', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540137777153441792', 'ID518136921315082240', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540137840525180928', 'ID518137166967078912', 'audio', '2', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540137904484122624', 'ID518128033970782208', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540205404714434560', 'ID535777043741147136', 'audio', '1', '0', '2019-01-30');
INSERT INTO `media_counts` VALUES ('ID540436250205618176', 'ID538783862449242112', 'audio', '1', '1', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540495807015550976', 'ID529392370534318080', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540547594330308608', 'ID521698898528436224', 'audio', '4', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540547949730463744', 'ID521699097439109120', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540579582881824768', 'ID537937799890862080', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588067946233856', 'ID518418068611792896', 'audio', '4', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588210326077440', 'ID537651492618764288', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588343470063616', 'ID538380303387852800', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588758760685568', 'ID518128033970782208', 'audio', '4', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588806928072704', 'ID518136921315082240', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588837991088128', 'ID518137166967078912', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540588889618776064', 'ID518137315487383552', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589015288512512', 'ID518083290419167232', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589152710688768', 'ID518083668560838656', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589175619977216', 'ID518087104530481152', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589283690414080', 'ID518417670446514176', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589347385114624', 'ID537922955988959232', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540589482542366720', 'ID520176596611497984', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540593533879320576', 'ID535777043741147136', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540594194016632832', 'ID524909182437031936', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540594452280901632', 'ID519450551428055040', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540596400774184960', 'ID535153697299103744', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540596439022043136', 'ID535385304635277312', 'audio', '3', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540597819837251584', 'ID539453671897825280', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540597985994604544', 'ID519454529536655360', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540598041879511040', 'ID518098356564656128', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540598068127465472', 'ID518424324789501952', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540599800765087744', 'ID537934717702373376', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540601183367069696', 'ID518099783953416192', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540601620686176256', 'ID537656827878309888', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540603016043036672', 'ID525686848677216256', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540603057356931072', 'ID536931748764712960', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540667844732387328', 'ID518137501840310272', 'audio', '2', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540668622486372352', 'ID518137406327619584', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540671148174606336', 'ID518417486404648960', 'audio', '1', '0', '2019-01-31');
INSERT INTO `media_counts` VALUES ('ID540777054535155712', 'ID535153697299103744', 'audio', '6', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540777322882531328', 'ID535385304635277312', 'audio', '7', '1', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540779300056465408', 'ID537937799890862080', 'audio', '2', '2', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540780827265466368', 'ID537934717702373376', 'audio', '3', '2', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540782128594419712', 'ID539453671897825280', 'audio', '2', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540946034323357696', 'ID518137406327619584', 'audio', '1', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540989168201760768', 'ID518087482479214592', 'audio', '1', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540989562713800704', 'ID518092325025480704', 'audio', '1', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID540989762551414784', 'ID540941586649841664', 'audio', '1', '0', '2019-02-01');
INSERT INTO `media_counts` VALUES ('ID541161199241265152', 'ID535385304635277312', 'audio', '3', '1', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541175553328152576', 'ID518083290419167232', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541350046491213824', 'ID537937799890862080', 'audio', '4', '1', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541356009419964416', 'ID518136921315082240', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541356495913091072', 'ID518098356564656128', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541362053344919552', 'ID518137406327619584', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541362838573154304', 'ID535153697299103744', 'audio', '2', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541364207669477376', 'ID518128033970782208', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541376579922558976', 'ID541375809848344576', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541381290402775040', 'ID539453671897825280', 'audio', '2', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541389300529364992', 'ID537934717702373376', 'audio', '1', '0', '2019-02-02');
INSERT INTO `media_counts` VALUES ('ID541555231989694464', 'ID535385304635277312', 'audio', '1', '0', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541606386291703808', 'ID518083290419167232', 'audio', '1', '0', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541606760369094656', 'ID540941586649841664', 'audio', '3', '0', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541614375279001600', 'ID536931748764712960', 'audio', '2', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541623108654596096', 'ID541377299564462080', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541723007450611712', 'ID537656827878309888', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541724471195598848', 'ID537657125153800192', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541725907056852992', 'ID525680320045907968', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541727421963960320', 'ID533605795837771776', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541728535912382464', 'ID533620189401448448', 'audio', '1', '1', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541729672585543680', 'ID536928804895981568', 'audio', '1', '0', '2019-02-03');
INSERT INTO `media_counts` VALUES ('ID541986930791809024', 'ID535153697299103744', 'audio', '3', '0', '2019-02-04');
INSERT INTO `media_counts` VALUES ('ID542127201101807616', 'ID537656827878309888', 'audio', '1', '0', '2019-02-04');
INSERT INTO `media_counts` VALUES ('ID542127254671458304', 'ID525680320045907968', 'audio', '1', '1', '2019-02-04');
INSERT INTO `media_counts` VALUES ('ID542128759726145536', 'ID533605795837771776', 'audio', '1', '0', '2019-02-04');
INSERT INTO `media_counts` VALUES ('ID542326983757922304', 'ID535153697299103744', 'audio', '1', '0', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542377445458706432', 'ID535385304635277312', 'audio', '1', '0', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542446958522925056', 'ID537657125153800192', 'audio', '2', '2', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542448402768592896', 'ID525680320045907968', 'audio', '2', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542465734173786112', 'ID533605795837771776', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542466850395521024', 'ID533620189401448448', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542467987194511360', 'ID536928804895981568', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542470664406171648', 'ID520180836125900800', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542472056621498368', 'ID525686848677216256', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542473269266087936', 'ID529380122512326656', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542474494304845824', 'ID518087803364442112', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542475456796950528', 'ID531530446631075840', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542476288049283072', 'ID518096552670003200', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542477405206347776', 'ID518097240917540864', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542478977139212288', 'ID531530617293111296', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542480065737261056', 'ID518450921814884352', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542481174245670912', 'ID518095629965066240', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542482512601939968', 'ID518096933240176640', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542483614265245696', 'ID518449187038167040', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542484733553016832', 'ID520184891380334592', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542485763317563392', 'ID518098057879879680', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542487259836841984', 'ID518449521076731904', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542488333159235584', 'ID518126692514922496', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542489624623185920', 'ID518096019230031872', 'audio', '1', '1', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542490842368049152', 'ID518081228029558784', 'audio', '1', '0', '2019-02-05');
INSERT INTO `media_counts` VALUES ('ID542617550043742208', 'ID535385304635277312', 'audio', '4', '2', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542620175673851904', 'ID537937799890862080', 'audio', '2', '2', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542621609110798336', 'ID537934717702373376', 'audio', '2', '1', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542622910716575744', 'ID539453671897825280', 'audio', '1', '1', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542624160824688640', 'ID538783862449242112', 'audio', '1', '1', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542625709860847616', 'ID541375809848344576', 'audio', '2', '1', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542626990457356288', 'ID541377299564462080', 'audio', '1', '1', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542628516450009088', 'ID518128033970782208', 'audio', '1', '0', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542694964023263232', 'ID535153697299103744', 'audio', '1', '0', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542762516418134016', 'ID519454529536655360', 'audio', '1', '0', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542762539541331968', 'ID519450551428055040', 'audio', '1', '0', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID542762569341861888', 'ID519448959479971840', 'audio', '1', '0', '2019-02-06');
INSERT INTO `media_counts` VALUES ('ID543091581972905984', 'ID535385304635277312', 'audio', '1', '0', '2019-02-07');
INSERT INTO `media_counts` VALUES ('ID543141232818257920', 'ID535153697299103744', 'audio', '1', '0', '2019-02-07');
INSERT INTO `media_counts` VALUES ('ID543478590600118272', 'ID535385304635277312', 'audio', '5', '0', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543532442653294592', 'ID536928804895981568', 'audio', '1', '0', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543534193557110784', 'ID533605795837771776', 'audio', '1', '1', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543535350346153984', 'ID533620189401448448', 'audio', '1', '0', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543535847920631808', 'ID520184891380334592', 'audio', '1', '1', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543559125968093184', 'ID535153697299103744', 'audio', '1', '0', '2019-02-08');
INSERT INTO `media_counts` VALUES ('ID543768467463995392', 'ID535385304635277312', 'audio', '2', '0', '2019-02-09');
INSERT INTO `media_counts` VALUES ('ID544263263928451072', 'ID537656827878309888', 'audio', '2', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544264740688363520', 'ID540941586649841664', 'audio', '2', '2', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544266041237176320', 'ID536931748764712960', 'audio', '3', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544266149567660032', 'ID533620189401448448', 'audio', '2', '2', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544267289776619520', 'ID536928804895981568', 'audio', '2', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544286598666125312', 'ID537657125153800192', 'audio', '1', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544288037782159360', 'ID525680320045907968', 'audio', '1', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544289545147908096', 'ID533605795837771776', 'audio', '1', '1', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544294467406921728', 'ID520180836125900800', 'audio', '1', '0', '2019-02-10');
INSERT INTO `media_counts` VALUES ('ID544628396278153216', 'ID518087803364442112', 'audio', '2', '2', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544630174688215040', 'ID520180836125900800', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544631583001280512', 'ID525686848677216256', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544632866009513984', 'ID529380122512326656', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544635051959123968', 'ID531530446631075840', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544635883433754624', 'ID518096552670003200', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544637023823069184', 'ID518097240917540864', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544638573807140864', 'ID531530617293111296', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544639661675380736', 'ID518450921814884352', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544640768996802560', 'ID518095629965066240', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544642108657500160', 'ID518096933240176640', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544643207833583616', 'ID518449187038167040', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544644325045174272', 'ID520184891380334592', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544645352674820096', 'ID518098057879879680', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544646847860310016', 'ID518449521076731904', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544647920670998528', 'ID518126692514922496', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544649212491464704', 'ID518096019230031872', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544650430655758336', 'ID518081228029558784', 'audio', '1', '1', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544651522227568640', 'ID518090678215901184', 'audio', '1', '0', '2019-02-11');
INSERT INTO `media_counts` VALUES ('ID544669015025385472', 'ID529392370534318080', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544802359885168640', 'ID518128033970782208', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544802379288018944', 'ID518137166967078912', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544802451606208512', 'ID518087482479214592', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544836017769676800', 'ID518083290419167232', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544844409934446592', 'ID540941586649841664', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544845715096993792', 'ID521698898528436224', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544855801466978304', 'ID518092325025480704', 'audio', '1', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544857163978244096', 'ID518098356564656128', 'audio', '1', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544857905808015360', 'ID518098925983367168', 'audio', '1', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544859177042837504', 'ID518424324789501952', 'audio', '1', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544860175190720512', 'ID518099783953416192', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544906395800043520', 'ID535777043741147136', 'audio', '1', '0', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544992275294322688', 'ID531530446631075840', 'audio', '2', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID544993286792675328', 'ID518096552670003200', 'audio', '1', '1', '2019-02-12');
INSERT INTO `media_counts` VALUES ('ID545358150262325248', 'ID535153697299103744', 'audio', '1', '0', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545358478739243008', 'ID518450921814884352', 'audio', '1', '1', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545359745586823168', 'ID525686848677216256', 'audio', '1', '1', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545360970394894336', 'ID529380122512326656', 'audio', '1', '1', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545362197379809280', 'ID518087803364442112', 'audio', '1', '1', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545363167430049792', 'ID531530446631075840', 'audio', '1', '0', '2019-02-13');
INSERT INTO `media_counts` VALUES ('ID545550930464997376', 'ID535777043741147136', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545550934625746944', 'ID537922955988959232', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545550939159789568', 'ID532501576867119104', 'audio', '2', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545550952900329472', 'ID524909182437031936', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545551759699869696', 'ID520180836125900800', 'audio', '2', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545558336418873344', 'ID545558132303069184', 'audio', '10', '2', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545564506814676992', 'ID537934717702373376', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545570528241385472', 'ID545568979322667008', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545614802718818304', 'ID518128033970782208', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545663678435819520', 'ID521699097439109120', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545722273303101440', 'ID518098356564656128', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545723024750411776', 'ID518098925983367168', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545724007660388352', 'ID545571653778669568', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545725423263154176', 'ID536931748764712960', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545726663451738112', 'ID537656827878309888', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545728134662586368', 'ID537657125153800192', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545729567600410624', 'ID525680320045907968', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545731074219573248', 'ID533605795837771776', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545732186582548480', 'ID533620189401448448', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545733325684211712', 'ID536928804895981568', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545737397879439360', 'ID525686848677216256', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545738606182924288', 'ID529380122512326656', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545739829732704256', 'ID545568366073479168', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545741244697935872', 'ID518087803364442112', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545742207097765888', 'ID531530446631075840', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545743041634238464', 'ID540941586649841664', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545744321370914816', 'ID518096552670003200', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545745438678974464', 'ID518097240917540864', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545747009152221184', 'ID531530617293111296', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545748096848494592', 'ID518450921814884352', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545749207558914048', 'ID518095629965066240', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545750547936837632', 'ID518096933240176640', 'audio', '1', '1', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545751648551567360', 'ID518449187038167040', 'audio', '1', '0', '2019-02-14');
INSERT INTO `media_counts` VALUES ('ID545924855371923456', 'ID518417486404648960', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID545957861058936832', 'ID537934717702373376', 'audio', '2', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID545958416804216832', 'ID545568979322667008', 'audio', '2', '2', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID545959372166004736', 'ID545571653778669568', 'audio', '2', '1', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID545960784404938752', 'ID536931748764712960', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID545996107092590592', 'ID535777043741147136', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015490942697472', 'ID541377299564462080', 'audio', '2', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015511289266176', 'ID541375809848344576', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015524081893376', 'ID535153697299103744', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015532197871616', 'ID535385304635277312', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015535788195840', 'ID537937799890862080', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546015543904174080', 'ID539453671897825280', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546020097945239552', 'ID546019894789931008', 'audio', '5', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546021625527533568', 'ID546021548780158976', 'audio', '3', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546078319007760384', 'ID533605795837771776', 'audio', '1', '0', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546078439107461120', 'ID520184891380334592', 'audio', '1', '1', '2019-02-15');
INSERT INTO `media_counts` VALUES ('ID546225136102014976', 'ID535153697299103744', 'audio', '2', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546266168365678592', 'ID546021548780158976', 'audio', '2', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546266476621856768', 'ID541377299564462080', 'audio', '1', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546267229834969088', 'ID518128033970782208', 'audio', '2', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546267255420223488', 'ID518137501840310272', 'audio', '1', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546355408227270656', 'ID537934717702373376', 'audio', '1', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546356693269741568', 'ID546019894789931008', 'audio', '1', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546364599734108160', 'ID518083290419167232', 'audio', '3', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546364684500992000', 'ID518087104530481152', 'audio', '5', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546366206844600320', 'ID518083668560838656', 'audio', '2', '2', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546368832399212544', 'ID518087482479214592', 'audio', '1', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546414757175885824', 'ID537937799890862080', 'audio', '2', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546431878966542336', 'ID525680320045907968', 'audio', '2', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546447002867597312', 'ID518081228029558784', 'audio', '1', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546449721959383040', 'ID520180836125900800', 'audio', '1', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546451211885215744', 'ID525686848677216256', 'audio', '1', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546452440132616192', 'ID529380122512326656', 'audio', '1', '1', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546453647463022592', 'ID518087803364442112', 'audio', '1', '0', '2019-02-16');
INSERT INTO `media_counts` VALUES ('ID546792191599575040', 'ID529380122512326656', 'audio', '1', '1', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546793420635504640', 'ID518087803364442112', 'audio', '1', '1', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546794385149263872', 'ID518096552670003200', 'audio', '1', '1', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546797483561320448', 'ID518097240917540864', 'audio', '1', '0', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546798901714223104', 'ID525686848677216256', 'audio', '2', '0', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546799101899964416', 'ID518090678215901184', 'audio', '1', '0', '2019-02-17');
INSERT INTO `media_counts` VALUES ('ID546966181337104384', 'ID518418068611792896', 'audio', '3', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID546967831774756864', 'ID529392370534318080', 'audio', '2', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID546968357547540480', 'ID521698898528436224', 'audio', '1', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID546969110307667968', 'ID521699097439109120', 'audio', '1', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID547130582304292864', 'ID535385304635277312', 'audio', '2', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID547163609591971840', 'ID534404740755226624', 'audio', '1', '1', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID547167115732320256', 'ID536928804895981568', 'audio', '1', '0', '2019-02-18');
INSERT INTO `media_counts` VALUES ('ID547341966715650048', 'ID541377299564462080', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547383473959075840', 'ID546021548780158976', 'audio', '2', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547426458935492608', 'ID518136921315082240', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547426664129232896', 'ID545568979322667008', 'audio', '2', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547428240600334336', 'ID535153697299103744', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547435611833761792', 'ID547435337442394112', 'audio', '3', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547469121877442560', 'ID547461763847684096', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547476943352627200', 'ID547476409900072960', 'audio', '8', '1', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547494633857351680', 'ID547468661670019072', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547527662952775680', 'ID518091303477575680', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547528294224887808', 'ID532515574329114624', 'audio', '1', '0', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547528794462748672', 'ID545568366073479168', 'audio', '1', '1', '2019-02-19');
INSERT INTO `media_counts` VALUES ('ID547706352437297152', 'ID547476409900072960', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547707496496627712', 'ID547468661670019072', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547811626032562176', 'ID518128033970782208', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547811769851052032', 'ID518136921315082240', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547858031589720064', 'ID518083290419167232', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547866951708311552', 'ID518083668560838656', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547868145805688832', 'ID518087104530481152', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547870026741317632', 'ID518087482479214592', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547871950370766848', 'ID518087975544815616', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547873753174900736', 'ID518088768721256448', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547924821850193920', 'ID518089162302160896', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547926558581456896', 'ID518089575046840320', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547928125070114816', 'ID518089984079560704', 'audio', '1', '1', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547929702308773888', 'ID518090756984930304', 'audio', '1', '0', '2019-02-20');
INSERT INTO `media_counts` VALUES ('ID547931556639932416', 'ID518090756984930304', 'audio', '0', '1', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548030340975820800', 'ID547476409900072960', 'audio', '1', '1', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548031496519155712', 'ID547468661670019072', 'audio', '1', '0', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548031591994097664', 'ID545568979322667008', 'audio', '3', '2', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548032557950697472', 'ID545571653778669568', 'audio', '2', '1', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548033978737623040', 'ID536931748764712960', 'audio', '1', '1', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548035218095734784', 'ID537656827878309888', 'audio', '1', '1', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548036686089551872', 'ID537657125153800192', 'audio', '1', '0', '2019-02-21');
INSERT INTO `media_counts` VALUES ('ID548451589988286464', 'ID546021548780158976', 'audio', '1', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548455211811733504', 'ID539471062065217536', 'audio', '4', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548456581574950912', 'ID538380538935771136', 'audio', '1', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548459930076577792', 'ID537922955988959232', 'audio', '2', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548469294778810368', 'ID548462666079797248', 'audio', '2', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548469339859189760', 'ID524909182437031936', 'audio', '2', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548469405537796096', 'ID532501576867119104', 'audio', '2', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548505152936476672', 'ID546019894789931008', 'audio', '2', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548531930312736768', 'ID547476409900072960', 'audio', '1', '0', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548555801006964736', 'ID518088768721256448', 'audio', '1', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548557597339287552', 'ID518089162302160896', 'audio', '1', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548559330983542784', 'ID518089575046840320', 'audio', '1', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548560786696437760', 'ID518089984079560704', 'audio', '1', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548562351633203200', 'ID518090756984930304', 'audio', '1', '1', '2019-02-22');
INSERT INTO `media_counts` VALUES ('ID548772450121285632', 'ID548462666079797248', 'audio', '2', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548807215968944128', 'ID547476409900072960', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548808702279286784', 'ID547468661670019072', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548810360455430144', 'ID547461763847684096', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548812017083875328', 'ID547435337442394112', 'audio', '1', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548867424162676736', 'ID538378337517568000', 'audio', '2', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548870081250066432', 'ID546019894789931008', 'audio', '1', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548870164876099584', 'ID548205419797938176', 'audio', '1', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548870225680924672', 'ID535385304635277312', 'audio', '1', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548888510912790528', 'ID520176596611497984', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548890302908203008', 'ID535777043741147136', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548892370217730048', 'ID519454529536655360', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548894164062830592', 'ID519450551428055040', 'audio', '1', '1', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548896179887276032', 'ID519448959479971840', 'audio', '2', '2', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548898064501309440', 'ID545558132303069184', 'audio', '2', '2', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID548978254610956288', 'ID545568979322667008', 'audio', '1', '0', '2019-02-23');
INSERT INTO `media_counts` VALUES ('ID549315131780104192', 'ID547476409900072960', 'audio', '2', '1', '2019-02-24');
INSERT INTO `media_counts` VALUES ('ID549363408084926464', 'ID547468661670019072', 'audio', '1', '1', '2019-02-24');
INSERT INTO `media_counts` VALUES ('ID549365073953423360', 'ID547461763847684096', 'audio', '1', '1', '2019-02-24');
INSERT INTO `media_counts` VALUES ('ID549366663183597568', 'ID547435337442394112', 'audio', '1', '1', '2019-02-24');
INSERT INTO `media_counts` VALUES ('ID549492555528536064', 'ID535385304635277312', 'audio', '2', '0', '2019-02-25');
INSERT INTO `media_counts` VALUES ('ID549595951778496512', 'ID546019894789931008', 'audio', '1', '0', '2019-02-25');
INSERT INTO `media_counts` VALUES ('ID549713528148197376', 'ID547435337442394112', 'audio', '1', '0', '2019-02-25');
INSERT INTO `media_counts` VALUES ('ID549743535650242560', 'ID547476409900072960', 'audio', '1', '0', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549893493946843136', 'ID546021548780158976', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549895405471531008', 'ID548447672898420736', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549896733409148928', 'ID535153697299103744', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549897898825875456', 'ID546019894789931008', 'audio', '2', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549899307910692864', 'ID548205419797938176', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549900657650302976', 'ID535385304635277312', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549902104488050688', 'ID537937799890862080', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549903637640380416', 'ID537934717702373376', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549904932682072064', 'ID539453671897825280', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549906180785307648', 'ID538783862449242112', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549907731813761024', 'ID541375809848344576', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID549909008111108096', 'ID541377299564462080', 'audio', '1', '1', '2019-02-26');
INSERT INTO `media_counts` VALUES ('ID550232854227845120', 'ID535153697299103744', 'audio', '1', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550232878479310848', 'ID538783862449242112', 'audio', '1', '1', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550234452807122944', 'ID541375809848344576', 'audio', '1', '1', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550236005886590976', 'ID541377299564462080', 'audio', '1', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550317884069380096', 'ID546021548780158976', 'audio', '1', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550318412677513216', 'ID545568979322667008', 'audio', '1', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550325500254355456', 'ID537561196815974400', 'audio', '2', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550326034445107200', 'ID537650488993120256', 'audio', '3', '1', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550326711552573440', 'ID537651492618764288', 'audio', '3', '1', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550329093934022656', 'ID538378337517568000', 'audio', '3', '2', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550330828756877312', 'ID538380120281317376', 'audio', '3', '3', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550333465862602752', 'ID538380303387852800', 'audio', '4', '3', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550337784414470144', 'ID538380538935771136', 'audio', '5', '4', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550338979451371520', 'ID539471062065217536', 'audio', '5', '1', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550363408856252416', 'ID518128033970782208', 'audio', '1', '0', '2019-02-27');
INSERT INTO `media_counts` VALUES ('ID550635951865462784', 'ID532501576867119104', 'audio', '2', '0', '2019-02-28');
INSERT INTO `media_counts` VALUES ('ID550636571796176896', 'ID546021548780158976', 'audio', '2', '0', '2019-02-28');
INSERT INTO `media_counts` VALUES ('ID550701386719821824', 'ID518417486404648960', 'audio', '1', '0', '2019-02-28');
INSERT INTO `media_counts` VALUES ('ID551138448774266880', 'ID532501576867119104', 'audio', '1', '0', '2019-03-01');
INSERT INTO `media_counts` VALUES ('ID551445173423308800', 'ID532501576867119104', 'audio', '1', '0', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551520242547818496', 'ID545568979322667008', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551521203156680704', 'ID545571653778669568', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551522641576460288', 'ID550725286547685376', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551524104432254976', 'ID536931748764712960', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551525350954237952', 'ID537656827878309888', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551526813810032640', 'ID537657125153800192', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551528251655192576', 'ID550721224100020224', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551529210712162304', 'ID525680320045907968', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551530725841567744', 'ID533605795837771776', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551531838565253120', 'ID533620189401448448', 'audio', '1', '1', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551532973313228800', 'ID534404740755226624', 'audio', '1', '0', '2019-03-02');
INSERT INTO `media_counts` VALUES ('ID551793271156768768', 'ID532501576867119104', 'audio', '1', '0', '2019-03-03');
INSERT INTO `media_counts` VALUES ('ID552151555680239616', 'ID547435337442394112', 'audio', '1', '1', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552154392346755072', 'ID533605795837771776', 'audio', '1', '1', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552155527036010496', 'ID533620189401448448', 'audio', '1', '1', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552157647474786304', 'ID534404740755226624', 'audio', '1', '1', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552161157083824128', 'ID536928804895981568', 'audio', '1', '1', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552163828876443648', 'ID520180836125900800', 'audio', '1', '0', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552238425260949504', 'ID518418068611792896', 'audio', '1', '0', '2019-03-04');
INSERT INTO `media_counts` VALUES ('ID552822337494319104', 'ID518083290419167232', 'audio', '2', '0', '2019-03-06');
INSERT INTO `media_counts` VALUES ('ID552823194352877568', 'ID533620189401448448', 'audio', '1', '0', '2019-03-06');
INSERT INTO `media_counts` VALUES ('ID552842022046662656', 'ID548205419797938176', 'audio', '2', '0', '2019-03-06');
INSERT INTO `media_counts` VALUES ('ID554928306374311936', 'ID518128033970782208', 'audio', '1', '0', '2019-03-12');
INSERT INTO `media_counts` VALUES ('ID555112125312270336', 'ID518137315487383552', 'audio', '1', '1', '2019-03-12');
INSERT INTO `media_counts` VALUES ('ID555115950404272128', 'ID518137406327619584', 'audio', '1', '0', '2019-03-12');
INSERT INTO `media_counts` VALUES ('ID555278802318524416', 'ID518128033970782208', 'audio', '3', '0', '2019-03-13');
INSERT INTO `media_counts` VALUES ('ID555301817769000960', 'ID521698898528436224', 'audio', '1', '0', '2019-03-13');
INSERT INTO `media_counts` VALUES ('ID555769801167863808', 'ID546021548780158976', 'audio', '2', '0', '2019-03-14');
INSERT INTO `media_counts` VALUES ('ID555780003288055808', 'ID529392370534318080', 'audio', '1', '1', '2019-03-14');
INSERT INTO `media_counts` VALUES ('ID555785853683630080', 'ID518418068611792896', 'audio', '1', '1', '2019-03-14');
INSERT INTO `media_counts` VALUES ('ID555794991142666240', 'ID518417486404648960', 'audio', '1', '0', '2019-03-14');
INSERT INTO `media_counts` VALUES ('ID555881169619517440', 'ID541375809848344576', 'audio', '1', '0', '2019-03-14');
INSERT INTO `media_counts` VALUES ('ID557293987950493696', 'ID547435337442394112', 'audio', '1', '1', '2019-03-18');
INSERT INTO `media_counts` VALUES ('ID557564326248972288', 'ID518098356564656128', 'audio', '2', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557564387804577792', 'ID518092325025480704', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557564466451972096', 'ID518098925983367168', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557564471283810304', 'ID518424324789501952', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557577468182003712', 'ID518083668560838656', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557613444346413056', 'ID548447672898420736', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557613632804880384', 'ID518083290419167232', 'audio', '2', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557613804452577280', 'ID545568979322667008', 'audio', '1', '1', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557614797667958784', 'ID545571653778669568', 'audio', '1', '0', '2019-03-19');
INSERT INTO `media_counts` VALUES ('ID557728247400366080', 'ID529392370534318080', 'audio', '1', '1', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557939597498122240', 'ID524909182437031936', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557945815960649728', 'ID557940478700421120', 'audio', '3', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557950818943238144', 'ID545568979322667008', 'audio', '2', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557951644872998912', 'ID545571653778669568', 'audio', '2', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557951869788356608', 'ID550725286547685376', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557951974813728768', 'ID536931748764712960', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557952081823006720', 'ID537656827878309888', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557952169588817920', 'ID537657125153800192', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557952910235795456', 'ID550721224100020224', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557953110954213376', 'ID525680320045907968', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557953229510410240', 'ID533605795837771776', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557953412243652608', 'ID533620189401448448', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557953514114908160', 'ID534404740755226624', 'audio', '3', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557953706163699712', 'ID518097240917540864', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557954902848962560', 'ID531530617293111296', 'audio', '2', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557955496426864640', 'ID518450921814884352', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557956292681924608', 'ID518095629965066240', 'audio', '2', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557956411481391104', 'ID519446741330690048', 'audio', '2', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557959526393839616', 'ID518449187038167040', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557960325110956032', 'ID518449521076731904', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961176433033216', 'ID532510537691430912', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961273027854336', 'ID518081228029558784', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961524371521536', 'ID532514201436946432', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961650225807360', 'ID518090678215901184', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961850558349312', 'ID532514618128465920', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557961970595135488', 'ID518092557754826752', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962184177483776', 'ID518096019230031872', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962411131273216', 'ID532515231453151232', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962545332224000', 'ID518091303477575680', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962661434753024', 'ID532515574329114624', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962784290111488', 'ID518090356701528064', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557962893711114240', 'ID532515777736081408', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557963095796875264', 'ID532516960567558144', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID557963155246940160', 'ID518086312704606208', 'audio', '1', '0', '2019-03-20');
INSERT INTO `media_counts` VALUES ('ID558771409954799616', 'ID548462666079797248', 'audio', '1', '0', '2019-03-22');
INSERT INTO `media_counts` VALUES ('ID558771422336385024', 'ID557940478700421120', 'audio', '1', '0', '2019-03-22');
INSERT INTO `media_counts` VALUES ('ID560029871384821760', 'ID518136921315082240', 'audio', '2', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560030167506878464', 'ID557940478700421120', 'audio', '6', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560162025305538560', 'ID546021548780158976', 'audio', '2', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560162240368476160', 'ID547476409900072960', 'audio', '1', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560162704237527040', 'ID518128033970782208', 'audio', '1', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560163039215616000', 'ID518083290419167232', 'audio', '1', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560164418374074368', 'ID519446741330690048', 'audio', '1', '1', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560165243678883840', 'ID518092325025480704', 'audio', '1', '0', '2019-03-26');
INSERT INTO `media_counts` VALUES ('ID560411676411691008', 'ID550718369184088064', 'audio', '1', '0', '2019-03-27');
INSERT INTO `media_counts` VALUES ('ID560426402088747008', 'ID537937799890862080', 'audio', '1', '0', '2019-03-27');
INSERT INTO `media_counts` VALUES ('ID560430825653403648', 'ID532501576867119104', 'audio', '1', '0', '2019-03-27');
INSERT INTO `media_counts` VALUES ('ID561216960994476032', 'ID518083290419167232', 'audio', '1', '0', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561217190519373824', 'ID548205419797938176', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561218553617842176', 'ID550352358605848576', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561219731814612992', 'ID535385304635277312', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561221173946351616', 'ID537937799890862080', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561222606733180928', 'ID537934717702373376', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561223906308915200', 'ID539453671897825280', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561225152646348800', 'ID538783862449242112', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561226716693921792', 'ID541375809848344576', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID561227992181768192', 'ID541377299564462080', 'audio', '1', '1', '2019-03-29');
INSERT INTO `media_counts` VALUES ('ID562356089916489728', 'ID525686848677216256', 'audio', '2', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562394350718287872', 'ID550718369184088064', 'audio', '1', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562396053920284672', 'ID537561196815974400', 'audio', '3', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562396119808606208', 'ID537650488993120256', 'audio', '4', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562398641738743808', 'ID537651492618764288', 'audio', '3', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562398900720238592', 'ID538378337517568000', 'audio', '2', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562399047797702656', 'ID538380120281317376', 'audio', '2', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562399170808250368', 'ID538380303387852800', 'audio', '1', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562399478917627904', 'ID538380538935771136', 'audio', '1', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562399617258356736', 'ID539471062065217536', 'audio', '1', '0', '2019-04-01');
INSERT INTO `media_counts` VALUES ('ID562589268141146112', 'ID525686848677216256', 'audio', '1', '0', '2019-04-02');
INSERT INTO `media_counts` VALUES ('ID562627198628921344', 'ID537561196815974400', 'audio', '1', '1', '2019-04-02');
INSERT INTO `media_counts` VALUES ('ID562628034335604736', 'ID537650488993120256', 'audio', '1', '1', '2019-04-02');
INSERT INTO `media_counts` VALUES ('ID562629217225801728', 'ID537651492618764288', 'audio', '2', '0', '2019-04-02');
INSERT INTO `media_counts` VALUES ('ID562664828418654208', 'ID521698898528436224', 'audio', '1', '0', '2019-04-02');
INSERT INTO `media_counts` VALUES ('ID562956203018158080', 'ID518083290419167232', 'audio', '1', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID562956342990471168', 'ID518087482479214592', 'audio', '2', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID562956814459600896', 'ID546021548780158976', 'audio', '2', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID562956859309293568', 'ID546019894789931008', 'audio', '1', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID562957127556005888', 'ID550718369184088064', 'audio', '1', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID562957924821893120', 'ID547476409900072960', 'audio', '1', '0', '2019-04-03');
INSERT INTO `media_counts` VALUES ('ID563351589478203392', 'ID518089575046840320', 'audio', '1', '0', '2019-04-04');
INSERT INTO `media_counts` VALUES ('ID563352004013850624', 'ID531530446631075840', 'audio', '1', '0', '2019-04-04');
INSERT INTO `media_counts` VALUES ('ID563356981406990336', 'ID518418068611792896', 'audio', '1', '0', '2019-04-04');
INSERT INTO `media_counts` VALUES ('ID564126160200400896', 'ID537650488993120256', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564127345183555584', 'ID537651492618764288', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564128669073670144', 'ID538378337517568000', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564129683201851392', 'ID538380120281317376', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564132319670042624', 'ID538380303387852800', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564133204512997376', 'ID538380538935771136', 'audio', '1', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564134397050093568', 'ID539471062065217536', 'audio', '2', '1', '2019-04-06');
INSERT INTO `media_counts` VALUES ('ID564931737147146240', 'ID537656827878309888', 'audio', '1', '1', '2019-04-08');
INSERT INTO `media_counts` VALUES ('ID564933201877794816', 'ID540941586649841664', 'audio', '1', '1', '2019-04-08');
INSERT INTO `media_counts` VALUES ('ID564934481811603456', 'ID520184891380334592', 'audio', '1', '1', '2019-04-08');
INSERT INTO `media_counts` VALUES ('ID564935507662864384', 'ID518081228029558784', 'audio', '1', '1', '2019-04-08');
INSERT INTO `media_counts` VALUES ('ID564936596109918208', 'ID518091303477575680', 'audio', '1', '0', '2019-04-08');
INSERT INTO `media_counts` VALUES ('ID565142595827662848', 'ID547476409900072960', 'audio', '1', '0', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565179971958472704', 'ID535385304635277312', 'audio', '1', '0', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565194007613800448', 'ID546021548780158976', 'audio', '2', '0', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565215340137545728', 'ID518087482479214592', 'audio', '1', '0', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565215885376094208', 'ID525686848677216256', 'audio', '1', '1', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565217093264343040', 'ID518097240917540864', 'audio', '1', '1', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565218718049632256', 'ID518096933240176640', 'audio', '1', '1', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565219815489273856', 'ID518449187038167040', 'audio', '1', '1', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565220931417407488', 'ID518449521076731904', 'audio', '1', '1', '2019-04-09');
INSERT INTO `media_counts` VALUES ('ID565580396385796096', 'ID546021548780158976', 'audio', '1', '0', '2019-04-10');
INSERT INTO `media_counts` VALUES ('ID565580902856392704', 'ID547435337442394112', 'audio', '3', '0', '2019-04-10');
INSERT INTO `media_counts` VALUES ('ID565581196029853696', 'ID547461763847684096', 'audio', '3', '0', '2019-04-10');
INSERT INTO `media_counts` VALUES ('ID565581746716803072', 'ID560427229113221120', 'audio', '1', '0', '2019-04-10');
INSERT INTO `media_counts` VALUES ('ID565826571424759808', 'ID547476409900072960', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565827720735358976', 'ID547468661670019072', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565829427888390144', 'ID547461763847684096', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565830967156015104', 'ID547435337442394112', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565831409126604800', 'ID518418068611792896', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565841120093798400', 'ID529392370534318080', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565841427230097408', 'ID539471062065217536', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565843959864098816', 'ID537651492618764288', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565844848154771456', 'ID538380303387852800', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565845759358926848', 'ID538380538935771136', 'audio', '2', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565846525826039808', 'ID538378337517568000', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565846851211755520', 'ID521698898528436224', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565847539509624832', 'ID538380120281317376', 'audio', '2', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565847842850078720', 'ID537650488993120256', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565850728296349696', 'ID565231276592726016', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565851988760199168', 'ID565231867960229888', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565852922143834112', 'ID565232320047480832', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565853827056533504', 'ID536931748764712960', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565855065441566720', 'ID565230834248843264', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565856145139302400', 'ID536928804895981568', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565858671641231360', 'ID562333841675517952', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565859785853894656', 'ID519446741330690048', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565860270069514240', 'ID557940478700421120', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565861866585194496', 'ID548462666079797248', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565864037204623360', 'ID524909182437031936', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565866047660359680', 'ID532501576867119104', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565868706354167808', 'ID537922955988959232', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565871188656521216', 'ID520176596611497984', 'audio', '1', '1', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID565872976608624640', 'ID535777043741147136', 'audio', '1', '0', '2019-04-11');
INSERT INTO `media_counts` VALUES ('ID567437556350713856', 'ID547476409900072960', 'audio', '2', '1', '2019-04-15');
INSERT INTO `media_counts` VALUES ('ID567438703585132544', 'ID547468661670019072', 'audio', '1', '0', '2019-04-15');
INSERT INTO `media_counts` VALUES ('ID567692521073803264', 'ID518083290419167232', 'audio', '1', '0', '2019-04-16');
INSERT INTO `media_counts` VALUES ('ID568132876931956736', 'ID546021548780158976', 'audio', '1', '0', '2019-04-17');
INSERT INTO `media_counts` VALUES ('ID568453956322197504', 'ID546021548780158976', 'audio', '1', '0', '2019-04-18');
INSERT INTO `media_counts` VALUES ('ID568454323814531072', 'ID547476409900072960', 'audio', '1', '0', '2019-04-18');
INSERT INTO `media_counts` VALUES ('ID568461000550907904', 'ID537651492618764288', 'audio', '1', '0', '2019-04-18');
INSERT INTO `media_counts` VALUES ('ID568527038286135296', 'ID521698898528436224', 'audio', '1', '0', '2019-04-18');
INSERT INTO `media_counts` VALUES ('ID568974341409079296', 'ID525686848677216256', 'audio', '1', '0', '2019-04-20');
INSERT INTO `media_counts` VALUES ('ID569299398970834944', 'ID550725286547685376', 'audio', '1', '1', '2019-04-20');
INSERT INTO `media_counts` VALUES ('ID569300851122765824', 'ID550721224100020224', 'audio', '1', '1', '2019-04-20');
INSERT INTO `media_counts` VALUES ('ID569301806874624000', 'ID533620189401448448', 'audio', '1', '1', '2019-04-20');
INSERT INTO `media_counts` VALUES ('ID569302942809587712', 'ID529380122512326656', 'audio', '1', '0', '2019-04-20');
INSERT INTO `media_counts` VALUES ('ID569608943744057344', 'ID518083290419167232', 'audio', '2', '0', '2019-04-21');
INSERT INTO `media_counts` VALUES ('ID569609792092372992', 'ID518083668560838656', 'audio', '1', '0', '2019-04-21');
INSERT INTO `media_counts` VALUES ('ID569932545194459136', 'ID529392370534318080', 'audio', '1', '0', '2019-04-22');
INSERT INTO `media_counts` VALUES ('ID570196654485929984', 'ID537561196815974400', 'audio', '1', '0', '2019-04-23');
INSERT INTO `media_counts` VALUES ('ID570196714288316416', 'ID537650488993120256', 'audio', '1', '0', '2019-04-23');
INSERT INTO `media_counts` VALUES ('ID570258106022363136', 'ID518137501840310272', 'audio', '1', '0', '2019-04-23');
INSERT INTO `media_counts` VALUES ('ID570335112760131584', 'ID547468661670019072', 'audio', '1', '0', '2019-04-23');
INSERT INTO `media_counts` VALUES ('ID570665828752556032', 'ID537656827878309888', 'audio', '1', '0', '2019-04-24');
INSERT INTO `media_counts` VALUES ('ID570665889649655808', 'ID547468661670019072', 'audio', '1', '0', '2019-04-24');
INSERT INTO `media_counts` VALUES ('ID570665920708476928', 'ID547461763847684096', 'audio', '1', '0', '2019-04-24');
INSERT INTO `media_counts` VALUES ('ID570718188422037504', 'ID529392370534318080', 'audio', '1', '0', '2019-04-24');
INSERT INTO `media_counts` VALUES ('ID570718347927224320', 'ID518418068611792896', 'audio', '1', '0', '2019-04-24');
INSERT INTO `media_counts` VALUES ('ID571269864300216320', 'ID546021548780158976', 'audio', '1', '0', '2019-04-26');
INSERT INTO `media_counts` VALUES ('ID572566939562409984', 'ID525686848677216256', 'audio', '2', '1', '2019-04-29');
INSERT INTO `media_counts` VALUES ('ID572568153440124928', 'ID518097240917540864', 'audio', '1', '1', '2019-04-29');
INSERT INTO `media_counts` VALUES ('ID572569759917277184', 'ID518096933240176640', 'audio', '1', '0', '2019-04-29');
INSERT INTO `media_counts` VALUES ('ID572681675545247744', 'ID546021548780158976', 'audio', '1', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID572730027389485056', 'ID547435337442394112', 'audio', '2', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID572730450280185856', 'ID518103250356928512', 'audio', '1', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID572834897425596416', 'ID548447672898420736', 'audio', '1', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID572835070457413632', 'ID560427229113221120', 'audio', '1', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID572835991664984064', 'ID518092325025480704', 'audio', '1', '0', '2019-04-30');
INSERT INTO `media_counts` VALUES ('ID574211281922293760', 'ID546021548780158976', 'audio', '2', '0', '2019-05-04');
INSERT INTO `media_counts` VALUES ('ID574213767093551104', 'ID550718369184088064', 'audio', '1', '0', '2019-05-04');
INSERT INTO `media_counts` VALUES ('ID574213785917587456', 'ID560427229113221120', 'audio', '1', '0', '2019-05-04');
INSERT INTO `media_counts` VALUES ('ID575268470086696960', 'ID529392370534318080', 'audio', '2', '1', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575357387876073472', 'ID546021548780158976', 'audio', '2', '0', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575410802907938816', 'ID562333841675517952', 'audio', '1', '0', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575410988619137024', 'ID519446741330690048', 'audio', '1', '0', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575411194110672896', 'ID518083290419167232', 'audio', '1', '0', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575418035389595648', 'ID520180836125900800', 'audio', '3', '0', '2019-05-07');
INSERT INTO `media_counts` VALUES ('ID575584921741950976', 'ID565231867960229888', 'audio', '1', '0', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575705860534173696', 'ID560427229113221120', 'audio', '1', '0', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575801837047775232', 'ID525686848677216256', 'audio', '2', '1', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575803088342876160', 'ID518097240917540864', 'audio', '1', '1', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575804660183465984', 'ID518096933240176640', 'audio', '1', '1', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575805766112378880', 'ID518449187038167040', 'audio', '1', '1', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575806881105182720', 'ID518449521076731904', 'audio', '1', '1', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID575813785650987008', 'ID529392370534318080', 'audio', '1', '0', '2019-05-08');
INSERT INTO `media_counts` VALUES ('ID576042768959275008', 'ID546021548780158976', 'audio', '1', '0', '2019-05-09');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `user_id` varchar(30) NOT NULL COMMENT '用户（当前登录的用户信息）',
  `ROLE` varchar(100) DEFAULT NULL COMMENT '身份',
  `import_data` varchar(20) DEFAULT NULL COMMENT '是否为导入数据',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `pic` varchar(150) DEFAULT NULL COMMENT '头像',
  `audio_intro` varchar(200) DEFAULT NULL COMMENT '音频介绍',
  `expert` int(3) DEFAULT NULL COMMENT '是否是专家',
  `office_status` varchar(100) DEFAULT NULL COMMENT '在职状态',
  `ORGANIZATION` varchar(100) DEFAULT NULL COMMENT '学校',
  `ID_CARD` varchar(30) DEFAULT NULL COMMENT '身份证',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '状态',
  `PHASE` varchar(100) DEFAULT NULL COMMENT '学段',
  `SUBJECT` varchar(30) DEFAULT NULL COMMENT '学科',
  `NAME` varchar(100) DEFAULT NULL COMMENT '姓名',
  `point` int(8) DEFAULT '0' COMMENT '积分',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('432228697144033280', 'school_admin', null, '18118807230', null, null, '1', '1', '6', '4', '1', '4', '1', '王一帆test', '0', '432228697144033280', '2018-12-20 16:39:14', '432228697144033280', '2019-04-30 09:10:25');
INSERT INTO `member` VALUES ('516919611287928832', null, null, null, null, null, null, null, null, null, '1', null, null, null, '1489', '516919611287928832', '2018-12-20 16:39:14', '516919611287928832', '2019-03-21 09:18:55');
INSERT INTO `member` VALUES ('517349219414048768', '1', null, '11111111111', null, null, null, '1', '12', '333333333333333333', '1', '1', '1', '王一帆', '535', '517349219414048768', '2018-12-21 09:36:31', '517349219414048768', '2019-04-29 15:06:58');
INSERT INTO `member` VALUES ('517353407590170624', '1', null, '138233233232', null, null, '1', '1', '7', '34334', '1', '3', '4', 'liuasdad', '0', '232', '222', '22', '22');
INSERT INTO `member` VALUES ('517366313497133056', null, null, null, null, null, null, null, null, null, '1', null, null, null, '189', '517366313497133056', '2019-01-10 11:47:31', '517366313497133056', '2019-05-09 17:34:06');
INSERT INTO `member` VALUES ('517366532112646144', null, null, null, null, null, null, null, null, null, '1', null, null, null, '271', '517366532112646144', '2019-01-02 14:48:37', '517366532112646144', '2019-03-01 12:54:25');
INSERT INTO `member` VALUES ('517713552572678144', null, null, '13823323323', null, null, null, null, null, '', '1', null, '', '不吃草的牛', '889655267', '517713552572678144', '2018-12-20 16:52:13', '517713552572678144', '2019-05-08 15:17:13');
INSERT INTO `member` VALUES ('518084122451640320', null, null, null, null, null, null, null, null, null, '1', null, null, null, '83', '518084122451640320', '2018-12-24 10:19:41', '518084122451640320', '2019-02-01 10:05:19');
INSERT INTO `member` VALUES ('518503409347723264', null, null, null, null, null, null, null, null, null, '1', null, null, null, '17', '518503409347723264', '2019-01-08 11:53:52', null, null);
INSERT INTO `member` VALUES ('518508236668665856', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '518508236668665856', '2019-01-02 21:26:06', '518508236668665856', '2019-01-02 21:26:06');
INSERT INTO `member` VALUES ('518668438701342720', null, null, null, null, null, null, null, null, null, '1', null, null, null, '25', '518668438701342720', '2018-12-22 22:20:48', null, null);
INSERT INTO `member` VALUES ('518880937937731584', null, null, null, null, null, null, null, null, null, '1', null, null, null, '81', '518880937937731584', '2018-12-25 10:01:03', '518880937937731584', '2019-04-25 18:41:01');
INSERT INTO `member` VALUES ('518881590537879552', null, null, null, null, null, null, null, null, null, '1', null, null, null, '12', '518881590537879552', '2019-01-05 10:19:30', null, null);
INSERT INTO `member` VALUES ('518881699824664576', null, null, null, null, null, null, null, null, null, '1', null, null, null, '27', '518881699824664576', '2019-02-01 11:03:45', null, null);
INSERT INTO `member` VALUES ('518882036950237184', null, null, null, null, null, null, null, null, null, '1', null, null, null, '10', '518882036950237184', '2019-01-17 01:49:21', '518882036950237184', '2019-02-01 11:05:05');
INSERT INTO `member` VALUES ('518882959818752000', null, null, null, null, null, null, null, null, null, '1', null, null, null, '10', '518882959818752000', '2019-04-24 16:11:37', null, null);
INSERT INTO `member` VALUES ('518884655118680064', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '518884655118680064', '2018-12-30 10:48:01', '518884655118680064', '2018-12-30 10:48:01');
INSERT INTO `member` VALUES ('518896990185062400', null, null, null, null, null, null, null, null, null, '1', null, null, null, '9', '518896990185062400', '2019-01-30 10:11:34', null, null);
INSERT INTO `member` VALUES ('519047766756818944', null, null, null, null, null, null, null, null, null, '1', null, null, null, '49', '519047766756818944', '2019-02-01 11:03:42', '519047766756818944', '2019-02-21 07:41:24');
INSERT INTO `member` VALUES ('520731933508894720', null, null, null, null, null, null, null, null, null, '1', null, null, null, '22', '520731933508894720', '2019-01-13 22:01:01', null, null);
INSERT INTO `member` VALUES ('521720061925261312', null, null, null, null, null, null, null, null, null, '1', null, null, null, '23', '521720061925261312', '2019-02-26 09:58:33', null, null);
INSERT INTO `member` VALUES ('521736048980525056', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '521736048980525056', '2019-01-15 01:21:13', '521736048980525056', '2019-01-15 01:21:13');
INSERT INTO `member` VALUES ('522000062855774208', null, null, null, null, null, null, null, null, null, '1', null, null, null, '33', '522000062855774208', '2018-12-25 17:50:40', '522000062855774208', '2019-01-21 15:48:08');
INSERT INTO `member` VALUES ('522110938266992640', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '522110938266992640', '2018-12-24 04:54:03', '522110938266992640', '2018-12-24 04:54:03');
INSERT INTO `member` VALUES ('522531743010390016', null, null, null, null, null, null, null, null, null, '1', null, null, null, '53', '522531743010390016', '2018-12-23 14:09:18', '522531743010390016', '2019-02-16 07:03:58');
INSERT INTO `member` VALUES ('522536656230678528', null, null, null, null, null, null, null, null, null, '1', null, null, null, '25', '522536656230678528', '2019-02-24 07:56:45', null, null);
INSERT INTO `member` VALUES ('522561907647840256', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '522561907647840256', '2019-01-20 13:49:26', '522561907647840256', '2019-01-20 13:49:26');
INSERT INTO `member` VALUES ('522853368662589440', null, null, null, null, null, null, null, null, null, '1', null, null, null, '9', '522853368662589440', '2019-02-23 10:03:20', null, null);
INSERT INTO `member` VALUES ('522869362797838336', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '522869362797838336', '2018-12-29 14:28:58', '522869362797838336', '2018-12-29 14:28:58');
INSERT INTO `member` VALUES ('522898944108265472', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '522898944108265472', '2018-12-28 20:41:44', '522898944108265472', '2018-12-28 20:41:44');
INSERT INTO `member` VALUES ('523131306125557760', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '523131306125557760', '2018-12-31 12:41:41', '523131306125557760', '2018-12-31 12:41:41');
INSERT INTO `member` VALUES ('523195517895704576', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '523195517895704576', '2018-12-29 12:12:02', '523195517895704576', '2018-12-29 12:12:02');
INSERT INTO `member` VALUES ('523268382355619840', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '523268382355619840', '2018-12-26 14:39:19', '523268382355619840', '2018-12-26 14:39:19');
INSERT INTO `member` VALUES ('524887260525494272', null, null, null, null, null, null, null, null, null, '1', null, null, null, '16', '524887260525494272', '2018-12-24 22:12:17', '524887260525494272', '2018-12-24 22:12:31');
INSERT INTO `member` VALUES ('526136308179927040', null, null, null, null, null, null, null, null, null, '1', null, null, null, '15', '526136308179927040', '2018-12-22 20:37:51', null, null);
INSERT INTO `member` VALUES ('526303687518191616', null, null, null, null, null, null, null, null, null, '1', null, null, null, '4', '526303687518191616', '2018-12-23 07:43:28', null, null);
INSERT INTO `member` VALUES ('527215466574249984', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '527215466574249984', '2019-03-23 15:40:10', '527215466574249984', '2019-03-23 15:40:10');
INSERT INTO `member` VALUES ('527401172592492544', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '527401172592492544', '2018-12-28 15:28:21', '527401172592492544', '2018-12-28 15:28:21');
INSERT INTO `member` VALUES ('527817346845245440', null, null, null, null, null, null, null, null, null, '1', null, null, null, '24', '527817346845245440', '2019-01-05 10:18:42', null, null);
INSERT INTO `member` VALUES ('528504526999650304', null, null, null, null, null, null, null, null, null, '1', null, null, null, '64', '528504526999650304', '2018-12-29 09:29:37', '528504526999650304', '2019-03-14 18:34:14');
INSERT INTO `member` VALUES ('529646964027949056', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '529646964027949056', '2019-01-06 13:13:09', '529646964027949056', '2019-01-06 13:13:09');
INSERT INTO `member` VALUES ('530036578211332096', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '530036578211332096', '2019-01-05 17:33:32', '530036578211332096', '2019-01-05 17:33:32');
INSERT INTO `member` VALUES ('530063862783803392', null, null, null, null, null, null, null, null, null, '1', null, null, null, '21', '530063862783803392', '2019-01-02 16:44:33', null, null);
INSERT INTO `member` VALUES ('530655734237495296', null, null, null, null, null, null, null, null, null, '1', null, null, null, '29', '530655734237495296', '2019-02-18 21:22:02', null, null);
INSERT INTO `member` VALUES ('530671496780054528', null, null, null, null, null, null, null, null, null, '1', null, null, null, '20', '530671496780054528', '2019-01-04 10:21:56', null, null);
INSERT INTO `member` VALUES ('530682931111264256', null, null, null, null, null, null, null, null, null, '1', null, null, null, '4', '530682931111264256', '2019-04-27 16:04:09', '530682931111264256', '2019-05-08 22:40:40');
INSERT INTO `member` VALUES ('530684543288475648', null, null, null, null, null, null, null, null, null, '1', null, null, null, '28', '530684543288475648', '2019-01-04 09:51:22', null, null);
INSERT INTO `member` VALUES ('530763584435650560', null, null, null, null, null, null, null, null, null, '1', null, null, null, '3', '530763584435650560', '2019-01-04 15:05:18', '530763584435650560', '2019-01-04 15:05:32');
INSERT INTO `member` VALUES ('531193380303011840', null, null, null, null, null, null, null, null, null, '1', null, null, null, '28', '531193380303011840', '2019-01-05 19:32:51', null, null);
INSERT INTO `member` VALUES ('531198831472148480', null, null, null, null, null, null, null, null, null, '1', null, null, null, '5', '531198831472148480', '2019-01-06 10:42:39', null, null);
INSERT INTO `member` VALUES ('531463664335585280', null, null, null, null, null, null, null, null, null, '1', null, null, null, '5', '531463664335585280', '2019-01-06 13:27:20', null, null);
INSERT INTO `member` VALUES ('531760962533851136', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '531760962533851136', '2019-01-07 20:46:42', '531760962533851136', '2019-01-07 20:46:42');
INSERT INTO `member` VALUES ('533026919273201664', null, null, null, null, null, null, null, null, null, '1', null, null, null, '19', '533026919273201664', '2019-01-10 20:58:58', null, null);
INSERT INTO `member` VALUES ('534678644358905856', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '534678644358905856', '2019-01-17 20:28:01', '534678644358905856', '2019-01-17 20:28:01');
INSERT INTO `member` VALUES ('534820655208595456', null, null, null, null, null, null, null, null, null, '1', null, null, null, '26', '534820655208595456', '2019-01-15 21:53:10', null, null);
INSERT INTO `member` VALUES ('534857801768370176', null, null, null, null, null, null, null, null, null, '1', null, null, null, '11', '534857801768370176', '2019-01-15 22:19:34', null, null);
INSERT INTO `member` VALUES ('534986068928233472', null, null, null, null, null, null, null, null, null, '1', null, null, null, '29', '534986068928233472', '2019-01-16 06:44:53', null, null);
INSERT INTO `member` VALUES ('535051648821624832', null, null, null, null, null, null, null, null, null, '1', null, null, null, '5', '535051648821624832', '2019-01-16 11:04:31', null, null);
INSERT INTO `member` VALUES ('535368785566105600', null, null, null, null, null, null, null, null, null, '1', null, null, null, '27', '535368785566105600', '2019-01-17 08:07:33', null, null);
INSERT INTO `member` VALUES ('536175873498284032', null, null, null, null, null, null, null, null, null, '1', null, null, null, '19', '536175873498284032', '2019-01-23 22:41:35', null, null);
INSERT INTO `member` VALUES ('537581987150430208', null, null, null, null, null, null, null, null, null, '1', null, null, null, '26', '537581987150430208', '2019-01-27 19:07:02', '537581987150430208', '2019-02-23 14:05:33');
INSERT INTO `member` VALUES ('540849671703101440', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '540849671703101440', '2019-02-01 11:03:43', '540849671703101440', '2019-02-01 11:03:43');
INSERT INTO `member` VALUES ('542125831393116160', null, null, null, null, null, null, null, null, null, '1', null, null, null, '46', '542125831393116160', '2019-02-04 23:35:08', '542125831393116160', '2019-02-16 20:46:19');
INSERT INTO `member` VALUES ('542609078732455936', null, null, null, null, null, null, null, null, null, '1', null, null, null, '1', '542609078732455936', '2019-02-21 08:54:22', null, null);
INSERT INTO `member` VALUES ('542645486696267776', null, null, null, null, null, null, null, null, null, '1', null, null, null, '26', '542645486696267776', '2019-02-09 16:37:50', null, null);
INSERT INTO `member` VALUES ('542756001749663744', null, null, null, null, null, null, null, null, null, '1', null, null, null, '5', '542756001749663744', '2019-02-06 17:36:35', null, null);
INSERT INTO `member` VALUES ('542760627559464960', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '542760627559464960', '2019-02-06 17:37:46', '542760627559464960', '2019-02-06 17:37:46');
INSERT INTO `member` VALUES ('543393650038538240', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '543393650038538240', '2019-02-08 11:38:34', '543393650038538240', '2019-02-08 11:38:34');
INSERT INTO `member` VALUES ('543486290889277440', null, null, null, null, null, null, null, null, null, '1', null, null, null, '3', '543486290889277440', '2019-02-08 17:44:40', null, null);
INSERT INTO `member` VALUES ('545280675389898752', null, null, null, null, null, null, null, null, null, '1', null, null, null, '28', '545280675389898752', '2019-02-13 16:31:00', null, null);
INSERT INTO `member` VALUES ('545631542223831040', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '545631542223831040', '2019-02-14 15:45:10', '545631542223831040', '2019-02-14 15:45:10');
INSERT INTO `member` VALUES ('547840691636535296', null, null, null, null, null, null, null, null, null, '1', null, null, null, '11', '547840691636535296', '2019-02-20 18:05:00', '547840691636535296', '2019-02-20 18:05:10');
INSERT INTO `member` VALUES ('549529816974491648', null, null, null, null, null, null, null, null, null, '1', null, null, null, '15', '549529816974491648', '2019-03-15 15:10:58', null, null);
INSERT INTO `member` VALUES ('549629902832271360', null, null, null, null, null, null, null, null, null, '1', null, null, null, '21', '549629902832271360', '2019-03-06 15:49:32', '549629902832271360', '2019-03-28 19:46:59');
INSERT INTO `member` VALUES ('549642497890975744', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '549642497890975744', '2019-02-25 17:23:45', '549642497890975744', '2019-02-25 17:23:45');
INSERT INTO `member` VALUES ('549647578178781184', null, null, null, null, null, null, null, null, null, '1', null, null, null, '26', '549647578178781184', '2019-02-25 17:43:30', null, null);
INSERT INTO `member` VALUES ('551117546237984768', null, null, null, null, null, null, null, null, null, '1', null, null, null, '24', '551117546237984768', '2019-03-15 15:10:23', null, null);
INSERT INTO `member` VALUES ('552238223779168256', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '552238223779168256', '2019-03-04 21:17:46', '552238223779168256', '2019-03-04 21:17:46');
INSERT INTO `member` VALUES ('552443095552098304', null, null, null, null, null, null, null, null, null, '1', null, null, null, '30', '552443095552098304', '2019-03-05 10:51:54', null, null);
INSERT INTO `member` VALUES ('552883573422555136', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '552883573422555136', '2019-03-06 19:23:39', '552883573422555136', '2019-03-06 19:23:39');
INSERT INTO `member` VALUES ('553343517510860800', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '553343517510860800', '2019-03-07 22:29:43', '553343517510860800', '2019-03-07 22:29:43');
INSERT INTO `member` VALUES ('553685330042028032', null, null, null, null, null, null, null, null, null, '1', null, null, null, '9', '553685330042028032', '2019-03-08 21:07:50', null, null);
INSERT INTO `member` VALUES ('555234985158639616', null, null, null, null, null, null, null, null, null, '1', null, null, null, '2', '555234985158639616', '2019-03-13 03:49:18', null, null);
INSERT INTO `member` VALUES ('557290688249593856', null, null, null, null, null, null, null, null, null, '1', null, null, null, '12', '557290688249593856', '2019-03-18 19:54:14', null, null);
INSERT INTO `member` VALUES ('557290743798956032', null, null, null, null, null, null, null, null, null, '1', null, null, null, '10', '557290743798956032', '2019-03-18 19:54:27', null, null);
INSERT INTO `member` VALUES ('557290814846271488', null, null, null, null, null, null, null, null, null, '1', null, null, null, '2', '557290814846271488', '2019-03-18 19:54:44', null, null);
INSERT INTO `member` VALUES ('557290866201329664', null, null, null, null, null, null, null, null, null, '1', null, null, null, '27', '557290866201329664', '2019-03-18 19:54:56', null, null);
INSERT INTO `member` VALUES ('557291926672375808', null, null, null, null, null, null, null, null, null, '1', null, null, null, '8', '557291926672375808', '2019-03-18 19:59:09', null, null);
INSERT INTO `member` VALUES ('557291991554064384', null, null, null, null, null, null, null, null, null, '1', null, null, null, '23', '557291991554064384', '2019-03-18 19:59:25', null, null);
INSERT INTO `member` VALUES ('557292028187115520', null, null, null, null, null, null, null, null, null, '1', null, null, null, '17', '557292028187115520', '2019-03-18 19:59:33', null, null);
INSERT INTO `member` VALUES ('557728124612116480', null, null, null, null, null, null, null, null, null, '1', null, null, null, '16', '557728124612116480', '2019-03-20 18:13:34', '557728124612116480', '2019-03-20 18:13:43');
INSERT INTO `member` VALUES ('562421265705467904', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '562421265705467904', '2019-04-01 23:43:16', '562421265705467904', '2019-04-01 23:43:16');
INSERT INTO `member` VALUES ('565911816136294400', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '565911816136294400', '2019-04-18 14:21:43', '565911816136294400', '2019-04-18 14:21:43');
INSERT INTO `member` VALUES ('567454471102136320', null, null, null, null, null, null, null, null, null, '1', null, null, null, '29', '567454471102136320', '2019-04-15 21:02:07', null, null);
INSERT INTO `member` VALUES ('569476847666987008', null, null, null, null, null, null, null, null, null, '1', null, null, null, '30', '569476847666987008', '2019-04-21 10:58:04', null, null);
INSERT INTO `member` VALUES ('571306885035065344', null, null, null, null, null, null, null, null, null, '1', null, null, null, '0', '571306885035065344', '2019-04-26 12:11:04', '571306885035065344', '2019-04-26 12:11:04');
INSERT INTO `member` VALUES ('572781947458158592', null, null, null, null, null, null, null, null, null, null, null, null, null, '58', '572781947458158592', '2019-04-30 13:51:55', '572781947458158592', '2019-05-07 09:01:47');
INSERT INTO `member` VALUES ('573096267157078016', null, null, null, null, null, null, null, null, null, null, null, null, null, '8', '573096267157078016', '2019-05-01 10:40:24', null, null);
INSERT INTO `member` VALUES ('ID568730312775827456', null, null, '13870579800', null, null, null, null, '10', '321111111111111102', '1', '', '', '小易', null, null, '2019-04-19 09:46:55', null, '2019-04-19 09:46:55');
INSERT INTO `member` VALUES ('ID568730313816014848', null, null, '13928282882', null, null, null, null, '10', '320992199809691991', '1', '', '', '小牛', null, null, '2019-04-19 09:46:55', null, '2019-04-19 09:46:55');
INSERT INTO `member` VALUES ('ID568760083727515648', '2', null, '13128282882', null, null, null, null, '10', '\'320992199809691891', '1', '2', null, '小明', null, null, '2019-04-19 11:29:30', null, '2019-04-19 11:29:30');
INSERT INTO `member` VALUES ('ID568761065127542784', '2', null, '13128282882', null, null, null, null, '10', '\'320992199809691891', '1', '2', null, '小明', null, null, '2019-04-19 11:33:24', null, '2019-04-19 11:33:24');

-- ----------------------------
-- Table structure for `my_collect`
-- ----------------------------
DROP TABLE IF EXISTS `my_collect`;
CREATE TABLE `my_collect` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `collect_type` varchar(10) DEFAULT NULL COMMENT '被收藏类型(info:资讯,audio:音频,vedio:视频)',
  `collect_id` varchar(30) DEFAULT NULL COMMENT '被收藏主键',
  `create_id` varchar(30) DEFAULT NULL COMMENT '收藏人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`rec_id`),
  KEY `idx_collect` (`collect_type`,`collect_id`,`create_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='我的收藏';

-- ----------------------------
-- Records of my_collect
-- ----------------------------
INSERT INTO `my_collect` VALUES ('ID526706110908858368', 'audio', 'ID525680320045907968', '518084122451640320', '2018-12-24 10:22:02');
INSERT INTO `my_collect` VALUES ('ID526706179049521152', 'audio', 'ID525686848677216256', '518084122451640320', '2018-12-24 10:22:18');
INSERT INTO `my_collect` VALUES ('ID526706217511288832', 'audio', 'ID524899582493065216', '518084122451640320', '2018-12-24 10:22:27');
INSERT INTO `my_collect` VALUES ('ID526706453780627456', 'audio', 'ID518101884913844224', '517366532112646144', '2018-12-24 10:23:24');
INSERT INTO `my_collect` VALUES ('ID526800283716550656', 'audio', 'ID518136921315082240', '517349219414048768', '2018-12-24 16:36:15');
INSERT INTO `my_collect` VALUES ('ID527147166028791808', 'audio', 'ID518098356564656128', '522000062855774208', '2018-12-25 15:34:38');
INSERT INTO `my_collect` VALUES ('ID528232850537840640', 'info', 'ID525642043955871744', '527401172592492544', '2018-12-28 15:28:45');
INSERT INTO `my_collect` VALUES ('ID528505034644652032', 'info', 'ID527067444838137856', '528504526999650304', '2018-12-29 09:30:19');
INSERT INTO `my_collect` VALUES ('ID528505053581934592', 'info', 'ID525642043955871744', '528504526999650304', '2018-12-29 09:30:23');
INSERT INTO `my_collect` VALUES ('ID528505125430362112', 'audio', 'ID518097240917540864', '528504526999650304', '2018-12-29 09:30:41');
INSERT INTO `my_collect` VALUES ('ID528524629912846336', 'audio', 'ID518098356564656128', '516919611287928832', '2018-12-29 10:48:11');
INSERT INTO `my_collect` VALUES ('ID528527433234644992', 'info', 'ID527067444838137856', '516919611287928832', '2018-12-29 10:59:19');
INSERT INTO `my_collect` VALUES ('ID528527441614864384', 'info', 'ID525641099935481856', '516919611287928832', '2018-12-29 10:59:21');
INSERT INTO `my_collect` VALUES ('ID530061479454441472', 'audio', 'ID518128033970782208', '517349219414048768', '2019-01-02 16:35:04');
INSERT INTO `my_collect` VALUES ('ID530074495793233920', 'info', 'ID528523933176037376', '516919611287928832', '2019-01-02 17:26:48');
INSERT INTO `my_collect` VALUES ('ID530074504961982464', 'info', 'ID528523190591291392', '516919611287928832', '2019-01-02 17:26:50');
INSERT INTO `my_collect` VALUES ('ID530764189203955712', 'audio', 'ID519448959479971840', '530763584435650560', '2019-01-04 15:07:23');
INSERT INTO `my_collect` VALUES ('ID531054493639376896', 'audio', 'ID518092325025480704', '531053882562838528', '2019-01-05 10:20:57');
INSERT INTO `my_collect` VALUES ('ID532968692862943232', 'audio', 'ID530074431402278912', '532968691453657088', '2019-01-10 17:07:18');
INSERT INTO `my_collect` VALUES ('ID532994915261480960', '', 'ID532982257195941888', '517349219414048768', '2019-01-10 18:51:30');
INSERT INTO `my_collect` VALUES ('ID533223975275200512', '', 'ID532982257195941888', '517349219414048768', '2019-01-11 10:01:42');
INSERT INTO `my_collect` VALUES ('ID533224058804764672', '', 'ID532982257195941888', '517349219414048768', '2019-01-11 10:02:02');
INSERT INTO `my_collect` VALUES ('ID533224101284675584', '', 'ID532982257195941888', '517349219414048768', '2019-01-11 10:02:12');
INSERT INTO `my_collect` VALUES ('ID533224169869934592', '', 'ID532982257195941888', '517349219414048768', '2019-01-11 10:02:28');
INSERT INTO `my_collect` VALUES ('ID533234778996998144', 'info', 'ID530686243135029248', '516919611287928832', '2019-01-11 10:44:38');
INSERT INTO `my_collect` VALUES ('ID533308111830646784', 'book', 'ID532982257195941888', '517349219414048768', '2019-01-11 15:36:02');
INSERT INTO `my_collect` VALUES ('ID534323245059407872', 'book', 'ID532982257195941888', '517366532112646144', '2019-01-14 10:49:48');
INSERT INTO `my_collect` VALUES ('ID534984709076156416', 'book', 'ID534321710904639488', '518668438701342720', '2019-01-16 06:38:14');
INSERT INTO `my_collect` VALUES ('ID535275513782992896', 'audio', 'ID518089540838096896', '518882036950237184', '2019-01-17 01:53:47');
INSERT INTO `my_collect` VALUES ('ID537289005192970240', 'book', 'ID534322399064096768', '517366313497133056', '2019-01-22 15:14:41');
INSERT INTO `my_collect` VALUES ('ID537289033231892480', 'book', 'ID532982257195941888', '517366313497133056', '2019-01-22 15:14:47');
INSERT INTO `my_collect` VALUES ('ID537289145471467520', 'book', 'ID534321710904639488', '517366313497133056', '2019-01-22 15:15:14');
INSERT INTO `my_collect` VALUES ('ID537648887305863168', 'book', 'ID532982257195941888', '518084122451640320', '2019-01-23 15:04:43');
INSERT INTO `my_collect` VALUES ('ID537648929785774080', 'book', 'ID534321710904639488', '518084122451640320', '2019-01-23 15:04:53');
INSERT INTO `my_collect` VALUES ('ID537649636278534144', 'info', 'ID536943250125094912', '518084122451640320', '2019-01-23 15:07:42');
INSERT INTO `my_collect` VALUES ('ID537649683997130752', 'info', 'ID536933661522526208', '518084122451640320', '2019-01-23 15:07:53');
INSERT INTO `my_collect` VALUES ('ID537649805959102464', 'book', 'ID532982257195941888', '516919611287928832', '2019-01-23 15:08:22');
INSERT INTO `my_collect` VALUES ('ID537709210104758272', 'book', 'ID532982257195941888', '517713552572678144', '2019-01-23 19:04:25');
INSERT INTO `my_collect` VALUES ('ID537738625681457152', 'audio', 'ID535385304635277312', '516919611287928832', '2019-01-23 21:01:19');
INSERT INTO `my_collect` VALUES ('ID537955371621285888', 'audio', 'ID537937799890862080', '516919611287928832', '2019-01-24 11:22:35');
INSERT INTO `my_collect` VALUES ('ID539493101887029248', 'audio', 'ID532501576867119104', '517366532112646144', '2019-01-28 17:12:58');
INSERT INTO `my_collect` VALUES ('ID540579707486208000', 'audio', 'ID537937799890862080', '517366313497133056', '2019-01-31 17:10:45');
INSERT INTO `my_collect` VALUES ('ID540852098678390784', 'book', 'ID540677444353392640', '517713552572678144', '2019-02-01 11:13:08');
INSERT INTO `my_collect` VALUES ('ID540852103514423296', 'book', 'ID540846505183936512', '517366313497133056', '2019-02-01 11:13:10');
INSERT INTO `my_collect` VALUES ('ID548772505511264256', 'audio', 'ID548462666079797248', '517366532112646144', '2019-02-23 07:46:01');
INSERT INTO `my_collect` VALUES ('ID557564064893501440', 'book', 'ID538015249526161408', '516919611287928832', '2019-03-19 14:00:32');
INSERT INTO `my_collect` VALUES ('ID560105762274148352', 'book', 'ID542288738995142656', '517366532112646144', '2019-03-26 14:20:19');
INSERT INTO `my_collect` VALUES ('ID568560202140352512', 'book', 'ID567793485105594368', '517349219414048768', '2019-04-18 22:15:15');

-- ----------------------------
-- Table structure for `my_like`
-- ----------------------------
DROP TABLE IF EXISTS `my_like`;
CREATE TABLE `my_like` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `like_type` varchar(10) DEFAULT NULL COMMENT '被点赞类型(info:资讯,audio:音频,vedio:视频)',
  `like_id` varchar(30) DEFAULT NULL COMMENT '被点赞主键',
  `create_id` varchar(30) DEFAULT NULL COMMENT '点赞人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`rec_id`),
  KEY `idx_like` (`like_type`,`like_id`,`create_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='我的点赞';

-- ----------------------------
-- Records of my_like
-- ----------------------------
INSERT INTO `my_like` VALUES ('ID519572653724401664', 'info', 'ID519100605982048256', '432228697144033280', '2018-12-04 17:56:13');
INSERT INTO `my_like` VALUES ('ID519608313571180544', 'info', 'ID519604878759165952', '517349219414048768', '2018-12-04 20:17:55');
INSERT INTO `my_like` VALUES ('ID519656807786872832', 'info', 'ID519604878759165952', '516919611287928832', '2018-12-04 23:30:37');

-- ----------------------------
-- Table structure for `my_signin`
-- ----------------------------
DROP TABLE IF EXISTS `my_signin`;
CREATE TABLE `my_signin` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `point` int(8) DEFAULT '0' COMMENT '签到获得的积分',
  `create_id` varchar(30) DEFAULT NULL COMMENT '签到人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`rec_id`),
  KEY `idx_userid` (`create_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='我的签到';

-- ----------------------------
-- Records of my_signin
-- ----------------------------
INSERT INTO `my_signin` VALUES ('ID525607567016067072', '13', '517349219414048768', '2018-12-21 09:36:49');
INSERT INTO `my_signin` VALUES ('ID525673852437528576', '2', '516919611287928832', '2018-12-21 14:00:12');
INSERT INTO `my_signin` VALUES ('ID525675836364292096', '23', '517713552572678144', '2018-12-21 14:08:05');
INSERT INTO `my_signin` VALUES ('ID525675859214860288', '19', '517713552572678144', '2018-12-21 14:08:11');
INSERT INTO `my_signin` VALUES ('ID525716438615326720', '4', '516919611287928832', '2018-12-21 16:49:26');
INSERT INTO `my_signin` VALUES ('ID525717270622633984', '24', '516919611287928832', '2018-12-21 16:52:44');
INSERT INTO `my_signin` VALUES ('ID525717595802828800', '19', '516919611287928832', '2018-12-21 16:54:02');
INSERT INTO `my_signin` VALUES ('ID525717863781105664', '9', '516919611287928832', '2018-12-21 16:55:06');
INSERT INTO `my_signin` VALUES ('ID525717884807151616', '11', '516919611287928832', '2018-12-21 16:55:11');
INSERT INTO `my_signin` VALUES ('ID525717906126798848', '11', '516919611287928832', '2018-12-21 16:55:16');
INSERT INTO `my_signin` VALUES ('ID525717926880215040', '21', '516919611287928832', '2018-12-21 16:55:21');
INSERT INTO `my_signin` VALUES ('ID525717952746487808', '10', '516919611287928832', '2018-12-21 16:55:27');
INSERT INTO `my_signin` VALUES ('ID525718293131034624', '12', '516919611287928832', '2018-12-21 16:56:48');
INSERT INTO `my_signin` VALUES ('ID525718975053561856', '9', '516919611287928832', '2018-12-21 16:59:31');
INSERT INTO `my_signin` VALUES ('ID525720257684307968', '24', '516919611287928832', '2018-12-21 17:04:36');
INSERT INTO `my_signin` VALUES ('ID525731490793783296', '9', '516919611287928832', '2018-12-21 17:49:15');
INSERT INTO `my_signin` VALUES ('ID525731772323856384', '1', '516919611287928832', '2018-12-21 17:50:22');
INSERT INTO `my_signin` VALUES ('ID525732133067554816', '1', '516919611287928832', '2018-12-21 17:51:48');
INSERT INTO `my_signin` VALUES ('ID525732318631952384', '3', '516919611287928832', '2018-12-21 17:52:32');
INSERT INTO `my_signin` VALUES ('ID525733365354070016', '5', '516919611287928832', '2018-12-21 17:56:41');
INSERT INTO `my_signin` VALUES ('ID525733405573251072', '17', '516919611287928832', '2018-12-21 17:56:51');
INSERT INTO `my_signin` VALUES ('ID525962022571999232', '28', '516919611287928832', '2018-12-22 09:05:18');
INSERT INTO `my_signin` VALUES ('ID525964273898225664', '28', '517713552572678144', '2018-12-22 09:14:14');
INSERT INTO `my_signin` VALUES ('ID525964916620787712', '5', '517713552572678144', '2018-12-22 09:16:48');
INSERT INTO `my_signin` VALUES ('ID526017597771087872', '9', '517349219414048768', '2018-12-22 12:46:08');
INSERT INTO `my_signin` VALUES ('ID526136309383692288', '15', '526136308179927040', '2018-12-22 20:37:51');
INSERT INTO `my_signin` VALUES ('ID526162217284927488', '25', '518668438701342720', '2018-12-22 22:20:48');
INSERT INTO `my_signin` VALUES ('ID526166153802809344', '30', '517366532112646144', '2018-12-22 22:36:26');
INSERT INTO `my_signin` VALUES ('ID526166235684012032', '10', '517366532112646144', '2018-12-22 22:36:46');
INSERT INTO `my_signin` VALUES ('ID526166285139050496', '25', '517366532112646144', '2018-12-22 22:36:58');
INSERT INTO `my_signin` VALUES ('ID526303819206754304', '4', '526303687518191616', '2018-12-23 07:43:28');
INSERT INTO `my_signin` VALUES ('ID526400914743885824', '29', '522531743010390016', '2018-12-23 14:09:18');
INSERT INTO `my_signin` VALUES ('ID526677820752003072', '9', '516919611287928832', '2018-12-24 08:29:37');
INSERT INTO `my_signin` VALUES ('ID526705485210976256', '14', '517349219414048768', '2018-12-24 10:19:33');
INSERT INTO `my_signin` VALUES ('ID526705518366949376', '15', '518084122451640320', '2018-12-24 10:19:41');
INSERT INTO `my_signin` VALUES ('ID526884907566235648', '16', '524887260525494272', '2018-12-24 22:12:31');
INSERT INTO `my_signin` VALUES ('ID527063216702881792', '24', '518880937937731584', '2018-12-25 10:01:03');
INSERT INTO `my_signin` VALUES ('ID527068659827343360', '7', '518084122451640320', '2018-12-25 10:22:40');
INSERT INTO `my_signin` VALUES ('ID527069779433881600', '18', '517349219414048768', '2018-12-25 10:27:07');
INSERT INTO `my_signin` VALUES ('ID527069829148966912', '19', '517349219414048768', '2018-12-25 10:27:19');
INSERT INTO `my_signin` VALUES ('ID527070579904217088', '13', '517713552572678144', '2018-12-25 10:30:18');
INSERT INTO `my_signin` VALUES ('ID527070611684458496', '8', '517713552572678144', '2018-12-25 10:30:26');
INSERT INTO `my_signin` VALUES ('ID527078703084077056', '4', '516919611287928832', '2018-12-25 11:02:35');
INSERT INTO `my_signin` VALUES ('ID527144495112781824', '30', '517366532112646144', '2018-12-25 15:24:01');
INSERT INTO `my_signin` VALUES ('ID527181399728324608', '23', '522000062855774208', '2018-12-25 17:50:40');
INSERT INTO `my_signin` VALUES ('ID527456502802284544', '3', '518880937937731584', '2018-12-26 12:03:48');
INSERT INTO `my_signin` VALUES ('ID527521323795087360', '25', '516919611287928832', '2018-12-26 16:21:24');
INSERT INTO `my_signin` VALUES ('ID527533313611530240', '8', '517349219414048768', '2018-12-26 17:09:03');
INSERT INTO `my_signin` VALUES ('ID527576067674734592', '12', '517713552572678144', '2018-12-26 19:58:56');
INSERT INTO `my_signin` VALUES ('ID527779226091257856', '9', '518084122451640320', '2018-12-27 09:26:13');
INSERT INTO `my_signin` VALUES ('ID527878148046454784', '20', '516919611287928832', '2018-12-27 15:59:17');
INSERT INTO `my_signin` VALUES ('ID528294010918273024', '14', '516919611287928832', '2018-12-28 19:31:47');
INSERT INTO `my_signin` VALUES ('ID528504937198387200', '23', '528504526999650304', '2018-12-29 09:29:56');
INSERT INTO `my_signin` VALUES ('ID530034689449132032', '17', '517366532112646144', '2019-01-02 14:48:37');
INSERT INTO `my_signin` VALUES ('ID530061717535719424', '26', '517349219414048768', '2019-01-02 16:36:01');
INSERT INTO `my_signin` VALUES ('ID530063864000151552', '21', '530063862783803392', '2019-01-02 16:44:33');
INSERT INTO `my_signin` VALUES ('ID530352030682710016', '27', '517366532112646144', '2019-01-03 11:49:37');
INSERT INTO `my_signin` VALUES ('ID530460404728463360', '8', '516919611287928832', '2019-01-03 19:00:15');
INSERT INTO `my_signin` VALUES ('ID530684658837356544', '28', '530684543288475648', '2019-01-04 09:51:22');
INSERT INTO `my_signin` VALUES ('ID530692353023803392', '20', '530671496780054528', '2019-01-04 10:21:56');
INSERT INTO `my_signin` VALUES ('ID530763720830222336', '3', '530763584435650560', '2019-01-04 15:05:32');
INSERT INTO `my_signin` VALUES ('ID531053927873904640', '24', '527817346845245440', '2019-01-05 10:18:42');
INSERT INTO `my_signin` VALUES ('ID531054126138654720', '12', '518881590537879552', '2019-01-05 10:19:30');
INSERT INTO `my_signin` VALUES ('ID531063969280950272', '3', '517349219414048768', '2019-01-05 10:58:36');
INSERT INTO `my_signin` VALUES ('ID531193381674549248', '28', '531193380303011840', '2019-01-05 19:32:51');
INSERT INTO `my_signin` VALUES ('ID531422340743954432', '5', '531198831472148480', '2019-01-06 10:42:39');
INSERT INTO `my_signin` VALUES ('ID531463784049410048', '5', '531463664335585280', '2019-01-06 13:27:20');
INSERT INTO `my_signin` VALUES ('ID532165039918940160', '17', '518503409347723264', '2019-01-08 11:53:52');
INSERT INTO `my_signin` VALUES ('ID532993706907664384', '17', '517713552572678144', '2019-01-10 18:46:42');
INSERT INTO `my_signin` VALUES ('ID533026992971317248', '19', '533026919273201664', '2019-01-10 20:58:58');
INSERT INTO `my_signin` VALUES ('ID533312048533078016', '16', '528504526999650304', '2019-01-11 15:51:40');
INSERT INTO `my_signin` VALUES ('ID533365520754278400', '3', '517366532112646144', '2019-01-11 19:24:09');
INSERT INTO `my_signin` VALUES ('ID534129774449131520', '22', '520731933508894720', '2019-01-13 22:01:01');
INSERT INTO `my_signin` VALUES ('ID534697649681465344', '19', '517349219414048768', '2019-01-15 11:37:33');
INSERT INTO `my_signin` VALUES ('ID534831398331088896', '14', '517713552572678144', '2019-01-15 20:29:02');
INSERT INTO `my_signin` VALUES ('ID534852571047657472', '26', '534820655208595456', '2019-01-15 21:53:10');
INSERT INTO `my_signin` VALUES ('ID534859216830070784', '11', '534857801768370176', '2019-01-15 22:19:34');
INSERT INTO `my_signin` VALUES ('ID534986385665294336', '29', '534986068928233472', '2019-01-16 06:44:53');
INSERT INTO `my_signin` VALUES ('ID535051723857723392', '5', '535051648821624832', '2019-01-16 11:04:31');
INSERT INTO `my_signin` VALUES ('ID535177264220864512', '19', '517713552572678144', '2019-01-16 19:23:22');
INSERT INTO `my_signin` VALUES ('ID535362586804224000', '5', '517349219414048768', '2019-01-17 07:39:47');
INSERT INTO `my_signin` VALUES ('ID535369576045608960', '27', '535368785566105600', '2019-01-17 08:07:33');
INSERT INTO `my_signin` VALUES ('ID535744944434839552', '20', '517349219414048768', '2019-01-18 08:59:08');
INSERT INTO `my_signin` VALUES ('ID535841776141860864', '8', '517366313497133056', '2019-01-18 15:23:54');
INSERT INTO `my_signin` VALUES ('ID536920215527620608', '3', '517713552572678144', '2019-01-21 14:49:13');
INSERT INTO `my_signin` VALUES ('ID536920222582439936', '12', '517349219414048768', '2019-01-21 14:49:16');
INSERT INTO `my_signin` VALUES ('ID536935035610071040', '10', '522000062855774208', '2019-01-21 15:48:08');
INSERT INTO `my_signin` VALUES ('ID537646467205038080', '19', '517349219414048768', '2019-01-23 14:55:06');
INSERT INTO `my_signin` VALUES ('ID537663527435894784', '11', '517366313497133056', '2019-01-23 16:02:54');
INSERT INTO `my_signin` VALUES ('ID537730982506135552', '2', '517713552572678144', '2019-01-23 20:30:55');
INSERT INTO `my_signin` VALUES ('ID537763859977469952', '19', '536175873498284032', '2019-01-23 22:41:35');
INSERT INTO `my_signin` VALUES ('ID538032862411096064', '27', '517713552572678144', '2019-01-24 16:30:30');
INSERT INTO `my_signin` VALUES ('ID538409052690972672', '9', '517713552572678144', '2019-01-25 17:25:21');
INSERT INTO `my_signin` VALUES ('ID538411021946060800', '1', '516919611287928832', '2019-01-25 17:33:10');
INSERT INTO `my_signin` VALUES ('ID538479608681463808', '29', '517349219414048768', '2019-01-25 22:05:43');
INSERT INTO `my_signin` VALUES ('ID538743928619270144', '12', '528504526999650304', '2019-01-26 15:36:01');
INSERT INTO `my_signin` VALUES ('ID538755584917241856', '30', '516919611287928832', '2019-01-26 16:22:21');
INSERT INTO `my_signin` VALUES ('ID538755961662210048', '15', '516919611287928832', '2019-01-26 16:23:50');
INSERT INTO `my_signin` VALUES ('ID538756067459334144', '8', '516919611287928832', '2019-01-26 16:24:16');
INSERT INTO `my_signin` VALUES ('ID538763173952487424', '31', '517713552572678144', '2019-01-26 16:52:30');
INSERT INTO `my_signin` VALUES ('ID538764091406155776', '27', '516919611287928832', '2019-01-26 16:56:09');
INSERT INTO `my_signin` VALUES ('ID538773823835602944', '4', '516919611287928832', '2019-01-26 17:34:49');
INSERT INTO `my_signin` VALUES ('ID538775338440720384', '12', '517349219414048768', '2019-01-26 17:40:50');
INSERT INTO `my_signin` VALUES ('ID538827416362024960', '22', '517366532112646144', '2019-01-26 21:07:46');
INSERT INTO `my_signin` VALUES ('ID538827424461225984', '15', '517366313497133056', '2019-01-26 21:07:48');
INSERT INTO `my_signin` VALUES ('ID538827846211076096', '13', '518084122451640320', '2019-01-26 21:09:29');
INSERT INTO `my_signin` VALUES ('ID539070851383820288', '4', '528504526999650304', '2019-01-27 13:15:06');
INSERT INTO `my_signin` VALUES ('ID539138370232647680', '13', '518880937937731584', '2019-01-27 17:43:24');
INSERT INTO `my_signin` VALUES ('ID539381861139349504', '19', '517349219414048768', '2019-01-28 09:50:56');
INSERT INTO `my_signin` VALUES ('ID539384038238978048', '5', '517349219414048768', '2019-01-28 09:59:35');
INSERT INTO `my_signin` VALUES ('ID539384208112484352', '26', '517349219414048768', '2019-01-28 10:00:16');
INSERT INTO `my_signin` VALUES ('ID539385437018390528', '6', '517349219414048768', '2019-01-28 10:05:09');
INSERT INTO `my_signin` VALUES ('ID539386544612442112', '30', '517349219414048768', '2019-01-28 10:09:32');
INSERT INTO `my_signin` VALUES ('ID539394505837641728', '28', '517349219414048768', '2019-01-28 10:41:11');
INSERT INTO `my_signin` VALUES ('ID539394772175945728', '11', '517349219414048768', '2019-01-28 10:42:15');
INSERT INTO `my_signin` VALUES ('ID539395498277076992', '11', '517349219414048768', '2019-01-28 10:45:08');
INSERT INTO `my_signin` VALUES ('ID539396101438963712', '12', '517349219414048768', '2019-01-28 10:47:32');
INSERT INTO `my_signin` VALUES ('ID539396204736282624', '16', '517349219414048768', '2019-01-28 10:47:56');
INSERT INTO `my_signin` VALUES ('ID539396272218439680', '18', '517349219414048768', '2019-01-28 10:48:12');
INSERT INTO `my_signin` VALUES ('ID539396642067972096', '3', '516919611287928832', '2019-01-28 10:49:40');
INSERT INTO `my_signin` VALUES ('ID539396698489749504', '19', '517366532112646144', '2019-01-28 10:49:54');
INSERT INTO `my_signin` VALUES ('ID539396777103589376', '20', '517366532112646144', '2019-01-28 10:50:13');
INSERT INTO `my_signin` VALUES ('ID539396801132756992', '22', '517366313497133056', '2019-01-28 10:50:18');
INSERT INTO `my_signin` VALUES ('ID539396813992493056', '4', '517366532112646144', '2019-01-28 10:50:21');
INSERT INTO `my_signin` VALUES ('ID539396861295853568', '10', '517366532112646144', '2019-01-28 10:50:33');
INSERT INTO `my_signin` VALUES ('ID539396864185729024', '15', '517366313497133056', '2019-01-28 10:50:33');
INSERT INTO `my_signin` VALUES ('ID539396903511523328', '5', '517366532112646144', '2019-01-28 10:50:43');
INSERT INTO `my_signin` VALUES ('ID539396907336728576', '26', '517366313497133056', '2019-01-28 10:50:44');
INSERT INTO `my_signin` VALUES ('ID539397488881172480', '31', '528504526999650304', '2019-01-28 10:53:02');
INSERT INTO `my_signin` VALUES ('ID539397792590725120', '27', '517366532112646144', '2019-01-28 10:54:15');
INSERT INTO `my_signin` VALUES ('ID539397830842777600', '17', '517366532112646144', '2019-01-28 10:54:24');
INSERT INTO `my_signin` VALUES ('ID539397861578637312', '10', '517366532112646144', '2019-01-28 10:54:31');
INSERT INTO `my_signin` VALUES ('ID539397960891367424', '13', '517366532112646144', '2019-01-28 10:54:55');
INSERT INTO `my_signin` VALUES ('ID539397994693263360', '24', '517349219414048768', '2019-01-28 10:55:03');
INSERT INTO `my_signin` VALUES ('ID539398017225064448', '27', '517366532112646144', '2019-01-28 10:55:08');
INSERT INTO `my_signin` VALUES ('ID539398088339488768', '4', '517366532112646144', '2019-01-28 10:55:25');
INSERT INTO `my_signin` VALUES ('ID539398333865656320', '2', '517366532112646144', '2019-01-28 10:56:24');
INSERT INTO `my_signin` VALUES ('ID539398916974575616', '9', '517349219414048768', '2019-01-28 10:58:43');
INSERT INTO `my_signin` VALUES ('ID539399436992774144', '19', '517366532112646144', '2019-01-28 11:00:47');
INSERT INTO `my_signin` VALUES ('ID539772294122176512', '4', '528504526999650304', '2019-01-29 11:42:22');
INSERT INTO `my_signin` VALUES ('ID539874258579357696', '23', '517713552572678144', '2019-01-29 18:27:33');
INSERT INTO `my_signin` VALUES ('ID540110591671402496', '31', '517366313497133056', '2019-01-30 10:06:39');
INSERT INTO `my_signin` VALUES ('ID540110646289629184', '7', '518084122451640320', '2019-01-30 10:06:52');
INSERT INTO `my_signin` VALUES ('ID540111825866326016', '9', '518896990185062400', '2019-01-30 10:11:34');
INSERT INTO `my_signin` VALUES ('ID540123211623301120', '26', '517713552572678144', '2019-01-30 10:56:48');
INSERT INTO `my_signin` VALUES ('ID540229776787374080', '2', '518880937937731584', '2019-01-30 18:00:15');
INSERT INTO `my_signin` VALUES ('ID540229922405220352', '2', '528504526999650304', '2019-01-30 18:00:50');
INSERT INTO `my_signin` VALUES ('ID540230119088717824', '7', '517349219414048768', '2019-01-30 18:01:37');
INSERT INTO `my_signin` VALUES ('ID540459416873336832', '27', '528504526999650304', '2019-01-31 09:12:46');
INSERT INTO `my_signin` VALUES ('ID540460630474227712', '18', '517349219414048768', '2019-01-31 09:17:35');
INSERT INTO `my_signin` VALUES ('ID540482184058765312', '6', '518084122451640320', '2019-01-31 10:43:14');
INSERT INTO `my_signin` VALUES ('ID540835032202215424', '26', '518084122451640320', '2019-02-01 10:05:19');
INSERT INTO `my_signin` VALUES ('ID540849725121757184', '24', '519047766756818944', '2019-02-01 11:03:42');
INSERT INTO `my_signin` VALUES ('ID540849731316744192', '5', '517349219414048768', '2019-02-01 11:03:44');
INSERT INTO `my_signin` VALUES ('ID540849734936428544', '27', '518881699824664576', '2019-02-01 11:03:45');
INSERT INTO `my_signin` VALUES ('ID540850069914517504', '10', '518882036950237184', '2019-02-01 11:05:05');
INSERT INTO `my_signin` VALUES ('ID540851130909851648', '12', '528504526999650304', '2019-02-01 11:09:18');
INSERT INTO `my_signin` VALUES ('ID540852202982342656', '8', '516919611287928832', '2019-02-01 11:13:33');
INSERT INTO `my_signin` VALUES ('ID541356076126175232', '10', '517366313497133056', '2019-02-02 20:35:46');
INSERT INTO `my_signin` VALUES ('ID541363001928712192', '15', '517349219414048768', '2019-02-02 21:03:17');
INSERT INTO `my_signin` VALUES ('ID542071423443664896', '19', '528504526999650304', '2019-02-04 19:58:18');
INSERT INTO `my_signin` VALUES ('ID542125989363187712', '20', '542125831393116160', '2019-02-04 23:35:08');
INSERT INTO `my_signin` VALUES ('ID542760536664702976', '5', '542756001749663744', '2019-02-06 17:36:35');
INSERT INTO `my_signin` VALUES ('ID543079377961746432', '27', '528504526999650304', '2019-02-07 14:43:33');
INSERT INTO `my_signin` VALUES ('ID543471578222952448', '17', '516919611287928832', '2019-02-08 16:42:01');
INSERT INTO `my_signin` VALUES ('ID543487342816526336', '3', '543486290889277440', '2019-02-08 17:44:40');
INSERT INTO `my_signin` VALUES ('ID543832912672325632', '26', '542645486696267776', '2019-02-09 16:37:50');
INSERT INTO `my_signin` VALUES ('ID545280745048899584', '28', '545280675389898752', '2019-02-13 16:31:00');
INSERT INTO `my_signin` VALUES ('ID545320215798349824', '29', '528504526999650304', '2019-02-13 19:07:51');
INSERT INTO `my_signin` VALUES ('ID545540665090506752', '24', '517713552572678144', '2019-02-14 09:43:50');
INSERT INTO `my_signin` VALUES ('ID545643993032032256', '6', '517366532112646144', '2019-02-14 16:34:25');
INSERT INTO `my_signin` VALUES ('ID545926671987900416', '1', '517713552572678144', '2019-02-15 11:17:41');
INSERT INTO `my_signin` VALUES ('ID545926912904527872', '12', '517349219414048768', '2019-02-15 11:18:38');
INSERT INTO `my_signin` VALUES ('ID546225212295741440', '24', '522531743010390016', '2019-02-16 07:03:58');
INSERT INTO `my_signin` VALUES ('ID546379964035891200', '2', '517713552572678144', '2019-02-16 17:18:54');
INSERT INTO `my_signin` VALUES ('ID546432160769245184', '26', '542125831393116160', '2019-02-16 20:46:19');
INSERT INTO `my_signin` VALUES ('ID547165924621287424', '29', '530655734237495296', '2019-02-18 21:22:02');
INSERT INTO `my_signin` VALUES ('ID547839334292652032', '6', '516919611287928832', '2019-02-20 17:57:55');
INSERT INTO `my_signin` VALUES ('ID547841160178040832', '11', '547840691636535296', '2019-02-20 18:05:10');
INSERT INTO `my_signin` VALUES ('ID548046570231169024', '25', '519047766756818944', '2019-02-21 07:41:24');
INSERT INTO `my_signin` VALUES ('ID548064931031810048', '1', '542609078732455936', '2019-02-21 08:54:22');
INSERT INTO `my_signin` VALUES ('ID548807065141772288', '9', '522853368662589440', '2019-02-23 10:03:20');
INSERT INTO `my_signin` VALUES ('ID548868020601094144', '26', '537581987150430208', '2019-02-23 14:05:33');
INSERT INTO `my_signin` VALUES ('ID549137594751909888', '25', '522536656230678528', '2019-02-24 07:56:45');
INSERT INTO `my_signin` VALUES ('ID549630160270262272', '23', '517713552572678144', '2019-02-25 16:34:01');
INSERT INTO `my_signin` VALUES ('ID549647644830466048', '26', '549647578178781184', '2019-02-25 17:43:30');
INSERT INTO `my_signin` VALUES ('ID549893024767803392', '23', '521720061925261312', '2019-02-26 09:58:33');
INSERT INTO `my_signin` VALUES ('ID551024445192404992', '19', '517366532112646144', '2019-03-01 12:54:25');
INSERT INTO `my_signin` VALUES ('ID552443165747970048', '30', '552443095552098304', '2019-03-05 10:51:54');
INSERT INTO `my_signin` VALUES ('ID552880456475869184', '7', '549629902832271360', '2019-03-06 15:49:32');
INSERT INTO `my_signin` VALUES ('ID553685332281786368', '9', '553685330042028032', '2019-03-08 21:07:50');
INSERT INTO `my_signin` VALUES ('ID554373499276230656', '15', '517713552572678144', '2019-03-10 18:42:21');
INSERT INTO `my_signin` VALUES ('ID555235915568513024', '2', '555234985158639616', '2019-03-13 03:49:18');
INSERT INTO `my_signin` VALUES ('ID555821005818298368', '9', '528504526999650304', '2019-03-14 18:34:14');
INSERT INTO `my_signin` VALUES ('ID556131216756047872', '28', '517713552572678144', '2019-03-15 15:06:54');
INSERT INTO `my_signin` VALUES ('ID556132092816130048', '24', '551117546237984768', '2019-03-15 15:10:23');
INSERT INTO `my_signin` VALUES ('ID556132239461580800', '15', '549529816974491648', '2019-03-15 15:10:58');
INSERT INTO `my_signin` VALUES ('ID557290689633714176', '12', '557290688249593856', '2019-03-18 19:54:14');
INSERT INTO `my_signin` VALUES ('ID557290745090801664', '10', '557290743798956032', '2019-03-18 19:54:27');
INSERT INTO `my_signin` VALUES ('ID557290816112951296', '2', '557290814846271488', '2019-03-18 19:54:44');
INSERT INTO `my_signin` VALUES ('ID557290867694501888', '27', '557290866201329664', '2019-03-18 19:54:56');
INSERT INTO `my_signin` VALUES ('ID557291927976804352', '8', '557291926672375808', '2019-03-18 19:59:09');
INSERT INTO `my_signin` VALUES ('ID557291992782995456', '23', '557291991554064384', '2019-03-18 19:59:25');
INSERT INTO `my_signin` VALUES ('ID557292029466378240', '17', '557292028187115520', '2019-03-18 19:59:33');
INSERT INTO `my_signin` VALUES ('ID557990171488813056', '16', '557728124612116480', '2019-03-20 18:13:43');
INSERT INTO `my_signin` VALUES ('ID558217972745764864', '29', '516919611287928832', '2019-03-21 09:18:55');
INSERT INTO `my_signin` VALUES ('ID558349890699132928', '3', '517713552572678144', '2019-03-21 18:03:07');
INSERT INTO `my_signin` VALUES ('ID560912746057564160', '14', '549629902832271360', '2019-03-28 19:46:59');
INSERT INTO `my_signin` VALUES ('ID563350169064570880', '20', '518880937937731584', '2019-04-04 13:12:26');
INSERT INTO `my_signin` VALUES ('ID564869105291624448', '12', '517713552572678144', '2019-04-08 17:48:09');
INSERT INTO `my_signin` VALUES ('ID567454634537385984', '29', '567454471102136320', '2019-04-15 21:02:07');
INSERT INTO `my_signin` VALUES ('ID568338156353486848', '24', '517366313497133056', '2019-04-18 07:32:55');
INSERT INTO `my_signin` VALUES ('ID568338157762772992', '7', '517366313497133056', '2019-04-18 07:32:56');
INSERT INTO `my_signin` VALUES ('ID568378608763011072', '24', '517713552572678144', '2019-04-18 10:13:40');
INSERT INTO `my_signin` VALUES ('ID568560088453742592', '29', '517349219414048768', '2019-04-18 22:14:48');
INSERT INTO `my_signin` VALUES ('ID569476948762296320', '30', '569476847666987008', '2019-04-21 10:58:04');
INSERT INTO `my_signin` VALUES ('ID570643018663591936', '10', '518882959818752000', '2019-04-24 16:11:37');
INSERT INTO `my_signin` VALUES ('ID570662632801959936', '2', '517349219414048768', '2019-04-24 17:29:34');
INSERT INTO `my_signin` VALUES ('ID571043002911293440', '19', '518880937937731584', '2019-04-25 18:41:01');
INSERT INTO `my_signin` VALUES ('ID572438687447515136', '6', '517349219414048768', '2019-04-29 15:06:58');
INSERT INTO `my_signin` VALUES ('ID572513297253793792', '5', '517713552572678144', '2019-04-29 20:03:26');
INSERT INTO `my_signin` VALUES ('ID573096378922696704', '8', '573096267157078016', '2019-05-01 10:40:24');
INSERT INTO `my_signin` VALUES ('ID574607700868988928', '20', '572781947458158592', '2019-05-05 14:45:51');
INSERT INTO `my_signin` VALUES ('ID574880776101822464', '21', '572781947458158592', '2019-05-06 08:50:57');
INSERT INTO `my_signin` VALUES ('ID575245888499220480', '17', '572781947458158592', '2019-05-07 09:01:47');
INSERT INTO `my_signin` VALUES ('ID575401693101948928', '27', '517713552572678144', '2019-05-07 19:20:54');
INSERT INTO `my_signin` VALUES ('ID575702757843927040', '13', '517713552572678144', '2019-05-08 15:17:13');
INSERT INTO `my_signin` VALUES ('ID575814354276974592', '4', '530682931111264256', '2019-05-08 22:40:40');
INSERT INTO `my_signin` VALUES ('ID576099593373089792', '20', '517366313497133056', '2019-05-09 17:34:06');

-- ----------------------------
-- Table structure for `recommend`
-- ----------------------------
DROP TABLE IF EXISTS `recommend`;
CREATE TABLE `recommend` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `recommend_type` varchar(10) DEFAULT NULL COMMENT '被推荐类型(info:资讯,audio:音频,vedio:视频)',
  `recommend_id` varchar(30) DEFAULT NULL COMMENT '被推荐主键',
  `image` varchar(500) DEFAULT NULL COMMENT '推荐图片',
  `level` varchar(30) DEFAULT NULL COMMENT '推荐年级',
  `menu` varchar(30) DEFAULT NULL COMMENT '推荐栏目',
  `create_id` varchar(30) DEFAULT NULL COMMENT '推荐人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '推荐时间',
  `start_time` varchar(30) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(30) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='推荐';

-- ----------------------------
-- Records of recommend
-- ----------------------------
INSERT INTO `recommend` VALUES ('22222', 'lesson', '13', 'http://img.jssns.cn/SHILU/1/b1a19a15b3c78190ce37429cdf80a976.png', null, '1', '432228697144033280', '2019-01-14 10:46:27', null, null);
INSERT INTO `recommend` VALUES ('22223', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/be369acf95da27ee3673c7ac9f9be68a.jpg', '', '1', '432228697144033280', '2019-01-14 10:46:27', '', '');

-- ----------------------------
-- Table structure for `relevance_item`
-- ----------------------------
DROP TABLE IF EXISTS `relevance_item`;
CREATE TABLE `relevance_item` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `category_id` varchar(30) DEFAULT NULL COMMENT '目录id',
  `item_id` varchar(30) DEFAULT NULL COMMENT '项目id',
  `item_type` varchar(30) DEFAULT NULL COMMENT '类型',
  `weight` varchar(30) DEFAULT NULL COMMENT '目录排序',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='书籍与目录对应关系';

-- ----------------------------
-- Records of relevance_item
-- ----------------------------

-- ----------------------------
-- Table structure for `section`
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '章节名称',
  `intro` text COMMENT '章节描述',
  `lession_id` varchar(30) DEFAULT NULL COMMENT '课程id ',
  `image` varchar(200) DEFAULT NULL COMMENT '图片URL',
  `banner` varchar(200) DEFAULT NULL COMMENT 'banner',
  `publish_status` varchar(6) DEFAULT NULL COMMENT '发布状态(0 未发布，1已发布)',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `visit_num` bigint(11) DEFAULT NULL COMMENT '访问数量',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='章节';

-- ----------------------------
-- Records of section
-- ----------------------------

-- ----------------------------
-- Table structure for `share_image`
-- ----------------------------
DROP TABLE IF EXISTS `share_image`;
CREATE TABLE `share_image` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `user_id` varchar(30) NOT NULL COMMENT '用户（当前登录的用户信息）',
  `share_type` varchar(10) DEFAULT NULL COMMENT '被分享的类型(audio:音频,video:视频)',
  `share_id` varchar(30) DEFAULT NULL COMMENT '被分享主键',
  `url` varchar(500) DEFAULT NULL COMMENT '分享图片URL',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分享图片';

-- ----------------------------
-- Records of share_image
-- ----------------------------
INSERT INTO `share_image` VALUES ('', '', null, null, null, null, null, null, null);
INSERT INTO `share_image` VALUES ('ID534423444071120896', '516919611287928832', 'audio', 'ID518128033970782208', 'http://img.jssns.cn/SHILU/1/44064968784874013.png', '516919611287928832', '2019-01-14 17:27:58', null, null);
INSERT INTO `share_image` VALUES ('ID534423446222798848', '516919611287928832', 'audio', 'ID518128033970782208', 'http://img.jssns.cn/SHILU/1/44064969516096657.png', '516919611287928832', '2019-01-14 17:27:58', null, null);
INSERT INTO `share_image` VALUES ('ID534429518971011072', '517713552572678144', 'audio', 'ID533605795837771776', 'http://img.jssns.cn/SHILU/1/44066417126755323.png', '517713552572678144', '2019-01-14 17:52:06', null, null);
INSERT INTO `share_image` VALUES ('ID534429525593817088', '517713552572678144', 'audio', 'ID533605795837771776', 'http://img.jssns.cn/SHILU/1/44066418943137836.png', '517713552572678144', '2019-01-14 17:52:08', null, null);
INSERT INTO `share_image` VALUES ('ID534429531000274944', '517713552572678144', 'audio', 'ID533605795837771776', 'http://img.jssns.cn/SHILU/1/44066419973535326.png', '517713552572678144', '2019-01-14 17:52:09', null, null);
INSERT INTO `share_image` VALUES ('ID534429539657318400', '517713552572678144', 'audio', 'ID533605795837771776', 'http://img.jssns.cn/SHILU/1/44066422309608633.png', '517713552572678144', '2019-01-14 17:52:11', null, null);
INSERT INTO `share_image` VALUES ('ID534429542534610944', '517713552572678144', 'audio', 'ID533605795837771776', 'http://img.jssns.cn/SHILU/1/44066422985394427.png', '517713552572678144', '2019-01-14 17:52:12', null, null);
INSERT INTO `share_image` VALUES ('ID534429621412691968', '517713552572678144', 'audio', 'ID531530446631075840', 'http://img.jssns.cn/SHILU/1/44066441774162028.png', '517713552572678144', '2019-01-14 17:52:30', null, null);
INSERT INTO `share_image` VALUES ('ID534429849704464384', '517713552572678144', 'audio', 'ID525686848677216256', 'http://img.jssns.cn/SHILU/1/44066496132311955.png', '517713552572678144', '2019-01-14 17:53:25', null, null);
INSERT INTO `share_image` VALUES ('ID534431261230366720', '517349219414048768', 'audio', 'ID518083290419167232', 'http://img.jssns.cn/SHILU/1/44066832730049121.png', '517349219414048768', '2019-01-14 17:59:01', null, null);
INSERT INTO `share_image` VALUES ('ID534431650201731072', '517349219414048768', 'audio', 'ID520176596611497984', 'http://img.jssns.cn/SHILU/1/44066925305973264.png', '517349219414048768', '2019-01-14 18:00:34', null, null);
INSERT INTO `share_image` VALUES ('ID534434151625916416', '517713552572678144', 'audio', 'ID519454529536655360', 'http://img.jssns.cn/SHILU/1/44067521857789301.png', '517713552572678144', '2019-01-14 18:10:31', null, null);
INSERT INTO `share_image` VALUES ('ID534434299911340032', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067557201824474.png', '517713552572678144', '2019-01-14 18:11:06', null, null);
INSERT INTO `share_image` VALUES ('ID534434308488691712', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067559103520637.png', '517713552572678144', '2019-01-14 18:11:08', null, null);
INSERT INTO `share_image` VALUES ('ID534434313815457792', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067560502705910.png', '517713552572678144', '2019-01-14 18:11:09', null, null);
INSERT INTO `share_image` VALUES ('ID534434316403343360', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067561102962155.png', '517713552572678144', '2019-01-14 18:11:10', null, null);
INSERT INTO `share_image` VALUES ('ID534434317900709888', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067561394588393.png', '517713552572678144', '2019-01-14 18:11:10', null, null);
INSERT INTO `share_image` VALUES ('ID534434318932508672', '517713552572678144', 'audio', 'ID518087975544815616', 'http://img.jssns.cn/SHILU/1/44067561654622139.png', '517713552572678144', '2019-01-14 18:11:10', null, null);
INSERT INTO `share_image` VALUES ('ID534434342332530688', '517713552572678144', 'audio', 'ID524909182437031936', 'http://img.jssns.cn/SHILU/1/44067567343881015.png', '517713552572678144', '2019-01-14 18:11:16', null, null);
INSERT INTO `share_image` VALUES ('ID534458479604137984', '517713552572678144', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44073321434008017.png', '517713552572678144', '2019-01-14 19:47:10', null, null);
INSERT INTO `share_image` VALUES ('ID534459856065658880', '517713552572678144', 'book', 'ID534322399064096768', 'http://img.jssns.cn/SHILU/1/44073650167070491.png', '517713552572678144', '2019-01-14 19:52:39', null, null);
INSERT INTO `share_image` VALUES ('ID534466979491217408', '516919611287928832', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44075348326272566.png', '516919611287928832', '2019-01-14 20:20:57', null, null);
INSERT INTO `share_image` VALUES ('ID534473519199682560', '517349219414048768', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44076907828442302.png', '517349219414048768', '2019-01-14 20:46:57', null, null);
INSERT INTO `share_image` VALUES ('ID534541813009088512', '521736048980525056', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/44093190192170757.png', '521736048980525056', '2019-01-15 01:18:19', null, null);
INSERT INTO `share_image` VALUES ('ID534696495127986176', '517349219414048768', 'book', 'ID534322399064096768', 'http://img.jssns.cn/SHILU/1/44130069314700535.png', '517349219414048768', '2019-01-15 11:32:58', null, null);
INSERT INTO `share_image` VALUES ('ID534696527382183936', '517349219414048768', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/44130077074373809.png', '517349219414048768', '2019-01-15 11:33:06', null, null);
INSERT INTO `share_image` VALUES ('ID534740899125526528', '516919611287928832', 'audio', 'ID518136921315082240', 'http://img.jssns.cn/SHILU/1/44140655701674433.png', '516919611287928832', '2019-01-15 14:29:25', null, null);
INSERT INTO `share_image` VALUES ('ID534755188209090560', '534755179401052160', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44144062295666265.png', '534755179401052160', '2019-01-15 15:26:12', null, null);
INSERT INTO `share_image` VALUES ('ID534795150015070208', '518668438701342720', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44153590403210095.png', '518668438701342720', '2019-01-15 18:04:59', null, null);
INSERT INTO `share_image` VALUES ('ID534795152154165248', '518668438701342720', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44153591096528913.png', '518668438701342720', '2019-01-15 18:05:00', null, null);
INSERT INTO `share_image` VALUES ('ID534855724065357824', '517349219414048768', 'audio', 'ID518418068611792896', 'http://img.jssns.cn/SHILU/1/44168032255447446.png', '517349219414048768', '2019-01-15 22:05:41', null, null);
INSERT INTO `share_image` VALUES ('ID534981264323641344', '518668438701342720', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/44197963447266257.png', '518668438701342720', '2019-01-16 06:24:32', null, null);
INSERT INTO `share_image` VALUES ('ID534990655059918848', '522515811546431488', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/44200202120877257.png', '522515811546431488', '2019-01-16 07:01:51', null, null);
INSERT INTO `share_image` VALUES ('ID535044731726462976', '535044327940816896', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/44213095468738652.png', '535044327940816896', '2019-01-16 10:36:44', null, null);
INSERT INTO `share_image` VALUES ('ID535057560844107776', '535056977512890368', 'audio', 'ID530074431402278912', 'http://img.jssns.cn/SHILU/1/44216154201252974.png', '535056977512890368', '2019-01-16 11:27:43', null, null);
INSERT INTO `share_image` VALUES ('ID535065276534751232', '535056977512890368', 'audio', 'ID518128033970782208', 'http://img.jssns.cn/SHILU/1/44217993751270906.png', '535056977512890368', '2019-01-16 11:58:22', null, null);
INSERT INTO `share_image` VALUES ('ID535141358323630080', '517366532112646144', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44236132582556679.png', '517366532112646144', '2019-01-16 17:00:41', null, null);
INSERT INTO `share_image` VALUES ('ID535141658782597120', '518084122451640320', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/44236204704379680.png', '518084122451640320', '2019-01-16 17:01:53', null, null);
INSERT INTO `share_image` VALUES ('ID535169456431693824', '535124454901022720', 'audio', 'ID519450551428055040', 'http://img.jssns.cn/SHILU/1/44242832202041535.png', '535124454901022720', '2019-01-16 18:52:21', null, null);
INSERT INTO `share_image` VALUES ('ID535356396787466240', '518668438701342720', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44287402050751680.png', '518668438701342720', '2019-01-17 07:15:11', null, null);
INSERT INTO `share_image` VALUES ('ID535362161237557248', '517349219414048768', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44288776278892765.png', '517349219414048768', '2019-01-17 07:38:05', null, null);
INSERT INTO `share_image` VALUES ('ID535386606584987648', '522000062855774208', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44294604848594439.png', '522000062855774208', '2019-01-17 09:15:14', null, null);
INSERT INTO `share_image` VALUES ('ID535386830019756032', '518084122451640320', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44294658119091283.png', '518084122451640320', '2019-01-17 09:16:07', null, null);
INSERT INTO `share_image` VALUES ('ID535386952094973952', '518084122451640320', 'audio', 'ID534414899401457664', 'http://img.jssns.cn/SHILU/1/44294687206340577.png', '518084122451640320', '2019-01-17 09:16:36', null, null);
INSERT INTO `share_image` VALUES ('ID535387053861371904', '518084122451640320', 'audio', 'ID534401259780702208', 'http://img.jssns.cn/SHILU/1/44294711483320993.png', '518084122451640320', '2019-01-17 09:17:00', null, null);
INSERT INTO `share_image` VALUES ('ID535387176188248064', '518084122451640320', 'audio', 'ID532501576867119104', 'http://img.jssns.cn/SHILU/1/44294740559198583.png', '518084122451640320', '2019-01-17 09:17:29', null, null);
INSERT INTO `share_image` VALUES ('ID535567886614265856', '518880937937731584', 'audio', 'ID535385304635277312', 'http://img.jssns.cn/SHILU/1/44337825148884877.png', '518880937937731584', '2019-01-17 21:15:34', null, null);
INSERT INTO `share_image` VALUES ('ID535723306649649152', '518668438701342720', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/44374880050534404.png', '518668438701342720', '2019-01-18 07:33:09', null, null);
INSERT INTO `share_image` VALUES ('ID535779453805002752', '518084122451640320', 'audio', 'ID535777043741147136', 'http://img.jssns.cn/SHILU/1/44388266893868071.png', '518084122451640320', '2019-01-18 11:16:16', null, null);
INSERT INTO `share_image` VALUES ('ID535871748617273344', '517713552572678144', 'audio', 'ID518103250356928512', 'http://img.jssns.cn/SHILU/1/44410271312933335.png', '517713552572678144', '2019-01-18 17:23:00', null, null);
INSERT INTO `share_image` VALUES ('ID535871750932529152', '517713552572678144', 'audio', 'ID518103250356928512', 'http://img.jssns.cn/SHILU/1/44410272213293670.png', '517713552572678144', '2019-01-18 17:23:01', null, null);
INSERT INTO `share_image` VALUES ('ID535909560922144768', '535092127965642752', 'audio', 'ID534404740755226624', 'http://img.jssns.cn/SHILU/1/44419286832623043.png', '535092127965642752', '2019-01-18 19:53:16', null, null);
INSERT INTO `share_image` VALUES ('ID536823662502739968', '528316923792850944', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44637225527128275.png', '528316923792850944', '2019-01-21 08:25:34', null, null);
INSERT INTO `share_image` VALUES ('ID536824661925691392', '528316923792850944', 'audio', 'ID518137315487383552', 'http://img.jssns.cn/SHILU/1/44637463940836474.png', '528316923792850944', '2019-01-21 08:29:33', null, null);
INSERT INTO `share_image` VALUES ('ID536843797426864128', '528316923792850944', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/44642026208180363.png', '528316923792850944', '2019-01-21 09:45:35', null, null);
INSERT INTO `share_image` VALUES ('ID536844948876558336', '528316923792850944', 'audio', 'ID518107379900874752', 'http://img.jssns.cn/SHILU/1/44642300630351469.png', '528316923792850944', '2019-01-21 09:50:09', null, null);
INSERT INTO `share_image` VALUES ('ID536848290595995648', '528316923792850944', 'audio', 'ID518418068611792896', 'http://img.jssns.cn/SHILU/1/44643097300925300.png', '528316923792850944', '2019-01-21 10:03:26', null, null);
INSERT INTO `share_image` VALUES ('ID537053397644214272', '518880937937731584', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44691998575951456.png', '518880937937731584', '2019-01-21 23:38:27', null, null);
INSERT INTO `share_image` VALUES ('ID537170018245279744', '518668438701342720', 'book', 'ID534322399064096768', 'http://img.jssns.cn/SHILU/1/44719803161632499.png', '518668438701342720', '2019-01-22 07:21:52', null, null);
INSERT INTO `share_image` VALUES ('ID537170083202465792', '518668438701342720', 'audio', 'ID535385304635277312', 'http://img.jssns.cn/SHILU/1/44719818779238543.png', '518668438701342720', '2019-01-22 07:22:07', null, null);
INSERT INTO `share_image` VALUES ('ID537306944587694080', '516919611287928832', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/44752449075877801.png', '516919611287928832', '2019-01-22 16:25:58', null, null);
INSERT INTO `share_image` VALUES ('ID537581791033163776', '517366532112646144', 'audio', 'ID537561196815974400', 'http://img.jssns.cn/SHILU/1/44817977565285480.png', '517366532112646144', '2019-01-23 10:38:06', null, null);
INSERT INTO `share_image` VALUES ('ID537639589565693952', '516919611287928832', 'issue', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/44831757822147124.png', '516919611287928832', '2019-01-23 14:27:47', null, null);
INSERT INTO `share_image` VALUES ('ID537689929631662080', '537581987150430208', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/44843759769764759.png', '537581987150430208', '2019-01-23 17:47:49', null, null);
INSERT INTO `share_image` VALUES ('ID537689939869958144', '537581987150430208', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/44843762188559926.png', '537581987150430208', '2019-01-23 17:47:51', null, null);
INSERT INTO `share_image` VALUES ('ID537689947755249664', '537581987150430208', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/44843764150659555.png', '537581987150430208', '2019-01-23 17:47:53', null, null);
INSERT INTO `share_image` VALUES ('ID537689958022905856', '537581987150430208', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/44843766606173954.png', '537581987150430208', '2019-01-23 17:47:55', null, null);
INSERT INTO `share_image` VALUES ('ID537689958190678016', '537581987150430208', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/44843766672991466.png', '537581987150430208', '2019-01-23 17:47:55', null, null);
INSERT INTO `share_image` VALUES ('ID537741133757808640', '516919611287928832', 'audio', 'ID518417670446514176', 'http://img.jssns.cn/SHILU/1/44855967849877957.png', '516919611287928832', '2019-01-23 21:11:17', null, null);
INSERT INTO `share_image` VALUES ('ID537959775153946624', '516919611287928832', 'audio', 'ID537934717702373376', 'http://img.jssns.cn/SHILU/1/44908095770931638.png', '516919611287928832', '2019-01-24 11:40:05', null, null);
INSERT INTO `share_image` VALUES ('ID537961622761635840', '516919611287928832', 'audio', 'ID535385304635277312', 'http://img.jssns.cn/SHILU/1/44908536473671509.png', '516919611287928832', '2019-01-24 11:47:25', null, null);
INSERT INTO `share_image` VALUES ('ID537963661780582400', '516919611287928832', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/44909022518606510.png', '516919611287928832', '2019-01-24 11:55:31', null, null);
INSERT INTO `share_image` VALUES ('ID538044030173315072', '517366532112646144', 'audio', 'ID537650488993120256', 'http://img.jssns.cn/SHILU/1/44928183957609325.png', '517366532112646144', '2019-01-24 17:14:53', null, null);
INSERT INTO `share_image` VALUES ('ID538101877703704576', '528504526999650304', 'audio', 'ID537937799890862080', 'http://img.jssns.cn/SHILU/1/44941975666218709.png', '528504526999650304', '2019-01-24 21:04:45', null, null);
INSERT INTO `share_image` VALUES ('ID538107711141707776', '518084122451640320', 'audio', 'ID537922955988959232', 'http://img.jssns.cn/SHILU/1/44943366493955582.png', '518084122451640320', '2019-01-24 21:27:55', null, null);
INSERT INTO `share_image` VALUES ('ID538107836882747392', '518084122451640320', 'audio', 'ID537937799890862080', 'http://img.jssns.cn/SHILU/1/44943396658344393.png', '518084122451640320', '2019-01-24 21:28:25', null, null);
INSERT INTO `share_image` VALUES ('ID538107945641050112', '518084122451640320', 'audio', 'ID537650488993120256', 'http://img.jssns.cn/SHILU/1/44943422556311097.png', '518084122451640320', '2019-01-24 21:28:51', null, null);
INSERT INTO `share_image` VALUES ('ID538297985105133568', '516919611287928832', 'bookAudio', '131231231', 'http://img.jssns.cn/SHILU/1/44988731362804026.png', '516919611287928832', '2019-01-25 10:04:00', null, null);
INSERT INTO `share_image` VALUES ('ID538305308674490368', '516919611287928832', 'book', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/44990477595109973.png', '516919611287928832', '2019-01-25 10:33:06', null, null);
INSERT INTO `share_image` VALUES ('ID538362512303718400', '528504526999650304', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/45004115623697462.png', '528504526999650304', '2019-01-25 14:20:25', null, null);
INSERT INTO `share_image` VALUES ('ID538363911850688512', '477136084623425536', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/45004449688448304.png', '477136084623425536', '2019-01-25 14:25:58', null, null);
INSERT INTO `share_image` VALUES ('ID538365316292411392', '518881699824664576', 'issue', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/45004784542359302.png', '518881699824664576', '2019-01-25 14:31:33', null, null);
INSERT INTO `share_image` VALUES ('ID538369199551021056', '477136084623425536', 'audio', 'ID536931748764712960', 'http://img.jssns.cn/SHILU/1/45005710168635237.png', '477136084623425536', '2019-01-25 14:46:59', null, null);
INSERT INTO `share_image` VALUES ('ID538369778520162304', '477136084623425536', 'audio', 'ID537656827878309888', 'http://img.jssns.cn/SHILU/1/45005848418904363.png', '477136084623425536', '2019-01-25 14:49:17', null, null);
INSERT INTO `share_image` VALUES ('ID538369804365463552', '477136084623425536', 'audio', 'ID537657125153800192', 'http://img.jssns.cn/SHILU/1/45005854614560217.png', '477136084623425536', '2019-01-25 14:49:23', null, null);
INSERT INTO `share_image` VALUES ('ID538372118480420864', '477136084623425536', 'audio', 'ID529380122512326656', 'http://img.jssns.cn/SHILU/1/45006406366871851.png', '477136084623425536', '2019-01-25 14:58:35', null, null);
INSERT INTO `share_image` VALUES ('ID538382582945939456', '477136084623425536', 'audio', 'ID537922955988959232', 'http://img.jssns.cn/SHILU/1/45008901022808084.png', '477136084623425536', '2019-01-25 15:40:10', null, null);
INSERT INTO `share_image` VALUES ('ID538384397376684032', '477136084623425536', 'audio', 'ID535777043741147136', 'http://img.jssns.cn/SHILU/1/45009333830496874.png', '477136084623425536', '2019-01-25 15:47:23', null, null);
INSERT INTO `share_image` VALUES ('ID538400338659508224', '537692823621730304', 'audio', 'ID537656827878309888', 'http://img.jssns.cn/SHILU/1/45013134478687016.png', '537692823621730304', '2019-01-25 16:50:43', null, null);
INSERT INTO `share_image` VALUES ('ID538400503713759232', '537692823621730304', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/45013173814179184.png', '537692823621730304', '2019-01-25 16:51:23', null, null);
INSERT INTO `share_image` VALUES ('ID538400511523553280', '537692823621730304', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/45013175778387007.png', '537692823621730304', '2019-01-25 16:51:24', null, null);
INSERT INTO `share_image` VALUES ('ID538410470525108224', '517713552572678144', 'issue', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/45015550158184938.png', '517713552572678144', '2019-01-25 17:30:59', null, null);
INSERT INTO `share_image` VALUES ('ID538438645141471232', '516919611287928832', 'audio', 'ID524909182437031936', 'http://img.jssns.cn/SHILU/1/45022267433915308.png', '516919611287928832', '2019-01-25 19:22:56', null, null);
INSERT INTO `share_image` VALUES ('ID538649595517861888', '522000062855774208', 'audio', 'ID537922955988959232', 'http://img.jssns.cn/SHILU/1/45072561876737976.png', '522000062855774208', '2019-01-26 09:21:11', null, null);
INSERT INTO `share_image` VALUES ('ID538651029399404544', '522000062855774208', 'audio', 'ID538380303387852800', 'http://img.jssns.cn/SHILU/1/45072903863347184.png', '522000062855774208', '2019-01-26 09:26:53', null, null);
INSERT INTO `share_image` VALUES ('ID538651136085721088', '522000062855774208', 'audio', 'ID537937799890862080', 'http://img.jssns.cn/SHILU/1/45072929256910034.png', '522000062855774208', '2019-01-26 09:27:18', null, null);
INSERT INTO `share_image` VALUES ('ID538651233133527040', '522000062855774208', 'audio', 'ID537657125153800192', 'http://img.jssns.cn/SHILU/1/45072952393550566.png', '522000062855774208', '2019-01-26 09:27:41', null, null);
INSERT INTO `share_image` VALUES ('ID538746628543086592', '518668438701342720', 'audio', 'ID537922955988959232', 'http://img.jssns.cn/SHILU/1/45095696308688933.png', '518668438701342720', '2019-01-26 15:46:45', null, null);
INSERT INTO `share_image` VALUES ('ID538746753365573632', '518668438701342720', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/45095726266813346.png', '518668438701342720', '2019-01-26 15:47:15', null, null);
INSERT INTO `share_image` VALUES ('ID538746879307939840', '518668438701342720', 'audio', 'ID537937799890862080', 'http://img.jssns.cn/SHILU/1/45095756275430469.png', '518668438701342720', '2019-01-26 15:47:45', null, null);
INSERT INTO `share_image` VALUES ('ID538747051970658304', '518668438701342720', 'audio', 'ID521698898528436224', 'http://img.jssns.cn/SHILU/1/45095797310410823.png', '518668438701342720', '2019-01-26 15:48:26', null, null);
INSERT INTO `share_image` VALUES ('ID538778325275901952', '516919611287928832', 'audio', 'ID537922955988959232', 'http://img.jssns.cn/SHILU/1/45103252939401153.png', '516919611287928832', '2019-01-26 17:52:42', null, null);
INSERT INTO `share_image` VALUES ('ID538778556155559936', '516919611287928832', 'audio', 'ID532501576867119104', 'http://img.jssns.cn/SHILU/1/45103308628727548.png', '516919611287928832', '2019-01-26 17:53:37', null, null);
INSERT INTO `share_image` VALUES ('ID538779713796046848', '517349219414048768', 'book', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/45103584593457606.png', '517349219414048768', '2019-01-26 17:58:13', null, null);
INSERT INTO `share_image` VALUES ('ID539477680303636480', '477136084623425536', 'audio', 'ID535385304635277312', 'http://img.jssns.cn/SHILU/1/45269992188316058.png', '477136084623425536', '2019-01-28 16:11:41', null, null);
INSERT INTO `share_image` VALUES ('ID539492673136885760', '517366532112646144', 'audio', 'ID535777043741147136', 'http://img.jssns.cn/SHILU/1/45273567362329654.png', '517366532112646144', '2019-01-28 17:11:16', null, null);
INSERT INTO `share_image` VALUES ('ID539492990662475776', '517366532112646144', 'audio', 'ID532501576867119104', 'http://img.jssns.cn/SHILU/1/45273643023545758.png', '517366532112646144', '2019-01-28 17:12:32', null, null);
INSERT INTO `share_image` VALUES ('ID539513108918435840', '517366532112646144', 'audio', 'ID538783862449242112', 'http://img.jssns.cn/SHILU/1/45278439479060727.png', '517366532112646144', '2019-01-28 18:32:28', null, null);
INSERT INTO `share_image` VALUES ('ID540114483759022080', '518084122451640320', 'audio', 'ID518092325025480704', 'http://img.jssns.cn/SHILU/1/45421818250978247.png', '518084122451640320', '2019-01-30 10:22:07', null, null);
INSERT INTO `share_image` VALUES ('ID540114580852965376', '518084122451640320', 'audio', 'ID538378337517568000', 'http://img.jssns.cn/SHILU/1/45421841651461470.png', '518084122451640320', '2019-01-30 10:22:30', null, null);
INSERT INTO `share_image` VALUES ('ID540120306996477952', '518084122451640320', 'audio', 'ID520176596611497984', 'http://img.jssns.cn/SHILU/1/45423206791240999.png', '518084122451640320', '2019-01-30 10:45:16', null, null);
INSERT INTO `share_image` VALUES ('ID540124104062140416', '517713552572678144', 'issue', 'ID534322399064096768', 'http://img.jssns.cn/SHILU/1/45424111953087970.png', '517713552572678144', '2019-01-30 11:00:21', null, null);
INSERT INTO `share_image` VALUES ('ID540129203236896768', '518084122451640320', 'audio', 'ID537561196815974400', 'http://img.jssns.cn/SHILU/1/45425327721037182.png', '518084122451640320', '2019-01-30 11:20:37', null, null);
INSERT INTO `share_image` VALUES ('ID540130686992908288', '518084122451640320', 'audio', 'ID537656827878309888', 'http://img.jssns.cn/SHILU/1/45425681699106665.png', '518084122451640320', '2019-01-30 11:26:30', null, null);
INSERT INTO `share_image` VALUES ('ID540243933360291840', '523195517895704576', 'book', 'ID534321710904639488', 'http://img.jssns.cn/SHILU/1/45452681488163192.png', '523195517895704576', '2019-01-30 18:56:30', null, null);
INSERT INTO `share_image` VALUES ('ID540246712925552640', '518880937937731584', 'book', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/45453344228107835.png', '518880937937731584', '2019-01-30 19:07:33', null, null);
INSERT INTO `share_image` VALUES ('ID540250467473555456', '517713552572678144', 'issue', 'ID532982257195941888', 'http://img.jssns.cn/SHILU/1/45454239395642084.png', '517713552572678144', '2019-01-30 19:22:28', null, null);
INSERT INTO `share_image` VALUES ('ID540475062386425856', '518084122451640320', 'book', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/45507787094210563.png', '518084122451640320', '2019-01-31 10:14:56', null, null);
INSERT INTO `share_image` VALUES ('ID540495831619338240', '517349219414048768', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/45512738863940042.png', '517349219414048768', '2019-01-31 11:37:28', null, null);
INSERT INTO `share_image` VALUES ('ID540777131664211968', '518503409347723264', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/45579805972498014.png', '518503409347723264', '2019-02-01 06:15:15', null, null);
INSERT INTO `share_image` VALUES ('ID540777655461478400', '518503409347723264', 'audio', 'ID535385304635277312', 'http://img.jssns.cn/SHILU/1/45579931036416125.png', '518503409347723264', '2019-02-01 06:17:20', null, null);
INSERT INTO `share_image` VALUES ('ID540849669220073472', '518884655118680064', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597100236340968.png', '518884655118680064', '2019-02-01 11:03:29', null, null);
INSERT INTO `share_image` VALUES ('ID540849861046566912', '518882036950237184', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597146130368455.png', '518882036950237184', '2019-02-01 11:04:15', null, null);
INSERT INTO `share_image` VALUES ('ID540849932907577344', '517366313497133056', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597163311377300.png', '517366313497133056', '2019-02-01 11:04:32', null, null);
INSERT INTO `share_image` VALUES ('ID540850093637500928', '538370652508258304', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597201650825741.png', '538370652508258304', '2019-02-01 11:05:10', null, null);
INSERT INTO `share_image` VALUES ('ID540850142517919744', '531053882562838528', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597213244610278.png', '531053882562838528', '2019-02-01 11:05:22', null, null);
INSERT INTO `share_image` VALUES ('ID540851730682740736', '518084122451640320', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/45597591937803657.png', '518084122451640320', '2019-02-01 11:11:41', null, null);
INSERT INTO `share_image` VALUES ('ID540851974854148096', '518882959818752000', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45597650058612159.png', '518882959818752000', '2019-02-01 11:12:39', null, null);
INSERT INTO `share_image` VALUES ('ID540852038917947392', '517713552572678144', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/45597665432725573.png', '517713552572678144', '2019-02-01 11:12:54', null, null);
INSERT INTO `share_image` VALUES ('ID540852049072357376', '531053882562838528', 'audio', 'ID535153697299103744', 'http://img.jssns.cn/SHILU/1/45597667872264619.png', '531053882562838528', '2019-02-01 11:12:57', null, null);
INSERT INTO `share_image` VALUES ('ID541350621085696000', '517366532112646144', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45716536386224031.png', '517366532112646144', '2019-02-02 20:14:05', null, null);
INSERT INTO `share_image` VALUES ('ID541354738340331520', '517349219414048768', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45717518076164643.png', '517349219414048768', '2019-02-02 20:30:27', null, null);
INSERT INTO `share_image` VALUES ('ID541356459443617792', '517366313497133056', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45717928615751798.png', '517366313497133056', '2019-02-02 20:37:17', null, null);
INSERT INTO `share_image` VALUES ('ID541356522635001856', '517366313497133056', 'audio', 'ID518098356564656128', 'http://img.jssns.cn/SHILU/1/45717943744835840.png', '517366313497133056', '2019-02-02 20:37:32', null, null);
INSERT INTO `share_image` VALUES ('ID541359509952528384', '518084122451640320', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45718655774467436.png', '518084122451640320', '2019-02-02 20:49:25', null, null);
INSERT INTO `share_image` VALUES ('ID541362905090621440', '541362276666441728', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45719465348467640.png', '541362276666441728', '2019-02-02 21:02:54', null, null);
INSERT INTO `share_image` VALUES ('ID541363214672199680', '541362276666441728', 'book', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/45719539115408546.png', '541362276666441728', '2019-02-02 21:04:08', null, null);
INSERT INTO `share_image` VALUES ('ID541364306885738496', '541362276666441728', 'audio', 'ID518128033970782208', 'http://img.jssns.cn/SHILU/1/45719799464137594.png', '541362276666441728', '2019-02-02 21:08:28', null, null);
INSERT INTO `share_image` VALUES ('ID541371034289307648', '518668438701342720', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45721403417933761.png', '518668438701342720', '2019-02-02 21:35:12', null, null);
INSERT INTO `share_image` VALUES ('ID541371128401100800', '518668438701342720', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/45721425947909353.png', '518668438701342720', '2019-02-02 21:35:35', null, null);
INSERT INTO `share_image` VALUES ('ID541379329771175936', '521720061925261312', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/45723381284277371.png', '521720061925261312', '2019-02-02 22:08:10', null, null);
INSERT INTO `share_image` VALUES ('ID542316814705623040', '517349219414048768', 'book', 'ID542288738995142656', 'http://img.jssns.cn/SHILU/1/45946894971008289.png', '517349219414048768', '2019-02-05 12:13:24', null, null);
INSERT INTO `share_image` VALUES ('ID542317337181683712', '518668438701342720', 'book', 'ID542288738995142656', 'http://img.jssns.cn/SHILU/1/45947019753939463.png', '518668438701342720', '2019-02-05 12:15:28', null, null);
INSERT INTO `share_image` VALUES ('ID544844436178206720', '517366313497133056', 'audio', 'ID540941586649841664', 'http://img.jssns.cn/SHILU/1/46549526519741457.png', '517366313497133056', '2019-02-12 11:37:16', null, null);
INSERT INTO `share_image` VALUES ('ID544893420871614464', '518503409347723264', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/46561205969348601.png', '518503409347723264', '2019-02-12 14:51:55', null, null);
INSERT INTO `share_image` VALUES ('ID545558399996133376', '517366532112646144', 'audio', 'ID545558132303069184', 'http://img.jssns.cn/SHILU/1/46719749366455715.png', '517366532112646144', '2019-02-14 10:54:18', null, null);
INSERT INTO `share_image` VALUES ('ID545614824977989632', '517366313497133056', 'audio', 'ID518128033970782208', 'http://img.jssns.cn/SHILU/1/46733202032891557.png', '517366313497133056', '2019-02-14 14:38:31', null, null);
INSERT INTO `share_image` VALUES ('ID547383525590958080', '518084122451640320', 'audio', 'ID546021548780158976', 'http://img.jssns.cn/SHILU/1/47154892952252369.png', '518084122451640320', '2019-02-19 11:46:42', null, null);
INSERT INTO `share_image` VALUES ('ID547478212523851776', '518084122451640320', 'audio', 'ID547476409900072960', 'http://img.jssns.cn/SHILU/1/47177468253800343.png', '518084122451640320', '2019-02-19 18:02:57', null, null);
INSERT INTO `share_image` VALUES ('ID547483109113724928', '517366532112646144', 'audio', 'ID547476409900072960', 'http://img.jssns.cn/SHILU/1/47178635541588184.png', '517366532112646144', '2019-02-19 18:22:24', null, null);
INSERT INTO `share_image` VALUES ('ID548031663943188480', '518503409347723264', 'audio', 'ID545568979322667008', 'http://img.jssns.cn/SHILU/1/47309421270615875.png', '518503409347723264', '2019-02-21 06:42:10', null, null);
INSERT INTO `share_image` VALUES ('ID548091316014153728', '516919611287928832', 'book', 'ID542288738995142656', 'http://img.jssns.cn/SHILU/1/47323643373362959.png', '516919611287928832', '2019-02-21 10:39:12', null, null);
INSERT INTO `share_image` VALUES ('ID548563197221666816', '547059615594971136', 'audio', 'ID518088768721256448', 'http://img.jssns.cn/SHILU/1/47436148512449147.png', '547059615594971136', '2019-02-22 17:54:18', null, null);
INSERT INTO `share_image` VALUES ('ID548563215768879104', '547059615594971136', 'audio', 'ID518087482479214592', 'http://img.jssns.cn/SHILU/1/47436153225053829.png', '547059615594971136', '2019-02-22 17:54:22', null, null);
INSERT INTO `share_image` VALUES ('ID548772544405045248', '517366532112646144', 'audio', 'ID548462666079797248', 'http://img.jssns.cn/SHILU/1/47486061088457147.png', '517366532112646144', '2019-02-23 07:46:10', null, null);
INSERT INTO `share_image` VALUES ('ID548772544405045249', '517366532112646144', 'audio', 'ID548462666079797248', 'http://img.jssns.cn/SHILU/1/47486060848485125.png', '517366532112646144', '2019-02-23 07:46:10', null, null);
INSERT INTO `share_image` VALUES ('ID557564176537485312', '516919611287928832', 'issue', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/49582149345163203.png', '516919611287928832', '2019-03-19 14:00:58', null, null);
INSERT INTO `share_image` VALUES ('ID558589564487204864', '516919611287928832', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/49826620781840594.png', '516919611287928832', '2019-03-22 09:55:30', null, null);
INSERT INTO `share_image` VALUES ('ID558771446680125440', '517366532112646144', 'audio', 'ID557940478700421120', 'http://img.jssns.cn/SHILU/1/49869985019275967.png', '517366532112646144', '2019-03-22 21:58:14', null, null);
INSERT INTO `share_image` VALUES ('ID560105778447384576', '517366532112646144', 'book', 'ID542288738995142656', 'http://img.jssns.cn/SHILU/1/50188114366727857.png', '517366532112646144', '2019-03-26 14:20:23', null, null);
INSERT INTO `share_image` VALUES ('ID562664854477864960', '517366532112646144', 'audio', 'ID521698898528436224', 'http://img.jssns.cn/SHILU/1/50798245393846987.png', '517366532112646144', '2019-04-02 15:49:15', null, null);
INSERT INTO `share_image` VALUES ('ID562956910379139072', '517713552572678144', 'audio', 'ID546019894789931008', 'http://img.jssns.cn/SHILU/1/50867877191350450.png', '517713552572678144', '2019-04-03 11:09:46', null, null);
INSERT INTO `share_image` VALUES ('ID562957073235574784', '517713552572678144', 'audio', 'ID518083290419167232', 'http://img.jssns.cn/SHILU/1/50867916331216301.png', '517713552572678144', '2019-04-03 11:10:25', null, null);
INSERT INTO `share_image` VALUES ('ID562957142965878784', '517713552572678144', 'audio', 'ID550718369184088064', 'http://img.jssns.cn/SHILU/1/50867932805862993.png', '517713552572678144', '2019-04-03 11:10:42', null, null);
INSERT INTO `share_image` VALUES ('ID562957195021385728', '517713552572678144', 'audio', 'ID518087482479214592', 'http://img.jssns.cn/SHILU/1/50867945336428725.png', '517713552572678144', '2019-04-03 11:10:54', null, null);
INSERT INTO `share_image` VALUES ('ID562957534978113536', '517349219414048768', 'audio', 'ID546021548780158976', 'http://img.jssns.cn/SHILU/1/50868026430998890.png', '517349219414048768', '2019-04-03 11:12:15', null, null);
INSERT INTO `share_image` VALUES ('ID562957945365594112', '517713552572678144', 'audio', 'ID547476409900072960', 'http://img.jssns.cn/SHILU/1/50868124147394168.png', '517713552572678144', '2019-04-03 11:13:53', null, null);
INSERT INTO `share_image` VALUES ('ID563350168930353152', '517349219414048768', 'issue', 'ID538015249526161408', 'http://img.jssns.cn/SHILU/1/50961637543253408.png', '517349219414048768', '2019-04-04 13:12:26', null, null);
INSERT INTO `share_image` VALUES ('ID563683830746054656', '518503409347723264', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/51041188534894220.png', '518503409347723264', '2019-04-05 11:18:17', null, null);
INSERT INTO `share_image` VALUES ('ID565141484882362368', '517713552572678144', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/51388720142114540.png', '517713552572678144', '2019-04-09 11:50:29', null, null);
INSERT INTO `share_image` VALUES ('ID565194017063567360', '517713552572678144', 'audio', 'ID546021548780158976', 'http://img.jssns.cn/SHILU/1/51401245111412329.png', '517713552572678144', '2019-04-09 15:19:14', null, null);
INSERT INTO `share_image` VALUES ('ID565565916687892480', '517349219414048768', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/51489912939763650.png', '517349219414048768', '2019-04-10 15:57:02', null, null);
INSERT INTO `share_image` VALUES ('ID565580987518418944', '517349219414048768', 'audio', 'ID547435337442394112', 'http://img.jssns.cn/SHILU/1/51493506126514030.png', '517349219414048768', '2019-04-10 16:56:55', null, null);
INSERT INTO `share_image` VALUES ('ID565581221535416320', '517349219414048768', 'audio', 'ID547461763847684096', 'http://img.jssns.cn/SHILU/1/51493562033689454.png', '517349219414048768', '2019-04-10 16:57:51', null, null);
INSERT INTO `share_image` VALUES ('ID565831451967225856', '517713552572678144', 'audio', 'ID518418068611792896', 'http://img.jssns.cn/SHILU/1/51553221227824497.png', '517713552572678144', '2019-04-11 09:32:10', null, null);
INSERT INTO `share_image` VALUES ('ID565841162909253632', '517713552572678144', 'audio', 'ID529392370534318080', 'http://img.jssns.cn/SHILU/1/51555536675666146.png', '517713552572678144', '2019-04-11 10:10:46', null, null);
INSERT INTO `share_image` VALUES ('ID565841489549066240', '517713552572678144', 'audio', 'ID539471062065217536', 'http://img.jssns.cn/SHILU/1/51555614740856499.png', '517713552572678144', '2019-04-11 10:12:03', null, null);
INSERT INTO `share_image` VALUES ('ID565843978822352896', '517713552572678144', 'audio', 'ID537651492618764288', 'http://img.jssns.cn/SHILU/1/51556207784781216.png', '517713552572678144', '2019-04-11 10:21:57', null, null);
INSERT INTO `share_image` VALUES ('ID565844897781776384', '517713552572678144', 'audio', 'ID538380303387852800', 'http://img.jssns.cn/SHILU/1/51556427285453646.png', '517713552572678144', '2019-04-11 10:25:36', null, null);
INSERT INTO `share_image` VALUES ('ID565845833828794368', '517713552572678144', 'audio', 'ID538380538935771136', 'http://img.jssns.cn/SHILU/1/51556650495004579.png', '517713552572678144', '2019-04-11 10:29:19', null, null);
INSERT INTO `share_image` VALUES ('ID565846536974499840', '517713552572678144', 'audio', 'ID538378337517568000', 'http://img.jssns.cn/SHILU/1/51556818102049761.png', '517713552572678144', '2019-04-11 10:32:07', null, null);
INSERT INTO `share_image` VALUES ('ID565846890415915008', '565846807398055936', 'audio', 'ID521698898528436224', 'http://img.jssns.cn/SHILU/1/51556902431637385.png', '565846807398055936', '2019-04-11 10:33:31', null, null);
INSERT INTO `share_image` VALUES ('ID565847882637246464', '517713552572678144', 'audio', 'ID537650488993120256', 'http://img.jssns.cn/SHILU/1/51557138971873309.png', '517713552572678144', '2019-04-11 10:37:28', null, null);
INSERT INTO `share_image` VALUES ('ID565848566300409856', '517713552572678144', 'audio', 'ID538380120281317376', 'http://img.jssns.cn/SHILU/1/51557300848121044.png', '517713552572678144', '2019-04-11 10:40:10', null, null);
INSERT INTO `share_image` VALUES ('ID565911863775199232', '565846807398055936', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/51572393252458761.png', '565846807398055936', '2019-04-11 14:51:42', null, null);
INSERT INTO `share_image` VALUES ('ID565912006108905472', '565911816136294400', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/51572427140195356.png', '565911816136294400', '2019-04-11 14:52:16', null, null);
INSERT INTO `share_image` VALUES ('ID567800336920608768', '517349219414048768', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/52022640379972608.png', '517349219414048768', '2019-04-16 19:55:49', null, null);
INSERT INTO `share_image` VALUES ('ID568454149125963776', '517349219414048768', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/52178521269606091.png', '517349219414048768', '2019-04-18 15:13:50', null, null);
INSERT INTO `share_image` VALUES ('ID568454337328578560', '517349219414048768', 'audio', 'ID547476409900072960', 'http://img.jssns.cn/SHILU/1/52178566191324260.png', '517349219414048768', '2019-04-18 15:14:35', null, null);
INSERT INTO `share_image` VALUES ('ID570644221996826624', '549529816974491648', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/52700675411873984.png', '549529816974491648', '2019-04-24 16:16:24', null, null);
INSERT INTO `share_image` VALUES ('ID570647173666963456', '517713552572678144', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/52701379008597869.png', '517713552572678144', '2019-04-24 16:28:08', null, null);
INSERT INTO `share_image` VALUES ('ID570651089473372160', '517366532112646144', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/52702312549020161.png', '517366532112646144', '2019-04-24 16:43:41', null, null);
INSERT INTO `share_image` VALUES ('ID570654591696240640', '517366313497133056', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/52703147701824203.png', '517366313497133056', '2019-04-24 16:57:36', null, null);
INSERT INTO `share_image` VALUES ('ID570665933249445888', '517366532112646144', 'book', 'ID540677444353392640', 'http://img.jssns.cn/SHILU/1/52705851592837320.png', '517366532112646144', '2019-04-24 17:42:40', null, null);
INSERT INTO `share_image` VALUES ('ID571040158036525056', '518880937937731584', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/52795073695045134.png', '518880937937731584', '2019-04-25 18:29:43', null, null);
INSERT INTO `share_image` VALUES ('ID571270729652240384', '518668438701342720', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/52850046264289694.png', '518668438701342720', '2019-04-26 09:45:55', null, null);
INSERT INTO `share_image` VALUES ('ID571270970875052032', '518668438701342720', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/52850103945416267.png', '518668438701342720', '2019-04-26 09:46:53', null, null);
INSERT INTO `share_image` VALUES ('ID571389272888705024', '571389238432497664', 'book', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/52878309279591238.png', '571389238432497664', '2019-04-26 17:36:58', null, null);
INSERT INTO `share_image` VALUES ('ID572358740905295872', '517713552572678144', 'issue', 'ID540846505183936512', 'http://img.jssns.cn/SHILU/1/53109448397085608.png', '517713552572678144', '2019-04-29 09:49:17', null, null);
INSERT INTO `share_image` VALUES ('ID572803889150033920', '518503409347723264', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/53215579710074574.png', '518503409347723264', '2019-04-30 15:18:09', null, null);
INSERT INTO `share_image` VALUES ('ID572851315915358208', '518084122451640320', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/53226887462131939.png', '518084122451640320', '2019-04-30 18:26:36', null, null);
INSERT INTO `share_image` VALUES ('ID572851448505696256', '517713552572678144', 'book', 'ID567793485105594368', 'http://img.jssns.cn/SHILU/1/53226919206127448.png', '517713552572678144', '2019-04-30 18:27:08', null, null);
INSERT INTO `share_image` VALUES ('ID572851601694261248', '518084122451640320', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/53226955675719429.png', '518084122451640320', '2019-04-30 18:27:44', null, null);
INSERT INTO `share_image` VALUES ('ID574154841652199424', '518503409347723264', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/53537672115194290.png', '518503409347723264', '2019-05-04 08:46:21', null, null);
INSERT INTO `share_image` VALUES ('ID575402289330651136', '517349219414048768', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/53835086983902594.png', '517349219414048768', '2019-05-07 19:23:16', null, null);
INSERT INTO `share_image` VALUES ('ID575402445480394752', '517353407590170624', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/53835124237897977.png', '517353407590170624', '2019-05-07 19:23:53', null, null);
INSERT INTO `share_image` VALUES ('ID575403206075482112', '549529816974491648', 'lesson', '12', 'http://img.jssns.cn/SHILU/1/53835305534496501.png', '549529816974491648', '2019-05-07 19:26:54', null, null);
INSERT INTO `share_image` VALUES ('ID575410576671375360', '517713552572678144', 'lesson', '13', 'http://img.jssns.cn/SHILU/1/53837061918144436.png', '517713552572678144', '2019-05-07 19:56:11', null, null);
INSERT INTO `share_image` VALUES ('ID575410819664183296', '517713552572678144', 'audio', 'ID562333841675517952', 'http://img.jssns.cn/SHILU/1/53837120738048770.png', '517713552572678144', '2019-05-07 19:57:10', null, null);
INSERT INTO `share_image` VALUES ('ID575411025092804608', '551117546237984768', 'audio', 'ID519446741330690048', 'http://img.jssns.cn/SHILU/1/53837169809625632.png', '551117546237984768', '2019-05-07 19:57:58', null, null);
INSERT INTO `share_image` VALUES ('ID575411340915507200', '517366532112646144', 'audio', 'ID518083290419167232', 'http://img.jssns.cn/SHILU/1/53837245060999898.png', '517366532112646144', '2019-05-07 19:59:14', null, null);
INSERT INTO `share_image` VALUES ('ID575705875197460480', '517713552572678144', 'audio', 'ID560427229113221120', 'http://img.jssns.cn/SHILU/1/53907467071746954.png', '517713552572678144', '2019-05-08 15:29:36', null, null);

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(200) DEFAULT NULL COMMENT '目录名字',
  `cover` varchar(200) DEFAULT NULL COMMENT '替换封面url',
  `pc_cover` varchar(200) DEFAULT NULL COMMENT 'pc端封面图片URL',
  `banner` varchar(200) DEFAULT NULL COMMENT '替换封面图片URL',
  `pc_banner` varchar(200) DEFAULT NULL COMMENT 'pc替换封面图片URL',
  `intro` text,
  `presentation` varchar(200) DEFAULT NULL COMMENT '电台视频介绍',
  `slogan` varchar(200) DEFAULT NULL,
  `publish_status` varchar(6) DEFAULT NULL COMMENT '0 未发布，1已发布',
  `status` varchar(6) DEFAULT NULL COMMENT '0 删除，1正常',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `detail` varchar(30) DEFAULT NULL,
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主题，关联专辑';

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('ID51553612743678361', '父母学堂', 'http://img.jssns.cn/SHILU/1/c54e70ca1c02ee1c1684f023c98ae996.png', null, 'http://img.jssns.cn/SHILU/1/cf9f4b21b19bf17b0b57703ed9417a91.jpg', null, '<p><img src=\"http://img.jssns.cn/SHILU/1/42341125804218001.jpg\"></p>', null, '只为你讲述科学、专业的教育书籍~', '1', '1', '2', null, '432228697144033280', '2018-11-23 14:36:30', null, null);
INSERT INTO `topic` VALUES ('ID51553634445426688', '儿童哲学', 'http://img.jssns.cn/SHILU/1/a56b3a04c77a6c03fea99b38ca8492d8.png', null, 'http://img.jssns.cn/SHILU/1/f91a2a65b6101c0e1b5e1647dd05fb90.png', null, '<p class=\"ql-align-justify\">每个孩子都是天生的哲学家，只需适当的引导，孩子就会变成一个热爱生活、充满激情的人。</p><p><br></p><p class=\"ql-align-justify\">儿童哲学针对的是4—12岁之间的孩子，通过趣味故事来讲解<span style=\"color: rgb(252, 88, 50);\">“生与死”、“对与错”、“爱与恨</span>”等孩子好奇家长犯难的话题，以此来增加孩子的见识。</p><p class=\"ql-align-justify\">&nbsp;</p><p class=\"ql-align-justify\">目前《时间管理》主题已经全部上架，第二季的《生与死》也将陆续更新，欢迎收听！</p><p class=\"ql-align-justify\"><br></p><p><img src=\"http://img.jssns.cn/SHILU/1/45277119159029623.jpg\"></p>', null, '陪孩子一起探究世界和人生的真相！', '1', '1', '4', null, '432228697144033280', '2018-11-23 14:37:22', null, null);
INSERT INTO `topic` VALUES ('ID51553898775078502', '晚安故事', 'http://img.jssns.cn/SHILU/1/57e71faeba34fac842355515fb254ddf.png', null, 'http://img.jssns.cn/SHILU/1/0778ac7e79e7c347174586f088fa923a.jpg', null, '<p>董事长说的很对结结巴巴v</p>', null, '在美好的声音中，遇见美妙的梦！', '1', '1', '5', null, '432228697144033280', '2018-11-23 14:47:52', null, null);
INSERT INTO `topic` VALUES ('ID51553923726992998', '成语新说', 'http://img.jssns.cn/SHILU/1/d342591240dfdea8715a0297eeeb2f0c.png', '', 'http://img.jssns.cn/SHILU/1/ec831e87e15677a3085594222d11deb6.jpg', '', '<p><img src=\"http://img.jssns.cn/SHILU/1/42332953434592621.png\"></p>', null, '不仅是故事，更是一种思维方式！', '1', '1', '2', null, '432228697144033280', '2018-11-23 14:48:52', '432228697144033280', '2019-02-22 15:46:16');
INSERT INTO `topic` VALUES ('ID52717613775585280', '节日百科', 'http://img.jssns.cn/SHILU/1/eb5b56116fe65e69c2119b8acf026d02.jpg', null, 'http://img.jssns.cn/SHILU/1/eb5b56116fe65e69c2119b8acf026d02.jpg', null, null, null, '讲述那些有趣的节日历史~', '0', '0', null, null, '168', '2018-12-25 17:29:44', null, null);
INSERT INTO `topic` VALUES ('ID5300618722384281', '世界童话', 'http://img.jssns.cn/SHILU/1/00ee915bd9fdd2ce81b90cd16e4e050c.jpg', null, 'http://img.jssns.cn/SHILU/1/00ee915bd9fdd2ce81b90cd16e4e050c.jpg', null, '<p><img src=\"http://img.jssns.cn/SHILU/1/43024268503287396.jpg\"></p>', null, '童话，幻想期孩子的内心语言。', '0', '0', null, null, '168', '2019-01-02 16:36:38', null, null);
INSERT INTO `topic` VALUES ('ID53514757478128025', '古诗鉴赏', 'http://img.jssns.cn/SHILU/1/143cb68203de0b08e7dc2327de0828d3.png', '', 'http://img.jssns.cn/SHILU/1/2fe1aa15aea0c0298de69e584f8e002a.png', '', '<p><img src=\"http://img.jssns.cn/SHILU/1/44898300353672905.jpg\"></p>', null, '习中国文化，悟古人智慧！', '1', '1', '0', null, '168', '2019-01-16 17:25:24', '432228697144033280', '2019-02-22 11:39:50');

-- ----------------------------
-- Table structure for `trade_order`
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `import_data` varchar(20) DEFAULT NULL COMMENT '是否为导入，1为自己购买，2为学校购买',
  `sell_id` varchar(100) DEFAULT NULL COMMENT '卖方id',
  `buy_id` varchar(100) DEFAULT NULL COMMENT '买方id',
  `name` varchar(30) DEFAULT NULL COMMENT '订单名称',
  `intro` text COMMENT '订单描述',
  `pay_no` varchar(100) DEFAULT NULL COMMENT '支付订单号',
  `pay_way` varchar(200) DEFAULT NULL COMMENT '支付页方式',
  `price` varchar(100) DEFAULT NULL COMMENT '总价',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单';

-- ----------------------------
-- Records of trade_order
-- ----------------------------
INSERT INTO `trade_order` VALUES ('1', '1', '', '10', '23231', null, null, null, null, '1', '111', '111', null, null);
INSERT INTO `trade_order` VALUES ('2', '2', null, '10', null, null, null, null, null, '1', '223', '111', null, null);

-- ----------------------------
-- Table structure for `trade_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `trade_order_detail`;
CREATE TABLE `trade_order_detail` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `trate_order_id` varchar(30) DEFAULT NULL COMMENT '订单名称',
  `original_price` varchar(50) DEFAULT NULL COMMENT '原价',
  `present_price` varchar(50) DEFAULT NULL COMMENT '购买金额',
  `name` varchar(30) DEFAULT NULL COMMENT '商品名称',
  `prod_type` varchar(30) DEFAULT NULL COMMENT '商品类型',
  `prod_id` varchar(30) DEFAULT NULL COMMENT '商品id',
  `intro` text COMMENT '商品描述',
  `preferential_way` varchar(50) DEFAULT NULL COMMENT '优惠方式',
  `status` varchar(6) DEFAULT NULL COMMENT '状态(0 删除，1正常)',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情';

-- ----------------------------
-- Records of trade_order_detail
-- ----------------------------
INSERT INTO `trade_order_detail` VALUES ('1', '1', '2222', null, null, 'lesson', '12', null, null, '1', '1', null, null, null);
INSERT INTO `trade_order_detail` VALUES ('2', '1', '333', null, null, 'lesson', '13', null, null, '2', '33243', null, null, null);

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `rec_id` varchar(30) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '视频名称',
  `url` varchar(500) DEFAULT NULL COMMENT '视频链接',
  `intro` text COMMENT '简介',
  `tag` varchar(30) DEFAULT NULL COMMENT '标签( 研读，导读)',
  `qr_code` varchar(100) DEFAULT NULL COMMENT '二维码',
  `cover` varchar(200) DEFAULT NULL COMMENT '封面',
  `pc_cover` varchar(200) DEFAULT NULL COMMENT 'pc端封面视频图片URL',
  `belong_to` varchar(10) DEFAULT NULL COMMENT '属于哪个栏目(album 专辑，book书籍)',
  `belong_to_id` varchar(30) DEFAULT NULL COMMENT '属于哪个栏目ID(专辑或书籍主键)',
  `free` varchar(30) DEFAULT NULL COMMENT '免费观看',
  `finish_num` bigint(11) DEFAULT NULL COMMENT '播放完成总数',
  `play_num` bigint(11) DEFAULT '0' COMMENT '播放量',
  `order_num` int(3) DEFAULT NULL COMMENT '排序',
  `create_id` varchar(30) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(30) DEFAULT NULL COMMENT '更新人',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频';

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('ID540678936577703936', '《小王子》', 'http://video.likesoft.com.cn/49b3d1ba63764b4eb5083a3fe2482257/fed7e95ba1574a33b4866da4a52a6a1e-f952cf8a36bbdc1af7fccae91a3bc189-sd.m3u8', '<p>小王子来自遥远的612星球，降落至地球沙漠深处。他的星球很小，星球上有他的小房子，美丽的玫瑰，不会爆发的火山以及可恶的猴面包树。清除猴面包树，浇灌玫瑰，是他在这个星球的日常生活，重复但并不枯燥乏味。</p><p><br></p><p>小王子爱着玫瑰，因为她是他亲手浇灌的，是他亲手放在花罩的，是他亲自用屏风保护起来的。因为爱她，所以呵护她。</p><p><br></p><p>他倾听过她的怨艾和自诩，甚至有时，他聆听她的沉默。因为她是他的玫瑰。</p><p><br></p><p>玫瑰花的骄傲和再三试探使小王子负气离开家园，开始了宇宙旅行。</p><p><br></p><p>当失去一些东西时，才感到弥足珍贵。越是在生活中常见的，容易得到的东西，失去会越让人觉得后悔。我们的亲人，朋友，虽然每天都能见到，但是我们很多人没能感觉到他们对我们价值，许多人被其他被认为重要的事情而忽略了他们。但是，等到他们有一天不在时，我们才感到伤心，甚至难以接受。</p><p><br></p><p>拥有爱你的人，是一种幸福。在小王子离开的前一天，他们双方才意识到彼此在自己心中的重量。纵然后悔，为了赌气，小王子毅然离开了。玫瑰默默的流泪，小王子又何尝不是？但双方难以打破那层隔膜，难以妥协。</p><p><br></p><p>地球的花园里有五千朵玫瑰，它们美丽又高贵，小王子只拥有有一株玫瑰，但在他的心中是独一无二的。</p><p><br></p><p>纵然你拥有整个花园，拥有无数的玫瑰，但也无法代替心中独一无二的玫瑰。</p><p><br></p><p>小王子在地球上难以忍受孤独与对玫瑰的思念，宁愿以肉体的毁灭为代价，也要回去陪着玫瑰。他实在担心在没有自己的日子里，玫瑰的生活是否很好。他需要绵羊，但必须有牙套。因为只有这样，才能保障玫瑰的安全。</p><p><br></p><p>人只有在失去后才懂得珍惜，珍惜你爱的人，承担起你对她的责任，不要付出巨大的代价而弥补后悔。</p><p><br></p><p>这个星球上的人们每天忙忙碌碌，这是小王子对地球人的第一印象。</p><p><br></p><p>在长长轨道上，火车拉了一波又一波的人。小王子很不解，人们为了什么而忙碌，为了什么而奔波。</p><p><br></p><p>人们每天奔波，实际上自己也不知道为了什么。人们在忙碌中早已忘记的最初的理想，最初是为了什么而奋斗，只知道随波逐流，在人流中，渐渐的失去了那个本来的自我。</p><p><br></p><p>或许你最初的梦想，就是简单的追求幸福。那么何为幸福？在小王子看来，幸福就是在自己的星球上除一除害草，通一通火山，与玫瑰看一看日落。</p><p><br></p><p>但是人们并不会满足，他们不断的追求。得到的越多，他心里的欲望越是膨胀。与他人不断的攀比，最终也在攀比中劳烦身心，得不到幸福。</p><p><br></p><p>为什么人们不知道满足呢？小王子不解道。</p><p><br></p><p>孩子们自小以来，都要顺着大人们的思维生长，发育，如果违背大人们的意志，轻则予以否定，重则受到惩罚。</p><p><br></p><p>不要问为什么，因为大人们也不知道为什么。他们只知道自己的儿时也是这样过来的。</p><p><br></p><p>这就是这个恶性循环形成的原因。</p><p><br></p><p>在小说开头，作者给大人们画了一只吞了大象的蟒蛇，大人们认为这没有任何意义，于是不断的对此做出否定。也就是在大人一次一次的否定中，我们可怜的作者失去了对绘画的兴趣，从此画不出什么东西。</p><p><br></p><p>人就是这样，当自己的所做得不到任何的肯定，在别人看来只是毫无价值的垃圾时，他就会对比做出改变。更不用说被否定的对象是儿时的作者。</p><p><br></p><p>当作者将这幅画给小王子看时，小王子立刻说出了作者所画的内容，让作者感到安慰。他想，如果早点遇到小王子，他的人生轨迹或许会有所不同。</p><p><br></p><p>在大人们的视角的影响下，孩子们失去了自己的童真。有不少的孩子过度早熟，在各类节目都有神童的出现，每当我看到这些神童时，没有与他人一样的羡慕，只有深深的惋惜。三四岁，甚至是五六岁的孩子，正是孩子们天马行空的想象着一草一木，认识这个未知的世界的时候。本该天真烂漫的时候，却被无数的奥数题，钢琴，各种父母希望，大人们认可的标准所禁锢。</p><p><br></p><p>让我不解的是，大人们的思维，为何要强加在孩子的身上。当孩子们说着与自己年龄不相符合的话，做着成熟的动作，穿着成熟的服装出现在舞台上。让大人们连连点头称赞，而让我感到只有做作，虚伪以及对这些孩子的惋惜。这些孩子在无形就被剥夺了在这个年龄段本该拥有的最珍贵的东西。</p><p><br></p><p>如今出现了一种奇怪的现象，孩子们很成熟，但很多大人装嫩，发嗲，犯贱，并且这很受人们的欢迎。这种本末的倒置，或许小王子一生都难以理解吧。</p><p><br></p><p><strong>人与人之间为何会产生联系？</strong></p><p><br></p><p>狐狸与小王子相识在花园中，两者都很孤独。</p><p><br></p><p>狐狸请求小王子驯服自己，当驯服成功后，两者建立联系，当彼此分开时，又感到难舍。</p><p><br></p><p>小王子顿悟到，自己之所以想念玫瑰，是因为玫瑰驯服了自己。</p><p><br></p><p>人与人之间又何尝不是吗？将对方的存在当成习惯，习惯对方的一切习惯，这就是建立联系的起源，也就是驯服。</p><p><br></p><p>驯服是责任，是担当。本质的东西是用眼睛看不见的，只能用心去看。小王子为玫瑰花费时光，才使得他的玫瑰变得如此重要。对你驯养过的东西，你永远都有责任。当你离不开对方时，要懂得珍惜。</p><p><br></p><p>珍惜驯服了你或你驯服的人，因为这个过程并不容易，茫茫人海中，与你建立联系，便是缘。一切都是缘起，终结于缘。</p><p><br></p><p>想想自己有多久没有坐在椅子上，心里没有任何杂乱的事，只是一心一意，心平气和的看一次日出。</p><p><br></p><p>也许许多人好多年都没有这样做过了。在现在快节奏的生活中，任何事都讲究效率，人们做什么事也讲究功利主义。所以许多最为自然与本真的东西被我们忽略。</p><p><br></p><p>看看日出，对许多人来说，并不是很难。也就是刷朋友圈的时间，或者打游戏的时间。但是，想要抠出这些时间对人们来说很难很难。</p><p><br></p><p>人们知道旅游，想要融入自然。但是，又何尝认识到，其实，你只需要抬一抬头，便能欣赏自然的风光。</p><p><br></p><p>许多人对比表示不屑，日出，这种最平常，最无聊的东西，有什么可看的。但是，你不可否认的是，日出象征着新的一天的开始，是希望的象征。</p><p>小王子说:“你知道，当人们感到非常苦闷时，总是喜欢日落的。”</p><p><br></p><p>也许看看日落能让小王子回忆起自己与玫瑰的时光，或许他们一同看过日出日落。</p><p><br></p><p>珍惜你现在能够与你相爱的人一同看日出的机会，不要等到迟暮之年，冥冥之际留下遗憾。</p>', '导读课', 'http://img.jssns.cn/SHILU/1/45556395314929922.png', 'http://img.jssns.cn/SHILU/1/7c8bb5267170d359f9bf641df7a68ab5.jpg', null, 'book', 'ID540677444353392640', null, null, '16', null, '168', '2019-01-31 23:45:03', '168', '2019-02-01 16:37:13');
INSERT INTO `video` VALUES ('ID540846955824152576', '探索神秘的海底世界', 'http://video.likesoft.com.cn/a884667dcbb04f7a9f415adb7e980552/f406f35d9c3c45aabe289a148398fcee-f9a2703239316105c6518fd5905b0563-sd.m3u8', '<p><span style=\"color: rgb(51, 51, 51);\">《海底两万里》是凡尔纳三部曲中的第二部，另外两部是《</span><a href=\"https://baike.sogou.com/lemma/ShowInnerLink.htm?lemmaId=183708&amp;ss_c=ssc.citiao.link\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">格兰特船长的儿女</a><span style=\"color: rgb(51, 51, 51);\">》和《</span><a href=\"https://baike.sogou.com/lemma/ShowInnerLink.htm?lemmaId=64591712&amp;ss_c=ssc.citiao.link\" target=\"_blank\" style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">神秘岛</a><span style=\"color: rgb(51, 51, 51); background-color: rgb(255, 255, 255);\">》。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳，出生于19世纪，1828年，距今，已经过了190年了，他是法国的小说家，剧作家以及诗人，凡尔纳出生于海国海港城市，叫做南特。出生在一个中产阶级的家庭，早年间依父亲的意愿在巴黎学习法律之后走上了写编剧以及杂志文章这条路。他的文章有很多被翻译成了多种语言并且是广泛流传。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">他的作品对科幻文学流派产生了巨大影响，因此也被成为科幻小说之父。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">据说他的第一部作品《气球上的星期五》连投了16家出版社都没有人愿意为他出版，他一气之下就把手稿扔进了火盆中，妻子看到后火速的抢救下来，才有机会让他遇到第17家出版社为他出版了这本书。名声大震，至此凡尔纳也就成了非常有名的科幻小说家。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">在凡尔纳的作品当作充满了明显的社会倾向，同时也充满了许多科学知识。但他本人确是一名宇宙神秘主义者，对世界有着崇拜感的。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳的才能在于他是在科学发展的范围之内，根据科学发展的规律和必然的趋势做出种种奇妙无比的构想。这些构想符合了当时科学发展的趋势，在20世纪之后这些全部成为了现实。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">而且他对于科学的态度是相当的严谨，相当认真的。它的想象是建立在科学之上的。比如说，他为了写地球飞到月球的故事，便事先研究了很多有关于空气动力，飞行速度，太空中的失重等等复杂的科技问题。正因如此他的很多科学幻想都成为了科学语言。其中就包括《海底两万里》当中我们都知道的潜水艇“鹦鹉螺号”。而在之后的1886年英国就真的建构了一艘用蓄电池推动的潜艇，就被命名为了“鹦鹉螺号”。当时的“鹦鹉螺号”成功的完成了水下航行。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">说到凡尔纳的写作风格，其实凡尔纳的作品基本属于浪漫主义文学。他总是在一个科学幻想的框架里面编织一个复杂曲折而又有趣的故事。惊险、刺激在衬托上非凡的大自然中奇景渲染了一种非常浓重的浪漫主义色彩，再加上凡尔纳他的文笔的流畅叙述清晰，从平淡的文字当中就可以传达出人类的热情。所以俄国作家列夫托尔福泰就曾经赞扬过他说凡尔纳创作的长篇小说使自己赞赏不已，在构思引发身省，情节入胜方面凡尔纳堪称一个大师。</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">&nbsp;</span></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">凡尔纳的作品不仅具有独特的艺术魅力，在现实生活中也产生了一场深远的影响。他在小说中塑造的一位位科学勇士和先驱的形象就影响了许多后代的科学家，许多科学家也都坦言，自己是受到了凡尔纳的启迪才走上的科学探索之路。</span></p><p><br></p><p><span style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">收回到凡尔纳的科学探索之路，有很多科学家都说过凡尔纳是自己科学之路的一个引路者，如：潜水艇的发明者西蒙*莱克。在他的自传中第一句话就是“凡尔纳是我一生事业的总指挥”而海军少将伯德在飞越北极之后说：凡尔纳是他的领路人。瑞士著名深海探险家皮卡德以及无线电发明者马可尼都一致认为：凡尔纳是启发他们发明的重要人物，所以，后人为了纪念凡尔纳在文学上的付出，法国的赫切特图书公司于1927年开始设立了儒勒凡尔纳大奖专门奖励优秀的科幻原创作品，奖金高达5000法郎，折合人民币30500</span></p><p><br></p><p><strong style=\"background-color: rgb(255, 255, 255); color: rgb(51, 51, 51);\">好了，现在我们对凡尔纳的生平有了一个了解，那么打开你手中的《海底两万里》和婷婷老师开始遨游海底世界吧！</strong></p><p>&nbsp;</p>', '导读课', 'http://img.jssns.cn/SHILU/1/45596454209704469.png', 'http://img.jssns.cn/SHILU/1/543f97aa3675be046fdbc62ed109a15a.png', null, 'book', 'ID540846505183936512', null, null, '1', null, '168', '2019-02-01 10:52:42', '432228697144033280', '2019-02-02 21:45:04');
INSERT INTO `video` VALUES ('ID542289909642166272', '《福》字的拆解', 'http://video.likesoft.com.cn/c702c3469d1542a4b10c7ca86085242f/9d3909e5334247fc9b8469384376d57d-0d0323c834aca52d8a85769ec379b6b1-sd.m3u8', '<p>“迎春接福”是我国民间的传统习俗。每逢新春佳节，家家户户都喜欢在门前，车上贴上大大小小的“福”字，祈求在新的一年里，福星高照，富运滚滚。但一个很奇怪的现象是，福字挂的再多再久，一些人的日子也没有丝毫变化。原因就在于他们理解错了“福”字的根本含义。下面，让我们穿越时空，回到“福”字刚出现的时代。</p><p><br></p><p>福字的甲骨文从字形便能意会出双手举酒祭天的意义，表示向神明供奉祭品，以求获得庇佑。</p><p>&nbsp;</p><p>为什么用酒而不是其他东西祭祀神明呢？因为，在古代，酒是非常珍贵的东西，黄金就是用来换美酒的！把自己最珍贵的东西献出去叫什么？没错，是奉献。因此，“福”的真正含义不是“索取”，而是“奉献”。</p><p><br></p><p>简单延伸下，前面提到，酒是如此的珍贵，那么一个人家里面藏着美酒表示什么字呢？</p><p><br></p><p>你猜的没错，是“富”字。家里有酒所以很富裕！</p><p><br></p><p>回到福字，现在的简体字福写起来简单多了，它也有特殊含义哦。我们把这部分拆开，就变成了一、口、田三个字。</p><p><br></p><p>表示，一人一口田，我国历来是个以农耕为主的国家，一家人只要有土地，就会过得很幸福。</p>', '趣味识字课', 'http://img.jssns.cn/SHILU/1/45940481231581809.png', 'http://img.jssns.cn/SHILU/1/251f49144be1d6d944583727885f5379.jpg', null, 'book', 'ID542288738995142656', null, null, '0', null, '432228697144033280', '2019-02-05 10:26:29', '432228697144033280', '2019-03-20 14:47:44');
INSERT INTO `video` VALUES ('ID567795249028530175', '《傅雷家书》应该如何去阅读？', 'http://video.likesoft.com.cn/965165110b5b4df787b9e7c9e2606cff/a5ccf2593fed439db026ae06e0d8caca-ca0ff5065bf358b16c24302ecafd66e5-ld.m3u8', '<p><img src=\"http://img.jssns.cn/SHILU/1/52022353200566577.jpg\"><img src=\"http://img.jssns.cn/SHILU/1/52022368509503763.jpg\"></p><p>王跃平&nbsp;江苏省语文特级教师，江苏省教科研先进教师，江苏省首届语文领航名师，南京市语文名师工作室领衔人，南京市语文学科带头人，南京市优秀教育工作者，南京市人大代表。</p>', '导读课', 'http://img.jssns.cn/SHILU/1/52021428019376108.png', 'http://img.jssns.cn/SHILU/1/ae97b641e378765ba3941c519c738f8c.png', null, 'book', 'ID567793485105594368', null, null, '14', null, '168', '2019-04-16 19:35:36', '168', '2019-04-18 10:01:32');
INSERT INTO `video` VALUES ('ID567795249028530176', '《傅雷家书》中的教育理念？', 'http://video.likesoft.com.cn/74d4068bd20f4395a0bfe89b12ae7525/1100a4d416f6434a80fc7d10bcc47b9b-59a15b06b8d72ef5417c9e8cfe00e91b-ld.m3u8', '<p><img src=\"http://img.jssns.cn/SHILU/1/52022353200566577.jpg\"><img src=\"http://img.jssns.cn/SHILU/1/52022368509503763.jpg\"></p><p>王跃平&nbsp;江苏省语文特级教师，江苏省教科研先进教师，江苏省首届语文领航名师，南京市语文名师工作室领衔人，南京市语文学科带头人，南京市优秀教育工作者，南京市人大代表。</p>', '研读课', 'http://img.jssns.cn/SHILU/1/52021428019376108.png', 'http://img.jssns.cn/SHILU/1/ae97b641e378765ba3941c519c738f8c.png', '', 'book', 'ID567793485105594368', '', null, '23', null, '168', '2019/4/16 19:35', '168', '2019/4/18 10:01');
INSERT INTO `video` VALUES ('ID567795249028530177', '顶天立地的“人”', 'http://video.likesoft.com.cn/ff4dc71724674d018594763aa51aa21e/9b79e8d2cfd54579a0ddecc570379191-d9070772ee5dcb58b4d31162ab1d73c9-sd.m3u8', null, '', 'http://img.jssns.cn/SHILU/1/52623277663542740.png', 'http://img.jssns.cn/SHILU/1/59014e79d382143b215721240a6f7df6.png', '', 'lesson', '12', '', null, '172', '2', '4.32229E+17', '2019/4/23 18:41', '4.32229E+17', '2019/4/23 18:46');
INSERT INTO `video` VALUES ('ID567795249028530178', '《傅雷家书》给孩子们的启示？', 'http://video.likesoft.com.cn/a2aeb503c449438a9b3e494e8756b627/8f5f541958974f5fb67050b6fd791653-86425809340fe1ee5635440753a63d12-ld.m3u8', '<p><img src=\"http://img.jssns.cn/SHILU/1/52022353200566577.jpg\"><img src=\"http://img.jssns.cn/SHILU/1/52022368509503763.jpg\"></p><p>王跃平&nbsp;江苏省语文特级教师，江苏省教科研先进教师，江苏省首届语文领航名师，南京市语文名师工作室领衔人，南京市语文学科带头人，南京市优秀教育工作者，南京市人大代表。</p>', '品读课', 'http://img.jssns.cn/SHILU/1/52021428019376108.png', 'http://img.jssns.cn/SHILU/1/ae97b641e378765ba3941c519c738f8c.png', '', 'book', 'ID567793485105594368', '', null, '15', null, '168', '2019/4/16 19:35', '168', '2019/4/18 10:01');
INSERT INTO `video` VALUES ('ID570319314746343424', '“大”字的奇妙家族', 'http://video.likesoft.com.cn/83b84eb3cbfd4d8b9d07b07074356e82/86e35404ed894be29c6dda2ce9488cd8-553d93059e8c7456c1f55534e9e62b9b-sd.m3u8', '', null, 'http://img.jssns.cn/SHILU/1/52623212894693871.png', 'http://img.jssns.cn/SHILU/1/4b2126341d688f928d1657ee39023fb7.png', null, 'lesson', '12', null, null, '108', '3', '432228697144033280', '2019-04-23 18:45:20', '432228697144033280', '2019-04-23 18:45:20');
INSERT INTO `video` VALUES ('ID570319691713609728', '懂得奉献才有“福”气', 'http://video.likesoft.com.cn/c702c3469d1542a4b10c7ca86085242f/9d3909e5334247fc9b8469384376d57d-0d0323c834aca52d8a85769ec379b6b1-sd.m3u8', '', null, 'http://img.jssns.cn/SHILU/1/52623301952113585.png', 'http://img.jssns.cn/SHILU/1/fb1a59050be80a942f7c09bd344fe003.png', null, 'lesson', '12', null, null, '180', '1', '432228697144033280', '2019-04-23 18:46:50', '432228697144033280', '2019-04-23 18:46:50');
INSERT INTO `video` VALUES ('ID575394088866545664', '“看”字的奥秘', 'http://video.likesoft.com.cn/686d92db15b64d8fb39ec3fdf9e00ffa/91ec18ca63b34000bc463e62bcbfbefe-61cf72970c617c4b61f4f9cd48e000f5-ld.m3u8', '', '', 'http://img.jssns.cn/SHILU/1/53833133111898049.png', 'http://img.jssns.cn/SHILU/1/4aad40de2ca631acb6b99c3b51338c67.png', null, 'lesson', '13', null, null, '76', '5', '517353407590170624', '2019-05-07 18:50:41', '517353407590170624', '2019-05-07 18:51:41');
INSERT INTO `video` VALUES ('ID575394738790727680', '做妈妈就是好', 'http://video.likesoft.com.cn/5d3a3eee66b14cbea6b390c10e8aa652/2c4bcf212bc840839c4378d11c0621c1-4e5d416f946e3f6566222c3a7a6b921e-ld.m3u8', '', null, 'http://img.jssns.cn/SHILU/1/53833287518210262.png', 'http://img.jssns.cn/SHILU/1/001e0475960255ffcdc92a5b8bfa05c5.png', null, 'lesson', '13', null, null, '62', '6', '517353407590170624', '2019-05-07 18:53:16', '517353407590170624', '2019-05-07 18:53:16');
