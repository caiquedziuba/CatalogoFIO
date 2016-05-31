package com.example.lucas.alunos_material.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.modelo.Curso;

import java.util.ArrayList;

/**
 * Created by Lucas on 04/10/2015.
 */
public class AlunoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Curso> lista;

    public AlunoAdapter(Context context, ArrayList<Curso> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Curso aluno = lista.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.lista_alunos_adapter, null);

        TextView nome = (TextView) layout.findViewById(R.id.nome_adapter);
        nome.setText(aluno.getNomeCurso());

        TextView telefone = (TextView) layout.findViewById(R.id.telefone_adapter);
        telefone.setText(aluno.getDescricaoCurso());


        return layout;
    }
}
