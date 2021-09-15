package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

public class MakerSet extends Trackable<MakerSet> {

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
