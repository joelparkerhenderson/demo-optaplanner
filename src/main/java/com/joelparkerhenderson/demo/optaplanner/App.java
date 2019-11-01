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
        System.out.println("Demo OptaPlanner version 0.1.0");

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

        Matcher matcherA = new Matcher(); matcherA.setName("A"); matcherA.setMaker(makerA); matcherA.setTaker(takerA); matchers.add(matcherA);
        Matcher matcherB = new Matcher(); matcherB.setName("B"); matcherB.setMaker(makerB); matcherB.setTaker(takerB); matchers.add(matcherB);
        Matcher matcherC = new Matcher(); matcherC.setName("C"); matcherC.setMaker(makerC); matcherC.setTaker(takerC); matchers.add(matcherC);
        Matcher matcherD = new Matcher(); matcherD.setName("D"); matcherD.setMaker(makerD); matcherD.setTaker(takerD); matchers.add(matcherD);
        Matcher matcherE = new Matcher(); matcherE.setName("E"); matcherE.setMaker(makerE); matcherE.setTaker(takerE); matchers.add(matcherE);
        Matcher matcherF = new Matcher(); matcherF.setName("F"); matcherF.setMaker(makerF); matcherF.setTaker(takerF); matchers.add(matcherF);

        Solution solution = new Solution();
        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        System.out.println("Matchers...");
        for(Matcher matcher: matchers){
            System.out.println("Matcher mame:" + matcher.getName() + " maker_name:" + matcher.getMaker().getName() + " taker_name:" + matcher.getTaker().getName());
        }
        
    }
}
