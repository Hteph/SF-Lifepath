package com.github.drhteph.sflifepath.utils;

import com.valkryst.VNameGenerator.generator.MarkovGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class NameGenerators {
    
    static final String[] trainingNames = new String[]{
            "Negor ", " Larpro", "Zucren", "Lazo", "Rysthrad", "Anvorg", "Twiborg", "Mylou", "Taluc", "Aur", "Neeur", "Kehlas", "Nonella",
            "Rodzol", "Drodak", "Melke", "Zexra", "Merpox", "Shraszac", "Valum", "Hatoru", "Twigor", "Uge", "Bekmorg", "Lame", "Orpry",
            "Koors", "Ut", "Zapik", "Yeru", "Gahne", "Tron", "Jedroum", "Konkang", "Zorg", "Thilek", "Keko", "Jata", "Ja", "Grabzuc", "Ugorin",
            "Phakore", "Aras", "Uphuviar", "Uwyn", "Elanneas", "Unukey", "Ubras", "Urin", "Uhossaem", "Eharas", "Negoris", "Phubras", "Oruvys",
            "Teneth", "Ezor", "Orrigorin", "Irrildor", "Ihith", "Uviar", "Utosh", "Rhulleas", "Hovior", "Opan", "Onorim", "Olenor", "Ollevior",
            "Eneth", "Egorin", "Ebine", "Leo", "Halcyon","Serpens","Sirius","Dalim","Nix","Caelum","Achernar","Phact","Eos"
    };
    
    public static String randomName(int length) {
        
        final MarkovGenerator generator = new MarkovGenerator(trainingNames);
        
        return generator.generate(length);
        
    }
}
