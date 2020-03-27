package me.pinkulu.chatthings;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME, acceptedMinecraftVersions = Main.acceptedMineshaftVersions)
public class Main {

     static final String MODID = "ChatThings";
     static final String VERSION = "1.1";
     static final String NAME = "ChatThings";
     static final String acceptedMineshaftVersions = "[1.8.9]";

     private Jump jump = new Jump();
     private Sneak sneak = new Sneak();
     private Drop drop = new Drop();
     private Front front = new Front();
     private UseItem useItem = new UseItem();
     private Right right = new Right();
     private Back back = new Back();
     private Left left = new Left();
     private UwU uwu = new UwU();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(jump);
        MinecraftForge.EVENT_BUS.register(sneak);
        MinecraftForge.EVENT_BUS.register(drop);
        MinecraftForge.EVENT_BUS.register(front);
        MinecraftForge.EVENT_BUS.register(back);
        MinecraftForge.EVENT_BUS.register(left);
        MinecraftForge.EVENT_BUS.register(right);
        MinecraftForge.EVENT_BUS.register(useItem);
        MinecraftForge.EVENT_BUS.register(uwu);
        ClientCommandHandler.instance.registerCommand(new HelpCommand());
        ClientCommandHandler.instance.registerCommand(new FrontToggle());
        ClientCommandHandler.instance.registerCommand(new BackToggle());
        ClientCommandHandler.instance.registerCommand(new DropToggle());
        ClientCommandHandler.instance.registerCommand(new JumpToggle());
        ClientCommandHandler.instance.registerCommand(new LeftToggle());
        ClientCommandHandler.instance.registerCommand(new SneakToggle());
        ClientCommandHandler.instance.registerCommand(new RightToggle());
        ClientCommandHandler.instance.registerCommand(new UseItemToggle());
        ClientCommandHandler.instance.registerCommand(new UwUToggle());
    }
}
