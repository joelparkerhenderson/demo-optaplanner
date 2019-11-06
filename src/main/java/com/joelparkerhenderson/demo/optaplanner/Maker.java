package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Maker extends Trackable<Maker> implements Comparable<Maker>{

    //@Interface FromXMLString
    public static Maker fromXMLString(String xml) {
        return (Maker)AppXML.fromXML(xml);
    }

    //@Override
    public int compareTo(Maker that) {
        return (int)(this.getName().compareTo(that.getName()));
    }

}
