package kewaiigamer.rice.compat.crafttweaker;

import kewaiigamer.rice.compat.crafttweaker.handlers.ExtremeCrafting;
import minetweaker.MineTweakerAPI;

public class CraftTweaker {

    public static void registerTweaker() {
        MineTweakerAPI.registerClass(ExtremeCrafting.class);
    }
}
