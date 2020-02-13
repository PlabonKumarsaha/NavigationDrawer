package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView nav_view;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        nav_view.bringToFront();


        //hide or show items

        Menu menu =nav_view.getMenu();
        //visibility will be fase if logout will be pressed
        menu.findItem(R.id.nav_logout).setVisible(false);

        menu.findItem(R.id.nav_profile).setVisible(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar,R.string.Navigation_Drawer_Open,R.string.Navigation_Drawer_Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setCheckedItem(R.id.nav_home);


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.nav_bus :
                Intent intent = new Intent(MainActivity.this, Bus.class);
                startActivity(intent);
                break;

            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),"nav home is selected!",Toast.LENGTH_SHORT).show();
            break;

            case R.id.nav_hospital:
                Toast.makeText(getApplicationContext(),"nav hospital is selected!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(),"nav profile is selected!",Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }
}
