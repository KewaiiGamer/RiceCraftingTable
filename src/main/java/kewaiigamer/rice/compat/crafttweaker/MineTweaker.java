package kewaiigamer.rice.compat.crafttweaker;

import minetweaker.MineTweakerAPI;

public class MineTweaker {
    public static void registerModCompat() {
        MineTweakerAPI.registerClass(ExtremeCrafting.class);
    }
}
