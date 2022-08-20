package com.example.bottomnavigationview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
/*
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerFrameLayout, new HomeFragmentClass()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.homeProfile:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        selectedFragment = new HomeFragmentClass();
                        break;

                    case R.id.profileAccount:
                        Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        selectedFragment = new ProfileFragmentClass();
                        break;

                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        selectedFragment = new SettingsFragmentClass();
                        break;

                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        selectedFragment = new LogoutFragmentClass();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerFrameLayout, selectedFragment).commit();
                return true;
            }
        });


    }
/*
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.homeProfile:
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    selectedFragment = new HomeFragmentClass();
                    break;

                case R.id.profileAccount:
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    selectedFragment = new ProfileFragmentClass();
                    break;

                case R.id.settings:
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                    selectedFragment = new SettingsFragmentClass();
                    break;

                case R.id.logout:
                    Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                    selectedFragment = new LogoutFragmentClass();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerFrameLayout, selectedFragment).commit();
            return true;
        }
    };*/
}