package com.joelparkerhenderson.demo.optaplanner;

import com.joelparkerhenderson.demo.optaplanner.interfaces.*;

import java.util.*;

public class Trackable<T extends Trackable> implements ToStringDeep, ToXMLString, FromXMLString, HasUUID, HasName, HasTagSet, HasTagScoreSet, Comparable<T> {

    public String toString(){
        return 
            "uuid:" + ((uuid != null) ? uuid : "null") + "," +
            "name:" + ((name != null) ? name : "null");
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

    private TagScoreSet tagScoreSet;

    @Override
    public TagScoreSet getTagScoreSet(){
        return tagScoreSet;
    }

    @Override
    public void setTagScoreSet(TagScoreSet tagScoreSet){
        this.tagScoreSet = tagScoreSet;
    }

    @Override
    public int compareTo(T that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
