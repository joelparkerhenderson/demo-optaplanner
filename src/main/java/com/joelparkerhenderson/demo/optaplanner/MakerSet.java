package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MakerSet extends Trackable<MakerSet> implements Comparable<MakerSet> {

    //@Interface FromXMLString
    public static MakerSet fromXMLString(String xml) {
        return (MakerSet)AppXML.fromXML(xml);
    }

    @Override
    public int compareTo(MakerSet that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

    private Set<Maker> elements;

    public Set<Maker> getElements() {
        return elements;
    }

    public void setElements(Set<Maker> elements) {
        this.elements = elements;
    }

}
