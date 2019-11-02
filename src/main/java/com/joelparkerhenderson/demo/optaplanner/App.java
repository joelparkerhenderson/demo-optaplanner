package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;

public class App
{

    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Demo OptaPlanner version 0.1.0");
        System.out.println("Demo OptaPlanner version 0.1.0");
        final Solution solution = createDemoSolutionWithExamples();
        final SolverFactory<Solution> solverFactory = createDemoSolverFactory();
        final Solver<Solution> solver = solverFactory.buildSolver();
        final Solution solved = solver.solve(solution);
        System.out.println("Solved...");
        System.out.println(solved.toStringDeep());
        System.exit(0);
    }


    public static Solution createDemoSolutionWithExamples(){
        final Solution solution = new Solution();
        solution.setName("Demo Solution");

        final Set<Maker> makers = new HashSet<Maker>();
        final Set<Taker> takers = new HashSet<Taker>();
        final Set<Matcher> matchers = new HashSet<Matcher>();

        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        for(int i=0; i<10; i++){
            String name = String.format("%01d", i);
            final Maker maker = new Maker(); maker.setName(name); makers.add(maker);
            final Taker taker = new Taker(); taker.setName(name); takers.add(taker);
            final Matcher matcher = new Matcher(); matcher.setName(name); matcher.setMaker(maker); matchers.add(matcher);
        }

        return solution;
    }

    public static SolverFactory<Solution> createDemoSolverFactory(){
        final SolverFactory<Solution> solverFactory = SolverFactory.createEmpty();
        final SolverConfig solverConfig = solverFactory.getSolverConfig();
        solverConfig.setSolutionClass(Solution.class);
        solverConfig.setEntityClassList(createDemoEntityClassList());
        solverConfig.setScoreDirectorFactoryConfig(createDemoScoreDirectorFactoryConfig());
        solverConfig.setTerminationConfig(createDemoTerminationConfig());
        return solverFactory;
    }

    public static ScoreDirectorFactoryConfig createDemoScoreDirectorFactoryConfig(){
        final ScoreDirectorFactoryConfig scoreDirectorFactoryConfig = new ScoreDirectorFactoryConfig();
        scoreDirectorFactoryConfig.setEasyScoreCalculatorClass(Scorer.class);
        return scoreDirectorFactoryConfig;
    }

    public static List<Class<?>> createDemoEntityClassList(){
        final List<Class<?>> entityClassList = new Vector<Class<?>>();
        entityClassList.add(Matcher.class);
        return entityClassList;
    }

    public static TerminationConfig createDemoTerminationConfig(){
        final TerminationConfig terminationConfig = new TerminationConfig();
        terminationConfig.setSecondsSpentLimit(10L);
        return terminationConfig;
    }

}
