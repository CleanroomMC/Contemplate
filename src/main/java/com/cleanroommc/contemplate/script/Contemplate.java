package com.cleanroommc.contemplate.script;

import java.util.List;

public class Contemplate {

    public static Contemplate register(List<Concept> concepts) {
        return new Contemplate(concepts);
    }

    private final List<Concept> concepts;

    private Contemplate(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public Contemplating begin() {
        return new Contemplating(this.concepts);
    }

}
