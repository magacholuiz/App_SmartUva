package com.magacho.smartuva.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.magacho.smartuva.GradeBO;
import com.magacho.smartuva.HomeActivity;
import com.magacho.smartuva.R;
import com.magacho.smartuva.ValidacaoLogin;
import com.magacho.smartuva.NavigationAndFragment_Prof.*;
import com.magacho.smartuva.database.GradeDB;
import com.magacho.smartuva.database.LoginDB;
import com.android.volley.Request;



public class LoginActivity extends ActionBarActivity {

    private LoginBO loginBO;

    private EditText edtMatricula;

    private EditText edtSenha;

    private String matricula, senha;

    private boolean aluno, professor;

    private RadioButton rbAluno;

    private RadioButton rbProfessor;

    //private LoginDB loginDB;

    private GradeBO gradeBO;

    //private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.uva_menu);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle(null);

        //LoginDB loginDB = new LoginDB(this);
        loginBO = new LoginBO(this);
        gradeBO = new GradeBO(this);

        //gradeDB = new GradeDB(this);
        //loginDB.onCreate();


        edtMatricula = (EditText) findViewById(R.id.matricula_input);
        edtSenha = (EditText) findViewById(R.id.senha_input);
        rbAluno = (RadioButton) findViewById(R.id.aluno);
        rbProfessor = (RadioButton)findViewById(R.id.professor);

        //loginDB.recuperar_login();





        }

    public void entrar(View view){

        //Pegando os dados digitados nos EditText e trnasformando eles em String
        matricula = edtMatricula.getText().toString();
        senha = edtSenha.getText().toString();

        aluno = rbAluno.isChecked();

        professor = rbProfessor.isChecked();


        //Chamando o AsyncTask apra executar as tarefas nele contidas
        new LoadingAsync().execute();

    }


    private class LoadingAsync extends AsyncTask<Void, Void, ValidacaoLogin> {

        ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);

        @Override
        protected void onPreExecute(){

            //Serve para mostrar alguma informação enquanto está executando o background, no caso só uma tela de loading
            progressDialog.setTitle("Carregando...");
            progressDialog.show();
        }

        @Override
        protected ValidacaoLogin doInBackground(Void... params) {

            //Executa os comandos no em plano de fundo para que não atrapalhe o usuário


            loginBO = new LoginBO(LoginActivity.this);

            if(aluno){
                return loginBO.validarLogin(matricula, senha);
            }
            else
                return loginBO.validarLoginProf(matricula,senha);




        }

        @Override
        protected void onPostExecute(ValidacaoLogin validacao) {

            //Retirar a tela de loading
            progressDialog.dismiss();

            //Executa após os comando em plano de fundo forem totalmente executados

            if (validacao.isValido() && rbAluno.isChecked()) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                i.putExtra("msg", validacao.getMensagem());
                startActivity(i);
                finish();
            }
            else if(validacao.isValido() && rbProfessor.isChecked()){
                Intent i = new Intent(LoginActivity.this, HomeProfActivity.class);
                i.putExtra("msg", validacao.getMensagem());
                startActivity(i);
                finish();
            }
            else if(!validacao.isValido()){
                Toast.makeText(getApplicationContext(), "Matricula ou Senha inválidos!", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Escolha Aluno ou Professor", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

   /* // Instantiate the RequestQueue.
    RequestQueue queue = Volley.newRequestQueue(this);
    String url ="http://www.google.com";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    mTextView.setText("Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mTextView.setText("That didn't work!");
        }
    });
// Add the request to the RequestQueue.
    queue.add(stringRequest);*/
}
