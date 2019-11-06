package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Trackable<T extends Trackable> implements ToStringDeep, ToXMLString, FromXMLString, HasUUID, HasName, HasTagSet, Comparable<T> {

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
    public static Trackable fromXMLString(String xml)
    {
        return (Trackable)AppXML.fromXML(xml);
    }

    private UUID uuid;

    @Override
    public UUID getUUID(){
        return uuid;
    }

    @Override
    public void setUUID(UUID uuid){
        this.uuid = uuid;
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

    private TagSet tagSet;

    @Override
    public TagSet getTagSet(){
        return tagSet;
    }

    @Override
    public void setTagSet(TagSet tagSet){
        this.tagSet = tagSet;
    }

    @Override
    public int compareTo(T that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
