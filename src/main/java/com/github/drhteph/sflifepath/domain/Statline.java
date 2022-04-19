package com.github.drhteph.sflifepath.domain;

import javafx.util.Pair;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statline {
    
    Stat c1;    //Strength
    Stat c2;    //Dexterity, Vigor, Agility
    Stat c3;    //Stamina
    Stat c4;    //Intelligence
    Stat c5;    //Education, Instinct,
    Stat c6;    //Social, Charisma
    
}
