-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-05-2018 a las 08:07:21
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `discoteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes2`
--

CREATE TABLE IF NOT EXISTS `clientes2` (
  `DNI_CLIENTE` varchar(9) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  PRIMARY KEY (`DNI_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes2`
--

INSERT INTO `clientes2` (`DNI_CLIENTE`, `FECHA_NACIMIENTO`) VALUES
('12121212A', '1990-05-07'),
('13131313D', '1980-04-04'),
('21212121B', '2018-05-07'),
('31313131C', '1987-03-03'),
('42424242E', '1992-06-06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados2`
--

CREATE TABLE IF NOT EXISTS `empleados2` (
  `DNI_EMPLEADO` varchar(9) NOT NULL,
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDO` varchar(20) NOT NULL,
  `OFICIO` varchar(12) NOT NULL,
  `FECHA_ALTA` date NOT NULL,
  `CONTRASEÑA` varchar(12) NOT NULL,
  PRIMARY KEY (`DNI_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados2`
--

INSERT INTO `empleados2` (`DNI_EMPLEADO`, `NOMBRE`, `APELLIDO`, `OFICIO`, `FECHA_ALTA`, `CONTRASEÑA`) VALUES
('00000000A', 'Pepe', 'Garcia', 'VENDEDOR', '2000-05-01', 'a1a1a1a1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas2`
--

CREATE TABLE IF NOT EXISTS `entradas2` (
  `NUMENTRADA` int(5) NOT NULL,
  `DNIENTRADA` varchar(9) NOT NULL,
  `IDESPECTACULO` int(9) NOT NULL,
  `FECHA` date NOT NULL,
  `VENDEDOR` varchar(9) NOT NULL,
  PRIMARY KEY (`NUMENTRADA`,`IDESPECTACULO`),
  KEY `DNIENTRADA` (`DNIENTRADA`),
  KEY `IDESPECTACULO` (`IDESPECTACULO`),
  KEY `VENDEDOR` (`VENDEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entradas2`
--

INSERT INTO `entradas2` (`NUMENTRADA`, `DNIENTRADA`, `IDESPECTACULO`, `FECHA`, `VENDEDOR`) VALUES
(1, '12121212A', 1, '2018-05-06', '00000000A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `espectaculos2`
--

CREATE TABLE IF NOT EXISTS `espectaculos2` (
  `IDESPECTACULO` int(9) NOT NULL DEFAULT '0',
  `NOMBRE` varchar(20) NOT NULL,
  `FECHA_INICIO` date NOT NULL,
  `FECHA_FIN` date NOT NULL,
  `PRECIO_ENTRADA` decimal(10,0) NOT NULL,
  `AFORO` int(11) NOT NULL,
  PRIMARY KEY (`IDESPECTACULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `espectaculos2`
--

INSERT INTO `espectaculos2` (`IDESPECTACULO`, `NOMBRE`, `FECHA_INICIO`, `FECHA_FIN`, `PRECIO_ENTRADA`, `AFORO`) VALUES
(1, 'rock1', '2019-01-01', '2019-01-02', '20', 200),
(2, 'Pop1', '2018-05-01', '2018-05-02', '50', 200),
(3, 'Hip-Hop', '2018-05-04', '2018-05-05', '35', 200);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parte_horas2`
--

CREATE TABLE IF NOT EXISTS `parte_horas2` (
  `DNI_EMPLEADO` varchar(9) NOT NULL,
  `FECHA` date NOT NULL,
  `HORAS` int(2) NOT NULL,
  `SALARIO` decimal(11,2) NOT NULL,
  PRIMARY KEY (`DNI_EMPLEADO`,`FECHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `parte_horas2`
--

INSERT INTO `parte_horas2` (`DNI_EMPLEADO`, `FECHA`, `HORAS`, `SALARIO`) VALUES
('00000000A', '2018-05-07', 6, '60.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_sala2`
--

CREATE TABLE IF NOT EXISTS `reserva_sala2` (
  `IDESPECTACULO` int(5) NOT NULL,
  `VENDEDOR` varchar(9) NOT NULL,
  `FECHA_INICIO` date NOT NULL,
  `FECHA_FIN` date NOT NULL,
  `PRECIO` decimal(10,0) NOT NULL,
  `DNI_CLIENTE` varchar(9) NOT NULL,
  PRIMARY KEY (`IDESPECTACULO`,`FECHA_INICIO`),
  KEY `VENDEDOR` (`VENDEDOR`),
  KEY `IDESPECTACULO` (`IDESPECTACULO`),
  KEY `DNI_CLIENTE` (`DNI_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva_sala2`
--

INSERT INTO `reserva_sala2` (`IDESPECTACULO`, `VENDEDOR`, `FECHA_INICIO`, `FECHA_FIN`, `PRECIO`, `DNI_CLIENTE`) VALUES
(1, '00000000A', '2019-01-01', '2019-01-02', '2999', '13131313D');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas2`
--
ALTER TABLE `entradas2`
  ADD CONSTRAINT `entradas2_ibfk_1` FOREIGN KEY (`DNIENTRADA`) REFERENCES `clientes2` (`DNI_CLIENTE`),
  ADD CONSTRAINT `entradas2_ibfk_2` FOREIGN KEY (`IDESPECTACULO`) REFERENCES `espectaculos2` (`IDESPECTACULO`),
  ADD CONSTRAINT `entradas2_ibfk_3` FOREIGN KEY (`VENDEDOR`) REFERENCES `empleados2` (`DNI_EMPLEADO`);

--
-- Filtros para la tabla `parte_horas2`
--
ALTER TABLE `parte_horas2`
  ADD CONSTRAINT `parte_horas2_ibfk_1` FOREIGN KEY (`DNI_EMPLEADO`) REFERENCES `empleados2` (`DNI_EMPLEADO`);

--
-- Filtros para la tabla `reserva_sala2`
--
ALTER TABLE `reserva_sala2`
  ADD CONSTRAINT `reserva_sala2_ibfk_1` FOREIGN KEY (`IDESPECTACULO`) REFERENCES `espectaculos2` (`IDESPECTACULO`),
  ADD CONSTRAINT `reserva_sala2_ibfk_2` FOREIGN KEY (`VENDEDOR`) REFERENCES `empleados2` (`DNI_EMPLEADO`),
  ADD CONSTRAINT `reserva_sala2_ibfk_3` FOREIGN KEY (`DNI_CLIENTE`) REFERENCES `clientes2` (`DNI_CLIENTE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
