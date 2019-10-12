package com.aryatech.kisan;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="farmers_data.db";
    public static final String TABLE_NAME="farmer_table";
    public static final String COL_1="REGISTRATION";
    public static final String COL_2="NAME";
    public static final String COL_3="FATHERS_NAME";
    public static final String COL_4="WARD";
    public static final String COL_5="VILLAGE";
    public static final String COL_6="MOBILE";
    public static final String COL_7="AADHAAR";
    public static final String COL_8="BANK";
    public static final String COL_9="IFSC";





    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (REGISTRATION INTEGER PRIMARY KEY, " +
                "NAME TEXT,FATHERS_NAME TEXT, WARD INTEGER,VILLAGE TEXT,MOBILE INTEGER," +
                "AADHAAR INTEGER,BANK INTEGER, IFSC TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String Registration,String name,String fathers_name,String ward,
                              String village, String mobile, String aadhaar, String bank, String ifsc){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,Registration);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,fathers_name);
        contentValues.put(COL_4,ward);
        contentValues.put(COL_5,village);
        contentValues.put(COL_6,mobile);
        contentValues.put(COL_7,aadhaar);
        contentValues.put(COL_8,bank);
        contentValues.put(COL_9,ifsc);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
