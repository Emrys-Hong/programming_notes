import sqlite3

conn = sqlite3.connect("emaildb.sqlite")
cur = conn.cursor()

cur.execute("DROP TABLE IF EXISTS Counts")

cur.execute("CREATE TABLE Counts (email TEXT, count INTEGER)")

fname = input('enter file name')
if (len(fname)<1):
    fname = '/Users/MH/Desktop/programming_notes/sql/mbox-short.txt'
fh = open(fname)
for line in fh:
    # if not line.startswith('From: '): continue
    pieces = line.split()
    email = pieces[0]
    cur.execute(f'SELECT count FROM Counts WHERE email = ?', (email,))
    row = cur.fetchone()
    print('row', row)
    if row is None:
        cur.execute(f'INSERT INTO Counts (email, count) VALUES (?, 1)', (email,))
    else:
        cur.execute(f'UPDATE Counts SET count = count +1 WHERER email = ?', (email,))
    conn.commit() ## when you write the commands to disk

# read the file from the sql dataset
sqlstr = 'SELECT email, count FROM Counts ORDER BY count DESC LIMIT 10'
# the first 10 ordered by emails

for row in cur.execute(sqlstr):
    print(str(row[0]), row[1])

# dont forget the last page
cur.close()