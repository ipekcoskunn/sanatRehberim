package com.ipekcoskun.sanatrehberim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int database_VERSION = 1;
    private static final String database_NAME = "SergiDB";
    private static final String table_SERGILER ="sergiler";
    private static final String sergi_ID = "id";
    private static final String sergi_NAME = "sergiadi";
    private static final String sergi_ARTIST = "sanatci";
    private static final String CREATE_SERGI_TABLE = "CREATE TABLE sergiler(id INTEGER PRIMARY KEY AUTOINCREMENT, sergiadi TEXT, sanatci TEXT)";

    public SQLiteHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
       //super(context, new File(Environment.getExternalStorageDirectory(),database_NAME).toString(),null,database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //tb olustur
        db.execSQL(CREATE_SERGI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_SERGILER);
        this.onCreate(db);
    }
    public void SergiEkle(Sergi sergi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(sergi_NAME,sergi.getSergiadi());
        degerler.put(sergi_ARTIST,sergi.getSanatci());
        db.insert(table_SERGILER,null,degerler);
        db.close();
    }
    public List<Sergi> sergileriGetir(){
        List<Sergi> sergiler = new ArrayList<>();
        String query= "SELECT * FROM " + table_SERGILER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Sergi sergi=null;
        if (cursor.moveToFirst()){
            do {
                sergi = new Sergi();
                sergi.setId(Integer.parseInt(cursor.getString(0)));
                sergi.setSergiadi(cursor.getString(1));
                sergi.setSanatci(cursor.getString(2));
                sergiler.add(sergi);
            }while (cursor.moveToNext());
        }
        return sergiler;


    }
}
