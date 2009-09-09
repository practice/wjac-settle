insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values ('admin', 'Administrators', 'A');
insert into USERGROUP(GROUPID, GROUPNAME, ROLE) values ('accountant', 'Accountants', 'C');

insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values ('admin', 'Administrator', 'admin@cjac.net', 'adminadmin');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values ('admin2', 'Administrator', 'admin2@cjac.net', 'adminadmin');
insert into USER(USERID, USERNAME, EMAIL, PASSWORD) values ('shawn', '원상호', 'shawn.won@gmail.com', 'shawn');

insert into FORUM(FORUMID, NAME) values (1, 'public');
insert into FORUM(FORUMID, NAME) values (2, 'qna');
insert into FORUM(FORUMID, NAME) values (3, 'files');

