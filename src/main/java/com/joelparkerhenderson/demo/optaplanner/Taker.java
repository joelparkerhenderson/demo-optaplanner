package com.joelparkerhenderson.demo.optaplanner;

public class Taker implements ToStringDeep, HasName, Comparable<Taker> {

    public String toString(){
        return "name:" + ((name != null) ? name : "null");
    }

    @Override
    public String toStringDeep(){
        return toString();
    }

    private String name;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Taker that) {
        return (int)(this.name.compareTo(that.getName()));
    }

}
