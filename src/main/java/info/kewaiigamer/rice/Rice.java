package info.kewaiigamer.rice;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static info.kewaiigamer.rice.Ref.*;

@Mod(modid = MODID, name = NAME, version = VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH + "." + VERSION_BUILD, dependencies = "required-after:kelib@[1.2.1.0,]")
public class Rice {


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