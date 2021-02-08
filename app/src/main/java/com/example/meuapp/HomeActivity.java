package com.example.meuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends Activity {
    private ImageView btn_add;
    private ImageView btn_pesquisar;
    private ImageView btn_atualizar;
    private ImageView btn_del;
    private DrawerLayout drawerLayoutProfile;
    private NavigationView navigationViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_add = findViewById(R.id.btn_add);
        btn_pesquisar = findViewById(R.id.btn_pesquisar);
        btn_atualizar = findViewById(R.id.btn_atualizar);
        btn_del = findViewById(R.id.btn_del);
        drawerLayoutProfile = findViewById(R.id.drawerLayoutProfile);
        navigationViewProfile = findViewById(R.id.navigationViewProfile);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CadastroActivity.class));
            }
        });

        btn_pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ConsultaActivity.class));
            }
        });

        btn_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, AtualizaActivity.class));
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DeletaActivity.class));
            }
        });

        navigationViewProfile.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.menuWarning:
                        Toast.makeText(getApplicationContext(), "Menu  Warning selected!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuInfo:
                        Toast.makeText(getApplicationContext(), "Menu  Information selected!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuGlobe:
                        Toast.makeText(getApplicationContext(), "Menu  Globe selected!", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menuSettings:
                        Toast.makeText(getApplicationContext(), "Menu  Settings selected!", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
    }
}
