/*
 Navicat Premium Data Transfer

 Source Server         : aliwaiwangdatabase
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : xinsheng.mysql.rds.aliyuncs.com:3306
 Source Schema         : o2o

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 27/10/2022 13:44:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area`  (
  `area_id` int(5) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`area_id`) USING BTREE,
  UNIQUE INDEX `UK_AREA`(`area_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_area
-- ----------------------------
INSERT INTO `tb_area` VALUES (1, '西苑', 1, '2022-10-25 14:21:22', NULL);
INSERT INTO `tb_area` VALUES (2, '东苑', 2, '2022-10-25 14:21:43', NULL);

-- ----------------------------
-- Table structure for tb_head_line
-- ----------------------------
DROP TABLE IF EXISTS `tb_head_line`;
CREATE TABLE `tb_head_line`  (
  `line_id` int(100) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `line_link` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `line_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NULL DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`line_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_head_line
-- ----------------------------

-- ----------------------------
-- Table structure for tb_local_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth`  (
  `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`local_auth_id`) USING BTREE,
  UNIQUE INDEX `uk_local_profile`(`user_name`) USING BTREE,
  INDEX `fk_local_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_local_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_local_auth
-- ----------------------------

-- ----------------------------
-- Table structure for tb_person_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_type` int(2) NOT NULL DEFAULT 1,
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `profile_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_person_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `normal_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `promotion_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `product_category_id` int(11) NULL DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `fk_product_shop`(`shop_id`) USING BTREE,
  INDEX `fk_product_procate`(`product_category_id`) USING BTREE,
  CONSTRAINT `fk_product_procate` FOREIGN KEY (`product_category_id`) REFERENCES `tb_product_category` (`product_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_product_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_category`;
CREATE TABLE `tb_product_category`  (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priority` int(2) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `shop_id` int(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`product_category_id`) USING BTREE,
  INDEX `fk_procate_shop`(`shop_id`) USING BTREE,
  CONSTRAINT `fk_procate_shop` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`shop_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_product_img
-- ----------------------------
DROP TABLE IF EXISTS `tb_product_img`;
CREATE TABLE `tb_product_img`  (
  `product_img_id` int(20) NOT NULL AUTO_INCREMENT,
  `img_addr` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_desc` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `product_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`product_img_id`) USING BTREE,
  INDEX `fk_proimg_product`(`product_id`) USING BTREE,
  CONSTRAINT `fk_proimg_product` FOREIGN KEY (`product_id`) REFERENCES `tb_product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product_img
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop`  (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) NULL DEFAULT NULL,
  `shop_category_id` int(11) NULL DEFAULT NULL,
  `parent_category_id` int(11) NULL DEFAULT NULL,
  `shop_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `shop_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `shop_img` varchar(1024) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `priority` int(3) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT 0,
  `advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shop_id`) USING BTREE,
  INDEX `fk_shop_profile`(`owner_id`) USING BTREE,
  INDEX `fk_shop_area`(`area_id`) USING BTREE,
  INDEX `fk_shop_shopcate`(`shop_category_id`) USING BTREE,
  INDEX `fk_shop_parentcate`(`parent_category_id`) USING BTREE,
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_shop_parentcate` FOREIGN KEY (`parent_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shop_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category`  (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `shop_category_img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `last_edit_time` datetime(0) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`) USING BTREE,
  INDEX `fk_shop_category_self`(`parent_id`) USING BTREE,
  CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_shop_category
-- ----------------------------

-- ----------------------------
-- Table structure for tb_wechat_auth
-- ----------------------------
DROP TABLE IF EXISTS `tb_wechat_auth`;
CREATE TABLE `tb_wechat_auth`  (
  `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `open_id` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`wechat_auth_id`) USING BTREE,
  UNIQUE INDEX `open_id`(`open_id`) USING BTREE,
  INDEX `fk_oauth_profile`(`user_id`) USING BTREE,
  CONSTRAINT `fk_oauth_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_wechat_auth
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
