package com.example.estock;

import android.content.Intent;
import android.os.Bundle;

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
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


    public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener  {

        ImageView mobileBtn, ClothingBtn, CosmeticsBtn, ElecBtn, FurnitureBtn, OtherBtn, UserAccountBlueBtn, SearchBlueBtn, HomeBlueBtn;
        ConstraintLayout mobileConstraint;
        TextView Text_nav_user;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            mobileBtn = (ImageView) findViewById(R.id.Circle_mobilephones);
        ClothingBtn = (ImageView) findViewById(R.id.Circle_clothing);
        mobileConstraint = (ConstraintLayout) findViewById(R.id.mobileConstraint) ;
        CosmeticsBtn = (ImageView) findViewById(R.id.Circle_cosmetics);
        ElecBtn = (ImageView) findViewById(R.id.Circle_Electronics);
        FurnitureBtn = (ImageView) findViewById(R.id.Circle_furniture);
        OtherBtn = (ImageView) findViewById(R.id.Circle_others);
        UserAccountBlueBtn = (ImageView) findViewById(R.id.Icon_useraccount_blue);
        SearchBlueBtn = (ImageView) findViewById(R.id.Icon_search_blue);
        HomeBlueBtn = (ImageView) findViewById(R.id.Icon_home_blue);


        Text_nav_user = (TextView)findViewById(R.id.Text_nav_username);
            Bundle extras = getIntent().getExtras();
            String username = null;
            if(extras != null){
                username = extras.getString("UserName");
                Text_nav_user.setText(username);
            }



            mobileConstraint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this, "Mobile phones...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, ProductListPage.class));
                }
            });

            mobileBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Mobile phones...", Toast.LENGTH_SHORT).show();
                    int id = 1;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);


                }
            });

            ClothingBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "clothing..", Toast.LENGTH_SHORT).show();
                    int id = 2;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);


                }
            });

            CosmeticsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Cosmetics...", Toast.LENGTH_SHORT).show();
                    int id = 3;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);

                }
            });

            ElecBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Electronics...", Toast.LENGTH_SHORT).show();
                    int id = 4;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });

            FurnitureBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Furniture...", Toast.LENGTH_SHORT).show();
                    int id = 5;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);

                }
            });

            OtherBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Others...", Toast.LENGTH_SHORT).show();
                    int id = 6;
                    Intent intent = new Intent(getApplicationContext(),ProductListPage.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
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
                    startActivity(new Intent(MainActivity.this, SignInPageUpdated.class));
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
                Toast.makeText(MainActivity.this, "Sign in ...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SignInPageUpdated.class));
                // Handle the camera action
            } else if (id == R.id.nav_SignUp) {
                Toast.makeText(MainActivity.this, "Sign up...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, SignUpPage.class));

            } else if (id == R.id.nav_addProducts) {
                Toast.makeText(MainActivity.this, "Selling page...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AddProducts.class));

            } else if (id == R.id.nav_myProducts) {
            Toast.makeText(MainActivity.this, "My Products...", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, MyProducts.class));

            } else if (id == R.id.nav_myAccount) {
                Toast.makeText(MainActivity.this, "My Account....", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MyAccount.class));

            }  else if (id == R.id.nav_category) {
                Toast.makeText(MainActivity.this, "Category...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            } else if (id == R.id.nav_contactUs) {
                Toast.makeText(MainActivity.this, "Contact us...", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_notifications) {
                Toast.makeText(MainActivity.this, "Notifications...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Notification.class));

            } else if (id == R.id.nav_aboutUs) {
                Toast.makeText(MainActivity.this, "About us...", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_myOrders) {
                Toast.makeText(MainActivity.this, "My orders...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, OrdersPage.class));
            } else if (id == R.id.nav_Cart) {
                Toast.makeText(MainActivity.this, "Shopping cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Cart.class));
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


    }

