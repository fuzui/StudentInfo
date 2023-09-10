/*
 Navicat MySQL Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 120.79.5.252:3306
 Source Schema         : selc

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 20/06/2019 09:41:55
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
INSERT INTO `course` VALUES ('0011', 'java程序设计', '1111', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('1005', '大学英语5', '大学英语5', '必修', '外国语学院', '外国语所有专业');
INSERT INTO `course` VALUES ('123', '123', '123', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('2002', '网络工程', '网络安全、网络路由配置', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('2003', 'C语言基础', 'C语言介绍使用', '必修', '计算机学院', '所有');
INSERT INTO `course` VALUES ('2004', '大学英语（1）', '大学英语', '必修', '所有', '所有');
INSERT INTO `course` VALUES ('2005', 'c++基础', 'c++基础', '必修', '计算机学院', '网络工程');
INSERT INTO `course` VALUES ('5002', 'javaEE', 'java相关框架', '选修', '计算机学院', '软件工程');

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
INSERT INTO `courseplan` VALUES ('123', '12', '1', '0011', '0005', '500', 3, 3, 50);
INSERT INTO `courseplan` VALUES ('456', '12', '1', '1005', '0005', '500', 3, 3, 50);
INSERT INTO `courseplan` VALUES ('C语言1班', '12', '7', '2003', '0002', '30802', 4, 40, 30);
INSERT INTO `courseplan` VALUES ('javaE2', '12,34', '3', '5002', '0002', '10105', 5, 25, 30);
INSERT INTO `courseplan` VALUES ('java设计', '34,56', '1,4,6', '0011', '0022', '10105', 6, 60, 30);
INSERT INTO `courseplan` VALUES ('网络班级2', '34,56', '4', '2002', '0002', '20202', 5, 25, 35);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` char(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `cid` char(4) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `grade` int(3) NULL DEFAULT NULL,
  `credits` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (3, '201507021225', '5002', 75, 5);
INSERT INTO `grade` VALUES (5, '201507024129', '5002', 79, 5);
INSERT INTO `grade` VALUES (6, '201507024125', '5002', 76, 5);
INSERT INTO `grade` VALUES (7, '201507024126', '5002', 79, 5);
INSERT INTO `grade` VALUES (8, '201507024128', '5002', 58, NULL);
INSERT INTO `grade` VALUES (12, '201507024128', '5002', 60, 5);
INSERT INTO `grade` VALUES (13, '201507021227', '2002', 22, NULL);
INSERT INTO `grade` VALUES (14, '201507021227', '2002', 66, 5);

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
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES (84, '1005', '201507024125');
INSERT INTO `sc` VALUES (85, '2002', '201507021227');

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
  PRIMARY KEY (`Sid`) USING BTREE,
  INDEX `class`(`Classr`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201507021227', '依凡', '3443778845551214', '女', '000000', '21', '软件B151', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507023225', '苏通', '1405819961012621', '男', '000000', '22', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507023226', '赵玉', '1253333388877788', '女', '000000', '23', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507023228', '张亚', '8885456456498512', '女', '000000', '21', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507023229', '王野', '1525659875656223', '男', '000000', '24', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507023230', '欧阳离镜', '7849656654641545', '男', '000000', '22', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024125', '王泽', '1405819961012621', '男', '', '22', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024126', '高猛', '1253333388877788', '男', '00000', '23', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024128', '李甜', '8885456456498512', '女', '000000', '21', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024129', '宋球', '1525659875656223', '男', '000000', '24', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024130', '张敏', '7849656654641545', '男', '00000', '22', '网络B151', '网络工程', '计算机学院');
INSERT INTO `student` VALUES ('201507024227', '丁晨', '5564778845551214', '女', '000000', '23', '软件B152', '软件工程', '计算机学院');
INSERT INTO `student` VALUES ('2018', 'wang', '123456', '男', '123456', '18', '1', '软件工程', '计科院');
INSERT INTO `student` VALUES ('88888888', 'wu', '123456', '男', '123123', '18', '阿萨大', '阿萨大大', '阿瑟东撒的');

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
INSERT INTO `teacher` VALUES ('0002', '李浩', '111111', '男', 'kindly\r\nkindly');
INSERT INTO `teacher` VALUES ('0005', '王智宏', '123123', '男', '');
INSERT INTO `teacher` VALUES ('0022', '鞠红军', '111111', '男', 'kingdy');
INSERT INTO `teacher` VALUES ('1003', '任雨', '123456', '女', '随和！~');
INSERT INTO `teacher` VALUES ('1010', '苏弥', '000000', '女', '教学有方');
INSERT INTO `teacher` VALUES ('5010', '冬玲', '111111', '女', '和蔼可亲');
INSERT INTO `teacher` VALUES ('9005', '李梅', '654321', '男', '严厉！');

-- ----------------------------
-- Table structure for wang
-- ----------------------------
DROP TABLE IF EXISTS `wang`;
CREATE TABLE `wang`  (
  `id` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wang
-- ----------------------------
INSERT INTO `wang` VALUES (123);

SET FOREIGN_KEY_CHECKS = 1;
