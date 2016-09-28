package kewaiigamer.rice.tile.inventory.ricecraftingtable;

import kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;

public class InventoryRiceCraftResult extends InventoryCraftResult {

    private TileEntityRiceCrafting craft;

    public InventoryRiceCraftResult(TileEntityRiceCrafting table) {
        craft = table;
    }

    @Override
    public ItemStack getStackInSlot(int par1) {
        return craft.getStackInSlot(0);
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        ItemStack stack = craft.getStackInSlot(0);
        if (stack != null) {
            ItemStack itemstack = stack;
            craft.setInventorySlotContents(0, null);
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        craft.setInventorySlotContents(0, par2ItemStack);
    }

}
