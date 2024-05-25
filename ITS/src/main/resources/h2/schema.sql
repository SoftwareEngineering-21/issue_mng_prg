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

CREATE TABLE UserDB
(
    ID varchar(45) NOT NULL PRIMARY KEY ,
    password varchar(100) NOT NULL
);

CREATE TABLE ProjectDB
(
    ID int auto_increment primary key ,
    title varchar(100) not null,
    description text not null ,
    adminID varchar(45) not null
);

CREATE TABLE AuthorityDB
(
    ID int auto_increment primary key ,
    userID varchar(45) not null,
    projectID int not null,
    auth int not null

)