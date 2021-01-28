package com.example.gradedatabase;

import java.util.Random;

// Code belongs to Tawfiq
public class Assignment {
    private static int assID = 0;
    private String assignmentTitle;
    private int assignmentGrade;

    private Assignment(String title, int grade)
    {
        assignmentTitle = title;
        assignmentGrade = grade;
        assID++;
    }
    static public Assignment generateRandomAssignment()
    {
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        int tempGrade = rnd.nextInt(100) +1;

        return new Assignment(tempTitle, tempGrade);
    }

    public String getAssignmentTitle()
    {
        return assignmentTitle;
    }

    public int getAssignmentGrade()
    {
        return assignmentGrade;
    }
}
