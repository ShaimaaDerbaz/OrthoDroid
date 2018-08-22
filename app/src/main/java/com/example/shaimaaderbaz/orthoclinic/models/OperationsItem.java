package com.example.shaimaaderbaz.orthoclinic.models;

/**
 * Created by Shaimaa Derbaz on 8/15/2018.
 */

public class OperationsItem {
    String name,date,steps,persons,followup;

    public OperationsItem() {
    }

    public OperationsItem(String name, String date, String steps, String persons, String followup) {
        this.name = name;
        this.date = date;
        this.steps = steps;
        this.persons = persons;
        this.followup = followup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }

    public String getFollowup() {
        return followup;
    }

    public void setFollowup(String followup) {
        this.followup = followup;
    }
}

