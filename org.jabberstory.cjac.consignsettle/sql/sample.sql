delete from USER;
delete from USERGROUP;

insert into USERGROUP(GROUPID, NAME, ROLE) values 
	('admin', 'Administrators', 'A'), 
	('accountant', 'Accountants', 'C');

insert into USER(USERID, USERNAME, EMAIL, PASSWORD, GROUPID) values
	('admin', 'Administrator', 'admin@cjac.net', 'adminadmin', 'admin'),
	('admin2', 'Administrator', 'admin2@cjac.net', 'adminadmin', 'admin');

select * from USERGROUP;
SELECT * FROM USER;
