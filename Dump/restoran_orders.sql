-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: restoran
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `isPaid` tinyint(1) DEFAULT '0',
  `orderDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `id_UNIQUE` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (54,0,'2017-09-05 00:00:00'),(55,0,'2017-09-05 00:11:54'),(56,0,'2017-09-05 01:01:39'),(57,0,'2017-09-05 01:03:19'),(58,0,'2017-09-05 01:20:24'),(59,0,'2017-09-05 01:21:50'),(60,0,'2017-09-05 01:29:00'),(61,0,'2017-09-05 21:46:44'),(62,0,'2017-09-05 21:48:54'),(63,0,'2017-09-05 22:15:57'),(64,0,'2017-09-05 22:17:41'),(65,1,'2017-09-05 22:25:09'),(66,0,'2017-09-05 22:26:52'),(67,0,'2017-09-05 22:27:41'),(68,0,'2017-09-05 23:14:18'),(69,0,'2017-09-06 00:12:10'),(70,0,'2017-09-06 00:13:15'),(71,0,'2017-09-06 00:14:10'),(72,0,'2017-09-06 00:27:44'),(73,0,'2017-09-06 00:30:04'),(74,1,'2017-09-06 03:10:12'),(75,1,'2017-09-06 03:12:06'),(76,1,'2017-09-06 03:31:32'),(77,0,'2017-09-06 03:34:02'),(78,0,'2017-09-06 03:40:04'),(79,1,'2017-09-06 13:40:27'),(80,1,'2017-09-06 13:42:04'),(81,1,'2017-09-06 13:44:43'),(82,1,'2017-09-06 13:45:49'),(83,1,'2017-09-06 13:47:10'),(84,1,'2017-09-06 13:48:19'),(85,1,'2017-09-06 14:24:03');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-06 16:51:51
