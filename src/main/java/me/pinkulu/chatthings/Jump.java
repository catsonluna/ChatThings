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



public class Jump {
    private boolean jump = false;
    private boolean last = false;
    public static boolean enabled = true;

    @SubscribeEvent
    public void ChatReceivedEvent(ClientChatReceivedEvent event) {
        if(enabled) {
            if (event.message.getUnformattedText().toLowerCase().contains("jump")) {
                jump = true;
            }
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
class JumpToggle extends CommandBase {

    @Override
    public String getCommandName() {
        return "chatjump";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chatjump <on/off>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /chatjump <on/off>."));
        } else if (args[0].equalsIgnoreCase("off")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Jump is now disabled.")));
            Jump.enabled = false;
        } else if (args[0].equalsIgnoreCase("on")) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Jump is now enabled.")));
            Jump.enabled = true;
        }

    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}