package kewaiigamer.rice.compat;

import kewaiigamer.rice.compat.crafttweaker.CraftTweaker;
import net.minecraftforge.fml.common.Loader;

public class Compat {

    public static boolean CompatMT = false;

    public static void checkMods() {
        CompatMT = Loader.isModLoaded("MineTweaker3");
    }

    public static void registerModsCompat() {
        if (CompatMT) {
            CraftTweaker.registerModCompat();
        }
    }
}
