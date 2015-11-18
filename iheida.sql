/*
SQLyog v10.2 
MySQL - 5.5.17 : Database - iheida
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`iheida` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `iheida`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`password`) values (1,'admin','admin');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `student_id` varchar(40) NOT NULL,
  `state` int(11) NOT NULL,
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `event_name` varchar(100) NOT NULL,
  `community_name` varchar(100) DEFAULT NULL,
  `event_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`student_id`,`state`,`publish_time`,`event_name`,`community_name`,`event_content`) values (85,'小飞','20138686',0,'2015-06-30 20:54:21','书上','书上社团','wadsadfeawdadawd'),(86,'飞飞','20138888',0,'2015-06-17 20:13:43','天假','打我还带我','dwadadawsda'),(87,'小飞','20136666',0,'2015-06-17 20:13:44','约会','awdawd','wdadawdawdaw'),(88,'xiaofei','20135555',0,'2015-06-17 20:13:44','书上','约会','dawcaszxcz'),(89,'xiaofei','20138686',0,'2015-06-02 20:48:55','拷打','书上社团','dwadawcdefdhftghwasd'),(90,'xiaofei','20138686',0,'2015-06-17 20:13:46','约会','约会','dawdawzdcvdfgvsdwadaw'),(91,'1213','12313',0,'2015-06-17 20:13:48','41231','32131','321313'),(92,'454','54654',0,'2015-06-17 20:13:48','545','32131','2313'),(93,'rwer','rwrewr',0,'2015-06-17 20:13:49',' ewrrwe','rwerew','rewrwerwer'),(94,'rwerwer','rwrwer',0,'2015-06-17 20:13:49','rwr','rwrwer','rewrwer'),(95,'rwrewr','rwrwer',0,'2015-06-17 20:13:50','rwrwer','rwerwe','rwerwe'),(96,'rwerew','rewr',0,'2015-06-17 20:13:50','rwr','rwrew','rwerwrwererwer'),(97,'rwerwer','rwerwer',0,'2015-06-17 20:13:50','rwerwer','rwerwer','rewrwerwer'),(98,'rewrwer','rwerwe',0,'2015-06-17 20:13:51','rewrw','rwerwe','rwrwerwe'),(100,'dwadawd','adawdawd',0,'2015-06-01 13:12:32','dawdawd','dawdawd','adawdawdwad'),(101,'awdawdawd','awdawdawd',0,'2015-06-01 13:12:59','dawdawd','adawdawd','awdawdawdawd'),(102,'awdawdawd','awdawdawdw',0,'2015-06-05 11:41:04','dawdawdaw','awdawdawdaw','dawdawdawdawdawd'),(103,'dawdawdaw','dawdawd',1,'2015-06-05 10:04:33','dawdawdaw','dawdawd','awdawdwadwad'),(104,'dawdawd','dawdawd',1,'2015-06-05 10:04:34','dawdaw','dawdaw','dawdawd'),(105,'dawdawd','dawdawd',1,'2015-06-05 10:05:59','dawdaw','dawdaw','dawdawd'),(106,'dawdawd','dawdawd',0,'2015-06-01 16:14:26','dawdaw','dawdaw','dawdawd'),(107,'dawdawd','dawdawd',0,'2015-06-01 16:14:26','dawdaw','dawdaw','dawdawd'),(108,'dawdawd','dawdawd',0,'2015-06-01 16:14:26','dawdaw','dawdaw','dawdawd'),(110,'dawdaw','adwad',0,'2015-06-01 16:14:40','dawdaw','dwadaw','dawdawd'),(111,'adawd','awdaw',0,'2015-06-01 16:14:58','dawdawd','dawdawd','awdawdawdawdaw'),(112,'awdawd','dawdawd',0,'2015-06-01 16:15:07','dawdawdwa','dawdawd','awdaw'),(113,'dawdawd','dawdaw',0,'2015-06-01 16:15:14','dawdawd','dawdawd','awdawdawdwa'),(115,'dawdawd','dawdawd',0,'2015-06-01 16:15:31','dawdawd','dawdawd','awdawdawdwa'),(116,'dawdawd','dawdawd',0,'2015-06-01 16:15:39','dawdawd','awdaw','dawdawdaw'),(117,'dawdawd','awdawd',0,'2015-06-01 16:15:47','awdawdawd','dawdawd','awdawdawdaw'),(118,'ddwad','ddd',0,'2015-06-01 16:15:54','dawdawd','ddd','dwadawdawd'),(119,'dawdawd','awdawdaw',0,'2015-06-01 16:16:02','dawdawdaw','adwdawdaw','wadwadawd'),(120,'dawdawd','awdawdaw',0,'2015-06-01 16:16:19','dawd','awdawd','dawdawdawdawd'),(121,'dawdawdw','dawdawdwa',0,'2015-06-01 16:16:27','dawdawdwa','dwadawdawd','awdawdawdawd'),(122,'dwadawdawd','awdawdawdaw',0,'2015-06-01 16:16:37','dawdawdawd','awdawdawdaw','awdawdawdawdawdawd'),(123,'dwadawdaw','dawdawdaw',0,'2015-06-01 16:16:45','dawdawdaw','awdawdawd','awdawdawdawdaw'),(124,'awdawdwad','awdwadwad',0,'2015-06-01 16:16:53','dawdawdwa','dwadwadwad','dawdawdawdawd'),(125,'dawdawdwa','dawdwa',0,'2015-06-01 16:17:01','dawdawdwad','wadawdwad','awdawdawdwa'),(126,'ddawd','adwwadwa',0,'2015-06-01 16:17:10','awdawdaw','awdwad','wadawdawd'),(127,'awdawdaw','dawdawd',0,'2015-06-01 16:17:18','dawdawdawd','dwadawd','wadawdawdawd'),(128,'dwadawd','adawdaw',0,'2015-06-01 16:17:25','dawdawdaw','dwadaw','wadeawdwadaw'),(129,'dawdawd','dawdawd',0,'2015-06-01 16:17:32','awdawdaw','dawdawd','awdawdawdawdaw'),(130,'dawdawd','dawdawd',0,'2015-06-01 16:17:39','dawdwadaw','wdawdawd','awdawdwadawdaw'),(133,'awdawdwa','dawdawdawd',0,'2015-06-01 16:18:13','dawdawdwa','awdawdaw','dwadawdawdaw'),(134,'dwadaw','dwadwad',0,'2015-06-01 16:18:20','dwadawd','awdawdwa','dwadawdwa'),(136,'awdawd','awdawd',0,'2015-06-01 16:18:35','dwadawd','dawdwad','dawdawdaw'),(137,'dwadwa','dawdaw',0,'2015-06-01 16:18:44','dwadaw','打我还带我','dawdawd'),(138,'飞飞','20135555',0,'2015-06-01 16:18:54','约会','awdawd','dwadawdwa'),(139,'小飞','20135555',0,'2015-06-01 16:19:05','约会','书上社团','dwadawdaw'),(140,'飞飞','15612',0,'2015-06-01 16:19:23','约会','书上社团','dadaadadaaaa'),(142,'xiaofei','20135555',0,'2015-06-02 17:19:52','飞飞','书上社团','达瓦达瓦达瓦大'),(143,'飞飞','20135555',0,'2015-06-02 17:30:36','飞飞','书上社团',' '),(145,'dwad','dwad',0,'2015-06-02 20:48:42','拷打','wadwad','awdwadwadaw'),(147,'123','123',0,'2015-06-03 20:03:04','123','123','大家今晚真的骄傲泪呀呀呀呀呀呀相互吻合度哇好多'),(148,'esfse','fsef',0,'2015-06-04 18:35:00','sefse','fesf','fsefse'),(149,'俞常爽','20132430',1,'2015-06-04 18:43:50','信管创业基地','信管创业基地','信管创业基地'),(150,'梁洪超','20144645',0,'2015-06-04 18:50:17','5249756','8888','基里连科KTV搜去高数睡吧'),(151,'刘艳云','20134622',0,'2015-06-04 18:50:46','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(152,'刘艳云','20134622',0,'2015-06-04 18:50:46','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(153,'刘艳云','20134622',0,'2015-06-04 18:50:47','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(154,'刘艳云','20134622',0,'2015-06-04 18:50:56','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(155,'刘艳云','20134622',0,'2015-06-04 18:50:56','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(156,'刘艳云','20134622',0,'2015-06-04 18:50:56','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(157,'刘艳云','20134622',0,'2015-06-04 18:50:56','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(158,'刘艳云','20134622',0,'2015-06-04 18:51:03','我要吃饭','信管基地','想吃锅包肉，鱼香肉丝，寿司，水煮鱼。'),(159,'没流量了','20144475',0,'2015-06-04 18:51:07','图图','黑大',''),(160,'','',0,'2015-06-04 18:51:07','','',''),(161,'。。。','5556464',0,'2015-06-04 18:51:50','高数','赶紧','。。。。明年高数叫'),(162,'zxcv','zxcv',0,'2015-06-04 20:47:12','xzcv','zx','cv'),(163,'  asdfas','adsf',0,'2015-06-04 20:51:01','sdf','sdfa','sdf'),(164,'dsef','dawda',0,'2015-06-05 10:00:17','dwad','dwadaw','awdawd'),(165,'vfd','vgfd',0,'2015-06-30 20:52:13','frg','fdgc','fdcv'),(166,'j\'b\'j\'h','你b',0,'2015-06-30 20:54:00','基本货币','不回家','不会吧');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
