package com.example.sqllitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_paduanSuara";
    private static final String tb_paduanSuara = "tb_paduanSuara";
    private static final String tb_padus_id = "id";
    private static final String tb_padus_nama = "nama";
    private static final String tb_padus_suara = "suara";
    private static final String tb_padus_jabatan = "jabatan";
    private static final String CREATE_TABLE_PADUS = "CREATE TABLE " +
            tb_paduanSuara + "("
            + tb_padus_id + " INTEGER PRIMARY KEY ,"
            + tb_padus_nama + " TEXT,"
            + tb_padus_suara + " TEXT, "
            + tb_padus_jabatan + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PADUS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreatePaduanSuara (Mahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_padus_id, mdNotif.get_id());
        values.put(tb_padus_nama, mdNotif.get_nama());
        values.put(tb_padus_suara, mdNotif.get_suara());
        values.put(tb_padus_jabatan, mdNotif.get_jabatan());
        db.insert(tb_paduanSuara, null, values);
        db.close();
    }

    public List<Mahasiswa> ReadPaduanSuara() {
        List<Mahasiswa> judulModelList = new ArrayList<Mahasiswa>();
        String selectQuery = "SELECT * FROM " + tb_paduanSuara;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Mahasiswa mdKontak = new Mahasiswa();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_suara(cursor.getString(2));
                mdKontak.set_jabatan(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdatePaduanSuara (Mahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_padus_nama, mdNotif.get_nama());
        values.put(tb_padus_suara, mdNotif.get_suara());
        values.put(tb_padus_jabatan, mdNotif.get_suara());
        return db.update(tb_paduanSuara, values, tb_padus_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeletePaduanSuara (Mahasiswa mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_paduanSuara, tb_padus_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
