package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import java.util.stream.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class Scorer extends Trackable<Scorer> implements EasyScoreCalculator<Solution> {

    //@Interface FromXMLString
    public static Scorer fromXMLString(String xml) {
        return (Scorer)AppXML.fromXML(xml);
    }

    public HardSoftScore calculateScore(Solution solution) {
        HardSoftScore score = HardSoftScore.ZERO;
        final Set<Maker> makers = solution.getMakers(); assert makers != null : " makers is null";
        final Set<Taker> takers = solution.getTakers(); assert takers != null : " takers is null";
        final Set<Matcher> matchers = solution.getMatchers(); assert matchers != null : " matchers is null";
        for(Matcher matcher: matchers){
            score = score.add(this.calculateScoreWithMatcher(matcher));
        }
        return score;
    }

    public HardSoftScore calculateScoreWithMatcher(Matcher matcher) {
        final Maker maker = matcher.getMaker(); if (maker == null){ return HardSoftScore.of(-1,0); }
        final Taker taker = matcher.getTaker(); if (taker == null){ return HardSoftScore.of(-1,0); }
        return calculateScoreWithTrackables(maker, taker).add(calculateScoreWithTrackables(taker, maker));
    }

    public HardSoftScore calculateScoreWithTrackables(Trackable a, Trackable b) {
        if (a == null || b == null){ return HardSoftScore.of(-1,0); }
        return calculateScoreWithTagSetAndTagScoreSet(a.getTagSet(), b.getTagScoreSet());
    }

    public HardSoftScore calculateScoreWithTagSetAndTagScoreSet(TagSet tagSet, TagScoreSet tagScoreSet) {
        if (tagSet == null || tagScoreSet == null){ return HardSoftScore.of(-1,0); }
        return calculateScoreWithTagsAndTagScores(tagSet.getElements(), tagScoreSet.getElements());
    }

    public HardSoftScore calculateScoreWithTagsAndTagScores(Set<Tag> tags, Set<TagScore> tagScores) {
        if (tags == null || tagScores == null){ return HardSoftScore.of(-1,0); }

        // Cache the viable tag names
        Set<String> names = tags.stream().map(
            tag -> tag.getName()
        ).collect(Collectors.toSet());

        // Select the viable tagScore elements
        Set<TagScore> tagScoresFiltered = tagScores.stream().filter(
            tagScore -> names.contains(tagScore.getName())
        ).collect(Collectors.toSet());

        // Map each viable tagScore elements to its score
        List<HardSoftScore> scores = tagScoresFiltered.stream().map(
            tagScore -> tagScore.getScore()
        ).collect(Collectors.toList());

        // Sum the scores
        return scores.stream().reduce(
            HardSoftScore.ZERO, 
            (a, b) -> a.add(b)
        );
    }

}
