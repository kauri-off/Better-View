package com.kauri.altzoom;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = AltZoom.MODID, name = AltZoom.NAME, version = AltZoom.VERSION)
public class AltZoom
{
    public static final String MODID = "altzoom";
    public static final String NAME = "AltZoom";
    public static final String VERSION = "1.1";

    private static Logger logger;
    private KeyBinding key = new KeyBinding(
            "First person",
            Keyboard.KEY_R,
            "Kauri mods"
    );

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        ClientRegistry.registerKeyBinding(key);
    }
    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (key.isPressed()) {
            switch (Minecraft.getMinecraft().gameSettings.thirdPersonView) {
                case 0: Minecraft.getMinecraft().gameSettings.thirdPersonView = 1; break;
                default: Minecraft.getMinecraft().gameSettings.thirdPersonView = 0; break;
            }
        }
    }
}
