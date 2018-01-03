-- phpMyAdmin SQL Dump
-- version 2.11.2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 03, 2018 at 08:04 AM
-- Server version: 5.0.45
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `official_address`
--

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL auto_increment,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` int(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `fname`, `lname`, `address`, `phone`, `email`, `visible`) VALUES
(1, 'Lewis', 'Macklemore', 'abc road 124 anothonio boulevard', 23444, 'abc@gmail.com', 0),
(3, 'parker', 'Scott', 'Bank Stark street', 0, 'mandem@gmail.com', 0),
(5, 'Sadio', 'Mane', '125 Liverpool road', 902384, 'mane@lfc.com', 0),
(6, 'bambam', 'Chapo', '3/4 festival City Drive', 12345, 'b.chappy@hotmail.com', 1),
(7, 'Barkley', 'Charles', 'Rotary Street V.I', 1234567, 'barkley@fly.com ', 1),
(8, 'markabee', 'scott', 'pandelic road', 1234567, 'mark@contact.com', 1);
