package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;


public class NickCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "nicksounds";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/nicksounds <nick/reset>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        SoundPlayer soundPlayer = new SoundPlayer();
        if (args.length == 0) {
            Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.RED + "Usage: /nicksounds <nick/reset>"));
        } else if (args.length > 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.RED + "Usage: /nicksounds <nick/reset>"));
        } else {
            if (args[0].equals("reset")) {
                SoundPlayer.resetNick();
                Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "[SoundsPlayer] " + EnumChatFormatting.GREEN + "Your nick has been reset."));
            } else {
                SoundPlayer.storeNick(args[0]);
                Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "[SoundsPlayer] " + EnumChatFormatting.GREEN + "Will now looking for chat messages with the nickname '" + args[0] + "'."));
            }
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}