package com.magacho.smartuva.Login;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.magacho.smartuva.LoginDAO;
import com.magacho.smartuva.R;
import com.magacho.smartuva.ValidacaoLogin;
import com.magacho.smartuva.database.LoginDB;

/**
 * Created by luizmagacho on 05/10/15.
 */
public class LoginBO {

    private Context context;
    private LoginDB loginDB;
    private LoginDAO loginDAO;



    public LoginBO(Activity activity){

        loginDB = new LoginDB(activity);
        loginDB.popularBD();
        loginDAO = new LoginDAO(activity);

    }

    public ValidacaoLogin validarLogin(String matricula, String senha) {

        ValidacaoLogin retorno = new ValidacaoLogin();



        if (matricula == null || matricula.equals("")) {
            retorno.setValido(false);
            retorno.setMensagem("Matricula Obrigatória!");
        } else if (senha == null || senha.equals("")) {
            retorno.setValido(false);
            retorno.setMensagem("Senha Obrigatória!");
        } else if ((loginDAO.isValidoLogin(matricula, senha) )) {
            retorno.setValido(true);
            retorno.setMensagem("Login feito com sucesso!");
        } else {
            retorno.setValido(false);
            retorno.setMensagem("Login Inválido!");
        }
        return retorno;
    }

    public ValidacaoLogin validarLoginProf(String matricula, String senha) {

        ValidacaoLogin retorno = new ValidacaoLogin();

        if (matricula == null || matricula.equals("")) {
            retorno.setValido(false);
            retorno.setMensagem("Matricula Obrigatória!");
        } else if (senha == null || senha.equals("")) {
            retorno.setValido(false);
            retorno.setMensagem("Senha Obrigatória!");
        } else if ((matricula.equals("200") && senha.equals("456")) ) {
            retorno.setValido(true);
            retorno.setMensagem("Login feito com sucesso!");
        } else {
            retorno.setValido(false);
            retorno.setMensagem("Login Inválido!");
        }
        return retorno;
    }
}
