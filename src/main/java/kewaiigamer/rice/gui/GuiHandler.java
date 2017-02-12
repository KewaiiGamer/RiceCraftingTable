package kewaiigamer.rice.gui;

import kewaiigamer.rice.gui.ricecraftingtable.ContainerExtremeCrafting;
import kewaiigamer.rice.gui.ricecraftingtable.GUIExtremeCrafting;
import kewaiigamer.rice.tile.TileEntityRiceCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_ID_ExtremeCrafting = 0;

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityRiceCrafting) {
            TileEntityRiceCrafting containerTileEntity = (TileEntityRiceCrafting) te;
            return new GUIExtremeCrafting(containerTileEntity, new ContainerExtremeCrafting(player.inventory, containerTileEntity));
        }
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityRiceCrafting) {
            return new ContainerExtremeCrafting(player.inventory, (TileEntityRiceCrafting) te);
        }
        return null;
    }
}