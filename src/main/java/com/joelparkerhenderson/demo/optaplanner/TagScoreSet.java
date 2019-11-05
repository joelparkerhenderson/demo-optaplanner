package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TagScoreSet implements ToStringDeep, ToXMLString, FromXMLString, HasName {

    @Override
    public String toStringDeep(){
        return toString();
    }

    @Override
    public String toXMLString()
    {
        return AppXML.toXML(this);
    }

    //@Interface FromXMLString
    public static TagScoreSet fromXMLString(String xml)
    {
        return (TagScoreSet)AppXML.fromXML(xml);
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

    private Set<TagScore> tagScores;

    public Set<TagScore> getTagScores(){
        return tagScores;
    }

    public void setTagScores(Set<TagScore> tagScores){
        this.tagScores = tagScores;
    }

}
