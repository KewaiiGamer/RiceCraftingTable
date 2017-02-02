package kewaiigamer.rice.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockRiceCrafting blockRiceCrafting;

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        blockRiceCrafting.initModel();
    }

    public static void init() {
        blockRiceCrafting = new BlockRiceCrafting();
    }
}
