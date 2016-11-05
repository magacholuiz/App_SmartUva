package com.magacho.smartuva.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by luizmagacho on 14/10/16.
 */
public class LoginDB extends SQLiteOpenHelper {

    private static final String TAG ="sql";
    public static final String NOME_BANCO ="smartuva1.sqlite";
    private static final int VERSAO_BANCO = 1;
    private SQLiteDatabase db;

    public LoginDB(Context context){
        //context, nome do banco, factory, versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);

        Log.d(TAG, "Criando bd...");



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando a Tabela Login...");
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE LOGIN_DB( ");
        query.append(" ID_LOGIN INTEGER PRIMARY KEY AUTOINCREMENT,");
        query.append(" MATRICULA TEXT(13) NOT NULL,");
        query.append(" SENHA TEXT(15) NOT NULL,");
        query.append(" ALUNO_OU_PROF TEXT(1) NOT NULL)");

        db.execSQL(query.toString());
        Log.d(TAG, "Tabela login criada com sucesso.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Caso mude a versão do banco de dados, podemos executar um SQL aqui
    }

    public void popularBD(){
        //Caso não haja WebService, aqui irá incluir os dados no SQLite


            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO LOGIN_DB(MATRICULA, SENHA, ALUNO_OU_PROF) VALUES(?, ?, ?)");

            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL(query.toString(), new String[] {"20131103031", "1234", "1"});
            db.execSQL(query.toString(), new String[]{"200", "1234", "2"});

    }

    public void recuperar_login(){
        db = getReadableDatabase();

       Cursor cursor =  db.query("LOGIN_DB", null, null, null, null, null, "matricula");

        while(cursor.moveToNext()){
            Log.d("MATRICULA", cursor.getString(0));

        }
    }

    public boolean isValido(String matricula, String senha){
        db = getReadableDatabase();

        return true;

         }
        //return false;

    public SQLiteDatabase getDatabase() {
        if (db == null) {
            db = getReadableDatabase();
        }
        return db;
    }

}
