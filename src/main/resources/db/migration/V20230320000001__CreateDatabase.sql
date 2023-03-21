CREATE TABLE IF NOT EXISTS principals
(
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_at          DATETIME        NOT NULL,
    updated_at          DATETIME        NOT NULL,
    username            CHAR(24)        NOT NULL,
    profile_description TEXT            NOT NULL,
    UNIQUE KEY unique_principal (username)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;