/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.25 : Database - student_control
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student_control` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `student_control`;

/*Table structure for table `admin_info` */

DROP TABLE IF EXISTS `admin_info`;

CREATE TABLE `admin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(16) DEFAULT NULL,
  `admin_password` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `admin_info` */

insert  into `admin_info`(`id`,`admin_name`,`admin_password`) values (5,'张老师','123'),(6,'admin','admin');

/*Table structure for table `health_info` */

DROP TABLE IF EXISTS `health_info`;

CREATE TABLE `health_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `heat` varchar(16) DEFAULT NULL COMMENT '体温',
  `fever` int(1) DEFAULT '0' COMMENT '是否发热 0 未发热 1发热',
  `times` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `health_info` */

insert  into `health_info`(`id`,`student_id`,`heat`,`fever`,`times`) values (12,20200531,'11',0,'2020-05-31');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_name` varchar(255) DEFAULT '',
  `role_id` int(11) DEFAULT NULL COMMENT '作者id',
  `create_time` datetime DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`news_name`,`role_id`,`create_time`,`content`) values (5,'疫情防控 人人有责',6,'2020-06-30 13:37:40','　疫情爆发初期，及时出台各项严格防疫措施是必要的，这可以最大限度控制疫情蔓延。但同时，严格的防疫措施也给人们生活带来不便，增加了巨大的社会成本，一定程度上影响了经济社会发展。好在如今成效初显，越来越多的省份确诊病例和疑似病例零报告，一些省份下调了应急响应级别，复产复工在各地积极有序开展，人们开始逐步恢复生产生活秩序。相应的，部分地区防控措施也开始放宽。\r\n\r\n　　防控措施放宽，自我保护不能放宽。27日的数据已经敲响警钟，放宽相关措施是根据疫情防控形势和社会经济发展做出的必要选择，但不能因此而放松警惕，相反，更要增强个人防护，不给病毒可乘之机。');

/*Table structure for table `person_flow` */

DROP TABLE IF EXISTS `person_flow`;

CREATE TABLE `person_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `canteen` varchar(16) DEFAULT NULL COMMENT '食堂人流量',
  `bath` varchar(16) DEFAULT NULL COMMENT '澡堂',
  `library` varchar(16) DEFAULT NULL COMMENT '图书馆',
  `study_room` varchar(16) DEFAULT NULL COMMENT '自习室',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person_flow` */


/*Table structure for table `posts` */
DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `goods` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `odd_number` varchar(255) DEFAULT NULL COMMENT '单号',
  `dispose` int(1) DEFAULT '0' COMMENT '是否处理 0 未处理 1已处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `posts` */
insert  into `posts`(`id`,`student_id`,`goods`,`address`,`odd_number`,`dispose`) values (4,20200630,'书籍 12-434-3','北京市望京大厦1-15','444555527777',1);

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `goods` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `purchase` */

insert  into `purchase`(`id`,`student_id`,`goods`,`time`) values (5,20200630,'矿泉水 4','2020-06-30 12:13:08');

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `student_num` varchar(32) DEFAULT NULL COMMENT '学号',
  `password` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `student_info` */

insert  into `student_info`(`id`,`name`,`student_num`,`password`) values (4,'褚建','123','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
