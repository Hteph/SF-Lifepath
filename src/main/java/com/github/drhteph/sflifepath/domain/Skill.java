package com.github.drhteph.sflifepath.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Skill {
    
    int level;
    ArrayList<String> specialisations;
    String notes;
}
