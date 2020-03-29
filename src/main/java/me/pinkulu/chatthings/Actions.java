package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Actions {
    //if any enabled action will execute
    private boolean drop = false;
    private boolean sneak = false;
    private boolean jump = false;
    //makes it so action only works once
    private boolean lastJump = false;
    private boolean lastDrop = false;
    //int so sneak can be longer(length can be controlled)
    private int i;
    //checks if its enabled
    public static boolean dropOn = true;
    public static boolean sneakOn = true;
    public static boolean jumpOn = true;


    //reads the chat and looks for keywords
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(dropOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("drop")) {
                drop = true;
            }
        }if(jumpOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("jump")) {
                jump = true;
            }
        }if (sneakOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("sneak")) {
               sneak = true;
            }
        }
    }

    //updates on ticks to execute action
    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        if (drop) {
            Minecraft.getMinecraft().thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());
            drop = false;
            lastDrop = true;
        } else if (lastDrop) {
            lastDrop = false;
            Minecraft.getMinecraft().thePlayer.dropOneItem(GuiScreen.isCtrlKeyDown());

        }if (jump) {
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), true);
            jump = false;
            lastJump = true;
        } else if (lastJump) {
            lastJump = false;
            KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode(), false);

        }if (this.sneak && event.phase == TickEvent.Phase.END) {
            if (this.i < 4) {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), true);
                this.i++;
            } else {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode(), false);
                this.sneak = false;
                this.i = 0;
            }
        }
    }
}

