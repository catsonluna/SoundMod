package me.pinkulu.SoundMod;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Mod(modid = Sounds.MODID, version = Sounds.VERSION, name = Sounds.NAME)
public class Sounds {

    static final String MODID = "soundsmod";
    public static final String VERSION = "1.1";
    public static final String NAME = "SoundsMod";

    private SoundPlayer soundplayer = new SoundPlayer();


    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(soundplayer);
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new KillToggleCommand());
        ClientCommandHandler.instance.registerCommand(new DeathToggleCommand());
        ClientCommandHandler.instance.registerCommand(new NickCommand());
        loadConfig();

    }

    public static void saveConfig(){
        try {
            File file = new File("SoundsMod", "config.json");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            JsonWriter writer = new JsonWriter(new FileWriter(file, false));
            writeJson(writer);
            writer.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void loadConfig() {
        try {
            File file = new File("SoundsMod", "config.json");
            if(file.exists())
                readJson(file);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public void readJson(File file) throws Throwable{
        JsonParser parser = new JsonParser();
        JsonObject json  = parser.parse(new FileReader(file)).getAsJsonObject();
        json = json.getAsJsonObject("Sounds");

        SoundPlayer.oofKill = json.get("oofKill").getAsBoolean();
        SoundPlayer.oofDeath = json.get("oofDeath").getAsBoolean();

        SoundPlayer.boomerKill = json.get("boomerKill").getAsBoolean();
        SoundPlayer.boomerDeath = json.get("boomerDeath").getAsBoolean();

        SoundPlayer.bruhKill = json.get("bruhKill").getAsBoolean();
        SoundPlayer.bruhDeath = json.get("bruhDeath").getAsBoolean();

        SoundPlayer.quackKill = json.get("quackKill").getAsBoolean();
        SoundPlayer.quackDeath = json.get("quackDeath").getAsBoolean();

        SoundPlayer.gotchaKill = json.get("gotchaKill").getAsBoolean();
    }
    public static void writeJson(JsonWriter writer) throws IOException {
        writer.setIndent(" "); // this enabled pretty print
        writer.beginObject();
        writer.name("Sounds");
        writer.beginObject();

        writer.name("oofKill").value(SoundPlayer.oofKill);
        writer.name("oofDeath").value(SoundPlayer.oofDeath);

        writer.name("boomerKill").value(SoundPlayer.boomerKill);
        writer.name("boomerDeath").value(SoundPlayer.boomerDeath);

        writer.name("bruhKill").value(SoundPlayer.bruhKill);
        writer.name("bruhDeath").value(SoundPlayer.bruhDeath);

        writer.name("quackKill").value(SoundPlayer.quackKill);
        writer.name("quackDeath").value(SoundPlayer.quackDeath);

        writer.name("gotchaKill").value(SoundPlayer.gotchaKill);

        writer.endObject();
        writer.endObject();
    }
}
