package me.pinkulu.SoundMod;

import me.pinkulu.SoundMod.SoundPlayer;
import me.pinkulu.SoundMod.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.io.IOException;

public class KillToggleCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "killsound";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/killsound + name";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText(Util.replace("&cInvalid Arguments. Usage: ") + this.getCommandUsage(sender)));
            return;
        }
        if (args[0].equals("help")) {
            sender.addChatMessage(new ChatComponentText(Util.replace("&2Correct command is" + getCommandUsage(sender))));

        } else if (args[0].equals("boomer")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4boomer &2for &4Kill")));
            SoundPlayer.boomerKill = true;
            SoundPlayer.bruhKill = false;
            SoundPlayer.quackKill= false;
            SoundPlayer.gotchaKill = false;
            SoundPlayer.oofKill = false;
            Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.boomer.toString(), 1.0f, 1.0f);
                Sounds.saveConfig();

        }else if(args[0].equals("bruh")){
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4bruh &2for &4Kill")));
            SoundPlayer.boomerKill = false;
            SoundPlayer.bruhKill = true;
            SoundPlayer.quackKill= false;
            SoundPlayer.gotchaKill = false;
            SoundPlayer.oofKill = false;
            Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.bruh.toString(), 1.0f, 1.0f);
                Sounds.saveConfig();

        }else if (args[0].equals("quack")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4bquack &2for &4Kill")));
            SoundPlayer.boomerKill = false;
            SoundPlayer.bruhKill = false;
            SoundPlayer.quackKill= true;
            SoundPlayer.gotchaKill = false;
            SoundPlayer.oofKill = false;
            Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.quack.toString(), 1.0f, 1.0f);
                Sounds.saveConfig();

        }else if (args[0].equals("gotcha")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4gotcha &2for &4Kill")));
            SoundPlayer.boomerKill = false;
            SoundPlayer.bruhKill = false;
            SoundPlayer.quackKill= false;
            SoundPlayer.gotchaKill = true;
            SoundPlayer.oofKill = false;
            Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.gotcha.toString(), 1.0f, 1.0f);
                Sounds.saveConfig();

        }else if (args[0].equals("oof")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4oof &2for &4Kill")));
            SoundPlayer.boomerKill = false;
            SoundPlayer.bruhKill = false;
            SoundPlayer.quackKill= false;
            SoundPlayer.gotchaKill = false;
            SoundPlayer.oofKill = true;
            Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.oof.toString(), 1.0f, 1.0f);
                Sounds.saveConfig();
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}