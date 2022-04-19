package com.github.drhteph.sflifepath.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Person {
    int age;
    String name;
    @Singular
    List<Person> biologicalParents;
    Statline statline;
    
    public int getC1value(){
    
        return statline.getC1().getGenetic() + statline.getC1().getLife();
    }
    public int getC2value(){
    
        return statline.getC2().getGenetic() + statline.getC2().getLife();
    }
    public int getC3value(){
    
        return statline.getC3().getGenetic() + statline.getC3().getLife();
    }
    public int getC4value(){
    
        return statline.getC4().getGenetic() + statline.getC4().getLife();
    }
    public int getC5value(){
    
        return statline.getC5().getGenetic() + statline.getC5().getLife();
    }
    public int getC6value(){
    
        return statline.getC6().getGenetic() + statline.getC6().getLife();
    }

}
