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
        return "chatHelp";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "For help.";
    }

    @Override
    public List<String> getCommandAliases() {
        List<String> commandAliases = new ArrayList<String>();
        commandAliases.add("chatTHelp");
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
                            "\n &bJump, sneak, useitem, drop" +
                            "\n &3Extras:" +
                            "\n &dUwU" +
                            "\n &3Commands: " +
                            "\n &b/chatHelp(chatTHelp, cth)" +
                            "\n &b/chat(keyword) <on/off>" +
                            "\n &b(example: /chatjump off(turns off keyword jump))"+
                            "\n &4More coming soon" +
                            "\n &5Mod made by:" +
                            "\n &dPinkulu"))));
            IChatComponent text = new ChatComponentText(Util.replace("&6v1.1&8&o(hoverable text)")).setChatStyle(style);
            player.addChatMessage(text);
        

    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
