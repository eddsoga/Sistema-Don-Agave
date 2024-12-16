-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: donagave
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gastos` (
  `idGasto` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `proveedor` varchar(100) NOT NULL,
  `tipoActividad` varchar(255) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `descripcion` text,
  `montoTotal` double NOT NULL,
  PRIMARY KEY (`idGasto`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (1,'2024-12-12','Caja','Pagos','Transferencia','prueba gastos',100),(52,'2024-12-01','Caja','Compra','Efectivo','Compra de agave para producción',5000),(53,'2024-12-02','Bolsa','Compra','Transferencia','Adquisición de botellas',2500.5),(54,'2024-12-03','Caja','Pagos','Cheque','Pago de servicios de limpieza',1200),(55,'2024-12-04','Bolsa','Pagos','Efectivo','Pago a proveedor de etiquetas',450.75),(56,'2024-12-05','Caja','Compra','Transferencia','Compra de cajas para empaque',1800),(57,'2024-12-06','Bolsa','Pagos','Efectivo','Pago de mantenimiento de maquinaria',3200),(58,'2024-12-07','Caja','Compra','Cheque','Adquisición de materia prima',4100),(59,'2024-12-08','Bolsa','Pagos','Transferencia','Pago por diseño gráfico de etiquetas',1500),(60,'2024-12-09','Caja','Compra','Efectivo','Compra de insumos para el taller',950),(61,'2024-12-10','Bolsa','Pagos','Cheque','Pago de servicios de transporte',2200),(62,'2024-12-01','Caja','Compra','Efectivo','Compra de agave para producción',5000),(63,'2024-12-02','Bolsa','Compra','Transferencia','Adquisición de botellas',2500.5),(64,'2024-12-03','Caja','Pagos','Cheque','Pago de servicios de limpieza',1200),(65,'2024-12-04','Bolsa','Pagos','Efectivo','Pago a proveedor de etiquetas',450.75),(66,'2024-12-05','Caja','Compra','Transferencia','Compra de cajas para empaque',1800),(67,'2024-12-06','Bolsa','Pagos','Efectivo','Pago de mantenimiento de maquinaria',3200),(68,'2024-12-07','Caja','Compra','Cheque','Adquisición de materia prima',4100),(69,'2024-12-08','Bolsa','Pagos','Transferencia','Pago por diseño gráfico de etiquetas',1500),(70,'2024-12-09','Caja','Compra','Efectivo','Compra de insumos para el taller',950),(71,'2024-12-10','Bolsa','Pagos','Cheque','Pago de servicios de transporte',2200),(72,'2024-12-01','Caja','Compra','Efectivo','Compra de agave para producción',5000),(73,'2024-12-02','Bolsa','Compra','Transferencia','Adquisición de botellas',2500.5),(74,'2024-12-03','Caja','Pagos','Cheque','Pago de servicios de limpieza',1200),(75,'2024-12-04','Bolsa','Pagos','Efectivo','Pago a proveedor de etiquetas',450.75),(76,'2024-12-05','Caja','Compra','Transferencia','Compra de cajas para empaque',1800),(77,'2024-12-06','Bolsa','Pagos','Efectivo','Pago de mantenimiento de maquinaria',3200),(78,'2024-12-07','Caja','Compra','Cheque','Adquisición de materia prima',4100),(79,'2024-12-08','Bolsa','Pagos','Transferencia','Pago por diseño gráfico de etiquetas',1500),(80,'2024-12-09','Caja','Compra','Efectivo','Compra de insumos para el taller',950),(81,'2024-12-10','Bolsa','Pagos','Cheque','Pago de servicios de transporte',2200),(82,'2024-12-01','Caja','Compra','Efectivo','Compra de agave para producción',5000),(83,'2024-12-02','Bolsa','Compra','Transferencia','Adquisición de botellas',2500.5),(84,'2024-12-03','Caja','Pagos','Cheque','Pago de servicios de limpieza',1200),(85,'2024-12-04','Bolsa','Pagos','Efectivo','Pago a proveedor de etiquetas',450.75),(86,'2024-12-05','Caja','Compra','Transferencia','Compra de cajas para empaque',1800),(87,'2024-12-06','Bolsa','Pagos','Efectivo','Pago de mantenimiento de maquinaria',3200),(88,'2024-12-07','Caja','Compra','Cheque','Adquisición de materia prima',4100),(89,'2024-12-08','Bolsa','Pagos','Transferencia','Pago por diseño gráfico de etiquetas',1500),(90,'2024-12-09','Caja','Compra','Efectivo','Compra de insumos para el taller',950),(91,'2024-12-10','Bolsa','Pagos','Cheque','Pago de servicios de transporte',2200),(92,'2024-12-01','Caja','Compra','Efectivo','Compra de agave para producción',5000),(93,'2024-12-02','Bolsa','Compra','Transferencia','Adquisición de botellas',2500.5),(94,'2024-12-03','Caja','Pagos','Cheque','Pago de servicios de limpieza',1200),(95,'2024-12-04','Bolsa','Pagos','Efectivo','Pago a proveedor de etiquetas',450.75),(96,'2024-12-05','Caja','Compra','Transferencia','Compra de cajas para empaque',1800),(97,'2024-12-06','Bolsa','Pagos','Efectivo','Pago de mantenimiento de maquinaria',3200),(98,'2024-12-07','Caja','Compra','Cheque','Adquisición de materia prima',4100),(99,'2024-12-08','Bolsa','Pagos','Transferencia','Pago por diseño gráfico de etiquetas',1500),(100,'2024-12-09','Caja','Compra','Efectivo','Compra de insumos para el taller',950),(101,'2024-12-10','Bolsa','Pagos','Cheque','Pago de servicios de transporte',2200);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(100) NOT NULL,
  `tipoProducto` varchar(50) NOT NULL,
  `entrada` int DEFAULT '0',
  `salidas` int DEFAULT '0',
  `existencia` int DEFAULT '0',
  `stockIdeal` int NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Cremita de Mezcal','Mezcal',0,50,0,20,900,1300),(3,'Tequila Don Julio','Bebida',50,10,40,60,400,500),(4,'Tlayuda Tradicional','Comida',30,5,25,40,80,150),(5,'Mezcal Espadín','Mezcal',100,30,70,120,300,450),(6,'Cerveza Artesanal','Bebida',200,50,150,250,30,60),(7,'Mole Oaxaqueño','Comida',20,6,12,30,100,180),(8,'Mezcal Tobalá','Mezcal',50,15,35,50,500,750);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productosventa`
