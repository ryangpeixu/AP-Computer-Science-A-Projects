package com.company;
import java.util.*;
public class Student {
    ArrayList<Grade> lgrades;
    private static int numStudents = 0;
    private String name;
    private double avg;
    private int numGrades=0;
    private int ID;
    private int rank;

    public Student(){
        lgrades = new ArrayList<Grade>();
        numStudents++;
        ID = numStudents;
        name = "RandomStudent"+numStudents;
        avg=0.0;
        rank=0;
    }

    public Student(String n, double a){
        lgrades = new ArrayList<Grade>();
        numStudents++;
        ID = numStudents;
        name = n;
        avg=a;
        rank=0;
    }

    public Student(String n){
        lgrades = new ArrayList<Grade>();
        numStudents++;
        ID = numStudents;
        name = n;
        avg=0.0;
        rank=0;
    }

    public Student(double a){
        lgrades = new ArrayList<Grade>();
        numStudents++;
        ID = numStudents;
        name = "RandomStudent"+ID;
        avg=a;
        numGrades=0;
        rank=0;
    }

    public double getAvg(){
        return avg;
    }

    public String getName(){
        return name;
    }

    public int getRank(){
        return rank;
    }

    public int getID(){
        return ID;
    }

    public int getNumGrades(){
        return numGrades;
    }

    public void setName(String newname){
        name = newname;
    }

    public void setAvg(double newavg){
        avg = newavg;
    }

    public void setRank(int newRank){
        rank = newRank;
    }

    public String toString(){
        return name + " ( ID: " + ID + " Rank: "+ rank + " ) "+" : " + avg;
    }

    public void calc(){
        double sum = 0.0;
        for (Grade g : lgrades){
            sum+=g.getNumerical();
        }
        avg = sum/lgrades.size();
    }

    public void addGrade (String gname, double g){
        lgrades.add(new Grade(gname, g));
    }

    public void addGrade (String gname){
        lgrades.add(new Grade(gname));
    }

    public void deleteGrade(String tname){
        for (int i=0;i<lgrades.size();++i){
            if (lgrades.get(i).getName().equals(tname)){
                lgrades.remove(i);
                break;
            }
        }
    }

    public void changeGNum(String tname, double tnum){
        for (int i=0;i<lgrades.size();++i){
            if (lgrades.get(i).getName().equals(tname)){
                lgrades.get(i).setNumerical(tnum);
                break;
            }
        }
    }

    public void changeGName(String before, String after){
        for (int i=0;i<lgrades.size();++i){
            if (lgrades.get(i).getName().equals(before)){
                lgrades.get(i).setName(after);
                break;
            }
        }
    }

    public void replaceLowest(double newG){
        int ind=0;
        double min = lgrades.get(0).getNumerical();
        for (int i=0;i<lgrades.size();++i){
            if (lgrades.get(i).getNumerical()<min){
                min = lgrades.get(i).getNumerical();
                ind = i;
            }
        }
        lgrades.get(ind).setNumerical(newG);
    }

    public boolean equals(Student other){
        return this.ID==other.getID();
    }
}


