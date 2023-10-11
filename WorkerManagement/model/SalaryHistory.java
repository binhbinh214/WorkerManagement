package model;

import java.util.*;

public class SalaryHistory {
    private String workerId;
    private double previousSalary;
    private double newSalary;
    private Date date;

    public SalaryHistory(String workerId, double previousSalary, double newSalary) {
        this.workerId = workerId;
        this.previousSalary = previousSalary;
        this.newSalary = newSalary;
        this.date = new Date();
    }

    // Getters

    public String getWorkerId() {
        return workerId;
    }

    public double getPreviousSalary() {
        return previousSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Worker ID: " + workerId 
                + "\nPrevious Salary: $" + previousSalary 
                + "\nNew Salary: $" + newSalary
                + "\nDate: " + date;
                
    }
}