package kewaiigamer.rice.tile;

import kewaiigamer.rice.gui.riceautocraftingtable.ItemAutoCraftHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class TileEntityRiceAutoCrafting extends TileEntity implements ICapabilityProvider {

    public ItemAutoCraftHandler matrix = new ItemAutoCraftHandler(81, this);
    private ItemStack result;
    private ItemStack[] matrixStack = new ItemStack[81];
    //net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.UP);
    //net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.DOWN);
    //net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, EnumFacing.WEST);
    private static final int[] SLOTS_TOP = new int[]{0};
    private static final int[] SLOTS_BOTTOM = new int[]{2, 1};
    private static final int[] SLOTS_SIDES = new int[]{1};
    private String riceCraftingCustomName;

    public ItemStack getResult()
    {
        return result;
    }

    public void setResult(ItemStack result)
    {
        this.result = result;
    }

    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        matrix.setStackInSlot(slot, stack);
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        matrix.deserializeNBT(compound.getCompoundTag("matrix"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("matrix", matrix.serializeNBT());
        return super.writeToNBT(compound);
    }


    /*
    @Override
    public int getSizeInventory() {
        return 82;
    }
    */

    /*
    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == 0)
            return result;
        else if (slot <= matrixStack.length)
            return matrixStack[slot - 1];
        else
            return null;
    }
    */
/*
    @Override
    public ItemStack decrStackSize(int slot, int decrement) {

        if (slot == 0) {
            if (result != null) {
                for (int x = 1; x <= matrixStack.length; x++) {
                    decrStackSize(x, 1);
                }
                if (result.stackSize <= decrement) {
                    ItemStack craft = result;
                    result = null;
                    return craft;
                }
                ItemStack split = result.splitStack(decrement);
                if (result.stackSize <= 0)
                    result = null;
                return split;
            } else
                return null;
        } else if (slot <= matrixStack.length) {
            if (matrixStack[slot - 1] != null) {
                if (matrixStack[slot - 1].stackSize <= decrement) {
                    ItemStack ingredient = matrix[slot - 1];
                    matrix[slot - 1] = null;
                    return ingredient;
                }
                ItemStack split = matrix[slot - 1].splitStack(decrement);
                if (matrix[slot - 1].stackSize <= 0)
                    matrix[slot - 1] = null;
                return split;
            }
        }
        return null;
    }
*/
/*
    @Nullable
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }
*/
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.getWorld().getTileEntity(this.getPos()) == this
                && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }
/*
    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {

        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }


    @Override
    public void clear() {
        for (int i = 0; i < this.matrix.length; ++i) {
            this.matrix[i] = null;
        }
    }


    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
*/
    /*
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (slot == 0) {
            result = stack;
        } else if (slot <= matrix.length) {
            matrix[slot - 1] = stack;
        }
    }
    */
/*
    @Override
    public String getName() {
        return this.hasCustomName() ? this.riceCraftingCustomName : "container.Rice_Crafting ";
    }

    @Override
    public boolean hasCustomName() {
        return this.riceCraftingCustomName != null && !this.riceCraftingCustomName.isEmpty();
    }


    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        if (direction == EnumFacing.DOWN && index == 2) {


            return true;
        }
        return false;
    }
*/
  /*  public void setCustomInventoryName(String p_145951_1_) {
        this.riceCraftingCustomName = p_145951_1_;
    }
    */

}

