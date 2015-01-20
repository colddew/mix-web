CREATE DATABASE IF NOT EXISTS mix DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE mix;

-- ----------------------------
-- Table structure for `metadata_table`
-- ----------------------------
DROP TABLE IF EXISTS `metadata_table`;
CREATE TABLE `metadata_table` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(50) DEFAULT NULL,
  `table_desc` varchar(100) DEFAULT NULL,
  `table_type` tinyint(4) DEFAULT NULL,
  `operator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of metadata_table
-- ----------------------------
INSERT INTO `metadata_table` VALUES ('1', 'sys_user', '用户信息表', '0', 'admin');
INSERT INTO `metadata_table` VALUES ('2', 'sys_org', '组织信息表', '1', 'test2');
INSERT INTO `metadata_table` VALUES ('3', 'sys_role', '角色信息表', '0', 'admin');
INSERT INTO `metadata_table` VALUES ('4', 'sys_res', '资源信息表', '0', 'admin');
INSERT INTO `metadata_table` VALUES ('5', 'sys_user_ref_role', '用户角色关联表', '0', 'admin');
INSERT INTO `metadata_table` VALUES ('6', 'sys_role_ref_res', '角色资源关联表', '0', 'admin');

-- ----------------------------
-- Table structure for `sys_org`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `org_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(100) DEFAULT NULL,
  `org_desc` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `priority` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', 'alibaba', '阿里集团', '0', null);
INSERT INTO `sys_org` VALUES ('2', 'taobao', '淘宝', '1', null);
INSERT INTO `sys_org` VALUES ('3', 'tmall', '天猫', '1', null);
INSERT INTO `sys_org` VALUES ('4', 'aliyun', '阿里云', '1', null);
INSERT INTO `sys_org` VALUES ('5', 'ant', '蚂蚁金服', '0', null);
INSERT INTO `sys_org` VALUES ('6', 'alipay', '支付宝', '5', null);

