package com.example.lucas.alunos_material.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.adapter.AlunoAdapter;
import com.example.lucas.alunos_material.dao.AlunoDAO;
import com.example.lucas.alunos_material.modelo.Curso;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    private ListView listViewAlunos;
    private Curso aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_alunos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaAlunosActivity.this, FormularioAlunosActivity2.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        recarregarLista();
        super.onResume();
    }

    private void recarregarLista() {
        listViewAlunos = (ListView) findViewById(R.id.listaDeAlunos);
        registerForContextMenu(listViewAlunos);

        AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
        List<Curso> alunos = dao.getLista();
        listViewAlunos.setAdapter(new AlunoAdapter(this, (ArrayList<Curso>) alunos));

        /* Vizualizar Curso no Formulario*/
        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Curso alunoParaSerAlterado = (Curso) parent.getItemAtPosition(position);

                Intent visualizar = new Intent(ListaAlunosActivity.this, FormularioAlunosActivity2.class);
                visualizar.putExtra("alunoSelecionado", alunoParaSerAlterado);
                startActivity(visualizar);
            }
        });

        /*Pega a posição do curso */
        listViewAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                aluno = (Curso) parent.getItemAtPosition(position);
                return false;
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


        /*Deletar curso do formulario*/
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlunoDAO dao = new AlunoDAO(ListaAlunosActivity.this);
                dao.deletar(aluno);
                recarregarLista();
                Toast.makeText(ListaAlunosActivity.this, "Curso Apagado", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}

