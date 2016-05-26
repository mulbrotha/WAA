/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mulu.cs545.WAA.Day3;

/**
 *
 * @author mulu
 */
public class Student {
    private String sName,sGender;
    private int sID;
    private double gpa;

    public Student(int sID, String sName , double gpa, String sGender) {
        this.sName = sName;
        this.sGender = sGender;
        this.sID = sID;
        this.gpa = gpa;
    }

    
    
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "sName=" + sName + ", sGender=" + sGender + ", sID=" + sID + ", gpa=" + gpa + '}';
    }
    
}
