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

    ListView listView;
    private String[] courseProfile = {"ENGR390","ENCS282","ELEC311"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        isItEmpty();

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

    private void isItEmpty()
    {
        // I don't know how to work with array List or objects of array.
        listView = (ListView)findViewById(R.id.listGrade);
        ArrayList<String> name = new ArrayList<String>();

        for(int j = 0; j < 5; j++)
        {
            Course course = Course.generateRandomCourse();
            ArrayList<Assignment> assignments = course.getAssignments();
            name.add(course.getCourseTitle());
            for(int i = 0; i < assignments.size(); i++)
            {
                name.add(assignments.get(i).getAssignmentTitle() + " " + assignments.get(i).getAssignmentGrade());
            }
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.labelTitle,name);
            listView.setAdapter(arrayAdapter2);
        }
    }

}