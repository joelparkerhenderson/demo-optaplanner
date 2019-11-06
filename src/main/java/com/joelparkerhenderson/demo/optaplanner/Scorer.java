package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class Scorer implements ToStringDeep, ToXMLString, FromXMLString, HasName, EasyScoreCalculator<Solution> {

    public String toString(){
        return "name:" + ((name != null) ? name : "null");
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
    public static Scorer fromXMLString(String xml)
    {
        return (Scorer)AppXML.fromXML(xml);
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

    public HardSoftScore calculateScore(Solution solution) {
        HardSoftScore score = HardSoftScore.ZERO;
        final Set<Maker> makers = solution.getMakers(); assert makers != null : " makers is null";
        final Set<Taker> takers = solution.getTakers(); assert takers != null : " makers is null";
        final Set<Matcher> matchers = solution.getMatchers(); assert matchers != null : " matchers is null";
        for(Matcher matcher: matchers){
            score = score.add(this.calculateScoreWithMatcher(matcher));
        }
        return score;
    }

    public HardSoftScore calculateScoreWithMatcher(Matcher matcher) {
        final Maker maker = matcher.getMaker(); if (maker == null){ return HardSoftScore.ZERO; }
        final Taker taker = matcher.getTaker(); if (taker == null){ return HardSoftScore.ZERO; }
        return calculateScoreWithMakerTaker(maker, taker);
    }

    public HardSoftScore calculateScoreWithMaker(Maker maker) {
        if (maker == null){ return HardSoftScore.of(-1,0); }
        return HardSoftScore.ZERO;
    }

    public HardSoftScore calculateScoreWithTaker(Taker taker) {
        if (taker == null){ return HardSoftScore.of(-1,0); }
        return HardSoftScore.ZERO;
    }

    public HardSoftScore calculateScoreWithMakerTaker(Maker maker, Taker taker) {
        if (maker == null || taker == null){ return HardSoftScore.of(-1,0); }
        return calculateScoreWithTagSets(maker.getTagSet(), taker.getTagSet());
    }

    public HardSoftScore calculateScoreWithTagSets(TagSet a, TagSet b) {
        if (a == null || b == null){ return HardSoftScore.of(-1,0); }
        return HardSoftScore.of(0, (a == b) ? 1 : -1);
    }

}