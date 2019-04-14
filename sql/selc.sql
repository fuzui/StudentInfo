/*
 Navicat MySQL Data Transfer

 Source Server         : 腾讯云centos7.6
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 94.191.88.237:3306
 Source Schema         : selc

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 14/04/2019 21:47:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `Aname` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Apassword` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Aname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `Cid` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cintroduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `belongcoll` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `belongpro` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('0001', '数据结构', 'java 数据结构', '必修', '计算机学院', '计算机所有专业');
INSERT INTO `course` VALUES ('008', '面向对象思想', 'java为例的面向对象', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('1000', 'OS', 'OS', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('2001', '软件工程', '详细介绍软件设计流程', '必修', '计算机学院', '软件工程');
INSERT INTO `course` VALUES ('2002', '网络工程', '网络安全、网络路由配置', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('2003', 'C语言基础', 'C语言介绍使用', '必修', '计算机学院', '所有');
INSERT INTO `course` VALUES ('2004', '大学英语（1）', '大学英语', '必修', '所有', '所有');
INSERT INTO `course` VALUES ('2005', '汉语言', '汉语课程', '必修', '人文学院', '汉语');
INSERT INTO `course` VALUES ('5001', 'ORACLE', 'oracle12G数据库', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('5002', 'javaEE', 'java相关框架', '选修', '计算机学院', '软件工程');
INSERT INTO `course` VALUES ('5012', '线性代数', '线性代数1111', '必修', '所有学院', '所有专业');

-- ----------------------------
-- Table structure for courseplan
-- ----------------------------
DROP TABLE IF EXISTS `courseplan`;
CREATE TABLE `courseplan`  (
  `Courseclass` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coursetime` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseweek` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tid` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classroom` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credits` int(11) NULL DEFAULT NULL,
  `period` int(11) NULL DEFAULT NULL,
  `Totalnum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Courseclass`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  INDEX `tid`(`tid`) USING BTREE,
  CONSTRAINT `courseplan_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `courseplan_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `teacher` (`Tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseplan
-- ----------------------------
INSERT INTO `courseplan` VALUES ('C语言1班', '12', '7', '2003', '0002', '30802', 4, 40, 30);
INSERT INTO `courseplan` VALUES ('线性1班', '56', '3', '5012', '1003', '10506', 3, 20, 30);
INSERT INTO `courseplan` VALUES ('网络工程1班', '34', '5', '2002', '9001', '10103', 4, 40, 40);
INSERT INTO `courseplan` VALUES ('软件工程1班', '56', '3', '2001', '0002', '30803', 5, 40, 30);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sid` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  INDEX `sid`(`sid`) USING BTREE,
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`Cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `student` (`Sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (20, '2001', '201220122016');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `Sid` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sidcard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ssex` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Spassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sage` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Classr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profession` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201107024126', '高猛', '123456123456123123', '男', '000000', '23', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201220122016', '王泽', '140140199612122255', '男', '111111', '22', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201220122017', '王波', '140514199610106458', '男', '111111', '19', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201220122018', '刘倩', '8899281992022954', '女', '000000', '22', '汉语B152', '汉语言', '人文学院');
INSERT INTO `student` VALUES ('201220122019', '王叶波', '5258446926545255', '男', 'dddddd', '22', '英语B152', '英语', '外国语学院');
INSERT INTO `student` VALUES ('201507024101', '高铭', '150140199701029854', '男', '000000', '22', '外语B165', '英语', '外国语学院');
INSERT INTO `student` VALUES ('201507024102', '曹门', '13052719920229542X', '男', '111111', '23', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024105', '强非非', '520658199709105895', '男', '000000', '22', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024126', '高那', '584325987412012047', '男', '000000', '21', '软件B145', '软件工程', '计算机学院');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `Tid` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tpassword` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tsex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Introduction` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('0002', '王艳', '111111', '女', 'kindly');
INSERT INTO `teacher` VALUES ('1003', '任雨', '123456', '女', '随和！~');
INSERT INTO `teacher` VALUES ('1010', '苏弥', '000000', '男', '教学有方');
INSERT INTO `teacher` VALUES ('5010', '冬玲', '111111', '女', '和蔼可亲');
INSERT INTO `teacher` VALUES ('9001', '李浩', '111111', '男', '和蔼、亲近、志同道合');
INSERT INTO `teacher` VALUES ('9002', '吕雅', '111111', '女', '美丽！');
INSERT INTO `teacher` VALUES ('9005', '李梅', '654321', '男', '严厉！');

-- ----------------------------
-- Table structure for wang
-- ----------------------------
DROP TABLE IF EXISTS `wang`;
CREATE TABLE `wang`  (
  `id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wang
-- ----------------------------
INSERT INTO `wang` VALUES (123);

SET FOREIGN_KEY_CHECKS = 1;
