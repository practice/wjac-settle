
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('1','관리자','A');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('2','천지회계','C');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('3','건기평','O');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('4','산림청','O');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('5','강릉원주대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('6','서울대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('7','서강대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('8','제주대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('9','숭실대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('10','연세대학교','S');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values('11','고려대학교','S');

insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('admin','Administrator','admin@cjac.net','adminadmin', 1);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('greatshin','신현배','greatshin@springspirit.net','greatshin', 1);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('shawn','숀','shawn@jabberstory.net','shawn', 1);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('cjac','천지회계','cjac@cjac.net','cjac', 2);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('subject1','건기평','subject1@cjac.net','subject1', 3);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('subject2','산림청','subject2@cjac.net','subject2', 4);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner1','강릉원주대학교','owner1@cjac.net','owner1', 5);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner2','서울대학교','owner2@cjac.net','owner2', 6);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner3','서강대학교','owner3@cjac.net','owner3', 7);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner4','제주대학교','owner4@cjac.net','owner4', 8);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner5','숭실대학교','owner5@cjac.net','owner5', 9);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner6','연세대학교','owner6@cjac.net','owner6', 10);
insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values('owner7','고려대학교','owner7@cjac.net','owner7', 11);

insert into FORUM(FORUMID, NAME) values (1, '공지사항');
insert into FORUM(FORUMID, NAME) values (2, 'Q &amp; A');
insert into FORUM(FORUMID, NAME) values (3, '자료실');
