package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Esuara, Ejabatan;
    private String Snama, Ssuara, Sjabatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Esuara = (EditText) findViewById(R.id.create_suara);
        Ejabatan = (EditText) findViewById(R.id.create_jabatan);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Ssuara = String.valueOf(Esuara.getText());
                Sjabatan = String.valueOf(Ejabatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Ssuara.equals("")){
                    Esuara.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis suara",
                            Toast.LENGTH_SHORT).show();
                }else if (Sjabatan.equals("")){
                    Ejabatan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jabatan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Esuara.setText("");
                    Ejabatan.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePaduanSuara(new Mahasiswa(null, Snama, Ssuara, Sjabatan));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

