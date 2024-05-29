-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: cosplay
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `exhibition`
--

DROP TABLE IF EXISTS `exhibition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exhibition` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `eName` varchar(30) NOT NULL,
  `eTime` datetime NOT NULL,
  `ePlace` varchar(50) NOT NULL,
  `eIntroduce` varchar(200) NOT NULL,
  `eImgName` varchar(100) NOT NULL,
  `tid` int NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibition`
--

LOCK TABLES `exhibition` WRITE;
/*!40000 ALTER TABLE `exhibition` DISABLE KEYS */;
INSERT INTO `exhibition` VALUES (1,'腾讯王者荣誉cos漫展','2022-12-16 22:50:46','湖工大','好看得一匹','1',1),(2,'原神漫展','2023-12-17 16:56:26','湖工大','只有你想不到,没有我们没有','2',2),(3,'火影漫展','2023-12-20 21:20:48','工程学院','真实好看','3',3),(4,'一人之下','2023-12-24 15:31:40','北京市','异人召集令','4',4),(5,'海贼王','2023-12-21 14:36:59','海南','我要成为海贼王','5',5);
/*!40000 ALTER TABLE `exhibition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `status` varchar(10) NOT NULL DEFAULT '未支付',
  `oNum` int NOT NULL,
  `oTime` datetime NOT NULL,
  `totalPrice` double NOT NULL,
  `uid` int NOT NULL,
  `tid` int NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'已支付',2,'2023-12-17 17:02:58',99.6,1,1),(2,'未支付',1,'2023-12-17 17:04:59',88.8,1,2),(3,'已支付',2,'2023-12-17 14:36:21',99.6,2,1),(5,'未支付',2,'2023-12-27 09:54:16',177.6,6,2),(6,'已支付',2,'2023-12-29 10:41:21',100,1,3),(7,'已支付',1,'2023-12-29 10:59:21',49.8,1,1),(12,'已支付',1,'2023-12-29 10:38:22',38.8,1,5),(13,'已支付',3,'2023-12-29 10:53:50',120,1,4),(14,'未支付',1,'2023-12-29 10:56:50',40,2,4),(15,'未支付',1,'2023-12-29 10:57:11',49.8,2,1),(16,'已支付',3,'2024-05-28 12:12:51',149.4,1,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `rContent` varchar(300) NOT NULL,
  `rTime` datetime NOT NULL,
  `uid` int NOT NULL,
  `eid` int NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,'好看666啊啊啊啊啊啊啊啊','2023-12-17 16:47:41',1,1),(2,'不错啊啊啊啊啊啊啊啊','2023-12-17 14:48:23',2,1),(3,'这么叼','2023-12-16 18:53:23',2,2),(4,'厉害还好哈哈哈哈哈哈哈哈哈','2023-12-18 14:49:14',1,2),(5,'好看好看好看好看','2023-12-25 13:24:49',3,1),(6,'test','2023-12-27 14:15:02',1,1),(7,'好看的不得鸟','2023-12-26 16:00:00',1,1),(8,'test2','2023-12-26 16:00:00',1,1),(9,'test','2023-12-28 08:42:21',1,1),(10,'test','2023-12-28 08:46:16',1,1),(11,'test','2023-12-28 08:50:28',1,1),(12,'test','2023-12-28 08:50:49',1,1),(13,'test','2023-12-28 08:52:06',1,1),(14,'888888','2023-12-28 16:00:00',1,5),(15,'123432234','2023-12-28 16:00:00',1,3),(16,'可','2024-04-17 16:00:00',1,1),(17,'不错','2024-05-27 16:00:00',1,1);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `rid` int NOT NULL,
  `roleName` varchar(30) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (0,'普通用户'),(1,'管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tSurplus` int NOT NULL,
  `tPrice` double NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,233,49.8),(2,422,88.8),(3,500,50),(4,200,40),(5,200,38.8);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `money` double DEFAULT '0',
  `rid` int DEFAULT '0',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'gy','1111','12345@qq.com',999541.9999999999,1),(2,'jj','123456','520@qq.com',0,0),(3,'yu','1234','564@qq.com',100,0),(4,'zjh','1234','123@qq.com',0,0),(5,'test','test','1111',111111,1),(6,'cx','1234','yguo7136@gmail.com',0,0),(8,'guo','1234','23996@qq.com',0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-28 20:27:54
