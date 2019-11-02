package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

public class MakerSet implements ToStringDeep, HasName {

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

    private Set<Maker> makers;

    public Set<Maker> getMakers(){
        return makers;
    }

    public void setMakers(Set<Maker> makers){
        this.makers = makers;
    }

}
