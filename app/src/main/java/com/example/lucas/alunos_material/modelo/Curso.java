package com.example.lucas.alunos_material.modelo;

import java.io.Serializable;

/**
 * Created by Lucas on 01/10/2015.
 */
public class Curso implements Serializable {

    private Long id;
    private String nomeCurso, descricaoCurso, duracaoCurso, foto, cordenador, palavraCordenador, palavraAluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public String getDuracaoCurso() {
        return duracaoCurso;
    }

    public void setDuracaoCurso(String duracaoCurso) {
        this.duracaoCurso = duracaoCurso;
    }

    public String getCordenador() {
        return cordenador;
    }

    public void setCordenador(String cordenador) {
        this.cordenador = cordenador;
    }

    public String getPalavraCordenador() {
        return palavraCordenador;
    }

    public void setPalavraCordenador(String palavraCordenador) {
        this.palavraCordenador = palavraCordenador;
    }

    public String getPalavraAluno() {
        return palavraAluno;
    }

    public void setPalavraAluno(String palavraAluno) {
        this.palavraAluno = palavraAluno;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Curso: " + getNomeCurso() + "\nDuração: " + getDescricaoCurso();
    }
}
