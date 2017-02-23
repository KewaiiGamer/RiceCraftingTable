package info.kewaiigamer.rice.utils;

import info.kewaiigamer.kewaiilib.utils.BlockUtils;
import net.minecraft.block.Block;

import static info.kewaiigamer.rice.Ref.MODID;

public class RiceBlockUtils {

    public static void registerRiceBlockRender(Block block, String name) {
        BlockUtils.registerBlockRender(MODID, block, name);
    }
}