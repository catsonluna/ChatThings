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

public class Sneak {
    private boolean sneak;
    private int i;
    public static boolean enabled = true;


    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if (enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("sneak")) {
                this.sneak = true;
            }
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent event) {
        if (this.sneak && event.phase == TickEvent.Phase.END) {
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
class SneakToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatsneak";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatsneak <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatsneak <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Sneak is now disabled.")));
            Left.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Sneak is now enabled.")));
            Left.enabled = true;
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}