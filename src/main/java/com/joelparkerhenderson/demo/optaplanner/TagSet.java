package com.joelparkerhenderson.demo.optaplanner;

import com.joelparkerhenderson.demo.optaplanner.interfaces.ToStringDeep;
import com.joelparkerhenderson.demo.optaplanner.interfaces.ToXMLString;
import com.joelparkerhenderson.demo.optaplanner.interfaces.FromXMLString;
import com.joelparkerhenderson.demo.optaplanner.interfaces.HasName;

import java.util.*;

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

    private Set<Tag> elements;

    public Set<Tag> getElements(){
        return elements;
    }

    public void setElements(Set<Tag> elements){
        this.elements = elements;
    }

}
