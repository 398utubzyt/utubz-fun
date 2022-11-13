package com.utubz.commands;

import com.utubz.ranking.Rank;
import com.utubz.ranking.Ranks;
import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.command.builder.arguments.ArgumentLiteral;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.entity.Player;

public class RankCommand extends ServerCommand {
    private final ArgumentEntity entityArg = new ArgumentEntity("target");

    public RankCommand()
    {
        super("rank", true, true, "rank.staff.admin");

        final Rank[] all = Ranks.getAllRanks();
        for (int i = 0; i < all.length; i++)
        {
            addSyntax((s, c) -> executeSet(s, c), entityArg, new ArgumentLiteral(all[i].getId()));
        }
    }

    public boolean executeSet(CommandSender sender, CommandContext context)
    {
        final Player target = context.get(entityArg).findFirstPlayer(sender);

        if (target == null)
            return reportError(sender, "Invalid target. Must be a valid player.");
        
        final Rank rank = Ranks.fromId(context.getInput().split(" ")[2]);
        rank.apply(target);
        target.refreshCommands();

        Chat.send(sender, Text.combine(Text.green(Text.combine(target.getUsername(), " has been given [")), rank.getDisplayName(), Text.green("] rank!")));
        Chat.send(target, Text.combine(Text.gray("Your rank has been set to ["), rank.getDisplayName(), Text.gray("].")));
        return true;
    }
}
