package me.pinkulu.chatthings;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.*;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand extends CommandBase{


    @Override
    public String getCommandName() {
        return "chathelp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "For help.";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> commandAliases = new ArrayList<String>();
        commandAliases.add("cth");
        return commandAliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
            EntityPlayer player = (EntityPlayer) sender;
            ChatStyle style = new ChatStyle();
                style.setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ChatComponentText(Util.replace(
                        " &3Movement: " +
                                "\n &bfront, back, left, right " +
                                "\n &3Actions: " +
                                "\n &bJump, sneak, &4useitem, &bdrop" +
                                "\n &cExtras:" +
                                "\n &cCrash" +
                                "\n &3Commands: " +
                                "\n &b/chathelp(or /cth)" +
                                "\n &b/chat(keyword) <on/off>" +
                                "\n &b(example: /chatjump off(turns off keyword jump))" +
                                "\n &4More coming soon" +
                                "\n &5Mod made by:" +
                                "\n &dPinkulu"))));
            IChatComponent text = new ChatComponentText(Util.replace("&6v1.1.2&8&o(hoverable text)")).setChatStyle(style);
            player.addChatMessage(text);
        

    }
    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
