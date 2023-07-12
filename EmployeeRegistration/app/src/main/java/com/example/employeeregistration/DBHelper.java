package com.example.employeeregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, "empData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE empDetails(empid TEXT, name TEXT, age TEXT, department TEXT, salary TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS empDetails");
    }

    public boolean inserData(String empid, String name, String age, String department, String salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("empid", empid);
        cv.put("name", name);
        cv.put("age", age);
        cv.put("department", department);
        cv.put("salary", salary);
        long result = db.insert("empDetails", null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM empDetails", null);
        return cursor;
    }
}
