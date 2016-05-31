package com.example.lucas.alunos_material.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lucas.alunos_material.helper.DbHelper;
import com.example.lucas.alunos_material.modelo.Curso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 01/10/2015.
 */
public class AlunoDAO {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public AlunoDAO(Context ctx) {
        DbHelper helper = new DbHelper(ctx);
        escreve = helper.getWritableDatabase();
        le = helper.getReadableDatabase();
    }

    public void insere(Curso aluno) {
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.campoNomeCurso, aluno.getNomeCurso());
        cv.put(DbHelper.tempoCurso, aluno.getDuracaoCurso());
        cv.put(DbHelper.descricaoCurso, aluno.getDescricaoCurso());
        cv.put(DbHelper.caminhofoto, aluno.getFoto());
        cv.put(DbHelper.cordenadorCurso, aluno.getCordenador());
        cv.put(DbHelper.palavraCordenador, aluno.getPalavraCordenador());
        cv.put(DbHelper.palavraAluno, aluno.getPalavraAluno());

        try {
            escreve.insert(DbHelper.TAB_CURSO, null, cv);
            Log.i("INFO", "Dados Inseridos");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao Inserir Dado" + e.getMessage());
        }
    }

    public List<Curso> getLista() {
        String sql = "SELECT * FROM " + DbHelper.TAB_CURSO + ";";
        Cursor c = le.rawQuery(sql, null);

        ArrayList<Curso> cursos = new ArrayList<Curso>();

        while (c.moveToNext()){
            Curso aluno = new Curso();

            aluno.setId(c.getLong(c.getColumnIndex("id")));
            aluno.setNomeCurso(c.getString(c.getColumnIndex(DbHelper.campoNomeCurso)));
            aluno.setDuracaoCurso(c.getString(c.getColumnIndex(DbHelper.tempoCurso)));
            aluno.setDescricaoCurso(c.getString(c.getColumnIndex(DbHelper.descricaoCurso)));
            aluno.setFoto(c.getString(c.getColumnIndex(DbHelper.caminhofoto)));
            aluno.setFoto(c.getString(c.getColumnIndex(DbHelper.cordenadorCurso)));
            aluno.setFoto(c.getString(c.getColumnIndex(DbHelper.palavraCordenador)));
            aluno.setFoto(c.getString(c.getColumnIndex(DbHelper.palavraAluno)));


            cursos.add(aluno);
        }
        return cursos;
    }

    public void deletar(Curso aluno) {
        String[] args = {aluno.getId().toString()};
        escreve.delete(DbHelper.TAB_CURSO, "id=?", args);
    }

    public void atualizar(Curso aluno) {
        ContentValues cv = new ContentValues();
        cv.put(DbHelper.campoNomeCurso, aluno.getNomeCurso());
        cv.put(DbHelper.tempoCurso, aluno.getDuracaoCurso());
        cv.put(DbHelper.descricaoCurso, aluno.getDescricaoCurso());
        cv.put(DbHelper.cordenadorCurso, aluno.getCordenador());
        cv.put(DbHelper.palavraCordenador, aluno.getPalavraCordenador());
        cv.put(DbHelper.palavraAluno, aluno.getPalavraAluno());
        cv.put(DbHelper.caminhofoto, aluno.getFoto());

        try {
            String[] args = {aluno.getId().toString()};

            escreve.update(DbHelper.TAB_CURSO, cv, "id=?", args);

            Log.i("INFO", "Dados Atualizados");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao Inserir Dado" + e.getMessage());
        }
    }
}
