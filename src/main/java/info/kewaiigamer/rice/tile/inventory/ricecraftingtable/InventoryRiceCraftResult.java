package info.kewaiigamer.rice.tile.inventory.ricecraftingtable;

import info.kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;

public class InventoryRiceCraftResult extends InventoryCraftResult {

    private TileEntityRiceCrafting craft;

    public InventoryRiceCraftResult(TileEntityRiceCrafting te)
    {
        craft = te;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot == 0 ? craft.getResult() : null;
    }

    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        //return craft.decrStackSize(slot, decrement);
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