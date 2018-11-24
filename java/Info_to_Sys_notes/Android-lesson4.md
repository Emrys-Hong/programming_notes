## Table of Contents

## Database
A relational database (“SQL database”) has its data stored in tables. The closest thing you might be familiar with is having data in a spreadsheet.

A non-relational database (“noSQL database”) has its data stored in other ways. One common way is using key-value pairs, which you would have encountered in Google firebase.

This class can also include methods for the database CRUD queries
- Creating records
- Reading or Querying records
- Updating records
- Deleting records

## sqlite instruction
- create tables and insert values
```sql
CREATE TABLE SpendingRecord (_ID INTEGER PRIMARY KEY AUTOINCREMENT, Amount INTEGER NOT NULL, Remarks TEXT NOT NULL );
INSERT INTO SpendingRecord (Amount, Remarks)
VALUES (10000, 'Man');
INSERT INTO SpendingRecord (Amount, Remarks)
VALUES (20000, 'Norman');
INSERT INTO SpendingRecord (Amount, Remarks)
VALUES (30000, 'Eric');
```
- sql queries
```sql
SELECT * FROM SpendingRecord;
SELECT Remarks FROM SpendingRecord;
SELECT * FROM SpendingRecord WHERE Remarks = 'Eric';
SELECT * FROM SpendingRecord WHERE Amount > 15000;
SELECT * FROM SpendingRecord ORDER BY RANDOM() LIMIT 1;
```
Further reading:
[Android Developer Fundamentals v2, Concept Reference, Section 10.0](https://google-developer-training.github.io/android-developer-fundamentals-course-concepts-v2/unit-4-saving-user-data/lesson-10-storing-data-with-room/10-0-c-sqlite-primer/10-0-c-sqlite-primer.html)

practise at: 
http://sqlfiddle.com


## Create Constructor for database
The singleton design pattern should also be used with this class,
as only one instance of the helper should be querying the database at any point in time.


```SQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)``` Create a helper object to create, open, and manage a database.

```java
private CharaDbHelper(Context context){
    super(context, CharaContract.CharaEntry.TABLE_NAME, null, DATABASE_VERSION );
    this.context = context;
}

static CharaDbHelper createCharaDbHelper(Context context) {
    if (charaDbHelper == null) {
        charaDbHelper = new CharaDbHelper(context.getApplicationContext());
    }
    return new CharaDbHelper(context);
}
```


## Create SQL Table
```java
public static String SQL_CREATE_TABLE = "CREATE TABLE" + SPACE
                + CharaEntry.TABLE_NAME + SPACE + "("
                + CharaEntry._ID + SPACE + "INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA
                + CharaEntry.COL_NAME + SPACE + "TEXT NOT NULL" + COMMA
                + CharaEntry.COL_DESCRIPTION + SPACE + "TEXT NOT NULL" + COMMA
                + CharaEntry.COL_FILE + SPACE + "BLOB NOT NULL" + ");" ;
```

```java
@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL(CharaContract.CharaSql.SQL_CREATE_TABLE);
    fillTable(sqLiteDatabase);
}
```

## Upgrade SQL Table
```java
public static String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + CharaEntry.TABLE_NAME;
```

```java
@Override
public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL(CharaContract.CharaSql.SQL_DROP_TABLE);
    onCreate(sqLiteDatabase);
}
```

## Query one row
Using cursor
```java
public static String SQL_QUERY_ONE_RANDOM_ROW = "SELECT * FROM" + SPACE
                + CharaEntry.TABLE_NAME + SPACE
                + "ORDER BY RANDOM() LIMIT 1";
```

```java
public CharaData queryOneRowRandom(){
    if (readableDb == null) {
        readableDb = getReadableDatabase();
    }
    Cursor cursor = readableDb.rawQuery(CharaContract.CharaSql.SQL_QUERY_ONE_RANDOM_ROW, null);

    return getDataFromCursor(0, cursor);
}
```