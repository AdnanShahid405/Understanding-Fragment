package com.example.quiz_practice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String Database_name= "ContactsDB";
    private static final String TABLE_NAME="contact";
    private static final String ID="id";
    private static final String name="name";
    private static final String number="number";

    public MyDBHelper(Context context) {
        super(context, Database_name,null,1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + name+" TEXT, "
        + number+ " TEXT)");
        SQLiteDatabase database= getWritableDatabase();
        database.close();
    //create table contact(ID
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addContact(String name1, String number1)
    {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name, name1);
        values.put(number, number1);
        db.insert(TABLE_NAME, null, values);
    }
    public ArrayList<ContectModel> fetchContact(){
        SQLiteDatabase db1= getReadableDatabase();
       Cursor cursor= db1.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
       ArrayList<ContectModel> addcontect= new ArrayList<>();
       while (cursor.moveToNext()){
           ContectModel model= new ContectModel();
           model.id= cursor.getInt(0);
           model.name= cursor.getString(1);
           model.number= cursor.getString(2);
           addcontect.add(model);
       }
        return addcontect;
    }
}
