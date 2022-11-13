package com.utubz.commands;

import java.util.List;

import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.kyori.adventure.text.Component;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.CommandContext;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentComponent;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestom.server.command.builder.arguments.minecraft.ArgumentItemStack;
import net.minestom.server.command.builder.arguments.number.ArgumentInteger;
import net.minestom.server.entity.Player;
import net.minestom.server.item.ItemStack;

public class GiveCommand extends ServerCommand {
    private final ArgumentEntity targetArg = new ArgumentEntity("target");
    private final ArgumentItemStack itemArg = new ArgumentItemStack("item");
    private final ArgumentInteger amountArg = new ArgumentInteger("amount");
    private final ArgumentComponent nameArg = new ArgumentComponent("name");
    private final ArgumentComponent loreArg = new ArgumentComponent("lore");

    public GiveCommand()
    {
        super("give", false, true, "rank.staff.mod");
        addSyntax((s, c) -> executeGive(s, c), targetArg, itemArg);
        addSyntax((s, c) -> executeGive(s, c), targetArg, itemArg, amountArg);
        addSyntax((s, c) -> executeGive(s, c), targetArg, itemArg, amountArg, nameArg);
        addSyntax((s, c) -> executeGive(s, c), targetArg, itemArg, amountArg, nameArg, loreArg);
    }

    private boolean executeGive(CommandSender sender, CommandContext context)
    {
        final Player target = context.get(targetArg).findFirstPlayer(sender);
        if (target == null)
            return reportError(sender, "Invalid target. Must be a valid player.");

        ItemStack item = context.get(itemArg);
        if (item == null)
            return reportError(sender, "Invalid item. Must be valid item id.");

        final int amount = context.get(amountArg);
        if (amount > 0)
            item = item.withAmount(amount);
        
        final Component name = context.get(nameArg);
        if (name != null)
            item = item.withDisplayName(name);

        final Component lore = context.get(loreArg);
        if (name != null)
            item = item.withLore(List.of(lore));

        return target.getInventory().addItemStack(item);
    }
}
