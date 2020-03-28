package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Crash {
    public static boolean enabled = false;
    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("crash")) {
                Minecraft.getMinecraft().crashed(new CrashReport("uwu daddy, someone crushed you ;) ops silly me i meant crashed", new Exception()));
            }
        }
    }
}
class CrashToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatcrash";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatcrash <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatcrash <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Crash is now disabled.")));
            Crash.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Crash is now enabled. Lol good luck")));
            Crash.enabled = true;
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}