package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

public class Solution {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private Set<Maker> makers;

    public Set<Maker> getMakers() {
        return makers;
    }

    public void setMakers(Set<Maker> makers) {
        this.makers = makers;
    }

    private Set<Taker> takers;

    public Set<Taker> getTakers() {
        return takers;
    }

    public void setTakers(Set<Taker> takers) {
        this.takers = takers;
    }

    private Set<Matcher> matchers;

    public Set<Matcher> getMatchers() {
        return matchers;
    }

    public void setMatchers(Set<Matcher> matchers) {
        this.matchers = matchers;
    }

}
