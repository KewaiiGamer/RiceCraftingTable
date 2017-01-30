package kewaiigamer.rice;

import kewaiigamer.rice.crafting.ExtremeCraftingManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Rice.MODID, name = Rice.NAME, version = Rice.VERSION)
public class Rice {

    public static final String MODID = "rice";
    public static final String NAME = "Rice";
    public static final String VERSION = "0.8";
    public static final String COMMON_PROXY_CLASS = "kewaiigamer.rice.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "kewaiigamer.rice.ClientProxy";
    @Instance(MODID)
    public static Rice Instance = new Rice();

    @SidedProxy(serverSide = COMMON_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
    public static CommonProxy proxy = new CommonProxy();


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Rice.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        Rice.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        Rice.proxy.postInit(e);

    }
}