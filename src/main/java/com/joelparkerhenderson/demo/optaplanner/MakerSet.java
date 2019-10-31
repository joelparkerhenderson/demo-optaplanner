package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

public class MakerSet {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private Set<Maker> makers;

    public Set<Maker> getMakers(){
        return makers;
    }

    public void setMakers(Set<Maker> makers){
        this.makers = makers;
    }

}
