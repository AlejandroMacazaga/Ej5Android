package com.example.ejerciciowassap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    
    private ViewPager viewPager;
    private ListView lstActual;
    private Contacto[] contactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.placeholder);
        contactos = new Contacto[] {
            new Contacto("Nombre 1", "Mensaje 1", "Fecha 1", img),
            new Contacto("Nombre 2", "Mensaje 2", "Fecha 2", img),
            new Contacto("Nombre 3", "Mensaje 3", "Fecha 3", img),
            new Contacto("Nombre 4", "Mensaje 4", "Fecha 4", img),
        };



        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);


    }
    class MyAdapter extends PagerAdapter {
        private LinearLayout p1, p2, p3;
        private final int[] pNames = {R.string.tab1, R.string.tab2, R.string.tab3};

        public MyAdapter() {

        }

        @Override
        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            String s = getString(pNames[position]);
            return s;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View page;
            switch (position) {
                case 0:
                    if (p1 == null)
                        p1 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab1, container, false);
                    page = p1;
                    lstActual = p1.findViewById(R.id.lstLlamadas);

                    break;
                case 1:
                    if (p2 == null)
                        p2 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab2, container, false);
                    page = p2;
                    lstActual = p2.findViewById(R.id.lstChats);
                    break;
                case 2:
                    if (p3 == null)
                        p3 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.tab3, container, false);
                    page = p3;
                    ArrayAdapterContacto adapter = new ArrayAdapterContacto(MainActivity.this, contactos);
                    lstActual.setAdapter(adapter);
                    break;
                default:
                    page = null;
                    break;
            }
            container.addView(page);
            return page;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}