package kewaiigamer.rice;

import kewaiigamer.rice.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab {
    public static final CreativeTabs tabRice = new CreativeTabs("Rice") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.blockRiceCrafting);
        }

        @Override
        public boolean hasSearchBar() {
            return false;
        }
    };
}