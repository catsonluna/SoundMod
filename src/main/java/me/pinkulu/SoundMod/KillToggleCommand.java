package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

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
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled boomer for &4Kill")));
            Kill.boomerKill = true;
            Kill.bruhKill = false;
            Kill.quackKill= false;
            Kill.gotchaKill = false;
            Kill.oofKill = false;
        }else if (args[0].equals("quack")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled bruh for &4Kill")));
            Kill.boomerKill = false;
            Kill.bruhKill = false;
            Kill.quackKill= true;
            Kill.gotchaKill = false;
            Kill.oofKill = false;
        }else if (args[0].equals("gotcha")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled gotcha for &4Kill")));
            Kill.boomerKill = false;
            Kill.bruhKill = false;
            Kill.quackKill= false;
            Kill.gotchaKill = true;
            Kill.oofKill = false;
        }else if (args[0].equals("oof")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Enabled oof for &4Kill")));
            Kill.boomerKill = false;
            Kill.bruhKill = false;
            Kill.quackKill= false;
            Kill.gotchaKill = false;
            Kill.oofKill = true;
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}