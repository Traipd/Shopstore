/*
MySQL Data Transfer
Source Host: localhost
Source Database: shopstore
Target Host: localhost
Target Database: shopstore
Date: 2018-07-21 16:31:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for manager
-- ----------------------------
CREATE TABLE `manager` (
  `id` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storehome
-- ----------------------------
CREATE TABLE `storehome` (
  `pid` varchar(40) NOT NULL,
  `category` varchar(40) DEFAULT NULL,
  `pname` varchar(40) DEFAULT NULL,
  `pprize` varchar(40) DEFAULT NULL,
  `introduction` varchar(40) DEFAULT NULL,
  `rigdate` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `manager` VALUES ('htc', '甜橙', '123');
INSERT INTO `storehome` VALUES ('11', '003', '松井佑贵演奏会门票', '500', '必须去', '2018-7-25');
INSERT INTO `storehome` VALUES ('12', '005', '伍伍慧演奏合集', '50', '好听', '2018-7-24');
INSERT INTO `storehome` VALUES ('13', '002', '伍伍慧，井草合奏专辑', '30', '演奏合集', '2018-7-24');
INSERT INTO `storehome` VALUES ('14', '002', '伍伍慧指弹教学', '32', '演奏教学', '2018-7-24');
INSERT INTO `storehome` VALUES ('15', '003', '伍伍慧自传', '66', '人物传记', '2018-7-24');
INSERT INTO `storehome` VALUES ('16', '001', '伍伍慧：等待的风', '15', '乐谱', '2018-7-24');
INSERT INTO `storehome` VALUES ('17', '004', '中国移动流量套餐', '12', '免流量限定一月', '2018-7-24');
INSERT INTO `storehome` VALUES ('18', '004', '方便面', '4', '好吃', '2018-7-24');
INSERT INTO `storehome` VALUES ('19', '005', '贞德手办', '500', '限量版', '2018-7-24');
INSERT INTO `storehome` VALUES ('20', '005', '室友的人头', '0.1', '不值钱', '2018-7-25');
INSERT INTO `storehome` VALUES ('21', '005', '崔钰琳的人头', '0.01', '不值钱', '2018-7-25');
INSERT INTO `storehome` VALUES ('22', '005', '电玩手游', '5', '充值工具', '2018-7-25');
INSERT INTO `storehome` VALUES ('23', '005', 'fgo圣晶石大礼包', '256', '充值fgo', '2018-7-25');
INSERT INTO `storehome` VALUES ('24', '005', '康娜酱1:1手办', '1000', '完全1:1还原', '2018-7-25');
INSERT INTO `storehome` VALUES ('25', '005', '我爱血小板 手办', '2000', '工作细胞手办', '2018-7-25');
INSERT INTO `storehome` VALUES ('26', '005', 'bilibili大会员', '98', '年度大会员', '2018-7-25');
INSERT INTO `storehome` VALUES ('27', '003', '小鬼子的人头', '0.01', '不值钱', '2018-7-25');
INSERT INTO `storehome` VALUES ('28', '003', '中正式步枪', '500', '抗日战争纪念模型', '2018-7-25');
INSERT INTO `storehome` VALUES ('29', '003', '5.5毫米冲锋枪子弹', '667', '游戏实体还原', '2018-7-25');
INSERT INTO `storehome` VALUES ('30', '003', '舒肤佳清凉一夏沐浴露', '38', '三重薄荷精华 清凉一夏', '2018-7-25');
INSERT INTO `storehome` VALUES ('31', '001', '录取通知书', '450', '无价', '2018-7-25');
INSERT INTO `storehome` VALUES ('32', '003', '小米8', '1699', '全新上市', '2018-7-26');
INSERT INTO `storehome` VALUES ('4', '004', '妮维雅', '50', '深层补水', '2018-7-21');
INSERT INTO `storehome` VALUES ('7', '002', '资生堂', '55', '中药成分滋补', '2018-7-23');
INSERT INTO `storehome` VALUES ('8', '002', '腾讯大王卡', '999', '免流量', '2018-7-24');
