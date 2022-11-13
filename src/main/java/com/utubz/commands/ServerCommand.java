package com.utubz.commands;

import com.utubz.ranking.Ranks;
import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.command.CommandSender;
import net.minestom.server.command.ConsoleSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.entity.Player;

public abstract class ServerCommand extends Command {

    public ServerCommand(String name, boolean consoleAllowed, boolean playerAllowed, String permission) {
        super(name);
        setCondition((sender, msg) -> {
            if (sender instanceof ConsoleSender) 
                return consoleAllowed || reportError(sender, "Console is not allowed to use that command!");
            
            if (sender instanceof Player player)
                return (playerAllowed || reportError(sender, "Players are not allowed to use that command.")) &&
                    (Ranks.fromPlayer(player).hasPermission(permission) || reportError(sender, "You do not have the permissions required to use that command."));
            
            return reportError(sender, "Something went wrong.");
        });
        setDefaultExecutor((sender, context) -> executeDefault(sender, context));
    }
    
    public boolean executeDefault(CommandSender sender, CommandContext context) {
        reportError(sender, "Invalid arguments!");
        return true;
    }

    public static final boolean reportError(CommandSender sender, String msg)
    {
        Chat.send(sender, Text.red(msg));
        return false;
    }
}
