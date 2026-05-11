CREATE TABLE IF NOT EXISTS `medecin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `specialite` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `organisateur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prenom` varchar(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `genre` varchar(10) DEFAULT NULL,
  `adresse_postal` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `medecin_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_patient_medecin`
    FOREIGN KEY (`medecin_id`) REFERENCES `medecin`(`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);