-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 3.112.4.66    Database: clothing
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('C01','clothing'),('C02','home-decor'),('C03','accessory'),('C04','outdoor');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'http://anh111'),(2,'http://anh222'),(3,'http://anh333'),(4,'http://anh444'),(5,'http://anh555'),(6,'http://anh666'),(7,'http://anh777');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_price` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `num_stock` int NOT NULL,
  `price` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `style` varchar(255) DEFAULT NULL,
  `category_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('CT001','http://anh1','Nike','Blue,Red','A Morden cotton t-shirt',54.99,'T-Shirt',0,59.99,'M,L,XXL',_binary '\0','Morden','C01'),('CT002','http://anh2','Levi\'s','Black,Green','Streetwear jeans with stretch fabric',39.99,'Jeans',0,49.99,'L',_binary '\0','Streetwear','C01'),('CT003','http://anh3','The North Face','Red,Blue,Yellow','Lightweight jacket perfect for autumn',59.99,'Jacket',0,79.99,'XL',_binary '\0','Colorful','C01'),('CT004','http://anh4','Zara','Grey','Wool blend sweater for colder days',49.99,'Sweater',0,59.99,'S,M,L',_binary '\0','Morden','C01'),('CT005','http://anh5','Gucci','Red,Blue,Yellow','Elegant evening dress',69.99,'Dress',0,89.99,'M,L,XL',_binary '\0','Vintage','C01'),('CT006','http://anh6','Adidas','Black,White','Cotton shorts with adjustable waistband',84.99,'Shorts',0,89.99,'M,XL',_binary '\0','Morden','C01'),('CT007','http://anh7','H&M','Red,Blue,Yellow','Pleated skirt perfect for office wear',39.99,'Skirt',0,109.99,'L,XL',_binary '\0','Vintage','C01'),('CT008','http://anh8','Chanel','White','Silk blouse with floral print',44.99,'Blouse',0,49.99,'S,M',_binary '\0','Morden','C01'),('CT009','http://anh9','Puma','Red,Blue,Yellow','Comfortable hoodie with a front pocket',49.99,'Hoodie',0,59.99,'M',_binary '\0','Morden','C01'),('CT010','http://anh10','Dolce & Gabbana','Red,Green,Blue','Chic jumpsuit for evening outings',54.99,'Jumpsuit',0,69.99,'M,XXL',_binary '\0','Bohemian','C01');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `product_id` varchar(255) NOT NULL,
  `image_id` int NOT NULL,
  KEY `FKbhddxsl8axd5io2wgkcoealn5` (`image_id`),
  KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`),
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKbhddxsl8axd5io2wgkcoealn5` FOREIGN KEY (`image_id`) REFERENCES `image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES ('CT001',1),('CT001',2),('CT002',2),('CT002',3),('CT003',3),('CT003',4),('CT004',4),('CT004',5),('CT005',1),('CT005',2),('CT005',3),('CT006',1),('CT006',5),('CT007',1),('CT008',6),('CT008',6),('CT009',1),('CT009',6),('CT010',1),('CT010',6);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-28 16:16:44
