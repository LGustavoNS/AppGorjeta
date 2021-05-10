package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor;
    private TextView txtPorcentagem;
    private TextView txtGorjeta;
    private TextView txtTotal;
    private SeekBar seekBarProgresso;

    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor            = findViewById(R.id.edtValor);
        txtGorjeta          = findViewById(R.id.txtGorjeta);
        txtPorcentagem      = findViewById(R.id.txtPorcentagem);
        txtTotal            = findViewById(R.id.txtTotal);
        seekBarProgresso    = findViewById(R.id.seekBarProgresso);

        //Adicionar listener SeekBar
        seekBarProgresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                txtPorcentagem.setText( Math.round( porcentagem ) + "%" );
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String valorRecuperado = edtValor.getText().toString();
        if(valorRecuperado ==  null || valorRecuperado.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro! ",
                    Toast.LENGTH_LONG
            ).show();
        }else {

            //Converter string para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibir a gorjeta e total
            //txtGorjeta.setText("R$: " + Math.round(gorjeta) );
            txtGorjeta.setText("R$: " + gorjeta );
            txtTotal.setText("R$: " + total );
        }

    }

}