package kewaiigamer.rice.gui;

import kewaiigamer.rice.crafting.ExtremeCraftingManager;
import kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraftforge.items.ItemStackHandler;

public class ItemCraftHandler extends ItemStackHandler {

    public InventoryCrafting crafting;
    private TileEntityRiceCrafting te;

    public ItemCraftHandler(int size, TileEntityRiceCrafting te)
    {
        super(size);
        this.te = te;
    }

    @Override
    protected void onContentsChanged(int slot) {
        if(crafting != null)
            te.setResult(ExtremeCraftingManager.getInstance().findMatchingRecipe(this.crafting, te.getWorld()));
        super.onContentsChanged(slot);
    }

}
