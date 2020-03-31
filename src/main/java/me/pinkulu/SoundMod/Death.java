package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class Death {
    public static boolean boomerDeath = false;
    public static boolean oofDeath = true;
    public static boolean bruhDeath = false;
    public static boolean quackDeath = false;

    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        String msg = event.message.getUnformattedText();
        if (msg.startsWith("You died!")) {
            if (boomerDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.boomer), 1f, 1f);
            } else if (oofDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.oof), 1f, 1f);
            } else if (bruhDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.bruh), 1f, 1f);
            } else if (quackDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(String.valueOf(RegisterSounds.quack), 1f, 1f);
            }
        }
    }
}