## inorder to construct a many to many relationships
such as. student and classes, each student take a lot of classes and each class have a lot of student

```
## membership table serves as connection table between the two
CREATE TABLE User (
	id integer not null primary key autoincrement unique,
	name text,
	email text
);
create table Course (
	id integer not null primary key autoincrement unique,
	title text
);
create table Member (
	user_id integer,
	course_id integer,
	     role   integer,
		 primary key (user_id, course_id)
)

## fill in content
insert into User (name, email) values ('Jane', 'jane@sutd.edu.sg');
insert into User (name, email) values('ed', 'ed@sutd.edu.sg');
insert into User (name, email) values('Sue', 'sue@sutd.edu.sg');
insert into Course (title) values ('python');
insert  into Course (title) values ('SQL');
insert into Course (title) values ('PHP');

## insert the members, 1 as a teacher and zeros as a student
insert into Member (user_id, course_id, role) values (1, 1, 0);
insert into Member (user_id, course_id, role) values (2, 1, 0);
insert into Member (user_id, course_id, role) values (3, 1, 0);
insert into Member (user_id, course_id, role) values (1, 2, 0);
insert into Member (user_id, course_id, role) values (2, 2, 0);
insert into Member (user_id, course_id, role) values (2, 3, 1);
insert into Member (user_id, course_id, role) values (3, 3, 0);

# join the table together
select User.name, Member.role, Course.title from User join Member join Course on Member.course_id = Course.id and Member.user_id = User.id
# order them as course first, member second in a descending order, and then user.name 
select User.name, Member.role, Course.title from User join Member join Course on Member.course_id = Course.id and Member.user_id = User.id order by Course.title, Member.role desc, User.nameselect User.name, Member.role, Course.title from User join Member join Course on Member.course_id = Course.id and Member.user_id = User.id order by Course.title, Member.role desc, User.name
```