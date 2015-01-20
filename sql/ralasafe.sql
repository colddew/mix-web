CREATE DATABASE IF NOT EXISTS ralasafe DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE ralasafe;

-- ----------------------------
-- Table structure for `application`
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('ralasafe', 'ralasafe application');

-- ----------------------------
-- Table structure for `applicationusertype`
-- ----------------------------
DROP TABLE IF EXISTS `applicationusertype`;
CREATE TABLE `applicationusertype` (
  `appName` varchar(100) NOT NULL,
  `userTypeName` varchar(100) NOT NULL,
  `userMetadataStr` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`appName`,`userTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicationusertype
-- ----------------------------
INSERT INTO `applicationusertype` VALUES ('ralasafe', 'ralasafe', 'user_id user_name salt password user_type user_status org_id ');

-- ----------------------------
-- Table structure for `ralasafe_businessdata`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_businessdata`;
CREATE TABLE `ralasafe_businessdata` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `installDate` date DEFAULT NULL,
  `fileName` varchar(40) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `isLeaf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_businessdata
-- ----------------------------

-- ----------------------------
-- Table structure for `ralasafe_decision_entitlement`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_decision_entitlement`;
CREATE TABLE `ralasafe_decision_entitlement` (
  `id` int(11) NOT NULL,
  `privilegeId` int(11) DEFAULT NULL,
  `userCategoryId` int(11) DEFAULT NULL,
  `businessDataId` int(11) DEFAULT NULL,
  `effect` varchar(100) DEFAULT NULL,
  `denyReason` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_decision_entitlement
-- ----------------------------

-- ----------------------------
-- Table structure for `ralasafe_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_privilege`;
CREATE TABLE `ralasafe_privilege` (
  `id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `isLeaf` int(11) DEFAULT NULL,
  `display` int(11) DEFAULT NULL,
  `decisionPolicyCombAlg` int(11) DEFAULT NULL,
  `queryPolicyCombAlg` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `constantName` varchar(40) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `target` varchar(20) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_privilege
-- ----------------------------
INSERT INTO `ralasafe_privilege` VALUES ('-6', '-3', '', '角色管理', '1', '1', '0', '0', '0', 'ROLE_ADMIN', '', '_self', '3');
INSERT INTO `ralasafe_privilege` VALUES ('-5', '-3', '', '给用户分配角色', '1', '1', '0', '0', '0', 'ASSIGN_ROLE_TO_USER', '', '_self', '2');
INSERT INTO `ralasafe_privilege` VALUES ('-4', '-3', '制定授权策略、定义用户分类、业务数据分类和数据查询', '策略管理', '1', '1', '0', '0', '0', 'POLICY_ADMIN', '', '_self', '1');
INSERT INTO `ralasafe_privilege` VALUES ('-3', '0', '', 'Ralasafe 管理', '0', '1', '0', '0', '0', '', '', '_self', '0');
INSERT INTO `ralasafe_privilege` VALUES ('1', '-1', '', '查询自己创建的数据库表记录', '1', '1', '0', '0', '1', 'QUERY_METADATA_TABLE', '', '_self', '0');

-- ----------------------------
-- Table structure for `ralasafe_query`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_query`;
CREATE TABLE `ralasafe_query` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `installDate` date DEFAULT NULL,
  `fileName` varchar(40) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `isLeaf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_query
-- ----------------------------
INSERT INTO `ralasafe_query` VALUES ('-10', 'current user\'s roles', 'Get current user\'s roles', '2015-01-20', '-10_ralasafe.xml', '0', '1');
INSERT INTO `ralasafe_query` VALUES ('1', '查询数据库表', '', '2015-01-20', null, '0', '0');
INSERT INTO `ralasafe_query` VALUES ('2', '查询自己创建的数据库表记录', '', '2015-01-20', '2_ralasafe.xml', '1', '1');

-- ----------------------------
-- Table structure for `ralasafe_query_entitlement`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_query_entitlement`;
CREATE TABLE `ralasafe_query_entitlement` (
  `id` int(11) NOT NULL,
  `privilegeId` int(11) DEFAULT NULL,
  `userCategoryId` int(11) DEFAULT NULL,
  `queryId` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_query_entitlement
-- ----------------------------
INSERT INTO `ralasafe_query_entitlement` VALUES ('2', '1', '2', '2', '');

-- ----------------------------
-- Table structure for `ralasafe_ralasafe_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_ralasafe_userrole`;
CREATE TABLE `ralasafe_ralasafe_userrole` (
  `userid` bigint(20) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`,`roleid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `ralasafe_ralasafe_userrole_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `ralasafe_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_ralasafe_userrole
-- ----------------------------

-- ----------------------------
-- Table structure for `ralasafe_role`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_role`;
CREATE TABLE `ralasafe_role` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_role
-- ----------------------------
INSERT INTO `ralasafe_role` VALUES ('-1', 'Ralasafe 管理员', null);

-- ----------------------------
-- Table structure for `ralasafe_roleprivilege`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_roleprivilege`;
CREATE TABLE `ralasafe_roleprivilege` (
  `roleid` int(11) NOT NULL,
  `privilegeid` int(11) NOT NULL,
  PRIMARY KEY (`roleid`,`privilegeid`),
  KEY `privilegeid` (`privilegeid`),
  CONSTRAINT `ralasafe_roleprivilege_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `ralasafe_role` (`id`),
  CONSTRAINT `ralasafe_roleprivilege_ibfk_2` FOREIGN KEY (`privilegeid`) REFERENCES `ralasafe_privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_roleprivilege
-- ----------------------------
INSERT INTO `ralasafe_roleprivilege` VALUES ('-1', '-6');
INSERT INTO `ralasafe_roleprivilege` VALUES ('-1', '-5');
INSERT INTO `ralasafe_roleprivilege` VALUES ('-1', '-4');

-- ----------------------------
-- Table structure for `ralasafe_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_sequence`;
CREATE TABLE `ralasafe_sequence` (
  `currentValue` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_sequence
-- ----------------------------
INSERT INTO `ralasafe_sequence` VALUES ('1', 'ralasafe_privilege_id');
INSERT INTO `ralasafe_sequence` VALUES ('2', 'ralasafe_query_entitlement_id');
INSERT INTO `ralasafe_sequence` VALUES ('2', 'ralasafe_query_id');
INSERT INTO `ralasafe_sequence` VALUES ('2', 'ralasafe_usercategory_id');

-- ----------------------------
-- Table structure for `ralasafe_usercategory`
-- ----------------------------
DROP TABLE IF EXISTS `ralasafe_usercategory`;
CREATE TABLE `ralasafe_usercategory` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `installDate` date DEFAULT NULL,
  `fileName` varchar(40) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `isLeaf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ralasafe_usercategory
-- ----------------------------
INSERT INTO `ralasafe_usercategory` VALUES ('-10', '角色', '', '2015-01-20', null, '0', '0');
INSERT INTO `ralasafe_usercategory` VALUES ('1', 'Ralasafe 管理员', null, '2015-01-20', '1_ralasafe.xml', '-10', '1');
INSERT INTO `ralasafe_usercategory` VALUES ('2', '所有人', '', '2015-01-20', '2_ralasafe.xml', '0', '1');

-- ----------------------------
-- Table structure for `usertype`
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `name` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `userMetadataXML` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES ('ralasafe', 'init', '<?xml version=\"1.0\"?>\r\n<user>\r\n    <table ds=\"app\" name=\"mainTable\" sqlName=\"sys_user\" uniqueFields=\"name\">\r\n		<field name=\"id\" columnName=\"user_id\" sqlType=\"bigint\" javaType=\"java.lang.Long\" />\r\n		<field name=\"name\" columnName=\"user_name\" sqlType=\"varchar(255)\" javaType=\"java.lang.String\" displayName=\"Name\" show=\"true\" />\r\n		<field name=\"salt\" columnName=\"salt\" sqlType=\"varchar(50)\" javaType=\"java.lang.String\" />\r\n		<field name=\"password\" columnName=\"password\" sqlType=\"varchar(100)\" javaType=\"java.lang.String\" />\r\n		<field name=\"userType\" columnName=\"user_type\" sqlType=\"tinyint\" javaType=\"java.lang.Integer\" />\r\n		<field name=\"userStatus\" columnName=\"user_status\" sqlType=\"tinyint\" javaType=\"java.lang.Integer\" />\r\n		<field name=\"orgId\" columnName=\"org_id\" sqlType=\"bigint\" javaType=\"java.lang.Long\" displayName=\"OrgId\" show=\"true\" />\r\n	</table>\r\n</user>');
