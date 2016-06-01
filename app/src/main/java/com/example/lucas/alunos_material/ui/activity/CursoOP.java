package com.example.lucas.alunos_material.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.example.lucas.alunos_material.R;
import com.example.lucas.alunos_material.ui.fragment.CursoFragment;
import com.example.lucas.alunos_material.ui.fragment.DepoimentosFragment;
import com.example.lucas.alunos_material.ui.fragment.GradeFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


public class CursoOP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curso_op);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_opCurso);
        toolbar.setTitle("Detalhe do Curso");
        setSupportActionBar(toolbar);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Curso", CursoFragment.class)
                .add("Grade", GradeFragment.class)
                .add("Depoimentos", DepoimentosFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
    }
}
