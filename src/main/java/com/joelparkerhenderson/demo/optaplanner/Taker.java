package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Taker extends Trackable<Taker> implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasTagSet, Comparable<Taker> {

    //@Interface FromXMLString
    public static Taker fromXMLString(String xml) {
        return (Taker)AppXML.fromXML(xml);
    }

    @Override
    public int compareTo(Taker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
