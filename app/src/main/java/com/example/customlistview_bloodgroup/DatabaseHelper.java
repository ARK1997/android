package com.example.customlistview_bloodgroup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class DatabaseHelper extends SQLiteOpenHelper {



    public DatabaseHelper(@Nullable Context context) {
        super(context,PersonConstants.DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(PersonConstants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void insertData(Person person){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonConstants.NAME,person.getName());
        contentValues.put(PersonConstants.DESCRIPTION,person.getDescription());
        contentValues.put(PersonConstants.BLOOD,person.getBlood_grp());

        long result= db.insert(PersonConstants.DB_TABLE,null,contentValues);
        //insrt returns -1, if data is not inserted

        //return result!=-1;
    }

    public Cursor viewData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + PersonConstants.DB_TABLE;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

}
