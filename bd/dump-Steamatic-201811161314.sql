-- MySQL dump 10.16  Distrib 10.2.18-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: Steamatic
-- ------------------------------------------------------
-- Server version	10.2.18-MariaDB

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
-- Table structure for table `Almacen`
--
Create database Steamatic;
use Steamatic
DROP TABLE IF EXISTS `Almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Almacen` (
  `Id_Empleado` bigint(20) DEFAULT NULL,
  `Id_Articulo` bigint(20) NOT NULL AUTO_INCREMENT,
  `Articulo` varchar(50) DEFAULT NULL,
  `Fecha_Registro` datetime DEFAULT NULL,
  `Unidad_Medida` decimal(10,2) DEFAULT NULL,
  `Stock_minimo` int(11) DEFAULT NULL,
  `Stock_Actual` int(11) DEFAULT NULL,
  `Costo_Promedio` float DEFAULT NULL,
  `Existencia` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`Id_Articulo`),
  KEY `Id_Empleado` (`Id_Empleado`),
  CONSTRAINT `Almacen_ibfk_1` FOREIGN KEY (`Id_Empleado`) REFERENCES `Empleado` (`Id_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Almacen`
--

LOCK TABLES `Almacen` WRITE;
/*!40000 ALTER TABLE `Almacen` DISABLE KEYS */;
INSERT INTO `Almacen` VALUES (5,2,'Maquina 8100','2018-05-06 00:00:00',1.00,2,6,30000,'si');
/*!40000 ALTER TABLE `Almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compras`
--

DROP TABLE IF EXISTS `Compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Compras` (
  `Id_Empleado` bigint(20) DEFAULT NULL,
  `Id_compras` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(50) DEFAULT NULL,
  `Nombre_Producto` varchar(50) DEFAULT NULL,
  `RFC` varchar(20) DEFAULT NULL,
  `Tipo_Producto` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Cantidad` float DEFAULT NULL,
  `Concepto` varchar(30) DEFAULT NULL,
  `Fecha_Compra` datetime DEFAULT NULL,
  `Costo_Real` float DEFAULT NULL,
  PRIMARY KEY (`Id_compras`),
  KEY `Id_Empleado` (`Id_Empleado`),
  CONSTRAINT `Compras_ibfk_1` FOREIGN KEY (`Id_Empleado`) REFERENCES `Empleado` (`Id_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compras`
--

LOCK TABLES `Compras` WRITE;
/*!40000 ALTER TABLE `Compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `Compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Control_Ventas`
--

DROP TABLE IF EXISTS `Control_Ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Control_Ventas` (
  `Id_Venta` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Empleado` bigint(20) DEFAULT NULL,
  `Nombre_Vendedor` varchar(40) DEFAULT NULL,
  `Tipo_Servicio` varchar(15) DEFAULT NULL,
  `Empleado_Operaciones` varchar(50) DEFAULT NULL,
  `Observaciones` varchar(100) DEFAULT NULL,
  `Impuesto` decimal(8,2) DEFAULT NULL,
  `Costo_Total` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`Id_Venta`),
  KEY `Id_Empleado` (`Id_Empleado`),
  CONSTRAINT `Control_Ventas_ibfk_1` FOREIGN KEY (`Id_Empleado`) REFERENCES `Empleado` (`Id_Empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Control_Ventas`
--

LOCK TABLES `Control_Ventas` WRITE;
/*!40000 ALTER TABLE `Control_Ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Control_Ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Devolucion`
--

DROP TABLE IF EXISTS `Devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Devolucion` (
  `Id_Operaciones` int(11) DEFAULT NULL,
  `Id_Articulo` bigint(20) DEFAULT NULL,
  `Fecha_Salida` datetime DEFAULT NULL,
  `Fecha_Entrada` datetime DEFAULT NULL,
  `Articulo_Devuelto` varchar(50) DEFAULT NULL,
  `Total_Devuelto` int(11) DEFAULT NULL,
  KEY `Id_Articulo` (`Id_Articulo`),
  KEY `Devolucion_Operaciones_FK` (`Id_Operaciones`),
  CONSTRAINT `Devolucion_Operaciones_FK` FOREIGN KEY (`Id_Operaciones`) REFERENCES `Operaciones` (`Id_Operaciones`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Devolucion_ibfk_2` FOREIGN KEY (`Id_Articulo`) REFERENCES `Almacen` (`Id_Articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Devolucion`
--

LOCK TABLES `Devolucion` WRITE;
/*!40000 ALTER TABLE `Devolucion` DISABLE KEYS */;
INSERT INTO `Devolucion` VALUES (1,2,'2018-11-01 00:00:00','2018-11-12 00:00:00','',3);
/*!40000 ALTER TABLE `Devolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Empleado` (
  `Id_Empleado` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(25) DEFAULT NULL,
  `Apellido_Paterno` varchar(20) DEFAULT NULL,
  `Apellido_Materno` varchar(20) DEFAULT NULL,
  `Organismo` varchar(40) DEFAULT NULL,
  `Sexo` varchar(10) DEFAULT NULL,
  `Estado_Civil` varchar(10) DEFAULT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  `Direccion` varchar(70) DEFAULT NULL,
  `Puesto` varchar(30) DEFAULT NULL,
  `estatus` int(11) DEFAULT 1,
  PRIMARY KEY (`Id_Empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES (4,'Martha','Mora','Rico','Grupo AHI Personel Mexico','Mujer','Soltera','1991-09-01','San lucas N 89 Col El Recreo Del Azcapotzalco','Compras',1),(5,'Amanda','Fuentes','Hernandez','Grupo AHI Personel Mexico','Mujer','Soltera','1985-06-29','Agapando 35 Brisas de Cuautla Morelos','Ventas',1),(6,'Amanda','Fuentes','Hernandez','Grupo AHI Personel Mexico','Mujer','Soltera','1985-06-29','Agapando 35 Brisas de Cuautla Morelos','Ventas',1),(7,'Amanda','Fuentes','Hernandez','Grupo AHI Personel Mexico','Mujer','Soltera','1985-06-29','Agapando 35 Brisas de Cuautla Morelos','Ventas',1),(8,'Amanda','Fuentes','Hernandez','Grupo AHI Personel Mexico','Mujer','Soltera','1985-06-29','Agapando 35 Brisas de Cuautla Morelos','Ventas',1),(9,'a','a','a','a','Item 1','Item 1','2018-11-02','a','a',0),(10,'ccc','h','h','h','Item 1','Item 1','2018-11-01','a','h',0),(11,'a','a','a','a','Item 1','Item 1','2018-11-04','a','a',0),(12,'h','q','q','q','Item 1','Item 1','2018-11-11','q','q',0),(13,' aasssaas',' sasa',' asasasa',' asas','Hombre','Soltero(a)','2018-11-04','asssssssssasasasasasssssssssasasa',' asassssssssas',0),(14,' ',' ',' ',' ','Hombre','Soltero(a)','2018-11-02','',' ',0),(15,'z','z','z','z','Hombre','Soltero(a)','2018-11-17','z','z',1);
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operaciones`
--

DROP TABLE IF EXISTS `Operaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operaciones` (
  `Id_Operaciones` int(11) NOT NULL AUTO_INCREMENT,
  `Empleado_Operaciones` varchar(30) DEFAULT NULL,
  `Apellidos` varchar(40) DEFAULT NULL,
  `Puesto` varchar(30) DEFAULT NULL,
  `Servicios_Programados` varchar(50) DEFAULT NULL,
  `Servicios_Realizado` int(11) NOT NULL,
  `Tiempo_Promedio` int(11) NOT NULL,
  `Costo_Servicio` float DEFAULT NULL,
  PRIMARY KEY (`Id_Operaciones`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operaciones`
--

LOCK TABLES `Operaciones` WRITE;
/*!40000 ALTER TABLE `Operaciones` DISABLE KEYS */;
INSERT INTO `Operaciones` VALUES (1,'Daniel Damaso','Garcia Avila','Operador','Atlas Copco',3,5,24500);
/*!40000 ALTER TABLE `Operaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedores`
--

DROP TABLE IF EXISTS `Proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedores` (
  `Id_Proveedores` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Proveedor` varchar(50) DEFAULT NULL,
  `Codigo` int(11) DEFAULT NULL,
  `RFC` varchar(25) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `E_Mail` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_Proveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedores`
--

LOCK TABLES `Proveedores` WRITE;
/*!40000 ALTER TABLE `Proveedores` DISABLE KEYS */;
INSERT INTO `Proveedores` VALUES (1,'Electric System Mexico',253648,'ESM253689','Jazmin 101 Fresnos Apodaca Nuevo Le�n 6663 M�xico',24896578,'more@Energy.com.mx');
/*!40000 ALTER TABLE `Proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Salidas`
--

DROP TABLE IF EXISTS `Salidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Salidas` (
  `Id_Operaciones` int(11) DEFAULT NULL,
  `Id_Articulo` bigint(20) DEFAULT NULL,
  `Fecha_Salida` datetime DEFAULT NULL,
  `Fecha_Servicio` datetime DEFAULT NULL,
  `Empleado_Operaciones` varchar(50) DEFAULT NULL,
  `Servicio` varchar(50) DEFAULT NULL,
  `Articulos_Entregados` varchar(50) DEFAULT NULL,
  `Total_Entregados` int(11) DEFAULT NULL,
  KEY `Id_Articulo` (`Id_Articulo`),
  KEY `Salidas_Operaciones_FK` (`Id_Operaciones`),
  CONSTRAINT `Salidas_Operaciones_FK` FOREIGN KEY (`Id_Operaciones`) REFERENCES `Operaciones` (`Id_Operaciones`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `Salidas_ibfk_2` FOREIGN KEY (`Id_Articulo`) REFERENCES `Almacen` (`Id_Articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Salidas`
--

LOCK TABLES `Salidas` WRITE;
/*!40000 ALTER TABLE `Salidas` DISABLE KEYS */;
INSERT INTO `Salidas` VALUES (1,2,'2018-11-01 00:00:00','2018-11-05 00:00:00','Daniel Garcia Avila','Dupont','Maquina de Lavado y Pulidora + Quimico Industrial',3);
/*!40000 ALTER TABLE `Salidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `Id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(25) DEFAULT NULL,
  `pwd` longtext DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  `id_empleado` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `id_empleado` (`id_empleado`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `Empleado` (`Id_Empleado`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','123',1,4);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'Steamatic'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-16 13:14:58
