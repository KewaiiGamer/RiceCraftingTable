package kewaiigamer.rice.blocks;

import kewaiigamer.rice.utils.RiceBlockUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockRiceCrafting blockRiceCrafting;

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        RiceBlockUtils.registerRiceBlockRender(blockRiceCrafting, "rice_crafting_table");
    }

    public static void init() {
        blockRiceCrafting = new BlockRiceCrafting();
    }
}