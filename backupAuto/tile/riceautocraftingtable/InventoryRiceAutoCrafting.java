package kewaiigamer.rice.tile.inventory.riceautocraftingtable;

import kewaiigamer.rice.tile.TileEntityRiceAutoCrafting;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;

public class InventoryRiceAutoCrafting extends InventoryCrafting implements ISidedInventory{

    public TileEntityRiceAutoCrafting craft;
    private IItemHandler handler;
    public Container container;
    private static final int[] SLOTS_TOP = new int[]{0};
    private static final int[] SLOTS_BOTTOM = new int[]{2, 1};
    private static final int[] SLOTS_SIDES = new int[]{1};

    public InventoryRiceAutoCrafting(Container container, TileEntityRiceAutoCrafting te) {
        super(container, 9, 9);
        craft = te;
        handler = te.matrix;
        this.container = container;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot >= this.getSizeInventory() ? null : handler.getStackInSlot(slot);
    }

    @Override
    public ItemStack getStackInRowAndColumn(int row, int column) {
        if (row >= 0 && row < 9) {
            int x = row + column * 9;
            return this.getStackInSlot(x);
        } else {
            return null;
        }
    }

    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        ItemStack stack = handler.getStackInSlot(slot);
        this.container.onCraftMatrixChanged(this);
        System.out.println("Decrease Stack Size");
        if (stack != null) {
            ItemStack itemstack;
            if (stack.stackSize <= decrement) {
                itemstack = stack.copy();
                stack = null;
                craft.setInventorySlotContents(slot, null);
                this.container.onCraftMatrixChanged(this);
                return itemstack;
            } else {
                itemstack = stack.splitStack(decrement);
                if (stack.stackSize == 0) {
                    stack = null;
                    craft.setInventorySlotContents(slot, null);
                }
                this.container.onCraftMatrixChanged(this);
                return itemstack;
            }
        } else {
            return null;
        }
    }

    public void craft()
    {
        for (int i = 0; i < handler.getSlots(); i++) {
            if(handler.getStackInSlot(i) != null)
            {
                handler.extractItem(i, 1, false);
            }
        }
        this.container.onCraftMatrixChanged(this);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack) {
        craft.setInventorySlotContents(slot, itemstack);
        this.container.onCraftMatrixChanged(this);
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack stack, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, EnumFacing direction) {
        return true;
    }
}
