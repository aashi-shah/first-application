package com.example.firstapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapplication.databinding.FragmentHomeBinding;
import com.example.firstapplication.ui.gallery.GalleryFragment;
import com.example.firstapplication.ui.home.HomeFragment;
import com.example.firstapplication.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firstapplication.databinding.ActivityNavBinding;

public class Nav_Activity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView textView;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        view = navigationView.getHeaderView(0);
        drawerLayout = findViewById(R.id.drawer_layout);
        textView = view.findViewById(R.id.textView);

        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_PAGE",MODE_PRIVATE);

        String user = sharedPreferences.getString("USERNAME_KEY","");
        textView.setText(user);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.nav_home){
                    toolbar.setTitle("Home");

                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.frame3,homeFragment);
                    fragmentTransaction.commit();
                }else if(id == R.id.nav_gallery){
                    toolbar.setTitle("Gallery");

                    GalleryFragment galleryFragment = new GalleryFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.frame3,galleryFragment);
                    fragmentTransaction.commit();
                }else if(id == R.id.nav_slideshow){
                    toolbar.setTitle("Slideshow");

                    SlideshowFragment slideshowFragment = new SlideshowFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.frame3,slideshowFragment);
                    fragmentTransaction.commit();
                }else if(id == R.id.nav_logout){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("USERNAME_KEY");
                    editor.remove("PASSWORD_KEY");
                    editor.apply();
                    finish();
                    Intent i = new Intent(Nav_Activity.this,LoginActivity.class);
                    startActivity(i);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}