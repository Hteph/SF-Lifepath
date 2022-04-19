package com.github.drhteph.sflifepath.creators;

import com.github.drhteph.sflifepath.domain.Person;
import com.github.drhteph.sflifepath.domain.Stat;
import com.github.drhteph.sflifepath.domain.Statline;
import com.github.drhteph.sflifepath.utils.Dice;
import com.github.drhteph.sflifepath.utils.NameGenerators;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateHuman {
    
    static Random rand = new Random();
    
    public static Person getRandomHuman() {
        
        var person = Person.builder();
        
        person.age(20 + rand.nextInt(40));
        
        var statline = Statline.builder();
        
        statline.c1(new Stat(Dice.d6(), Dice.d6(), "Strength"));
        statline.c2(new Stat(Dice.d6(), Dice.d6(), "Dexterity"));
        statline.c3(new Stat(Dice.d6(), Dice.d6(), "Stamina"));
        statline.c4(new Stat(Dice.d6(), Dice.d6(), "Intelligence"));
        statline.c5(new Stat(Dice.d6(), Dice.d6(), "Education"));
        statline.c6(new Stat(Dice.d6(), Dice.d6(), "Social"));
        
        person.statline(statline.build());
        
        person.name(NameGenerators.randomName(8) + " " + NameGenerators.randomName(12));
        
        return person.build();
    }
    
    public static Person generateMainHumanCharacter() {
        
        var parent1 = GenerateHuman.getRandomHuman();
        var parent2 = GenerateHuman.getRandomHuman();
        
        var statline = Statline.builder();
        
        statline.c1(new Stat(getGeneticsNumber(parent1.getStatline().getC1().getGenetic(),
                                               parent2.getStatline().getC1().getGenetic()),
                             0,
                             "Strength"));
        statline.c2(new Stat(getGeneticsNumber(parent1.getStatline().getC2().getGenetic(), parent2.getStatline().getC2().getGenetic()),
                             0,
                             "Dexterity"));
        statline.c3(new Stat(getGeneticsNumber(parent1.getStatline().getC3().getGenetic(), parent2.getStatline().getC3().getGenetic()),
                             0,
                             "Stamina"));
        statline.c4(new Stat(getGeneticsNumber(parent1.getStatline().getC4().getGenetic(), parent2.getStatline().getC4().getGenetic()),
                             0,
                             "Intelligence"));
        statline.c5(new Stat(0, 0, "Education"));
        statline.c6(new Stat(Math.max(0,Math.min(9,(parent1.getC6value() + parent2.getC6value())/2-1)),0,"Social"));
        
        return Person.builder()
                     .statline(statline.build())
                     .name(NameGenerators.randomName(8) + " " + getFamilyNameComplicated(parent1, parent2))
                     .biologicalParent(parent1)
                     .biologicalParent(parent2)
                     .build();
    }
    
    private static String getFamilyNameComplicated(Person parent1, Person parent2) {
        
        //Asumption is that the parent with highest social standing provides the family name
        //But there is a 1 in 10 chance that name is chosen on other grounds
        
        String familyName;
        int obstinateChance = rand.nextInt(10);
        
        if(parent1.getC6value() == parent2.getC6value() || obstinateChance<1) {
    
            int chance = rand.nextInt(5);
            int chance2 = rand.nextInt(5);
    
            if (chance < 2) {
                var nameSplit = parent1.getName().split(" ");
                familyName = nameSplit[1];
            } else if (chance < 4) {
                var nameSplit = parent2.getName().split(" ");
                familyName = nameSplit[1];
            } else {
                familyName = getFamilyNameComplicated(parent1, parent2, chance2);
            }
        } else {
            if(parent1.getC6value()>parent2.getC6value()){
                var nameSplit = parent1.getName().split(" ");
                familyName = nameSplit[1];
            } else{
                var nameSplit = parent2.getName().split(" ");
                familyName = nameSplit[1];
            }
        }
        return familyName;
    }
    
    private static String getFamilyNameComplicated(Person parent1, Person parent2, int chance2) {
        String familyName;
        var nameSplit1 = parent1.getName().split(" ");
        var nameSplit2 = parent2.getName().split(" ");
        if (!(nameSplit1[1].contains("-") || nameSplit2[1].contains("-"))) {
            familyName = nameSplit1[1] + "-" + nameSplit2[1];
        } else {
            if (chance2 < 2) {
                var nameSplit = parent1.getName().split(" ");
                familyName = nameSplit[1];
            } else if(chance2 <4){
                var nameSplit = parent2.getName().split(" ");
                familyName = nameSplit[1];
            }else {
                familyName = NameGenerators.randomName(10);
            }
        }
        return familyName;
    }
    
    private static int getGeneticsNumber(int parent1, int parent2) {
        
        int genetics;
        
        int chance = rand.nextInt(5);
        
        if (chance < 2) {
            genetics = parent1;
        } else if (chance < 4) {
            genetics = parent2;
        } else {
            genetics = (parent1 + parent2) / 2;
        }
        
        return genetics;
    }
}
