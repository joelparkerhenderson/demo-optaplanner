package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class TagScore implements ToStringDeep, ToXMLString, FromXMLString, HasName, HasScore, Comparable<TagScore>{

    public String toString(){
        return "name:" + ((name != null) ? name : "null")
        + ",score:(" + score + ")";
    }

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
    public static TagScore fromXMLString(String xml)
    {
        return (TagScore)AppXML.fromXML(xml);
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

    private HardSoftScore score = HardSoftScore.ZERO;

    @Override
    public HardSoftScore getScore(){
        return score;
    }

    @Override
    public void setScore(HardSoftScore score){
        this.score = score;
    }

    @Override
    public int compareTo(TagScore that) {
        int x = (int)(this.getName().compareTo(that.getName()));
        if (x != 0) { return x; }
        return this.getScore().compareTo(that.getScore());
    }

}
