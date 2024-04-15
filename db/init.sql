CREATE DATABASE `sql2dsl`;
USE `sql2dsl`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(20) DEFAULT NULL COMMENT '姓名',
    `account` varchar(20) DEFAULT NULL COMMENT '账号',
    `age` int DEFAULT NULL COMMENT '年龄',
    `sex` int DEFAULT NULL COMMENT '性别',
    `address` varchar(50) DEFAULT NULL COMMENT '地址',
    `create_time` TIMESTAMP DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT='用户信息表';



DROP TABLE IF EXISTS dsl_test;

CREATE TABLE dsl_test (
                          "id" BIGSERIAL PRIMARY KEY ,
                          "username" varchar(255) ,
                          "account" varchar(255) ,
                          "address" varchar(255) ,
                          "age" int2,
                          "sex" int2,
                          create_time TIMESTAMP ,
                          "src_ip" jsonb,
                          "tags" jsonb
);



INSERT INTO "public"."dsl_test" ("username", "age", "src_ip", "tags") VALUES ('prosqlbody', 18, '["1.1.1.1", "2.2.2.2"]'::jsonb, NULL);

