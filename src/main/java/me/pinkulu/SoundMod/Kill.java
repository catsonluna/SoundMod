package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class Kill {
    public static boolean boomerKill = true;
    public static boolean oofKill = false;
    public static boolean bruhKill = false;
    public static boolean quackKill = false;
    public static boolean gotchaKill = false;

    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (msg.startsWith("+") && msg.contains("Kill") && msg.contains("coins")) {
            if(boomerKill){
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.boomer), 1f, 1f);
            }else if(oofKill){
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.oof), 1f, 1f);
            }else if(bruhKill){
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.bruh), 1f, 1f);
            }else if(quackKill){
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.quack), 1f, 1f);
            }else if(gotchaKill){
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.gotcha), 1f, 1f);
            }
        }
    }
}



