/*
 Navicat Premium Data Transfer

 Source Server         : database
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 25/01/2022 14:34:58
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for catering
-- ----------------------------
DROP TABLE IF EXISTS "catering";
CREATE TABLE "catering" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "petname" TEXT NOT NULL,
  "petcnname" TEXT,
  "catering" TEXT
);

-- ----------------------------
-- Records of catering
-- ----------------------------
INSERT INTO "catering" VALUES (1, 'American Bull dog', '美国斗牛犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (2, 'American Pit Bull Terrier', '比特犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (3, 'Basset Hound', '巴吉度猎犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (4, 'Beagle', '比格犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (5, 'Boxer', '拳师犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (6, 'Chihuahua', '吉娃娃', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (7, 'English Cocker Spaniel', '英国可卡犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (8, 'English Setter', '英国塞特犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (9, 'German Shorthaired', '德国短毛指示犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (10, 'Great Pyrenees', '大白熊犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (11, 'Havanese', '哈瓦那犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (12, 'Japanese Chin', '日本狆', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (13, 'Keeshond', '荷兰狮毛狗', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (14, 'Leonberger', '兰伯格犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (15, 'Miniature Pinscher', '迷你杜宾犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (16, 'Newfoundland', '纽芬兰犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (17, 'Pomeranian', '博美犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (18, 'Pug', '巴哥犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (19, 'Saint Bernard', '圣伯纳犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (20, 'Samyoed', '萨摩耶犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (21, 'Scottish Terrier', '苏格兰梗犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (22, 'Shiba Inu', '柴犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (23, 'Staffordshire Bull Terrier', '史大丹佛郡斗牛梗', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (24, 'Wheaten Terrier', '爱尔兰软毛梗犬', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (25, 'Yorkshire Terrier', '约克郡梗', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (26, 'Abyssinian', '阿比西尼亚猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (27, 'Bengal', '孟加拉猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (28, 'Birman', '伯曼猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (29, 'Bombay', '孟买猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (30, 'British Shorthair', '英国短毛猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (31, 'Egyptian Mau', '埃及猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (32, 'Main Coon', '缅因猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (33, 'Persian', '波斯猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (34, 'Ragdoll', '布偶猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (35, 'Russian Blue', '俄罗斯蓝猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (36, 'Siamese', '暹罗猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');
INSERT INTO "catering" VALUES (37, 'Sphynx ', '斯芬克斯猫', '食物应以动物性蛋白为主，多喂饲高热量的食物');

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS "history";
CREATE TABLE "history" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "username" TEXT NOT NULL,
  "petname" TEXT NOT NULL,
  "search_time" TEXT NOT NULL
);

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO "history" VALUES (1, 'zhangsan', '吉娃娃', '2022-01-22');

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "sqlite_sequence";
CREATE TABLE "sqlite_sequence" (
  "name",
  "seq"
);

-- ----------------------------
-- Records of sqlite_sequence
-- ----------------------------
INSERT INTO "sqlite_sequence" VALUES ('user', 1);
INSERT INTO "sqlite_sequence" VALUES ('catering', 37);
INSERT INTO "sqlite_sequence" VALUES ('history', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "user";
CREATE TABLE "user" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "username" TEXT NOT NULL,
  "password" TEXT NOT NULL,
  "sex" TEXT NOT NULL,
  "age" INTEGER NOT NULL,
  "telephone" TEXT NOT NULL,
  "email" TEXT NOT NULL
);

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "user" VALUES (1, 'zhangsan', '123', '男', 25, '13112345678', 'zhangsan@qq.com');

-- ----------------------------
-- Auto increment value for catering
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 37 WHERE name = 'catering';

-- ----------------------------
-- Auto increment value for history
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 1 WHERE name = 'history';

-- ----------------------------
-- Auto increment value for user
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 1 WHERE name = 'user';

PRAGMA foreign_keys = true;
