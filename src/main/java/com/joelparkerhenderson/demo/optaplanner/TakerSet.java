package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TakerSet implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTags {

    @Override
    public String toStringDeep(){
        return toString();
    }

    @Override
    public String toXMLString()
    {
        return AppXML.toXML(this);
    }

    //@Interface FromXMLString
    public static TakerSet fromXMLString(String xml)
    {
        return (TakerSet)AppXML.fromXML(xml);
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

    private Set<Tag> tags;

    @Override
    public Set<Tag> getTags(){
        return tags;
    }

    @Override
    public void setTags(Set<Tag> tags){
        this.tags = tags;
    }

    private Set<Taker> takers;

    public Set<Taker> getTakers(){
        return takers;
    }

    public void setTakers(Set<Taker> takers){
        this.takers = takers;
    }

}
