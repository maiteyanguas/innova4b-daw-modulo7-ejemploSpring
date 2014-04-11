CREATE DATABASE `movies` /*!40100 DEFAULT CHARACTER SET latin1 */;
CREATE TABLE `movies` (
  `idmovies` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  PRIMARY KEY (`idmovies`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
INSERT INTO `movies` (`idmovies`,`name`,`director`) VALUES (17,'Los Otros','Amenabar');
INSERT INTO `movies` (`idmovies`,`name`,`director`) VALUES (18,'Abre los ojos','Amenabar');
INSERT INTO `movies` (`idmovies`,`name`,`director`) VALUES (19,'La naranja mecánica','Kubrik');
INSERT INTO `movies` (`idmovies`,`name`,`director`) VALUES (20,'La chaqueta metálica','Kubrik');
INSERT INTO `movies` (`idmovies`,`name`,`director`) VALUES (21,'Odisea en el espacio','Kubrik');
