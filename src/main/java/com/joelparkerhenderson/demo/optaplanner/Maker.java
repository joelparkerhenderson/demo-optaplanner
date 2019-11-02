package com.joelparkerhenderson.demo.optaplanner;

public class Maker implements Comparable<Maker> {

    public String toString(){
        return "name:" + ((name != null) ? name : "null");
    }

    public String toStringDeep(){
        return toString();
    }

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
