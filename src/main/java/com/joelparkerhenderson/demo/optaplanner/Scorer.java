package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public class Scorer implements EasyScoreCalculator<Solution> {

    public HardSoftScore calculateScore(Solution solution) {
        HardSoftScore score = HardSoftScore.of(0,0);

        final Set<Maker> makers = solution.getMakers(); assert makers != null : " makers is null";
        final Set<Taker> takers = solution.getTakers(); assert takers != null : " makers is null";
        final Set<Matcher> matchers = solution.getMatchers(); assert matchers != null : " matchers is null";

        for(Matcher matcher: matchers){
            score = score.add(this.calculateScoreWithMatcher(matcher));
        }

        return score;
    }

    public HardSoftScore calculateScoreWithMatcher(Matcher matcher) {
        HardSoftScore score = HardSoftScore.of(0,0);

        final Maker maker = matcher.getMaker(); assert maker != null : " maker is null";
        final Taker taker = matcher.getTaker(); assert taker != null : " taker is null"; 

        final String makerName = maker.getName(); assert makerName != null : " makerName is null"; 
        final String takerName = taker.getName(); assert takerName != null : " takerName is null"; 

        // Example: prefer the maker name equals the taker name
        score = score.add(HardSoftScore.of(0, (makerName == takerName) ? 1 : -1));

        return score;
    }       

}