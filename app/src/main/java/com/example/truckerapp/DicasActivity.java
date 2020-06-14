package com.example.truckerapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class DicasActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas);

        TextView dicas = (TextView) findViewById(R.id.lblTextoDicas);
        String dicasText = "- Use filtro solar;\n" +
                "- Evite o consumo de bebidas alcoólicas;\n" +
                "- Não dirija mais de 5 horas de forma constante;\n" +
                "- Alongue-se a cada parada;\n" +
                "- Se alimente de forma saudável;\n" +
                "- Se for uma viagem longa, lembre-se de descansar 11 horas antes de inicia-la novamente;\n" +
                "- Em casos de perigo, utilize o botão SOS na tela anterior para pedir ajudar." +
                "\n\nBoa viagem!";

        dicas.setText(dicasText);
    }
}
