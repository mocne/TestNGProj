/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.14 : Database - pkf_useful
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pkf_useful` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pkf_useful`;

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(10) unsigned DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `QQ` varchar(20) DEFAULT NULL,
  `wechat` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `phone` (`phone`),
  KEY `QQ` (`QQ`),
  KEY `wechat` (`wechat`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`name`,`age`,`sex`,`phone`,`address`,`QQ`,`wechat`) values (1000,'test1',13,1,'18244440000','杭州市西湖区华星路96号互联网金融大厦11层','917500000','5211314'),(1001,'test2',15,0,'18244440001','杭州市西湖区华星路96号互联网金融大厦10层','917500001','52113141');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
