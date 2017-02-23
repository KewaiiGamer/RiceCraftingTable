package info.kewaiigamer.rice;

import info.kewaiigamer.rice.blocks.ModBlocks;
import info.kewaiigamer.rice.compat.Compat;
import info.kewaiigamer.rice.gui.GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import static info.kewaiigamer.rice.Rice.Instance;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        Compat.checkMods();
        ModBlocks.init();
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
        Compat.registerModsCompat();
    }
}