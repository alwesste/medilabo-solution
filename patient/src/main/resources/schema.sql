CREATE TABLE IF NOT EXISTS `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `genre` varchar(10) DEFAULT NULL,
  `adresse_postal` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
   UNIQUE KEY `uq_patient` (`nom`, `prenom`, `birth_date`)
);