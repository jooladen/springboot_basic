use edu;

create table user2 (
	no 		int 			not null auto_increment primary key,
	name 	varchar(100) 	not null,
	email 	varchar(200) 	null,
	pwd		varchar(100)	not null,
	gender	boolean			not null default '1',
	regDate datetime 		not null default now()
);

commit;