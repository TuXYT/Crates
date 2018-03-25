package com.Emile2250.ezcrates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        Player player = (Player) sender;

        if(args.length == 0) {
            player.sendMessage("§7[§6Crates§7]§r Command usage:\n" +
                    "/cr add contents [name]      Adds crate content\n" +
                    "");

        }

        if (args[0].equalsIgnoreCase("addcontents")) {
        }

        return false;
    }
}
///petblock rename &b&k|&f &cHam &b&k|