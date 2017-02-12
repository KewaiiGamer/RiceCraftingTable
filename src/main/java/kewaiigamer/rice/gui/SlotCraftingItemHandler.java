package kewaiigamer.rice.gui;

import kewaiigamer.rice.tile.inventory.ricecraftingtable.InventoryRiceCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class SlotCraftingItemHandler extends Slot {
    private final InventoryRiceCrafting craftingInv;
    private final IItemHandler matrix;
    private final EntityPlayer player;

    public SlotCraftingItemHandler(EntityPlayer player, InventoryCrafting craftingInventory, IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
    {
        super(inventoryIn, slotIndex, xPosition, yPosition);
        craftingInv = (InventoryRiceCrafting)craftingInventory;
        this.player = player;
        this.matrix = ((InventoryRiceCrafting)craftingInventory).craft.matrix;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(@Nullable ItemStack stack)
    {
        return false;
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack) {
        for (int i = 0; i < matrix.getSlots(); i++) {
            if(matrix.getStackInSlot(i) != null)
            {
                matrix.extractItem(i, 1, false);
            }
        }
        //craftingInv.craft.setResult(ExtremeCraftingManager.getInstance().findMatchingRecipe(craftingInv, craftingInv.craft.getWorld()));
        craftingInv.container.onCraftMatrixChanged(craftingInv);
    }
}