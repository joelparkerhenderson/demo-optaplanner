package com.joelparkerhenderson.demo.optaplanner;

public class Matcher {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private Maker maker;

    public Maker getMaker(){
        return maker;
    }

    public void setMaker(Maker maker){
        this.maker = maker;
    }

    private Taker taker;

    public Taker getTaker(){
        return taker;
    }

    public void setTaker(Taker taker){
        this.taker = taker;
    }

}
