package me.pinkulu.SoundMod.Commands;

import me.pinkulu.SoundMod.SoundPlayer;
import me.pinkulu.SoundMod.Sounds;
import me.pinkulu.SoundMod.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;


public class DeathToggleCommand extends CommandBase {
        @Override
        public String getCommandName() {
            return "deathsound";
        }

        @Override
        public String getCommandUsage(ICommandSender sender) {
            return "/deathsound + name";
        }

        @Override
        public void processCommand(ICommandSender sender, String[] args) throws CommandException {
            if (args.length == 0) {
                sender.addChatMessage(new ChatComponentText(Util.replace("&cInvalid Arguments. Usage: ") + this.getCommandUsage(sender)));
                return;
            }
            if (args[0].equals("help")) {
                sender.addChatMessage(new ChatComponentText(Util.replace("Correct command is " + getCommandUsage(sender))));

            } else if (args[0].equals("boomer")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4boomer &2for &4Death")));
                SoundPlayer.boomerDeath = true;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.boomer.toString(), 0.5f, 1.0f);
                Sounds.saveConfig();

            } else if (args[0].equals("quack")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4quack &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = true;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.quack.toString(), 4.0f, 1.0f);
                Sounds.saveConfig();

            } else if (args[0].equals("bruh")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4bruh &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = true;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.bruh.toString(), 3.0f, 1.0f);
                Sounds.saveConfig();

            } else if (args[0].equals("oof")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4oof &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = true;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.oof.toString(), 3.0f, 1.0f);
                Sounds.saveConfig();
            } else if (args[0].equals("disable")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4disabled All sounds for Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Sounds.saveConfig();
            } else if (args[0].equals("skeppyjsp")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4SkeppyJsp &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = true;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.skeppyjsp.toString(), 1f, 1f);
                Sounds.saveConfig();
            } else if (args[0].equals("oke")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4Oke &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = true;
                SoundPlayer.noiceDeath = false;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.okey.toString(), 2f, 1f);
                Sounds.saveConfig();
            }else if (args[0].equals("noice")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4Oke &2for &4Death")));
                SoundPlayer.boomerDeath = false;
                SoundPlayer.quackDeath = false;
                SoundPlayer.bruhDeath = false;
                SoundPlayer.oofDeath = false;
                SoundPlayer.skeppyjspDeath = false;
                SoundPlayer.okeyDeath = false;
                SoundPlayer.noiceDeath = true;
                Minecraft.getMinecraft().thePlayer.playSound(SoundPlayer.noice.toString(), 2f, 1f);
                Sounds.saveConfig();
            }
        }
        @Override
        public int getRequiredPermissionLevel() {
            return -1;
        }
}