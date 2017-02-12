package kewaiigamer.rice.utils;

import kewaiigamer.kewaiilib.utils.BlockUtils;
import kewaiigamer.rice.Rice;
import net.minecraft.block.Block;

public class RiceBlockUtils {

    public static void registerRiceBlockRender(Block block, String name) {
        BlockUtils.registerBlockRender(Rice.MODID, block, name);
    }
}