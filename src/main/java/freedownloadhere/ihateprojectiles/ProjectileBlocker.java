package freedownloadhere.ihateprojectiles;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ProjectileBlocker
{
    public static void init()
    {
        instance = new ProjectileBlocker();
    }
    public static ProjectileBlocker getInstance()
    {
        return instance;
    }
    private static ProjectileBlocker instance;
    private ProjectileBlocker(){}

    private static final int RIGHT_CLICK = 1;

    @SubscribeEvent
    public void onRightClick(MouseEvent event)
    {
        if(event.button != RIGHT_CLICK || Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() == null)
            return;

        String held = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getDisplayName();

        if(held.equals("Snowball") || held.equals("Egg") || held.equals("Bow") || held.equals("Fishing Rod"))
        {
            event.setCanceled(true);
            Minecraft.getMinecraft().thePlayer.addChatComponentMessage(
                    new ChatComponentText("\u00A7c\u00A7lI HATE PROJECTILES! \u00A77You can't use that!")
            );
            Minecraft.getMinecraft().theWorld.playSound(
                    Minecraft.getMinecraft().thePlayer.posX,
                    Minecraft.getMinecraft().thePlayer.posY,
                    Minecraft.getMinecraft().thePlayer.posZ,
                    "random.break",
                    100.f,
                    1.f,
                    false
            );
        }
    }
}
