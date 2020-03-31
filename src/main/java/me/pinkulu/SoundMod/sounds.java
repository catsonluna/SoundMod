package me.pinkulu.SoundMod;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Sounds.MODID, version = Sounds.VERSION, name = Sounds.NAME)
public class Sounds {

    static final String MODID = "soundsmod";
    static final String VERSION = "1.0";
    static final String NAME = "SoundsMod";

    private Kill kill = new Kill();
    private Death death = new Death();
    private RegisterSounds registerSounds = new RegisterSounds();

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(kill);
        MinecraftForge.EVENT_BUS.register(death);
        MinecraftForge.EVENT_BUS.register(registerSounds);
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new KillToggleCommand());
        ClientCommandHandler.instance.registerCommand(new DeathToggleCommand());
    }

}
