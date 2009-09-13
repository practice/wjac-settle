select * from USER;

select * from USERGROUP;

select * from ORGAN;

insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('greatshin','신현배','greatshin@springspirit.net','greatshin');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('shawn','숀','shawn@jabberstory.net','shawn');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('cjac','천지회계','cjac@cjac.net','cjac');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('subject1','건기평','subject1@cjac.net','subject1');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('subject2','산림청','subject2@cjac.net','subject2');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner1','강릉원주대학교','owner1@cjac.net','owner1');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner2','서울대학교','owner2@cjac.net','owner2');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner3','서강대학교','owner3@cjac.net','owner3');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner4','제주대학교','owner4@cjac.net','owner4');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner5','숭실대학교','owner5@cjac.net','owner5');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner6','연세대학교','owner6@cjac.net','owner6');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('owner7','고려대학교','owner7@cjac.net','owner7');

insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values('','','','');

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

insert into FORUM(FORUMID, NAME) values (1, 'public');
insert into FORUM(FORUMID, NAME) values (2, 'qna');
insert into FORUM(FORUMID, NAME) values (3, 'files');
