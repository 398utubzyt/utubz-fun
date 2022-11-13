package com.utubz.commands;

import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.CommandContext;

public class StopCommand extends ServerCommand {

    public StopCommand()
    {
        super("stop", true, true, "rank.staff.owner");
    }

    @Override
    public boolean executeDefault(CommandSender sender, CommandContext context)
    {
        Chat.announce(Text.bold(Text.red("SERVER IS CLOSING!")));
        MinecraftServer.stopCleanly();
        return true;
    }
}
