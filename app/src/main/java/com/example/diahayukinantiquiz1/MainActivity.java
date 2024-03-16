package com.example.diahayukinantiquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etnama, etkode, etjumlah;
    RadioGroup radioGroup;
    Button btnproses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnama = findViewById(R.id.etnama);
        etkode = findViewById(R.id.etkode);
        etjumlah = findViewById(R.id.etjumlah);
        radioGroup = findViewById(R.id.radioGroup);
        btnproses = findViewById(R.id.btnproses);

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processTransaction();
            }
        });

    }

    private void processTransaction() {
        String nama = etnama.getText().toString().trim();
        String kode = etkode.getText().toString().trim();
        int jumlah = Integer.parseInt(etjumlah.getText().toString().trim());
        String tipepelanggan = getTipepelanggan();

        Intent intent = new Intent(MainActivity.this, TotalHarga.class);
        intent.putExtra("nama", nama);
        intent.putExtra("Kode", kode);
        intent.putExtra("jumlah", jumlah);
        intent.putExtra("tipepelanggan", tipepelanggan);
        startActivity(intent);
    }
    private String getTipepelanggan() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        return selectedRadioButton.getText().toString();
    }
}