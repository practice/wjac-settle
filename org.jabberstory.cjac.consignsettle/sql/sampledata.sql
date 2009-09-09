select * from user;

select * from usergroup;

select * from organ;

insert into user(userid,username,email,password) values('greatshin','신현배','greatshin@springspirit.net','greatshin');
insert into user(userid,username,email,password) values('shawn','숀','shawn@jabberstory.net','shawn');
insert into user(userid,username,email,password) values('cjac','천지회계','cjac@cjac.net','cjac');
insert into user(userid,username,email,password) values('subject1','건기평','subject1@cjac.net','subject1');
insert into user(userid,username,email,password) values('subject2','산림청','subject2@cjac.net','subject2');
insert into user(userid,username,email,password) values('owner1','강릉원주대학교','owner1@cjac.net','owner1');
insert into user(userid,username,email,password) values('owner2','서울대학교','owner2@cjac.net','owner2');
insert into user(userid,username,email,password) values('owner3','서강대학교','owner3@cjac.net','owner3');
insert into user(userid,username,email,password) values('owner4','제주대학교','owner4@cjac.net','owner4');
insert into user(userid,username,email,password) values('owner5','숭실대학교','owner5@cjac.net','owner5');
insert into user(userid,username,email,password) values('owner6','연세대학교','owner6@cjac.net','owner6');
insert into user(userid,username,email,password) values('owner7','고려대학교','owner7@cjac.net','owner7');

insert into user(userid,username,email,password) values('','','','');

insert into usergroup(groupid,groupname,role) values('1','관리자','A');
insert into usergroup(groupid,groupname,role) values('2','천지회계','C');
insert into usergroup(groupid,groupname,role) values('3','건기평','O');
insert into usergroup(groupid,groupname,role) values('4','산림청','O');
insert into usergroup(groupid,groupname,role) values('5','강릉원주대학교','S');
insert into usergroup(groupid,groupname,role) values('6','서울대학교','S');
insert into usergroup(groupid,groupname,role) values('7','서강대학교','S');
insert into usergroup(groupid,groupname,role) values('8','제주대학교','S');
insert into usergroup(groupid,groupname,role) values('9','숭실대학교','S');
insert into usergroup(groupid,groupname,role) values('10','연세대학교','S');
insert into usergroup(groupid,groupname,role) values('11','고려대학교','S');

