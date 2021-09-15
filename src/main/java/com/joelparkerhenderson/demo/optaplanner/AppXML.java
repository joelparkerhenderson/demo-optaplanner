package com.joelparkerhenderson.demo.optaplanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

class AppXML { 

    private static XStream xstream;

    public static void init() {
        AppXML.xstream = new XStream(new DomDriver());
        AppXML.xstream.allowTypesByWildcard(new String[] { 
            "com.joelparkerhenderson.demo.optaplanner.**",
        });
        AppXML.xstream.alias("trackable", Trackable.class);
        AppXML.xstream.alias("solution", Solution.class);
        AppXML.xstream.alias("scorer", Scorer.class);
        AppXML.xstream.alias("matcher", Matcher.class);
        AppXML.xstream.alias("maker", Maker.class);
        AppXML.xstream.alias("maker-set", MakerSet.class);
        AppXML.xstream.alias("taker", Taker.class);
        AppXML.xstream.alias("taker-set", TakerSet.class);
        AppXML.xstream.alias("tag", Tag.class);
        AppXML.xstream.alias("tag-set", TagSet.class);
        AppXML.xstream.alias("tag-score", TagScore.class);
        AppXML.xstream.alias("tag-score-set", TagScoreSet.class);
    }

    public static String toXML(Object o) {
        if (xstream == null) { init(); }
        return AppXML.xstream.toXML(o);
    }

    public static Object fromXML(String s) {
        if (xstream == null) { init(); }
        return AppXML.xstream.fromXML(s);
    }

}
