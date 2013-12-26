# MySQL-Front 5.1  (Build 4.2)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: shopping
# ------------------------------------------------------
# Server version 5.0.83-community-nt

#
# Source for table t_area
#

DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `AreaID` int(11) NOT NULL auto_increment,
  `CityID` int(11) NOT NULL,
  `AreaCode` varchar(6) NOT NULL,
  `Area` varchar(50) NOT NULL,
  PRIMARY KEY  (`AreaID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_area
#

LOCK TABLES `t_area` WRITE;
/*!40000 ALTER TABLE `t_area` DISABLE KEYS */;
INSERT INTO `t_area` VALUES (1,1,'1','上栗');
INSERT INTO `t_area` VALUES (2,2,'2','海淀');
INSERT INTO `t_area` VALUES (3,1,'2','莲花');
INSERT INTO `t_area` VALUES (4,1,'3','芦溪');
INSERT INTO `t_area` VALUES (5,3,'1','南昌');
/*!40000 ALTER TABLE `t_area` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_bill
#

DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `BillId` bigint(20) NOT NULL auto_increment,
  `BillPicPath` varchar(200) default NULL,
  `BillAddTime` datetime default NULL,
  `BillOrder` smallint(6) default NULL,
  `BillStatus` char(1) default NULL,
  `BillCreateUser` varchar(50) default NULL,
  PRIMARY KEY  (`BillId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_bill
#

LOCK TABLES `t_bill` WRITE;
/*!40000 ALTER TABLE `t_bill` DISABLE KEYS */;
INSERT INTO `t_bill` VALUES (7,'upLoad/u=3582460449,2703430297&fm=0&gp=6.jpg','2012-05-03 19:23:53',1,'y','admin');
INSERT INTO `t_bill` VALUES (8,'upLoad/guanggao1.jpg','2012-05-03 19:23:50',4,'y','admin');
INSERT INTO `t_bill` VALUES (9,'upLoad/yge.jpg','2012-05-03 19:24:04',3,'y','admin');
INSERT INTO `t_bill` VALUES (10,'upLoad/guang2.jpg','2012-05-03 19:25:13',4,'y','admin');
/*!40000 ALTER TABLE `t_bill` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_city
#

DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `CityID` int(11) NOT NULL auto_increment,
  `ProvinceID` int(11) default NULL,
  `CityCode` varchar(6) NOT NULL,
  `City` varchar(20) NOT NULL,
  PRIMARY KEY  (`CityID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_city
#

LOCK TABLES `t_city` WRITE;
/*!40000 ALTER TABLE `t_city` DISABLE KEYS */;
INSERT INTO `t_city` VALUES (1,1,'1','萍乡');
INSERT INTO `t_city` VALUES (2,2,'2','北京');
INSERT INTO `t_city` VALUES (3,1,'2','南昌');
INSERT INTO `t_city` VALUES (4,1,'3','赣州');
INSERT INTO `t_city` VALUES (5,1,'4','九江');
INSERT INTO `t_city` VALUES (6,1,'5','上饶');
INSERT INTO `t_city` VALUES (7,1,'6','宜春');
/*!40000 ALTER TABLE `t_city` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_comment
#

DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `CommentID` bigint(20) NOT NULL auto_increment,
  `CommentUserName` varchar(50) NOT NULL,
  `CommentRank` smallint(6) NOT NULL,
  `CommentContent` text NOT NULL,
  `CommentData` datetime NOT NULL,
  `GoodsID` bigint(20) NOT NULL,
  PRIMARY KEY  (`CommentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_comment
#

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (1,'huangzhen',1,'很好看~~','2012-04-26 09:08:44',2);
INSERT INTO `t_comment` VALUES (2,'游客',1,'非常的漂亮！！！','2012-04-26 09:09:32',2);
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_favorits
#

DROP TABLE IF EXISTS `t_favorits`;
CREATE TABLE `t_favorits` (
  `ID` bigint(20) NOT NULL auto_increment,
  `MemberID` bigint(20) NOT NULL,
  `GoodsID` bigint(20) NOT NULL,
  `Addtime` datetime default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_favorits
#

LOCK TABLES `t_favorits` WRITE;
/*!40000 ALTER TABLE `t_favorits` DISABLE KEYS */;
INSERT INTO `t_favorits` VALUES (3,1,2,'2012-04-26 09:07:25');
INSERT INTO `t_favorits` VALUES (4,1,1,'2012-04-26 09:07:27');
INSERT INTO `t_favorits` VALUES (5,4,2,'2012-04-26 09:22:43');
/*!40000 ALTER TABLE `t_favorits` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_goods
#

DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `GoodsID` bigint(20) NOT NULL auto_increment,
  `GoodsName` varchar(200) NOT NULL,
  `GoodsIntroduce` text,
  `GoodsNormalPrice` double NOT NULL,
  `GoodsMemberPrice` double NOT NULL,
  `GoodsRebate` float NOT NULL,
  `TypeCode` varchar(100) NOT NULL,
  `GoodsNumber` int(11) default NULL,
  `GoodsGrade` int(11) default NULL,
  `isSale` char(1) NOT NULL,
  `isValid` char(1) NOT NULL,
  `GoodsPicture` varchar(200) default NULL,
  `Creater` varchar(20) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `Updater` varchar(20) NOT NULL,
  `UpdateDate` datetime NOT NULL,
  `BuyCount` int(11) default NULL,
  `BuyGoodsNumber` int(11) default NULL,
  PRIMARY KEY  (`GoodsID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_goods
#

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
INSERT INTO `t_goods` VALUES (4,'管理是什么？','<p><span style=\"font-size: medium\"><img alt=\"\" src=\"http://localhost:8080/shoppingD/fckeditor/editor/images/smiley/msn/heart.gif\" />掌握管理学，让你快速当领导，</span></p>',96.5,85,0.88,'0000001111',50,NULL,'n','y','upLoad/11.jpg','admin','2012-05-03 18:11:38','admin','2012-05-03 18:48:59',0,0);
INSERT INTO `t_goods` VALUES (8,'无懈可击的Web设计','<p>无懈可击哦！买过路过，千万不要错过！</p>',120,120,1,'0000001112',40,NULL,'n','y','upLoad/24.jpg','admin','2012-05-03 18:19:47','admin','2012-05-03 18:19:47',0,0);
INSERT INTO `t_goods` VALUES (12,'货币战争','<p><span style=\"color: #ff6600\">了解世界货币，了解世界</span></p>',68.8000030517578,50,0.73,'0000001111',10,NULL,'y','y','upLoad/13.jpg','admin','2012-05-03 18:30:37','admin','2012-05-03 18:46:33',0,0);
INSERT INTO `t_goods` VALUES (15,'新编考研英语','<p>好书</p>',25,20,0.8,'0000001113',10,NULL,'y','y','upLoad/31.jpg','admin','2012-05-03 18:45:50','admin','2012-05-03 18:45:50',0,0);
INSERT INTO `t_goods` VALUES (16,'多维女性手机','<p>很漂亮哦~~千万不要错过</p>',438,300,0.68,'0001000111',21,NULL,'y','y','upLoad/41.jpg','admin','2012-05-03 18:52:09','admin','2012-05-03 18:52:09',0,0);
INSERT INTO `t_goods` VALUES (17,'Nokia新款手机','<p>抢购了~~</p>',1200,1000,0.83,'0001000111',111,NULL,'y','y','upLoad/44.jpg','admin','2012-05-03 18:54:36','admin','2012-05-03 19:19:12',0,0);
INSERT INTO `t_goods` VALUES (18,'数码相机','<p>你能记住这一瞬间吗？但是他永远可以记得！！</p>\r\n<p>让瞬间甜蜜达到永恒</p>',1500,1200,0.8,'000010011',0,NULL,'y','y','upLoad/111G345X-0.jpg','admin','2012-05-03 19:28:14','admin','2012-05-03 19:28:14',0,0);
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_goodstype
#

DROP TABLE IF EXISTS `t_goodstype`;
CREATE TABLE `t_goodstype` (
  `TypeID` bigint(20) NOT NULL auto_increment,
  `TypeCode` varchar(100) NOT NULL,
  `TypeName` varchar(200) NOT NULL,
  `TypeDesc` varchar(2000) NOT NULL,
  `isLeaf` char(1) NOT NULL,
  `ParentID` varchar(100) default NULL,
  `TypeLevel` int(11) NOT NULL,
  `Creater` varchar(20) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `Updater` varchar(20) NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY  (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_goodstype
#

LOCK TABLES `t_goodstype` WRITE;
/*!40000 ALTER TABLE `t_goodstype` DISABLE KEYS */;
INSERT INTO `t_goodstype` VALUES (3,'0000001001','图书','书中自有颜如玉——书中自有黄金屋！','n',NULL,1,'null','2012-05-03 18:05:26','null','2012-05-03 18:05:26');
INSERT INTO `t_goodstype` VALUES (4,'0000001111','经济学','经济学!让你学会在家看世界！','y','0000001001',0,'null','2012-05-03 18:06:27','admin','2012-05-03 18:06:57');
INSERT INTO `t_goodstype` VALUES (5,'0000001112','计算机','快速入门的法门，等你来哦~~','y','0000001001',0,'null','2012-05-03 18:08:03','null','2012-05-03 18:08:03');
INSERT INTO `t_goodstype` VALUES (6,'0000001113','英语书','英语~走遍世界的语言，尽在掌握！','y','0000001001',0,'null','2012-05-03 18:09:29','null','2012-05-03 18:09:29');
INSERT INTO `t_goodstype` VALUES (7,'0001000100','手机','各种手机上市了','n',NULL,1,'null','2012-05-03 18:50:19','null','2012-05-03 18:50:19');
INSERT INTO `t_goodstype` VALUES (8,'0001000111','女性手机','赶快来买哦！','y','0001000100',0,'null','2012-05-03 18:50:53','null','2012-05-03 18:50:53');
INSERT INTO `t_goodstype` VALUES (9,'000010001','数码产品','数码产品很好','n',NULL,1,'null','2012-05-03 19:26:08','null','2012-05-03 19:26:08');
INSERT INTO `t_goodstype` VALUES (10,'000010011','相机类','数码相机，让瞬间变为永恒','y','000010001',0,'null','2012-05-03 19:26:45','null','2012-05-03 19:26:45');
/*!40000 ALTER TABLE `t_goodstype` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_member
#

DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `MemberID` bigint(20) NOT NULL auto_increment,
  `MemberName` varchar(20) NOT NULL,
  `MemberTrueName` varchar(20) character set gbk default '',
  `MemberPassword` varchar(32) NOT NULL,
  `MemberEmail` varchar(50) NOT NULL,
  `MemberGrade` int(11) default NULL,
  `MemberAmount` double default NULL,
  `MemberStatus` char(1) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY  (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_member
#

LOCK TABLES `t_member` WRITE;
/*!40000 ALTER TABLE `t_member` DISABLE KEYS */;
INSERT INTO `t_member` VALUES (1,'huangzhen','黄珍','123456','519523266@qq.com',0,123,'1','2011-11-03','2012-03-06');
INSERT INTO `t_member` VALUES (3,'huanghuang','黄珍','222222','519523266@qq.com',NULL,NULL,'0','2012-04-25 18:06:52','2012-04-25 18:06:52');
INSERT INTO `t_member` VALUES (4,'bejing','','000000','519523266@qq.com',NULL,NULL,'1','2012-04-26 09:15:39','2012-04-26 09:15:39');
/*!40000 ALTER TABLE `t_member` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_memberaddressbook
#

DROP TABLE IF EXISTS `t_memberaddressbook`;
CREATE TABLE `t_memberaddressbook` (
  `ID` bigint(20) NOT NULL auto_increment,
  `MemberID` bigint(20) default NULL,
  `MemberTrueName` varchar(20) NOT NULL,
  `MemberAddress` varchar(100) NOT NULL,
  `ProvinceCode` char(2) NOT NULL,
  `CityCode` char(4) NOT NULL,
  `AreaCode` char(6) NOT NULL,
  `MemberPostcode` char(6) NOT NULL,
  `MemberTelephone` varchar(20) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_memberaddressbook
#

LOCK TABLES `t_memberaddressbook` WRITE;
/*!40000 ALTER TABLE `t_memberaddressbook` DISABLE KEYS */;
INSERT INTO `t_memberaddressbook` VALUES (1,1,'黄珍','四海村','1','1','1','337009','15083784750','2011-11-03','2012-04-25 16:35:15');
INSERT INTO `t_memberaddressbook` VALUES (2,3,'黄珍','第一客栈','1','1','1','111111','15236593625','2012-04-25 18:06:52','2012-04-25 18:08:59');
INSERT INTO `t_memberaddressbook` VALUES (3,4,'北京','中关村','2','2','2','998877','12345698765','2012-04-26 09:15:39','2012-04-26 09:15:39');
/*!40000 ALTER TABLE `t_memberaddressbook` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_order
#

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `OrderID` bigint(20) NOT NULL auto_increment,
  `MemberID` bigint(20) NOT NULL,
  `MemberTrueName` varchar(30) NOT NULL,
  `MemberAddress` varchar(100) NOT NULL,
  `MemberProvince` varchar(30) NOT NULL,
  `MemberCity` varchar(30) NOT NULL,
  `MemberArea` varchar(50) NOT NULL,
  `MemberPostcode` varchar(6) NOT NULL,
  `MemberTelephone` varchar(20) NOT NULL,
  `OrderAmount` double NOT NULL,
  `OrderPay` varchar(20) NOT NULL,
  `OrderInvoice` char(1) default NULL,
  `OrderCarry` varchar(20) NOT NULL,
  `OrderCarryTime` int(11) NOT NULL,
  `OrderRemark` varchar(2000) default NULL,
  `OrderStatus` char(1) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY  (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_order
#

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (3,3,'黄珍','第一客栈','1','1','1','111111','15236593625',1998,'现金','Y','邮寄',2,'','Y','2012-04-25 18:43:05','2012-04-25 18:43:05');
INSERT INTO `t_order` VALUES (5,3,'黄珍','第一客栈','1','1','1','111111','15236593625',999,'现金','Y','邮寄',2,'尽快哦','Y','2012-04-25 20:54:05','2012-04-25 20:54:05');
INSERT INTO `t_order` VALUES (6,1,'黄珍','四海村','1','1','1','337009','15083784750',999,'现金','N','邮寄',2,'','Y','2012-05-02 18:56:10','2012-05-02 18:56:10');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_ordercarrymode
#

DROP TABLE IF EXISTS `t_ordercarrymode`;
CREATE TABLE `t_ordercarrymode` (
  `CarryID` int(11) NOT NULL auto_increment,
  `CarryContent` varchar(50) NOT NULL,
  `CarryDay` int(11) default NULL,
  `CarryDesc` varchar(150) default NULL,
  PRIMARY KEY  (`CarryID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_ordercarrymode
#

LOCK TABLES `t_ordercarrymode` WRITE;
/*!40000 ALTER TABLE `t_ordercarrymode` DISABLE KEYS */;
INSERT INTO `t_ordercarrymode` VALUES (1,'邮寄',2,'快捷、方便、实惠');
/*!40000 ALTER TABLE `t_ordercarrymode` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_ordercarrytime
#

DROP TABLE IF EXISTS `t_ordercarrytime`;
CREATE TABLE `t_ordercarrytime` (
  `CarryTimeID` int(11) NOT NULL auto_increment,
  `CarryTimeContent` varchar(100) NOT NULL,
  PRIMARY KEY  (`CarryTimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_ordercarrytime
#

LOCK TABLES `t_ordercarrytime` WRITE;
/*!40000 ALTER TABLE `t_ordercarrytime` DISABLE KEYS */;
INSERT INTO `t_ordercarrytime` VALUES (1,'3天内送到');
INSERT INTO `t_ordercarrytime` VALUES (2,'7天内送到');
INSERT INTO `t_ordercarrytime` VALUES (3,'一个月内送到');
INSERT INTO `t_ordercarrytime` VALUES (4,'当天送到');
/*!40000 ALTER TABLE `t_ordercarrytime` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_orderdetail
#

DROP TABLE IF EXISTS `t_orderdetail`;
CREATE TABLE `t_orderdetail` (
  `ID` bigint(20) NOT NULL auto_increment,
  `OrderID` bigint(20) default NULL,
  `GoodsID` bigint(20) NOT NULL,
  `GoodsName` varchar(200) NOT NULL,
  `GoodsPrice` double NOT NULL,
  `GoodsCount` int(11) NOT NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_orderdetail
#

LOCK TABLES `t_orderdetail` WRITE;
/*!40000 ALTER TABLE `t_orderdetail` DISABLE KEYS */;
INSERT INTO `t_orderdetail` VALUES (4,3,1,'菲尔服饰',999,2);
INSERT INTO `t_orderdetail` VALUES (6,5,1,'菲尔服饰',999,1);
INSERT INTO `t_orderdetail` VALUES (7,6,2,'菲尔服饰',999,1);
/*!40000 ALTER TABLE `t_orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_orderinvoice
#

DROP TABLE IF EXISTS `t_orderinvoice`;
CREATE TABLE `t_orderinvoice` (
  `InvoiceID` bigint(20) NOT NULL auto_increment,
  `OrderID` bigint(20) NOT NULL,
  `InvoiceTitle` varchar(100) NOT NULL,
  `InvoiceContent` varchar(150) NOT NULL,
  `InvoiceAmount` double default NULL,
  PRIMARY KEY  (`InvoiceID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_orderinvoice
#

LOCK TABLES `t_orderinvoice` WRITE;
/*!40000 ALTER TABLE `t_orderinvoice` DISABLE KEYS */;
INSERT INTO `t_orderinvoice` VALUES (1,3,'我的发票','服装件',1998);
INSERT INTO `t_orderinvoice` VALUES (2,5,'我要发票','服装件',999);
INSERT INTO `t_orderinvoice` VALUES (3,5,'我要发票','服装件',999);
INSERT INTO `t_orderinvoice` VALUES (4,1,'我要发票','服装件',999);
/*!40000 ALTER TABLE `t_orderinvoice` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_orderpaymode
#

DROP TABLE IF EXISTS `t_orderpaymode`;
CREATE TABLE `t_orderpaymode` (
  `PayID` int(11) NOT NULL auto_increment,
  `PayContent` varchar(50) NOT NULL,
  `PayDesc` varchar(150) default NULL,
  PRIMARY KEY  (`PayID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_orderpaymode
#

LOCK TABLES `t_orderpaymode` WRITE;
/*!40000 ALTER TABLE `t_orderpaymode` DISABLE KEYS */;
INSERT INTO `t_orderpaymode` VALUES (1,'现金','采用现金消费');
INSERT INTO `t_orderpaymode` VALUES (2,'会员卡','使用会员卡进行消费');
INSERT INTO `t_orderpaymode` VALUES (3,'银行卡','使用网上银行消费');
/*!40000 ALTER TABLE `t_orderpaymode` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_placard
#

DROP TABLE IF EXISTS `t_placard`;
CREATE TABLE `t_placard` (
  `PlacardID` bigint(20) NOT NULL auto_increment,
  `PlacardTitle` varchar(100) NOT NULL,
  `PlacardContent` varchar(4000) NOT NULL,
  `IssueDate` datetime NOT NULL,
  `ExpireDate` datetime NOT NULL,
  `Creater` varchar(20) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `Updater` varchar(20) NOT NULL,
  `UpdateDate` datetime NOT NULL,
  PRIMARY KEY  (`PlacardID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_placard
#

LOCK TABLES `t_placard` WRITE;
/*!40000 ALTER TABLE `t_placard` DISABLE KEYS */;
INSERT INTO `t_placard` VALUES (1,'推出新产品','尊敬的各位顾客！\r\n   感谢你对本商城的支持和鼓励，为此我们推出新一期的商品活动，希望各位购物愉快！','2012-04-18','2012-05-12','admin','2012-04-25 15:09:59','null','2012-04-26 08:46:29');
INSERT INTO `t_placard` VALUES (2,'新品手机上市','  本周内将有一款由Nokia制作的手机于本月20号上市，活动为期5天，希望各位新老顾客前来选购，我们将为您提供优质服务~','2012-05-01','2012-05-25','admin','2012-05-03 19:06:18','admin','2012-05-03 19:06:18');
INSERT INTO `t_placard` VALUES (3,'停卖公告！！','  由于系统在进行维护，本月30号将不进行任何购物活动~希望各位顾客谅解！','2012-05-01','2012-05-31','admin','2012-05-03 19:08:27','admin','2012-05-03 19:08:27');
/*!40000 ALTER TABLE `t_placard` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_province
#

DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `ProvinceID` int(11) NOT NULL auto_increment,
  `ProvinceCode` varchar(2) NOT NULL,
  `Province` varchar(20) NOT NULL,
  PRIMARY KEY  (`ProvinceID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_province
#

LOCK TABLES `t_province` WRITE;
/*!40000 ALTER TABLE `t_province` DISABLE KEYS */;
INSERT INTO `t_province` VALUES (1,'1','江西');
INSERT INTO `t_province` VALUES (2,'2','北京');
/*!40000 ALTER TABLE `t_province` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_skin
#

DROP TABLE IF EXISTS `t_skin`;
CREATE TABLE `t_skin` (
  `SkinID` int(11) NOT NULL,
  `SkinName` varchar(50) default NULL,
  `SkinPath` varchar(100) default NULL,
  `SkinCreateTime` datetime default NULL,
  `SkinUser` varchar(50) default NULL,
  PRIMARY KEY  (`SkinID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table t_skin
#

LOCK TABLES `t_skin` WRITE;
/*!40000 ALTER TABLE `t_skin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_skin` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table t_user
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `UserID` int(11) NOT NULL auto_increment,
  `UserName` varchar(20) NOT NULL,
  `UserTrueName` varchar(20) NOT NULL,
  `UserPassword` varchar(32) NOT NULL,
  `isValid` char(1) NOT NULL,
  `CreateDate` datetime NOT NULL,
  `UpdateDate` datetime NOT NULL,
  `UserType` char(1) default NULL,
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table t_user
#

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','admin','y','2011-11-03','2012-02-05','y');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
