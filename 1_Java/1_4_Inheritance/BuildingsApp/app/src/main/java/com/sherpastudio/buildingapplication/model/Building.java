package com.sherpastudio.buildingapplication.model;

public class Building {
    private String name;
    private int numberOfDoors;
    private int numberOfWindows;

    public Building(String name, int doors, int windows){
        this.name = name;
        this.numberOfDoors = doors;
        this.numberOfWindows = windows;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){

        //TODO edit this code to return a String with the description of the object:
        //TODO you have to use the object fields numberOfDoors and numberOfWindows instead of the XXX
        //TODO return something like  "Building with XXX doors and XXX windows"

        return "";
    }
}
