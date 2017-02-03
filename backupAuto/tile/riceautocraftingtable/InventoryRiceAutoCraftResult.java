package kewaiigamer.rice.tile.inventory.riceautocraftingtable;

import kewaiigamer.rice.tile.TileEntityRiceAutoCrafting;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;

public class InventoryRiceAutoCraftResult extends InventoryCraftResult {

    private TileEntityRiceAutoCrafting craft;

    public InventoryRiceAutoCraftResult(TileEntityRiceAutoCrafting te) {
        craft = te;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot == 0 ? craft.getResult() : null;
    }

    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        ItemStack stack = craft.getResult();
        if (stack != null) {
            ItemStack itemstack = stack;
            craft.setResult(null);
            return itemstack;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        craft.setResult(stack);
    }

}