-- ----------------------------
-- Table structure for `sys_res`
-- ----------------------------
DROP TABLE IF EXISTS `sys_res`;
CREATE TABLE `sys_res` (
  `res_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `res_name` varchar(100) DEFAULT NULL,
  `res_desc` varchar(255) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL COMMENT '资源URL',
  `permission` varchar(255) DEFAULT NULL,
  `res_type` tinyint(4) DEFAULT NULL,
  `is_leaf` tinyint(4) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `priority` bigint(20) DEFAULT NULL,
  `parent_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_res
-- ----------------------------
INSERT INTO `sys_res` VALUES ('1', 'resource', '资源', null, null, null, '0', '0', null, '0/');
INSERT INTO `sys_res` VALUES ('11', 'organizationManage', '机构管理', '/organization/index.html', 'organization:*', '0', '0', '1', null, '0/1/');
INSERT INTO `sys_res` VALUES ('12', 'organizationAdd', '机构新增', null, 'organization:add', '1', '1', '11', null, '0/1/11/');
INSERT INTO `sys_res` VALUES ('13', 'organizationModify', '机构修改', null, 'organization:modify', '1', '1', '11', null, '0/1/11/');
INSERT INTO `sys_res` VALUES ('14', 'organizationDelete', '机构删除', null, 'organization:delete', '1', '1', '11', null, '0/1/11/');
INSERT INTO `sys_res` VALUES ('15', 'organizationQuery', '机构查看', null, 'organization:query', '1', '1', '11', null, '0/1/11/');
INSERT INTO `sys_res` VALUES ('21', 'userManage', '用户管理', '/user/index.html', 'user:*', '0', '0', '1', null, '0/1/');
INSERT INTO `sys_res` VALUES ('22', 'userAdd', '用户新增', null, 'user:add', '1', '1', '21', null, '0/1/21/');
INSERT INTO `sys_res` VALUES ('23', 'userModify', '用户修改', null, 'user:modify', '1', '1', '21', null, '0/1/21/');
INSERT INTO `sys_res` VALUES ('24', 'userDelete', '用户删除', null, 'user:delete', '1', '1', '21', null, '0/1/21/');
INSERT INTO `sys_res` VALUES ('25', 'userQuery', '用户查看', null, 'user:query', '1', '0', '21', null, '0/1/21/');
INSERT INTO `sys_res` VALUES ('31', 'roleManage', '角色管理', '/role/index.html', 'role:*', '0', '0', '1', null, '0/1/');
INSERT INTO `sys_res` VALUES ('32', 'roleAdd', '角色新增', null, 'role:add', '1', '1', '31', null, '0/1/31/');
INSERT INTO `sys_res` VALUES ('33', 'roleModify', '角色修改', null, 'role:modify', '1', '1', '31', null, '0/1/31/');
INSERT INTO `sys_res` VALUES ('34', 'roleDelete', '角色删除', null, 'role:delete', '1', '1', '31', null, '0/1/31/');
INSERT INTO `sys_res` VALUES ('35', 'roleQuery', '角色查看', null, 'role:query', '1', '1', '31', null, '0/1/31/');
INSERT INTO `sys_res` VALUES ('41', 'resourceManage', '资源管理', '/resource/index.html', 'resource:*', '0', '0', '1', null, '0/1/');
INSERT INTO `sys_res` VALUES ('42', 'resourceAdd', '资源新增', null, 'resource:add', '1', '1', '41', null, '0/1/41/');
INSERT INTO `sys_res` VALUES ('43', 'resourceModify', '资源修改', null, 'resource:modify', '1', '1', '41', null, '0/1/41/');
INSERT INTO `sys_res` VALUES ('44', 'resourceDelete', '资源删除', null, 'resource:delete', '1', '1', '41', null, '0/1/41/');
INSERT INTO `sys_res` VALUES ('45', 'resourceQuery', '资源查看', null, 'resource:query', '1', '1', '41', null, '0/1/41/');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES ('2', 'dev', '开发人员');
INSERT INTO `sys_role` VALUES ('3', 'sa', '架构师');
INSERT INTO `sys_role` VALUES ('4', 'pm', '产品经理');
INSERT INTO `sys_role` VALUES ('5', 'qa', '测试人员');
INSERT INTO `sys_role` VALUES ('8', 'outsource', '外包');
INSERT INTO `sys_role` VALUES ('10', 'test3', 'test3');

-- ----------------------------
-- Table structure for `sys_role_ref_res`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_ref_res`;
CREATE TABLE `sys_role_ref_res` (
  `ref_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `res_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ref_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_ref_res
-- ----------------------------
INSERT INTO `sys_role_ref_res` VALUES ('30', '2', '31');
INSERT INTO `sys_role_ref_res` VALUES ('31', '2', '41');
INSERT INTO `sys_role_ref_res` VALUES ('41', '8', '15');
INSERT INTO `sys_role_ref_res` VALUES ('42', '8', '25');
INSERT INTO `sys_role_ref_res` VALUES ('43', '8', '35');
INSERT INTO `sys_role_ref_res` VALUES ('44', '8', '45');
INSERT INTO `sys_role_ref_res` VALUES ('50', '1', '11');
INSERT INTO `sys_role_ref_res` VALUES ('51', '1', '21');
INSERT INTO `sys_role_ref_res` VALUES ('52', '1', '31');
INSERT INTO `sys_role_ref_res` VALUES ('53', '1', '41');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `user_type` tinyint(4) DEFAULT NULL,
  `user_status` tinyint(4) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '8d78869f470951332959580424d4bf4f', 'd3c59d25033dbf980d29554025c23a75', '0', '1', '1');
INSERT INTO `sys_user` VALUES ('2', 'test', 'c25135abc22a22bb18675cf8d6c0088c', 'b0f5b6952cc0276fe4b4aab8a8f5827b', '1', '2', '3');
INSERT INTO `sys_user` VALUES ('3', 'hacker', 'c25135abc22a22bb18675cf8d6c0088c', 'b0f5b6952cc0276fe4b4aab8a8f5827b', '1', '2', '4');
INSERT INTO `sys_user` VALUES ('4', 'colddew', 'c25135abc22a22bb18675cf8d6c0088c', 'b0f5b6952cc0276fe4b4aab8a8f5827b', '0', '1', '1');
INSERT INTO `sys_user` VALUES ('5', 'rainbow', 'c25135abc22a22bb18675cf8d6c0088c', 'b0f5b6952cc0276fe4b4aab8a8f5827b', '1', '0', '5');
INSERT INTO `sys_user` VALUES ('7', 'test2', '66717aeadc6295d458e238efb9b6367f', 'd257b8f0368630b3d94a5e489ed506c6', '1', '1', '2');

-- ----------------------------
-- Records of sys_user_ref_res
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_ref_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_ref_role`;
CREATE TABLE `sys_user_ref_role` (
  `ref_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ref_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_ref_role
-- ----------------------------
INSERT INTO `sys_user_ref_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_ref_role` VALUES ('11', '3', '3');
INSERT INTO `sys_user_ref_role` VALUES ('19', '4', '1');
INSERT INTO `sys_user_ref_role` VALUES ('20', '4', '3');
INSERT INTO `sys_user_ref_role` VALUES ('23', '5', '2');
INSERT INTO `sys_user_ref_role` VALUES ('24', '5', '8');
INSERT INTO `sys_user_ref_role` VALUES ('26', '2', '5');
INSERT INTO `sys_user_ref_role` VALUES ('27', '2', '8');