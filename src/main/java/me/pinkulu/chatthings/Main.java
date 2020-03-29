package me.pinkulu.chatthings;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {

     static final String MODID = "ChatThings";
     static final String VERSION = "1.2";
     static final String NAME = "ChatThings";

     //registers the classes in the main class
     private Movement movement = new Movement();
     private Extras extras = new Extras();
     private Actions actions = new Actions();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //registers the classes in mod
        MinecraftForge.EVENT_BUS.register(movement);
        MinecraftForge.EVENT_BUS.register(extras);
        MinecraftForge.EVENT_BUS.register(actions);
        //registers commands in mod
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new ToggleCommand());
    }
}
