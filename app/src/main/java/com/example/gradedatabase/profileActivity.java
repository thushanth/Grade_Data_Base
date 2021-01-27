package com.example.gradedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    private TextView editTextName;
    private Button saveProfile;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupUI();
        sharedPref = getSharedPreferences(getString(R.string.SharedID),MODE_PRIVATE);

        saveProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String userInput = editTextName.getText().toString();
                if(!userInput.trim().isEmpty())
                {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(getString(R.string.key), userInput);
                    editor.apply();
                    Toast.makeText(profileActivity.this, "saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupUI(){
        editTextName = findViewById(R.id.editTextName);
        saveProfile = findViewById(R.id.saveProfile);
    }
}