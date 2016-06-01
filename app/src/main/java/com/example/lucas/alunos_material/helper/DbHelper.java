package com.example.lucas.alunos_material.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Lucas on 01/10/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String NAME = "db_aluno";
    private static final int VERSION = 8;

    //Variaveis da tabela curso
    public static final String TAB_CURSO = "TAB_CURSO";
    public static final String campoNomeCurso = "NOME_CURSO";
    public static final String tempoCurso = "TEMP_CURSO";
    public static final String descricaoCurso = "DESC_CURSO";
    public static final String cordenadorCurso = "CORD_CURSO";
    public static final String palavraCordenador = "PALAVRA_CORD_CURSO";
    public static final String palavraAluno = "PALAVRA_ALUNO_CURSO";
    public static final String caminhofoto = "FOTO_CURSO";


    public DbHelper(Context ctx) {
        super(ctx, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            String sql = "CREATE TABLE " + TAB_CURSO
                    + " (id INTEGER PRIMARY KEY," +
                    campoNomeCurso + " TEXT UNIQUE NOT NULL," +
                    tempoCurso + " TEXT NOT NULL," +
                    descricaoCurso + " TEXT NOT NULL," +
                    cordenadorCurso + " TEXT NOT NULL," +
                    palavraCordenador + " TEXT NOT NULL," +
                    palavraAluno + " TEXT NOT NULL," +
                    caminhofoto + " TEXT " +
                    " );";

            db.execSQL(sql);

            db.execSQL("INSERT INTO " + TAB_CURSO + "(" + campoNomeCurso + "," + tempoCurso + "," + descricaoCurso + "," + cordenadorCurso + "," + palavraCordenador + "," + palavraAluno + ")" +
                    " VALUES ('Sistemas de Informação', '8 Semestres', 'TAL', 'DELFINO', 'Vem pra FIO', 'Nao quero');" );
            Log.i("INFO", "Tabela foi criada com suceso" );
        }catch (Exception e){
            Log.e("INFO", "Erro ao Criar tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            String sql = "DROP TABLE IF EXISTS " + TAB_CURSO + ";";
            db.execSQL(sql);
            onCreate(db);

            Log.i("INFO", "Nova versao funcionando");
        }catch (Exception e){
            Log.e("INFO", "Erro ao dropar tabela" + e.getMessage());
        }
    }
}
