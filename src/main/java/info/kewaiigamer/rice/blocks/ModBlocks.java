package info.kewaiigamer.rice.blocks;

import info.kewaiigamer.rice.utils.RiceBlockUtils;

public class ModBlocks {

    public static BlockRiceCrafting blockRiceCrafting;

    public static void registerModels() {
        RiceBlockUtils.registerRiceBlockRender(blockRiceCrafting, "rice_crafting_table");
    }


    public static void init()
    {
        blockRiceCrafting = new BlockRiceCrafting();}
}