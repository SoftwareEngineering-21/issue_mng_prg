
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
);

CREATE TABLE IssueDB
(
    ID int not null auto_increment primary key ,
    title varchar(100) not null ,
    description text not null ,
    reporter varchar(45) not null ,
    assignee varchar(45) default null,
    fixer varchar(45) default null,
    type int not null ,
    priority int not null,
    status int not null ,
    createdAt timestamp not null default current_timestamp
);

CREATE TABLE PIRelationDB
(
    ID int not null auto_increment primary key ,
    projectIDFK int not null,
    issueIDFK int not null,
    createdAt timestamp not null default current_timestamp
);

