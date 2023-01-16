create database USERSTEAMS
-- 
use USERSTEAMS

create table Users(
	id INT primary key,
	login VARCHAR(50)
);

create table Teams(
	id INT primary key,
	name VARCHAR(50)
);

create table UsersTeams(
	user_id INT,
	team_id INT
);

insert into Users (id, login) values (1, 'Leeland');
insert into Users (id, login) values (2, 'Ruby');
insert into Users (id, login) values (3, 'Mack');
insert into Users (id, login) values (4, 'Bill');
insert into Users (id, login) values (5, 'Dorette');
insert into Users (id, login) values (6, 'Bard');
insert into Users (id, login) values (7, 'Agnola');
insert into Users (id, login) values (8, 'Nita');
insert into Users (id, login) values (9, 'Nicola');
insert into Users (id, login) values (10, 'Dore');

insert into Teams (id, name) values (1, 'Carroll-Will');
insert into Teams (id, name) values (2, 'Glover-Hermann');
insert into Teams (id, name) values (3, 'Connelly LLC');
insert into Teams (id, name) values (4, 'Reichert-Schinner');
insert into Teams (id, name) values (5, 'Senger-Thompson');
insert into Teams (id, name) values (6, 'Koss-Bernier');
insert into Teams (id, name) values (7, 'Mosciski Inc');
insert into Teams (id, name) values (8, 'Windler-Runolfsson');
insert into Teams (id, name) values (9, 'Gaylord, Heaney and Stanton');
insert into Teams (id, name) values (10, 'Schimmel, Moore and Rau');

insert into USERSTEAMS (USER_ID , TEAM_ID ) values (8, 2);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (5, 3);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (1, 9);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (8, 6);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (6, 1);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (5, 7);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (5, 5);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (10, 8);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (1, 2);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (3, 7);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (3, 10);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (7, 4);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (7, 5);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (3, 8);
insert into USERSTEAMS (USER_ID , TEAM_ID ) values (5, 9);