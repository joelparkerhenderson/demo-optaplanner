package com.joelparkerhenderson.demo.optaplanner;

public class Taker implements Comparable<Taker> {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Taker that) {
        return (int)(this.name.compareTo(that.getName()));
    }

}
