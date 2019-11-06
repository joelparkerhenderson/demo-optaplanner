package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TakerSet extends Trackable<TakerSet> implements Comparable<TakerSet> {

    //@Interface FromXMLString
    public static TakerSet fromXMLString(String xml) {
        return (TakerSet)AppXML.fromXML(xml);
    }

    @Override
    public int compareTo(TakerSet that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

    private Set<Taker> elements;

    public Set<Taker> getElements() {
        return elements;
    }

    public void setElements(Set<Taker> elements) {
        this.elements = elements;
    }

}
