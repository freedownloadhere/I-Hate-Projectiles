package freedownloadhere.ihateprojectiles;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class TheMod
{
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ProjectileBlocker.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(ProjectileBlocker.getInstance());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
