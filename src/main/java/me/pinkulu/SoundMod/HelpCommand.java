package me.pinkulu.SoundMod;

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
                " &3Available Kill massages: " +
                        "\n &" + (Kill.boomerKill ? "a" : "c")+ "boomer " +
                        "&" + (Kill.oofKill ? "a" : "c")+ "oof "+
                        "&" + (Kill.gotchaKill ? "a" : "c")+"gotcha "+
                        "&" + (Kill.quackKill ? "a" : "c")+"quack "+
                        "&" + (Kill.bruhKill ? "a" : "c") +"bruh"+
                        "\n &3Available death massages: " +
                        "\n &" + (Death.boomerDeath ? "a" : "c")+ "boomer " +
                        "&" + (Death.oofDeath ? "a" : "c")+ "oof "+
                        "&" + (Death.quackDeath ? "a" : "c")+"quack "+
                        "&" + (Death.bruhDeath ? "a" : "c") +"bruh"+
                        "\n &3Commands: " +
                        "\n &b/killsound + name or /deathsound + name" +
                        "\n &4More coming soon" +
                        "\n &5Mod made by:" +
                        "\n &dPinkulu" ))));
        //what shows in chat and than the hoverable text is registered
        IChatComponent text = new ChatComponentText(Util.replace( "&e " + Sounds.NAME +" " + Sounds.VERSION + "&7(hoverable text)")).setChatStyle(style);
        //ads to chat
        player.addChatMessage(text);
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
