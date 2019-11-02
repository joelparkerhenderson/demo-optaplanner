package com.joelparkerhenderson.demo.optaplanner;

public class Maker implements ToStringDeep, HasName, Comparable<Maker>{

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
    public int compareTo(Maker that) {
        return (int)(this.name.compareTo(that.getName()));
    }

}
