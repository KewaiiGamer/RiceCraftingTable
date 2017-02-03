package kewaiigamer.rice.compat.crafttweaker;

import minetweaker.MineTweakerAPI;

public class CraftTweaker {
    public static void registerModCompat() {
        MineTweakerAPI.registerClass(ExtremeCrafting.class);
    }
}
