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
        final Maker maker = matcher.getMaker(); if (maker == null){ return HardSoftScore.of(0,0); }
        final Taker taker = matcher.getTaker(); if (taker == null){ return HardSoftScore.of(0,0); }
        return calculateScoreWithMakerTaker(maker, taker);
    }

    public HardSoftScore calculateScoreWithMaker(Maker maker) {
        return HardSoftScore.of(0,0);
    }

    public HardSoftScore calculateScoreWithTaker(Taker taker) {
        return HardSoftScore.of(0,0);
    }

    public HardSoftScore calculateScoreWithMakerTaker(Maker maker, Taker taker) {
        if (maker == null){ return HardSoftScore.of(0,0); }
        if (taker == null){ return HardSoftScore.of(0,0); }
        final String makerName = maker.getName(); if (makerName == null){ return HardSoftScore.of(0,0); }
        final String takerName = taker.getName(); if (takerName == null){ return HardSoftScore.of(0,0); }
        HardSoftScore score = HardSoftScore.of(0,0);
        return HardSoftScore.of(0, (makerName == takerName) ? 1 : -1);
    }

}