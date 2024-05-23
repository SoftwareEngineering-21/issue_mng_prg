-- CREATE TABLE "UserDB" (
--                           "ID" varchar(45) NOT NULL PRIMARY KEY,
--                           "password" VARCHAR(100) NOT NULL
-- );
--
--
-- CREATE TABLE "ProjectDB" (
--                              "ID" INT AUTO_INCREMENT PRIMARY KEY,
--                              "title" VARCHAR(100) NOT NULL,
--                              "description" TEXT NOT NULL,
--                              "adminID" varchar(45) NOT NULL,
--                              CONSTRAINT `FK_ProjectDB_UserDB` FOREIGN KEY ("adminID") REFERENCES "UserDB" ("ID") ON DELETE CASCADE ON UPDATE CASCADE
-- );
--
--
--
DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    prod_id     IDENTITY        PRIMARY KEY,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL
);