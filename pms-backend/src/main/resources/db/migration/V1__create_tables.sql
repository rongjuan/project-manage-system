DROP TABLE IF EXISTS `license`;
CREATE TABLE `license` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '公司名称',
  `expire_date` date NOT NULL COMMENT '过期时间',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `license` WRITE;
INSERT INTO `license` (`id`, `company`, `expire_date`, `remark`)
VALUES
	('1','超级管理员','2099-12-31','超级管理员');
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `license_id` varchar(36) NOT NULL DEFAULT '' COMMENT '许可证主键',
  `account` varchar(45) NOT NULL DEFAULT '' COMMENT '账号',
  `secret` varchar(36) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(25) NOT NULL COMMENT '姓名',
  `phone` varchar(25) NOT NULL COMMENT '电话',
  `email` varchar(200) NOT NULL DEFAULT '' COMMENT '邮箱',
  `photo` varchar(200) NOT NULL DEFAULT '' COMMENT '电话',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用；',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ACCOUNT` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
INSERT INTO `user` (`id`, `license_id`, `account`, `secret`, `name`, `phone`, `email`, `photo`, `status`, `deleted`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('1','1','admin','e7c4eba026edbda38b166446461d447e','薛鹏','17600891908','100103081@qq.com','http://thumb10.jfcdns.com/2018-06/bce5b10ae530f530.png',1,0,'超级管理员','1','1','2019-04-04 11:19:14','2019-06-12 10:14:04');
UNLOCK TABLES;

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `pid` varchar(36) NOT NULL DEFAULT '0' COMMENT '父级主键',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '标题',
  `icon` varchar(200) NOT NULL DEFAULT '' COMMENT '图标',
  `path` varchar(200) NOT NULL DEFAULT '' COMMENT '路径',
  `sort` smallint(6) NOT NULL DEFAULT '0' COMMENT '排序',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `menu` WRITE;
INSERT INTO `menu` (`id`, `pid`, `title`, `icon`, `path`, `sort`, `deleted`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('1','0','系统管理','config','/',1,0,'','1','1','2019-05-27 17:21:01','2019-06-03 19:03:40'),
	('2','1','菜单管理','tree-table','/system/menu',1,0,'菜单管理','1','1','2019-05-27 17:21:37','2019-06-04 11:26:11'),
	('3','1','用户管理','user','/system/user',2,0,'用户管理','1','1','2019-05-27 17:21:17','2019-06-04 10:35:12'),
	('4','1','角色管理','peoples','/system/role',3,0,'角色管理','1','1','2019-05-27 17:21:45','2019-06-05 14:39:53');
UNLOCK TABLES;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `license_id` varchar(36) NOT NULL COMMENT '许可证主键',
  `name` varchar(25) NOT NULL DEFAULT '' COMMENT '名称',
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用；',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
INSERT INTO `role` (`id`, `license_id`, `name`, `status`, `deleted`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('1','1','超级管理员',1,0,'超级管理员','1','1','2019-05-27 16:05:29','2019-06-05 16:21:37');
UNLOCK TABLES;

DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `role_id` varchar(36) NOT NULL DEFAULT '' COMMENT '角色主键',
  `menu_id` varchar(36) NOT NULL DEFAULT '' COMMENT '菜单主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role_menu_relation` WRITE;
INSERT INTO `role_menu_relation` (`id`, `role_id`, `menu_id`)
VALUES
	('1','1','1'),
	('2','1','2'),
	('3','1','3'),
	('4','1','4');
UNLOCK TABLES;

DROP TABLE IF EXISTS `role_user_relation`;
CREATE TABLE `role_user_relation` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `role_id` varchar(36) NOT NULL DEFAULT '' COMMENT '角色主键',
  `user_id` varchar(36) NOT NULL DEFAULT '' COMMENT '用户主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role_user_relation` WRITE;
INSERT INTO `role_user_relation` (`id`, `role_id`, `user_id`)
VALUES
	('1','1','1');
UNLOCK TABLES;