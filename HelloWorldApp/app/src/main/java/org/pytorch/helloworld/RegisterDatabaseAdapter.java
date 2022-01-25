package org.pytorch.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import org.pytorch.helloworld.bean.User;

public class RegisterDatabaseAdapter {
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
            ");\n";


    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private static DataBaseHelper dbHelper;
    public RegisterDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method to openthe Database
    public  RegisterDatabaseAdapter open() throws SQLException
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

    // method to insert a record in Table
    public String insertEntry(User user)
    {

        try {
            ContentValues newValues = new ContentValues();
            // Assign values for each column.
            newValues.put("username", user.getUsername());
            newValues.put("password", user.getPassword());
            newValues.put("telephone", user.getTelephone());
            newValues.put("email", user.getEmail());
            newValues.put("age", user.getAge());
            newValues.put("sex", user.getSex());

            // Insert the row into your table
            db = dbHelper.getWritableDatabase();
            long result = db.insert("user", null, newValues);
            System.out.print("result:" + result);
            Log.e("Note", String.valueOf(result));
            Toast.makeText(context, "注册成功!", Toast.LENGTH_LONG).show();

        }catch(Exception ex) {
            System.out.println("Exceptions " + ex);
            Log.e("Note", "One row entered");
        }
        return ok;
    }

}
