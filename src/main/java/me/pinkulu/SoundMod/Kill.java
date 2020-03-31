package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class Kill {
    public static boolean boomerOn = true;
    public static boolean oofOn = false;
    public static boolean bruhOn = false;
    public static boolean quackOn = false;
    public static boolean gotchaOn = false;
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().toLowerCase().startsWith("You died!")) {
            if(boomerOn){
                Minecraft.getMinecraft().thePlayer.playSound(RegisterSounds.boomer.toString(), 1f, 1f);
            }else if(oofOn){
                Minecraft.getMinecraft().thePlayer.playSound(RegisterSounds.oof.toString(), 1f, 1f);
            }else if(bruhOn){
                Minecraft.getMinecraft().thePlayer.playSound(RegisterSounds.bruh.toString(), 1f, 1f);
            }else if(quackOn){
                Minecraft.getMinecraft().thePlayer.playSound(RegisterSounds.quack.toString(), 1f, 1f);
            }else if(gotchaOn){
                Minecraft.getMinecraft().thePlayer.playSound(RegisterSounds.gotcha.toString(), 1f, 1f);
            }
        }
    }
}
