package kewaiigamer.rice.gui.riceautocraftingtable;

import kewaiigamer.rice.tile.TileEntityRiceAutoCrafting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUIExtremeAutoCrafting extends GuiContainer {

    private static final ResourceLocation tex = new ResourceLocation("rice:textures/gui/rice_crafting_gui.png");

    public GUIExtremeAutoCrafting(TileEntityRiceAutoCrafting tileEntity, ContainerExtremeAutoCrafting container) {
        super(container);
        this.ySize = 256;
        this.xSize = 238;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(tex);
        int foo = (this.width - this.xSize) / 2;
        int bar = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(foo, bar, 0, 0, this.ySize, this.ySize);
    }
}
