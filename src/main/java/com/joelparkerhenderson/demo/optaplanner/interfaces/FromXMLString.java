package com.joelparkerhenderson.demo.optaplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

interface FromXMLString {

    // This interface is merely a marker that the implementing
    // class has a method that matches this type signature:
    //
    //     public static T fromXMLString(String xml){
    //         XStream xstream = new XStream(new DomDriver());
    //         xstream.alias("t", T.class);
    //         return (T)xstream.fromXML(xml);
    //     }

}
