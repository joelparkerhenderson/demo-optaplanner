package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TakerSet implements ToStringDeep, ToXMLString, HasName {

    @Override
    public String toStringDeep(){
        return toString();
    }

    @Override
    public String toXMLString()
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("takerSet", TakerSet.class);
        return xstream.toXML(this);
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
