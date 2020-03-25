package me.pinkulu.chatthings;

import me.pinkulu.chatthings.Jump;
import me.pinkulu.chatthings.Sneak;
import me.pinkulu.chatthings.Drop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = ChatThings.MODID, version = ChatThings.VERSION, name = ChatThings.NAME, acceptedMinecraftVersions = ChatThings.acceptedMineshaftVersions)
public class ChatThings {

     static final String MODID = "ChatThings";
     static final String VERSION = "1.0 - snapshot";
     static final String NAME = "ChatThings";
     static final String acceptedMineshaftVersions = "[1.8.9]";
     private Jump Jump = new Jump();
     private Sneak Sneak = new Sneak();
     private Drop Drop = new Drop();
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(Jump);
        MinecraftForge.EVENT_BUS.register(Sneak);
        MinecraftForge.EVENT_BUS.register(Drop);
    }
//discord push test
}
