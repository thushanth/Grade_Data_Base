package com.example.gradedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button profileNavBtn, gradeNavBtn;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        sharedPref = getSharedPreferences(getString(R.string.SharedID),MODE_PRIVATE);
        String name = sharedPref.getString(getString(R.string.key),null);
        profileNavBtn.setText(name);
        profileNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfileActivity();
            }
        });
    }

    private void goToProfileActivity() {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        checkForName();
        super.onStart();
    }

    private void setupUI(){
        profileNavBtn = findViewById(R.id.profileNavBtn);
        gradeNavBtn = findViewById(R.id.gradeNavBtn);
    }

    protected void checkForName()
    {

        String user = sharedPref.getString(getString(R.string.key),null);
        profileNavBtn.setText(user);
        if (user.isEmpty())
        {
            goToProfileActivity();
        }
    }
}