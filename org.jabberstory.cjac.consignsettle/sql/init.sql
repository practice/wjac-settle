-- Initial data for going live.

insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('1','관리자','A');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('2','회계법인','C');

insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('admin','Administrator','admin@cjac.net','adminadmin', 1);

insert into FORUM(FORUMID, NAME) values (1, '공지사항');
insert into FORUM(FORUMID, NAME) values (2, 'Q &amp; A');
insert into FORUM(FORUMID, NAME) values (3, '자료실');
