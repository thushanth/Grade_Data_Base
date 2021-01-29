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

    //String[] mobileArray={"pizza","pepper","onions"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,mobileArray);

        //listView = (ListView) findViewById(R.id.listGrade);
        generateContent();

       // listView.setAdapter(adapter);
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
        float grade = 0;
        listView = (ListView)findViewById(R.id.listGrade);
        ArrayList<String> arrayList=new ArrayList<>();

        for(int j = 0; j<5; j++)
        {
            Course course = Course.generateRandomCourse();
            ArrayList<Assignment> assignments = course.getAssignments();
            arrayList.add(course.getCourseTitle());
            float arrayDim = assignments.size();
            if(assignments.size() > 0)
            {
                arrayList.add(String.valueOf(grade/arrayDim));
            }
            else
            {
                arrayList.add("0");
            }
            grade = 0;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

}