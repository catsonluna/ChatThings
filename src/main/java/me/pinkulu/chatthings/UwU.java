package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UwU {
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().toLowerCase().contains("uwu")) {
            Minecraft.getMinecraft().ingameGUI.displayTitle(Util.replace("&dUwU"), Util.replace("&5Senpie"), 3, 8, 3);

        }
    }
}
