-- INSERT INTO "UserDB" (`ID`, "password") VALUES ( 'test1' ,'$2a$10$RuJNZMF5xHF2xkTGnFtuBe3W3XUBH1OafX4ScDtY5f0GKwOzlVyPu');
-- INSERT INTO "UserDB"(`ID`, "password") VALUES ( 'test2' ,'$2a$10$ERGJfbqZGecKAUG7ubNHpe/AK8eueDi2A8BEM2nytYmsh.K9DcxW2');
-- INSERT INTO "UserDB" (`ID`, "password") VALUES ( 'test3' ,'$2a$10$I9mwBmbU7LuAgPGLGFxasOUbqlfDddKe1wOdGLqCwzPCUtnz/63E2');
--
-- INSERT INTO "ProjectDB" ("title", "description", "adminID")VALUES ( 'test1title','desc','test1');

-- INSERT INTO Products (prod_name, prod_price) values ('베베숲 물티슈', 2700);
-- INSERT INTO Products (prod_name, prod_price) values ('여름 토퍼', 35180);
-- INSERT INTO Products (prod_name, prod_price) values ('페이크 삭스', 860);
-- INSERT INTO Products (prod_name, prod_price) values ('우산', 2900);

insert into UserDB (ID, password) VALUES ('test1' ,'$2a$10$RuJNZMF5xHF2xkTGnFtuBe3W3XUBH1OafX4ScDtY5f0GKwOzlVyPu');
insert into UserDB (ID, password) VALUES ('test2' ,'$2a$10$ERGJfbqZGecKAUG7ubNHpe/AK8eueDi2A8BEM2nytYmsh.K9DcxW2');
insert into UserDB (ID, password) VALUES ('test3' ,'$2a$10$I9mwBmbU7LuAgPGLGFxasOUbqlfDddKe1wOdGLqCwzPCUtnz/63E2');

insert into ProjectDB(title, description, adminID) VALUES ( 'test1_title','desc','test1' );