package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Left {
    private boolean left;
    private int i;
    public static boolean enabled = true;
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("left")) {
                this.left = true;
            }
        }
    }

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
        }
    }
}
class LeftToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatleft";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatleft <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatleft <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Left is now disabled.")));
            Left.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Left is now enabled.")));
            Left.enabled = true;
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}