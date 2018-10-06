## sql is manipulating on rows, it is like a spreadsheet

### action + table + (values) + where_clause
```
# create table
CREATE TABLE Users(
 name VARCHAR(128),
 email VARCHAR(128)
)

# insert values
INSERT INTO Users (name, email) VALUES ('zihao', 'zihao@sutd.edu.sg')

# delete
delete FROM Users WHERE email='abc@sutd.edu.sg'

# update
UPDATE Users SET name = 'Hong Pengfei' WHERE email='pengfei@sutd.edu.sg'

# select
SELECT * FROM Users  
# '*' means that all the columns
SELECT * FROM Users WHERE email='blabla'

# sort and order
SELECT * FROM Users ORDER BY email

# count the rows in the table Users
SELECT COUNT(*) FROM Users

