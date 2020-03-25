package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sneak {
    private boolean sneak = false;
    private boolean last = false;

    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().toLowerCase().contains("sneak")) {
            sneak = true;
        }

    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {


        if (sneak) {
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
            sneak = false;
            last = true;
        } else if (last) {
            last = false;
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
        }
    }
}
