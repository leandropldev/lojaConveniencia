CREATE TABLE IF NOT EXISTS `permission` (
    `id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;