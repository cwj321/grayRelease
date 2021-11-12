/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : grayupdate

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 12/11/2021 19:14:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `download_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `aid` int(0) NULL DEFAULT NULL,
  `md5` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_version_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `max_update_version_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `min_update_version_code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `device_id_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `min_os_api` int(0) NULL DEFAULT NULL,
  `max_os_api` int(0) NULL DEFAULT NULL,
  `title` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_tips` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `channel` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cpu_arch` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `env` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'pro',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `complex_index`(`platform`, `channel`, `cpu_arch`, `aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES (1, 'android', 'http://baidu.com', 1, '12345', '10.0.0', '9.2', '9.1', 'a,b,c', 8, 9, '测试', 'tip1', '应用商店', '64', 'pro');
INSERT INTO `rule` VALUES (2, 'android', 'http://baidu.com', 1, '12345', '10.0.0', '8.0.3', '9.1', 'a,b,c', 8, 9, '测试', 'tip1', '应用商店', '32', 'pro');
INSERT INTO `rule` VALUES (3, 'ios', 'https://bing.com', 2, 'sa2w14s', '10.0.1', '9.0.1', '9.0.0', 'a,b,c,d,e', 10, 11, '更新提示', 'tip2', '浏览器', '64', 'dev');
INSERT INTO `rule` VALUES (4, 'ios', 'https://bing.com', 2, 'sa2w14s', '10.0.1', '9.0.1', '9.0.0', 'a,b,c,d,e', 10, 11, '更新提示', 'tip2', '浏览器', '64', 'pro');
INSERT INTO `rule` VALUES (5, 'android', 'https://baidu.com', 3, '123fdsiu127bf', '8.9', '8.8', '8.7', '1,2,3,4', 10, 11, 'update', 'tip', '应用商店', '64', 'pro');
INSERT INTO `rule` VALUES (6, 'android', 'https://baidu.com', 4, '123fdsiu127bf', '8.9', '8.8', '8.7', '1,2,3,4', 10, 11, 't', '123', '应用商店', '64', 'pro');
INSERT INTO `rule` VALUES (7, 'android', 'https://baidu.com', 6, '123fdsiu127bf', '8.9', '8.8', '8.7', '1,2,3,4', 10, 11, '134', 'tip', '应用商店', '64', 'pro');

SET FOREIGN_KEY_CHECKS = 1;
