package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = sounds.MODID, version = sounds.VERSION, name = sounds.NAME, acceptedMinecraftVersions = sounds.acceptedMineshaftVersions)
public class sounds {

    static final String MODID = "sounds";
    static final String VERSION = "1.0";
    static final String NAME = "SoundsMod";
    static final String acceptedMineshaftVersions = "[1.8.9]";


    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
