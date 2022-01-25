package org.pytorch.helloworld;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginDatabaseAdapter {

    static final String DATABASE_NAME = "database.db";
    String ok="OK";
    static final int DATABASE_VERSION = 1;
    public  static String getPassword="";

    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXIST user (" +
            "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "username TEXT NOT NULL," +
            "password TEXT NOT NULL," +
            "sex TEXT NOT NULL," +
            "age INTEGER NOT NULL," +
            "telephoneTEXT NOT NULL," +
            "email TEXT NOT NULL" +
            ");"+
            "INSERT INTO user VALUES (1, 'zhangsan', '123', '男', 25, '13112345678', 'zhangsan@qq.com');\n";

    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private static DataBaseHelper dbHelper;
    public  LoginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method to openthe Database
    public  LoginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    // Method to close the Database
    public void close()
    {
        db.close();
    }

    // method returns an Instance of the Database
    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    // method to get the password  of userName
    public String getSinlgeEntry(String userName)
    {
        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("user", null, "username=?", new String[]{userName}, null, null, null);
        if(cursor!=null && cursor.getCount() >= 1) // UserName Not Exist
            cursor.moveToNext();
        getPassword= cursor.getString(cursor.getColumnIndex("password"));
        return getPassword;
    }

}
