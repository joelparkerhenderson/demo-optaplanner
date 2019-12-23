package com.joelparkerhenderson.demo.optaplanner;

import java.util.*;
import java.util.stream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.score.director.ScoreDirectorFactoryConfig;
import org.optaplanner.core.config.solver.SolverConfig;
import org.optaplanner.core.config.solver.termination.TerminationConfig;

public class App
{

    public static void main( String[] args )
    {
        // Startup
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Demo OptaPlanner version 1.0.0");
        System.out.println("Demo OptaPlanner version 1.0.0");

        // Create the solution container
        final Solution solution = createDemoSolutionWithExamples();
        System.out.println("Initialize...");
        System.out.println(solution.toStringDeep());

        // Create the solver
        final SolverFactory<Solution> solverFactory = createDemoSolverFactory();
        final Solver<Solution> solver = solverFactory.buildSolver();

        // Solve
        final Solution solved = solver.solve(solution);
        System.out.println("Solved...");
        System.out.println(solved.toStringDeep());
        System.exit(0);
    }

    public static Solution createDemoSolutionWithExamples(){
        Logger logger = LoggerFactory.getLogger(App.class);
        final Solution solution = _solution("Demo Solution");

        final Set<Maker> makers = new HashSet<Maker>();
        final Set<Taker> takers = new HashSet<Taker>();
        final Set<Matcher> matchers = new HashSet<Matcher>();

        solution.setMakers(makers);
        solution.setTakers(takers);
        solution.setMatchers(matchers);

        logger.info("createDemoSolutionWithExamples HERE");

        // For assert in the loop below
        // final Scorer scorer = new Scorer();
        // final HardSoftScore score = HardSoftScore.of(0,1).multiply(6); // because there are 3 example tags * 2 example trackables

        for(int i=0; i<10; i++){
            logger.info("createDemoSolutionWithExamples LOOP");
            String name = String.format("%01d", i);
            final Maker maker = _maker(name); makers.add(maker);
            final Taker taker = _taker(name); takers.add(taker);
            final Matcher matcher = _matcher(name); matcher.setMaker(maker); matchers.add(matcher);
            final TagSet tagSet = _tagSet(name + "A", name + "B", name + "C");
            final TagScoreSet tagScoreSet = _tagScoreSet(name + "A", name + "B", name + "C");
            maker.setTagSet(tagSet); maker.setTagScoreSet(tagScoreSet);
            taker.setTagSet(tagSet); taker.setTagScoreSet(tagScoreSet);
        }

        logger.info("Solution XML ...\n" + solution.toXMLString());

        return solution;
    }

    protected static Solution _solution(String name){
        final Solution solution = new Solution();
        solution.setName(name);
        return solution;
    }

    protected static Maker _maker(String name){
        final Maker maker = new Maker();
        maker.setName(name);
        return maker;
    }

    protected static Taker _taker(String name){
        final Taker taker = new Taker();
        taker.setName(name);
        return taker;
    }

    protected static Matcher _matcher(String name){
        final Matcher matcher = new Matcher(); 
        matcher.setName(name); 
        return matcher;
    }

    protected static Tag _tag(String name){
        final Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    protected static TagSet _tagSet(String ... names){
        TagSet tagSet = new TagSet();
        Set<Tag> tags = Stream.of(names).map(name -> _tag(name)).collect(Collectors.toSet());
        tagSet.setElements(tags);
        return tagSet;
    }

    protected static TagScore _tagScore(String name){
        final TagScore tagScore = new TagScore();
        tagScore.setName(name);
        tagScore.setScore(HardSoftScore.of(0,1));
        return tagScore;
    }

    protected static TagScoreSet _tagScoreSet(String ... names){
        TagScoreSet tagScoreSet = new TagScoreSet();
        Set<TagScore> tagScores = Stream.of(names).map(name -> _tagScore(name)).collect(Collectors.toSet());
        tagScoreSet.setElements(tagScores);
        return tagScoreSet;
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
