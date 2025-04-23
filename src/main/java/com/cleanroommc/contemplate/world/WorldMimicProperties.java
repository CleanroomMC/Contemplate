package com.cleanroommc.contemplate.world;

import net.minecraft.world.WorldProvider;

public class WorldMimicProperties {

    public static WorldMimicProperties of(WorldProvider provider) {
        return new WorldMimicProperties(provider);
    }

    public static WorldMimicProperties overworld() {
        return new WorldMimicProperties(true);
    }

    public static WorldMimicProperties nether() {
        return new WorldMimicProperties(false);
    }

    public static WorldMimicProperties end() {
        return new WorldMimicProperties(true);
    }

    private final boolean skyLight;

    private WorldMimicProperties(WorldProvider provider) {
        this(provider.hasSkyLight());
    }

    private WorldMimicProperties(boolean skyLight) {
        this.skyLight = skyLight;
    }

}
