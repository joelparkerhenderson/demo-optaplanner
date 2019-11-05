package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Taker implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTags, Comparable<Taker> {

    public String toString(){
        return "name:" + ((name != null) ? name : "null");
    }

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
    public static Taker fromXMLString(String xml)
    {
        return (Taker)AppXML.fromXML(xml);
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

    private Set<String> tags;

    @Override
    public Set<String> getTags(){
        return tags;
    }

    @Override
    public void setTags(Set<String> tags){
        this.tags = tags;
    }

    @Override
    public int compareTo(Taker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
