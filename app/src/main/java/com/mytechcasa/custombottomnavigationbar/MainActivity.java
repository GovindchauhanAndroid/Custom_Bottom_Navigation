package com.mytechcasa.custombottomnavigationbar;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    private int mMenuId;
    FloatingActionButton fltBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fltBtn = findViewById(R.id.floatingBtn);
        Toast.makeText(MainActivity.this, "OnCreate", Toast.LENGTH_LONG).show();
        fltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Chat.class));
                Toast.makeText(MainActivity.this, "floating button", Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mMenuId = item.getItemId();
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = bottomNavigationView.getMenu().getItem(i);
            boolean isChecked = menuItem.getItemId() == item.getItemId();
            menuItem.setChecked(isChecked);

        }

        switch (item.getItemId()) {
            case R.id.chat:
                startActivity(new Intent(MainActivity.this, Chat.class));
                Toast.makeText(getApplicationContext(), "chat", Toast.LENGTH_LONG).show();
                break;

            case R.id.sell:
                Toast.makeText(getApplicationContext(), "sell", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Chat.class));
                break;
            case R.id.show_ads:
                Toast.makeText(getApplicationContext(), "show_ads", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, Chat.class));
                break;
            case R.id.account:
                Fragment fragment = new Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fram_layput, fragment); // give your fragment container id in first parameter
               transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
        }


        return true;
    }

    @Override
    public void onBackPressed() {
        bottomNavigationView.setSelectedItemId(R.id.home);
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
        Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();
        super.onStart();
    }
}