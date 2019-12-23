package com.joelparkerhenderson.demo.optaplanner;

public class Taker extends Trackable<Taker> implements Comparable<Taker> {

    //@Interface FromXMLString
    public static Taker fromXMLString(String xml) {
        return (Taker)AppXML.fromXML(xml);
    }

    @Override
    public int compareTo(Taker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
