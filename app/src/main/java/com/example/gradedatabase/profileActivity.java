package com.example.gradedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()){
           case R.id.action_show:
               Toast.makeText(this,"Item 1", Toast.LENGTH_SHORT).show();
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_profile, menu);
        return true;
    }

    private void setupUI(){
        editTextName = findViewById(R.id.editTextName);
        saveProfile = findViewById(R.id.saveProfile);
    }
}