package com.example.lucas.alunos_material.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.modelo.Curso;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    List<Curso> cursos;
    Context context;

    public CardAdapter(Context context, List<Curso> cursos) {
        this.context = context;
        this.cursos = cursos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_alunos_adapter, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) {

        Curso curso = cursos.get(position);
        holder.campoNome.setText(curso.getNomeCurso());


        holder.campoImage.setImageResource(Integer.parseInt(curso.getFoto()));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView campoImage;
        public TextView campoNome;

        public ViewHolder(View itemView) {
            super(itemView);
            campoImage = (ImageView) itemView.findViewById(R.id.banner);
            campoNome = (TextView) itemView.findViewById(R.id.nomeCurso_adapter);
        }
    }
}
