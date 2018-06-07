CREATE DATABASE  IF NOT EXISTS `guns` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `guns`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 118.31.10.18    Database: guns
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_cdcontent`
--

DROP TABLE IF EXISTS `sys_cdcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_cdcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `limit_time` varchar(30) DEFAULT NULL COMMENT '额度',
  `detail` varchar(60) DEFAULT NULL COMMENT '详情',
  `title` varchar(20) NOT NULL COMMENT '信用卡名称',
  `url` varchar(50) DEFAULT NULL COMMENT '图片URL',
  `show_order` int(11) DEFAULT NULL COMMENT '展示顺序',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `tourl` varchar(50) DEFAULT NULL COMMENT '跳转URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='信用卡';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_cdcontent`
--

LOCK TABLES `sys_cdcontent` WRITE;
/*!40000 ALTER TABLE `sys_cdcontent` DISABLE KEYS */;
INSERT INTO `sys_cdcontent` VALUES (5,'50-5000','缓存测试2222','工商信用卡','52d31317-d9bf-41b3-b549-5220d41e0642.jpg',1,1,'2018-05-21 15:22:37','http://www.baidu.com'),(6,'60-6000','hello world!','test信用卡','906942c9-9e34-4342-a060-d50919f395be.jpg',2,1,'2018-05-22 14:34:19','#'),(7,'1-100','我就想试试这个最多支持多少字数啊啊啊啊啊啊，厉害了！！！','南京银行信用卡','f4a6815e-1fea-48ea-befc-bf189f1b0e89.jpg',1,2,'2018-05-26 07:27:24','http://www.baidu.com');
/*!40000 ALTER TABLE `sys_cdcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_cdcontent_click`
--

DROP TABLE IF EXISTS `sys_cdcontent_click`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_cdcontent_click` (
  `cdid` int(11) DEFAULT NULL,
  `click` int(11) DEFAULT NULL,
  `lastclick` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `sys_cdcontent_click_sys_cdcontent_id_fk` (`cdid`),
  CONSTRAINT `sys_cdcontent_click_sys_cdcontent_id_fk` FOREIGN KEY (`cdid`) REFERENCES `sys_cdcontent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_cdcontent_click`
--

LOCK TABLES `sys_cdcontent_click` WRITE;
/*!40000 ALTER TABLE `sys_cdcontent_click` DISABLE KEYS */;
INSERT INTO `sys_cdcontent_click` VALUES (5,10,'2018-05-26 20:05:47'),(6,2,'2018-05-24 23:32:20'),(7,1,'2018-05-26 15:31:52');
/*!40000 ALTER TABLE `sys_cdcontent_click` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (29,0,0,'性别',NULL),(30,1,29,'男',NULL),(31,2,29,'女',NULL),(35,0,0,'账号状态',NULL),(36,1,35,'启用',NULL),(37,2,35,'冻结',NULL),(38,3,35,'已删除',NULL),(42,0,0,'图片类型',NULL),(43,1,42,'货代',NULL),(44,2,42,'信用卡',NULL),(48,0,0,'图片状态',NULL),(49,2,48,'关闭',NULL),(50,1,48,'开启',NULL),(55,0,0,'货代类型',NULL),(56,1,55,'最新入驻平台',NULL),(57,2,55,'平台力荐',NULL),(58,3,55,'下款最快',NULL),(59,0,0,'信用卡类型',NULL),(60,1,59,'点击最多',NULL),(61,2,59,'发款最快',NULL),(62,3,59,'最新发布',NULL);
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_expense`
--

DROP TABLE IF EXISTS `sys_expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` decimal(20,2) DEFAULT NULL COMMENT '报销金额',
  `desc` varchar(255) DEFAULT '' COMMENT '描述',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT NULL COMMENT '状态: 1.待提交  2:待审核   3.审核通过 4:驳回',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `processId` varchar(255) DEFAULT NULL COMMENT '流程定义id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报销表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_expense`
--

LOCK TABLES `sys_expense` WRITE;
/*!40000 ALTER TABLE `sys_expense` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_expense` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_hdcontent`
--

DROP TABLE IF EXISTS `sys_hdcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_hdcontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deadline` varchar(30) DEFAULT NULL,
  `detail` varchar(30) DEFAULT NULL,
  `limit_time` varchar(30) DEFAULT NULL,
  `rate` varchar(20) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `show_order` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_hdcontent`
--

LOCK TABLES `sys_hdcontent` WRITE;
/*!40000 ALTER TABLE `sys_hdcontent` DISABLE KEYS */;
INSERT INTO `sys_hdcontent` VALUES (6,'1-12月','个人小额贷款','50-5000','0.01%/日','平安贷款','http://www.baidu.com',1,1,'2018-05-26 06:26:35'),(7,'1-12月','个人小额贷款','50-6000','0.01%/日','蚂蚁花呗','#',2,1,'2018-05-26 06:26:35'),(8,'2-10个月','大额个人贷款','1万-5万','0.02%/日','蚂蚁借呗','#',3,1,'2018-05-26 06:26:35'),(9,'6-10天','个人小额贷款','1000-1万','0.05%/日','测试啊','#',1,2,'2018-05-26 06:26:35');
/*!40000 ALTER TABLE `sys_hdcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_hdcontent_click`
--

DROP TABLE IF EXISTS `sys_hdcontent_click`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_hdcontent_click` (
  `hdid` int(11) NOT NULL,
  `click` int(11) NOT NULL DEFAULT '0',
  `lastclick` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `sys_hdcontent_click_sys_hdcontent_id_fk` (`hdid`),
  CONSTRAINT `sys_hdcontent_click_sys_hdcontent_id_fk` FOREIGN KEY (`hdid`) REFERENCES `sys_hdcontent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_hdcontent_click`
--

LOCK TABLES `sys_hdcontent_click` WRITE;
/*!40000 ALTER TABLE `sys_hdcontent_click` DISABLE KEYS */;
INSERT INTO `sys_hdcontent_click` VALUES (6,12,'2018-05-25 08:56:39'),(7,4,'2018-05-25 01:33:52'),(8,1,'2018-05-24 13:32:26'),(9,2,'2018-05-24 21:12:59');
/*!40000 ALTER TABLE `sys_hdcontent_click` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_login_log`
--

DROP TABLE IF EXISTS `sys_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_log`
--

LOCK TABLES `sys_login_log` WRITE;
/*!40000 ALTER TABLE `sys_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=998570078133981192 DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (105,'system','0','[0],','系统管理','fa-user','#',4,1,1,NULL,1,1),(106,'mgr','system','[0],[system],','用户管理','','/mgr',1,2,1,NULL,1,0),(107,'mgr_add','mgr','[0],[system],[mgr],','添加用户',NULL,'/mgr/add',1,3,0,NULL,1,0),(108,'mgr_edit','mgr','[0],[system],[mgr],','修改用户',NULL,'/mgr/edit',2,3,0,NULL,1,0),(109,'mgr_delete','mgr','[0],[system],[mgr],','删除用户',NULL,'/mgr/delete',3,3,0,NULL,1,0),(110,'mgr_reset','mgr','[0],[system],[mgr],','重置密码',NULL,'/mgr/reset',4,3,0,NULL,1,0),(111,'mgr_freeze','mgr','[0],[system],[mgr],','冻结用户',NULL,'/mgr/freeze',5,3,0,NULL,1,0),(112,'mgr_unfreeze','mgr','[0],[system],[mgr],','解除冻结用户',NULL,'/mgr/unfreeze',6,3,0,NULL,1,0),(113,'mgr_setRole','mgr','[0],[system],[mgr],','分配角色',NULL,'/mgr/setRole',7,3,0,NULL,1,0),(114,'role','system','[0],[system],','角色管理',NULL,'/role',2,2,1,NULL,1,0),(115,'role_add','role','[0],[system],[role],','添加角色',NULL,'/role/add',1,3,0,NULL,1,0),(116,'role_edit','role','[0],[system],[role],','修改角色',NULL,'/role/edit',2,3,0,NULL,1,0),(117,'role_remove','role','[0],[system],[role],','删除角色',NULL,'/role/remove',3,3,0,NULL,1,0),(118,'role_setAuthority','role','[0],[system],[role],','配置权限',NULL,'/role/setAuthority',4,3,0,NULL,1,0),(119,'menu','system','[0],[system],','菜单管理',NULL,'/menu',4,2,1,NULL,1,0),(120,'menu_add','menu','[0],[system],[menu],','添加菜单',NULL,'/menu/add',1,3,0,NULL,1,0),(121,'menu_edit','menu','[0],[system],[menu],','修改菜单',NULL,'/menu/edit',2,3,0,NULL,1,0),(122,'menu_remove','menu','[0],[system],[menu],','删除菜单',NULL,'/menu/remove',3,3,0,NULL,1,0),(128,'log','system','[0],[system],','业务日志',NULL,'/log',6,2,1,NULL,1,0),(130,'druid','system','[0],[system],','监控管理',NULL,'/druid',7,2,1,NULL,1,NULL),(131,'dept','system','[0],[system],','部门管理',NULL,'/dept',3,2,1,NULL,1,NULL),(132,'dict','system','[0],[system],','字典管理',NULL,'/dict',4,2,1,NULL,1,NULL),(133,'loginLog','system','[0],[system],','登录日志',NULL,'/loginLog',6,2,1,NULL,1,NULL),(134,'log_clean','log','[0],[system],[log],','清空日志',NULL,'/log/delLog',3,3,0,NULL,1,NULL),(135,'dept_add','dept','[0],[system],[dept],','添加部门',NULL,'/dept/add',1,3,0,NULL,1,NULL),(136,'dept_update','dept','[0],[system],[dept],','修改部门',NULL,'/dept/update',1,3,0,NULL,1,NULL),(137,'dept_delete','dept','[0],[system],[dept],','删除部门',NULL,'/dept/delete',1,3,0,NULL,1,NULL),(138,'dict_add','dict','[0],[system],[dict],','添加字典',NULL,'/dict/add',1,3,0,NULL,1,NULL),(139,'dict_update','dict','[0],[system],[dict],','修改字典',NULL,'/dict/update',1,3,0,NULL,1,NULL),(140,'dict_delete','dict','[0],[system],[dict],','删除字典',NULL,'/dict/delete',1,3,0,NULL,1,NULL),(141,'notice','system','[0],[system],','通知管理',NULL,'/notice',9,2,1,NULL,1,NULL),(142,'notice_add','notice','[0],[system],[notice],','添加通知',NULL,'/notice/add',1,3,0,NULL,1,NULL),(143,'notice_update','notice','[0],[system],[notice],','修改通知',NULL,'/notice/update',2,3,0,NULL,1,NULL),(144,'notice_delete','notice','[0],[system],[notice],','删除通知',NULL,'/notice/delete',3,3,0,NULL,1,NULL),(145,'hello','0','[0],','通知','fa-rocket','/notice/hello',1,1,1,NULL,1,NULL),(148,'code','0','[0],','代码生成','fa-code','/code',3,1,1,NULL,1,NULL),(149,'api_mgr','0','[0],','接口文档','fa-leaf','/swagger-ui.html',2,1,1,NULL,1,NULL),(150,'to_menu_edit','menu','[0],[system],[menu],','菜单编辑跳转','','/menu/menu_edit',4,3,0,NULL,1,NULL),(151,'menu_list','menu','[0],[system],[menu],','菜单列表','','/menu/list',5,3,0,NULL,1,NULL),(152,'to_dept_update','dept','[0],[system],[dept],','修改部门跳转','','/dept/dept_update',4,3,0,NULL,1,NULL),(153,'dept_list','dept','[0],[system],[dept],','部门列表','','/dept/list',5,3,0,NULL,1,NULL),(154,'dept_detail','dept','[0],[system],[dept],','部门详情','','/dept/detail',6,3,0,NULL,1,NULL),(155,'to_dict_edit','dict','[0],[system],[dict],','修改菜单跳转','','/dict/dict_edit',4,3,0,NULL,1,NULL),(156,'dict_list','dict','[0],[system],[dict],','字典列表','','/dict/list',5,3,0,NULL,1,NULL),(157,'dict_detail','dict','[0],[system],[dict],','字典详情','','/dict/detail',6,3,0,NULL,1,NULL),(158,'log_list','log','[0],[system],[log],','日志列表','','/log/list',2,3,0,NULL,1,NULL),(159,'log_detail','log','[0],[system],[log],','日志详情','','/log/detail',3,3,0,NULL,1,NULL),(160,'del_login_log','loginLog','[0],[system],[loginLog],','清空登录日志','','/loginLog/delLoginLog',1,3,0,NULL,1,NULL),(161,'login_log_list','loginLog','[0],[system],[loginLog],','登录日志列表','','/loginLog/list',2,3,0,NULL,1,NULL),(162,'to_role_edit','role','[0],[system],[role],','修改角色跳转','','/role/role_edit',5,3,0,NULL,1,NULL),(163,'to_role_assign','role','[0],[system],[role],','角色分配跳转','','/role/role_assign',6,3,0,NULL,1,NULL),(164,'role_list','role','[0],[system],[role],','角色列表','','/role/list',7,3,0,NULL,1,NULL),(165,'to_assign_role','mgr','[0],[system],[mgr],','分配角色跳转','','/mgr/role_assign',8,3,0,NULL,1,NULL),(166,'to_user_edit','mgr','[0],[system],[mgr],','编辑用户跳转','','/mgr/user_edit',9,3,0,NULL,1,NULL),(167,'mgr_list','mgr','[0],[system],[mgr],','用户列表','','/mgr/list',10,3,0,NULL,1,NULL),(997455850513809409,'hdcontent','0','[0],','货代管理','fa-flash ','/hdcontent',99,1,1,NULL,1,0),(997455850522198018,'hdcontent_list','hdcontent','[0],[hdcontent],','货代管理列表','','/hdcontent/list',99,2,0,NULL,1,0),(997455850522198019,'hdcontent_add','hdcontent','[0],[hdcontent],','货代管理添加','','/hdcontent/add',99,2,0,NULL,1,0),(997455850522198020,'hdcontent_update','hdcontent','[0],[hdcontent],','货代管理更新','','/hdcontent/update',99,2,0,NULL,1,0),(997455850522198021,'hdcontent_delete','hdcontent','[0],[hdcontent],','货代管理删除','','/hdcontent/delete',99,2,0,NULL,1,0),(997455850522198022,'hdcontent_detail','hdcontent','[0],[hdcontent],','货代管理详情','','/hdcontent/detail',99,2,0,NULL,1,0),(997819974682927106,'swiper','0','[0],','图片展示管理','fa-file-image-o','/swiper',100,1,1,NULL,1,0),(997819974687121410,'swiper_list','swiper','[0],[swiper],','图片展示管理列表','','/swiper/list',99,2,0,NULL,1,0),(997819974687121411,'swiper_add','swiper','[0],[swiper],','图片展示管理添加','','/swiper/add',99,2,0,NULL,1,0),(997819974687121412,'swiper_update','swiper','[0],[swiper],','图片展示管理更新','','/swiper/update',99,2,0,NULL,1,0),(997819974687121413,'swiper_delete','swiper','[0],[swiper],','图片展示管理删除','','/swiper/delete',99,2,0,NULL,1,0),(997819974687121414,'swiper_detail','swiper','[0],[swiper],','图片展示管理详情','','/swiper/detail',99,2,0,NULL,1,0),(998570078133981186,'cdcontent','0','[0],','信用卡管理','fa-flash ','/cdcontent',99,1,1,NULL,1,0),(998570078133981187,'cdcontent_list','cdcontent','[0],[cdcontent],','信用卡管理列表','','/cdcontent/list',99,2,0,NULL,1,0),(998570078133981188,'cdcontent_add','cdcontent','[0],[cdcontent],','信用卡管理添加','','/cdcontent/add',99,2,0,NULL,1,0),(998570078133981189,'cdcontent_update','cdcontent','[0],[cdcontent],','信用卡管理更新','','/cdcontent/update',99,2,0,NULL,1,0),(998570078133981190,'cdcontent_delete','cdcontent','[0],[cdcontent],','信用卡管理删除','','/cdcontent/delete',99,2,0,NULL,1,0),(998570078133981191,'cdcontent_detail','cdcontent','[0],[cdcontent],','信用卡管理详情','','/cdcontent/detail',99,2,0,NULL,1,0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通知表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
INSERT INTO `sys_notice` VALUES (8,'你好',NULL,'你好','2017-05-10 19:28:57',1);
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operation_log`
--

DROP TABLE IF EXISTS `sys_operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operation_log`
--

LOCK TABLES `sys_operation_log` WRITE;
/*!40000 ALTER TABLE `sys_operation_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_relation`
--

DROP TABLE IF EXISTS `sys_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4295 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_relation`
--

LOCK TABLES `sys_relation` WRITE;
/*!40000 ALTER TABLE `sys_relation` DISABLE KEYS */;
INSERT INTO `sys_relation` VALUES (4093,105,1),(4094,106,1),(4095,107,1),(4096,108,1),(4097,109,1),(4098,110,1),(4099,111,1),(4100,112,1),(4101,113,1),(4102,165,1),(4103,166,1),(4104,167,1),(4105,114,1),(4106,115,1),(4107,116,1),(4108,117,1),(4109,118,1),(4110,162,1),(4111,163,1),(4112,164,1),(4113,119,1),(4114,120,1),(4115,121,1),(4116,122,1),(4117,150,1),(4118,151,1),(4119,128,1),(4120,134,1),(4121,158,1),(4122,159,1),(4123,130,1),(4124,131,1),(4125,135,1),(4126,136,1),(4127,137,1),(4128,152,1),(4129,153,1),(4130,154,1),(4131,132,1),(4132,138,1),(4133,139,1),(4134,140,1),(4135,155,1),(4136,156,1),(4137,157,1),(4138,133,1),(4139,160,1),(4140,161,1),(4141,141,1),(4142,142,1),(4143,143,1),(4144,144,1),(4145,145,1),(4146,148,1),(4147,149,1),(4151,997455850513809409,1),(4152,997455850522198018,1),(4153,997455850522198019,1),(4154,997455850522198020,1),(4155,997455850522198021,1),(4156,997455850522198022,1),(4157,997819974682927106,1),(4158,997819974687121410,1),(4159,997819974687121411,1),(4160,997819974687121412,1),(4161,997819974687121413,1),(4162,997819974687121414,1),(4163,998570078133981186,1),(4164,998570078133981187,1),(4165,998570078133981188,1),(4166,998570078133981189,1),(4167,998570078133981190,1),(4168,998570078133981191,1),(4187,105,7),(4188,106,7),(4189,107,7),(4190,108,7),(4191,109,7),(4192,110,7),(4193,111,7),(4194,112,7),(4195,113,7),(4196,165,7),(4197,166,7),(4198,167,7),(4199,114,7),(4200,115,7),(4201,116,7),(4202,117,7),(4203,118,7),(4204,162,7),(4205,163,7),(4206,164,7),(4207,128,7),(4208,134,7),(4209,158,7),(4210,159,7),(4211,131,7),(4212,135,7),(4213,136,7),(4214,137,7),(4215,152,7),(4216,153,7),(4217,154,7),(4218,133,7),(4219,160,7),(4220,161,7),(4221,141,7),(4222,142,7),(4223,143,7),(4224,144,7),(4225,145,7),(4226,997455850513809409,7),(4227,997455850522198018,7),(4228,997455850522198019,7),(4229,997455850522198020,7),(4230,997455850522198021,7),(4231,997455850522198022,7),(4232,997819974682927106,7),(4233,997819974687121410,7),(4234,997819974687121411,7),(4235,997819974687121412,7),(4236,997819974687121413,7),(4237,997819974687121414,7),(4238,998570078133981186,7),(4239,998570078133981187,7),(4240,998570078133981188,7),(4241,998570078133981189,7),(4242,998570078133981190,7),(4243,998570078133981191,7),(4277,997455850513809409,6),(4278,997455850522198018,6),(4279,997455850522198019,6),(4280,997455850522198020,6),(4281,997455850522198021,6),(4282,997455850522198022,6),(4283,997819974682927106,6),(4284,997819974687121410,6),(4285,997819974687121411,6),(4286,997819974687121412,6),(4287,997819974687121413,6),(4288,997819974687121414,6),(4289,998570078133981186,6),(4290,998570078133981187,6),(4291,998570078133981188,6),(4292,998570078133981189,6),(4293,998570078133981190,6),(4294,998570078133981191,6);
/*!40000 ALTER TABLE `sys_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,1,0,'超级管理员',24,'administrator',1),(6,1,0,'应用管理员',0,'content',NULL),(7,3,0,'普通管理员',0,'root',NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_swiper`
--

DROP TABLE IF EXISTS `sys_swiper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_swiper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `url` varchar(50) NOT NULL,
  `open` int(11) NOT NULL DEFAULT '1',
  `tourl` varchar(100) DEFAULT '#',
  `showorder` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_swiper`
--

LOCK TABLES `sys_swiper` WRITE;
/*!40000 ALTER TABLE `sys_swiper` DISABLE KEYS */;
INSERT INTO `sys_swiper` VALUES (4,'hello world','8b0981cc-edb3-4080-b526-5d2613cf661e.jpg',1,'http://www.baidu.com',1,1),(6,'hello world！','9ea33952-c294-4ddf-ac1a-038c275f7349.jpg',1,'#',1,2),(7,'！～～～','8185c18f-f2e7-49de-83f6-ba5afb9b3310.jpg',1,'#',2,1),(8,'啦啦啦啦','629c048c-345b-4e9a-94a9-c88defd73873.jpg',2,'http://www.baidu.com',2,2);
/*!40000 ALTER TABLE `sys_swiper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'1a654906-56b4-484a-a553-c7fed3ed1f38.jpg','admin','55aec35fa74d6ff93328abd52551a48b','8pgby','张三','2017-05-05 00:00:00',2,'sn93@qq.com','18200000000','1',0,1,'2016-01-29 08:49:53',25),(44,NULL,'test','45abb7879f6a8268f1ef600e6038ac73','ssts3','test','2017-05-01 00:00:00',1,'abc@123.com','','5',26,3,'2017-05-16 20:33:37',NULL),(45,NULL,'boss','71887a5ad666a18f709e1d4e693d5a35','1f7bf','老板','2017-12-04 00:00:00',1,'','','1',24,3,'2017-12-04 22:24:02',NULL),(46,NULL,'manager','b53cac62e7175637d4beb3b16b2f7915','j3cs9','经理','2017-12-04 00:00:00',1,'','','1',24,3,'2017-12-04 22:24:24',NULL),(47,NULL,'test','12526206092eb09353559399fdf6d030','u1f8p','test',NULL,1,'123@test.com','123456','6',0,1,'2018-05-23 12:22:27',NULL),(48,NULL,'sqz','5ba6fd8b83d7a7703b59dd417af1d66c','luprt','boss','2018-05-25 00:00:00',1,'123@qq.com','123456789','7',0,1,'2018-05-25 20:54:16',NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-28 21:42:36
