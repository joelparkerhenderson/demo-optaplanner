package com.joelparkerhenderson.demo.optaplanner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

interface HasScore { 
    public HardSoftScore getScore(); 
    public void setScore(HardSoftScore score); 
}