--

DROP TABLE IF EXISTS `productosventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productosventa` (
  `idproductosVenta` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `idVenta` int NOT NULL,
  `cantidad` int NOT NULL,
  `subtotal` double DEFAULT '0',
  PRIMARY KEY (`idproductosVenta`),
  KEY `fk_producto_idx` (`idProducto`),
  KEY `fk_venta_idx` (`idVenta`),
  CONSTRAINT `fk_producto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`),
  CONSTRAINT `fk_venta` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productosventa`
--

LOCK TABLES `productosventa` WRITE;
/*!40000 ALTER TABLE `productosventa` DISABLE KEYS */;
INSERT INTO `productosventa` VALUES (93,1,15,1,1300);
/*!40000 ALTER TABLE `productosventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservasmesas`
--

DROP TABLE IF EXISTS `reservasmesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservasmesas` (
  `idReserva` int NOT NULL AUTO_INCREMENT,
  `fechaReserva` date NOT NULL,
  `horaReserva` time NOT NULL,
  `nombreCliente` varchar(100) NOT NULL,
  `numPersonas` int NOT NULL,
  `lugarAsignada` varchar(50) NOT NULL,
  `estadoReserva` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idReserva`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservasmesas`
--

LOCK TABLES `reservasmesas` WRITE;
/*!40000 ALTER TABLE `reservasmesas` DISABLE KEYS */;
INSERT INTO `reservasmesas` VALUES (1,'2024-12-25','13:00:00','Lalo s',3,'Mesa 1','Pendiente'),(2,'2024-12-10','15:30:00','Jairo',8,'Patio 1','Pendiente'),(3,'2024-12-10','18:22:00','Misael',2,'Baño','Realizada');
/*!40000 ALTER TABLE `reservasmesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'eduardo','eddsoga','Gerente','123'),(2,'jairo','jairo','Gerente','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idVenta` int NOT NULL AUTO_INCREMENT,
  `idUsuario` int NOT NULL,
  `fechaHoraVenta` datetime NOT NULL,
  `montoTotal` double NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `guiaParticular` varchar(100) NOT NULL,
  `estadoVenta` varchar(50) DEFAULT 'Abierta',
  PRIMARY KEY (`idVenta`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (12,1,'2024-12-15 17:54:16',0,'Efectivo','no','Finalizada'),(13,1,'2024-12-15 17:59:31',0,'Efectivo','no','Finalizada'),(14,1,'2024-12-15 18:02:23',0,'Tarjeta','no','En Proceso'),(15,1,'2024-12-16 03:12:14',1300,'Efectivo','no','Finalizada');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 21:47:16
