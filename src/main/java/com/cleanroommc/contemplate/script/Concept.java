package com.cleanroommc.contemplate.script;

import com.cleanroommc.contemplate.world.Mind;

public abstract class Concept {

    protected final int ticks;

    protected Concept(int ticks) {
        this.ticks = ticks;
    }

    public int ticks() {
        return ticks;
    }

    public abstract void think(Mind mind);

}
