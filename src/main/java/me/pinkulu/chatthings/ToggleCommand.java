package me.pinkulu.chatthings;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class ToggleCommand extends CommandBase {
    //the first thing after /
    @Override
    public String getCommandName() {
        return "chattoggle";
    }
    //commands usage
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/chattoggle <keyword> <on/off>";
    }

    //what happens when you execute
    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        {
            //if nothing comes after argument (example /chattoggle (and nothing here)) will show this msg
            if (args.length == 0) {
                sender.addChatMessage(new ChatComponentText(Util.replace("&cInvalid Arguments. Usage: ") + this.getCommandUsage(sender)));
                return;
            }
            //if /chattoggle help is run
            if (args[0].equals("help")) {
                sender.addChatMessage(new ChatComponentText(Util.replace("Correct command is /chathelp or /cth")));
                //and all the rest that are like "args[0].equals("keyword")" is the 2nd word(example: /chattoggle jump off) the ones that are like "args[1].equalsIgnoreCase("off/on")" is the 3rd word
            } else if (args[0].equals("jump")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Jump is now disabled.")));
                    Actions.jumpOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Jump is now enabled.")));
                    Actions.jumpOn = true;
                }
            }else if (args[0].equals("sneak")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Sneak is now disabled.")));
                    Actions.sneakOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Sneak is now enabled.")));
                    Actions.sneakOn = true;
                }
            }else if (args[0].equals("drop")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Drop is now disabled.")));
                    Actions.dropOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Drop is now enabled.")));
                    Actions.dropOn = true;
                }
            }else if (args[0].equals("front")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Front is now disabled.")));
                    Movement.frontOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Front is now enabled.")));
                    Movement.frontOn = true;
                }
            }else if (args[0].equals("back")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Back is now disabled.")));
                    Movement.backOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Back is now enabled.")));
                    Movement.backOn = true;
                }
            }else if (args[0].equals("left")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Left is now disabled.")));
                    Movement.leftOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Left is now enabled.")));
                    Movement.leftOn = true;
                }
            }else if (args[0].equals("right")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Right is now disabled.")));
                    Movement.rightOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Right is now enabled.")));
                    Movement.rightOn = true;
                }
            }else if (args[0].equals("crash")){
                if (args[1].equalsIgnoreCase("off")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&2Crash is now disabled.")));
                    Extras.crashOn = false;
                } else if (args[1].equalsIgnoreCase("on")) {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(Util.replace("&4Crash is now enabled.")));
                    Extras.crashOn = true;
                }
            }
        }
    }
    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
