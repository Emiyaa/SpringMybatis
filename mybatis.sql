/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50532
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2017-06-09 18:18:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `price` float(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `createtime` datetime NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('2', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('3', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');
INSERT INTO `items` VALUES ('4', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('5', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('6', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');
INSERT INTO `items` VALUES ('7', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('8', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('9', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');
INSERT INTO `items` VALUES ('10', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('11', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('12', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');
INSERT INTO `items` VALUES ('13', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('14', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('15', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');
INSERT INTO `items` VALUES ('16', '台式机', '3000.0', '该电脑质量非常好！！！！', '/pic/20170511/68dda992-d49a-4ba0-bd98-3dd361c94551.jpg', '2015-02-03 13:22:53');
INSERT INTO `items` VALUES ('17', '笔记本', '6000.0', '笔记本性能好，质量好！！！！！', '/pic/20161215/57fbdbf0-a055-4bd2-9425-53c587ca1493.jpg', '2015-02-09 13:22:57');
INSERT INTO `items` VALUES ('18', '背包', '2000.0', '名牌背包，容量大质量好！！！！', '/pic/20161211/08ae6e57-eca2-4ccd-bc98-4e95cab303c3.jpg', '2015-02-06 13:23:02');

-- ----------------------------
-- Table structure for `orderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) NOT NULL COMMENT '订单id',
  `items_id` int(11) NOT NULL COMMENT '商品id',
  `items_num` int(11) DEFAULT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`),
  KEY `FK_orderdetail_1` (`orders_id`),
  KEY `FK_orderdetail_2` (`items_id`),
  CONSTRAINT `FK_orderdetail_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_orderdetail_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '3', '1', '1');
INSERT INTO `orderdetail` VALUES ('2', '3', '2', '3');
INSERT INTO `orderdetail` VALUES ('3', '4', '3', '4');
INSERT INTO `orderdetail` VALUES ('4', '4', '2', '3');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '下单用户id',
  `number` varchar(32) NOT NULL COMMENT '订单号',
  `createtime` datetime NOT NULL COMMENT '创建订单时间',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_orders_1` (`user_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('3', '1', '1000010', '2015-02-04 13:22:35', null);
INSERT INTO `orders` VALUES ('4', '1', '1000011', '2015-02-03 13:22:41', null);
INSERT INTO `orders` VALUES ('5', '10', '1000012', '2015-02-12 16:13:23', null);

-- ----------------------------
-- Table structure for `publicurl`
-- ----------------------------
DROP TABLE IF EXISTS `publicurl`;
CREATE TABLE `publicurl` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publicurl
-- ----------------------------
INSERT INTO `publicurl` VALUES ('1', '/login');
INSERT INTO `publicurl` VALUES ('2', '/js/');
INSERT INTO `publicurl` VALUES ('3', '/toRegist');
INSERT INTO `publicurl` VALUES ('4', '/registTo');
INSERT INTO `publicurl` VALUES ('5', '/loginTo');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `password` varchar(16) NOT NULL,
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '王五', 'admin', '2016-11-13', '2', '河南郑州');
INSERT INTO `user` VALUES ('10', '张三', 'admin', '2014-07-10', '1', '北京市');
INSERT INTO `user` VALUES ('16', '张小明', 'admin', '2016-11-13', '1', '河南郑州');
INSERT INTO `user` VALUES ('22', '陈小明', 'admin', '2016-11-13', '1', '河南郑州');
INSERT INTO `user` VALUES ('24', '张三丰', 'admin', '2016-11-13', '1', '河南郑州');
INSERT INTO `user` VALUES ('25', '陈小明', 'admin', '2016-11-13', '1', '河南郑州');
INSERT INTO `user` VALUES ('27', 'admin', 'admin', '2016-12-09', '1', '湖北襄阳');
