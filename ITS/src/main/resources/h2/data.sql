
insert into UserDB (ID, password) VALUES ('test1' ,'$2a$10$RuJNZMF5xHF2xkTGnFtuBe3W3XUBH1OafX4ScDtY5f0GKwOzlVyPu');
insert into UserDB (ID, password) VALUES ('test2' ,'$2a$10$ERGJfbqZGecKAUG7ubNHpe/AK8eueDi2A8BEM2nytYmsh.K9DcxW2');
insert into UserDB (ID, password) VALUES ('test3' ,'$2a$10$I9mwBmbU7LuAgPGLGFxasOUbqlfDddKe1wOdGLqCwzPCUtnz/63E2');
insert into UserDB (ID, password) VALUES ('test4' ,'$2a$10$qw9ibXAeS5pP9mHsnqX/f.BuxvnPz4lYRsTfP5j/LO3WreDNu7AE.');

insert into ProjectDB(title, description, adminID) VALUES ( 'test1_title','desc','test1' );
insert into ProjectDB(title, description, adminID) VALUES ( 'test2_title','desc','test2' );
insert into ProjectDB(title, description, adminID) VALUES ( 'test3_title','desc','test3' );

insert into AuthorityDB(userID, projectID, auth) VALUES('test1',3,2);
insert into AuthorityDB(userID, projectID, auth) VALUES('test1',1,1);
insert into AuthorityDB(userID, projectID, auth) VALUES('test1',1,2);
insert into AuthorityDB(userID, projectID, auth) VALUES('test2',1,0);
insert into AuthorityDB(userID, projectID, auth) VALUES('test3',1,2);
insert into AuthorityDB(userID, projectID, auth) VALUES('test4',1,1);
insert into AuthorityDB(userID, projectID, auth) VALUES('test4',1,0);


insert into IssueDB(title, description, reporter, type, priority, status) VALUES ('issue1', 'text1', 'test1',2,4,0);
insert into IssueDB(title, description, reporter, type, priority, status) VALUES ('issue2', 'text2', 'test3',1,2,4);
insert into IssueDB(title, description, reporter,assignee, type, priority, status) VALUES ('issue3', 'text3', 'test3','test4',1,2,3);
insert into IssueDB(title, description, reporter,assignee, type, priority, status) VALUES ('issue4', 'text4', 'test4','test1',1,2,3);
insert into IssueDB(title, description, reporter,assignee, type, priority, status) VALUES ('issue5', 'text5', 'test1','test4',2,4,1);


insert into PIRelationDB(projectIDFK,issueIDFK) VALUES (1,1);
insert into PIRelationDB(projectIDFK,issueIDFK) VALUES (1,2);
insert into PIRelationDB(projectIDFK,issueIDFK) VALUES (1,3);
insert into PIRelationDB(projectIDFK,issueIDFK) VALUES (1,4);
insert into PIRelationDB(projectIDFK,issueIDFK) VALUES (1,5);


insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment1', 'test1','2022-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment1-1', 'test2','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment2-1', 'test4','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment2-2', 'test1','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment2-3', 'test3','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment3', 'test3','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment3-1', 'test1','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment4', 'test4','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment4-1', 'test1','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment5', 'test1','2023-05-31 12:34:56');
insert into CommentDB(text, reporterComment, createdAt) VALUES ('comment5-1', 'test4','2023-05-31 12:34:56');


insert into ICRelationDB(issueID, commentID) VALUES (1, 1);
insert into ICRelationDB(issueID, commentID) VALUES (1, 2);
insert into ICRelationDB(issueID, commentID) VALUES (2, 3);
insert into ICRelationDB(issueID, commentID) VALUES (2, 4);
insert into ICRelationDB(issueID, commentID) VALUES (2, 5);
insert into ICRelationDB(issueID, commentID) VALUES (3, 6);
insert into ICRelationDB(issueID, commentID) VALUES (3, 7);
insert into ICRelationDB(issueID, commentID) VALUES (4, 8);
insert into ICRelationDB(issueID, commentID) VALUES (4, 9);
insert into ICRelationDB(issueID, commentID) VALUES (5, 10);
insert into ICRelationDB(issueID, commentID) VALUES (5, 11);
