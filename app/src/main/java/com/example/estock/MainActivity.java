package com.example.estock;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imageView2,ClothingBtn,CosmeticsBtn,ElecBtn,FurnitureBtn,OtherBtn,UserAccountBlueBtn,SearchBlueBtn,HomeBlueBtn;
    ConstraintLayout mobileConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        ClothingBtn = (ImageView) findViewById(R.id.ClothingBtn);
        mobileConstraint = (ConstraintLayout) findViewById(R.id.mobileConstraint) ;
        CosmeticsBtn = (ImageView) findViewById(R.id.CosmeticsBtn);
        ElecBtn = (ImageView) findViewById(R.id.ElecBtn);
        FurnitureBtn = (ImageView) findViewById(R.id.FurnitureBtn);
        OtherBtn = (ImageView) findViewById(R.id.OtherBtn);
        UserAccountBlueBtn = (ImageView) findViewById(R.id.UserAccountBlueBtn);
        SearchBlueBtn = (ImageView) findViewById(R.id.SearchBlueBtn);
        HomeBlueBtn = (ImageView) findViewById(R.id.HomeBlueBtn);

        mobileConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Whole constarint Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "mobileClicked", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        ClothingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "clothing Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        CosmeticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "CosmeticsBtn Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        ElecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ElecBtn Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        FurnitureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "FurnitureBtn Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        OtherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "OtherBtn Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ProductListPage.class));
            }
        });

        HomeBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HomeBlueBtn Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        SearchBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "SearchBlueBtn Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        UserAccountBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "UserAccountBlueBtn Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_SignIn) {
            // Handle the camera action
        } else if (id == R.id.nav_SignUp) {

        } else if (id == R.id.nav_category) {

        } else if (id == R.id.nav_contactUs) {

        } else if (id == R.id.nav_aboutUs) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
