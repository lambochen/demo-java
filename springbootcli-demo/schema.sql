CREATE TABLE Book
(
    `id`          BIGINT        NOT NULL AUTO_INCREMENT,
    `reader`      VARCHAR(20)   NOT NULL,
    `isbn`        VARCHAR(10)   NOT NULL,
    `title`       VARCHAR(50)   NOT NULL,
    `author`      VARCHAR(50)   NOT NULL,
    `description` VARCHAR(2000) NOT NULL
);
