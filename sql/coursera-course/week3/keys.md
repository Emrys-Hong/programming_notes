## important concepts: primary keys, foreign keys and logical keys
## it is okay to have replicated keys as long as they are numbers

how you can create tables with related keys. (artist > track) (Genre > track) to reduce the amount of real string you need to replicate.

```
## genre table
CREATE TABLE Genre (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	name TEXT 
)

## artist table
CREATE TABLE Artist (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	name TEXT 
)

## album table (album < artist)
CREATE TABLE Album (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    artist_id INTEGER,
	title TEXT 
)

# track table
CREATE TABLE Track (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	title TEXT,
	album_id  INTEGER,
	genre_id INTEGER,
	len INTEGER, rating INTEGER, count INTEGER
	
)

## insert data into artist (dont need to specify any number here)
insert into Artist (name) values ('Led Zepplin')
insert into Artist (name) values ('AC/DC')

## insert data into genre
insert into Genre (name) values ('rock');
insert into Genre (name) values ('metal');

## album table insert
insert into Album (title, artist_id) values ('Who made Who', 2);
insert into Album (title, artist_id) values ('IV', 1)

## track table
insert into Track (title, rating, len, count, album_id, genre_id) values ('Black Dog', 5, 297, 0, 2, 1);
insert into Track (title, rating, len, count, album_id, genre_id) values ('Stairway', 5, 482, 0, 2, 1);
insert into Track (title, rating, len, count, album_id, genre_id) values ('about to rock', 5, 313, 0, 1, 2);
insert into Track (title, rating, len, count, album_id, genre_id) values ('Who made Who', 5, 207, 0, 1, 2);

# join two tables and their names together, the ids are the source of the connection
select Album.title, Artist.name from Album join Artist on Album.artist_id = Artist.id
## if you dont have a "on clause" then we will ahve all the combination
select Track.title, Genre.name from Track join Genre

# join all the things together and reconstruct the whole thing
select Track.title, Artist.name, Album.title, Genre.name from Track join Genre join Album join Artist on Track.genre_id = Genre.id and Track.album_id = Album.id and Album.artist_id = Artist.id

