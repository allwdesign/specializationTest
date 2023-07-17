DROP DATABASE IF EXISTS `human_friends`;

-- 7
CREATE DATABASE IF NOT EXISTS `human_friends`;

USE `human_friends`;

-- 8
CREATE TABLE `animal` (
    id INT PRIMARY KEY,
    `name` VARCHAR(60) NOT NULL,
    commands VARCHAR(255),
    `birthday` DATE NOT NULL
);

CREATE TABLE `pets` (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `animal`(id)
);

CREATE TABLE `packs` (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `animal`(id)
);

CREATE TABLE IF NOT EXISTS `horse`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `packs`(id)
);

CREATE TABLE IF NOT EXISTS `donkey`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `packs`(id)
);

CREATE TABLE IF NOT EXISTS `camel`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `packs`(id)
);

CREATE TABLE IF NOT EXISTS `cat`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `pets`(id)
);

CREATE TABLE IF NOT EXISTS `dog`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `pets`(id)
);

CREATE TABLE IF NOT EXISTS `hamster`
( 
	id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `pets`(id)
);
-- 9
-- алюр = шаг рысь галоп прыжок парадный шаг пассаж пируэт 
INSERT INTO `animal` (id, `name`, commands, `birthday`) 
VALUES 
		(1, 'Лулу', 'Галоп', '201-10-10'),
		(2, 'Искорка', 'Бег рысью', '2004-09-18'),
        (3, 'Иа', 'Тянуть груз', '2000-06-18'),
        (4, 'Моисей', 'Тянуть большой груз', '1999-06-18'),
        (5, 'Посейдон', 'Тянуть груз', '2016-06-18'),
        (6, 'Зевс', 'Жить в пустыне', '2021-03-30'),
        (7, 'Мурка', 'Мурчать', '2001-12-25'),
        (8, 'Барсик', 'Царапаться', '2016-06-18'),
        (9, 'Шарик', 'Гавкать', '2021-05-19'),
        (10, 'Бобик', 'Грызть кость', '2018-04-05'),
        (11, 'Боня', 'Хрумать целый день', '2021-07-03'),
        (12, 'Лапа', 'Бегать в колесе', '2021-01-06');
        
INSERT INTO `packs`(id) 
VALUES (1), (2), (3), (4), (5), (6);

INSERT INTO `pets`(id) 
VALUES (7), (8), (9), (10), (11), (12);
       
INSERT INTO `horse`(id)
VALUES (1), (2);
        
INSERT INTO `donkey` (id)
VALUES (3), (4);
        
INSERT INTO `camel` (id)
VALUES (5), (6);
        
INSERT INTO `cat` (id)
VALUES (7), (8);
        
INSERT INTO `dog` (id)
VALUES (9), (10);
        
INSERT INTO `hamster` (id)
VALUES (11), (12);

-- 10
DELETE FROM `camel`;

CREATE TABLE `horse_donkey` (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES `packs`(id)
);

INSERT INTO `horse_donkey` (id)
SELECT id FROM `horse` 
UNION ALL
SELECT id FROM `donkey`;

SELECT * FROM `horse_donkey`;

-- 11
CREATE TABLE `young_animals` (
    id INT PRIMARY KEY,
    age INT,
    FOREIGN KEY (id) REFERENCES `animal`(id)
);

INSERT INTO `young_animals` (id, age)
SELECT id,
    TIMESTAMPDIFF(MONTH, `birthday`, CURDATE()) as age
FROM `animal`
WHERE TIMESTAMPDIFF(YEAR, `birthday`, CURDATE()) > 1
AND
	TIMESTAMPDIFF(YEAR, `birthday`, CURDATE()) < 3;


SELECT * FROM `young_animals`;
-- 12
ALTER TABLE `animal` 
ADD COLUMN `class` VARCHAR(60);

UPDATE `animal` 
SET `class` = 'horse'
WHERE id IN (SELECT id FROM `horse`);

UPDATE `animal` 
SET `class` = 'donkey'
WHERE id IN (SELECT id FROM `donkey`);

UPDATE `animal` 
SET `class` = 'camel'
WHERE id IN (SELECT id FROM `camel`);

UPDATE `animal` 
SET `class` = 'cat'
WHERE id IN (SELECT id FROM `cat`);

UPDATE `animal` 
SET `class` = 'dog'
WHERE id IN (SELECT id FROM `dog`);
