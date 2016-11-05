package com.magacho.smartuva.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.magacho.smartuva.FragmentGrade;
import com.magacho.smartuva.GradeListView.InformacoesMateria;
import com.magacho.smartuva.GradeListView.Materia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luizmagacho on 25/10/16.
 */
public class GradeDB extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    public static final String NOME_BANCO = "smartuva.sqlite";
    private static final int VERSAO_BANCO = 1;
    private SQLiteDatabase db;

    public GradeDB(Context context) {
        //context, nome do banco, factory, versão
        super(context, NOME_BANCO, null, VERSAO_BANCO);


        Log.d(TAG, "Criando bd...");



    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Criando a Tabela Grade...");

        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE GRADE_DB( ");
        query.append(" ID_GRADE INTEGER PRIMARY KEY AUTOINCREMENT,");
        query.append(" TURMA TEXT(7) NOT NULL,");
        query.append(" MATERIA TEXT(30) NOT NULL,");
        query.append(" HORARIO TEXT(5) NOT NULL,");
        query.append(" DIA_SEMANA TEXT(10) NOT NULL,");
        query.append(" PROFESSOR TEXT(50) NOT NULL,");
        query.append(" SALA TEXT(7) NOT NULL)");

        db.execSQL(query.toString());
        Log.d(TAG, "Tabela Grade criada com sucesso.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso mude a versão do banco de dados, podemos executar um SQL aqui
    }

    public void popularBD() {
        //Caso não haja WebService, aqui irá incluir os dados no SQLite


        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO GRADE_DB(TURMA, MATERIA, HORARIO, DIA_SEMANA, PROFESSOR, SALA) VALUES(?, ?, ?, ?, ?, ?)");


        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL(query.toString(), new String[] {"1ECP38A","TOP ESP DISPOSITIVOS MOVEIS", "20:30", "TERÇA-FEIRA", "MATTHEUS DA HORA", "LAB. INFO 10"});
        db.execSQL(query.toString(), new String[] {"1ECP38A", "PROJETO ORIENTADO A OBJETOS", "20:30", "SEGUNDA-FEIRA", "JOBSON MAZZOLAR", "LAB. INFO 7"});
        db.execSQL(query.toString(), new String[] {"1INF34B", "ESTRUTURA DE DADOS I", "18:20", "TERÇA-FEIRA", "ELIANE XAVIER", "LAB. INFO 9"});
        db.execSQL(query.toString(), new String[] {"1INF36A", "SISTEMAS DISTRIBUÍDOS", "18:20", "QUINTA-FEIRA", "MATHEUS BANDINI", "TJC415"});
        db.execSQL(query.toString(), new String[] {"1ECP39A", "TOP ESP EM ARQUITETURA PARA ALTO DESEMPENHO", "20:30", "QUINTA-FEIRA", "MATHEUS BANDINI", "TJC220"});
        db.execSQL(query.toString(), new String[] {"1ECP38A", "PROJETO ORIENTADO A OBJETOS", "18:20", "SEXTA-FEIRA", "JOBSON MAZZOLAR", "LAB. INFO 7"});
        db.execSQL(query.toString(), new String[] {"1INF34B", "REDES DE COMPUTADORES I", "20:30", "SEXTA-FEIRA", "ELIAS RESTUM", "TJA327"});
        //db.execSQL(query.toString(), new String[]{"20111999871", "1234", "2"});

    }

    public void getLista(){
        List<InformacoesMateria> informacoesMateria = new ArrayList<InformacoesMateria>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(" SELECT * FROM GRADE_DB;", null);

        while(c.moveToNext()){
            InformacoesMateria info = new InformacoesMateria();
            Materia materia = new Materia();

            materia.setName(c.getString(c.getColumnIndex("MATERIA")));

            info.setDia(c.getString(c.getColumnIndex("DIA_SEMANA")));
            info.setHorario(c.getString(c.getColumnIndex("HORARIO")));
            info.setTurma(c.getString(c.getColumnIndex("TURMA")));
            info.setProfessor(c.getString(c.getColumnIndex("PROFESSOR")));
            info.setSala(c.getString(c.getColumnIndex("SALA")));


            informacoesMateria.add(info);
        }
        c.close();
        //return informacoesMateria;
    }
}
