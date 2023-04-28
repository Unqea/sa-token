/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0.29
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : zb-shiro

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 28/04/2023 16:26:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parent_id` int DEFAULT NULL COMMENT '父级权限id',
  `type` int DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int DEFAULT '0' COMMENT '排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` int NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of permission
-- ----------------------------
BEGIN;
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (1, '1', '工作台', '工作台', '/workdest', 'workdest', 0, 1, 1, 'fa fa-home', 1, '2017-09-27 21:22:02', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (2, '2', '权限管理', '权限管理', '', NULL, 0, 0, 2, 'fa fa-th-list', 1, '2017-07-13 15:04:42', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (3, '201', '用户管理', '用户管理', '/users', 'users', 2, 1, 1, 'fa fa-circle-o', 1, '2017-07-13 15:05:47', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (4, '20101', '列表查询', '用户列表查询', '/user/list', 'user:list', 3, 2, 0, NULL, 1, '2017-07-13 15:09:24', '2017-10-09 05:38:29');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (5, '20102', '新增', '新增用户', '/user/add', 'user:add', 3, 2, 0, NULL, 1, '2017-07-13 15:06:50', '2018-02-28 17:58:46');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (6, '20103', '编辑', '编辑用户', '/user/edit', 'user:edit', 3, 2, 0, NULL, 1, '2017-07-13 15:08:03', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (7, '20104', '删除', '删除用户', '/user/delete', 'user:delete', 3, 2, 0, NULL, 1, '2017-07-13 15:08:42', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (8, '20105', '批量删除', '批量删除用户', '/user/batch/delete', 'user:batchDelete', 3, 2, 0, '', 1, '2018-07-11 01:53:09', '2018-07-11 01:53:09');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (9, '20106', '分配角色', '分配角色', '/user/assign/role', 'user:assignRole', 3, 2, 0, NULL, 1, '2017-07-13 15:09:24', '2017-10-09 05:38:29');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (10, '202', '角色管理', '角色管理', '/roles', 'roles', 2, 1, 2, 'fa fa-circle-o', 1, '2017-07-17 14:39:09', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (11, '20201', '列表查询', '角色列表查询', '/role/list', 'role:list', 10, 2, 0, NULL, 1, '2017-10-10 15:31:36', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (12, '20202', '新增', '新增角色', '/role/add', 'role:add', 10, 2, 0, NULL, 1, '2017-07-17 14:39:46', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (13, '20203', '编辑', '编辑角色', '/role/edit', 'role:edit', 10, 2, 0, NULL, 1, '2017-07-17 14:40:15', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (14, '20204', '删除', '删除角色', '/role/delete', 'role:delete', 10, 2, 0, NULL, 1, '2017-07-17 14:40:57', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (15, '20205', '批量删除', '批量删除角色', '/role/batch/delete', 'role:batchDelete', 10, 2, 0, '', 1, '2018-07-10 22:20:43', '2018-07-10 22:20:43');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (16, '20206', '分配权限', '分配权限', '/role/assign/permission', 'role:assignPerms', 10, 2, 0, NULL, 1, '2017-09-26 07:33:05', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (17, '203', '资源管理', '资源管理', '/permissions', 'permissions', 2, 1, 3, 'fa fa-circle-o', 1, '2017-09-26 07:33:51', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (18, '20301', '列表查询', '资源列表', '/permission/list', 'permission:list', 17, 2, 0, NULL, 1, '2018-07-12 16:25:28', '2018-07-12 16:25:33');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (19, '20302', '新增', '新增资源', '/permission/add', 'permission:add', 17, 2, 0, NULL, 1, '2017-09-26 08:06:58', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (20, '20303', '编辑', '编辑资源', '/permission/edit', 'permission:edit', 17, 2, 0, NULL, 1, '2017-09-27 21:29:04', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (21, '20304', '删除', '删除资源', '/permission/delete', 'permission:delete', 17, 2, 0, NULL, 1, '2017-09-27 21:29:50', '2018-02-27 10:53:14');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (22, '3', '运维管理', '运维管理', '', NULL, 0, 0, 3, 'fa fa-th-list', 1, '2018-07-06 15:19:26', '2018-07-06 15:19:26');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (23, '301', '数据监控', '数据监控', '/database/monitoring', 'database', 22, 1, 1, 'fa fa-circle-o', 1, '2018-07-06 15:19:55', '2018-09-12 13:14:48');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (24, '4', '系统工具', '系统工具', '', NULL, 0, 0, 4, 'fa fa-th-list', 1, '2018-07-06 15:20:38', '2018-07-06 15:20:38');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (25, '401', '图标工具', '图标工具', '/icons', 'icons', 24, 1, 1, 'fa fa-circle-o', 1, '2018-07-06 15:21:00', '2018-07-06 15:21:00');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (28, '1000000884924014', '在线用户', '在线用户', '/online/users', 'onlineUsers', 2, 1, 4, 'fa fa-circle-o', 1, '2018-07-18 21:00:38', '2018-07-19 12:47:42');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (29, '1000000433323073', '在线用户查询', '在线用户查询', '/online/user/list', 'onlineUser:list', 28, 2, 0, NULL, 1, '2018-07-18 21:01:25', '2018-07-19 12:48:04');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (30, '1000000903407910', '踢出用户', '踢出用户', '/online/user/kickout', 'onlineUser:kickout', 28, 2, 0, NULL, 1, '2018-07-18 21:41:54', '2018-07-19 12:48:25');
INSERT INTO `permission` (`id`, `permission_id`, `name`, `description`, `url`, `perms`, `parent_id`, `type`, `order_num`, `icon`, `status`, `create_time`, `update_time`) VALUES (31, '1000000851815490', '批量踢出', '批量踢出', '/online/user/batch/kickout', 'onlineUser:batchKickout', 28, 2, 0, '', 1, '2018-07-19 12:49:30', '2018-07-19 12:49:30');
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` (`id`, `role_id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES (1, '1', 'admin', '超级管理员', 1, '2017-06-28 20:30:05', '2017-06-28 20:30:10');
INSERT INTO `role` (`id`, `role_id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES (2, '2', '管理员', '管理员', 1, '2017-06-30 23:35:19', '2017-10-11 09:32:33');
INSERT INTO `role` (`id`, `role_id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES (3, '3', '普通用户', '普通用户', 1, '2017-06-30 23:35:44', '2018-07-13 11:44:06');
INSERT INTO `role` (`id`, `role_id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES (4, '4', '数据库管理员', '数据库管理员', 1, '2017-07-12 11:50:22', '2017-10-09 17:38:02');
COMMIT;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=892 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (840, '1', '1');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (841, '1', '2');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (842, '1', '201');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (843, '1', '20101');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (844, '1', '20102');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (845, '1', '20103');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (846, '1', '20104');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (847, '1', '20105');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (848, '1', '20106');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (849, '1', '202');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (850, '1', '20201');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (851, '1', '20202');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (852, '1', '20203');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (853, '1', '20204');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (854, '1', '20205');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (855, '1', '20206');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (856, '1', '203');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (857, '1', '20301');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (858, '1', '20302');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (859, '1', '20303');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (860, '1', '20304');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (861, '1', '1000000884924014');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (862, '1', '1000000433323073');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (863, '1', '1000000903407910');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (864, '1', '1000000851815490');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (865, '1', '3');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (866, '1', '301');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (867, '1', '4');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (868, '1', '401');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (877, '3', '2');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (878, '3', '201');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (879, '3', '20101');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (880, '3', '20102');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (881, '3', '20103');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (882, '3', '20104');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (883, '3', '20105');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (884, '3', '20106');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (885, '3', '202');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (886, '3', '20201');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (887, '3', '20202');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (888, '3', '20203');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (889, '3', '20204');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (890, '3', '20205');
INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES (891, '3', '20206');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL,
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `sex` int DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int DEFAULT NULL COMMENT '年龄',
  `status` int NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `user_id`, `username`, `password`, `salt`, `email`, `phone`, `sex`, `age`, `status`, `create_time`, `update_time`, `last_login_time`) VALUES (1, '1', 'admin', '123456', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2023-01-09 14:58:02');
INSERT INTO `user` (`id`, `user_id`, `username`, `password`, `salt`, `email`, `phone`, `sex`, `age`, `status`, `create_time`, `update_time`, `last_login_time`) VALUES (2, '2', 'zhangsan', '123456', 'dfesdfdsfefxfsdfdsfdsew3dsg4sg4eegsgdsg', '787777777@qq.com', '18723587653', 1, 22, 1, '2023-01-13 18:16:15', '2023-01-13 18:16:18', '2023-01-13 18:16:20');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (1, '1', '1');
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES (2, '2', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
