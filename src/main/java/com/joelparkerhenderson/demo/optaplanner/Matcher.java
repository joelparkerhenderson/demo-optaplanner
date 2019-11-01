package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;

@PlanningEntity
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
    
    // Ref corresponds to the ref on Solution.takers().
    @PlanningVariable(valueRangeProviderRefs = {"ValueRangeProviderTakers"}) 
    public Taker getTaker(){
        return taker;
    }

    public void setTaker(Taker taker){
        this.taker = taker;
    }

}
