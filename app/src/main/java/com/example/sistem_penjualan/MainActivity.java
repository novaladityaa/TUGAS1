package com.example.sistem_penjualan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
    private Button btnproses;
    private Button btnexit;
    private Button btnhapus;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("STMIK PONTIANAK STORE");

        edtnamapel=(EditText)findViewById(R.id.namapelanggan);
        edtnamabar=(EditText)findViewById(R.id.namabarang);
        edtjumlahbel=(EditText)findViewById(R.id.jumlahbeli);
        edtharga=(EditText)findViewById(R.id.harga);
        edtuangbay=(EditText)findViewById(R.id.uangbayar);
        btnproses=(Button)findViewById(R.id.tombol1);
        btnhapus=(Button) findViewById(R.id.tombol2);
        btnexit=(Button) findViewById(R.id.tombol3);
        txtnamapel=(TextView) findViewById(R.id.namapelanggan);
        txtnamabar=(TextView)findViewById(R.id.namabarang);
        txtjumlahbel=(TextView)findViewById(R.id.jumlahbeli);
        txtharga=(TextView)findViewById(R.id.harga);
        txtuangbay=(TextView)findViewById(R.id.uangbayar);
        txtbonus=(TextView)findViewById(R.id.bonus);
        txttotalbelanja=(TextView)findViewById(R.id.totalbelanja);
        txtuangkembali=(TextView)findViewById(R.id.uangkembali);
        txtketerangan=(TextView)findViewById(R.id.keterangan);

        //MMEBERIKAN ACTION PADA TOMBOL PROSES
        btnproses.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " +total);

                //PEMBERIAN IF ELSE PADA ATURAN PEMBERIAN BONUS
                if (total>=200000){
                    txtbonus.setText("Bonus: Mouse");
                }else if (total>=50000){
                    txtbonus.setText("Bonus: Keyboard");
                }else if (total>=40000){
                    txtbonus.setText("Bonus: Hardisk");
                }else{
                    txtbonus.setText("Bonus: Tidak dapat bonus! ");
                }
                double uangkembalian=(ub-total);
                if(ub<total){
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp."+(-uangkembalian));
                    txtuangkembali.setText("Uang kembali : Rp 0");
                }
                else{
                    txtketerangan.setText("Keterangan: Tunggu kembalian");
                    txtuangkembali.setText("Uang kembali : "+uangkembalian);
                }

                //MEMBERIKAN ACTION PADA TOMBOL KELUAR
            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText("Total belanja : Rp 0 ");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("Uang kembali : Rp 0  ");
                txtbonus.setText("Bonus : - ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(), "DATA SUDAH DIRESET", Toast.LENGTH_LONG).show();

                //MEMBERIKAN ACTION PADA TOMBO KELUAR
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moveTaskToBack(true);
            }
        });
    }
}
