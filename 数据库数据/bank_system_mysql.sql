/*
SQLyog Ultimate v8.32 
MySQL - 8.0.16 : Database - bank_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bank_system`;

/*Table structure for table `message1` */

DROP TABLE IF EXISTS `message1`;

CREATE TABLE `message1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_type` char(20) NOT NULL,
  `bank_card` varchar(20) NOT NULL,
  `id_card` varchar(20) NOT NULL,
  `balance` double DEFAULT '0',
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bank_card` (`bank_card`),
  UNIQUE KEY `id_card` (`id_card`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `message1` */

insert  into `message1`(`id`,`name`,`password`,`user_type`,`bank_card`,`id_card`,`balance`,`phone_number`) values (1,'张三','123456','普通用户','622821 2299030126666','549854545894231',400,'10086'),(7,'李四','123456','普通用户','622821 2299030125369','1111111',500,'1111111'),(8,'王五','123456','普通用户','622821 2299030129250','555555555',1500,'245114714'),(13,'老六','123456','管理员','6924','23456531',0,'15615313');

/*Table structure for table `message2` */

DROP TABLE IF EXISTS `message2`;

CREATE TABLE `message2` (
  `number` int(11) NOT NULL,
  `transfer` varchar(20) NOT NULL,
  `amount` double NOT NULL,
  `type` char(20) NOT NULL,
  `Collection` varchar(20) NOT NULL,
  `datatime` datetime NOT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `NewIndex1` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `message2` */

insert  into `message2`(`number`,`transfer`,`amount`,`type`,`Collection`,`datatime`,`id`) values (1,'张三',100,'+','张三','2022-05-07 10:52:29',1),(1,'张三',100,'-','张三','2022-05-07 10:53:21',2),(1,'张三',500,'-','李四','2022-05-07 10:53:57',3),(7,'李四',500,'+','张三','2022-05-07 10:53:57',4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
