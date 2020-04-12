package me.pinkulu.SoundMod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.*;
import java.util.ArrayList;



public class SoundPlayer {

    public static boolean boomerDeath;
    public static boolean oofDeath;
    public static boolean bruhDeath;
    public static boolean quackDeath;
    public static boolean skeppyjspDeath;
    public static boolean okeyDeath;
    public static boolean noiceDeath;

    public static boolean boomerKill;
    public static boolean oofKill;
    public static boolean bruhKill;
    public static boolean quackKill;
    public static boolean gotchaKill;
    public static boolean okeyKill;
    public static boolean noiceKill;
    
    public static boolean knockbackHit;


    private String nickData;
    private String msg;
    private ArrayList<String> deathMessages = new ArrayList<String>();

    public static ResourceLocation boomer = new ResourceLocation("soundsmodutil", "boomer");
    public static ResourceLocation oof = new ResourceLocation("soundsmodutil", "oof");
    public static ResourceLocation bruh = new ResourceLocation("soundsmodutil", "bruh");
    public static ResourceLocation quack = new ResourceLocation("soundsmodutil", "quack");
    public static ResourceLocation gotcha = new ResourceLocation("soundsmodutil", "gotcha");
    public static ResourceLocation skeppyjsp = new ResourceLocation("soundsmodutil", "skeppyjsp");
    public static ResourceLocation okey = new ResourceLocation("soundsmodutil", "okey");
    public static ResourceLocation noice = new ResourceLocation("soundsmodutil", "noice");




    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent e) {
        String msg = e.message.getUnformattedText();
        ArrayList<String> formattedDeathMessages = new ArrayList<String>();
        ArrayList<String> nickedFormattedDeathMessages = new ArrayList<String>();

        for(String m : deathMessages) {
            formattedDeathMessages.add(m.replace("PLAYER", Minecraft.getMinecraft().thePlayer.getName()));
        }
        if(getNick() != "null") {
            for(String m : deathMessages) {
                nickedFormattedDeathMessages.add(m.replace("PLAYER", getNick()));
            }
        }
        if (msg.startsWith("You died")) {
            if (boomerDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 0.5f, 1.0f);
            } else if (oofDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 3.0f, 1.0f);
            } else if (bruhDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 3.0f, 1.0f);
            } else if (quackDeath) {
                Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 4.0f, 1.0f);
            } else if (skeppyjspDeath){
                Minecraft.getMinecraft().thePlayer.playSound(skeppyjsp.toString(), 1.0f, 1.0f);
            }else if (okeyDeath){
                Minecraft.getMinecraft().thePlayer.playSound(okey.toString(), 2.0f, 1.0f);
            }
            else if (noiceDeath){
                Minecraft.getMinecraft().thePlayer.playSound(noice.toString(), 2.0f, 1.0f);
            }
        }
        if (msg.startsWith("+") && msg.contains("Kill") && msg.contains("coins")) {
            if (boomerKill) {
                Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 0.5f, 1.0f);
            } else if (oofKill) {
                Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 3.0f, 1.0f);
            } else if (bruhKill) {
                Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 3.0f, 1.0f);
            } else if (quackKill) {
                Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 4.0f, 1.0f);
            } else if (gotchaKill) {
                Minecraft.getMinecraft().thePlayer.playSound(gotcha.toString(), 2.5f, 1.0f);
            }else if (okeyKill){
                Minecraft.getMinecraft().thePlayer.playSound(okey.toString(), 2.0f, 1.0f);
            }else if (noiceKill){
                Minecraft.getMinecraft().thePlayer.playSound(noice.toString(), 2.0f, 1.0f);
            }

        }


        //everything below is stolen from @refractions:oof mod v1.2 so check it out
        if(msg.equals("You have finished setting up your nickname!")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "[SoundsMod] " + EnumChatFormatting.GREEN + "Don't forget to /soundsnick with your current nickname in order for the oof mod to work properly."));
        }

        if(msg.equals("Your nick has been reset!")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.LIGHT_PURPLE + "[SoundsMod] " + EnumChatFormatting.GREEN + "Automatically detected /nick reset and reset your SoundsMod nick data."));
            resetNick();
        }
        if(getNick() != "null") {
            for(String m : deathMessages) {
                nickedFormattedDeathMessages.add(m.replace("PLAYER", getNick()));
            }
        }
        String[] compare = msg.split(" ", 2);
        if(compare.length > 1) {
            for(String m : formattedDeathMessages) {
                if(compare[1].equals(m)) {
                    if (boomerKill) {
                        Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 0.5f, 1.0f);
                    } else if (oofKill) {
                        Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 3.0f, 1.0f);
                    } else if (bruhKill) {
                        Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 3.0f, 1.0f);
                    } else if (quackKill) {
                        Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 4.0f, 1.0f);
                    } else if (gotchaKill) {
                        Minecraft.getMinecraft().thePlayer.playSound(gotcha.toString(), 2.5f, 1.0f);
                    }else if (okeyKill){
                        Minecraft.getMinecraft().thePlayer.playSound(okey.toString(), 2.0f, 1.0f);
                    }else if (noiceKill){
                        Minecraft.getMinecraft().thePlayer.playSound(noice.toString(), 2.0f, 1.0f);
                    }
                }
            }
            if(getNick() != "null") {
                for(String m : nickedFormattedDeathMessages) {
                    if(compare[1].equals(m)) {
                        if (boomerKill) {
                            Minecraft.getMinecraft().thePlayer.playSound(boomer.toString(), 0.5f, 1.0f);
                        } else if (oofKill) {
                            Minecraft.getMinecraft().thePlayer.playSound(oof.toString(), 3.0f, 1.0f);
                        } else if (bruhKill) {
                            Minecraft.getMinecraft().thePlayer.playSound(bruh.toString(), 3.0f, 1.0f);
                        } else if (quackKill) {
                            Minecraft.getMinecraft().thePlayer.playSound(quack.toString(), 4.0f, 1.0f);
                        } else if (gotchaKill) {
                            Minecraft.getMinecraft().thePlayer.playSound(gotcha.toString(), 3.0f, 1.0f);
                        }else if (okeyKill){
                            Minecraft.getMinecraft().thePlayer.playSound(okey.toString(), 2.0f, 1.0f);
                        }else if (noiceKill){
                            Minecraft.getMinecraft().thePlayer.playSound(noice.toString(), 2.0f, 1.0f);
                        }
                    }
                }
            }
        }
    }
    public static void storeNick(String nick) {
        final File nickData = new File(Minecraft.getMinecraft().mcDataDir + File.separator + "SoundsMod", "nickData.txt");
        try {
            if (!nickData.exists()) {
                nickData.getParentFile().mkdirs();
                nickData.createNewFile();
            }
            final BufferedWriter writer = new BufferedWriter(new FileWriter(nickData));
            writer.write(nick);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void resetNick() {
        final File nickData = new File(Minecraft.getMinecraft().mcDataDir + File.separator + "SoundsMod", "nickData.txt");
        try {
            if (!nickData.exists()) {
                nickData.getParentFile().mkdirs();
                nickData.createNewFile();
            }
            final BufferedWriter writer = new BufferedWriter(new FileWriter(nickData));
            writer.write("null");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNick() {
        try {
            final File file = new File(Minecraft.getMinecraft().mcDataDir + File.separator + "SoundsMod", "nickData.txt");
            if (!file.exists()) {
                return "null";
            }
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            int i = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                switch (++i) {
                    case 1: {
                        nickData = line;
                    }
                }
            }
            reader.close();
            return nickData;
        }
        catch (Throwable e) {
            e.printStackTrace();
            return "null";
        }
    }
    public void populateDeathMessages() {
        deathMessages.add("was slain by PLAYER");
        deathMessages.add("was slain by PLAYER FINAL KILL!");
        deathMessages.add("was shot by PLAYER");
        deathMessages.add("was shot by PLAYER FINAL KILL!");
        deathMessages.add("was thrown into the void by PLAYER");
        deathMessages.add("was thrown into the void by PLAYER FINAL KILL!");
        deathMessages.add("was doomed to fall by PLAYER");
        deathMessages.add("was doomed to fall by PLAYER FINAL KILL!");
        deathMessages.add("was toasted by PLAYER");
        deathMessages.add("was toasted by PLAYER FINAL KILL!");
        deathMessages.add("was killed by PLAYER");
        deathMessages.add("was killed by PLAYER FINAL KILL!");
        deathMessages.add("was bomberman'd by PLAYER");
        deathMessages.add("was bomberman'd by PLAYER FINAL KILL!");
        deathMessages.add("was Bomberman'd by PLAYER");
        deathMessages.add("was Bomberman'd by PLAYER FINAL KILL!");
        deathMessages.add("was thrown off a cliff by PLAYER");
        deathMessages.add("was thrown off a cliff by PLAYER FINAL KILL!");
        deathMessages.add("was shot and killed by PLAYER");
        deathMessages.add("was shot and killed by PLAYER FINAL KILL!");
        deathMessages.add("was snowballed to death by PLAYER");
        deathMessages.add("was snowballed to death by PLAYER FINAL KILL!");
        deathMessages.add("was killed with a potion by PLAYER");
        deathMessages.add("was killed with a potion by PLAYER FINAL KILL!");
        deathMessages.add("was killed with an explosion by PLAYER");
        deathMessages.add("was killed with an explosion by PLAYER FINAL KILL!");
        deathMessages.add("was killed with magic by PLAYER");
        deathMessages.add("was killed with magic by PLAYER FINAL KILL!");
        deathMessages.add("was filled full of lead by PLAYER");
        deathMessages.add("was filled full of lead by PLAYER FINAL KILL!");
        deathMessages.add("was iced by PLAYER");
        deathMessages.add("was iced by PLAYER FINAL KILL!");
        deathMessages.add("met their end by PLAYER");
        deathMessages.add("met their end by PLAYER FINAL KILL!");
        deathMessages.add("lost a drinking contest with PLAYER");
        deathMessages.add("lost a drinking contest with PLAYER FINAL KILL!");
        deathMessages.add("was killed with dynamite by PLAYER");
        deathMessages.add("was killed with dynamite by PLAYER FINAL KILL!");
        deathMessages.add("lost the draw to PLAYER");
        deathMessages.add("lost the draw to PLAYER FINAL KILL!");
        deathMessages.add("was struck down by PLAYER");
        deathMessages.add("was struck down by PLAYER FINAL KILL!");
        deathMessages.add("was turned to dust by PLAYER");
        deathMessages.add("was turned to dust by PLAYER FINAL KILL!");
        deathMessages.add("was turned to ash by PLAYER");
        deathMessages.add("was turned to ash by PLAYER FINAL KILL!");
        deathMessages.add("was melted by PLAYER");
        deathMessages.add("was melted by PLAYER FINAL KILL!");
        deathMessages.add("was incinerated by PLAYER");
        deathMessages.add("was incinerated by PLAYER FINAL KILL!");
        deathMessages.add("was vaporized by PLAYER");
        deathMessages.add("was vaporized by PLAYER FINAL KILL!");
        deathMessages.add("was struck with Cupid's arrow by PLAYER");
        deathMessages.add("was struck with Cupid's arrow by PLAYER FINAL KILL!");
        deathMessages.add("was given the cold shoulder by PLAYER");
        deathMessages.add("was given the cold shoulder by PLAYER FINAL KILL!");
        deathMessages.add("was hugged too hard by PLAYER");
        deathMessages.add("was hugged too hard by PLAYER FINAL KILL!");
        deathMessages.add("drank a love potion from PLAYER");
        deathMessages.add("drank a love potion from PLAYER FINAL KILL!");
        deathMessages.add("was hit by a love bomb from PLAYER");
        deathMessages.add("was hit by a love bomb from PLAYER FINAL KILL!");
        deathMessages.add("was no match for PLAYER");
        deathMessages.add("was no match for PLAYER FINAL KILL!");
        deathMessages.add("was smote from afar by PLAYER");
        deathMessages.add("was smote from afar by PLAYER FINAL KILL!");
        deathMessages.add("was justly ended by PLAYER");
        deathMessages.add("was justly ended by PLAYER FINAL KILL!");
        deathMessages.add("was purified by PLAYER");
        deathMessages.add("was purified by PLAYER FINAL KILL!");
        deathMessages.add("was killed with holy water by PLAYER");
        deathMessages.add("was killed with holy water by PLAYER FINAL KILL!");
        deathMessages.add("was dealt vengeful justice by PLAYER");
        deathMessages.add("was dealt vengeful justice by PLAYER FINAL KILL!");
        deathMessages.add("was returned to dust by PLAYER");
        deathMessages.add("was returned to dust by PLAYER FINAL KILL!");
        deathMessages.add("be shot and killed by PLAYER");
        deathMessages.add("be shot and killed by PLAYER FINAL KILL!");
        deathMessages.add("be snowballed to death by PLAYER");
        deathMessages.add("be snowballed to death by PLAYER FINAL KILL!");
        deathMessages.add("be sent to Davy Jones' locker by PLAYER");
        deathMessages.add("be sent to Davy Jones' locker by PLAYER FINAL KILL!");
        deathMessages.add("be killed with rum by PLAYER");
        deathMessages.add("be killed with rum by PLAYER FINAL KILL!");
        deathMessages.add("be shot with cannon by PLAYER");
        deathMessages.add("be shot with cannon by PLAYER FINAL KILL!");
        deathMessages.add("be killed with magic by PLAYER");
        deathMessages.add("be killed with magic by PLAYER FINAL KILL!");
        deathMessages.add("was glazed in BBQ sauce by PLAYER");
        deathMessages.add("was glazed in BBQ sauce by PLAYER FINAL KILL!");
        deathMessages.add("was sprinkled with chilli powder by PLAYER");
        deathMessages.add("was sprinkled with chilli powder by PLAYER FINAL KILL!");
        deathMessages.add("was sprinkled with chili powder by PLAYER");
        deathMessages.add("was sprinkled with chili powder by PLAYER FINAL KILL!");
        deathMessages.add("was sliced up by PLAYER");
        deathMessages.add("was sliced up by PLAYER FINAL KILL!");
        deathMessages.add("was overcooked by PLAYER");
        deathMessages.add("was overcooked by PLAYER FINAL KILL!");
        deathMessages.add("was deep fried by PLAYER");
        deathMessages.add("was deep fried by PLAYER FINAL KILL!");
        deathMessages.add("was boiled by PLAYER");
        deathMessages.add("was boiled by PLAYER FINAL KILL!");
        deathMessages.add("was spooked by PLAYER");
        deathMessages.add("was spooked by PLAYER FINAL KILL!");
        deathMessages.add("was spooked off the map by PLAYER");
        deathMessages.add("was spooked off the map by PLAYER FINAL KILL!");
        deathMessages.add("was totally spooked by PLAYER");
        deathMessages.add("was totally spooked by PLAYER FINAL KILL!");
        deathMessages.add("was remotely spooked by PLAYER");
        deathMessages.add("was remotely spooked by PLAYER FINAL KILL!");
        deathMessages.add("was slain by PLAYER.");
        deathMessages.add("was slain by PLAYER. FINAL KILL!");
        deathMessages.add("was shot by PLAYER.");
        deathMessages.add("was shot by PLAYER. FINAL KILL!");
        deathMessages.add("was thrown into the void by PLAYER.");
        deathMessages.add("was thrown into the void by PLAYER. FINAL KILL!");
        deathMessages.add("was doomed to fall by PLAYER.");
        deathMessages.add("was doomed to fall by PLAYER. FINAL KILL!");
        deathMessages.add("was toasted by PLAYER.");
        deathMessages.add("was toasted by PLAYER. FINAL KILL!");
        deathMessages.add("was killed by PLAYER.");
        deathMessages.add("was killed by PLAYER. FINAL KILL!");
        deathMessages.add("was bomberman'd by PLAYER.");
        deathMessages.add("was bomberman'd by PLAYER. FINAL KILL!");
        deathMessages.add("was Bomberman'd by PLAYER.");
        deathMessages.add("was Bomberman'd by PLAYER. FINAL KILL!");
        deathMessages.add("was thrown off a cliff by PLAYER.");
        deathMessages.add("was thrown off a cliff by PLAYER. FINAL KILL!");
        deathMessages.add("was shot and killed by PLAYER.");
        deathMessages.add("was shot and killed by PLAYER. FINAL KILL!");
        deathMessages.add("was snowballed to death by PLAYER.");
        deathMessages.add("was snowballed to death by PLAYER. FINAL KILL!");
        deathMessages.add("was killed with a potion by PLAYER.");
        deathMessages.add("was killed with a potion by PLAYER. FINAL KILL!");
        deathMessages.add("was killed with an explosion by PLAYER.");
        deathMessages.add("was killed with an explosion by PLAYER. FINAL KILL!");
        deathMessages.add("was killed with magic by PLAYER.");
        deathMessages.add("was killed with magic by PLAYER. FINAL KILL!");
        deathMessages.add("was filled full of lead by PLAYER.");
        deathMessages.add("was filled full of lead by PLAYER. FINAL KILL!");
        deathMessages.add("was iced by PLAYER.");
        deathMessages.add("was iced by PLAYER. FINAL KILL!");
        deathMessages.add("met their end by PLAYER.");
        deathMessages.add("met their end by PLAYER. FINAL KILL!");
        deathMessages.add("lost a drinking contest with PLAYER.");
        deathMessages.add("lost a drinking contest with PLAYER. FINAL KILL!");
        deathMessages.add("was killed with dynamite by PLAYER.");
        deathMessages.add("was killed with dynamite by PLAYER. FINAL KILL!");
        deathMessages.add("lost the draw to PLAYER.");
        deathMessages.add("lost the draw to PLAYER. FINAL KILL!");
        deathMessages.add("was struck down by PLAYER.");
        deathMessages.add("was struck down by PLAYER. FINAL KILL!");
        deathMessages.add("was turned to dust by PLAYER.");
        deathMessages.add("was turned to dust by PLAYER. FINAL KILL!");
        deathMessages.add("was turned to ash by PLAYER.");
        deathMessages.add("was turned to ash by PLAYER. FINAL KILL!");
        deathMessages.add("was melted by PLAYER.");
        deathMessages.add("was melted by PLAYER. FINAL KILL!");
        deathMessages.add("was incinerated by PLAYER.");
        deathMessages.add("was incinerated by PLAYER. FINAL KILL!");
        deathMessages.add("was vaporized by PLAYER.");
        deathMessages.add("was vaporized by PLAYER. FINAL KILL!");
        deathMessages.add("was struck with Cupid's arrow by PLAYER.");
        deathMessages.add("was struck with Cupid's arrow by PLAYER. FINAL KILL!");
        deathMessages.add("was given the cold shoulder by PLAYER.");
        deathMessages.add("was given the cold shoulder by PLAYER. FINAL KILL!");
        deathMessages.add("was hugged too hard by PLAYER.");
        deathMessages.add("was hugged too hard by PLAYER. FINAL KILL!");
        deathMessages.add("drank a love potion from PLAYER.");
        deathMessages.add("drank a love potion from PLAYER. FINAL KILL!");
        deathMessages.add("was hit by a love bomb from PLAYER.");
        deathMessages.add("was hit by a love bomb from PLAYER. FINAL KILL!");
        deathMessages.add("was no match for PLAYER.");
        deathMessages.add("was no match for PLAYER. FINAL KILL!");
        deathMessages.add("was smote from afar by PLAYER.");
        deathMessages.add("was smote from afar by PLAYER. FINAL KILL!");
        deathMessages.add("was justly ended by PLAYER.");
        deathMessages.add("was justly ended by PLAYER. FINAL KILL!");
        deathMessages.add("was purified by PLAYER.");
        deathMessages.add("was purified by PLAYER. FINAL KILL!");
        deathMessages.add("was killed with holy water by PLAYER.");
        deathMessages.add("was killed with holy water by PLAYER. FINAL KILL!");
        deathMessages.add("was dealt vengeful justice by PLAYER.");
        deathMessages.add("was dealt vengeful justice by PLAYER. FINAL KILL!");
        deathMessages.add("was returned to dust by PLAYER.");
        deathMessages.add("was returned to dust by PLAYER. FINAL KILL!");
        deathMessages.add("be shot and killed by PLAYER.");
        deathMessages.add("be shot and killed by PLAYER. FINAL KILL!");
        deathMessages.add("be snowballed to death by PLAYER.");
        deathMessages.add("be snowballed to death by PLAYER. FINAL KILL!");
        deathMessages.add("be sent to Davy Jones' locker by PLAYER.");
        deathMessages.add("be sent to Davy Jones' locker by PLAYER. FINAL KILL!");
        deathMessages.add("be killed with rum by PLAYER.");
        deathMessages.add("be killed with rum by PLAYER. FINAL KILL!");
        deathMessages.add("be shot with cannon by PLAYER.");
        deathMessages.add("be shot with cannon by PLAYER. FINAL KILL!");
        deathMessages.add("be killed with magic by PLAYER.");
        deathMessages.add("be killed with magic by PLAYER. FINAL KILL!");
        deathMessages.add("was glazed in BBQ sauce by PLAYER.");
        deathMessages.add("was glazed in BBQ sauce by PLAYER. FINAL KILL!");
        deathMessages.add("was sprinkled with chilli powder by PLAYER.");
        deathMessages.add("was sprinkled with chilli powder by PLAYER. FINAL KILL!");
        deathMessages.add("was sprinkled with chili powder by PLAYER.");
        deathMessages.add("was sprinkled with chili powder by PLAYER. FINAL KILL!");
        deathMessages.add("was sliced up by PLAYER.");
        deathMessages.add("was sliced up by PLAYER. FINAL KILL!");
        deathMessages.add("was overcooked by PLAYER.");
        deathMessages.add("was overcooked by PLAYER. FINAL KILL!");
        deathMessages.add("was deep fried by PLAYER.");
        deathMessages.add("was deep fried by PLAYER. FINAL KILL!");
        deathMessages.add("was boiled by PLAYER.");
        deathMessages.add("was boiled by PLAYER. FINAL KILL!");
        deathMessages.add("was spooked by PLAYER.");
        deathMessages.add("was spooked by PLAYER. FINAL KILL!");
        deathMessages.add("was spooked off the map by PLAYER.");
        deathMessages.add("was spooked off the map by PLAYER. FINAL KILL!");
        deathMessages.add("was totally spooked by PLAYER.");
        deathMessages.add("was totally spooked by PLAYER. FINAL KILL!");
        deathMessages.add("was remotely spooked by PLAYER.");
        deathMessages.add("was remotely spooked by PLAYER. FINAL KILL!");
    }
}