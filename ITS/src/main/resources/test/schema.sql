CREATE TABLE `UserDB` (
                          `ID` varchar(45) NOT NULL,
                          `password` varchar(100) NOT NULL,
                          PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ProjectDB` (
                             `ID` int NOT NULL AUTO_INCREMENT,
                             `title` varchar(100) NOT NULL,
                             `description` text NOT NULL,
                             `adminID` varchar(45) NOT NULL,
                             PRIMARY KEY (`ID`),
                             KEY `adminID_idx` (`adminID`),
                             CONSTRAINT `adminID` FOREIGN KEY (`adminID`) REFERENCES `UserDB` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
)