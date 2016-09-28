package kewaiigamer.rice.compat;

import kewaiigamer.rice.compat.minetweaker.MineTweaker;
import net.minecraftforge.fml.common.Loader;

/**
 * Created by Miguel on 18/09/2016.
 */
public class Compat {

    public static boolean CompatMT = false;

    public static void checkMods() {
        CompatMT = Loader.isModLoaded("MineTweaker3");
    }

    public static void registerModsCompat() {
        if (CompatMT) {
            MineTweaker.registerModCompat();
        }
    }
}
