package me.pinkulu.chatthings;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Commands implements ICommand {


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
        return commandAliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) sender;
            player.addChatMessage( new ChatComponentText("UwU"));
        }
        

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
}
