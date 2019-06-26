package com.example.projetobank.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetobank.SharedPrefManager;
import com.example.projetobank.R;
import com.example.projetobank.model.User;
import com.example.projetobank.ui.Second;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    Matcher matcher;
    private Button botao;
    Context context;
    private EditText login, password;
    private SharedPrefManager sharedPrefManager;

    public LoginContract.Presenter presenter;
    private LoginResponse loginResponse;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //pelo menos 1 digito
                  //  "(?=.*[a-z])" +         //pelo menos 1 letra minuscula
                   // "(?=.*[A-Z])" +         //pelo menos 1 letra maiuscula
                    "(?=.*[a-zA-Z])" +      //qualquer letra
                    "(?=.*[@#$%^&+=])" +    //pelo menos 1 caracter especial
                    "(?=\\S+$)" +           //sem espaços em branco
                    ".{4,}" +               //pelo menos 4 caracteres
                    "$");
private static final Pattern CPF_PATTERN = Pattern.compile("^" +"(?=.*[0-9])" + ".{11}" + "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefManager = new SharedPrefManager(this);

        login = findViewById(R.id.test_user);
        password = findViewById(R.id.password);
        botao = findViewById(R.id.buttonSignUp);
        verifyLogin();
        presenter = new LoginPresenter(this);

        validateEmail(login.getText().toString());
        validatePassword(password.getText().toString());

        //userSign();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEmail(login.getText().toString()) == true
                && validatePassword(password.getText().toString()) == true){
                    presenter.login(login.getText().toString(), password.getText().toString());
                }

            }
        });

    }
    private boolean validateEmail(String user) {
        String email = login.getText().toString();
        if (email.isEmpty()) {
            login.setError("Login não pode ser nulo");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login.setError("Insira um email válido");
            return false;
        } else {
            login.setError(null);
            return true;
        }
    }
    private boolean validatePassword(String senha1){
        String senha = password.getText().toString();
        if(senha.isEmpty()){
            password.setError("Senha não pode ser nula");
            return false;
        } else if(!PASSWORD_PATTERN.matcher(senha).matches()){
            password.setError("A senha deve ter o minino de 4 caracteres, 1 caracter especial, " +
                    "1 caracter maiusculo e 1 numero");
            return false;
        } else{
            password.setError(null);
            return true;
        }
    }
//    private boolean validateCPF(int user){
//        int cpf = Integer.parseInt(login.getText().toString());
//        if(cpf == 0){
//            login.setError("CPF não pode ser nulo");
//            return false;
//        } else if(!CPF_PATTERN.matcher(String.valueOf(cpf)).matches()){
//            login.setError("CPF deve ter 11 digitos");
//            return false;
//        }else{
//            login.setError(null);
//            return true;
//        }
//    }



    @Override
    public void navigateToList(User user) {

        Intent intent = new Intent(LoginActivity.this, Second.class);
        intent.putExtra("user", user);
        startActivity(intent);
        //saveLogin(user.getName());

    }

    public Context getContext() {
        return this;
    }

    public Context getActivity() {
        return this;
    }

    public void saveLogin(String user) {
        sharedPrefManager.saveLogin(login.getText().toString());
        Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show();
    }

    public void verifyLogin() {
        if (sharedPrefManager.getItsSave() == 1) {
            login.setText(sharedPrefManager.getUser());
        }
    }
}
