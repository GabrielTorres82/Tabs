package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager2 viewPager;
    ///// NOMBRES DE LAS PESTANIAS ///////////////////
    private String[] nombres = new String[]{"Pestaña 1", "Pestaña 2", "Pestaña 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    viewPager = findViewById(R.id.viewpager);
    viewPager.setAdapter(new MiPagerAdapter(this));
    tabs = findViewById(R.id.tabs);

    /*
    ///// comentamos el primer ejercicio de tabs- pag 131-132 /////
    /////// CREAMOS LAS PESTANIAS //////////////
    tabs.addTab(tabs.newTab().setText("Pestaña 1"));
    tabs.addTab(tabs.newTab().setText("Pestaña 2"));
    tabs.addTab(tabs.newTab().setText("Pestaña 3"));


    ///// SE DA FUNCIONALIDAD A LAS PESTANIAS ////////
    /// se modifica el textView con el nombre de cada pestania ////

     final TextView texto = findViewById(R.id.texto);
    tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            switch (tab.getPosition())
            {
                case 0:
                    texto.setText(tab.getText()); // le asignamos el texto de la pestania
                    break;
                case 1:
                    texto.setText("Pestaña 2");
                    break;
                case 2:
                    texto.setText("Pestaña 3");
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });

     */
    ///// SEGUIMOS AQUI CON EL EJERCICIO PAG 133 //////////
        new TabLayoutMediator (tabs, viewPager,
            new TabLayoutMediator.TabConfigurationStrategy() {
                @Override
                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                    tab.setText(nombres[position]);
                }
            }
        ).attach();


    }

    public class MiPagerAdapter extends FragmentStateAdapter {

        public MiPagerAdapter (FragmentActivity activity) {
            super(activity);
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position)
            {
                case 0: return new Tab1();
                case 1: return new Tab2();
                case 2: return new Tab3();
            }
            return null;
        }


    }
}