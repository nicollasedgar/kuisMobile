package com.example.sqllitedatabase;

public class Mahasiswa {
    private String _id, _nama, _suara, _jabatan;
    public Mahasiswa (String id, String nama, String suara, String jabatan) {
        this._id = id;
        this._nama = nama;
        this._suara = suara;
        this._jabatan = jabatan;
    }
    public Mahasiswa() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_suara() {
        return _suara;
    }
    public void set_suara(String _suara) {
        this._suara = _suara;
    }
    public void set_jabatan(String _jabatan){
        this._jabatan = _jabatan;
    }
    public String get_jabatan() {
        return _jabatan;
    }
}

