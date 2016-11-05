package com.magacho.smartuva;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.magacho.smartuva.database.LoginDB;

/**
 * Created by luizmagacho on 01/11/16.
 */
public class LoginDAO extends LoginDB {
    private final String TABLE = "LOGIN_DB";
    Cursor cursor;

    public LoginDAO(Context context) {
        super(context);
    }

    public boolean isValidoLogin(String matricula, String senha){
        //String sql = "SELECT * FROM " + TABLE + " WHERE MATRICULA = ? AND SENHA=? ;";
        SQLiteDatabase db = getReadableDatabase();
        String[] parametros = {matricula, senha};
       //String[] selectionArgs = new String[] { matricula, senha };
        //while(cursor.moveToFirst()){
            //cursor = getDatabase().rawQuery(sql, null);
            Cursor rawQuerry = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE + " WHERE MATRICULA = ? AND SENHA=? ;", parametros);
            //if(matricula.equals(cursor.getString(cursor.getColumnIndex("MATRICULA")) && );
            //cursor.moveToFirst();
            return true;
        //}
        //cursor.close();
        //return true;
    }
}
