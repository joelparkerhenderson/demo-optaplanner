package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MakerSet implements ToStringDeep, ToXMLString, HasName {

    @Override
    public String toStringDeep(){
        return toString();
    }

    @Override
    public String toXMLString()
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("makerSet", MakerSet.class);
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

    private Set<Maker> makers;

    public Set<Maker> getMakers(){
        return makers;
    }

    public void setMakers(Set<Maker> makers){
        this.makers = makers;
    }

}
