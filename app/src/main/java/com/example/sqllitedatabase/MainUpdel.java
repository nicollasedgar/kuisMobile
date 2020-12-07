package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Ssuara, Sjabatan;
    private EditText Enama, Esuara, Ejabatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Ssuara = i.getStringExtra("Isuara");
        Sjabatan = i.getStringExtra("Ijabatan");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Esuara = (EditText) findViewById(R.id.updel_suara);
        Ejabatan = (EditText) findViewById(R.id.updel_jabatan);
        Enama.setText(Snama);
        Esuara.setText(Ssuara);
        Ejabatan.setText(Sjabatan);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Ssuara = String.valueOf(Esuara.getText());
                Sjabatan = String.valueOf(Ejabatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Ssuara.equals("")){
                    Esuara.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis suara",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjabatan.equals("")){
                    Ejabatan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jabatan",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdatePaduanSuara(new Mahasiswa(Sid, Snama, Ssuara, Sjabatan));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePaduanSuara(new Mahasiswa(Sid, Snama, Ssuara, Sjabatan));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
