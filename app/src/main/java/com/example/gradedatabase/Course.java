package com.example.gradedatabase;

import java.util.ArrayList;
import java.util.Random;
/**
 * Code Belongs to Tawfiq
 * ***/
public class Course {
    private static int courseID = 0;

    private String courseTitle;
    private ArrayList<Assignment> assignments;

    private Course(String title, ArrayList<Assignment> assns) {
        courseTitle = title;
        assignments = assns;
        courseID++;
    }

    static public Course generateRandomCourse()
    {
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(5);
        ArrayList<Assignment> tempAssns = new ArrayList<Assignment>();

        for(int i=0; i < assignmentNo; i++)
            tempAssns.add(Assignment.generateRandomAssignment());

        return  new Course("Course"+courseID,tempAssns);
    }

    public String getCourseTitle() {return courseTitle;}
    public ArrayList<Assignment> getAssignments() {return assignments;}
}
