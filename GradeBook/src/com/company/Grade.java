package com.company;

public class Grade {
    private String name;
    private double numerical;
    public Grade() {
        name = "Empty";
    }
    public Grade(String n, double num){
        name = n;
        numerical = num;
    }
    public Grade(String n){
        name = n;
    }
    public double getNumerical(){
        return numerical;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public void setNumerical(double d){
        numerical=d;
    }
}
