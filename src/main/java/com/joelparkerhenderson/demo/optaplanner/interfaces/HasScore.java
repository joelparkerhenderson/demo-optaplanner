package com.joelparkerhenderson.demo.optaplanner.interfaces;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

public interface HasScore { 
    public HardSoftScore getScore(); 
    public void setScore(HardSoftScore score); 
}
