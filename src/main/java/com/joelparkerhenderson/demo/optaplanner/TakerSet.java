package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TakerSet extends Trackable<TakerSet> implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTagSet {

    //@Interface FromXMLString
    public static TakerSet fromXMLString(String xml) {
        return (TakerSet)AppXML.fromXML(xml);
    }

    private Set<Taker> takers;

    public Set<Taker> getTakers() {
        return takers;
    }

    public void setTakers(Set<Taker> takers) {
        this.takers = takers;
    }

}
