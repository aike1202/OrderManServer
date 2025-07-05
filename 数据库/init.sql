-- 用户表 (user)
CREATE TABLE `user`
(
    `id`         BIGINT                 NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
    `phone`      VARCHAR(11)            NOT NULL COMMENT '手机号',
    `password`   VARCHAR(255)           NOT NULL COMMENT '加密密码',
    `name`       VARCHAR(50)            NOT NULL COMMENT '用户姓名',
    `language`   ENUM ('zh-CN','en-US') NOT NULL DEFAULT 'zh-CN' COMMENT '默认语言',
    `is_active`  BOOLEAN                NOT NULL DEFAULT true COMMENT '账号是否启用',
    `is_deleted` BOOLEAN                NOT NULL DEFAULT false COMMENT '逻辑删除标志',
    `created_at` TIMESTAMP              NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP              NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by` BIGINT COMMENT '创建人ID',
    `updated_by` BIGINT COMMENT '修改人ID',
    `shop_id`    BIGINT                 NULL COMMENT '关联店铺ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_phone` (`phone`),
    KEY `idx_shop_id` (`shop_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

-- 店铺表 (shop)
CREATE TABLE `shop`
(
    `id`                  BIGINT       NOT NULL AUTO_INCREMENT COMMENT '店铺唯一ID',
    `name`                VARCHAR(100) NOT NULL COMMENT '店铺名称',
    `address`             VARCHAR(255) NOT NULL COMMENT '店铺地址',
    `logo_url`            VARCHAR(255) COMMENT '店铺头像URL',
    `contact_phone`       VARCHAR(20) COMMENT '联系电话',
    `authorization_start` DATE         NOT NULL COMMENT '授权开始日期',
    `authorization_end`   DATE         NOT NULL COMMENT '授权结束日期',
    `is_active`           BOOLEAN      NOT NULL DEFAULT true COMMENT '店铺是否启用',
    `is_deleted`          BOOLEAN      NOT NULL DEFAULT false COMMENT '逻辑删除标志',
    `created_at`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by`          BIGINT COMMENT '创建人ID',
    `updated_by`          BIGINT COMMENT '修改人ID',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='店铺表';

-- 角色表 (roles)
CREATE TABLE `role`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `name`        VARCHAR(20) NOT NULL COMMENT '角色名称',
    `description` VARCHAR(100) COMMENT '角色描述',
    `is_deleted`  BOOLEAN     NOT NULL DEFAULT false COMMENT '逻辑删除标志',
    `created_at`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by`  BIGINT COMMENT '创建人ID',
    `updated_by`  BIGINT COMMENT '修改人ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_name` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';

-- 用户角色关联表 (user_role)
CREATE TABLE `user_role`
(
    `id`         BIGINT    NOT NULL AUTO_INCREMENT COMMENT '关联ID',
    `user_id`    BIGINT    NOT NULL COMMENT '用户ID',
    `role_id`    BIGINT    NOT NULL COMMENT '角色ID',
    `is_deleted` BOOLEAN   NOT NULL DEFAULT false COMMENT '逻辑删除标志',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `created_by` BIGINT COMMENT '创建人ID',
    `updated_by` BIGINT COMMENT '修改人ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_user_role` (`user_id`, `role_id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_role_id` (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户角色关联表';

-- Token表 (user_tokens)
CREATE TABLE `user_token`
(
    `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'Token ID',
    `user_id`     BIGINT       NOT NULL COMMENT '用户ID',
    `token`       VARCHAR(255) NOT NULL COMMENT 'Token值',
    `expires_at`  DATETIME     NOT NULL COMMENT '过期时间',
    `device_info` VARCHAR(100) COMMENT '设备信息',
    `is_deleted`  BOOLEAN      NOT NULL DEFAULT false COMMENT '逻辑删除标志',
    `created_at`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_by`  BIGINT COMMENT '创建人ID',
    `updated_by`  BIGINT COMMENT '修改人ID',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_token` (`token`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户Token表';

-- 初始化角色数据
INSERT INTO `role` (`id`, `name`, `description`)
VALUES (1, 'super_admin', '超级管理员'),
       (2, 'shop_owner', '店长'),
       (3, 'staff', '店员');

ALTER TABLE `user`
    MODIFY `shop_id` BIGINT NULL COMMENT '关联店铺ID（可为空）';


-- 创建超级管理员用户（无店铺关联）
INSERT INTO `user` (`phone`, `password`, `name`, `language`,
                     `is_active`, `shop_id`, `created_by`, `updated_by`)
VALUES ('18888888888',
        '$2a$10$6VY5huzI7cQwzYb9bJQnBOk7X9tTZ7XlL2W3cYvD4aGp1rS6fKj8Wm', -- BCrypt加密后的Admin@123
        '超级管理员',
        'zh-CN',
        true,
        NULL, -- 不关联任何店铺
        NULL,
        NULL);

-- 关联超级管理员角色
SET @superAdminId = LAST_INSERT_ID();

INSERT INTO `user_role` (`user_id`, `role_id`, `created_by`, `updated_by`)
VALUES (@superAdminId,
        1, -- 超级管理员角色ID
        @superAdminId,
        @superAdminId);