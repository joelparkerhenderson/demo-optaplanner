package com.joelparkerhenderson.demo.optaplanner;

public class Maker implements Comparable<Maker> {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Maker that) {
        return (int)(this.name.compareTo(that.getName()));
    }

}
