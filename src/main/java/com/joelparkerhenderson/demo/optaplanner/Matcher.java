package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Matcher extends Trackable<Matcher> {

    @Override
    public String toStringDeep() {
        return toString() + 
        ",maker:{" + ((maker != null) ? maker : "null") + "}" + 
        ",taker:{" + ((taker != null) ? taker : "null") + "}";
    }

    //@Interface FromXMLString
    public static Matcher fromXMLString(String xml) {
        return (Matcher)AppXML.fromXML(xml);
    }

    private Maker maker;

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

    private Taker taker;

    // Ref corresponds to the ref on Solution.takers().
    @PlanningVariable(valueRangeProviderRefs = {"ValueRangeProviderTakers"})
    public Taker getTaker() {
        return taker;
    }

    public void setTaker(Taker taker) {
        this.taker = taker;
    }

    @Override
    public int compareTo(Matcher that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
