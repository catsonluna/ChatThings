package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Movement {
    //if any enabled action will execute
    private boolean left;
    private boolean forward;
    private boolean back;
    private boolean right;
    //sets the length of an action
    private int i;
    //checks if enabled
    public static boolean leftOn = true;
    public static boolean frontOn = true;
    public static boolean rightOn = true;
    public static boolean backOn = true;
    //reds the chat for keywords
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(leftOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("left")) {
                this.left = true;
            }
        }if(frontOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("front")) {
                this.forward = true;
                }
            }if(rightOn){
            if (event.message.getUnformattedText().toLowerCase().contains("right")) {
                this.right = true;
            }
        }if (backOn) {
            if (event.message.getUnformattedText().toLowerCase().contains("back")) {
                this.back = true;
            }
        }
    }
    //executes the movement to any matched keywords
    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        if (this.left && event.phase == TickEvent.Phase.END) {
            if (this.i < 4) {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(), true);
                this.i++;
            } else {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindLeft.getKeyCode(), false);
                this.left = false;
                this.i = 0;
            }
        }if(this.forward && event.phase == TickEvent.Phase.END) {
             if (this.i < 4) {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode(), true);
                this.i++;
            } else {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode(), false);
                this.forward = false;
                this.i = 0;
            }
        }if(this.right && event.phase == TickEvent.Phase.END) {
            if (this.i < 4) {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(), true);
                this.i++;
            } else {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindRight.getKeyCode(), false);
                this.right = false;
                this.i = 0;
            }
        }if (this.back && event.phase == TickEvent.Phase.END) {
            if (this.i < 4) {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode(), true);
                this.i++;
            } else {
                KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindBack.getKeyCode(), false);
                this.back = false;
                this.i = 0;
            }
        }
    }
}
