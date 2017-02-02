package kewaiigamer.rice.compat.minetweaker;

import minetweaker.MineTweakerAPI;

public class MineTweaker {
    public static void registerModCompat() {
        MineTweakerAPI.registerClass(ExtremeCrafting.class);
    }
}
