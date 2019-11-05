package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MakerSet implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTagSet {

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
    public static MakerSet fromXMLString(String xml)
    {
        return (MakerSet)AppXML.fromXML(xml);
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

    private Set<Maker> makers;

    public Set<Maker> getMakers(){
        return makers;
    }

    public void setMakers(Set<Maker> makers){
        this.makers = makers;
    }

}
