package com.joelparkerhenderson.demo.optaplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Maker implements ToStringDeep, ToXMLString, FromXMLString, HasName, Comparable<Maker>{

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
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("maker", Maker.class);
        return xstream.toXML(this);
    }

    //@Interface FromXMLString
    public static Maker fromXMLString(String xml)
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("maker", Maker.class);
        return (Maker)xstream.fromXML(xml);
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
    public int compareTo(Maker that) {
        return (int)(this.name.compareTo(that.getName()));
    }

}
