package com.example.gradedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    private TextView editTextName, editTextAge, editTextId;
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
                String userAge = editTextAge.getText().toString();
                String userId = editTextId.getText().toString();

                if(!userInput.trim().isEmpty() && !userAge.trim().isEmpty() && !userId.trim().isEmpty())
                {
                    if(userInput.matches("^[a-zA-Z]*$"))
                    {
                        if(userAge.matches("^(1[89]|[2-9][0-9])$"))
                        {
                            if(userId.matches("^[0-9]{1,6}$"))
                            {
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString(getString(R.string.key), userInput);
                                editor.putString(getString(R.string.key2), userAge);
                                editor.putString(getString(R.string.key3), userId);

                                editor.apply();
                                Toast.makeText(profileActivity.this, getString(R.string.saved), Toast.LENGTH_SHORT).show();
                                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                            }
                            else
                            {
                                Toast.makeText(profileActivity.this, getString(R.string.iderror), Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(profileActivity.this, getString(R.string.agerror), Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(profileActivity.this, getString(R.string.nameerror), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Update();
    }

    private void Update() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.SharedID),MODE_PRIVATE);
        String text = sharedPreferences.getString(getString(R.string.key),"");
        String age = sharedPreferences.getString(getString(R.string.key2),"");
        String id = sharedPreferences.getString(getString(R.string.key3),"");

        editTextName.setText(text);
        editTextAge.setText(age);
        editTextId.setText(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()){
           case R.id.action_show:
               editTextId.setEnabled(true);
               editTextAge.setEnabled(true);
               editTextName.setEnabled(true);
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
        editTextName.setEnabled(false);
        editTextAge = findViewById(R.id.editTextAge);
        editTextAge.setEnabled(false);
        editTextId = findViewById(R.id.editTextId);
        editTextId.setEnabled(false);
        saveProfile = findViewById(R.id.saveProfile);
    }

}