package com.example.lucas.alunos_material.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.adapter.CardAdapter;
import com.example.lucas.alunos_material.dao.CursoDAO;
import com.example.lucas.alunos_material.modelo.Curso;

import java.util.List;

public class ListaCursosActivity extends AppCompatActivity {

    private Curso curso;

    private RecyclerView recyclerItens;
    private RecyclerView.LayoutManager mLayoutMananger;
    private RecyclerView.Adapter mAdapter;
    private ImageButton ligarPraFaculdade;
    List<Curso> cursos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cursos FIO");
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onResume() {
        recarregarLista();
        super.onResume();
    }

    private void recarregarLista() {
        CursoDAO cursoDAO = new CursoDAO(this);
        cursos = cursoDAO.getLista();

        recyclerItens = (RecyclerView)findViewById(R.id.rv_cursos);
        recyclerItens.setHasFixedSize(true);

        mLayoutMananger = new LinearLayoutManager(this);
        recyclerItens.setLayoutManager(mLayoutMananger);

        mAdapter = new CardAdapter(this, cursos);
        recyclerItens.setAdapter(mAdapter);

        recyclerItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CursoOP.class));
            }
        });
    }
}

