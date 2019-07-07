/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : cheapshop

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 07/07/2019 08:50:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cs_common_user
-- ----------------------------
DROP TABLE IF EXISTS `cs_common_user`;
CREATE TABLE `cs_common_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gender` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_common_user
-- ----------------------------
INSERT INTO `cs_common_user` VALUES (1, 1, '1232', '1', '1', '1', '1', '1', '2019-06-02 17:54:13', '2019-06-04 10:54:54');
INSERT INTO `cs_common_user` VALUES (3, 1, '小强', '666666', '12312', '大白', '123141332@qq.com', '42152341234', '2019-06-04 14:49:30', '2019-06-28 01:14:10');
INSERT INTO `cs_common_user` VALUES (6, 1, '6666666', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-04 14:49:42', NULL);
INSERT INTO `cs_common_user` VALUES (7, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:41:52', NULL);
INSERT INTO `cs_common_user` VALUES (8, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:49:46', NULL);
INSERT INTO `cs_common_user` VALUES (9, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:50:36', NULL);
INSERT INTO `cs_common_user` VALUES (10, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:51:10', NULL);
INSERT INTO `cs_common_user` VALUES (11, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:52:05', NULL);
INSERT INTO `cs_common_user` VALUES (12, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:52:39', NULL);
INSERT INTO `cs_common_user` VALUES (13, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-27 23:53:22', NULL);
INSERT INTO `cs_common_user` VALUES (14, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-28 00:05:19', NULL);
INSERT INTO `cs_common_user` VALUES (15, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-28 00:10:08', NULL);
INSERT INTO `cs_common_user` VALUES (16, 0, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-28 01:14:10', NULL);
INSERT INTO `cs_common_user` VALUES (17, 1, '小明', '123456', '12312', '大白', '451835900@qq.com', '13253242142', '2019-06-30 00:31:35', NULL);

-- ----------------------------
-- Table structure for cs_shop_address
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_address`;
CREATE TABLE `cs_shop_address`  (
  `addressid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `firstname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '姓',
  `lastname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '名',
  `company` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '公司',
  `address` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详细地址',
  `postcode` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮编',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电话',
  `userid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`addressid`) USING BTREE,
  INDEX `shop_address_userid`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_shop_address
-- ----------------------------
INSERT INTO `cs_shop_address` VALUES (1, 'zhang', 'cheng', 'xxx', '深圳市福田区', '123', '457825900@qq.com', '123123', 1, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for cs_shop_admin
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_admin`;
CREATE TABLE `cs_shop_admin`  (
  `adminid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `adminuser` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员账号',
  `adminpass` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员密码',
  `adminemail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员电子邮箱',
  `logintime` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '登陆时间',
  `loginip` bigint(20) NOT NULL DEFAULT 0 COMMENT '登陆IP',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`adminid`) USING BTREE,
  UNIQUE INDEX `shop_admin_adminuser_adminpass`(`adminuser`, `adminpass`) USING BTREE,
  UNIQUE INDEX `shop_admin_adminuser_adminemail`(`adminuser`, `adminemail`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_shop_cart
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_cart`;
CREATE TABLE `cs_shop_cart`  (
  `cartid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `productid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品id',
  `userid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `productnum` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '加入购物车的商品数量',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '加入购物车时的商品价格',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`cartid`) USING BTREE,
  INDEX `shop_cart_userid`(`userid`) USING BTREE,
  INDEX `shop_cart_productid`(`productid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_category`;
CREATE TABLE `cs_shop_category`  (
  `cateid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `parentid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父级id',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`cateid`) USING BTREE,
  INDEX `shop_category_parentid`(`parentid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '无限级商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_shop_order
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_order`;
CREATE TABLE `cs_shop_order`  (
  `orderid` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单id',
  `userid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '下单人id',
  `amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '订单总价',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态',
  `addressid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '收货地址',
  `expressid` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '快递id',
  `expressno` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '快递单号',
  `tradeno` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '支付交易号',
  `tradeext` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '支付信息',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  `updatetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`orderid`) USING BTREE,
  INDEX `shop_order_userid`(`userid`) USING BTREE,
  INDEX `shop_order_addressid`(`addressid`) USING BTREE,
  INDEX `shop_order_expressid`(`expressid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_shop_order
-- ----------------------------
INSERT INTO `cs_shop_order` VALUES ('e097179de04e4c0694468a0536b3dc0c', 1, 9.00, 3, 1, 123, '6666', '232323', 'Good', '2019-07-06 23:04:38', '2019-07-06 23:04:37');

-- ----------------------------
-- Table structure for cs_shop_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_order_detail`;
CREATE TABLE `cs_shop_order_detail`  (
  `detailid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单详情id',
  `orderid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单id',
  `productid` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '商品id',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '商品价格',
  `productnum` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品数量',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`detailid`) USING BTREE,
  INDEX `shop_order_detail_orderid`(`orderid`) USING BTREE,
  INDEX `shop_order_detail_productid`(`productid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_shop_order_detail
-- ----------------------------
INSERT INTO `cs_shop_order_detail` VALUES (1, 0, 1, 9.00, 2, '2019-07-06 23:04:38');

-- ----------------------------
-- Table structure for cs_shop_product
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_product`;
CREATE TABLE `cs_shop_product`  (
  `productid` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `cateid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品分类id',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '库存',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `cover` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '封面图',
  `pics` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '图片集合',
  `issale` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否促销',
  `saleprice` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '促销价格',
  `ishot` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否热卖',
  `ison` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否上架',
  `istui` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否推荐',
  `createtime` datetime(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`productid`) USING BTREE,
  INDEX `shop_product_cateid`(`cateid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_shop_product
-- ----------------------------
INSERT INTO `cs_shop_product` VALUES (1, 1, '薯片', '黄瓜味', 44, 9.00, '123.png', '456.png,789.png', '1', 5.00, '1', '1', '1', '2019-06-30 00:51:51');
INSERT INTO `cs_shop_product` VALUES (3, 1, '薯片', '黄瓜味', 50, 9.00, '123.png', '456.png,789.png', '1', 5.00, '1', '1', '1', '2019-06-30 11:35:16');
INSERT INTO `cs_shop_product` VALUES (4, 1, '薯片', '黄瓜味', 50, 9.00, '123.png', '456.png,789.png', '1', 5.00, '1', '1', '1', '2019-07-06 18:41:29');

-- ----------------------------
-- Table structure for cs_shop_profile
-- ----------------------------
DROP TABLE IF EXISTS `cs_shop_profile`;
CREATE TABLE `cs_shop_profile`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `truename` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `age` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '年龄',
  `sex` enum('0','1','2') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '性别',
  `birthday` date NOT NULL DEFAULT '1992-12-05' COMMENT '生日',
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `company` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '公司',
  `userid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  `createtime` timestamp(0) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `shop_profile_userid`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员详细信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
