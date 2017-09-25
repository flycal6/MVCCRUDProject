-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema teamdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teamdb` ;

-- -----------------------------------------------------
-- Schema teamdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teamdb` DEFAULT CHARACTER SET utf8 ;
USE `teamdb` ;

-- -----------------------------------------------------
-- Table `teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teams` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `first_year` INT NOT NULL,
  `last_year` INT NOT NULL,
  `relocated_to` VARCHAR(255) NULL,
  `seasons` INT UNSIGNED NOT NULL DEFAULT 0,
  `record` VARCHAR(45) NOT NULL,
  `win_percentage` DECIMAL(3,3) NOT NULL,
  `playoff_appearances` INT UNSIGNED NOT NULL DEFAULT 0,
  `stanley_cups` INT UNSIGNED NOT NULL DEFAULT 0,
  `reason` VARCHAR(600) NOT NULL,
  `logo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;

CREATE USER 'team'@'localhost' IDENTIFIED BY 'teamuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'team'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `teams`
-- -----------------------------------------------------
START TRANSACTION;
USE `teamdb`;
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (1, 'Winnipeg Jets', 1979, 1996, 'Phoenix Coyotes*', 17, '506–660–172', 0.442, 11, 0, 'Sold to a group of investors with the intention to move in search of better financial conditions.', 'http://www.winnipegjetsonline.com/images/content/logoJersey/hi-res/80s-Logo-Away.jpg');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (2, 'St. Louis Eagles', 1934, 1935, 'Defunct', 1, '11–31–6', 0.292, 0, 0, 'Financial struggle during the Great Depression.', 'https://i.pinimg.com/736x/ae/62/2b/ae622bbafc0517e738f7bd1251863685--nhl-logos-sports-logos.jpg');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (3, 'Quebec Nordiques', 1979, 1995, 'Colorado Avalanche*', 16, '497–599–160', 0.459, 9, 0, 'Financial struggle; sold to a Denver-based group.', 'https://upload.wikimedia.org/wikipedia/en/thumb/9/96/Quebec_Nordiques_Logo.svg/1280px-Quebec_Nordiques_Logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (4, 'Quebec Athletic Club', 1919, 1920, 'Hamilton Tigers', 1, '4–20–0', 0.167, 0, 0, 'Sold to a Hamilton-based company.', 'http://www.sportsbettingtips.org/wp-content/uploads/2015/04/who-were-the-quebec-bulldogs-610x400.jpg');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (5, 'Pittsburgh Pirates', 1925, 1930, 'Philadelphia Quakers', 5, '67–122–23', 0.370, 2, 0, 'Financial struggle during the Great Depression', 'https://upload.wikimedia.org/wikipedia/en/thumb/8/85/Pittsburgh_Pirates_Logo.svg/930px-Pittsburgh_Pirates_Logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (6, 'Philadelphia Quakers', 1930, 1931, 'Defunct', 1, '4–36–4', 0.136, 0, 0, 'Financial struggle during the Great Depression', 'http://content.sportslogos.net/logos/1/48/full/hvegege8x6kshi5e0e7fk5k3j.gif');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (7, 'Ottawa Senators', 1917, 1934, 'St. Louis Eagles', 16, '258–221–63', 0.534, 9, 4, 'Financial struggle during the Great Depression', 'https://upload.wikimedia.org/wikipedia/en/thumb/d/d1/Original_ottawa_sens_logo.svg/1260px-Original_ottawa_sens_logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (8, 'Montreal Wanderers', 1917, 1918[g], 'Defunct', 1, '1–5–0', 0.167, 0, 0, 'Lack of available players due to World War I', 'http://www.hockeydb.com/ihdb/logos/nhl--montreal_wanderers_1917-18.gif');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (9, 'Montreal Maroons', 1924, 1938, 'Defunct', 14, '271–260–91', 0.509, 11, 2, 'Financial struggle during the Great Depression', 'http://content.sportslogos.net/logos/1/40/full/7107.gif');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (10, 'Minnesota North Stars', 1967, 1993, 'Dallas Stars*', 26, '758–970–334', 0.449, 17, 0, 'In search of better financial conditions', 'https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Minnesota_North_Stars_Logo_2.svg/801px-Minnesota_North_Stars_Logo_2.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (11, 'Kansas City Scouts', 1974, 1976, 'Colorado Rockies', 2, '27–110–23', 0.241, 0, 0, 'Financial struggle; sold to a group of investors with the intention to move.', 'http://18.220.25.115/images/KCScouts.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (12, 'Hartford Whalers', 1979, 1997, 'Carolina Hurricanes*', 18, '534–709–177', 0.438, 8, 0, 'In search of better financial conditions', 'https://upload.wikimedia.org/wikipedia/en/thumb/7/70/Hartford_Whalers_Logo-79-92.svg/1031px-Hartford_Whalers_Logo-79-92.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (13, 'Hamilton Tigers', 1920, 1925, 'Defunct', 5, '47–78–1', 0.377, 0, 0, 'Ceased due to players\' strike; players were bought by the New York Americans.', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/15/Hamilton_Tigers_Logo.svg/1280px-Hamilton_Tigers_Logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (14, 'Colorado Rockies', 1976, 1982, 'New Jersey Devils*', 6, '113–281–86', 0.325, 0, 0, 'Sold to John McMullen; New Jersey is the home state of McMullen.', 'https://upload.wikimedia.org/wikipedia/en/thumb/2/24/Colorado_Rockies_%28NHL%29_logo.svg/1200px-Colorado_Rockies_%28NHL%29_logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (15, 'Cleveland Barons', 1976, 1978, 'Minnesota North Stars(merge)', 2, '47–87–26', 0.375, 0, 0, 'Both teams with financial struggle', 'https://s-media-cache-ak0.pinimg.com/originals/84/cb/bc/84cbbcb3a641a44d98fb488a5c3b20a0.jpg');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (16, 'California Golden Seals', 1967, 1976, 'Cleveland Barons', 9, '182–401–115', 0.343, 2, 0, 'In search of better financial conditions; Cleveland is the hometown of minority owner George Gund III.', 'https://upload.wikimedia.org/wikipedia/en/thumb/1/17/California_Golden_Seals_Logo.svg/1236px-California_Golden_Seals_Logo.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (17, 'Brooklyn Americans', 1925, 1942, 'Defunct', 17, '255–402–127', 0.406, 5, 0, 'Financial struggle plus lack of players due to World War II; formally ceased in 1946.', 'http://content.sportslogos.net/logos/1/998/full/22hfgtld3jtnfnbqmls2ejruo.gif');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (18, 'Atlanta Thrashers', 1999, 2011, 'Winnipeg Jets*', 11, '342–437–45–78', 0.447, 1, 0, 'Financial struggle; sold to a Winnipeg-based company.', 'https://upload.wikimedia.org/wikipedia/en/thumb/0/02/Atlanta_Thrashers.svg/1242px-Atlanta_Thrashers.svg.png');
INSERT INTO `teams` (`id`, `name`, `first_year`, `last_year`, `relocated_to`, `seasons`, `record`, `win_percentage`, `playoff_appearances`, `stanley_cups`, `reason`, `logo`) VALUES (19, 'Atlanta Flames', 1972, 1980, 'Calgary Flames*', 8, '268–260–108', 0.506, 6, 0, 'Financial struggle; sold to Nelson Skalbania with the intention to move to Calgary.', 'https://upload.wikimedia.org/wikipedia/en/thumb/4/45/Atlanta_Flames_Logo.svg/1222px-Atlanta_Flames_Logo.svg.png');

COMMIT;

