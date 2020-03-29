package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Extras {
    //checks if enabled
    public static boolean crashOn = false;
    //reads the chat and if matches auto crashes the game
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(crashOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("crash")) {
                Minecraft.getMinecraft().crashed(new CrashReport("uwu daddy, someone crushed you ;) ops silly me i meant crashed", new Exception()));
            }
        }
    }
}
