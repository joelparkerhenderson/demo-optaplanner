package com.joelparkerhenderson.demo.optaplanner;

public class Maker extends Trackable<Maker> {

    //@Interface FromXMLString
    public static Maker fromXMLString(String xml) {
        return (Maker)AppXML.fromXML(xml);
    }

    @Override
    public int compareTo(Maker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
