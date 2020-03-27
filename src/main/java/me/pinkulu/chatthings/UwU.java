package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UwU {
    public static boolean enabled = true;
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("uwu")) {
                Minecraft.getMinecraft().ingameGUI.displayTitle(Util.replace("&dUwU"), Util.replace("&5Senpie"), 3, 8, 3);
            }
        }
    }
}
class UwUToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatuwu";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatuwu <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatuwu <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4UwU is now disabled.")));
            UwU.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2UwU is now enabled.")));
            UwU.enabled = true;
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}