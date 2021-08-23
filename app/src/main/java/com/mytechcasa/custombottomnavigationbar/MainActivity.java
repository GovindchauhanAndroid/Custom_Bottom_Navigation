package com.mytechcasa.custombottomnavigationbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    private int mMenuId;
    Fragment fragment = null;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigationBar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
        floatingActionButton = findViewById(R.id.floating_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Chat.class));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                fragment = new profile_Fragment();
                LoadFragment();
                break;
            case R.id.chat:
                startActivity(new Intent(MainActivity.this, Chat.class));
                break;

            case R.id.sell:
                Toast.makeText(getApplicationContext(), "sell", Toast.LENGTH_LONG).show();
                break;
            case R.id.show_ads:
                startActivity(new Intent(MainActivity.this, Chat.class));
                break;
            case R.id.account:
                fragment = new ProfileFragment();
                LoadFragment();
        }
        return true;
    }

    void LoadFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
    }


    @Override
    protected void onStart() {
        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        super.onStart();
    }
}