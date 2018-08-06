package com.company;
import java.util.*;
public class GradeBook {
    ArrayList<Student> gb;
    public GradeBook(){
        gb = new ArrayList<Student>();
    }
    public void addStudent(Student newS){
        gb.add(newS);
    }
    public void remStudent(Student remS){
        for (int i=0;i<gb.size();++i){
            if (gb.get(i).equals(remS)){
                gb.remove(i);
                break;
            }
        }
    }
    public void remStudent(int remID){
        for (int i=0;i<gb.size();++i){
            if (gb.get(i).getID()==remID){
                gb.remove(i);
                break;
            }
        }
    }
    public void update(){
        for (Student a: gb){
            a.calc();
        }
    }
    public void gradeInflation(int newGrade){
        for (Student a: gb){
            a.replaceLowest(newGrade);
        }
    }
    public void rankStudents(){
        //implementation of bubble sort
        for (int i=0;i<gb.size()-1;++i){
            for (int j=i+1;j<gb.size();++j){
                if (gb.get(i).getAvg()<gb.get(j).getAvg()){
                    Student temp = gb.get(j);
                    gb.set(j,gb.get(i));
                    gb.set(i, temp);
                }
            }
        }
        for (int i=0;i<gb.size();++i) {
            gb.get(i).setRank(i + 1);
        }
    }

    public String toString(){
        String s = "";
        for (int i=0;i<gb.size();++i){
            s+=gb.get(i).toString()+"\n";
        }
        return s;
    }
}
