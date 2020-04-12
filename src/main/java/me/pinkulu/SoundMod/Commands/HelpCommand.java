package me.pinkulu.SoundMod.Commands;

import me.pinkulu.SoundMod.SoundPlayer;
import me.pinkulu.SoundMod.Sounds;
import me.pinkulu.SoundMod.Util;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public class HelpCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "soundshelp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = (EntityPlayer) sender;
        ChatStyle style = new ChatStyle();
        //hoverable text
        style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(Util.replace(
                " &3Available Kill sounds: " +
                        "\n &" + (SoundPlayer.boomerKill ? "a" : "c")+ "boomer " +
                        "&" + (SoundPlayer.oofKill ? "a" : "c")+ "oof "+
                        "&" + (SoundPlayer.gotchaKill ? "a" : "c")+"gotcha "+
                        "&" + (SoundPlayer.quackKill ? "a" : "c")+"quack "+
                        "&" + (SoundPlayer.bruhKill ? "a" : "c") +"bruh "+
                        "&" + (SoundPlayer.okeyKill ? "a" : "c") +"oke "+
                        "&" + (SoundPlayer.noiceKill ? "a" : "c") +"noice "+
                        "\n &3Available Death sounds: " +
                        "\n &"+(SoundPlayer.boomerDeath ? "a" : "c")+ "boomer " +
                        "&" + (SoundPlayer.oofDeath ? "a" : "c")+ "oof "+
                        "&" + (SoundPlayer.quackDeath ? "a" : "c")+"quack "+
                        "&" + (SoundPlayer.bruhDeath ? "a" : "c") +"bruh " +
                        "&" + (SoundPlayer.okeyDeath ? "a" : "c") +"oke "+
                        "&" + (SoundPlayer.skeppyjspDeath ? "a" : "c") +"skeppyjsp " +
                        "&" + (SoundPlayer.noiceDeath ? "a" : "c") +"noice "+
                        "\n &3Commands: " +
                        "\n &b/killsound + name or /deathsound + name" +
                        "\n &b/nicksounds + <name/reset> which is for mvp++'s if you want this mod to work in bedwars" +
                        "\n &bexample: /nicksounds pinkulu(set this as your nicked nick)" +
                        "\n &bor /nicksounds reset(do this if you change it back to your normal name)" +
                        "\n &4More coming soon" +
                        "\n &5Mod made by:" +
                        "\n &dPinkulu" ))));
        //what shows in chat and than the hoverable text is registered
        IChatComponent text = new ChatComponentText(Util.replace( "&e " + Sounds.NAME +" " + Sounds.VERSION + " &7(hoverable text)")).setChatStyle(style);
        //ads to chat
        player.addChatMessage(text);
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
