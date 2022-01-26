-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 26, 2020 at 11:39 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id14014428_hotelres`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_reg`
--

CREATE TABLE `admin_reg` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phn` int(13) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin_reg`
--

INSERT INTO `admin_reg` (`id`, `name`, `phn`, `email`, `pass`) VALUES
(0, 'a', 1511, 'a@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(11) NOT NULL,
  `cui` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dis` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `cui`, `dis`) VALUES
(1, 'Indian', 'Biryani');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `img` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `hotel_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `rating` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `contact_us` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `img`, `hotel_name`, `description`, `address`, `rating`, `contact_us`) VALUES
(1, 'https://bookyourownroom.000webhostapp.com/all_api/img/kolkata/hyatt.jpg', 'Hyatt Regency ', 'Centrally Located 5 Star Hotel Near Salt lake Stadium in Kolkata for Business or Leisure Travel\r\nExperience luxury at Hyatt Regency Kolkata, one of the finest 5 star business hotels in Salt Lake, Kolkata (Calcutta). This Kolkata hotel is just 15 minutes\' drive from the Kolkata Int\'l airport and IT corridor of Kolkata. The location of the hotel makes it the most convenient hotel for business & leisure travele', 'Hyatt Regency, JA Block, Sector III, Bidhannagar, Kolkata, West Bengal', 'https://bookyourownroom.000webhostapp.com/all_api/rating/four.png', '+91 3368201234');

-- --------------------------------------------------------

--
-- Table structure for table `room_book`
--

CREATE TABLE `room_book` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phn` int(13) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `price` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `checkin` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `checkout` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `room_book`
--

INSERT INTO `room_book` (`id`, `user_id`, `name`, `phn`, `email`, `type`, `price`, `checkin`, `checkout`) VALUES
(1, 1, 'asadas', 44946164, 'xsaxaa', 'Hyatt Single Room', 'Rs. 9,000', '24/6/2020', '24/6/2020'),
(2, 1, 'zczczxccacascdds', 465465, 'casas', 'Hyatt Deluxe Room', 'Rs. 9,500', '1/7/2020', '2/7/2020'),
(3, 1, 'zczczxccacascdds', 465465, 'casas', 'Hyatt Deluxe Room', 'Rs. 9,500', '1/7/2020', '2/7/2020'),
(4, 1, 'anutam', 11111111, 'a@gmail.com', 'Hyatt Deluxe Room', 'Rs. 9,500', '1/7/2020', '2/7/2020'),
(5, 1, 'Rajdeep', 618486684, 'shahw@sjsjs.com', 'Hilton Deluxe Room', 'Rs. 9,500', '24/7/2020', '29/7/2020');

-- --------------------------------------------------------

--
-- Table structure for table `user_reg`
--

CREATE TABLE `user_reg` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phn` int(13) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_reg`
--

INSERT INTO `user_reg` (`id`, `name`, `phn`, `email`, `pass`) VALUES
(1, 'anutam', 987456321, 'a@gmail.com', '123'),
(2, 'shsjwj', 19494646, 'shshs@wjjs.xlx', 'ajsjejsh'),
(3, 'Rajdeep', 618486684, 'shahw@sjsjs.com', 'wkans123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_reg`
--
ALTER TABLE `admin_reg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room_book`
--
ALTER TABLE `room_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_reg`
--
ALTER TABLE `user_reg`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `room_book`
--
ALTER TABLE `room_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_reg`
--
ALTER TABLE `user_reg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
