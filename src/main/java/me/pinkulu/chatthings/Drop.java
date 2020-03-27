package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Drop {
    private boolean drop = false;
    private boolean last = false;
    public static boolean enabled = true;

    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("drop")) {
                drop = true;
            }
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
class DropToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatdrop";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatdrop <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatdrop <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Drop is now disabled.")));
            Drop.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Drop is now enabled.")));
            Drop.enabled = true;
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}