package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

public class TakerSet implements ToStringDeep, HasName {

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

    private Set<Taker> takers;

    public Set<Taker> getTakers(){
        return takers;
    }

    public void setTakers(Set<Taker> takers){
        this.takers = takers;
    }

}
