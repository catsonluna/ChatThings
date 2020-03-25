package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Jump {
    private boolean jump = false;
    private boolean last = false;

    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (event.message.getUnformattedText().toLowerCase().contains("jump")) {
            jump = true;
        }

    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {


        if (jump) {
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), true);
            jump = false;
            last = true;
        } else if (last) {
            last = false;
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), false);
        }
    }
}
