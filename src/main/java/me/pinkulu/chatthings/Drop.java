package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Drop {
    private boolean drop = false;
    private boolean last = false;

    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().toLowerCase().contains("drop")) {
            drop = true;
        }

    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {


        if (drop) {
            Minecraft.getMinecraft().thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
            drop = false;
            last = true;
        } else if (last) {
            last = false;
            Minecraft.getMinecraft().thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
        }
    }
}
