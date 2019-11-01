package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Set<Maker> makers = new HashSet<Maker>();
        Set<Taker> takers = new HashSet<Taker>();
        Set<Matcher> matchers = new HashSet<Matcher>();
        
        Maker makerA = new Maker(); makerA.setName("A"); makers.add(makerA);
        Maker makerB = new Maker(); makerB.setName("B"); makers.add(makerB);
        Maker makerC = new Maker(); makerC.setName("C"); makers.add(makerC);
        Maker makerD = new Maker(); makerD.setName("D"); makers.add(makerD);
        Maker makerE = new Maker(); makerE.setName("E"); makers.add(makerE);
        Maker makerF = new Maker(); makerF.setName("F"); makers.add(makerA);

        Taker takerA = new Taker(); takerA.setName("A"); takers.add(takerA);
        Taker takerB = new Taker(); takerB.setName("B"); takers.add(takerB);
        Taker takerC = new Taker(); takerC.setName("C"); takers.add(takerC);
        Taker takerD = new Taker(); takerD.setName("D"); takers.add(takerD);
        Taker takerE = new Taker(); takerE.setName("E"); takers.add(takerE);
        Taker takerF = new Taker(); takerF.setName("F"); takers.add(takerF);

        Matcher matcherA = new Matcher(); matcherA.setMaker(makerA); matchers.add(matcherA);
        Matcher matcherB = new Matcher(); matcherB.setMaker(makerB); matchers.add(matcherB);
        Matcher matcherC = new Matcher(); matcherC.setMaker(makerC); matchers.add(matcherC);
        Matcher matcherD = new Matcher(); matcherD.setMaker(makerD); matchers.add(matcherD);
        Matcher matcherE = new Matcher(); matcherE.setMaker(makerE); matchers.add(matcherE);
        Matcher matcherF = new Matcher(); matcherF.setMaker(makerF); matchers.add(matcherF);

        Solution solution = new Solution();
        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

    }
}
