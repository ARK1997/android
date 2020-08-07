package com.example.customlistview_bloodgroup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

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
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+PersonConstants.DB_TABLE);
            onCreate(sqLiteDatabase);
    }


    public boolean insertData(Person person){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PersonConstants.NAME,person.getName());
        contentValues.put(PersonConstants.DESCRIPTION,person.getDescription());
        contentValues.put(PersonConstants.BLOOD,person.getBlood_grp());
        contentValues.put(PersonConstants.URL, person.getURL());

         long result = db.insert(PersonConstants.DB_TABLE,null,contentValues);
        //insert returns -1, if data is not inserted

         return (result!=-1)?true:false;
    }

    public Cursor viewData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + PersonConstants.DB_TABLE;
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public void deleteItem() {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE from "+ PersonConstants.DB_TABLE);
    }

    public ArrayList<Person> getData(){

        ArrayList<Person> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(PersonConstants.DB_TABLE,null,null,null,null,null,null);




            cursor.moveToFirst();
            while (cursor.moveToNext())
            {
                String name = cursor.getString(cursor.getColumnIndex(PersonConstants.NAME));
                String desc = cursor.getString(cursor.getColumnIndex(PersonConstants.DESCRIPTION));
                String blood = cursor.getString(cursor.getColumnIndex(PersonConstants.BLOOD));
                String url = cursor.getString(cursor.getColumnIndex(PersonConstants.URL));
                Person p = new Person(name,desc,blood,url);

                list.add(p);

        }

        return list;
    }

}
