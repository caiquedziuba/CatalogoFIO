package com.example.lucas.alunos_material.helper;

import android.widget.EditText;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.activity.FormularioAlunosActivity2;
import com.example.lucas.alunos_material.modelo.Curso;

/**
 * Created by Lucas on 01/10/2015.
 */
public class FormularioCursoHelper {

    private EditText campoCurso, campoDescricao, campoDuracao, campoCordenador, campoWordCordenador, campoWordAluno;
    private String nomeCurso, descricao, duracao, cordenador, wordCordenador, wordAluno;
    Curso curso;

    public FormularioCursoHelper(FormularioAlunosActivity2 f) {

        campoCurso = (EditText) f.findViewById(R.id.nomeCurso);
        campoDescricao = (EditText) f.findViewById(R.id.descricaoCurso);
        campoDuracao = (EditText) f.findViewById(R.id.duracaoCurso);
        campoCordenador = (EditText) f.findViewById(R.id.cordenador);
        campoWordCordenador = (EditText) f.findViewById(R.id.wordCordenador);
        campoWordAluno = (EditText) f.findViewById(R.id.wordAluno);
    }

    public Curso pegaCursoDoFormulario(){

        nomeCurso = campoCurso.getText().toString();
        descricao = campoDescricao.getText().toString();
        duracao = campoDuracao.getText().toString();
        cordenador = campoCordenador.getText().toString();
        wordCordenador = campoWordCordenador.getText().toString();
        wordAluno = campoWordAluno.getText().toString();

        curso = new Curso();

        curso.setNomeCurso(nomeCurso);
        curso.setDuracaoCurso(descricao);
        curso.setDuracaoCurso(duracao);
        curso.setCordenador(cordenador);
        curso.setPalavraCordenador(wordCordenador);
        curso.setPalavraAluno(wordAluno);


        return curso;
    }

    public void colocaCursoNoFormulario(Curso alunoAlterado) {
       campoCurso.setText(alunoAlterado.getNomeCurso());
       campoDescricao.setText(alunoAlterado.getDuracaoCurso());
       campoDuracao.setText(alunoAlterado.getDescricaoCurso());
       campoCordenador.setText(alunoAlterado.getCordenador());
       campoWordCordenador.setText(alunoAlterado.getPalavraCordenador());
       campoWordAluno.setText(alunoAlterado.getPalavraAluno());
    }
}
