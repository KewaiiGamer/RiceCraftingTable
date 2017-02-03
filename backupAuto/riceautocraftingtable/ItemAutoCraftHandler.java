package kewaiigamer.rice.gui.riceautocraftingtable;

import kewaiigamer.rice.crafting.ExtremeCraftingManager;
import kewaiigamer.rice.tile.TileEntityRiceAutoCrafting;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraftforge.items.ItemStackHandler;

public class ItemAutoCraftHandler  extends ItemStackHandler {

    public InventoryCrafting crafting;
    private TileEntityRiceAutoCrafting te;

    public ItemAutoCraftHandler(int size, TileEntityRiceAutoCrafting te)
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
