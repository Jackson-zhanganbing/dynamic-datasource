/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 30/05/2019 13:33:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `age` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'age',
  `weight` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'weight',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhang', '27', '150');
INSERT INTO `user` VALUES (2, 'zhou', '28', '150');
INSERT INTO `user` VALUES (3, 'liu', '24', '100');
INSERT INTO `user` VALUES (10, 'test10', '210', '10010');
INSERT INTO `user` VALUES (11, 'test11', '211', '10011');
INSERT INTO `user` VALUES (12, 'test12', '212', '10012');
INSERT INTO `user` VALUES (13, 'test13', '213', '10013');
INSERT INTO `user` VALUES (14, 'test14', '214', '10014');
INSERT INTO `user` VALUES (15, 'test15', '215', '10015');
INSERT INTO `user` VALUES (16, 'test16', '216', '10016');
INSERT INTO `user` VALUES (17, 'test17', '217', '10017');
INSERT INTO `user` VALUES (18, 'test18', '218', '10018');
INSERT INTO `user` VALUES (19, 'test19', '219', '10019');
INSERT INTO `user` VALUES (20, 'test20', '220', '10020');

SET FOREIGN_KEY_CHECKS = 1;
