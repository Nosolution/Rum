DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`
(
    `id`                       bigint       NOT NULL AUTO_INCREMENT,
    `username`                 varchar(50)  NOT NULL,
    `password`                 varchar(255) NOT NULL,
    `email`                    varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8mb4;
