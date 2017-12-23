CREATE TABLE users (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,

    `name` VARBINARY(32) NOT NULL,

    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE entries (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,

    `url` VARBINARY(512) NOT NULL,
    `title` VARCHAR(512) NOT NULL,

    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY (url(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE bookmarks (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,

    `user_id` BIGINT UNSIGNED NOT NULL,
    `entry_id` BIGINT UNSIGNED NOT NULL,
    `comment` VARCHAR(256) NOT NULL,

    `created_at` DATETIME NOT NULL,
    `updated_at` DATETIME NOT NULL,

    PRIMARY KEY (id),
    UNIQUE KEY (user_id, entry_id),
    KEY (user_id, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
