package com.joelparkerhenderson.demo.optaplanner;

import com.joelparkerhenderson.demo.optaplanner.interfaces.ToStringDeep;
import com.joelparkerhenderson.demo.optaplanner.interfaces.ToXMLString;
import com.joelparkerhenderson.demo.optaplanner.interfaces.FromXMLString;
import com.joelparkerhenderson.demo.optaplanner.interfaces.HasName;

import java.util.*;

public class TagScoreSet implements ToStringDeep, ToXMLString, FromXMLString, HasName {

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
    public static TagScoreSet fromXMLString(String xml)
    {
        return (TagScoreSet)AppXML.fromXML(xml);
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

    private Set<TagScore> elements;

    public Set<TagScore> getElements(){
        return elements;
    }

    public void setElements(Set<TagScore> elements){
        this.elements = elements;
    }

}
