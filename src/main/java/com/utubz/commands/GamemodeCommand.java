package com.utubz.commands;

import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.command.builder.arguments.number.ArgumentInteger;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.permission.Permission;

public class GamemodeCommand extends ServerCommand {
    public GamemodeCommand()
    {
        super("gamemode", false, true, "rank.staff.mod");
        addSyntax((s, c) -> executeSurvival(s, c), "survival");
        addSyntax((s, c) -> executeCreative(s, c), "creative");
        addSyntax((s, c) -> executeAdventure(s, c), "adventure");
        addSyntax((s, c) -> executeSpectator(s, c), "spectator");
        addSyntax((s, c) -> executeId(s, c), new ArgumentInteger("gamemode"));
    }

    private boolean executeSurvival(CommandSender sender, CommandContext context) {
        final Player player = (Player)sender;
        player.setGameMode(GameMode.SURVIVAL);
        player.addPermission(new Permission("Admin"));
        Chat.log(Text.gray(Text.combine("Set ", player.getUsername(), "'s gamemode to Survival")));
        Chat.send(player, Text.combine("Set gamemode to ", Text.red("Survival"), "!"));
        return true;
    }

    private boolean executeCreative(CommandSender sender, CommandContext context) {
        final Player player = (Player)sender;
        player.setGameMode(GameMode.CREATIVE);

        Chat.log(Text.gray(Text.combine("Set ", player.getUsername(), "'s gamemode to Creative")));
        Chat.send(player, Text.combine("Set gamemode to ", Text.purple("Creative"), "!"));
        return true;
    }

    private boolean executeAdventure(CommandSender sender, CommandContext context) {
        final Player player = (Player)sender;
        player.setGameMode(GameMode.ADVENTURE);

        Chat.log(Text.gray(Text.combine("Set ", player.getUsername(), "'s gamemode to Adventure")));
        Chat.send(player, Text.combine("Set gamemode to ", Text.green("Adventure"), "!"));
        return true;
    }

    private boolean executeSpectator(CommandSender sender, CommandContext context) {
        final Player player = (Player)sender;
        player.setGameMode(GameMode.SPECTATOR);

        Chat.log(Text.gray(Text.combine("Set ", player.getUsername(), "'s gamemode to Spectator")));
        Chat.send(player, Text.combine("Set gamemode to ", Text.gray("Spectator"), "!"));
        return true;
    }

    private boolean executeId(CommandSender sender, CommandContext context) {
        final int gmid = (int)context.get("gamemode");
        if (gmid < 0 || gmid > 3)
            return reportError(sender, "Gamemode ID is out of bounds!");
        switch (gmid)
        {
            case 0:
                return executeSurvival(sender, context);
            case 1:
                return executeCreative(sender, context);
            case 2:
                return executeAdventure(sender, context);
            case 3:
                return executeSpectator(sender, context);
            default:
                return reportError(sender, "Gamemode ID is out of bounds!");
        }
    }
}
