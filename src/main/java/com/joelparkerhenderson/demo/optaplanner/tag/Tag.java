package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class Tag implements ToStringDeep, ToXMLString, FromXMLString, HasName, Comparable<Tag> {

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
    public static Tag fromXMLString(String xml)
    {
        return (Tag)AppXML.fromXML(xml);
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

    @Override
    public int compareTo(Tag that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
