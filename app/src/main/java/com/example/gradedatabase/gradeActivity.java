package com.example.gradedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class gradeActivity extends AppCompatActivity {

    String[] mobileArray={"pizza","pepper","onions"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        generateContent();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,mobileArray);

        ListView listView = (ListView) findViewById(R.id.listGrade);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_convert:
                Toast.makeText(this,"Item 1", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_grade,menu);
        return true;
    }

    private void generateContent()
    {
        for(int j = 0; j<5; j++)
        {
            Course course = Course.generateRandomCourse();
            ArrayList<Assignment> assignments = course.getAssignments();
            System.out.println(course.getCourseTitle());
            for(int i=0; i < assignments.size(); i++)
            {
                 //assignments.get(i).getAssignmentTitle() + " " + assignments.get(i).getAssignmentGrade();
            }
        }
    }

}