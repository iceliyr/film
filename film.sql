-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: film
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('lyr','111'),('scnu','scnu');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `movie_id` varchar(30) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `submit_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1895931906 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (424607746,'a@163.com','022','你好','2023-12-22 13:27:45'),(969916417,'a@163.com','027','aaa','2023-12-30 08:35:49'),(1678745602,'a@163.com','022','真好看','2024-01-10 13:11:35'),(1745829890,'a@163.com','031','666','2023-12-22 07:44:30'),(1895931905,'lyr@163.com','032','好','2023-12-21 04:26:43');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favor`
--

DROP TABLE IF EXISTS `favor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `movie_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favor`
--

LOCK TABLES `favor` WRITE;
/*!40000 ALTER TABLE `favor` DISABLE KEYS */;
INSERT INTO `favor` VALUES (1,'lyr@163.com','032'),(2,'lyr@163.com','031'),(3,'lyr@163.com','030'),(4,'lyr@163.com','029'),(5,'lyr@163.com','028'),(6,'lyr@163.com','023'),(7,'lyr@163.com','024'),(12,'lyr@163.com','026'),(15,'lyr@163.com','025'),(16,'lyr@163.com','016'),(17,'lyr@163.com','027'),(18,'lyr@163.com','001'),(19,'a@163.com','030'),(20,'a@163.com','032'),(30,'a@163.com','022'),(33,'a@163.com','069');
/*!40000 ALTER TABLE `favor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_id` char(30) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  `director` varchar(30) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `region` char(30) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `view_count` int DEFAULT NULL,
  `vip_class` varchar(30) DEFAULT NULL,
  `pictures` varchar(30) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('001','奥本海默','2023','诺兰','基里安·墨菲','传记','美国',9.5,1000,'会员','001.jpg',NULL),('002','蝙蝠侠：黑暗骑士','2008','诺兰','克里斯蒂安·贝尔','剧情','美国',9.2,1221,'免费','002.jpg',NULL),('003','国王的演讲','2010','汤姆·霍伯','科林·费尔斯','传记','英国',8.4,997,'免费','003.jpg',NULL),('004','你的名字','2016','新海诚','神木隆之介','爱情','日本',8.5,899,'免费','004.jpg',NULL),('005','岛上书店','2022','汉斯·卡诺萨','克里斯蒂娜·亨德里克斯','剧情/喜剧','美国',6.8,674,'免费','005.jpg',NULL),('006','八角笼中','2023','王宝强','王宝强/陈永胜/王迅','剧情/动作','中国大陆',7.3,788,'会员','006.jpg',NULL),('007','埋葬','2023','玛格丽特·贝茨','杰米·福克斯/汤米·李·琼斯','剧情','美国',7.1,711,'会员','007.jpg',NULL),('008','蜘蛛侠：英雄无归','2021','乔·沃茨','汤姆·赫兰德/赞达亚/本尼迪克特·康伯巴奇','动作/科幻/奇幻/冒险','美国',6.8,700,'免费','008.jpg',NULL),('009','长津湖','2021','陈凯歌/徐克/林超贤','吴京','剧情/历史/战争','中国大陆/中国香港',7.8,864,'免费','009.jpg',NULL),('010','奇异博士2：疯狂多元宇宙','2022','山姆·雷米','本尼迪克特·康伯巴奇','动作/科幻/恐怖/奇幻/冒险','美国',6.4,700,'免费','010.jpg',NULL),('011','神奇动物：邓布利多之谜','2022','大卫·叶茨','埃迪·雷德梅恩/裘德·洛','奇幻/冒险','英国/美国',6.2,600,'免费','011.jpg',NULL),('012','长津湖之水门桥','2022','徐克','吴京','剧情/历史/战争','中国大陆/中国香港',7.2,800,'免费','012.jpg',NULL),('013','黑豹2','2022','瑞恩·库格勒','利蒂希娅·赖特/露皮塔·尼永奥','剧情/动作/科幻/惊悚/奇幻/冒险','美国',5.4,300,'免费','013.jpg',NULL),('014','铃芽之旅','2022','新海诚','原菜乃华/松村北斗/深津绘里','爱情/动画/奇幻','日本',7.4,743,'免费','014.jpg',NULL),('015','岸边露伴卢浮宫之行','2023','渡边一贵','高桥一生/饭丰万理江/木村文乃','剧情/奇幻','日本',6.2,612,'会员','015.jpg',NULL),('016','长安三万里','2023','谢君伟/邹靖','杨天翔/凌振赫/吴俊全','动画/历史','中国大陆',8.3,924,'会员','016.jpg',NULL),('017','流浪地球','2019','郭帆','吴京/屈楚萧/李光洁/吴孟达','科幻/冒险/灾难','中国大陆',7.9,900,'免费','017.jpg',NULL),('018','让子弹飞','2010','姜文','姜文/葛优/周润发','剧情/喜剧/动作/西部','中国大陆/中国香港',9,1000,'免费','018.jpg',NULL),('019','摔跤吧！爸爸','2016','涅提·蒂瓦里','阿米尔·汗/法缇玛·萨那·纱卡/桑亚·玛荷塔','剧情/家庭/传记/运动','印度',9.1,1100,'免费','019.jpg',NULL),('020','三傻大闹宝莱坞','2009','拉吉库马尔·希拉尼','阿米尔·汗/卡琳娜·卡普尔/马达范','剧情/喜剧/爱情/歌舞','印度',9.2,1211,'免费','020.jpg',NULL),('021','盗梦空间','2010','克里斯托弗·诺兰','莱昂纳多·迪卡普里奥/约瑟夫·高登-莱维特','剧情/科幻/悬疑/冒险','美国/英国',9.4,1245,'免费','021.jpg',NULL),('022','楚门的世界','1998','彼得·威尔','金·凯瑞/劳拉·琳妮/艾德·哈里斯','剧情/科幻','美国',9.4,1186,'免费','022.jpg',NULL),('023','绿皮书','2018','彼得·法雷里','维果·莫腾森/马赫沙拉·阿里','剧情/喜剧/音乐/传记','美国/中国大陆',8.9,1004,'免费','023.jpg',NULL),('024','寻梦环游记','2017','李·昂克里奇/阿德里安·莫利纳','安东尼·冈萨雷斯/盖尔·加西亚·贝纳尔','喜剧/动画/音乐/奇幻','美国',9.1,1126,'免费','024.jpg',NULL),('025','泰坦尼克号','1997','詹姆斯·卡梅隆','莱昂纳多·迪卡普里奥/凯特·温丝莱特','剧情/爱情/灾难','美国/墨西哥',9.5,1224,'免费','025.jpg',NULL),('026','肖申克的救赎','1994','弗兰克·德拉邦特','蒂姆·罗宾斯/摩根·弗里曼','剧情/犯罪','美国',9.7,1256,'免费','026.jpg',NULL),('027','坚如磐石','2023','张艺谋','雷佳音/张国立','剧情/动作/犯罪','中国大陆',6.2,700,'会员','027.jpg',NULL),('028','封神第一部：朝歌风云','2023','乌尔善','费翔/李雪健/黄渤','动作/战争/奇幻/古装','中国大陆',7.8,800,'会员','028.jpg',NULL),('029','疯狂动物城','2016','拜伦·霍华德/瑞奇·摩尔/杰拉德·布什','金妮弗·古德温/杰森·贝特曼','喜剧/动画/冒险','美国',9.2,1178,'免费','029.jpg',NULL),('030','我不是药神','2018','文牧野','徐峥/王传君','剧情/喜剧','中国大陆',9,1233,'免费','030.jpg',NULL),('031','海上钢琴师','1998','朱塞佩·托纳多雷','蒂姆·罗斯/普路特·泰勒·文斯','剧情/音乐','意大利',9.3,1169,'免费','031.jpg',NULL),('032','哈尔的移动城堡','2004','宫崎骏','倍赏千惠子/木村拓哉/美轮明宏/我修院达也','动画/奇幻/冒险','日本',9.1,1242,'会员','032.jpg',NULL),('033','龙猫','2008','宫崎骏','日高范子/坂本千夏/糸井重里/岛本须美/','动画/奇幻/冒险','日本',9.2,1179,'免费','033.jpg',NULL),('034','海街日记','2015','是枝裕和','绫濑遥/长泽雅美/夏帆/广濑铃/','剧情/家庭','日本',8.8,897,'免费','034.jpg',NULL),('035','假如爱有天意','2003','郭在容','孙艺珍/赵寅成/曹承佑/李己雨/','剧情/爱情','韩国',8.4,1023,'会员','035.jpg',NULL),('036','隐秘而伟大','2013','张哲洙','金秀贤/李玹雨/朴基雄/','喜剧/动作','韩国',7.9,712,'免费','036.jpg',NULL),('037','寒战','2012','梁乐民/陆剑青','郭富城/梁家辉/李治廷','剧情/动作/犯罪','中国香港',7.6,915,'免费','037.jpg',NULL),('038','台北飘雪','2012','霍建起','陈柏霖/童瑶/杨祐宁/蔡淑臻','剧情','中国台湾',5.6,667,'免费','038.jpg',NULL),('039','老大人','2018','洪伯豪','小戽斗/喜翔/黄嘉千','剧情','中国台湾',6.8,910,'免费','039.jpg',NULL),('040','妈祖回家','2019','蒲剑','赵亮/葛玟希/关德辉','剧情/历史中国台湾','',7.2,1023,'会员','040.jpg',NULL),('041','英国人在纽约','2009','理查德·拉克辛','约翰·赫特/丹尼斯·欧哈拉/乔纳森·塔克','剧情/同性','英国',8.3,1172,'免费','041.jpg',NULL),('042','文艺复兴','2014','海伦·沙尔敏','詹姆斯·福克斯','纪录片','英国',8.6,1056,'会员','042.jpg',NULL),('043','主顾','2008','若西安·巴拉斯科','纳塔莉·贝伊/埃里克·卡拉瓦卡/伊莎贝尔·卡雷','剧情/爱情','法国',7.4,1210,'免费','043.jpg',NULL),('045','天使','2005','吕克·贝松','贾梅尔·杜布兹/丽·拉丝姆森/GilbertMelki','喜剧/爱情/奇幻','法国',7.7,1079,'会员','045.jpg',NULL),('046','年轻气盛','2015','保罗·索伦蒂诺','迈克尔·凯恩/保罗·达诺/蕾切尔·薇兹','剧情/喜剧','意大利/法国/瑞士',8.2,1232,'会员','046.jpg',NULL),('047','我的天才女友第四季','2022','萨维里奥·科斯坦佐/劳拉·比斯普里','阿尔芭·罗尔瓦赫尔/艾琳·马伊奥里诺/','剧情','意大利',7.8,896,'免费','047.jpg',NULL),('048','压力第七季','2021','撒贝尔其','柘文义汉','剧情/爱情','德国',7,982,'免费','048.jpg',NULL),('050','宿敌','2022','普利特维拉吉·苏库玛兰','普利特维拉吉·苏库玛兰/玛玛塔·莫汉达斯/','剧情','印度',8.5,1223,'会员','050.jpg',NULL),('051','双面线索','2023','阿迪亚·罗伊·卡普尔','阿迪亚·罗伊·卡普尔/洛尼特·罗伊','剧情/动作/悬疑/惊悚/犯罪','印度',6.9,1128,'免费','051.jpg',NULL),('052','这该死的爱','2017','阿塔彭·提马郜','查亚鹏·朱利·普帕特/婉娜拉·宋提查/帕塔拉萨雅·克苏菀斯莉','剧情','泰国',6.6,756,'免费','052.jpg',NULL),('053','世界欠我一个你','2021','桑凯·维杜郎奇','皮查雅·瓦塔那蒙迪里/阿南达·爱华灵咸/叻叻那·功多尔','剧情/喜剧/爱情','泰国',7.2,357,'免费','053.jpg',NULL),('055','福尔摩斯探案','2013','安纳托伊·路达科夫','伊戈尔·别特连科/安德烈·帕宁/米哈依尔·波亚尔斯基','悬疑/犯罪','俄罗斯',9.2,1379,'会员','055.jpg',NULL),('056','极速前进：加拿大版第四季','2016','罗伯·布鲁内尔','庄拿芬·蒙哥马利','真人秀','加拿大',9.1,1277,'免费','056.jpg',NULL),('057','逝去的时光','1922','卡尔·西奥多·德莱叶','卡尔·西奥多·德莱叶','剧情/爱情/家庭/奇幻','丹麦',6.8,556,'免费','057.jpg',NULL),('058','红心女王','2019','梅尔·图琪','崔娜·蒂虹/古斯塔夫·林德/马格努斯·克雷佩/','剧情/情色','丹麦/瑞典',7.2,783,'免费','058.jpg',NULL),('059','九月','2007','皮特·卡斯特尔','泽维尔·塞缪尔/基兰·达西-史密斯','剧情','澳大利亚',7.6,982,'会员','059.jpg',NULL),('060','筑梦奇人','2010','皮特·麦德森','泽维尔·塞缪尔/基兰·达西-史密斯','真人秀','澳大利亚',6.4,902,'免费','060.jpg',NULL),('061','巴西利亚！巴西利亚！','2021','扬·冈扎乐兹','凯特·莫兰/安迪·吉雷','剧情/历史','巴西',6.8,759,'免费','061.jpg',NULL),('062','无间道','2002','刘伟强','刘德华/梁朝伟/黄秋生','犯罪/剧情/悬疑','中国香港',9.1,1423,'会员','062.jpg',NULL),('063','鬼灭之刃：无限列车篇','2020','富冈义博','花江夏树/鬼头明里/下野纮','动画/奇幻/冒险','日本',8.7,1365,'免费','063.jpg',NULL),('064','美国队长3：内战','2016','安东尼·罗素/乔·罗素','克里斯·埃文斯/小罗伯特·唐尼/斯嘉丽·约翰逊','动作/科幻/惊悚','美国',8.1,1287,'会员','064.jpg',NULL),('065','摩登时代','1936','查理·卓别林','查理·卓别林/派蒂·麦基','喜剧/剧情','美国',9.3,1089,'会员','065.jpg',NULL),('066','无耻混蛋','2009','昆汀·塔伦蒂诺','布拉德·皮特/克里斯托弗·瓦尔兹/梅拉尼·罗兰','剧情/战争/冒险','美国',8.5,1043,'免费','066.jpg',NULL),('067','大鱼','2003','蒂姆·波顿','伊万·麦克格雷格/阿尔伯特·芬尼/比利·克鲁德普','剧情/奇幻/冒险','美国',8.7,1007,'会员','067.jpg',NULL),('068','阿甘正传','1994','罗伯特·泽米吉斯','汤姆·汉克斯/罗宾·怀特/加里·西尼斯','剧情/爱情','美国',9.5,1498,'免费','068.jpg',NULL),('069','无名之辈','2018','饶晓志','陈建斌/任素汐/潘斌龙','剧情/喜剧/犯罪','中国大陆',8.1,1234,'会员','069.jpg',NULL),('070','千面牛郎','2023','尼古拉斯·贝多斯','夏洛特·甘斯布/让·杜雅尔丹/劳拉·莫兰特','喜剧','法国',8,1367,'免费','070.jpg',NULL);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_member`
--

DROP TABLE IF EXISTS `tb_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_member` (
  `email` varchar(30) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `vip` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_member`
--

LOCK TABLES `tb_member` WRITE;
/*!40000 ALTER TABLE `tb_member` DISABLE KEYS */;
INSERT INTO `tb_member` VALUES ('2023@163.com','5531a5834816222280f20d1ef9e95f69',NULL,0),('a@163.com','698d51a19d8a121ce581499d7b701668',NULL,1),('lyr@163.com','698d51a19d8a121ce581499d7b701668',NULL,0);
/*!40000 ALTER TABLE `tb_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-10 21:42:46
