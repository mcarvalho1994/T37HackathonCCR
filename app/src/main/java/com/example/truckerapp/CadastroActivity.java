package com.example.truckerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.truckerapp.controller.TruckerappBDController;
import com.example.truckerapp.model.Usuario;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadastroActivity extends Activity {

    EditText usuario;
    EditText senha;
    EditText nome;
    EditText celular;
    EditText data_nascimento;
    EditText marcaCaminhao;
    EditText modeloCaminhao;
    EditText placaCaminhao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuario = (EditText)findViewById(R.id.edtTextUsuario_cadastroActivity);
        senha = (EditText)findViewById(R.id.edtTextPassword_cadastroActivity);
        nome = (EditText)findViewById(R.id.edtTextNome);
        celular = (EditText)findViewById(R.id.edtTextCelular);
        data_nascimento = (EditText)findViewById(R.id.edtTextDataNascimento);
        marcaCaminhao = (EditText)findViewById(R.id.edtTextMarcaCaminhao);
        modeloCaminhao = (EditText)findViewById(R.id.edtTextModeloCaminhao);
        placaCaminhao = (EditText)findViewById(R.id.edtTextPlacaCaminhao);

        SimpleMaskFormatter smfData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskData = new MaskTextWatcher(data_nascimento, smfData);
        data_nascimento.addTextChangedListener(maskData);

        SimpleMaskFormatter smfCelular = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher maskCelular = new MaskTextWatcher(celular, smfCelular);
        celular.addTextChangedListener(maskCelular);

        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TruckerappBDController crud = new TruckerappBDController(getBaseContext());

                Usuario user = new Usuario();
                String resultado;

                user.setUsuario(usuario.getText().toString());
                user.setPassword(senha.getText().toString());
                user.setNome(nome.getText().toString());
                user.setCelular(celular.getText().toString());
                user.setData_nascimento(data_nascimento.getText().toString());
                user.setMarcaCaminhao(marcaCaminhao.getText().toString());
                user.setModeloCaminhao(modeloCaminhao.getText().toString());
                user.setPlacaCaminhao(placaCaminhao.getText().toString());

                resultado = crud.cadastrarUsuario(user);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent irParaLoginActivity = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(irParaLoginActivity);
            }
        });
    }
}
