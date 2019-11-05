package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TagSet implements ToStringDeep, ToXMLString, FromXMLString, HasName {

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
    public static TagSet fromXMLString(String xml)
    {
        return (TagSet)AppXML.fromXML(xml);
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

    //@Override
    public Set<Tag> getTags(){
        return tags;
    }

    //@Override
    public void setTags(Set<Tag> tags){
        this.tags = tags;
    }

}
