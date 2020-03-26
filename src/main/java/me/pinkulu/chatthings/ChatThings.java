package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
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
     private Front Front = new Front();
     private UseItem UseItem = new UseItem();
     private Right Right = new Right();
     private Back Back = new Back();
     private Left Left = new Left();
     private Crash Crash = new Crash();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(Jump);
        MinecraftForge.EVENT_BUS.register(Sneak);
        MinecraftForge.EVENT_BUS.register(Drop);
        MinecraftForge.EVENT_BUS.register(Front);
        MinecraftForge.EVENT_BUS.register(Back);
        MinecraftForge.EVENT_BUS.register(Left);
        MinecraftForge.EVENT_BUS.register(Right);
        MinecraftForge.EVENT_BUS.register(UseItem);
        MinecraftForge.EVENT_BUS.register(Crash);
    }
}
