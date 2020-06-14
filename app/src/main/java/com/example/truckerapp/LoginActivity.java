package com.example.truckerapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.truckerapp.controller.TruckerappBDController;
import com.example.truckerapp.model.Usuario;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnCadastrarSe = (Button) findViewById(R.id.btnCadastreSe);
        Button btnLogar = (Button) findViewById(R.id.btnLogar);

        btnCadastrarSe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent irParaCadastrarUsuarioActivity = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(irParaCadastrarUsuarioActivity);
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TruckerappBDController crud = new TruckerappBDController(getBaseContext());

                Boolean resultado;

                EditText usuario = (EditText)findViewById(R.id.edtTextLogin_loginActivity);
                EditText senha = (EditText)findViewById(R.id.edtTxtPassword_loginActivity);

                Usuario user = new Usuario();

                user.setUsuario(usuario.getText().toString());
                user.setPassword(senha.getText().toString());

                resultado = crud.logarUsuario(user);

                if(resultado) {
                    Toast.makeText(getApplicationContext(), "Bem vinda " + user.getNome(), Toast.LENGTH_LONG).show();
                    Intent irParaMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(irParaMainActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Falha ao Autenticar Usuário", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
