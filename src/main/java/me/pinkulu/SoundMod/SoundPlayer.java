package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoundPlayer {

    public static boolean boomerDeath;
    public static boolean oofDeath;
    public static boolean bruhDeath;
    public static boolean quackDeath;

    public static boolean boomerKill;
    public static boolean oofKill;
    public static boolean bruhKill;
    public static boolean quackKill;
    public static boolean gotchaKill;


    public static ResourceLocation boomer = new ResourceLocation("soundsmodutil", "boomer");
    public static ResourceLocation oof = new ResourceLocation("soundsmodutil", "oof");
    public static ResourceLocation bruh = new ResourceLocation("soundsmodutil", "bruh");
    public static ResourceLocation quack = new ResourceLocation("soundsmodutil", "quack");
    public static ResourceLocation gotcha = new ResourceLocation("soundsmodutil", "gotcha");

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        if (msg.startsWith("You died")) {
            if (boomerDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 1.0f, 1.0f);
            } else if (oofDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 1.0f, 1.0f);
            } else if (bruhDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 1.0f, 1.0f);
            } else if (quackDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 1.0f, 1.0f);
            }
            if (msg.endsWith("Final kill!")) {
                if (boomerDeath) {
                    Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 1.0f, 1.0f);
                } else if (oofDeath) {
                    Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 1.0f, 1.0f);
                } else if (bruhDeath) {
                    Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 1.0f, 1.0f);
                } else if (quackDeath) {
                    Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 1.0f, 1.0f);
                }
            }
            if (msg.startsWith("+") && msg.contains("Kill") && msg.contains("coins")) {
                if (boomerKill) {
                    Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 1.0f, 1.0f);
                } else if (oofKill) {
                    Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 1.0f, 1.0f);
                } else if (bruhKill) {
                    Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 1.0f, 1.0f);
                } else if (quackKill) {
                    Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 1.0f, 1.0f);
                } else if (gotchaKill) {
                    Minecraft.getMinecraft().thePlayer.playSound(gotcha.toString(), 1.0f, 1.0f);
                }
            }
        }
    }
}