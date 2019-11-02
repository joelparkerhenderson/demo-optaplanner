package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig;
import org.optaplanner.core.config.solver.SolverConfig;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Demo OptaPlanner version 0.1.0");

        final Set<Maker> makers = new HashSet<Maker>();
        final Set<Taker> takers = new HashSet<Taker>();
        final Set<Matcher> matchers = new HashSet<Matcher>();

        final Maker makerA = new Maker(); makerA.setName("A"); makers.add(makerA);
        final Maker makerB = new Maker(); makerB.setName("B"); makers.add(makerB);
        final Maker makerC = new Maker(); makerC.setName("C"); makers.add(makerC);
        final Maker makerD = new Maker(); makerD.setName("D"); makers.add(makerD);
        final Maker makerE = new Maker(); makerE.setName("E"); makers.add(makerE);
        final Maker makerF = new Maker(); makerF.setName("F"); makers.add(makerA);

        final Taker takerA = new Taker(); takerA.setName("A"); takers.add(takerA);
        final Taker takerB = new Taker(); takerB.setName("B"); takers.add(takerB);
        final Taker takerC = new Taker(); takerC.setName("C"); takers.add(takerC);
        final Taker takerD = new Taker(); takerD.setName("D"); takers.add(takerD);
        final Taker takerE = new Taker(); takerE.setName("E"); takers.add(takerE);
        final Taker takerF = new Taker(); takerF.setName("F"); takers.add(takerF);

        final Matcher matcherA = new Matcher(); matcherA.setName("A"); matcherA.setMaker(makerA); matcherA.setTaker(takerA); matchers.add(matcherA);
        final Matcher matcherB = new Matcher(); matcherB.setName("B"); matcherB.setMaker(makerB); matcherB.setTaker(takerB); matchers.add(matcherB);
        final Matcher matcherC = new Matcher(); matcherC.setName("C"); matcherC.setMaker(makerC); matcherC.setTaker(takerC); matchers.add(matcherC);
        final Matcher matcherD = new Matcher(); matcherD.setName("D"); matcherD.setMaker(makerD); matcherD.setTaker(takerD); matchers.add(matcherD);
        final Matcher matcherE = new Matcher(); matcherE.setName("E"); matcherE.setMaker(makerE); matcherE.setTaker(takerE); matchers.add(matcherE);
        final Matcher matcherF = new Matcher(); matcherF.setName("F"); matcherF.setMaker(makerF); matcherF.setTaker(takerF); matchers.add(matcherF);

        System.out.println("Makers...");
        makers.stream().sorted().forEachOrdered((maker) -> 
            System.out.println("Maker name:" + maker.getName())
        );

        System.out.println("Takers...");
        takers.stream().sorted().forEachOrdered((taker) -> 
            System.out.println("Taker name:" + taker.getName())
        );

        System.out.println("Matchers...");
        matchers.stream().sorted().forEachOrdered((matcher) -> 
            System.out.println("Matcher name:" + matcher.getName() + " maker_name:" + matcher.getMaker().getName() + " taker_name:" + matcher.getTaker().getName())
        );

        final Solution solution = new Solution();
        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        // Create the solver factory and its config
        SolverFactory<Solution> solverFactory = SolverFactory.createEmpty();
        SolverConfig solverConfig = solverFactory.getSolverConfig();

        // Adjust the config as needed
        solverConfig.setSolutionClass(Solution.class);
        List<Class<?>> entityClassList = new Vector<Class<?>>();
        entityClassList.add(Matcher.class);
        solverConfig.setEntityClassList(entityClassList);
        ScoreDirectorFactoryConfig scoreDirectorFactoryConfig = new ScoreDirectorFactoryConfig();
        scoreDirectorFactoryConfig.setEasyScoreCalculatorClass(Scorer.class);
        solverConfig.setScoreDirectorFactoryConfig(scoreDirectorFactoryConfig);

        // Solve everything
        Solver<Solution> solver = solverFactory.buildSolver();
        Solution solved = solver.solve(solution);

    }
}
