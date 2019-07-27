/*
Navicat MySQL Data Transfer

Source Server         : 本地开发环境
Source Server Version : 50721
Source Host           : 192.168.1.2:3306
Source Database       : study

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-05-22 21:31:15
*/

-- 创建数据库
-- create database `xibian` default character set utf8mb4 collate utf8mb4_general_ci;
create database `xibian` default character set utf8 collate utf8_general_ci;

use `xibian` ;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_log
-- ----------------------------
DROP TABLE IF EXISTS `account_log`;
CREATE TABLE `account_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` bigint(20) NOT NULL COMMENT '客户Id',
  `reward_rule_id` varchar(255) DEFAULT NULL COMMENT '奖励规则Id',
  `account_log_id` bigint(20) DEFAULT NULL COMMENT '关联账户日志id',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='账户日志表';

-- ----------------------------
-- Records of account_log
-- ----------------------------

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '课程名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'java开发', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('2', 'java开发1', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('3', 'java开发2', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('4', 'java开发3', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('5', 'java开发4', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('6', 'java开发5', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('7', 'java开发6', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('8', 'java开发7', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('9', 'java开发8', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('10', 'java开发9', '100.00', null, null, null, null, null, null);
INSERT INTO `course` VALUES ('11', 'java开发10', '100.00', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for course_order
-- ----------------------------
DROP TABLE IF EXISTS `course_order`;
CREATE TABLE `course_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` bigint(255) DEFAULT NULL COMMENT '客户ID',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程ID',
  `status` tinyint(20) DEFAULT NULL COMMENT '订单状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of course_order
-- ----------------------------
INSERT INTO `course_order` VALUES ('1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码盐',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别（1:男,2:女）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '陈文韬', '5602b313de6d3380d89011b7673acf38a0c89176e8b8229ab10c82b265e421fa', '8dVWeD', null, '1', '1', '1', '1', '2019-05-13 09:48:27', '2019-05-15 20:17:38', '1');

-- ----------------------------
-- Table structure for customer_account
-- ----------------------------
DROP TABLE IF EXISTS `customer_account`;
CREATE TABLE `customer_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户id',
  `money` decimal(10,0) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='客户账户表';

-- ----------------------------
-- Records of customer_account
-- ----------------------------

-- ----------------------------
-- Table structure for customer_marketing
-- ----------------------------
DROP TABLE IF EXISTS `customer_marketing`;
CREATE TABLE `customer_marketing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户Id',
  `type` tinyint(2) DEFAULT NULL COMMENT '客户营销类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='客户营销表';

-- ----------------------------
-- Records of customer_marketing
-- ----------------------------
INSERT INTO `customer_marketing` VALUES ('1', '6', '1', '2019-05-17 18:22:01');
INSERT INTO `customer_marketing` VALUES ('2', '7', '1', '2019-05-21 20:17:46');
INSERT INTO `customer_marketing` VALUES ('3', '8', '1', '2019-05-21 20:32:13');
INSERT INTO `customer_marketing` VALUES ('4', '9', '1', '2019-05-21 20:32:46');
INSERT INTO `customer_marketing` VALUES ('5', '11', '1', '2019-06-25 00:19:04');

-- ----------------------------
-- Table structure for customer_team
-- ----------------------------
DROP TABLE IF EXISTS `customer_team`;
CREATE TABLE `customer_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `leader_id` bigint(20) DEFAULT NULL COMMENT '团长id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '团员Id',
  `level` tinyint(1) DEFAULT NULL COMMENT '级别',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='客户team表';

-- ----------------------------
-- Records of customer_team
-- ----------------------------

-- ----------------------------
-- Table structure for marketing_activity
-- ----------------------------
DROP TABLE IF EXISTS `marketing_activity`;
CREATE TABLE `marketing_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` bigint(20) DEFAULT NULL COMMENT '主题',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户营销表';

-- ----------------------------
-- Records of marketing_activity
-- ----------------------------

-- ----------------------------
-- Table structure for pic_template
-- ----------------------------
DROP TABLE IF EXISTS `pic_template`;
CREATE TABLE `pic_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '课程名',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '是否默认',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `sort` int(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of pic_template
-- ----------------------------
INSERT INTO `pic_template` VALUES ('60', 'chenwt', null, '/xibian/template/20190522/f591be7a1f96447583664458ed44132e.jpg', '1', '', '1', '2019-05-22 17:14:28', null, null);

-- ----------------------------
-- Table structure for reward_rule
-- ----------------------------
DROP TABLE IF EXISTS `reward_rule`;
CREATE TABLE `reward_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(20) DEFAULT NULL COMMENT '规则编码',
  `name` varchar(255) DEFAULT NULL COMMENT '奖励规则名',
  `course_id` decimal(10,2) DEFAULT NULL COMMENT '课程id --- 备用字段',
  `money` decimal(10,0) DEFAULT NULL COMMENT '金额',
  `percentage` decimal(10,0) DEFAULT NULL COMMENT '提成比例',
  `level` tinyint(4) DEFAULT NULL COMMENT '客户层级（所属客户团队）--- 备用字段',
  `create_by` bigint(20) DEFAULT NULL COMMENT '修改者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='奖励规则表';

-- ----------------------------
-- Records of reward_rule
-- ----------------------------
INSERT INTO `reward_rule` VALUES ('1', 'TEAM_REWARD', '我的团队推广奖励', null, null, '10', '1', null, '2019-06-25 20:21:10', '1', '2019-06-25 20:37:19', '1', '');
INSERT INTO `reward_rule` VALUES ('2', 'TEAM_REWARD', '我的团队推广奖励', null, null, '5', '2', null, '2019-06-25 20:21:10', '1', '2019-07-27 18:38:02', '1', '');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `sex` tinyint(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `parent_id` bigint(20) NOT NULL COMMENT '家长Id',
  `remark` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('4', '15820242077', null, null, '6', null, '2019-05-17 18:22:00');
INSERT INTO `student` VALUES ('5', '1', null, null, '7', null, '2019-05-21 20:17:45');
INSERT INTO `student` VALUES ('6', '1', null, null, '8', null, '2019-05-21 20:32:13');
INSERT INTO `student` VALUES ('7', '12', null, null, '9', null, '2019-05-21 20:32:46');
INSERT INTO `student` VALUES ('8', '泡泡', null, null, '11', null, '2019-06-25 00:19:04');

-- ----------------------------
-- Table structure for sys_action_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_action_log`;
CREATE TABLE `sys_action_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '日志类型',
  `ipaddr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `clazz` varchar(255) DEFAULT NULL COMMENT '产生日志的类',
  `method` varchar(255) DEFAULT NULL COMMENT '产生日志的方法',
  `model` varchar(255) DEFAULT NULL COMMENT '产生日志的表',
  `record_id` bigint(20) DEFAULT NULL COMMENT '产生日志的数据id',
  `message` text COMMENT '日志消息',
  `create_date` datetime DEFAULT NULL COMMENT '记录时间',
  `oper_name` varchar(255) DEFAULT NULL COMMENT '产生日志的用户昵称',
  `oper_by` bigint(20) DEFAULT NULL COMMENT '产生日志的用户',
  PRIMARY KEY (`id`),
  KEY `FK32gm4dja0jetx58r9dc2uljiu` (`oper_by`) USING BTREE,
  CONSTRAINT `sys_action_log_ibfk_1` FOREIGN KEY (`oper_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1281 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_action_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `pids` varchar(255) DEFAULT NULL COMMENT '所有父级编号',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  KEY `FKifwd1h4ciusl3nnxrpfpv316u` (`create_by`) USING BTREE,
  KEY `FK83g45s1cjqqfpifhulqhv807m` (`update_by`) USING BTREE,
  CONSTRAINT `sys_dept_ibfk_1` FOREIGN KEY (`update_by`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_dept_ibfk_2` FOREIGN KEY (`create_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '总公司', '0', '[0]', '1', '', '2018-12-02 17:41:23', '2019-02-23 02:41:28', '1', '1', '1');
INSERT INTO `sys_dept` VALUES ('2', '技术部门', '1', '[0],[1]', '1', '', '2018-12-02 17:51:04', '2019-04-27 13:12:46', '1', '1', '1');
INSERT INTO `sys_dept` VALUES ('3', '市场部门', '1', '[0],[1]', '2', '', '2018-12-02 17:51:42', '2019-04-27 13:12:20', '1', '1', '1');
INSERT INTO `sys_dept` VALUES ('4', '研发部门', '1', '[0],[1]', '3', '', '2018-12-02 17:51:55', '2019-04-27 13:12:20', '1', '1', '1');
INSERT INTO `sys_dept` VALUES ('5', '测试部门', '1', '[0],[1]', '4', '', '2018-12-02 17:52:07', '2019-04-27 13:12:20', '1', '1', '1');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `name` varchar(255) DEFAULT NULL COMMENT '字典键名',
  `type` tinyint(4) DEFAULT NULL COMMENT '字典类型',
  `value` text COMMENT '字典键值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  KEY `FKag4shuprf2tjot9i1mhh37kk6` (`create_by`) USING BTREE,
  KEY `FKoyng5jlifhsme0gc1lwiub0lr` (`update_by`) USING BTREE,
  CONSTRAINT `sys_dict_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_dict_ibfk_2` FOREIGN KEY (`update_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '数据状态', 'DATA_STATUS', '2', '1:正常,2:冻结,3:删除', '', '2018-10-05 16:03:11', '2018-10-05 16:11:41', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('2', '字典类型', 'DICT_TYPE', '2', '2:键值对', '', '2018-10-05 20:08:55', '2019-01-17 23:39:23', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('3', '用户性别', 'USER_SEX', '2', '1:男,2:女', '', '2018-10-05 20:12:32', '2018-10-05 20:12:32', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('4', '菜单类型', 'MENU_TYPE', '2', '1:一级菜单,2:子级菜单,3:不是菜单', '', '2018-10-05 20:24:57', '2018-10-13 13:56:05', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('5', '搜索栏状态', 'SEARCH_STATUS', '2', '1:正常,2:冻结', '', '2018-10-05 20:25:45', '2019-02-26 00:34:34', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('6', '日志类型', 'LOG_TYPE', '2', '1:业务,2:登录,3:系统', '', '2018-10-05 20:28:47', '2019-02-26 00:31:43', '1', '1', '1');
INSERT INTO `sys_dict` VALUES ('11', '订单状态', 'ORDER_STATUS', '2', '1:已支付,2:未支付', '描述订单状态', '2019-05-05 20:05:43', '2019-05-05 20:05:43', '1', '1', '1');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `mime` varchar(255) DEFAULT NULL COMMENT 'MIME文件类型',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `md5` varchar(255) DEFAULT NULL COMMENT 'MD5值',
  `sha1` varchar(255) DEFAULT NULL COMMENT 'SHA1值',
  `create_by` bigint(20) DEFAULT NULL COMMENT '上传者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `FKkkles8yp0a156p4247cc22ovn` (`create_by`) USING BTREE,
  CONSTRAINT `sys_file_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('1', '5562c5a20dd4425089d74a411b5e0d86.jpg', '/upload/picture/20190513/5562c5a20dd4425089d74a411b5e0d86.jpg', 'image/jpeg', '18300', '5883e4287f836e8936657c17c4be6089', '209fdbaf1fa0793bebb2aedd41e7c9b92ba4c50d', '1', '2019-05-13 11:14:18');
INSERT INTO `sys_file` VALUES ('52', 'e26e306a875a46f6897d66af697851cd.jpg', '/xibian/picture/20190522/e26e306a875a46f6897d66af697851cd.jpg', 'image/jpeg', '17762', '5c51f8ddde5bf0ab958a616179cea68f', '3bfc6b6003d60ba076424b9b4758defb943d5e10', '1', '2019-05-22 17:13:26');
INSERT INTO `sys_file` VALUES ('53', 'f591be7a1f96447583664458ed44132e.jpg', '/xibian/template/20190522/f591be7a1f96447583664458ed44132e.jpg', 'image/jpeg', '61920', '541d0107266a9ee2ecbb8d7c4ca04f60', 'ca2fc9e0ed193ddc9ad7f4b00c2a8c9ab26d3393', '1', '2019-05-22 17:14:22');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `pid` bigint(20) DEFAULT NULL COMMENT '父级编号',
  `pids` varchar(255) DEFAULT NULL COMMENT '所有父级编号',
  `url` varchar(255) DEFAULT NULL COMMENT 'URL地址',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型（1:一级菜单,2:子级菜单,3:不是菜单）',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  KEY `FKoxg2hi96yr9pf2m0stjomr3we` (`create_by`) USING BTREE,
  KEY `FKsiko0qcr8ddamvrxf1tk4opgc` (`update_by`) USING BTREE,
  CONSTRAINT `sys_menu_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_menu_ibfk_2` FOREIGN KEY (`update_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '菜单管理', '2', '[0],[2]', '/system/menu/index', 'system:menu:index', '', '2', '3', '', '2018-09-29 00:02:10', '2019-02-24 16:10:40', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('2', '系统管理', '0', '[0]', '#', '#', 'fa fa-cog', '1', '2', '', '2018-09-29 00:05:50', '2019-02-27 21:34:56', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('3', '添加', '1', '[0],[2],[1]', '/system/menu/add', 'system:menu:add', '', '3', '1', '', '2018-09-29 00:06:57', '2019-02-24 16:12:59', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '2', '[0],[2]', '/system/role/index', 'system:role:index', '', '2', '2', '', '2018-09-29 00:08:14', '2019-02-24 16:10:34', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('5', '添加', '4', '[0],[2],[4]', '/system/role/add', 'system:role:add', '', '3', '1', '', '2018-09-29 00:09:04', '2019-02-24 16:12:04', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('6', '主页', '0', '[0]', '/index', 'index', 'layui-icon layui-icon-home', '1', '1', '', '2018-09-29 00:09:56', '2019-02-27 21:34:56', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('7', '用户管理', '2', '[0],[2]', '/system/user/index', 'system:user:index', '', '2', '1', '', '2018-09-29 00:43:50', '2019-04-05 17:43:25', '1', '2', '1');
INSERT INTO `sys_menu` VALUES ('8', '编辑', '1', '[0],[2],[1]', '/system/menu/edit', 'system:menu:edit', '', '3', '2', '', '2018-09-29 00:57:33', '2019-02-24 16:13:05', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('9', '详细', '1', '[0],[2],[1]', '/system/menu/detail', 'system:menu:detail', '', '3', '3', '', '2018-09-29 01:03:00', '2019-02-24 16:13:12', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('10', '修改状态', '1', '[0],[2],[1]', '/system/menu/status', 'system:menu:status', '', '3', '4', '', '2018-09-29 01:03:43', '2019-02-24 16:13:21', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('11', '编辑', '4', '[0],[2],[4]', '/system/role/edit', 'system:role:edit', '', '3', '2', '', '2018-09-29 01:06:13', '2019-02-24 16:12:10', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('12', '授权', '4', '[0],[2],[4]', '/system/role/auth', 'system:role:auth', '', '3', '3', '', '2018-09-29 01:06:57', '2019-02-24 16:12:17', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('13', '详细', '4', '[0],[2],[4]', '/system/role/detail', 'system:role:detail', '', '3', '4', '', '2018-09-29 01:08:00', '2019-02-24 16:12:24', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('14', '修改状态', '4', '[0],[2],[4]', '/system/role/status', 'system:role:status', '', '3', '5', '', '2018-09-29 01:08:22', '2019-02-24 16:12:43', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('15', '编辑', '7', '[0],[2],[7]', '/system/user/edit', 'system:user:edit', '', '3', '2', '', '2018-09-29 21:17:17', '2019-02-24 16:11:03', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('16', '添加', '7', '[0],[2],[7]', '/system/user/add', 'system:user:add', '', '3', '1', '', '2018-09-29 21:17:58', '2019-02-24 16:10:28', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('17', '修改密码', '7', '[0],[2],[7]', '/system/user/pwd', 'system:user:pwd', '', '3', '3', '', '2018-09-29 21:19:40', '2019-02-24 16:11:11', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('18', '权限分配', '7', '[0],[2],[7]', '/system/user/role', 'system:user:role', '', '3', '4', '', '2018-09-29 21:20:35', '2019-02-24 16:11:18', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('19', '详细', '7', '[0],[2],[7]', '/system/user/detail', 'system:user:detail', '', '3', '5', '', '2018-09-29 21:21:00', '2019-02-24 16:11:26', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('20', '修改状态', '7', '[0],[2],[7]', '/system/user/status', 'system:user:status', '', '3', '6', '', '2018-09-29 21:21:18', '2019-02-24 16:11:35', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('21', '字典管理', '2', '[0],[2]', '/system/dict/index', 'system:dict:index', '', '2', '5', '', '2018-10-05 00:55:52', '2019-05-22 10:53:10', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('22', '字典添加', '21', '[0],[2],[21]', '/system/dict/add', 'system:dict:add', '', '3', '1', '', '2018-10-05 00:56:26', '2019-05-22 10:53:10', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('23', '字典编辑', '21', '[0],[2],[21]', '/system/dict/edit', 'system:dict:edit', '', '3', '2', '', '2018-10-05 00:57:08', '2019-05-22 10:53:10', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('24', '字典详细', '21', '[0],[2],[21]', '/system/dict/detail', 'system:dict:detail', '', '3', '3', '', '2018-10-05 00:57:42', '2019-05-22 10:53:10', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('25', '修改状态', '21', '[0],[2],[21]', '/system/dict/status', 'system:dict:status', '', '3', '4', '', '2018-10-05 00:58:27', '2019-05-22 10:53:10', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('26', '行为日志', '2', '[0],[2]', '/system/actionLog/index', 'system:actionLog:index', '', '2', '6', '', '2018-10-14 16:52:01', '2019-02-27 21:34:15', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('27', '日志详细', '26', '[0],[2],[26]', '/system/actionLog/detail', 'system:actionLog:detail', '', '3', '1', '', '2018-10-14 21:07:11', '2019-02-27 21:34:15', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('28', '日志删除', '26', '[0],[2],[26]', '/system/actionLog/delete', 'system:actionLog:delete', '', '3', '2', '', '2018-10-14 21:08:17', '2019-02-27 21:34:15', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('30', '开发中心', '0', '[0]', '#', '#', 'fa fa-gavel', '1', '4', '', '2018-10-19 16:38:23', '2019-05-22 10:52:50', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('31', '代码生成', '30', '[0],[30]', '/dev/code', '#', '', '2', '1', '', '2018-10-19 16:39:04', '2019-05-22 10:52:50', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('125', '表单构建', '30', '[0],[30]', '/dev/build', '#', '', '2', '2', '', '2018-11-25 16:12:23', '2019-05-22 10:52:50', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('136', '部门管理', '2', '[0],[2]', '/system/dept/index', 'system:dept:index', '', '2', '4', '', '2018-12-02 16:33:23', '2019-02-24 16:10:50', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('137', '添加', '136', '[0],[2],[136]', '/system/dept/add', 'system:dept:add', '', '3', '1', '', '2018-12-02 16:33:23', '2019-02-24 16:13:34', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('138', '编辑', '136', '[0],[2],[136]', '/system/dept/edit', 'system:dept:edit', '', '3', '2', '', '2018-12-02 16:33:23', '2019-02-24 16:13:42', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('139', '详细', '136', '[0],[2],[136]', '/system/dept/detail', 'system:dept:detail', '', '3', '3', '', '2018-12-02 16:33:23', '2019-02-24 16:13:49', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('140', '改变状态', '136', '[0],[2],[136]', '/system/dept/status', 'system:dept:status', '', '3', '4', '', '2018-12-02 16:33:23', '2019-02-24 16:13:57', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('146', '数据接口', '30', '[0],[30]', '/dev/swagger', '#', '', '2', '3', '', '2018-12-09 21:11:11', '2019-05-22 10:52:50', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('159', '业务管理', '0', '[0]', '#', '#', 'fa fa-server', '1', '3', '', '2019-05-05 00:02:18', '2019-05-05 00:02:18', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('160', '客户管理', '159', '[0],[159]', '/business/customer/index', 'business:customer:index', '', '2', '1', '客户管理页面', '2019-05-06 14:10:19', '2019-05-06 14:10:19', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('161', '课程管理', '159', '[0],[159]', '/business/course/index', 'business:course:index', '', '2', '2', '课程管理页面', '2019-05-06 14:10:19', '2019-05-06 14:10:19', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('162', '订单管理', '159', '[0],[159]', '/business/courseOrder/index', 'business:courseOrder:index', '', '2', '3', '订单管理页面', '2019-05-06 14:10:19', '2019-05-06 14:10:19', '1', '1', '3');
INSERT INTO `sys_menu` VALUES ('163', '模板管理', '159', '[0],[159]', '/business/picTemplate/index', 'business:picTemplate:index', '', '2', '4', '模板管理页面', '2019-05-06 14:10:19', '2019-05-06 14:10:19', '1', '1', '1');
INSERT INTO `sys_menu` VALUES ('164', '奖励管理', '159', '[0],[159]', '/business/rewardRule/index', 'business:rewardRule:index', '', '2', '5', '奖励管理页面', '2019-05-06 14:10:19', '2019-05-06 14:10:19', '1', '1', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '角色名称（中文名）',
  `name` varchar(255) DEFAULT NULL COMMENT '标识名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  KEY `FKdkwvv0rm6j3d5l6hwsy2dplol` (`create_by`) USING BTREE,
  KEY `FKrouqqi3f2bgc5o83wdstlh6q4` (`update_by`) USING BTREE,
  CONSTRAINT `sys_role_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_role_ibfk_2` FOREIGN KEY (`update_by`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', '', '2018-09-29 00:12:40', '2019-01-18 21:09:51', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('2', '开发组', 'group', '', '2018-09-30 16:04:32', '2019-04-28 00:10:00', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('3', '用户组', 'group1', '', '2018-09-30 16:24:20', '2019-04-28 00:11:09', '1', '1', '1');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `FKf3mud4qoc7ayew8nml4plkevo` (`menu_id`) USING BTREE,
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('2', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('3', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('2', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('2', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('2', '6');
INSERT INTO `sys_role_menu` VALUES ('3', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('2', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('3', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('3', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('3', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('2', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('2', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('2', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('2', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('2', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '16');
INSERT INTO `sys_role_menu` VALUES ('2', '16');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('2', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('2', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('2', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('2', '20');
INSERT INTO `sys_role_menu` VALUES ('1', '26');
INSERT INTO `sys_role_menu` VALUES ('1', '27');
INSERT INTO `sys_role_menu` VALUES ('1', '28');
INSERT INTO `sys_role_menu` VALUES ('1', '136');
INSERT INTO `sys_role_menu` VALUES ('3', '136');
INSERT INTO `sys_role_menu` VALUES ('1', '137');
INSERT INTO `sys_role_menu` VALUES ('3', '137');
INSERT INTO `sys_role_menu` VALUES ('1', '138');
INSERT INTO `sys_role_menu` VALUES ('3', '138');
INSERT INTO `sys_role_menu` VALUES ('1', '139');
INSERT INTO `sys_role_menu` VALUES ('3', '139');
INSERT INTO `sys_role_menu` VALUES ('1', '140');
INSERT INTO `sys_role_menu` VALUES ('3', '140');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码盐',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别（1:男,2:女）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  KEY `FKb3pkx0wbo6o8i8lj0gxr37v1n` (`dept_id`) USING BTREE,
  CONSTRAINT `sys_user_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', '140b3a6f99e768a98990984091b7543eaf853e57e2bdac43e323797250d637ea', 'h6i0vW', '2', '/xibian/picture/20190522/e26e306a875a46f6897d66af697851cd.jpg', '1', '10086@163.com', '10086', '', '2018-08-09 23:00:03', '2019-05-22 17:13:38', '1');
INSERT INTO `sys_user` VALUES ('2', 'chenwt', '泡泡哥', 'f061ad891b99463f49e79b80fda22a2c2d320a248d485c6d8f188fb79be72a9b', '5f444i', '2', null, '1', '1008612@qq.com', '1008612', '', '2018-09-30 16:25:22', '2019-05-04 23:42:20', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('2', '3');
