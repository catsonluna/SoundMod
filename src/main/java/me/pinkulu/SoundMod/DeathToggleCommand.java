package me.pinkulu.SoundMod;

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
                sender.addChatMessage(new ChatComponentText(Util.replace("Correct command is "+ getCommandUsage(sender))));
            } else if (args[0].equals("boomer")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4boomer &2for &4Death")));
                Death.boomerDeath = true;
                Death.quackDeath = false;
                Death.bruhDeath = false;
                Death.oofDeath = false;
            }else if (args[0].equals("quack")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4quack &2for &4Death")));
                Death.boomerDeath = false;
                Death.quackDeath = true;
                Death.bruhDeath = false;
                Death.oofDeath = false;
            }else if (args[0].equals("bruh")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4bruh &2for &4Death")));
                Death.boomerDeath = false;
                Death.quackDeath = false;
                Death.bruhDeath = true;
                Death.oofDeath = false;
            }else if (args[0].equals("oof")) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled &4oof &2for &4Death")));
                Death.boomerDeath = false;
                Death.quackDeath = false;
                Death.bruhDeath = false;
                Death.oofDeath = true;
            }
        }

        @Override
        public int getRequiredPermissionLevel() {
            return -1;
        }
}