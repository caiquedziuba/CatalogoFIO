package com.example.lucas.alunos_material.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.dao.AlunoDAO;
import com.example.lucas.alunos_material.helper.FormularioCursoHelper;
import com.example.lucas.alunos_material.modelo.Curso;

import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class FormularioAlunosActivity2 extends AppCompatActivity {

    FormularioCursoHelper helper;
    Curso cursoAlterado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_alunos2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarForAluno);
        toolbar.setTitle("Novo Curso");
        setSupportActionBar(toolbar);

        helper = new FormularioCursoHelper(this);

        //Recuperando informações de outra activity
        cursoAlterado = (Curso) getIntent().getSerializableExtra("alunoSelecionado");


           /* Verifica se esta vindo um dado ou não
            se estiver , vai atualizar, se vir nulo vai cadastrar um novo*/
        if(cursoAlterado != null){
            helper.colocaCursoNoFormulario(cursoAlterado);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabFoto);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
                File arquivoFoto = new File(caminhoFoto);

                camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivoFoto));
                startActivity(camera);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnConfirmaAluno) {

            Curso curso = helper.pegaCursoDoFormulario();
            AlunoDAO dao = new AlunoDAO(FormularioAlunosActivity2.this);

            if(cursoAlterado != null){
                curso.setId(cursoAlterado.getId());
                dao.atualizar(curso);
            }else{

                dao.insere(curso);
                Toast.makeText(FormularioAlunosActivity2.this, "Curso Cadastrado", Toast.LENGTH_SHORT).show();
            }

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
