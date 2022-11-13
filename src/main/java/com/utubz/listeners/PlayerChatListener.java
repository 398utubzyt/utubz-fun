package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import com.utubz.ranking.Ranks;
import com.utubz.util.Text;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerChatEvent;

public class PlayerChatListener implements EventListener<PlayerChatEvent> {
    @Override
    public @NotNull Class<PlayerChatEvent> eventType() {
        return PlayerChatEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerChatEvent ev) {
        final Player player = ev.getPlayer();
        final Component rank = Ranks.fromPlayer(player).getDisplayName();
        ev.setChatFormat((event) -> {
            return Text.style(Text.combine(Text.combine("[", rank, "] "), Text.combine(player.getUsername(), ": "), ev.getMessage()), rank.style());
        });

        return Result.SUCCESS;
    }
}
