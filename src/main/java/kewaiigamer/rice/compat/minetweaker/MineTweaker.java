package kewaiigamer.rice.compat.minetweaker;

import minetweaker.MineTweakerAPI;

/**
 * Created by Miguel on 18/09/2016.
 */
public class MineTweaker {
    public static void registerModCompat() {
        MineTweakerAPI.registerClass(ExtremeCrafting.class);
    }
}
