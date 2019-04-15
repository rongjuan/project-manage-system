# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: pms
# Generation Time: 2019-04-15 11:38:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table commodity
# ------------------------------------------------------------

DROP TABLE IF EXISTS `commodity`;

CREATE TABLE `commodity` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `fee_id` varchar(36) NOT NULL DEFAULT '' COMMENT '费用类型',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '名称',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) DEFAULT '' COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '编辑人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `UK_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;

INSERT INTO `commodity` (`id`, `fee_id`, `name`, `is_delete`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('9839a6d0-a487-4aa7-9fd4-0da7f0b05d91','31279a01-f54e-4135-95cf-eaf998f8d7f7','tt',0,'tt','1','1','2019-04-08 11:30:56','2019-04-08 11:30:56'),
	('d974f66d-f152-422c-9dac-8c07c66027c4','8cdf1692-652a-40ee-9aca-f22f1e77e588','Test123',1,'test','1','1','2019-04-05 00:19:59','2019-04-08 11:32:04');

/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table fee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fee`;

CREATE TABLE `fee` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `pid` varchar(36) NOT NULL DEFAULT '0' COMMENT '父主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '名称',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '编辑人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `fee` WRITE;
/*!40000 ALTER TABLE `fee` DISABLE KEYS */;

INSERT INTO `fee` (`id`, `pid`, `name`, `is_delete`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('1','0','aa',1,'aa','1','1','2019-04-04 14:47:16','2019-04-04 15:39:17'),
	('31279a01-f54e-4135-95cf-eaf998f8d7f7','0','ttt133333',0,'ttt1333','1','1','2019-04-08 08:53:44','2019-04-09 10:40:35'),
	('49150a01-1f53-4e11-ac57-3abee2d316bd','0','test update',0,'test remark','1','1','2019-04-04 14:42:32','2019-04-04 14:43:42'),
	('635c49b1-9873-4644-8e91-88a4ee1f4823','0','test111',0,'test remark','1','1','2019-04-04 15:39:07','2019-04-04 15:39:07'),
	('66554c35-3df3-4716-9b00-3fa3ac978235','0','qqq222',1,'qqq333','1','1','2019-04-07 22:19:58','2019-04-08 09:24:29'),
	('8cdf1692-652a-40ee-9aca-f22f1e77e588','0','hhh33',0,'hhh33','1','1','2019-04-08 09:24:44','2019-04-08 09:25:13'),
	('c1580ec0-d1a4-40ec-a75b-857f32f010ea','0','肉肉肉',1,'肉肉肉','1','1','2019-04-09 10:40:47','2019-04-09 10:40:49'),
	('ef9fb055-6f2c-42d1-8121-39249f8ac02b','0','tttwww',1,'tttwww','1','1','2019-04-07 22:19:25','2019-04-08 09:23:40');

/*!40000 ALTER TABLE `fee` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table project
# ------------------------------------------------------------

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `user_id` varchar(36) DEFAULT '' COMMENT '项目经理',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '名称',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0=初始化；1=启动；2=暂停；3=停止',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '编辑人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `UK_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;

INSERT INTO `project` (`id`, `user_id`, `name`, `address`, `status`, `is_delete`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('cc12ea01-5617-46b0-a32c-7fb550b0c2e0','2','tt','tt',0,0,'tt','1','1','2019-04-08 13:25:31','2019-04-08 13:26:10'),
	('ce0d3764-c257-4861-ac0e-74ce9584d380','1','ggsss','ff',0,1,'ff','1','1','2019-04-09 11:24:49','2019-04-09 11:24:55'),
	('fe95dff4-9404-40b8-8f27-9c12ddb42600','1','盖大楼','China',1,0,'test','1','1','2019-04-04 17:04:32','2019-04-04 17:06:18');

/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table purchase_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `purchase_order`;

CREATE TABLE `purchase_order` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `purchase_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '采购日期',
  `supplier_id` varchar(36) DEFAULT NULL COMMENT '供应商主键',
  `commodity_id` varchar(36) DEFAULT NULL COMMENT '商品主键',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目主键',
  `specification` varchar(200) DEFAULT '' COMMENT '商品规格',
  `unit` varchar(10) DEFAULT '' COMMENT '单位名称',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单价',
  `amount` decimal(12,2) NOT NULL DEFAULT '0.00' COMMENT '合计金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '编辑人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;

INSERT INTO `purchase_order` (`id`, `purchase_date`, `supplier_id`, `commodity_id`, `project_id`, `specification`, `unit`, `quantity`, `price`, `amount`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('77938949-954e-45eb-a29d-b7a50cce01f4','2019-04-18 16:00:00','677d5e28-ec50-4a90-81f0-db4fab0066e9','9839a6d0-a487-4aa7-9fd4-0da7f0b05d91','cc12ea01-5617-46b0-a32c-7fb550b0c2e0','1','1',4,12.15,48.60,'111','1','1','2019-04-09 14:43:31','2019-04-09 16:15:00');

/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table supplier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '名称',
  `bank_name` varchar(100) DEFAULT '' COMMENT '开户行',
  `bank_account` varchar(45) DEFAULT '' COMMENT '开户行卡号',
  `contact` varchar(20) DEFAULT '' COMMENT '联系人',
  `contact_phone` varchar(20) DEFAULT '' COMMENT '联系电话',
  `address` varchar(200) DEFAULT '' COMMENT '联系地址',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(36) NOT NULL DEFAULT '' COMMENT '创建人',
  `modify_user` varchar(36) NOT NULL DEFAULT '' COMMENT '编辑人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`),
  KEY `UK_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;

INSERT INTO `supplier` (`id`, `name`, `bank_name`, `bank_account`, `contact`, `contact_phone`, `address`, `is_delete`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('0bac9db4-34de-4ea3-991d-83c78bde49b9','反反复复1','反反复复1','反反复复','反反复复','反反复复','反反复复',1,'反反复复','1','1','2019-04-08 11:19:47','2019-04-08 11:19:54'),
	('1','w','w','w','w','w','w',1,'w','1','1','2019-04-04 15:47:04','2019-04-04 15:47:13'),
	('677d5e28-ec50-4a90-81f0-db4fab0066e9','test','发达发饿为为为为是的的的发发发发是是是是','231332132132123122222','俄通社','123333212233','热饭吃的是非得失范德萨翻炒撒的范德萨范德萨撒',0,' 范德萨范德萨发送fa s','1','1','2019-04-08 10:26:00','2019-04-08 10:27:54'),
	('85e403a4-ce9f-4f02-aa6a-3c137481ec65','trsdy','发达发饿为为为为是的的的发发发发是是是是','231332132132123122222','俄通社','123333212233','热饭吃的是非得失范德萨翻炒撒的范德萨范德萨撒',1,' 范德萨范德萨发送fa s','1','1','2019-04-08 10:26:00','2019-04-08 10:26:07'),
	('f2527bf8-9f3d-46d7-bf7c-b45506fb8e32','1ttt','1ttt','1ttt','t1','t1','t',1,'t','1','1','2019-04-09 11:10:56','2019-04-09 11:11:06'),
	('fa61019e-81c1-401f-95b3-358f994b7762','supplier122','bank ICBC','20193939292','笑哈哈','17273738281','China',0,'test','1','1','2019-04-04 15:43:43','2019-04-04 15:45:20');

/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(25) NOT NULL DEFAULT '' COMMENT '姓名',
  `account` varchar(45) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(36) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(25) NOT NULL DEFAULT '' COMMENT '电话',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用；',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_user` varchar(36) DEFAULT NULL COMMENT '创建人',
  `modify_user` varchar(36) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ACCOUNT` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `name`, `account`, `password`, `phone`, `status`, `is_delete`, `remark`, `create_user`, `modify_user`, `create_time`, `modify_time`)
VALUES
	('1','超级管理员','admin','admin','17600891908',1,0,'超级管理员','1','1','2019-04-04 11:19:14','2019-04-04 11:19:14'),
	('2','普通用户','customer','customer','18767381221',1,0,'普通用户','1','1','2019-04-08 13:25:59','2019-04-08 13:25:59');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
